package com.lothrazar.cyclicmagic.item.bauble;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.item.base.BaseCharm;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ItemCharmBoat extends BaseCharm implements IHasRecipe {
  private static final int durability = 4096;
  public ItemCharmBoat() {
    super(durability);
  }
  /**
   * Called each tick as long the item is on a player inventory. Uses by maps to
   * check if is on a player hand and update it's contents.
   */
  public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    if (entityIn instanceof EntityPlayer) {
      onTick(stack, (EntityPlayer) entityIn);
    }
  }
  @Override
  public void onTick(ItemStack stack, EntityPlayer entityIn) {
    if (!this.canTick(stack)) { return; }
    if (entityIn.getRidingEntity() instanceof EntityBoat) {
      EntityBoat boat = (EntityBoat) entityIn.getRidingEntity();
      if (entityIn.moveForward > 0) {
        float reduce = 0.08F;
        //pulled from private EntityBoat.controlBoat() fn
        boat.motionX += net.minecraft.util.math.MathHelper.sin(-boat.rotationYaw * 0.017453292F) * reduce;
        boat.motionZ += net.minecraft.util.math.MathHelper.cos(boat.rotationYaw * 0.017453292F) * reduce;
        if (entityIn.getEntityWorld().rand.nextDouble() < 0.1) {
          super.damageCharm(entityIn, stack);
        }
      }
    }
  }

  @Override
  public boolean isHidden() {
    return RecipeRegistry.hiddenItems.contains(this);
  }
}
