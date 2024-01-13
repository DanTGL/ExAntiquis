package dantgl.exantiquis.blocks;

import dantgl.exantiquis.blocks.tileentities.TileEntityBarrel
import net.minecraft.core.block.BlockTileEntity
import net.minecraft.core.block.entity.TileEntity
import net.minecraft.core.block.material.Material

class BlockBarrel(key: String, id: Int, material: Material): BlockTileEntity(key, id, material) {

	override fun getRenderBlockPass(): Int {
		return 2
	}

	override fun renderAsNormalBlock(): Boolean {
		return false
	}

	override fun isOpaqueCube(): Boolean {
		return false
	}


	override fun getNewBlockEntity(): TileEntity {
		try {
			return TileEntityBarrel()
		} catch (e: Exception) {
			throw RuntimeException(e)
		}
	}
}
