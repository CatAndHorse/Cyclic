package com.lothrazar.cyclicmagic.gui;
import com.lothrazar.cyclicmagic.component.autouser.ContainerUser;
import com.lothrazar.cyclicmagic.component.autouser.GuiUser;
import com.lothrazar.cyclicmagic.component.autouser.TileEntityUser;
import com.lothrazar.cyclicmagic.component.builder.ContainerBuilder;
import com.lothrazar.cyclicmagic.component.builder.GuiBuilder;
import com.lothrazar.cyclicmagic.component.builder.TileEntityStructureBuilder;
import com.lothrazar.cyclicmagic.component.controlledminer.ContainerMinerSmart;
import com.lothrazar.cyclicmagic.component.controlledminer.GuiMinerSmart;
import com.lothrazar.cyclicmagic.component.controlledminer.TileEntityControlledMiner;
import com.lothrazar.cyclicmagic.component.crafter.ContainerCrafter;
import com.lothrazar.cyclicmagic.component.crafter.GuiCrafter;
import com.lothrazar.cyclicmagic.component.crafter.TileEntityCrafter;
import com.lothrazar.cyclicmagic.component.cyclicwand.ContainerWand;
import com.lothrazar.cyclicmagic.component.cyclicwand.GuiWandInventory;
import com.lothrazar.cyclicmagic.component.cyclicwand.InventoryWand;
import com.lothrazar.cyclicmagic.component.disenchanter.ContainerDisenchanter;
import com.lothrazar.cyclicmagic.component.disenchanter.GuiDisenchanter;
import com.lothrazar.cyclicmagic.component.disenchanter.TileEntityDisenchanter;
import com.lothrazar.cyclicmagic.component.enderbook.GuiEnderBook;
import com.lothrazar.cyclicmagic.component.entitydetector.ContainerDetector;
import com.lothrazar.cyclicmagic.component.entitydetector.GuiDetector;
import com.lothrazar.cyclicmagic.component.entitydetector.TileEntityDetector;
import com.lothrazar.cyclicmagic.component.fan.ContainerFan;
import com.lothrazar.cyclicmagic.component.fan.GuiFan;
import com.lothrazar.cyclicmagic.component.fan.TileEntityFan;
import com.lothrazar.cyclicmagic.component.fisher.ContainerFisher;
import com.lothrazar.cyclicmagic.component.fisher.GuiFisher;
import com.lothrazar.cyclicmagic.component.fisher.TileEntityFishing;
import com.lothrazar.cyclicmagic.component.harvester.ContainerHarvester;
import com.lothrazar.cyclicmagic.component.harvester.GuiHarvester;
import com.lothrazar.cyclicmagic.component.harvester.TileEntityHarvester;
import com.lothrazar.cyclicmagic.component.merchant.ContainerMerchantBetter;
import com.lothrazar.cyclicmagic.component.merchant.GuiMerchantBetter;
import com.lothrazar.cyclicmagic.component.merchant.InventoryMerchantBetter;
import com.lothrazar.cyclicmagic.component.merchant.ItemMerchantAlmanac;
import com.lothrazar.cyclicmagic.component.miner.ContainerBlockMiner;
import com.lothrazar.cyclicmagic.component.miner.GuiBlockMiner;
import com.lothrazar.cyclicmagic.component.miner.TileEntityBlockMiner;
import com.lothrazar.cyclicmagic.component.password.ContainerPassword;
import com.lothrazar.cyclicmagic.component.password.GuiPassword;
import com.lothrazar.cyclicmagic.component.password.TileEntityPassword;
import com.lothrazar.cyclicmagic.component.pattern.ContainerPattern;
import com.lothrazar.cyclicmagic.component.pattern.GuiPattern;
import com.lothrazar.cyclicmagic.component.pattern.TileEntityPatternBuilder;
import com.lothrazar.cyclicmagic.component.placer.ContainerPlacer;
import com.lothrazar.cyclicmagic.component.placer.GuiPlacer;
import com.lothrazar.cyclicmagic.component.placer.TileEntityPlacer;
import com.lothrazar.cyclicmagic.component.playerext.crafting.ContainerPlayerExtWorkbench;
import com.lothrazar.cyclicmagic.component.playerext.crafting.GuiPlayerExtWorkbench;
import com.lothrazar.cyclicmagic.component.playerext.storage.ContainerPlayerExtended;
import com.lothrazar.cyclicmagic.component.playerext.storage.GuiPlayerExtended;
import com.lothrazar.cyclicmagic.component.playerext.storage.InventoryPlayerExtended;
import com.lothrazar.cyclicmagic.component.pylonexp.ContainerPylon;
import com.lothrazar.cyclicmagic.component.pylonexp.GuiPylon;
import com.lothrazar.cyclicmagic.component.pylonexp.TileEntityXpPylon;
import com.lothrazar.cyclicmagic.component.storagesack.ContainerStorage;
import com.lothrazar.cyclicmagic.component.storagesack.GuiStorage;
import com.lothrazar.cyclicmagic.component.storagesack.InventoryStorage;
import com.lothrazar.cyclicmagic.component.storagesack.ItemStorageBag;
import com.lothrazar.cyclicmagic.component.uncrafter.ContainerUncrafting;
import com.lothrazar.cyclicmagic.component.uncrafter.GuiUncrafting;
import com.lothrazar.cyclicmagic.component.uncrafter.TileEntityUncrafter;
import com.lothrazar.cyclicmagic.component.vector.ContainerVector;
import com.lothrazar.cyclicmagic.component.vector.GuiVector;
import com.lothrazar.cyclicmagic.component.vector.TileEntityVector;
import com.lothrazar.cyclicmagic.component.workbench.ContainerWorkBench;
import com.lothrazar.cyclicmagic.component.workbench.GuiWorkbench;
import com.lothrazar.cyclicmagic.component.workbench.TileEntityWorkbench;
import com.lothrazar.cyclicmagic.util.UtilEntity;
import com.lothrazar.cyclicmagic.util.UtilPlayer;
import com.lothrazar.cyclicmagic.util.UtilSpellCaster;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ForgeGuiHandler implements IGuiHandler {
  public static final int GUI_INDEX_UNCRAFTING = 0;
  public static final int GUI_INDEX_WAND = 1;
  public static final int GUI_INDEX_EXTENDED = 2;
  public static final int GUI_INDEX_STORAGE = 3;
  public static final int GUI_INDEX_WAYPOINT = 4;
  public static final int GUI_INDEX_BUILDER = 5;
  public static final int GUI_INDEX_PLACER = 6;
  public static final int GUI_INDEX_PASSWORD = 7;
  public static final int GUI_INDEX_SMARTMINER = 8;
  public static final int GUI_INDEX_FISHER = 9;
  public static final int GUI_INDEX_PWORKBENCH = 10;
  public static final int GUI_INDEX_USER = 11;
  public static final int GUI_INDEX_HARVESTER = 12;
  public static final int GUI_INDEX_BLOCKMINER = 13;
  public static final int GUI_INDEX_PATTERN = 14;
  public static final int GUI_INDEX_DETECTOR = 15;
  public static final int GUI_INDEX_VECTOR = 16;
  public static final int GUI_INDEX_VILLAGER = 17;
  public static final int GUI_INDEX_FAN = 18;
  public static final int GUI_INDEX_XP = 19;
  public static final int GUI_INDEX_DISENCH = 20;
  public static final int GUI_INDEX_CRAFTER = 21;
  public static final int GUI_INDEX_WORKBENCH = 22;
  @Override
  public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    BlockPos p = new BlockPos(x, y, z);
    TileEntity te = world.getTileEntity(p);
    switch (ID) {
      case GUI_INDEX_EXTENDED:
        return new ContainerPlayerExtended(player.inventory, new InventoryPlayerExtended(player), player);
      case GUI_INDEX_PWORKBENCH:
        return new ContainerPlayerExtWorkbench(player.inventory, player);
      case GUI_INDEX_WAND:
        ItemStack wand = UtilSpellCaster.getPlayerWandIfHeld(player);
        return new ContainerWand(player, player.inventory, new InventoryWand(player, wand));
      case GUI_INDEX_UNCRAFTING:
        if (te != null && te instanceof TileEntityUncrafter) { return new ContainerUncrafting(player.inventory, (TileEntityUncrafter) te); }
      break;
      case GUI_INDEX_HARVESTER:
        if (te != null && te instanceof TileEntityHarvester) { return new ContainerHarvester(player.inventory, (TileEntityHarvester) te); }
      break;
      case GUI_INDEX_BLOCKMINER:
        if (te != null && te instanceof TileEntityBlockMiner) { return new ContainerBlockMiner(player.inventory, (TileEntityBlockMiner) te); }
      break;
      case GUI_INDEX_STORAGE:
        ItemStack s = ItemStorageBag.getPlayerItemIfHeld(player);
        return new ContainerStorage(player, player.inventory, new InventoryStorage(player, s));
      case GUI_INDEX_WAYPOINT:
        return null;
      case GUI_INDEX_BUILDER:
        if (te != null && te instanceof TileEntityStructureBuilder) {
          Container c = new ContainerBuilder(player.inventory, (TileEntityStructureBuilder) te);
          c.detectAndSendChanges();
          return c;
        }
      break;
      case GUI_INDEX_PLACER:
        if (te != null && te instanceof TileEntityPlacer) {
          Container c = new ContainerPlacer(player.inventory, (TileEntityPlacer) te);
          c.detectAndSendChanges();
          return c;
        }
      break;
      case GUI_INDEX_PASSWORD:
        if (te != null && te instanceof TileEntityPassword) {
          Container c = new ContainerPassword((TileEntityPassword) te);
          return c;
        }
      break;
      case GUI_INDEX_SMARTMINER:
        if (te != null && te instanceof TileEntityControlledMiner) {
          Container c = new ContainerMinerSmart(player.inventory, (TileEntityControlledMiner) te);
          return c;
        }
      break;
      case GUI_INDEX_FISHER:
        if (te != null && te instanceof TileEntityFishing) { return new ContainerFisher(player.inventory, (TileEntityFishing) te); }
      break;
      case GUI_INDEX_USER:
        if (te != null && te instanceof TileEntityUser) { return new ContainerUser(player.inventory, (TileEntityUser) te); }
      break;
      case GUI_INDEX_PATTERN:
        if (te != null && te instanceof TileEntityPatternBuilder) { return new ContainerPattern(player.inventory, (TileEntityPatternBuilder) te); }
      break;
      case GUI_INDEX_DETECTOR:
        if (te != null && te instanceof TileEntityDetector) { return new ContainerDetector(player.inventory, (TileEntityDetector) te); }
      break;
      case GUI_INDEX_VECTOR:
        if (te != null && te instanceof TileEntityVector) { return new ContainerVector(player.inventory, (TileEntityVector) te); }
      break;
      case GUI_INDEX_VILLAGER:
        //http://www.minecraftforge.net/forum/topic/29593-18-solveddisplay-gui-when-interacting-with-an-entity/
        EntityVillager v = (EntityVillager) UtilEntity.getClosestEntity(world, player, UtilEntity.getVillagers(world, p, ItemMerchantAlmanac.radius));
        if (v != null) {
          v.setCustomer(player);
          ContainerMerchantBetter c = new ContainerMerchantBetter(player.inventory, v, new InventoryMerchantBetter(player, v), world);
          return c;
        }
      break;
      case GUI_INDEX_FAN:
        if (te != null && te instanceof TileEntityFan) { return new ContainerFan(player.inventory, (TileEntityFan) te); }
      break;
      case GUI_INDEX_XP:
        if (te instanceof TileEntityXpPylon) { return new ContainerPylon(player.inventory, (TileEntityXpPylon) te); }
      break;
      case GUI_INDEX_DISENCH:
        if (te instanceof TileEntityDisenchanter) { return new ContainerDisenchanter(player.inventory, (TileEntityDisenchanter) te); }
      break;
      case GUI_INDEX_CRAFTER:
        if (te instanceof TileEntityCrafter) { return new ContainerCrafter(player.inventory, (TileEntityCrafter) te); }
      break;
      case GUI_INDEX_WORKBENCH:
        if (te instanceof TileEntityWorkbench) { return new ContainerWorkBench(player.inventory, (TileEntityWorkbench) te); }
      break;
    }
    return null;
  }
  @Override
  public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    BlockPos p = new BlockPos(x, y, z);
    if (world instanceof WorldClient) {
      TileEntity te = world.getTileEntity(p);
      switch (ID) {
        case GUI_INDEX_EXTENDED:
          return new GuiPlayerExtended(new ContainerPlayerExtended(player.inventory, new InventoryPlayerExtended(player), player));
        case GUI_INDEX_PWORKBENCH:
          return new GuiPlayerExtWorkbench(new ContainerPlayerExtWorkbench(player.inventory, player));
        case GUI_INDEX_WAND:
          ItemStack wand = UtilSpellCaster.getPlayerWandIfHeld(player);
          return new GuiWandInventory(new ContainerWand(player, player.inventory, new InventoryWand(player, wand)), wand);
        case GUI_INDEX_UNCRAFTING:
          if (te instanceof TileEntityUncrafter) { return new GuiUncrafting(player.inventory, (TileEntityUncrafter) te); }
        break;
        case GUI_INDEX_HARVESTER:
          if (te instanceof TileEntityHarvester) { return new GuiHarvester(player.inventory, (TileEntityHarvester) te); }
        break;
        case GUI_INDEX_BLOCKMINER:
          if (te instanceof TileEntityBlockMiner) { return new GuiBlockMiner(player.inventory, (TileEntityBlockMiner) te); }
        break;
        case GUI_INDEX_STORAGE:
          ItemStack s = ItemStorageBag.getPlayerItemIfHeld(player);
          return new GuiStorage(new ContainerStorage(player, player.inventory, new InventoryStorage(player, s)));
        case GUI_INDEX_WAYPOINT:
          return new GuiEnderBook(player, UtilPlayer.getPlayerItemIfHeld(player));
        case GUI_INDEX_BUILDER:
          if (te != null && te instanceof TileEntityStructureBuilder) { return new GuiBuilder(player.inventory, (TileEntityStructureBuilder) te); }
        break;
        case GUI_INDEX_PLACER:
          if (te != null && te instanceof TileEntityPlacer) { return new GuiPlacer(player.inventory, (TileEntityPlacer) te); }
        break;
        case GUI_INDEX_PASSWORD:
          if (te != null && te instanceof TileEntityPassword) { return new GuiPassword((TileEntityPassword) te); }
        break;
        case GUI_INDEX_SMARTMINER:
          if (te != null && te instanceof TileEntityControlledMiner) { return new GuiMinerSmart(player.inventory, (TileEntityControlledMiner) te); }
        break;
        case GUI_INDEX_FISHER:
          if (te != null && te instanceof TileEntityFishing) { return new GuiFisher(player.inventory, (TileEntityFishing) te); }
        break;
        case GUI_INDEX_USER:
          if (te != null && te instanceof TileEntityUser) { return new GuiUser(player.inventory, (TileEntityUser) te); }
        break;
        case GUI_INDEX_PATTERN:
          if (te != null && te instanceof TileEntityPatternBuilder) { return new GuiPattern(player.inventory, (TileEntityPatternBuilder) te); }
        break;
        case GUI_INDEX_DETECTOR:
          if (te != null && te instanceof TileEntityDetector) { return new GuiDetector(player.inventory, (TileEntityDetector) te); }
        break;
        case GUI_INDEX_VECTOR:
          if (te != null && te instanceof TileEntityVector) { return new GuiVector(player.inventory, (TileEntityVector) te); }
        break;
        case GUI_INDEX_VILLAGER:
          EntityVillager v = (EntityVillager) UtilEntity.getClosestEntity(world, player, UtilEntity.getVillagers(world, p, ItemMerchantAlmanac.radius));
          if (v != null) { return new GuiMerchantBetter(player.inventory, v, new InventoryMerchantBetter(player, v), world); }
        break;
        case GUI_INDEX_FAN:
          if (te != null && te instanceof TileEntityFan) { return new GuiFan(player.inventory, (TileEntityFan) te); }
        break;
        case GUI_INDEX_XP:
          if (te instanceof TileEntityXpPylon) { return new GuiPylon(player.inventory, (TileEntityXpPylon) te); }
        break;
        case GUI_INDEX_DISENCH:
          if (te instanceof TileEntityDisenchanter) { return new GuiDisenchanter(player.inventory, (TileEntityDisenchanter) te); }
        break;
        case GUI_INDEX_CRAFTER:
          if (te instanceof TileEntityCrafter) { return new GuiCrafter(player.inventory, (TileEntityCrafter) te); }
        break;
        case GUI_INDEX_WORKBENCH:
          if (te instanceof TileEntityWorkbench) { return new GuiWorkbench(player.inventory, (TileEntityWorkbench) te); }
        break;
      }
    }
    return null;
  }
}
