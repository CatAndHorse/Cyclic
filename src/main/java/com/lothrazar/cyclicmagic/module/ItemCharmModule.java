package com.lothrazar.cyclicmagic.module;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.ModCyclic;
import com.lothrazar.cyclicmagic.data.Const;
import com.lothrazar.cyclicmagic.item.bauble.ItemAutoTorch;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmAir;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmAntidote;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmBoat;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmFire;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmSlowfall;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmSpeed;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmVoid;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmWater;
import com.lothrazar.cyclicmagic.registry.GuideRegistry.GuideCategory;
import com.lothrazar.cyclicmagic.registry.ItemRegistry;
import com.lothrazar.cyclicmagic.registry.LootTableRegistry;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import net.minecraftforge.common.config.Configuration;

public class ItemCharmModule extends BaseModule implements IHasConfig {
  private boolean enableFire;
  private boolean enableSea;
  private boolean enableVoid;
  private boolean enableWater;
  private boolean antidoteCharm;
  private boolean slowfallCharm;
  private boolean autoTorch;
  private boolean enableSpeed;
  private boolean enableAir;
  @Override
  public void onPreInit() {
  }
  @Override
  public void syncConfig(Configuration config) {
    enableAir = config.getBoolean("AirCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableSpeed = config.getBoolean("SpeedCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    slowfallCharm = config.getBoolean("WingCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableFire = config.getBoolean("FireCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableSea = config.getBoolean("SailorCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableVoid = config.getBoolean("VoidCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableWater = config.getBoolean("WaterCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    antidoteCharm = config.getBoolean("AntidoteCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    autoTorch = config.getBoolean("AutomaticTorch", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
  

    RecipeRegistry.toggleVisibility(ItemRegistry.charm_air, enableAir);
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_fire, enableFire);
  

    RecipeRegistry.toggleVisibility(ItemRegistry.charm_boat, enableSea);
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_void, enableVoid);

    RecipeRegistry.toggleVisibility(ItemRegistry.charm_water, enableWater);
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_antidote, antidoteCharm);
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_wing, slowfallCharm);
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_auto_torch, autoTorch);

    RecipeRegistry.toggleVisibility(ItemRegistry.charm_speed, enableSpeed);
    
  }
}
