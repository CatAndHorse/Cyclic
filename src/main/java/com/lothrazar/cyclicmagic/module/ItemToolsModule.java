package com.lothrazar.cyclicmagic.module;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.data.Const;
import com.lothrazar.cyclicmagic.dispenser.BehaviorProjectileThrowable;
import com.lothrazar.cyclicmagic.item.ItemBuildSwapper;
import com.lothrazar.cyclicmagic.item.ItemHorseUpgrade;
import com.lothrazar.cyclicmagic.item.projectile.BaseItemProjectile;
import com.lothrazar.cyclicmagic.registry.ItemRegistry;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import net.minecraft.block.BlockDispenser;
import net.minecraftforge.common.config.Configuration;

public class ItemToolsModule extends BaseEventModule implements IHasConfig {
  
  @Override
  public void syncConfig(Configuration config) {
    RecipeRegistry.toggleVisibility(ItemRegistry.magic_net,
        config.getBoolean("MonsterBall", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.dynamite_safe,
        config.getBoolean("DynamiteSafe", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.dynamite_mining,
        config.getBoolean("DynamiteMining", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_blaze,
        config.getBoolean("EnderBlaze", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_dungeon,
        config.getBoolean("EnderDungeonFinder", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_fishing,
        config.getBoolean("EnderFishing", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_snow,
        config.getBoolean("EnderSnow", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_wool,
        config.getBoolean("EnderWool", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_torch,
        config.getBoolean("EnderTorch", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_lightning,
        config.getBoolean("EnderLightning", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_water,
        config.getBoolean("EnderWater", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    boolean enderBombsEnabled = config.getBoolean("EnderBombs", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_tnt_1, enderBombsEnabled);
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_tnt_2, enderBombsEnabled);
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_tnt_3, enderBombsEnabled);
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_tnt_4, enderBombsEnabled);
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_tnt_5, enderBombsEnabled);
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_tnt_6, enderBombsEnabled);
    RecipeRegistry.toggleVisibility(ItemRegistry.apple_lapis,
        config.getBoolean("LapisApple", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.glowing_chorus,
        config.getBoolean("GlowingChorus(Food)", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.apple_emerald,
        config.getBoolean("EmeraldApple", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.heart_food,
        config.getBoolean("HeartContainer(food)", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.crafting_food,
        config.getBoolean("InventoryCrafting(Food)", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.inventory_food,
        config.getBoolean("InventoryUpgrade(Food)", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.corrupted_chorus,
        config.getBoolean("CorruptedChorus(Food)", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    boolean enableHorseFoodUpgrades = config.getBoolean("HorseFood", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    RecipeRegistry.toggleVisibility(ItemRegistry.diamond_carrot, enableHorseFoodUpgrades);
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_carrot, enableHorseFoodUpgrades);
    RecipeRegistry.toggleVisibility(ItemRegistry.emerald_carrot, enableHorseFoodUpgrades);
    RecipeRegistry.toggleVisibility(ItemRegistry.lapis_carrot, enableHorseFoodUpgrades);
    RecipeRegistry.toggleVisibility(ItemRegistry.redstone_carrot, enableHorseFoodUpgrades);
    String category = Const.ConfigCategory.modpackMisc;
    ItemHorseUpgrade.HEARTS_MAX = config.getInt("HorseFood Max Hearts", category, 20, 1, 100, "Maximum number of upgraded hearts");
    ItemHorseUpgrade.JUMP_MAX = config.getInt("HorseFood Max Jump", category, 6, 1, 20, "Maximum value of jump.  Naturally spawned/bred horses seem to max out at 5.5");
    ItemHorseUpgrade.SPEED_MAX = config.getInt("HorseFood Max Speed", category, 50, 1, 99, "Maximum value of speed (this is NOT blocks/per second or anything like that)");
    RecipeRegistry.toggleVisibility(ItemRegistry.evoker_fangs,
        config.getBoolean("EvokerFang", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_launcher,
        config.getBoolean("PlayerLauncher", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.soulstone,
        config.getBoolean("Soulstone", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_trade,
        config.getBoolean("Merchant Almanac", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.password_remote,
        config.getBoolean("Remote Lever", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_elevate,
        config.getBoolean("RodElevation", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.glove_climb,
        config.getBoolean("ClimbingGlove", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_rotate,
        config.getBoolean("BlockRotator", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.water_spreader,
        config.getBoolean("WaterSpreader", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.water_freezer,
        config.getBoolean("WaterFroster", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.fire_killer,
        config.getBoolean("FireKiller", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.sack_ender,
        config.getBoolean("EnderSack", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_torch_launcher,
        config.getBoolean("TorchLauncher", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.storage_bag,
        config.getBoolean("StorageBag", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.book_ender,
        config.getBoolean("EnderBook", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_warp_home,
        config.getBoolean("EnderWingPrime", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_warp_spawn,
        config.getBoolean("EnderWing", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_spawn_inspect,
        config.getBoolean("SpawnDetector", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_pearl_reuse,
        config.getBoolean("EnderOrb", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_harvest_weeds,
        config.getBoolean("BrushScythe", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_harvest_crops,
        config.getBoolean("HarvestScythe", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_harvest_leaves,
        config.getBoolean("TreeScythe", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_push,
        config.getBoolean("PistonScepter", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.sleeping_mat,
        config.getBoolean("SleepingMat", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.cyclic_wand_build,
        config.getBoolean("CyclicWand", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_prospector,
        config.getBoolean("Prospector", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_spelunker,
        config.getBoolean("Cavefinder", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_swap,
        config.getBoolean("ExchangeScepters", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_randomize,
        config.getBoolean("BlockRandomizer", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.ender_pearl_mounted,
        config.getBoolean("EnderOrbMounted", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.carbon_paper,
        config.getBoolean("CarbonPaper", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.chest_sack_empty,
        config.getBoolean("ChestSack", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_mount,
        config.getBoolean("Stirrups", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_air,
        config.getBoolean("AirCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_speed,
        config.getBoolean("SpeedCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_wing,
        config.getBoolean("WingCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_fire,
        config.getBoolean("FireCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_boat,
        config.getBoolean("SailorCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_void,
        config.getBoolean("VoidCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_water,
        config.getBoolean("WaterCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.charm_antidote,
        config.getBoolean("AntidoteCharm", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.tool_auto_torch,
        config.getBoolean("AutomaticTorch", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    String[] deflist = new String[] { "minecraft:mob_spawner", "minecraft:obsidian" };
    ItemBuildSwapper.swapBlacklist = config.getStringList("ExchangeSceptersBlacklist", Const.ConfigCategory.items, deflist, "Blocks that will not be broken by the exchange scepters.  It will also not break anything that is unbreakable (such as bedrock), regardless of if its in this list or not.  ");
    //
    //    RecipeRegistry.toggleVisibility(ItemRegistry.charm_air, enableAir);
    //    RecipeRegistry.toggleVisibility(ItemRegistry.charm_fire, enableFire);
    //  
    //
    //    RecipeRegistry.toggleVisibility(ItemRegistry.charm_boat, enableSea);
    //    RecipeRegistry.toggleVisibility(ItemRegistry.charm_void, enableVoid);
    //
    //    RecipeRegistry.toggleVisibility(ItemRegistry.charm_water, enableWater);
    //    RecipeRegistry.toggleVisibility(ItemRegistry.charm_antidote, antidoteCharm);
    //    RecipeRegistry.toggleVisibility(ItemRegistry.charm_wing, slowfallCharm);
    //    RecipeRegistry.toggleVisibility(ItemRegistry.tool_auto_torch, autoTorch);
    //
    //    RecipeRegistry.toggleVisibility(ItemRegistry.charm_speed, enableSpeed);
  }
}
