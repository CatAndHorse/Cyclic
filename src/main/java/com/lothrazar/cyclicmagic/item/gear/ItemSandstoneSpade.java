package com.lothrazar.cyclicmagic.item.gear;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.registry.MaterialRegistry;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class ItemSandstoneSpade extends ItemSpade implements IHasRecipe {
  public ItemSandstoneSpade() {
    super(MaterialRegistry.sandstoneToolMaterial);
  }

  @Override
  public boolean isHidden() {
    return RecipeRegistry.hiddenItems.contains(this);
  }
}
