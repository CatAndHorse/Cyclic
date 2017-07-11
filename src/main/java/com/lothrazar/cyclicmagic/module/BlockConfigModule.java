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

public class BlockConfigModule extends BaseModule implements IHasConfig {
  public void onPreInit() {
  }
  @Override
  public void syncConfig(Configuration config) {
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
    String category = Const.ConfigCategory.content;
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
    RecipeRegistry.toggleVisibility(BlockRegistry.sprout,  enableBeans);
  
    
    
  }
}
