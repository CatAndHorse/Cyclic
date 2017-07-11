package com.lothrazar.cyclicmagic.module;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.ModCyclic;
import com.lothrazar.cyclicmagic.block.BlockConveyor;
import com.lothrazar.cyclicmagic.block.BlockScaffolding;
import com.lothrazar.cyclicmagic.block.BlockScaffoldingReplace;
import com.lothrazar.cyclicmagic.block.BlockScaffoldingResponsive;
import com.lothrazar.cyclicmagic.block.BlockShears;
import com.lothrazar.cyclicmagic.block.BlockSoundSuppress;
import com.lothrazar.cyclicmagic.block.ItemBlockScaffolding;
import com.lothrazar.cyclicmagic.component.autouser.BlockUser;
import com.lothrazar.cyclicmagic.component.autouser.TileEntityUser;
import com.lothrazar.cyclicmagic.component.bucketstorage.BlockBucketStorage;
import com.lothrazar.cyclicmagic.component.bucketstorage.ItemBlockBucket;
import com.lothrazar.cyclicmagic.component.bucketstorage.TileEntityBucketStorage;
import com.lothrazar.cyclicmagic.component.builder.BlockStructureBuilder;
import com.lothrazar.cyclicmagic.component.builder.TileEntityStructureBuilder;
import com.lothrazar.cyclicmagic.component.controlledminer.BlockMinerSmart;
import com.lothrazar.cyclicmagic.component.controlledminer.TileEntityControlledMiner;
import com.lothrazar.cyclicmagic.component.crafter.BlockCrafter;
import com.lothrazar.cyclicmagic.component.crafter.TileEntityCrafter;
import com.lothrazar.cyclicmagic.component.disenchanter.BlockDisenchanter;
import com.lothrazar.cyclicmagic.component.disenchanter.TileEntityDisenchanter;
import com.lothrazar.cyclicmagic.component.entitydetector.BlockDetector;
import com.lothrazar.cyclicmagic.component.entitydetector.TileEntityDetector;
import com.lothrazar.cyclicmagic.component.fan.BlockFan;
import com.lothrazar.cyclicmagic.component.fan.TileEntityFan;
import com.lothrazar.cyclicmagic.component.fisher.BlockFishing;
import com.lothrazar.cyclicmagic.component.fisher.TileEntityFishing;
import com.lothrazar.cyclicmagic.component.harvester.BlockHarvester;
import com.lothrazar.cyclicmagic.component.harvester.TileEntityHarvester;
import com.lothrazar.cyclicmagic.component.magnet.TileEntityMagnet;
import com.lothrazar.cyclicmagic.component.magnetanti.TileEntityMagnetAnti;
import com.lothrazar.cyclicmagic.component.miner.BlockMiner;
import com.lothrazar.cyclicmagic.component.miner.TileEntityBlockMiner;
import com.lothrazar.cyclicmagic.component.password.BlockPassword;
import com.lothrazar.cyclicmagic.component.password.TileEntityPassword;
import com.lothrazar.cyclicmagic.component.pattern.BlockPatternBuilder;
import com.lothrazar.cyclicmagic.component.pattern.TileEntityPatternBuilder;
import com.lothrazar.cyclicmagic.component.placer.BlockPlacer;
import com.lothrazar.cyclicmagic.component.placer.TileEntityPlacer;
import com.lothrazar.cyclicmagic.component.pylonexp.BlockXpPylon;
import com.lothrazar.cyclicmagic.component.pylonexp.TileEntityXpPylon;
import com.lothrazar.cyclicmagic.component.uncrafter.BlockUncrafting;
import com.lothrazar.cyclicmagic.component.uncrafter.TileEntityUncrafter;
import com.lothrazar.cyclicmagic.component.vector.ItemBlockVectorPlate;
import com.lothrazar.cyclicmagic.component.vector.TileEntityVector;
import com.lothrazar.cyclicmagic.component.workbench.BlockWorkbench;
import com.lothrazar.cyclicmagic.component.workbench.TileEntityWorkbench;
import com.lothrazar.cyclicmagic.data.Const;
import com.lothrazar.cyclicmagic.item.ItemBuildSwapper;
import com.lothrazar.cyclicmagic.item.ItemHorseUpgrade;
import com.lothrazar.cyclicmagic.registry.BlockRegistry;
import com.lothrazar.cyclicmagic.registry.GuideRegistry;
import com.lothrazar.cyclicmagic.registry.ItemRegistry;
import com.lothrazar.cyclicmagic.registry.GuideRegistry.GuideCategory;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ConfigModule extends BaseModule implements IHasConfig {
  public void onPreInit() {}
  @Override
  public void syncConfig(Configuration config) {
    
    


    RecipeRegistry.toggleVisibility(ItemRegistry.stone_minecart,
        config.getBoolean("StoneMinecart", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.turret_minecart,
        config.getBoolean("GoldTurretMinecart", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.dropper_minecart,
        config.getBoolean("GoldDropperMinecart", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
    RecipeRegistry.toggleVisibility(ItemRegistry.gold_minecart,
        config.getBoolean("GoldMinecart", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText));
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
  
    
    
    
    
    //TOOD: fix this mess
    boolean fragileEnabled;
    boolean fishingBlock;
    boolean enableBucketBlocks;
    boolean enableShearingBlock;
    boolean enableFan;
    boolean entityDetector;
    boolean disenchanter;
    boolean autoCrafter;
    boolean soundproofing;
    boolean workbench;
    boolean enableConveyor;
    boolean launchPads;
    boolean enableMagnet;
    boolean enableInterdict;
    boolean vectorPlate;
    boolean enableUncrafter;
    boolean enableBuilderBlock;
    boolean enableHarvester;
    boolean enableMiner;
    boolean enablePlacer;
    boolean enablePassword;
    boolean enableMinerSmart;
    boolean enableUser;
    boolean enablePattern;
    boolean expPylon;
      category = Const.ConfigCategory.content;
    workbench = config.getBoolean("Workbench", category, true, Const.ConfigCategory.contentDefaultText);
    soundproofing = config.getBoolean("Soundproofing", category, true, Const.ConfigCategory.contentDefaultText);
    autoCrafter = config.getBoolean("AutoCrafter", category, true, Const.ConfigCategory.contentDefaultText);
    disenchanter = config.getBoolean("UnchantPylon", category, true, Const.ConfigCategory.contentDefaultText);
    entityDetector = config.getBoolean("EntityDetector", category, true, Const.ConfigCategory.contentDefaultText);
    enableFan = config.getBoolean("Fan", category, true, Const.ConfigCategory.contentDefaultText);
    enableShearingBlock = config.getBoolean("ShearingBlock", category, true, Const.ConfigCategory.contentDefaultText);
    enableBucketBlocks = config.getBoolean("BucketBlocks", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    fragileEnabled = config.getBoolean("ScaffoldingBlock", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    fishingBlock = config.getBoolean("FishingBlock", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    vectorPlate = config.getBoolean("AerialFaithPlate", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableInterdict = config.getBoolean("InterdictionPlate", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableConveyor = config.getBoolean("SlimeConveyor", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableMagnet = config.getBoolean("MagnetBlock", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    launchPads = config.getBoolean("SlimePads", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    BlockConveyor.keepEntityGrounded = config.getBoolean("SlimeConveyorKeepEntityGrounded", Const.ConfigCategory.blocks, true, "If true, the Slime Conveyor will keep entities grounded so they dont get sudden bursts of speed when falling down a block onto a conveyor on a lower level");
    BlockConveyor.doCorrections = config.getBoolean("SlimeConveyorPullCenter", Const.ConfigCategory.blocks, true, "If true, the Slime Conveyor will auto-correct entities towards the center while they are moving (keeping them away from the edge)");
    expPylon = config.getBoolean("ExperiencePylon", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enablePattern = config.getBoolean("PatternReplicator", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableUser = config.getBoolean("AutomatedUser", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enablePassword = config.getBoolean("PasswordTrigger", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enablePlacer = config.getBoolean("BlockPlacer", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableMiner = config.getBoolean("MinerBlock", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    //   enableMinerEnhanced = config.getBoolean("MinerBlockAdvanced", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText + ".  This is the one that mines a 3x3x3 area");
    enableBuilderBlock = config.getBoolean("BuilderBlock", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    TileEntityStructureBuilder.maxSize = config.getInt("builder.maxRange", Const.ConfigCategory.modpackMisc, 64, 3, 64, "Maximum range of the builder block that you can increase it to in the GUI");
    TileEntityStructureBuilder.maxHeight = config.getInt("builder.maxHeight", Const.ConfigCategory.modpackMisc, 64, 3, 64, "Maximum height of the builder block that you can increase it to in the GUI");
    enableHarvester = config.getBoolean("HarvesterBlock", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableUncrafter = config.getBoolean("UncraftingGrinder", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    enableMinerSmart = config.getBoolean("ControlledMiner", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    TileEntityControlledMiner.maxHeight = config.getInt("ControlledMiner.maxHeight", Const.ConfigCategory.modpackMisc, 32, 3, 128, "Maximum height of the controlled miner block that you can increase it to in the GUI");
    RecipeRegistry.toggleVisibility(BlockRegistry.auto_crafter, autoCrafter);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_soundproofing, soundproofing);
    RecipeRegistry.toggleVisibility(BlockRegistry.workbench, workbench);
    RecipeRegistry.toggleVisibility(BlockRegistry.detector, entityDetector);
    RecipeRegistry.toggleVisibility(BlockRegistry.fan, enableFan);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_shears, enableShearingBlock);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_fragile, fragileEnabled);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_fragile_auto, fragileEnabled);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_fragile_weak, fragileEnabled);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_disenchanter, disenchanter);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_fishing, fishingBlock);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_storewater, enableBucketBlocks);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_storemilk, enableBucketBlocks);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_storelava, enableBucketBlocks);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_storeempty, enableBucketBlocks);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_miner_smart, enableMinerSmart);
    RecipeRegistry.toggleVisibility(BlockRegistry.builder_pattern, enablePattern);
    RecipeRegistry.toggleVisibility(BlockRegistry.builder_block, enableBuilderBlock);
    RecipeRegistry.toggleVisibility(BlockRegistry.uncrafting_block, enableUncrafter);
    RecipeRegistry.toggleVisibility(BlockRegistry.harvester_block, enableHarvester);
    RecipeRegistry.toggleVisibility(BlockRegistry.miner_block, enableMiner);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_user, enableUser);
    RecipeRegistry.toggleVisibility(BlockRegistry.password_block, enablePassword);
    RecipeRegistry.toggleVisibility(BlockRegistry.magnet_block, enableMagnet);
    RecipeRegistry.toggleVisibility(BlockRegistry.plate_launch_small, launchPads);
    RecipeRegistry.toggleVisibility(BlockRegistry.plate_launch_med, launchPads);
    RecipeRegistry.toggleVisibility(BlockRegistry.plate_launch_large, launchPads);
    RecipeRegistry.toggleVisibility(BlockRegistry.magnet_anti_block, enableInterdict);
    RecipeRegistry.toggleVisibility(BlockRegistry.plate_push_fast, enableConveyor);
    RecipeRegistry.toggleVisibility(BlockRegistry.plate_push_slow, enableConveyor);
    RecipeRegistry.toggleVisibility(BlockRegistry.plate_push_slowest, enableConveyor);
    RecipeRegistry.toggleVisibility(BlockRegistry.plate_vector, vectorPlate);
    RecipeRegistry.toggleVisibility(BlockRegistry.block_miner_smart, enablePlacer);
    RecipeRegistry.toggleVisibility(BlockRegistry.exp_pylon, expPylon);
    boolean enableBeans = config.getBoolean("MagicBean", Const.ConfigCategory.content, true, Const.ConfigCategory.contentDefaultText);
    RecipeRegistry.toggleVisibility(ItemRegistry.sprout_seed, enableBeans);
    RecipeRegistry.toggleVisibility(BlockRegistry.sprout, enableBeans);
  }
}
