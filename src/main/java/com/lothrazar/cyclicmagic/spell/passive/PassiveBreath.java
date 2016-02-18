package com.lothrazar.cyclicmagic.spell.passive;

import com.lothrazar.cyclicmagic.Const;
import com.lothrazar.cyclicmagic.PotionRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;

public class PassiveBreath implements IPassiveSpell{

	private final static int SECONDS = 60;
	private final static float AIRLIMIT = 150;// 300 is a full bar

	@Override
	public boolean canTrigger(EntityPlayer entity){

		return (entity.getAir() <= AIRLIMIT) && (entity.isPotionActive(Potion.waterBreathing) == false);
	}

	@Override
	public void trigger(EntityPlayer entity){

		PotionRegistry.addOrMergePotionEffect(entity, new PotionEffect(Potion.waterBreathing.id, SECONDS * Const.TICKS_PER_SEC));
		PotionRegistry.addOrMergePotionEffect(entity, new PotionEffect(Potion.nightVision.id, SECONDS * Const.TICKS_PER_SEC));
	}

	@Override
	public int getID(){

		return 0;
	}

	@Override
	public String getName(){

		return StatCollector.translateToLocal("spellpassive.breath.name");
	}

	@Override
	public String getInfo(){

		return StatCollector.translateToLocal("spellpassive.breath.info");
	}
}