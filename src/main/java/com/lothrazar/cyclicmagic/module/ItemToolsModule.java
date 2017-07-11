package com.lothrazar.cyclicmagic.module;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.ModCyclic;
import com.lothrazar.cyclicmagic.component.cyclicwand.InventoryWand;
import com.lothrazar.cyclicmagic.component.cyclicwand.ItemCyclicWand;
import com.lothrazar.cyclicmagic.component.cyclicwand.PacketSpellShiftLeft;
import com.lothrazar.cyclicmagic.component.cyclicwand.PacketSpellShiftRight;
import com.lothrazar.cyclicmagic.data.Const;
import com.lothrazar.cyclicmagic.item.ItemBuildSwapper;
import com.lothrazar.cyclicmagic.item.ItemBuildSwapper.ActionType;
import com.lothrazar.cyclicmagic.item.ItemBuildSwapper.WandType;
import com.lothrazar.cyclicmagic.net.PacketSwapBlock;
import com.lothrazar.cyclicmagic.registry.GuideRegistry.GuideCategory;
import com.lothrazar.cyclicmagic.registry.ItemRegistry;
import com.lothrazar.cyclicmagic.registry.LootTableRegistry;
import com.lothrazar.cyclicmagic.registry.LootTableRegistry.ChestType;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import com.lothrazar.cyclicmagic.registry.SoundRegistry;
//import com.lothrazar.cyclicmagic.registry.SpellHud;
import com.lothrazar.cyclicmagic.registry.SpellRegistry;
import com.lothrazar.cyclicmagic.spell.ISpell;
import com.lothrazar.cyclicmagic.util.UtilSound;
import com.lothrazar.cyclicmagic.util.UtilSpellCaster;
import com.lothrazar.cyclicmagic.util.UtilTextureRender;
import com.lothrazar.cyclicmagic.util.UtilWorld;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemToolsModule extends BaseEventModule implements IHasConfig {
  private static SpellHud spellHud;
  //  public static ItemStorageBag storage_bag;//ref by ContainerStorage
  public static RenderLoc renderLocation;
  /**
   * BIG thank you to this MIT licensed source code
   * 
   * https://github.com/romelo333/notenoughwands1.8.8/blob/2fee100fe9441828eb54dc7ec6a233c9b278e753/src/main/java/romelo333/notenoughwands/proxy/ClientProxy.java
   * 
   * @param evt
   */
  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public void renderOverlay(RenderWorldLastEvent evt) {
    Minecraft mc = Minecraft.getMinecraft();
    EntityPlayerSP p = mc.player;
    ItemStack heldItem = p.getHeldItemMainhand();
    if (heldItem == null) { return; }
    if (heldItem.getItem() instanceof ItemBuildSwapper) {
      RayTraceResult mouseOver = Minecraft.getMinecraft().objectMouseOver;
      if (mouseOver != null && mouseOver.getBlockPos() != null && mouseOver.sideHit != null) {
        IBlockState state = p.world.getBlockState(mouseOver.getBlockPos());
        Block block = state.getBlock();
        if (block != null && block.getMaterial(state) != Material.AIR) {
          ItemBuildSwapper wandInstance = (ItemBuildSwapper) heldItem.getItem();
          IBlockState matched = null;
          if (wandInstance.getWandType() == WandType.MATCH) {
            matched = p.getEntityWorld().getBlockState(mouseOver.getBlockPos());
          }
          List<BlockPos> places = PacketSwapBlock.getSelectedBlocks(p.getEntityWorld(), mouseOver.getBlockPos(),
              ActionType.values()[ActionType.get(heldItem)], wandInstance.getWandType(),
              mouseOver.sideHit, matched);
          Set<BlockPos> coordinates = new HashSet<BlockPos>(places);
          UtilWorld.OutlineRenderer.renderOutlines(evt, p, coordinates, 75, 0, 130);
        }
      }
    }
  }
  @Override
  public void onPreInit() {
    spellHud = new SpellHud();
    ModCyclic.instance.events.register(this);
  }
  @Override
  public void syncConfig(Configuration config) {
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
  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public void onMouseInput(MouseEvent event) {
    EntityPlayer player = Minecraft.getMinecraft().player;
    if (!player.isSneaking() || event.getDwheel() == 0) { return; }
    ItemStack wand = UtilSpellCaster.getPlayerWandIfHeld(player);
    if (wand.isEmpty()) { return; }
    //if theres only one spell, do nothing
    if (SpellRegistry.getSpellbook(wand) == null || SpellRegistry.getSpellbook(wand).size() <= 1) { return; }
    if (event.getDwheel() < 0) {
      ModCyclic.network.sendToServer(new PacketSpellShiftRight());
      event.setCanceled(true);
      UtilSound.playSound(player, player.getPosition(), SoundRegistry.bip);
    }
    else if (event.getDwheel() > 0) {
      ModCyclic.network.sendToServer(new PacketSpellShiftLeft());
      event.setCanceled(true);
      UtilSound.playSound(player, player.getPosition(), SoundRegistry.bip);
    }
  }
  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public void onRenderTextOverlay(RenderGameOverlayEvent.Text event) {
    ItemStack wand = UtilSpellCaster.getPlayerWandIfHeld(Minecraft.getMinecraft().player);
    // special new case: no hud for this type
    if (!wand.isEmpty()) {
      spellHud.drawSpellWheel(wand);
    }
  }
  @SideOnly(Side.CLIENT)
  @SubscribeEvent(priority = EventPriority.LOWEST)
  public void onRender(RenderGameOverlayEvent.Post event) {
    if (event.isCanceled() || event.getType() != ElementType.EXPERIENCE) { return; }
    EntityPlayer effectivePlayer = Minecraft.getMinecraft().player;
    ItemStack heldWand = UtilSpellCaster.getPlayerWandIfHeld(effectivePlayer);
    if (heldWand.isEmpty()) { return; }
    int itemSlot = ItemCyclicWand.BuildType.getSlot(heldWand);
    ItemStack current = InventoryWand.getFromSlot(heldWand, itemSlot);
    if (!current.isEmpty()) {
      //THE ITEM INSIDE THE BUILDY WHEEL
      int leftOff = 7, rightOff = -26, topOff = 36, bottOff = -2;
      int xmain = RenderLoc.locToX(ItemToolsModule.renderLocation, leftOff, rightOff);
      int ymain = RenderLoc.locToY(ItemToolsModule.renderLocation, topOff, bottOff);
      ModCyclic.proxy.renderItemOnScreen(current, xmain, ymain);
      //      ModCyclic.proxy.renderItemOnScreen(current, RenderLoc.xoffset - 1, RenderLoc.ypadding + RenderLoc.spellSize * 2);
    }
  }
  //TODO: refactor this
  public static enum RenderLoc {
    TOPLEFT, TOPRIGHT, BOTTOMLEFT, BOTTOMRIGHT;
    private static final int yPadding = 6;
    private static final int xPadding = 6;//was 30 if manabar is showing
    private static final int spellSize = 16;
    @SideOnly(Side.CLIENT)
    public static int locToX(RenderLoc loc, int leftOffset, int rightOffset) {
      ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
      switch (loc) {
        case BOTTOMLEFT:
        case TOPLEFT:
          return RenderLoc.xPadding + leftOffset;
        case BOTTOMRIGHT:
        case TOPRIGHT:
          return res.getScaledWidth() - RenderLoc.xPadding + rightOffset;
      }
      return 0;
    }
    @SideOnly(Side.CLIENT)
    public static int locToY(RenderLoc loc, int topOffset, int bottomOffset) {
      ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
      switch (ItemToolsModule.renderLocation) {
        case BOTTOMLEFT:
        case BOTTOMRIGHT:
          return res.getScaledHeight() - RenderLoc.spellSize - RenderLoc.yPadding + bottomOffset;
        case TOPLEFT:
        case TOPRIGHT:
          return RenderLoc.yPadding + topOffset;
        default:
        break;
      }
      return 0;
    }
  }
  private class SpellHud {
    private int ymain = RenderLoc.yPadding;
    private int xmain;
    @SideOnly(Side.CLIENT)
    public void drawSpellWheel(ItemStack wand) {
      int leftOff = 8, rightOff = -26, topOff = 0, bottOff = -38;
      xmain = RenderLoc.locToX(ItemToolsModule.renderLocation, leftOff, rightOff);
      ymain = RenderLoc.locToY(ItemToolsModule.renderLocation, topOff, bottOff);
      EntityPlayer player = Minecraft.getMinecraft().player;
      if (SpellRegistry.getSpellbook(wand) == null || SpellRegistry.getSpellbook(wand).size() <= 1) { return; }
      ISpell spellCurrent = UtilSpellCaster.getPlayerCurrentISpell(player);
      //if theres only one spell, do not do the rest eh
      drawCurrentSpell(player, spellCurrent);
      drawNextSpells(player, spellCurrent);
      drawPrevSpells(player, spellCurrent);
    }
    private void drawCurrentSpell(EntityPlayer player, ISpell spellCurrent) {
      UtilTextureRender.drawTextureSquare(spellCurrent.getIconDisplay(), xmain, ymain, RenderLoc.spellSize);
    }
    private void drawPrevSpells(EntityPlayer player, ISpell spellCurrent) {
      ItemStack wand = UtilSpellCaster.getPlayerWandIfHeld(player);
      ISpell prev = SpellRegistry.prev(wand, spellCurrent);
      if (prev != null) {
        int x = xmain + 9;
        int y = ymain + RenderLoc.spellSize;
        int dim = RenderLoc.spellSize / 2;
        UtilTextureRender.drawTextureSquare(prev.getIconDisplay(), x, y, dim);
        prev = SpellRegistry.prev(wand, prev);
        if (prev != null) {
          x += 5;
          y += 14;
          dim -= 2;
          UtilTextureRender.drawTextureSquare(prev.getIconDisplay(), x, y, dim);
          prev = SpellRegistry.prev(wand, prev);
          if (prev != null) {
            x += 3;
            y += 10;
            dim -= 2;
            UtilTextureRender.drawTextureSquare(prev.getIconDisplay(), x, y, dim);
            prev = SpellRegistry.prev(wand, prev);
            if (prev != null) {
              x += 2;
              y += 10;
              dim -= 1;
              UtilTextureRender.drawTextureSquare(prev.getIconDisplay(), x, y, dim);
            }
          }
        }
      }
    }
    private void drawNextSpells(EntityPlayer player, ISpell spellCurrent) {
      ItemStack wand = UtilSpellCaster.getPlayerWandIfHeld(player);
      ISpell next = SpellRegistry.next(wand, spellCurrent);
      if (next != null) {
        int x = xmain - 5;
        int y = ymain + RenderLoc.spellSize;
        int dim = RenderLoc.spellSize / 2;
        UtilTextureRender.drawTextureSquare(next.getIconDisplay(), x, y, dim);
        ISpell next2 = SpellRegistry.next(wand, next);
        if (next2 != null) {
          x -= 2;
          y += 14;
          dim -= 2;
          UtilTextureRender.drawTextureSquare(next2.getIconDisplay(), x, y, dim);
          ISpell next3 = SpellRegistry.next(wand, next2);
          if (next3 != null) {
            x -= 2;
            y += 10;
            dim -= 2;
            UtilTextureRender.drawTextureSquare(next3.getIconDisplay(), x, y, dim);
            ISpell next4 = SpellRegistry.next(wand, next3);
            if (next4 != null) {
              x -= 2;
              y += 10;
              dim -= 1;
              UtilTextureRender.drawTextureSquare(next4.getIconDisplay(), x, y, dim);
            }
          }
        }
      }
    }
  }
}
