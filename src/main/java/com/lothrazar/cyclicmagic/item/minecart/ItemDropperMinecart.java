package com.lothrazar.cyclicmagic.item.minecart;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.entity.EntityMinecartDropper;
import com.lothrazar.cyclicmagic.item.base.BaseItemMinecart;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ItemDropperMinecart extends BaseItemMinecart implements IHasRecipe {
  public ItemDropperMinecart() {
    super();
  }

  @Override
  public boolean isHidden() {
    return RecipeRegistry.hiddenItems.contains(this);
  }
  @Override
  public EntityMinecart summonMinecart(World world) {
    return new EntityMinecartDropper(world);
  }
  @Override
  public EntityMinecart summonMinecart(World world, double x, double y, double z) {
    return new EntityMinecartDropper(world, x, y, z);
  }
}
