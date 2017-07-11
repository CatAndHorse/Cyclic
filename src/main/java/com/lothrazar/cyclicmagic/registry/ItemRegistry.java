package com.lothrazar.cyclicmagic.registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.google.common.collect.Sets;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.ModCyclic;
import com.lothrazar.cyclicmagic.block.BlockDimensionOre;
import com.lothrazar.cyclicmagic.block.IBlockHasTESR;
import com.lothrazar.cyclicmagic.block.IHasOreDict;
import com.lothrazar.cyclicmagic.component.cyclicwand.ItemCyclicWand;
import com.lothrazar.cyclicmagic.component.enderbook.ItemEnderBook;
import com.lothrazar.cyclicmagic.component.merchant.ItemMerchantAlmanac;
import com.lothrazar.cyclicmagic.component.playerext.ItemFoodCrafting;
import com.lothrazar.cyclicmagic.component.playerext.ItemFoodInventory;
import com.lothrazar.cyclicmagic.component.storagesack.ItemStorageBag;
import com.lothrazar.cyclicmagic.data.Const;
import com.lothrazar.cyclicmagic.entity.EntityGoldFurnaceMinecart;
import com.lothrazar.cyclicmagic.entity.EntityGoldMinecart;
import com.lothrazar.cyclicmagic.entity.EntityGoldMinecartChest;
import com.lothrazar.cyclicmagic.entity.EntityGoldMinecartDispenser;
import com.lothrazar.cyclicmagic.entity.EntityMinecartDropper;
import com.lothrazar.cyclicmagic.entity.EntityMinecartTurret;
import com.lothrazar.cyclicmagic.entity.EntityStoneMinecart;
import com.lothrazar.cyclicmagic.entity.projectile.EntityBlazeBolt;
import com.lothrazar.cyclicmagic.entity.projectile.EntityDungeonEye;
import com.lothrazar.cyclicmagic.entity.projectile.EntityDynamite;
import com.lothrazar.cyclicmagic.entity.projectile.EntityDynamiteBlockSafe;
import com.lothrazar.cyclicmagic.entity.projectile.EntityDynamiteMining;
import com.lothrazar.cyclicmagic.entity.projectile.EntityFishingBolt;
import com.lothrazar.cyclicmagic.entity.projectile.EntityLightningballBolt;
import com.lothrazar.cyclicmagic.entity.projectile.EntityMagicNetEmpty;
import com.lothrazar.cyclicmagic.entity.projectile.EntityMagicNetFull;
import com.lothrazar.cyclicmagic.entity.projectile.EntityShearingBolt;
import com.lothrazar.cyclicmagic.entity.projectile.EntitySnowballBolt;
import com.lothrazar.cyclicmagic.entity.projectile.EntityTorchBolt;
import com.lothrazar.cyclicmagic.entity.projectile.EntityWaterBolt;
import com.lothrazar.cyclicmagic.item.ItemAppleEmerald;
import com.lothrazar.cyclicmagic.item.ItemAppleLapis;
import com.lothrazar.cyclicmagic.item.ItemBuildSwapper;
import com.lothrazar.cyclicmagic.item.ItemCaveFinder;
import com.lothrazar.cyclicmagic.item.ItemChestSack;
import com.lothrazar.cyclicmagic.item.ItemChestSackEmpty;
import com.lothrazar.cyclicmagic.item.ItemChorusCorrupted;
import com.lothrazar.cyclicmagic.item.ItemChorusGlowing;
import com.lothrazar.cyclicmagic.item.ItemEnderBag;
import com.lothrazar.cyclicmagic.item.ItemEnderPearlReuse;
import com.lothrazar.cyclicmagic.item.ItemEnderWing;
import com.lothrazar.cyclicmagic.item.ItemFangs;
import com.lothrazar.cyclicmagic.item.ItemFireExtinguish;
import com.lothrazar.cyclicmagic.item.ItemHeartContainer;
import com.lothrazar.cyclicmagic.item.ItemHorseUpgrade;
import com.lothrazar.cyclicmagic.item.ItemMagicBean;
import com.lothrazar.cyclicmagic.item.ItemMattock;
import com.lothrazar.cyclicmagic.item.ItemPaperCarbon;
import com.lothrazar.cyclicmagic.item.ItemPasswordRemote;
import com.lothrazar.cyclicmagic.item.ItemPistonWand;
import com.lothrazar.cyclicmagic.item.ItemPlayerLauncher;
import com.lothrazar.cyclicmagic.item.ItemProspector;
import com.lothrazar.cyclicmagic.item.ItemRandomizer;
import com.lothrazar.cyclicmagic.item.ItemRotateBlock;
import com.lothrazar.cyclicmagic.item.ItemScythe;
import com.lothrazar.cyclicmagic.item.ItemSleepingMat;
import com.lothrazar.cyclicmagic.item.ItemSoulstone;
import com.lothrazar.cyclicmagic.item.ItemSpawnInspect;
import com.lothrazar.cyclicmagic.item.ItemStirrups;
import com.lothrazar.cyclicmagic.item.ItemTorchThrower;
import com.lothrazar.cyclicmagic.item.ItemWarpSurface;
import com.lothrazar.cyclicmagic.item.ItemWaterSpreader;
import com.lothrazar.cyclicmagic.item.ItemWaterToIce;
import com.lothrazar.cyclicmagic.item.ItemBuildSwapper.WandType;
import com.lothrazar.cyclicmagic.item.ItemHorseUpgrade.HorseUpgradeType;
import com.lothrazar.cyclicmagic.item.bauble.ItemAutoTorch;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmAir;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmAntidote;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmBoat;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmFire;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmSlowfall;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmSpeed;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmVoid;
import com.lothrazar.cyclicmagic.item.bauble.ItemCharmWater;
import com.lothrazar.cyclicmagic.item.bauble.ItemGloveClimb;
import com.lothrazar.cyclicmagic.item.gear.ItemEmeraldArmor;
import com.lothrazar.cyclicmagic.item.gear.ItemEmeraldAxe;
import com.lothrazar.cyclicmagic.item.gear.ItemEmeraldHoe;
import com.lothrazar.cyclicmagic.item.gear.ItemEmeraldPickaxe;
import com.lothrazar.cyclicmagic.item.gear.ItemEmeraldSpade;
import com.lothrazar.cyclicmagic.item.gear.ItemEmeraldSword;
import com.lothrazar.cyclicmagic.item.minecart.ItemDropperMinecart;
import com.lothrazar.cyclicmagic.item.minecart.ItemGoldFurnaceMinecart;
import com.lothrazar.cyclicmagic.item.minecart.ItemGoldMinecart;
import com.lothrazar.cyclicmagic.item.minecart.ItemStoneMinecart;
import com.lothrazar.cyclicmagic.item.minecart.ItemTurretMinecart;
import com.lothrazar.cyclicmagic.item.projectile.BaseItemProjectile;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileBlaze;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileDungeon;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileFishing;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileLightning;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileMagicNet;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileSnow;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileTNT;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileTorch;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileWater;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileWool;
import com.lothrazar.cyclicmagic.item.projectile.ItemProjectileTNT.ExplosionType;
import com.lothrazar.cyclicmagic.registry.GuideRegistry.GuideCategory;
import com.lothrazar.cyclicmagic.registry.GuideRegistry.GuideItem;
import com.lothrazar.cyclicmagic.registry.LootTableRegistry.ChestType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRegistry {
  public static ItemRandomizer tool_randomize = new ItemRandomizer();
  public static ItemEnderWing tool_warp_home = new ItemEnderWing(ItemEnderWing.WarpType.BED);
  public static ItemEnderWing tool_warp_spawn = new ItemEnderWing(ItemEnderWing.WarpType.SPAWN);
  public static ItemBuildSwapper tool_swap = new ItemBuildSwapper(WandType.NORMAL);
  public static ItemBuildSwapper tool_swap_match = new ItemBuildSwapper(WandType.MATCH);
  public static ItemCyclicWand cyclic_wand_build = new ItemCyclicWand();
  public static ItemSleepingMat sleeping_mat = new ItemSleepingMat();
  public static ItemPistonWand tool_push = new ItemPistonWand();
  public static ItemEnderPearlReuse ender_pearl_mounted = new ItemEnderPearlReuse(ItemEnderPearlReuse.OrbType.MOUNTED);
  public static ItemScythe tool_harvest_weeds = new ItemScythe(ItemScythe.HarvestType.WEEDS);
  public static ItemEnderPearlReuse ender_pearl_reuse = new ItemEnderPearlReuse(ItemEnderPearlReuse.OrbType.NORMAL);
  public static ItemScythe tool_harvest_crops = new ItemScythe(ItemScythe.HarvestType.CROPS);
  public static ItemScythe tool_harvest_leaves = new ItemScythe(ItemScythe.HarvestType.LEAVES);
  public static ItemCharmAir charm_air = new ItemCharmAir();
  public static ItemCharmSpeed charm_speed = new ItemCharmSpeed();
  public static ItemAutoTorch tool_auto_torch = new ItemAutoTorch();
  public static ItemCharmFire charm_fire = new ItemCharmFire();
  public static ItemCharmSlowfall charm_wing = new ItemCharmSlowfall();
  public static ItemCharmWater charm_water = new ItemCharmWater();
  public static ItemCharmVoid charm_void = new ItemCharmVoid();
  public static ItemCharmAntidote charm_antidote = new ItemCharmAntidote();
  public static ItemCharmBoat charm_boat = new ItemCharmBoat();
  public static ItemFangs evoker_fangs = new ItemFangs();
  public static ItemPlayerLauncher tool_launcher = new ItemPlayerLauncher();
  public static ItemSoulstone soulstone = new ItemSoulstone();
  public static ItemMerchantAlmanac tool_trade = new ItemMerchantAlmanac();
  public static ItemPasswordRemote password_remote = new ItemPasswordRemote();
  public static ItemWarpSurface tool_elevate = new ItemWarpSurface();
  public static ItemGloveClimb glove_climb = new ItemGloveClimb();
  public static ItemRotateBlock tool_rotate = new ItemRotateBlock();
  public static ItemWaterSpreader water_spreader = new ItemWaterSpreader();
  public static ItemWaterToIce water_freezer = new ItemWaterToIce();
  public static ItemFireExtinguish fire_killer = new ItemFireExtinguish();
  public static ItemEnderBag sack_ender = new ItemEnderBag();
  public static ItemTorchThrower tool_torch_launcher = new ItemTorchThrower();
  public static ItemStirrups tool_mount = new ItemStirrups();
  public static ItemChestSackEmpty chest_sack_empty = new ItemChestSackEmpty();
  public static ItemChestSack chest_sack = new ItemChestSack();
  public static ItemEnderBook book_ender = new ItemEnderBook();
  public static ItemStorageBag storage_bag = new ItemStorageBag();
  public static ItemPaperCarbon carbon_paper = new ItemPaperCarbon();
  public static ItemProspector tool_prospector = new ItemProspector();
  public static ItemSpawnInspect tool_spawn_inspect = new ItemSpawnInspect();
  public static ItemCaveFinder tool_spelunker = new ItemCaveFinder();
  public static Item emerald_carrot = new ItemHorseUpgrade(HorseUpgradeType.TYPE, new ItemStack(Items.EMERALD));
  public static Item lapis_carrot = new ItemHorseUpgrade(HorseUpgradeType.VARIANT, new ItemStack(Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage()));
  public static Item diamond_carrot = new ItemHorseUpgrade(HorseUpgradeType.HEALTH, new ItemStack(Items.DIAMOND));
  public static Item redstone_carrot = new ItemHorseUpgrade(HorseUpgradeType.SPEED, new ItemStack(Items.REDSTONE));
  public static Item ender_carrot = new ItemHorseUpgrade(HorseUpgradeType.JUMP, new ItemStack(Items.ENDER_EYE));
  public static ItemAppleEmerald apple_emerald = new ItemAppleEmerald();
  public static ItemChorusGlowing glowing_chorus = new ItemChorusGlowing();
  public static ItemChorusCorrupted corrupted_chorus = new ItemChorusCorrupted();
  public static ItemFoodInventory inventory_food = new ItemFoodInventory();
  public static ItemFoodCrafting crafting_food = new ItemFoodCrafting();
  public static ItemHeartContainer heart_food = new ItemHeartContainer();
  public static ItemAppleLapis apple_lapis = new ItemAppleLapis();
  public static ItemProjectileLightning ender_lightning = new ItemProjectileLightning();
  public static ItemProjectileSnow ender_snow = new ItemProjectileSnow();
  public static ItemProjectileWater ender_water = new ItemProjectileWater();
  public static ItemProjectileBlaze ender_blaze = new ItemProjectileBlaze();
  public static ItemProjectileDungeon ender_dungeon = new ItemProjectileDungeon();
  public static ItemProjectileFishing ender_fishing = new ItemProjectileFishing();
  public static ItemProjectileWool ender_wool = new ItemProjectileWool();
  public static ItemProjectileTorch ender_torch = new ItemProjectileTorch();
  public static ItemProjectileTNT dynamite_safe = new ItemProjectileTNT(6, ExplosionType.BLOCKSAFE);
  public static ItemProjectileMagicNet magic_net = new ItemProjectileMagicNet();
  public static ItemProjectileTNT dynamite_mining = new ItemProjectileTNT(6, ExplosionType.MINING);
  public static ItemProjectileTNT ender_tnt_1 = new ItemProjectileTNT(1, ExplosionType.NORMAL);
  public static ItemProjectileTNT ender_tnt_2 = new ItemProjectileTNT(2, ExplosionType.NORMAL);
  public static ItemProjectileTNT ender_tnt_3 = new ItemProjectileTNT(3, ExplosionType.NORMAL);
  public static ItemProjectileTNT ender_tnt_4 = new ItemProjectileTNT(4, ExplosionType.NORMAL);
  public static ItemProjectileTNT ender_tnt_5 = new ItemProjectileTNT(5, ExplosionType.NORMAL);
  public static ItemProjectileTNT ender_tnt_6 = new ItemProjectileTNT(6, ExplosionType.NORMAL);
  public static   ItemGoldMinecart gold_minecart = new ItemGoldMinecart();
  public static ItemTurretMinecart turret_minecart = new ItemTurretMinecart();
  public static  ItemStoneMinecart stone_minecart = new ItemStoneMinecart();
  public static  ItemDropperMinecart dropper_minecart = new ItemDropperMinecart();

  
  
 
 
  
  
  public static ItemMagicBean sprout_seed;
  public static ArrayList<BaseItemProjectile> projectiles = new ArrayList<BaseItemProjectile>();
  public static void init() {
 
    
    
 
    
    
    ItemRegistry.register(gold_minecart, "gold_minecart", GuideCategory.TRANSPORT);
    EntityGoldMinecart.dropItem = gold_minecart;
    EntityProjectileRegistry.registerModEntity(EntityGoldMinecart.class, "goldminecart", 1100);
    ItemGoldFurnaceMinecart gold_furnace_minecart = new ItemGoldFurnaceMinecart();
    ItemRegistry.register(gold_furnace_minecart, "gold_furnace_minecart", GuideCategory.TRANSPORT);
    EntityGoldFurnaceMinecart.dropItem = gold_furnace_minecart;
    EntityProjectileRegistry.registerModEntity(EntityGoldFurnaceMinecart.class, "goldfurnaceminecart", 1101);

    ItemRegistry.register(stone_minecart, "stone_minecart", GuideCategory.TRANSPORT);
    EntityStoneMinecart.dropItem = stone_minecart;
    EntityProjectileRegistry.registerModEntity(EntityStoneMinecart.class, "stoneminecart", 1102);

    EntityProjectileRegistry.registerModEntity(EntityGoldMinecartChest.class, "goldchestminecart", 1103);

    ItemRegistry.register(dropper_minecart, "dropper_minecart", GuideCategory.TRANSPORT);
    EntityMinecartDropper.dropItem = dropper_minecart;
    EntityProjectileRegistry.registerModEntity(EntityMinecartDropper.class, "golddropperminecart", 1104);
 
    //BROKEN:
    //it spawns entity in the world. so like an arrow, it flies to the arget but then magically teleports back o teh  cart position
    //stop for now
    EntityProjectileRegistry.registerModEntity(EntityGoldMinecartDispenser.class, "golddispenserminecart", 1105);


    ItemRegistry.register(turret_minecart, "turret_minecart", GuideCategory.TRANSPORT);
    EntityMinecartTurret.dropItem = turret_minecart;
    EntityProjectileRegistry.registerModEntity(EntityMinecartTurret.class, "turretminecart", 1106);
 
    
    
    
    
    ItemRegistry.register(ender_blaze, "ender_blaze", GuideCategory.ITEMTHROW);
    EntityProjectileRegistry.registerModEntity(EntityBlazeBolt.class, "blazebolt", 1008);
    EntityBlazeBolt.renderSnowball = ender_blaze;
    projectiles.add(ender_blaze);
    ItemRegistry.register(ender_dungeon, "ender_dungeon", GuideCategory.ITEMTHROW);
    EntityProjectileRegistry.registerModEntity(EntityDungeonEye.class, "dungeonbolt", 1006);
    EntityDungeonEye.renderSnowball = ender_dungeon;
    LootTableRegistry.registerLoot(ender_dungeon);
    //  ItemRegistry.registerWithJeiDescription(ender_dungeon);
    projectiles.add(ender_dungeon);
    ItemRegistry.register(ender_fishing, "ender_fishing", GuideCategory.ITEMTHROW);
    EntityProjectileRegistry.registerModEntity(EntityFishingBolt.class, "fishingbolt", 1004);
    EntityFishingBolt.renderSnowball = ender_fishing;
    // ItemRegistry.registerWithJeiDescription(ender_fishing);
    projectiles.add(ender_fishing);
    ItemRegistry.register(ender_wool, "ender_wool", GuideCategory.ITEMTHROW);
    EntityProjectileRegistry.registerModEntity(EntityShearingBolt.class, "woolbolt", 1003);
    EntityShearingBolt.renderSnowball = ender_wool;
    //   ItemRegistry.registerWithJeiDescription(ender_wool);
    projectiles.add(ender_wool);
    ItemRegistry.register(ender_torch, "ender_torch", GuideCategory.ITEMTHROW);
    EntityProjectileRegistry.registerModEntity(EntityTorchBolt.class, "torchbolt", 1002);
    EntityTorchBolt.renderSnowball = ender_torch;
    // ItemRegistry.registerWithJeiDescription(ender_torch);
    projectiles.add(ender_torch);
    ItemRegistry.register(ender_water, "ender_water", GuideCategory.ITEMTHROW);
    EntityProjectileRegistry.registerModEntity(EntityWaterBolt.class, "waterbolt", 1000);
    EntityWaterBolt.renderSnowball = ender_water;
    // ItemRegistry.registerWithJeiDescription(ender_water);
    projectiles.add(ender_water);
    ItemRegistry.register(ender_snow, "ender_snow", GuideCategory.ITEMTHROW);
    EntityProjectileRegistry.registerModEntity(EntitySnowballBolt.class, "frostbolt", 1001);
    EntitySnowballBolt.renderSnowball = ender_snow;
    //     ItemRegistry.registerWithJeiDescription(ender_snow);
    projectiles.add(ender_snow);
    ItemRegistry.register(ender_lightning, "ender_lightning", GuideCategory.ITEMTHROW);
    EntityProjectileRegistry.registerModEntity(EntityLightningballBolt.class, "lightningbolt", 999);
    EntityLightningballBolt.renderSnowball = ender_lightning;
    LootTableRegistry.registerLoot(ender_lightning);
    //    ItemRegistry.registerWithJeiDescription(ender_lightning);
    projectiles.add(ender_lightning);
    ItemRegistry.register(dynamite_safe, "dynamite_safe", GuideCategory.ITEMTHROW);
    GuideItem page = GuideRegistry.register(GuideCategory.ITEMTHROW, dynamite_safe);
    EntityProjectileRegistry.registerModEntity(EntityDynamiteBlockSafe.class, "tntblocksafebolt", 1009);
    EntityDynamiteBlockSafe.renderSnowball = dynamite_safe;
    projectiles.add(dynamite_safe);
    ItemRegistry.register(magic_net, "magic_net", GuideCategory.ITEMTHROW);
    EntityMagicNetEmpty.renderSnowball = magic_net;
    EntityMagicNetFull.renderSnowball = magic_net;
    EntityProjectileRegistry.registerModEntity(EntityMagicNetFull.class, "magicnetfull", 1011);
    EntityProjectileRegistry.registerModEntity(EntityMagicNetEmpty.class, "magicnetempty", 1012);
    projectiles.add(magic_net);
    ItemRegistry.register(dynamite_mining, "dynamite_mining", GuideCategory.ITEMTHROW);
    GuideRegistry.register(GuideCategory.ITEMTHROW, dynamite_mining);
    EntityProjectileRegistry.registerModEntity(EntityDynamiteMining.class, "tntminingbolt", 1010);
    EntityDynamiteMining.renderSnowball = dynamite_mining;
    projectiles.add(dynamite_mining);
    GuideRegistry.register(GuideCategory.ITEMTHROW, ender_tnt_1);
    EntityProjectileRegistry.registerModEntity(EntityDynamite.class, "tntbolt", 1007);
    EntityDynamite.renderSnowball = ender_tnt_1;
    projectiles.add(ender_tnt_1);
    projectiles.add(ender_tnt_2);
    projectiles.add(ender_tnt_3);
    projectiles.add(ender_tnt_4);
    projectiles.add(ender_tnt_5);
    projectiles.add(ender_tnt_6);
    //    page.findRecipes=true;
    //first the basic recipes
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_1, 12), new ItemStack(Blocks.TNT), "paper", new ItemStack(Items.CLAY_BALL), "enderpearl"));
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_2), new ItemStack(ender_tnt_1), new ItemStack(ender_tnt_1), new ItemStack(Items.CLAY_BALL)));
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_3), new ItemStack(ender_tnt_2), new ItemStack(ender_tnt_2), new ItemStack(Items.CLAY_BALL)));
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_4), new ItemStack(ender_tnt_3), new ItemStack(ender_tnt_3), new ItemStack(Items.CLAY_BALL)));
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_5), new ItemStack(ender_tnt_4), new ItemStack(ender_tnt_4), new ItemStack(Items.CLAY_BALL)));
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_6), new ItemStack(ender_tnt_5), new ItemStack(ender_tnt_5), new ItemStack(Items.CLAY_BALL)));
    //    //default recipes are added already insice the IRecipe
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_3), new ItemStack(ender_tnt_1), new ItemStack(ender_tnt_1), new ItemStack(ender_tnt_1), new ItemStack(ender_tnt_1), new ItemStack(Items.CLAY_BALL)));
    //    //two 3s is four 2s
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_4), new ItemStack(ender_tnt_2), new ItemStack(ender_tnt_2), new ItemStack(ender_tnt_2), new ItemStack(ender_tnt_2), new ItemStack(Items.CLAY_BALL)));
    //    //four 3s is two 4s is one 5
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_5), new ItemStack(ender_tnt_3), new ItemStack(ender_tnt_3), new ItemStack(ender_tnt_3), new ItemStack(ender_tnt_3), new ItemStack(Items.CLAY_BALL)));
    //    page.addRecipePage(RecipeRegistry.addShapelessRecipe(new ItemStack(ender_tnt_6), new ItemStack(ender_tnt_4), new ItemStack(ender_tnt_4), new ItemStack(ender_tnt_4), new ItemStack(ender_tnt_4), new ItemStack(Items.CLAY_BALL)));
    // 
    LootTableRegistry.registerLoot(ender_tnt_6);
    ItemRegistry.register(ender_tnt_1, "ender_tnt_1", null);
    ItemRegistry.register(ender_tnt_2, "ender_tnt_2", null);
    ItemRegistry.register(ender_tnt_3, "ender_tnt_3", null);
    ItemRegistry.register(ender_tnt_4, "ender_tnt_4", null);
    ItemRegistry.register(ender_tnt_5, "ender_tnt_5", null);
    ItemRegistry.register(ender_tnt_6, "ender_tnt_6", null);
    ItemRegistry.register(emerald_carrot, "horse_upgrade_type");
    ItemRegistry.register(lapis_carrot, "horse_upgrade_variant");
    ItemRegistry.register(diamond_carrot, "horse_upgrade_health");
    ItemRegistry.register(redstone_carrot, "horse_upgrade_speed");
    ItemRegistry.register(ender_carrot, "horse_upgrade_jump");
    ItemRegistry.register(charm_air, "charm_air", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(charm_fire, "charm_fire", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(charm_boat, "charm_boat", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(charm_void, "charm_void", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(charm_water, "charm_water", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(charm_antidote, "charm_antidote", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(charm_wing, "charm_wing", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(tool_auto_torch, "tool_auto_torch", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(charm_speed, "charm_speed", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(ItemRegistry.evoker_fangs, "evoker_fang", GuideCategory.ITEM);
    ItemRegistry.register(ItemRegistry.tool_launcher, "tool_launcher", GuideCategory.TRANSPORT);
    ItemRegistry.register(ItemRegistry.soulstone, "soulstone");
    ItemRegistry.register(ItemRegistry.tool_trade, "tool_trade");
    ItemRegistry.register(ItemRegistry.password_remote, "password_remote");
    ItemRegistry.register(ItemRegistry.tool_elevate, "tool_elevate", GuideCategory.TRANSPORT);
    ItemRegistry.register(ItemRegistry.glove_climb, "glove_climb", GuideCategory.ITEMBAUBLES);
    ItemRegistry.register(ItemRegistry.tool_rotate, "tool_rotate");
    ItemRegistry.register(ItemRegistry.water_spreader, "water_spreader");
    ItemRegistry.register(ItemRegistry.water_freezer, "water_freezer");
    ItemRegistry.register(ItemRegistry.fire_killer, "fire_killer");
    ItemRegistry.register(ItemRegistry.sack_ender, "sack_ender");
    ItemRegistry.register(ItemRegistry.tool_torch_launcher, "tool_torch_launcher");
    ItemRegistry.register(ItemRegistry.tool_mount, "tool_mount");
    ItemRegistry.chest_sack.setEmptySack(ItemRegistry.chest_sack_empty);
    ItemRegistry.chest_sack_empty.setFullSack(ItemRegistry.chest_sack);
    ItemRegistry.register(ItemRegistry.chest_sack, "chest_sack", null);
    ItemRegistry.register(ItemRegistry.chest_sack_empty, "chest_sack_empty");
    ItemRegistry.register(ItemRegistry.book_ender, "book_ender", GuideCategory.TRANSPORT);
    ItemRegistry.register(ItemRegistry.storage_bag, "storage_bag");
    ItemRegistry.register(ItemRegistry.carbon_paper, "carbon_paper");
    ItemRegistry.register(ItemRegistry.tool_randomize, "tool_randomize");
    ItemRegistry.register(ItemRegistry.tool_swap_match, "tool_swap_match");
    ItemRegistry.register(ItemRegistry.tool_prospector, "tool_prospector");
    ItemRegistry.register(apple_emerald, "apple_emerald");
    ItemRegistry.register(apple_lapis, "apple_lapis");
    ItemRegistry.register(heart_food, "heart_food");
    ItemRegistry.register(crafting_food, "crafting_food");
    ItemRegistry.register(inventory_food, "inventory_food");
    ItemRegistry.register(glowing_chorus, "glowing_chorus");
    ItemRegistry.register(corrupted_chorus, "corrupted_chorus");
    ItemRegistry.register(ItemRegistry.tool_spelunker, "tool_spelunker");
    ItemRegistry.register(ItemRegistry.tool_spawn_inspect, "tool_spawn_inspect");
    ItemRegistry.register(ItemRegistry.ender_pearl_reuse, "ender_pearl_reuse");
    ItemRegistry.register(ItemRegistry.ender_pearl_mounted, "ender_pearl_mounted");
    ItemRegistry.register(ItemRegistry.tool_harvest_weeds, "tool_harvest_weeds");
    ItemRegistry.register(ItemRegistry.tool_harvest_crops, "tool_harvest_crops");
    ItemRegistry.register(ItemRegistry.tool_harvest_leaves, "tool_harvest_leaves");
    ItemRegistry.register(ItemRegistry.tool_push, "tool_push");
    ItemRegistry.register(ItemRegistry.sleeping_mat, "sleeping_mat");
    ItemRegistry.register(ItemRegistry.tool_warp_home, "tool_warp_home", GuideCategory.TRANSPORT);
    ItemRegistry.register(ItemRegistry.tool_warp_spawn, "tool_warp_spawn", GuideCategory.TRANSPORT);
    ItemRegistry.register(ItemRegistry.tool_swap, "tool_swap");
    ItemRegistry.register(ItemRegistry.cyclic_wand_build, "cyclic_wand_build");
    SpellRegistry.register(ItemRegistry.cyclic_wand_build);
    ModCyclic.instance.events.register(ItemRegistry.soulstone);
    ModCyclic.instance.events.register(ItemRegistry.tool_launcher);
    ModCyclic.instance.events.register(tool_auto_torch);
    ModCyclic.instance.events.register(charm_air);
    ModCyclic.instance.events.register(ItemRegistry.storage_bag);
    ModCyclic.instance.setTabItemIfNull(ItemRegistry.cyclic_wand_build);
    ModCyclic.instance.events.register(ItemRegistry.tool_swap);
    ModCyclic.instance.events.register(ItemRegistry.tool_swap_match);
    ModCyclic.instance.events.register(ItemRegistry.tool_randomize);
    ModCyclic.instance.events.register(ItemRegistry.sleeping_mat);
    ModCyclic.instance.events.register(ItemRegistry.tool_push);
    ModCyclic.instance.events.register(apple_lapis);
    ModCyclic.instance.events.register(apple_emerald);
    ModCyclic.instance.events.register(heart_food);
    ModCyclic.instance.events.register(corrupted_chorus);
    ModCyclic.instance.events.register(glowing_chorus);
    LootTableRegistry.registerLoot(heart_food, ChestType.ENDCITY);
    LootTableRegistry.registerLoot(heart_food, ChestType.IGLOO);
    LootTableRegistry.registerLoot(heart_food);
    LootTableRegistry.registerLoot(apple_emerald);
    LootTableRegistry.registerLoot(crafting_food);
    LootTableRegistry.registerLoot(inventory_food);
    LootTableRegistry.registerLoot(corrupted_chorus);
    LootTableRegistry.registerLoot(corrupted_chorus, ChestType.ENDCITY);
    LootTableRegistry.registerLoot(ItemRegistry.tool_prospector);
    LootTableRegistry.registerLoot(ItemRegistry.ender_pearl_reuse);
    LootTableRegistry.registerLoot(ItemRegistry.ender_pearl_mounted);
    LootTableRegistry.registerLoot(ItemRegistry.tool_harvest_crops);
    LootTableRegistry.registerLoot(ItemRegistry.tool_harvest_leaves, ChestType.BONUS);
    LootTableRegistry.registerLoot(ItemRegistry.tool_push);
    LootTableRegistry.registerLoot(ItemRegistry.cyclic_wand_build, ChestType.ENDCITY, 15);
    LootTableRegistry.registerLoot(ItemRegistry.cyclic_wand_build, ChestType.GENERIC, 1);
    LootTableRegistry.registerLoot(ItemRegistry.sleeping_mat, ChestType.BONUS);
    LootTableRegistry.registerLoot(ItemRegistry.tool_harvest_weeds, ChestType.BONUS);
    LootTableRegistry.registerLoot(ItemRegistry.tool_warp_spawn);
    LootTableRegistry.registerLoot(ItemRegistry.tool_warp_home);
    LootTableRegistry.registerLoot(ItemRegistry.book_ender);
    LootTableRegistry.registerLoot(ItemRegistry.book_ender);
    LootTableRegistry.registerLoot(ItemRegistry.tool_elevate);
    LootTableRegistry.registerLoot(ItemRegistry.glove_climb);
    LootTableRegistry.registerLoot(ItemRegistry.sack_ender);
    LootTableRegistry.registerLoot(ItemRegistry.storage_bag, ChestType.BONUS);
    LootTableRegistry.registerLoot(charm_air);
    LootTableRegistry.registerLoot(charm_fire);
    LootTableRegistry.registerLoot(charm_void);
    LootTableRegistry.registerLoot(charm_antidote);
    LootTableRegistry.registerLoot(charm_wing);
    LootTableRegistry.registerLoot(tool_auto_torch);
    LootTableRegistry.registerLoot(ItemRegistry.evoker_fangs);
  }
  public static Map<String, Item> itemMap = new HashMap<String, Item>();
  public static void register(Item item, String key, GuideCategory cat) {
    item.setUnlocalizedName(key);
    item.setRegistryName(new ResourceLocation(Const.MODID, key));
    itemMap.put(key, item);
    item = ItemRegistry.itemMap.get(key);
    item.setCreativeTab(ModCyclic.TAB);
    if (item instanceof IHasConfig) {
      ConfigRegistry.register((IHasConfig) item);
    }
    // IRecipe recipe = null;
    //    if (item instanceof IHasRecipe) {
    //      recipe = ((IHasRecipe) item).addRecipe();
    //    }
    if (cat != null) {
      GuideRegistry.register(cat, item, null);
    }
  }
  public static void register(Item item, String key) {
    register(item, key, GuideCategory.ITEM);//defaults to in guide book with its own standalone page
  }
  @SubscribeEvent
  public static void onRegistryEvent(RegistryEvent.Register<Item> event) {
    // event.getRegistry().registerAll(ItemRegistry.itemMap.values().toArray(new Item[0]));
    //new registries are crazy wacky. so ore dict DOES NOT WORK in block reg, stack becomes empty
    for (Item b : ItemRegistry.itemMap.values()) {
      event.getRegistry().register(b);
      Block blockItem = Block.getBlockFromItem(b);
      if (blockItem instanceof IHasOreDict) {
        String oreName = ((IHasOreDict) blockItem).getOre();
        OreDictionary.registerOre(oreName, blockItem);
        ModCyclic.logger.info("Registered ore dict entry " + oreName + " : " + blockItem);
      }
      //hacky-ish way to register smelting.. we do not have ability do to this inside block class anymore
      if (blockItem instanceof BlockDimensionOre) {
        BlockDimensionOre ore = (BlockDimensionOre) blockItem;
        GameRegistry.addSmelting(b, ore.getSmeltingOutput(), 1);
      }
    }
  }
  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public static void registerModels(ModelRegistryEvent event) {
    // with help from
    // http://www.minecraftforge.net/forum/index.php?topic=32492.0
    // https://github.com/TheOnlySilverClaw/Birdmod/blob/master/src/main/java/silverclaw/birds/client/ClientProxyBirds.java
    // More info on proxy rendering
    // http://www.minecraftforge.net/forum/index.php?topic=27684.0
    // http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/modification-development/2272349-lessons-from-my-first-mc-1-8-mod
    //    ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
    String name;
    Item item;
    for (Block b : BlockRegistry.blocks) {
      item = Item.getItemFromBlock(b);
      name = Const.MODRES + b.getUnlocalizedName().replaceAll("tile.", "");
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name));
      if (b instanceof IBlockHasTESR) {
        ((IBlockHasTESR) b).initModel();
      }
    }
    for (String key : ItemRegistry.itemMap.keySet()) {
      item = ItemRegistry.itemMap.get(key);
      if (item instanceof ItemBlock) {
        continue;
      }
      name = Const.MODRES + item.getUnlocalizedName().replaceAll("item.", "");
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
    }
  }
  //  @SubscribeEvent
  //  public static void onRegistryRecipeEvent(RegistryEvent.Register<IRecipe> event) {
  //  //  event.re
  //    //CraftingManager.getRecipeById(id)
  //     
  ////    event.getRegistry()
  //    System.out.println("onRegistryRecipeEvent onRegistryRecipeEvent onRegistryRecipeEvent");
  //  }
}
