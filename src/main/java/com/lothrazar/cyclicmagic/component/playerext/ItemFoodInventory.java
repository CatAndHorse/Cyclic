package com.lothrazar.cyclicmagic.component.playerext;
import java.util.List;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.data.Const;
import com.lothrazar.cyclicmagic.registry.CapabilityRegistry;
import com.lothrazar.cyclicmagic.registry.CapabilityRegistry.IPlayerExtendedProperties;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import com.lothrazar.cyclicmagic.registry.SoundRegistry;
import com.lothrazar.cyclicmagic.util.UtilChat;
import com.lothrazar.cyclicmagic.util.UtilParticle;
import com.lothrazar.cyclicmagic.util.UtilSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodInventory extends ItemFood implements IHasRecipe, IHasConfig {
  private static final int numFood = 10;
  public ItemFoodInventory() {
    super(numFood, false);
    this.setAlwaysEdible();
  }
  @Override
  protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
    final IPlayerExtendedProperties data = CapabilityRegistry.getPlayerProperties(player);
    if (data.hasInventoryExtended()) {
      UtilSound.playSound(player, SoundRegistry.buzzp);
      return;
    }
    data.setInventoryExtended(true);
    UtilParticle.spawnParticle(world, EnumParticleTypes.CRIT_MAGIC, player.getPosition());
    UtilParticle.spawnParticle(world, EnumParticleTypes.CRIT_MAGIC, player.getPosition().up());
    UtilSound.playSound(player, SoundRegistry.bwewe);
    if (player.getEntityWorld().isRemote) {
      UtilChat.addChatMessage(player, "unlocks.extended");
    }
  }

  @Override
  public boolean isHidden() {
    return RecipeRegistry.hiddenBlocks.contains(this);
  }
  @Override
  @SideOnly(Side.CLIENT)
  public void addInformation(ItemStack stack, World playerIn, List<String> tooltips, net.minecraft.client.util.ITooltipFlag advanced) {
    tooltips.add(UtilChat.lang(this.getUnlocalizedName() + ".tooltip"));
  }
  @Override
  public void syncConfig(Configuration config) {
    String category = Const.ConfigCategory.inventory;
    EventExtendedInventory.keepOnDeath = config.getBoolean("InventoryUpgradeKeepOnDeath", category, true, "If true, you always keep these extended storage items on death (similar to an ender chest).  If false, you will drop these items on death (depending on the keepInventory game rule)");
  }
}
