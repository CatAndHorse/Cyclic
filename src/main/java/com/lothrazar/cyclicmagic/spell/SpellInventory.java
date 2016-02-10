package com.lothrazar.cyclicmagic.spell;

import com.lothrazar.cyclicmagic.Const;
import com.lothrazar.cyclicmagic.ModMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class SpellInventory extends BaseSpell{

	public SpellInventory(int id, String n) {
		super(id, n);
		this.cost = 0;//so far, the only spell costing zero
	}

	@Override
	public boolean cast(World world, EntityPlayer player, BlockPos pos, EnumFacing side) {
		
		if (! world.isRemote){ 	//TODO: does the isRemote check actually matter
			player.openGui(ModMain.instance, Const.GUI_INDEX, world, 0, 0, 0);
		}
		
		return true;
	}
}
