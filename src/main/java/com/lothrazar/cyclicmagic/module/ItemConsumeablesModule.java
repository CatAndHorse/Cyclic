package com.lothrazar.cyclicmagic.module;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.ModCyclic;
import com.lothrazar.cyclicmagic.component.playerext.ItemFoodCrafting;
import com.lothrazar.cyclicmagic.component.playerext.ItemFoodInventory;
import com.lothrazar.cyclicmagic.data.Const;
import com.lothrazar.cyclicmagic.dispenser.BehaviorProjectileThrowable;
import com.lothrazar.cyclicmagic.item.ItemAppleEmerald;
import com.lothrazar.cyclicmagic.item.ItemAppleLapis;
import com.lothrazar.cyclicmagic.item.ItemChorusCorrupted;
import com.lothrazar.cyclicmagic.item.ItemChorusGlowing;
import com.lothrazar.cyclicmagic.item.ItemHeartContainer;
import com.lothrazar.cyclicmagic.item.ItemHorseUpgrade;
import com.lothrazar.cyclicmagic.item.ItemHorseUpgrade.HorseUpgradeType;
import com.lothrazar.cyclicmagic.item.projectile.BaseItemProjectile;
import com.lothrazar.cyclicmagic.registry.ItemRegistry;
import com.lothrazar.cyclicmagic.registry.LootTableRegistry;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import com.lothrazar.cyclicmagic.registry.LootTableRegistry.ChestType;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemConsumeablesModule extends BaseEventModule  {
  @Override
  public void onPreInit() {
    ModCyclic.instance.events.register(this);//for SubcribeEvent hooks 
  }
  

  @SubscribeEvent
  public void onEntityInteractEvent(EntityInteract event) {
    if (event.getEntity() instanceof EntityPlayer == false) { return; }
    EntityPlayer entityPlayer = (EntityPlayer) event.getEntity();
    ItemStack held = entityPlayer.getHeldItemMainhand();
    if (held != null && held.getItem() instanceof ItemHorseUpgrade && held.getCount() > 0
        && event.getTarget() instanceof AbstractHorse) {
      ItemHorseUpgrade.onHorseInteract((AbstractHorse) event.getTarget(), entityPlayer, held, (ItemHorseUpgrade) held.getItem());
      event.setCanceled(true);// stop the GUI inventory opening && horse mounting
    }
  }
 
}
