package dantgl.exantiquis.blocks.models

import net.minecraft.client.render.Tessellator
import net.minecraft.core.Global
import org.lwjgl.opengl.GL11
import java.awt.Color

object ModelSieveContents {

	fun render(color: Color, blend: Boolean, textureIndex: Int, tileWidth: Int) {
		val tessellator = Tessellator.instance

		val minU =
			((textureIndex % Global.TEXTURE_ATLAS_WIDTH_TILES * tileWidth).toFloat() + 0.0f) / (Global.TEXTURE_ATLAS_WIDTH_TILES * tileWidth).toDouble()
		val maxU =
			(((textureIndex % Global.TEXTURE_ATLAS_WIDTH_TILES * tileWidth).toFloat() + (tileWidth.toFloat() - 0.01f)) / (Global.TEXTURE_ATLAS_WIDTH_TILES * tileWidth).toFloat()).toDouble()
		val minV =
			(((textureIndex / Global.TEXTURE_ATLAS_WIDTH_TILES * tileWidth).toFloat() + 0.0f) / (Global.TEXTURE_ATLAS_WIDTH_TILES * tileWidth).toFloat()).toDouble()
		val maxV =
			(((textureIndex / Global.TEXTURE_ATLAS_WIDTH_TILES * tileWidth).toFloat() + (tileWidth.toFloat() - 0.01f)) / (Global.TEXTURE_ATLAS_WIDTH_TILES * tileWidth).toFloat()).toDouble()

		if (blend) {
			GL11.glDisable(GL11.GL_LIGHTING)
			GL11.glEnable(GL11.GL_BLEND)
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
		}

		val length = 0.85
		val width = 0.85
		val x = -(width / 2)
		val y = 0.0
		val z = -(length / 2)

		tessellator.startDrawingQuads()
		tessellator.setColorRGBA(color.red, color.green, color.blue, color.alpha)
		tessellator.addVertexWithUV(x + width, y, z + length, minU, minV);
		tessellator.addVertexWithUV(x + width, y, z, minU, maxV);
		tessellator.addVertexWithUV(x , y, z, maxU, maxV);
		tessellator.addVertexWithUV(x, y, z + length, maxU, minV);
		tessellator.draw();

		if (blend) {
			GL11.glEnable(GL11.GL_LIGHTING)
			GL11.glDisable(GL11.GL_BLEND)
		}
	}

}
