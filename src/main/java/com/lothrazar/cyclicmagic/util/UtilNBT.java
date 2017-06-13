package com.lothrazar.cyclicmagic.util;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

public class UtilNBT {
  public static String posToStringCSV(BlockPos position) {
    if (position == null) { return ""; }
    return position.getX() + "," + position.getY() + "," + position.getZ();
  }
  public static void setItemStackBlockPos(ItemStack item, BlockPos pos) {
    UtilNBT.setItemStackNBTVal(item, "xpos", pos.getX());
    UtilNBT.setItemStackNBTVal(item, "ypos", pos.getY());
    UtilNBT.setItemStackNBTVal(item, "zpos", pos.getZ());
  }
  public static BlockPos getItemStackBlockPos(ItemStack item) {
    if (item.getTagCompound() == null
        || !item.getTagCompound().hasKey("xpos")) { return null; }
    return new BlockPos(getItemStackNBTVal(item, "xpos"), getItemStackNBTVal(item, "ypos"), getItemStackNBTVal(item, "zpos"));
  }
  public static void setItemStackNBTVal(ItemStack item, String prop, int value) {
    if (item == ItemStack.EMPTY) { return; }
    if (item.getTagCompound() == null) {
      item.setTagCompound(new NBTTagCompound());
    }
    item.getTagCompound().setInteger(prop, value);
  }
  public static int getItemStackNBTVal(ItemStack held, String prop) {
    if (held == ItemStack.EMPTY) { return 0; }
    NBTTagCompound tags = getItemStackNBT(held);
    if (!tags.hasKey(prop)) { return 0; }
    return tags.getInteger(prop);
  }
  /**
   * empty string if null or empty, otherwise the value in string form for
   * tooltips
   * 
   * @param held
   * @param prop
   * @return
   */
  public static String getItemStackDisplayInteger(ItemStack held, String prop) {
    if (held == ItemStack.EMPTY) { return ""; }
    NBTTagCompound tags = getItemStackNBT(held);
    if (!tags.hasKey(prop)) { return ""; }
    return tags.getInteger(prop) + "";
  }
  public static NBTTagCompound getItemStackNBT(ItemStack held) {
    if (held.getTagCompound() == null) {
      held.setTagCompound(new NBTTagCompound());
    }
    return held.getTagCompound();
  }
  public static BlockPos stringCSVToBlockPos(String csv) {
    String[] spl = csv.split(",");
    // on server i got java.lang.ClassCastException: java.lang.String cannot
    // be cast to java.lang.Integer
    // ?? is it from this?
    BlockPos p = null;
    try {
      if (spl != null && spl.length == 3 && spl[0] != "")
        p = new BlockPos(Integer.parseInt(spl[0]), Integer.parseInt(spl[1]), Integer.parseInt(spl[2]));
    }
    catch (java.lang.ClassCastException e) {
      //      ModCyclic.logger.info("exc: bad string: " + csv);
    }
    return p;
  }
  public static void incrementPlayerIntegerNBT(EntityPlayer player, String prop, int inc) {
    int prev = player.getEntityData().getInteger(prop);
    prev += inc;
    player.getEntityData().setInteger(prop, prev);
  }
  public static void writeTagsToInventory(IInventory invo, NBTTagCompound tags, String key) {
    NBTTagList items = tags.getTagList(key, tags.getId());
    ItemStack stack;
    int slot;
    for (int i = 0; i < items.tagCount(); ++i) {
      // tagAt(int) has changed to getCompoundTagAt(int)
      NBTTagCompound item = items.getCompoundTagAt(i);
      stack = UtilNBT.itemFromNBT(item);
      slot = item.getInteger("slot");
      // list.add(ItemStack.loadItemStackFromNBT(item));
      invo.setInventorySlotContents(slot, stack);
    }
  }
  public static NBTTagCompound writeInventoryToTag(IInventory invo, NBTTagCompound returnTag, String key) {
    ItemStack chestItem;
    NBTTagCompound itemTag;
    NBTTagList nbttaglist = new NBTTagList();
    for (int i = 0; i < invo.getSizeInventory(); i++) {
      // zeroes to avoid nulls, and signify nothing goes there
      chestItem = invo.getStackInSlot(i);
      if (chestItem == ItemStack.EMPTY || chestItem.getCount() == 0) {
        continue;
      } // not an error; empty chest slot
      itemTag = chestItem.writeToNBT(new NBTTagCompound());
      itemTag.setInteger("slot", i);
      nbttaglist.appendTag(itemTag);
      // its either in the bag, or dropped on the player
      invo.setInventorySlotContents(i, ItemStack.EMPTY);
    }
    returnTag.setTag(key, nbttaglist);
    return returnTag;
  }
  public static NBTTagCompound writeInventoryToNewTag(IInventory invo, String key) {
    return writeInventoryToTag(invo, new NBTTagCompound(), key);
  }
  public static int countItemsFromNBT(NBTTagCompound tags, String key) {
    if (tags == null) { return 0; }
    NBTTagList items = tags.getTagList(key, tags.getId());
    if (items == null) { return 0; }
    return items.tagCount();
  }
  public static ArrayList<ItemStack> readItemsFromNBT(NBTTagCompound tags, String key) {
    ArrayList<ItemStack> list = new ArrayList<ItemStack>();
    NBTTagList items = tags.getTagList(key, tags.getId());
    for (int i = 0; i < items.tagCount(); ++i) {
      // tagAt(int) has changed to getCompoundTagAt(int)
      NBTTagCompound item = items.getCompoundTagAt(i);
      list.add(UtilNBT.itemFromNBT(item));
    }
    return list;
  }
  public static ItemStack enchantItem(Item item, Enchantment ench, short level) {
    ItemStack stack = new ItemStack(item);
    stack.addEnchantment(ench, level);
    return stack;
  }
  public static ItemStack buildEnchantedBook(Enchantment ench, short level) {
    ItemStack stack = new ItemStack(Items.ENCHANTED_BOOK);
    //NOT THIS: if you are putting it on a normal stack (sword/weapon) yeah then that way
    //		stack.addEnchantment(ench, level);
    Items.ENCHANTED_BOOK.addEnchantment(stack, new EnchantmentData(ench, level));
    //just to test it
    return stack;
  }
  public static ItemStack buildEnchantedNametag(String customNameTag) {
    // build multi-level NBT tag so it matches a freshly enchanted one
    ItemStack nameTag = new ItemStack(Items.NAME_TAG, 1);
    NBTTagCompound nbt = new NBTTagCompound();
    NBTTagCompound display = new NBTTagCompound();
    display.setString("Name", customNameTag);// NOT "CustomName" implied by
    // commandblocks/google
    nbt.setTag("display", display);
    nbt.setInteger("RepairCost", 1);
    nameTag.setTagCompound(nbt);// put the data into the item stack
    return nameTag;
  }
  public static ItemStack buildNamedPlayerSkull(EntityPlayer player) {
    return buildNamedPlayerSkull(player.getDisplayNameString());
  }
  public static ItemStack buildNamedPlayerSkull(String displayNameString) {
    ItemStack skull = new ItemStack(Items.SKULL, 1, Const.skull_player);
    if (skull.getTagCompound() == null) {
      skull.setTagCompound(new NBTTagCompound());
    }
    skull.getTagCompound().setString(Const.SkullOwner, displayNameString);
    return skull;
  }
  public static ItemStack itemFromNBT(NBTTagCompound tag) {
    return new ItemStack(tag);
  }
  public static void writeBlockPosAt(NBTTagCompound tags, String key, BlockPos val) {
    tags.setString(key, posToStringCSV(val));
  }
  public static BlockPos readBlockPosAt(NBTTagCompound tags, String key) {
    return stringCSVToBlockPos(tags.getString(key));
  }
  public static NBTTagCompound writeBlockPos(List<BlockPos> actuallyDestroyed) {
    NBTTagCompound tags = new NBTTagCompound();
    int i = 0;
    for (BlockPos p : actuallyDestroyed) {
      writeBlockPosAt(tags, i + "", p);
      i++;
    }
    tags.setInteger("max", i);
    return tags;
  }
  public static List<BlockPos> readBlockPos(NBTTagCompound tags) {
    List<BlockPos> pos = new ArrayList<BlockPos>();
    int max = tags.getInteger("max");
    for (int i = 0; i < max; i++) {
      pos.add(readBlockPosAt(tags, i + ""));
    }
    return pos;
  }
}
