package com.lothrazar.cyclicmagic.item.projectile;
import com.lothrazar.cyclicmagic.entity.projectile.EntityThrowableDispensable;
import com.lothrazar.cyclicmagic.item.base.BaseItem;
import com.lothrazar.cyclicmagic.util.UtilPlayer;
import com.lothrazar.cyclicmagic.util.UtilSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BaseItemProjectile extends BaseItem {
  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
    ItemStack h = playerIn.getHeldItem(hand);
    onItemThrow(h, worldIn, playerIn, hand);
    playerIn.swingArm(hand);
    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, h);
  }
  abstract void onItemThrow(ItemStack held, World world, EntityPlayer player, EnumHand hand);
  public abstract EntityThrowableDispensable getThrownEntity(World world, double x, double y, double z);//, double accelX, double accelY, double accelZ
  private static final float VELOCITY_DEFAULT = 1.5F;
  private static final float INACCURACY_DEFAULT = 1.0F;
  private static final float PITCHOFFSET = 0.0F;
  protected void doThrow(World world, EntityPlayer player, EnumHand hand, EntityThrowable thing, float velocity) {
    if (!world.isRemote) {
      // func_184538_a
      //zero pitch offset, meaning match the players existing. 1.0 at end ins inn
      thing.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, PITCHOFFSET, velocity, INACCURACY_DEFAULT);
      world.spawnEntity(thing);
    }
    player.swingArm(hand);
    BlockPos pos = player.getPosition();
    UtilSound.playSound(player, pos, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS);
    UtilPlayer.decrStackSize(player, hand);
  }
  protected void doThrow(World world, EntityPlayer player, EnumHand hand, EntityThrowable thing) {
    this.doThrow(world, player, hand, thing, VELOCITY_DEFAULT);
  }
}
