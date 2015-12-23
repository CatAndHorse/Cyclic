package com.lothrazar.cyclicmagic.gui;

import com.lothrazar.cyclicmagic.Const;
import com.lothrazar.cyclicmagic.PlayerPowerups;
import com.lothrazar.cyclicmagic.SpellRegistry;
import com.lothrazar.cyclicmagic.spell.ISpell;
import com.lothrazar.cyclicmagic.util.UtilTextureRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSpellbook extends GuiScreen {

	private final EntityPlayer entityPlayer;
	private final static ResourceLocation background = new ResourceLocation(Const.MODID, "textures/gui/spellbook.png");

	// https://github.com/LothrazarMinecraftMods/EnderBook/blob/66363b544fe103d6abf9bcf73f7a4051745ee982/src/main/java/com/lothrazar/enderbook/GuiEnderBook.java
	private int xCenter;
	private int yCenter;
	private int radius;
	private double arc;
	PlayerPowerups props;

	public GuiSpellbook(EntityPlayer p) {
		
		super();
		this.entityPlayer = p;
		this.props = PlayerPowerups.get(entityPlayer);
	}

	@Override
	public void initGui() {

		super.initGui();
		
		
		xCenter = this.width / 2;
		yCenter = this.height / 2;
		radius = xCenter / 3 + 26;
		// TODO: buttons to add/remove each spell from player rotation

		arc = (2 * Math.PI) / SpellRegistry.getSpellbook().size();

		//drawCenteredString(fontRendererObj, "Add or remove spells from active wheel",xCenter, yCenter, FONT);
		GuiButton c = new GuiButton(999,  xCenter, yCenter,20,20,  "test");
		this.buttonList.add(c);

		double ang = 0;
		double cx, cy;

		ang = 0;
		GuiButtonSpell b;
		// int spellSize = 16;
		for (ISpell s : SpellRegistry.getSpellbook()) {

			cx = xCenter + radius * Math.cos(ang) - 2;
			cy = yCenter + radius * Math.sin(ang) - 2;

			// int buttonId, int x, int y, int widthIn, int heightIn, String
			// buttonText)
			b = new GuiButtonSpell((int) cx, (int) cy, s);
			this.buttonList.add(b);

			/*
			 * UtilTextureRender.drawTextureSquare(s.getIconDisplay(), (int)cx,
			 * (int)cy, spellSize);
			 * 
			 * if (s.getID() == props.getSpellCurrent()) { //TODO: mark current
			 * spell with a highlight or some circle texture or something
			 * drawCenteredString(fontRendererObj, "current", (int)cx, (int)cy, FONT);
			 * }
			 */
			ang += arc;
		}
	}

	int textureWidth = 200;
	int textureHeight = 180;
	@Override
	public void drawBackground(int tint)
    {
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());

		int screenWidth = res.getScaledWidth();
		int screenHeight = res.getScaledHeight();

		int guiLeft = screenWidth/2 - textureWidth/2;
		int guiTop = screenHeight/2 - textureHeight/2;
		
		UtilTextureRender.drawTextureSimple(background,guiLeft,guiTop, 200,200);
    }
	private final static ResourceLocation ptr = new ResourceLocation(Const.MODID, "textures/spells/exp_cost_dummy.png");
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		//this.drawBackground(1); //turn this on if we want 'background' on
		super.drawScreen(mouseX, mouseY, partialTicks);
		double ang = 0;
		double cx, cy;

 //TODO: move this to btn class as well ??
		int spellSize = 16;
		UtilTextureRender.drawTextureSquare(ptr, mouseX-8,mouseY-8, spellSize);
		for (ISpell s : SpellRegistry.getSpellbook()) {

			cx = xCenter + radius * Math.cos(ang);
			cy = yCenter + radius * Math.sin(ang);

			//TODO: move this to btn class as well? but it would need access to the player props
			ResourceLocation header; 
			if(props.isSpellUnlocked(s.getID())){// TODO: do we want different icons for these
				header = s.getIconDisplayHeaderEnabled();
			}
			else{
				header = s.getIconDisplayHeaderDisabled();
			}
			UtilTextureRender.drawTextureSimple(header, (int) cx+1, (int) cy-6, spellSize-2,spellSize-4);
			
			ang += arc;
		}
	
		GuiButtonSpell btn;
		for (int i = 0; i < buttonList.size(); i++) {
			if (buttonList.get(i).isMouseOver()  && buttonList.get(i) instanceof GuiButtonSpell) {
				btn = (GuiButtonSpell) buttonList.get(i);
			
				drawHoveringText(btn.getTooltipForPlayer(props), mouseX, mouseY, fontRendererObj);
				break;//cant hover on 2 at once
			}
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}