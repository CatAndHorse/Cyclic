package com.lothrazar.cyclicmagic.component.builder;
import java.util.ArrayList;
import java.util.List;
import com.lothrazar.cyclicmagic.ITilePreviewToggle;
import com.lothrazar.cyclicmagic.ITileRedstoneToggle;
import com.lothrazar.cyclicmagic.ITileSizeToggle;
import com.lothrazar.cyclicmagic.block.tileentity.TileEntityBaseMachineInvo;
import com.lothrazar.cyclicmagic.util.UtilItemStack;
import com.lothrazar.cyclicmagic.util.UtilPlaceBlocks;
import com.lothrazar.cyclicmagic.util.UtilShape;
import com.lothrazar.cyclicmagic.util.UtilSound;
import com.lothrazar.cyclicmagic.util.UtilWorld;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;

public class TileEntityStructureBuilder extends TileEntityBaseMachineInvo implements ITileRedstoneToggle, ITileSizeToggle, ITilePreviewToggle, ITickable {
  private static final int spotsSkippablePerTrigger = 50;
  public static final int TIMER_FULL = 100;// 100;//one day i will add fuel AND/OR speed upgrades. till then make very slow
  private static final int[] hopperInput = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };// all slots
  private static final String NBT_BUILDTYPE = "build";
  private static final String NBT_SHAPEINDEX = "shapeindex";
  private int buildType;
  private int buildSize = 3;
  private int buildHeight = 3;
  private int needsRedstone = 1;
  private int shapeIndex = 0;// current index of shape array
  private int renderParticles = 1;
  public static int maxSize;
  public static int maxHeight = 10;
  public static enum Fields {
    TIMER, BUILDTYPE, SPEED, SIZE, HEIGHT, REDSTONE, RENDERPARTICLES, FUEL, FUELMAX;
  }
  public enum BuildType {
    FACING, SQUARE, CIRCLE, SOLID, STAIRWAY, SPHERE;
    public static BuildType getNextType(BuildType btype) {
      int type = btype.ordinal();
      type++;
      if (type > SPHERE.ordinal()) {
        type = FACING.ordinal();
      }
      return BuildType.values()[type];
    }
    public boolean hasHeight() {
      if (this == STAIRWAY || this == SPHERE)
        return false;
      return true;
    }
  }
  public TileEntityStructureBuilder() {
    super(10);
    this.setFuelSlot(9);
  }
  @Override
  public int[] getFieldOrdinals() {
    return super.getFieldArray(Fields.values().length);
  }
  @Override
  public List<BlockPos> getShape() {
    BuildType buildType = getBuildTypeEnum();
    List<BlockPos> shape = new ArrayList<BlockPos>();
    // only rebuild shapes if they are different
    switch (buildType) {
      case CIRCLE:
        shape = UtilShape.circleHorizontal(this.getPos(), this.getSize() * 2);
      break;
      case FACING:
        shape = UtilShape.line(this.getPos(), this.getCurrentFacing(), this.getSize());
      break;
      case SQUARE:
        shape = UtilShape.squareHorizontalHollow(this.getPos(), this.getSize());
      break;
      case SOLID:
        shape = UtilShape.squareHorizontalFull(this.getTargetCenter(), this.getSize());
      break;
      case STAIRWAY:
        shape = UtilShape.stairway(this.getPos(), this.getCurrentFacing(), this.getSize() * 2, true);
      break;
      case SPHERE:
        shape = UtilShape.sphere(this.getPos(), this.getSize());
      break;
    }
    if (buildType.hasHeight() && this.buildHeight > 1) { //first layer is already done, add remaining
      shape = UtilShape.repeatShapeByHeight(shape, buildHeight - 1);
    }
    return shape;
  }
  public BlockPos getTargetCenter() {
    //move center over that much, not including exact horizontal
    return this.getPos().offset(this.getCurrentFacing(), this.getSize() + 1);
  }
  @Override
  public boolean isItemValidForSlot(int index, ItemStack stack) {
    return Block.getBlockFromItem(stack.getItem()) != null;
  }
  @Override
  public int getField(int id) {
    if (id >= 0 && id < this.getFieldCount()) {
      switch (Fields.values()[id]) {
        case TIMER:
          return timer;
        case BUILDTYPE:
          return this.buildType;
        case SPEED:
          return this.speed;
        case SIZE:
          return this.buildSize;
        case HEIGHT:
          return this.buildHeight;
        case REDSTONE:
          return this.needsRedstone;
        case RENDERPARTICLES:
          return this.renderParticles;
        case FUEL:
          return this.getFuelCurrent();
        case FUELMAX:
          return this.getFuelMax();
      }
    }
    return -1;
  }
  @Override
  public void setField(int id, int value) {
    if (id >= 0 && id < this.getFieldCount()) {
      switch (Fields.values()[id]) {
        case TIMER:
          this.timer = value;
        break;
        case BUILDTYPE:
          this.buildType = value;
        break;
        case SPEED:
          this.speed = value;
        break;
        case SIZE:
          this.buildSize = value;
        break;
        case HEIGHT:
          if (value > maxHeight) {
            value = maxHeight;
          }
          this.buildHeight = value;
        break;
        case REDSTONE:
          this.needsRedstone = value;
        break;
        case RENDERPARTICLES:
          this.renderParticles = value;
        break;
        case FUEL:
          this.setFuelCurrent(value);
        break;
        case FUELMAX:
          this.setFuelMax(value);
        break;
      }
    }
  }
  public boolean onlyRunIfPowered() {
    return this.needsRedstone == 1;
  }
  public int getTimer() {
    return this.getField(Fields.TIMER.ordinal());
  }
  public int getHeight() {
    return this.getField(Fields.HEIGHT.ordinal());
  }
  public void setHeight(int value) {
    this.setField(Fields.HEIGHT.ordinal(), value);
  }
  public int getBuildType() {
    return this.getField(Fields.BUILDTYPE.ordinal());
  }
  public void setBuildType(int value) {
    this.setField(Fields.BUILDTYPE.ordinal(), value);
  }
  public BuildType getBuildTypeEnum() {
    int bt = Math.min(this.getBuildType(), BuildType.values().length - 1);
    return BuildType.values()[bt];
  }
  public void setSize(int s) {
    if (s <= 0) {
      s = 1;
    }
    if (s >= maxSize) {
      s = maxSize;
    }
    this.setField(Fields.SIZE.ordinal(), s);
  }
  public int getSize() {
    int s = this.getField(Fields.SIZE.ordinal());
    if (s <= 0) {
      s = 1;
    }
    return s;
  }
  @Override
  public int getFieldCount() {
    return Fields.values().length;
  }
  @Override
  public void readFromNBT(NBTTagCompound tagCompound) {
    super.readFromNBT(tagCompound);
    this.needsRedstone = tagCompound.getInteger(NBT_REDST);
    timer = tagCompound.getInteger(NBT_TIMER);
    shapeIndex = tagCompound.getInteger(NBT_SHAPEINDEX);
    this.buildType = tagCompound.getInteger(NBT_BUILDTYPE);
    this.buildSize = tagCompound.getInteger(NBT_SIZE);
    this.renderParticles = tagCompound.getInteger(NBT_RENDER);
  }
  @Override
  public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
    tagCompound.setInteger(NBT_TIMER, timer);
    tagCompound.setInteger(NBT_REDST, this.needsRedstone);
    tagCompound.setInteger(NBT_SHAPEINDEX, this.shapeIndex);
    tagCompound.setInteger(NBT_BUILDTYPE, this.getBuildType());
    tagCompound.setInteger(NBT_SIZE, this.getSize());
    tagCompound.setInteger(NBT_RENDER, renderParticles);
    return super.writeToNBT(tagCompound);
  }
  @Override
  public void update() {
    if (!isRunning()) { return; }
    this.shiftAllUp(1);
    this.updateFuelIsBurning();
    if (this.updateTimerIsZero()) {
      timer = TIMER_FULL;
      this.spawnParticlesAbove();
      ItemStack stack = getStackInSlot(0);
      if (stack.isEmpty()) { return; }
      Block stuff = Block.getBlockFromItem(stack.getItem());
      if (stuff != null) {
        List<BlockPos> shape = this.getShape();
        if (shape.size() == 0) { return; }
        if (this.shapeIndex < 0 || this.shapeIndex >= shape.size()) {
          this.shapeIndex = 0;
        }
        BlockPos nextPos = shape.get(this.shapeIndex);//start at current position and validate
        for (int i = 0; i < spotsSkippablePerTrigger; i++) {
          //true means bounding box is null in the check. entit falling sand uses true
          if (world.isAirBlock(nextPos) &&
              stuff.canPlaceBlockAt(world, nextPos) &&
              world.mayPlace(stuff, nextPos, true, EnumFacing.UP, null)) { // check if this spot is even valid
            IBlockState placeState = UtilItemStack.getStateFromMeta(stuff, stack.getMetadata());
            if (world.isRemote == false && world.isAirBlock(nextPos) && UtilPlaceBlocks.placeStateSafe(world, null, nextPos, placeState)) {
              this.decrStackSize(0, 1);
              SoundType type = UtilSound.getSoundFromBlockstate(placeState, world, nextPos);
              if (type != null && type.getPlaceSound() != null) {
                int dim = UtilWorld.getDimension(this.world);
                int range = 18;
                UtilSound.playSoundFromServer(type.getPlaceSound(), SoundCategory.BLOCKS, nextPos, dim, range);
              }
            }
            break;//ok , target position is valid, we can build only into air
          }
          else {//cant build here. move up one
            nextPos = shape.get(this.shapeIndex);
            this.incrementPosition(shape);
          } //but after inrementing once, we may not yet be valid so skip at most ten spots per tick
        }
      }
    }
  }
  private void incrementPosition(List<BlockPos> shape) {
    if (shape == null || shape.size() == 0) {
      return;
    }
    else {
      int c = shapeIndex + 1;
      if (c < 0 || c >= shape.size()) {
        c = 0;
      }
      shapeIndex = c;
    }
    //    this.markDirty();
  }
  @Override
  public int[] getSlotsForFace(EnumFacing side) {
    return hopperInput;
  }
  @Override
  public void toggleNeedsRedstone() {
    int val = (this.needsRedstone + 1) % 2;
    this.setField(Fields.REDSTONE.ordinal(), val);
  }
  @Override
  public void toggleSizeShape() {
    TileEntityStructureBuilder.BuildType old = this.getBuildTypeEnum();
    TileEntityStructureBuilder.BuildType next = TileEntityStructureBuilder.BuildType.getNextType(old);
    this.setBuildType(next.ordinal());
  }
  @Override
  public void togglePreview() {
    int val = (this.renderParticles + 1) % 2;
    this.setField(Fields.RENDERPARTICLES.ordinal(), val);
  }
  @Override
  public boolean isPreviewVisible() {
    return this.getField(Fields.RENDERPARTICLES.ordinal()) == 1;
  }
}
