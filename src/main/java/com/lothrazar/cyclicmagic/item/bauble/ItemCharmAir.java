package com.lothrazar.cyclicmagic.item.bauble;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.ModCyclic;
import com.lothrazar.cyclicmagic.item.base.BaseCharm;
import com.lothrazar.cyclicmagic.net.PacketPlayerFalldamage;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCharmAir extends BaseCharm implements IHasRecipe {
  private static final double DOWNWARD_SPEED_SNEAKING = -0.32;
  private static final int TICKS_FALLDIST_SYNC = 22;//tick every so often
  private static final int durability = 4096;
  public ItemCharmAir() {
    super(durability);
  }
  @Override
  public void onTick(ItemStack stack, EntityPlayer player) {
    if (!this.canTick(stack)) { return; }
    World world = player.getEntityWorld();
    BlockPos belowMe = player.getPosition().down();
    boolean isAirBorne = (world.isAirBlock(belowMe) //sneak on air, or a nonsolid block like a flower
        || world.isSideSolid(belowMe, EnumFacing.UP) == false);
    //do not use  player.isAirBorne, its only true on clientside, and that doesnt let us deal charm damage.. among possible other issues
    if (isAirBorne && player.motionY < 0) {//player.isSneaking() &&
      player.motionY = (player.isSneaking()) ? DOWNWARD_SPEED_SNEAKING : 0;
      player.isAirBorne = false;
      //if we set onGround->true all the time, it blocks fwd movement anywya
      player.onGround = true;// (player.motionX == 0 && player.motionZ == 0); //allow jump only if not walking
      if (player.getEntityWorld().rand.nextDouble() < 0.1) {
        super.damageCharm(player, stack);
      }
      if (world.isRemote && //setting fall distance on clientside wont work
          player instanceof EntityPlayer && player.ticksExisted % TICKS_FALLDIST_SYNC == 0) {
        ModCyclic.network.sendToServer(new PacketPlayerFalldamage());
      }
    }
  }

  @Override
  public boolean isHidden() {
    return RecipeRegistry.hiddenItems.contains(this);
  }
}
