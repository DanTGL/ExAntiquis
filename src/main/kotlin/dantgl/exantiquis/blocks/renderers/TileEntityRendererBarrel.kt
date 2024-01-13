package dantgl.exantiquis.blocks.renderers

import dantgl.exantiquis.blocks.models.ModelBarrel
import dantgl.exantiquis.blocks.models.ModelBarrelInternal
import dantgl.exantiquis.blocks.tileentities.TileEntityBarrel
import net.minecraft.client.render.RenderBlocks
import net.minecraft.client.render.Tessellator
import net.minecraft.client.render.Texture
import net.minecraft.client.render.TextureFX
import net.minecraft.client.render.tileentity.TileEntityRenderer
import net.minecraft.core.block.Block
import net.minecraft.core.util.helper.Color
import net.minecraft.core.util.helper.Side
import net.minecraft.core.util.helper.Textures
import org.lwjgl.opengl.GL11
import turniplabs.halplibe.helper.TextureHelper

class TileEntityRendererBarrel: TileEntityRenderer<TileEntityBarrel>() {

	private val model: ModelBarrel = ModelBarrel()
	private val contentModel: ModelBarrelInternal = ModelBarrelInternal


	override fun doRender(tileEntity: TileEntityBarrel?, x: Double, y: Double, z: Double, renderPartialTicks: Float) {
		GL11.glPushMatrix()

		val scale = 1.0f
		//Textures.
		//GL11.glTranslated(x, y, z)
		GL11.glTranslatef(x.toFloat() + 0.5f, y.toFloat() + 1.5f, z.toFloat() + 0.5f)
		GL11.glRotated(180.0, 0.0, 0.0, 1.0)
		loadTexture("/assets/examplemod/block/ModelBarrelOak.png")
		val textureIndex = Block.stone.atlasIndices[Side.TOP.id];

		val tessellator = Tessellator.instance;

		this.model.render()

		loadTexture("/terrain.png");
		//tessellator.startDrawingQuads();
		//RenderBlocks().renderTopFace(Block.stone, 0.0, 1.0, 0.0, textureIndex);
		//tessellator.draw();
		GL11.glTranslatef(0.0f, 0.5f, 0.0f);
		GL11.glDisable(GL11.GL_CULL_FACE);
		this.contentModel.render(Color().setRGB(0, 255, 0), true, textureIndex, TextureFX.tileWidthTerrain);
		GL11.glPopMatrix()
	}
}
