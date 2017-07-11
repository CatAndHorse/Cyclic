package com.lothrazar.cyclicmagic.registry;
import java.util.ArrayList;
import java.util.List;
import com.lothrazar.cyclicmagic.IHasConfig; 
import com.lothrazar.cyclicmagic.module.BlockConfigModule;
import com.lothrazar.cyclicmagic.module.CommandModule;
import com.lothrazar.cyclicmagic.module.DispenserBehaviorModule;
import com.lothrazar.cyclicmagic.module.EnchantModule;
import com.lothrazar.cyclicmagic.module.EntityMinecartModule;
import com.lothrazar.cyclicmagic.module.EnvironmentTweaksModule;
import com.lothrazar.cyclicmagic.module.FragileTorchesModule;
import com.lothrazar.cyclicmagic.module.FuelAdditionModule;
import com.lothrazar.cyclicmagic.module.GearEmeraldModule;
import com.lothrazar.cyclicmagic.module.GearPurpleModule;
import com.lothrazar.cyclicmagic.module.GearSandstoneModule;
import com.lothrazar.cyclicmagic.module.GuiTerrariaButtonsModule;
import com.lothrazar.cyclicmagic.module.ICyclicModule; 
import com.lothrazar.cyclicmagic.module.ItemConsumeablesModule;
import com.lothrazar.cyclicmagic.module.ItemPotionModule; 
import com.lothrazar.cyclicmagic.module.ItemToolsModule;
import com.lothrazar.cyclicmagic.module.KeyInventoryShiftModule;
import com.lothrazar.cyclicmagic.module.LootTableModule;
import com.lothrazar.cyclicmagic.module.MobDropChangesModule;
import com.lothrazar.cyclicmagic.module.MountedTweaksModule; 
import com.lothrazar.cyclicmagic.module.PlayerAbilitiesModule;
import com.lothrazar.cyclicmagic.module.RecipeChangerModule;
import com.lothrazar.cyclicmagic.module.StackSizeModule;
import com.lothrazar.cyclicmagic.module.TextInfoModule;
import com.lothrazar.cyclicmagic.module.VillagerCreateModule;
import com.lothrazar.cyclicmagic.module.WorldGenModule;

public class ModuleRegistry {
  public static List<ICyclicModule> modules = new ArrayList<ICyclicModule>();
  public static void init() {
    modules = new ArrayList<ICyclicModule>();
  }
  public static void register(ICyclicModule m) {
    modules.add(m);
    if (m instanceof IHasConfig) {
      ConfigRegistry.register((IHasConfig) m);
    }
  }
  public static void registerAll() {
    // :) http://alphabetizer.flap.tv/ 
    register(new BlockConfigModule());
    register(new CommandModule());
    register(new ItemConsumeablesModule());
  
    register(new ItemPotionModule());
    register(new DispenserBehaviorModule());
    register(new GearEmeraldModule());
    register(new EnchantModule());
    register(new PlayerAbilitiesModule());
    register(new TextInfoModule());
    register(new FragileTorchesModule());
    register(new FuelAdditionModule());
    register(new GuiTerrariaButtonsModule());
    register(new KeyInventoryShiftModule());
    register(new LootTableModule()); 
    register(new MobDropChangesModule());
    register(new MountedTweaksModule()); 
    register(new RecipeChangerModule());
    register(new GearSandstoneModule());
    register(new EnvironmentTweaksModule());
    register(new StackSizeModule());
    register(new ItemToolsModule());
    register(new VillagerCreateModule());
    register(new WorldGenModule());
    register(new GearPurpleModule());
    register(new EntityMinecartModule());
  }
}
