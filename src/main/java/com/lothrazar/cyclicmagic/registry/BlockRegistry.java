package com.lothrazar.cyclicmagic.registry;
import java.util.ArrayList;
import javax.annotation.Nullable;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.ModCyclic;
import com.lothrazar.cyclicmagic.block.BlockConveyor;
import com.lothrazar.cyclicmagic.block.BlockCropMagicBean;
import com.lothrazar.cyclicmagic.block.BlockLaunch;
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
import com.lothrazar.cyclicmagic.component.magnet.BlockMagnet;
import com.lothrazar.cyclicmagic.component.magnet.TileEntityMagnet;
import com.lothrazar.cyclicmagic.component.magnetanti.BlockMagnetAnti;
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
import com.lothrazar.cyclicmagic.component.vector.BlockVectorPlate;
import com.lothrazar.cyclicmagic.component.vector.ItemBlockVectorPlate;
import com.lothrazar.cyclicmagic.component.vector.TileEntityVector;
import com.lothrazar.cyclicmagic.component.workbench.BlockWorkbench;
import com.lothrazar.cyclicmagic.component.workbench.TileEntityWorkbench;
import com.lothrazar.cyclicmagic.data.Const;
import com.lothrazar.cyclicmagic.registry.GuideRegistry.GuideCategory;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {
  public static ArrayList<Block> blocks = new ArrayList<Block>();
  public static BlockBucketStorage block_storelava = new BlockBucketStorage(Items.LAVA_BUCKET);;//TODO: FIX THIS ENTIRE THING.. maybe even fliud registry eh
  public static BlockBucketStorage block_storewater = new BlockBucketStorage(Items.WATER_BUCKET);;
  public static BlockBucketStorage block_storemilk = new BlockBucketStorage(Items.MILK_BUCKET);;
  public static BlockBucketStorage block_storeempty = new BlockBucketStorage(null);;
  public static BlockSoundSuppress block_soundproofing = new BlockSoundSuppress();
  public static BlockWorkbench workbench = new BlockWorkbench();
  public static BlockCrafter auto_crafter = new BlockCrafter();
  public static BlockDetector detector = new BlockDetector();
  public static BlockShears block_shears = new BlockShears();
  public static BlockDisenchanter block_disenchanter = new BlockDisenchanter();
  public static BlockFishing block_fishing = new BlockFishing();
  public static BlockScaffolding block_fragile = new BlockScaffolding(true);
  public static BlockScaffoldingReplace block_fragile_weak = new BlockScaffoldingReplace();
  public static BlockScaffoldingResponsive block_fragile_auto = new BlockScaffoldingResponsive();
  public static BlockFan fan = new BlockFan();
  public static BlockMagnetAnti magnet_anti_block = new BlockMagnetAnti();
  public static BlockMagnet magnet_block = new BlockMagnet();
  public static BlockLaunch plate_launch_large = new BlockLaunch(1.8F, SoundEvents.BLOCK_SLIME_BREAK);
  public static BlockLaunch plate_launch_small = new BlockLaunch(0.8F, SoundEvents.BLOCK_SLIME_STEP);
  public static BlockLaunch plate_launch_med = new BlockLaunch(1.3F, SoundEvents.BLOCK_SLIME_FALL);
  public static BlockConveyor plate_push = new BlockConveyor(0.16F);
  public static BlockConveyor plate_push_fast = new BlockConveyor(0.32F);
  public static BlockConveyor plate_push_slowest = new BlockConveyor(0.04F);
  public static BlockConveyor plate_push_slow = new BlockConveyor(0.08F);
  public static BlockVectorPlate plate_vector = new BlockVectorPlate();
  public static BlockUncrafting uncrafting_block = new BlockUncrafting();
  public static BlockHarvester harvester_block = new BlockHarvester();
  public static BlockStructureBuilder builder_block = new BlockStructureBuilder();
  public static BlockMiner miner_block = new BlockMiner();
  public static BlockPatternBuilder builder_pattern = new BlockPatternBuilder();
  public static BlockXpPylon exp_pylon = new BlockXpPylon();
  public static BlockPlacer placer_block = new BlockPlacer();
  public static BlockPassword password_block = new BlockPassword();
  public static BlockMinerSmart block_miner_smart = new BlockMinerSmart();
  public static BlockUser block_user = new BlockUser();
  public static void init() {
    initBlocks();
    initTileEntities();
    initEvents();
    //most guide setup hapens auto in block registry process, these are the exceptions
    GuideRegistry.register(GuideCategory.BLOCKPLATE, BlockRegistry.plate_vector);
    GuideRegistry.register(GuideCategory.BLOCKPLATE, BlockRegistry.plate_push);
    GuideRegistry.register(GuideCategory.BLOCKPLATE, BlockRegistry.plate_launch_med);
    GuideRegistry.register(GuideCategory.BLOCK, BlockRegistry.block_storeempty, null);
  }
  private static void initTileEntities() {
    GameRegistry.registerTileEntity(TileEntityMagnet.class, "magnet_block_te");
    GameRegistry.registerTileEntity(TileEntityMagnetAnti.class, "magnet_anti_block_te");
    GameRegistry.registerTileEntity(TileEntityUser.class, Const.MODID + "block_user_te");
    GameRegistry.registerTileEntity(TileEntityVector.class, "plate_vector_te");
    GameRegistry.registerTileEntity(TileEntityWorkbench.class, Const.MODID + "workbench_te");
    GameRegistry.registerTileEntity(TileEntityControlledMiner.class, Const.MODID + "miner_smart_te");
    GameRegistry.registerTileEntity(TileEntityXpPylon.class, "exp_pylon_te");
    GameRegistry.registerTileEntity(TileEntityPatternBuilder.class, "builder_pattern_te");
    GameRegistry.registerTileEntity(TileEntityHarvester.class, "harveseter_te");
    GameRegistry.registerTileEntity(TileEntityStructureBuilder.class, "builder_te");
    GameRegistry.registerTileEntity(TileEntityPlacer.class, "placer_block_te");
    GameRegistry.registerTileEntity(TileEntityBlockMiner.class, "miner_te");
    GameRegistry.registerTileEntity(TileEntityUncrafter.class, "uncrafting_block_te");
    GameRegistry.registerTileEntity(TileEntityCrafter.class, Const.MODID + "auto_crafter_te");
    GameRegistry.registerTileEntity(TileEntityPassword.class, "password_block_te");
    GameRegistry.registerTileEntity(TileEntityDetector.class, Const.MODID + "entity_detector_te");
    GameRegistry.registerTileEntity(TileEntityFishing.class, Const.MODID + "block_fishing_te");
    GameRegistry.registerTileEntity(TileEntityFan.class, Const.MODID + "fan_te");
    GameRegistry.registerTileEntity(TileEntityDisenchanter.class, Const.MODID + "block_disenchanter_te");
    GameRegistry.registerTileEntity(TileEntityBucketStorage.class, "bucketstorage");
  }
  private static void initBlocks() {
    BlockRegistry.registerBlock(exp_pylon, "exp_pylon", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(builder_pattern, "builder_pattern", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(builder_block, "builder_block", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(harvester_block, "harvester_block", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(uncrafting_block, "uncrafting_block", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(miner_block, "block_miner", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(block_miner_smart, "block_miner_smart", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(placer_block, "placer_block", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(password_block, "password_block", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(block_user, "block_user", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(BlockRegistry.workbench, "block_workbench", GuideCategory.BLOCK);
    BlockRegistry.registerBlock(BlockRegistry.block_soundproofing, "block_soundproofing", GuideCategory.BLOCK);
    BlockRegistry.registerBlock(BlockRegistry.auto_crafter, "auto_crafter", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(BlockRegistry.fan, "fan", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(BlockRegistry.detector, "entity_detector", GuideCategory.BLOCKMACHINE);
    BlockRegistry.registerBlock(BlockRegistry.block_shears, "block_shears", GuideCategory.BLOCK);
    BlockRegistry.registerBlock(BlockRegistry.block_fragile, new ItemBlockScaffolding(BlockRegistry.block_fragile), "block_fragile", GuideCategory.BLOCK);
    BlockRegistry.registerBlock(BlockRegistry.block_fragile_auto, new ItemBlockScaffolding(BlockRegistry.block_fragile_auto), "block_fragile_auto", GuideCategory.BLOCK);
    BlockRegistry.registerBlock(BlockRegistry.block_fragile_weak, new ItemBlockScaffolding(BlockRegistry.block_fragile_weak), "block_fragile_weak", GuideCategory.BLOCK);
    BlockRegistry.registerBlock(BlockRegistry.block_fishing, "block_fishing", GuideCategory.BLOCK);
    BlockRegistry.registerBlock(BlockRegistry.block_disenchanter, "block_disenchanter", GuideCategory.BLOCKMACHINE);
    //TODO: refactor and support more recipes
    BlockRegistry.registerBlock(BlockRegistry.block_storewater, new ItemBlockBucket(BlockRegistry.block_storewater), "block_storewater", null);
    BlockRegistry.registerBlock(BlockRegistry.block_storemilk, new ItemBlockBucket(BlockRegistry.block_storemilk), "block_storemilk", null);
    BlockRegistry.registerBlock(BlockRegistry.block_storelava, new ItemBlockBucket(BlockRegistry.block_storelava), "block_storelava", null);
    BlockRegistry.registerBlock(BlockRegistry.block_storeempty, new ItemBlockBucket(BlockRegistry.block_storeempty), "block_storeempty", null);
    BlockRegistry.registerBlock(BlockRegistry.magnet_block, "magnet_block", GuideCategory.BLOCKPLATE);
    BlockRegistry.registerBlock(BlockRegistry.plate_launch_med, "plate_launch_med", null);
    BlockRegistry.registerBlock(BlockRegistry.plate_launch_small, "plate_launch_small", null);
    BlockRegistry.registerBlock(BlockRegistry.plate_launch_large, "plate_launch_large", null);
    BlockRegistry.registerBlock(BlockRegistry.plate_vector, new ItemBlockVectorPlate(BlockRegistry.plate_vector), "plate_vector", null);
    BlockRegistry.registerBlock(BlockRegistry.plate_push_fast, "plate_push_fast", null);
    BlockRegistry.registerBlock(BlockRegistry.plate_push_slow, "plate_push_slow", null);
    BlockRegistry.registerBlock(BlockRegistry.plate_push, "plate_push", null);
    BlockRegistry.registerBlock(BlockRegistry.plate_push_slowest, "plate_push_slowest", null);
    BlockRegistry.registerBlock(BlockRegistry.magnet_anti_block, "magnet_anti_block", GuideCategory.BLOCKPLATE);
  }
  private static void initEvents() {
    ModCyclic.instance.events.register(BlockRegistry.block_soundproofing);
    ModCyclic.instance.events.register(Item.getItemFromBlock(BlockRegistry.block_fragile_weak));
    ModCyclic.instance.events.register(Item.getItemFromBlock(BlockRegistry.block_fragile_auto));
    ModCyclic.instance.events.register(Item.getItemFromBlock(BlockRegistry.block_fragile));
    ModCyclic.instance.events.register(BlockRegistry.plate_vector);
    ModCyclic.instance.events.register(password_block);
  }
  public static void registerBlock(Block b, String name, @Nullable GuideCategory cat) {
    registerBlock(b, new ItemBlock(b), name, cat);
  }
  public static void registerBlock(Block b, ItemBlock ib, String name, @Nullable GuideCategory cat) {
    b.setRegistryName(new ResourceLocation(Const.MODID, name));
    b.setUnlocalizedName(name);
    if (ib != null) {
      ib.setRegistryName(b.getRegistryName()); // ok good this should work yes? yes! http://mcforge.readthedocs.io/en/latest/blocks/blocks/#registering-a-block
      ItemRegistry.itemMap.put(name, ib);
    }
    b.setCreativeTab(ModCyclic.TAB);
    blocks.add(b);
    IHasRecipe recipeMeta = null;
    if (b instanceof IHasConfig) {
      ConfigRegistry.register((IHasConfig) b);
    }
    //    if (b instanceof IHasRecipe) {
    //      recipeMeta = ((IHasRecipe) b);
    //    }
    if (cat != null) {
      // boolean isHidden = (recipeMeta != null && recipeMeta.isHidden());
      //if recipe  is hidden, dont put in guidebook also eh
      GuideRegistry.register(cat, b, null);
    }
    if (!(b instanceof BlockCropMagicBean)) { //TODO FIX dirty hack to skip sprout
      JeiDescriptionRegistry.registerWithJeiDescription(b);
    }
  }
  @SubscribeEvent
  public static void onRegistryEvent(RegistryEvent.Register<Block> event) {
    //    event.getRegistry().registerAll(blocks.toArray(new Block[0]));
    for (Block b : blocks) {
      event.getRegistry().register(b);
      //      if (b instanceof BlockDimensionOre) {
      //        BlockDimensionOre ore = (BlockDimensionOre) b;
      //ore dict fails here
      //      }
    }
  }
}
