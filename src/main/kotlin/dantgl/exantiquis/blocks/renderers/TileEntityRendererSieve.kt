package dantgl.exantiquis.blocks.renderers

import dantgl.exantiquis.blocks.models.ModelSieve
import dantgl.exantiquis.blocks.models.ModelSieveContents
import dantgl.exantiquis.blocks.tileentities.TileEntitySieve
import net.minecraft.client.render.TextureFX
import net.minecraft.client.render.tileentity.TileEntityRenderer
import net.minecraft.core.block.Block
import net.minecraft.core.block.entity.TileEntity
import net.minecraft.core.util.helper.Side
import org.lwjgl.opengl.GL11
import java.awt.Color


class TileEntityRendererSieve: TileEntityRenderer<TileEntitySieve>() {

	val modelContents = ModelSieveContents
	val modelSieve = ModelSieve()

	override fun doRender(sieve: TileEntitySieve, x: Double, y: Double, z: Double, f: Float) {
		renderTable(sieve, x, y, z, f)
		renderContents(sieve, x, y, z, f)
	}

	private fun renderTable(sieve: TileEntitySieve, x: Double, y: Double, z: Double, f: Float) {
		GL11.glPushMatrix()
		GL11.glTranslatef(x.toFloat() + 0.5f, y.toFloat() + 1.5f, z.toFloat() + 0.5f)
		GL11.glScalef(-1f, -1f, 1f)

		loadTexture(ModelSieve.texture)
		modelSieve.simpleRender(0.0625f)
		GL11.glPopMatrix()
	}

	private fun renderContents(sieve: TileEntitySieve, x: Double, y: Double, z: Double, f: Float) {
		if (sieve.mode !== TileEntitySieve.SieveMode.EMPTY) {
			GL11.glPushMatrix();
			GL11.glTranslatef(x.toFloat() + 0.5F, y.toFloat() + sieve.getAdjustedVolume(), z.toFloat() + 0.5F);

			loadTexture("/terrain.png");

			val textureIndex = Block.blocksList[sieve.contentID].getBlockTextureFromSideAndMetadata(Side.TOP, 0);
			//model.simpleRender(0.0625F);
			modelContents.render(Color(255, 255, 255), true, textureIndex, TextureFX.tileWidthTerrain)

			GL11.glPopMatrix();
		}
	}


}
