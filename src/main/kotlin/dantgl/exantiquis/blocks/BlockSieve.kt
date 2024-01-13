package dantgl.exantiquis.blocks

import dantgl.exantiquis.blocks.tileentities.TileEntitySieve
import dantgl.exantiquis.blocks.tileentities.TileEntitySieve.SieveMode
import dantgl.exantiquis.data.ModData
import dantgl.exantiquis.registries.SieveRegistry.Contains
import net.minecraft.core.block.BlockTileEntity
import net.minecraft.core.block.entity.TileEntity
import net.minecraft.core.block.material.Material
import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.item.block.ItemBlock
import net.minecraft.core.player.gamemode.Gamemode
import net.minecraft.core.world.World
import net.minecraft.server.entity.player.EntityPlayerMP


class BlockSieve(key: String, id: Int, material: Material): BlockTileEntity(key, id, material) {

	var meshIndex: Int = 0

	override fun getNewBlockEntity(): TileEntity {
		return TileEntitySieve()
	}

	override fun getRenderBlockPass(): Int {
		return -1
	}

	override fun isOpaqueCube(): Boolean {
		return false
	}

	override fun renderAsNormalBlock(): Boolean {
		return false
	}

	override fun onBlockClicked(world: World?, x: Int, y: Int, z: Int, player: EntityPlayer?) {
		/*if (player == null) {
			return false;
		}

		println("{x}, {y}, {z}")

		val sieve = world.getBlockTileEntity(x, y, z) as TileEntitySieve

		if (sieve.mode === SieveMode.EMPTY && player.currentEquippedItem != null) {
			val held = player.currentEquippedItem
			if (Contains(held.itemID, held.itemDamageForDisplay)) {
				sieve.addSievable(held.itemID, held.itemDamageForDisplay)
				removeCurrentItem(player)
			}
		} else {
			if (world.isClientSide) {
				sieve.ProcessContents(false)
			} else {
				if (sieve.mode !== SieveMode.EMPTY) {
					//if (isHuman(player)/* || ModData.ALLOW_SIEVE_AUTOMATION*/) {
					sieve.ProcessContents(false)
					//}
				}
			}
		}

		return true*/
	}

	override fun blockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer?): Boolean {

		if (player === null) {
			return false;
		}


		val sieve = world.getBlockTileEntity(x, y, z) as TileEntitySieve
		println("${sieve.getAdjustedVolume()}")

		if (sieve.mode === SieveMode.EMPTY && player.currentEquippedItem !== null) {
			val held = player.currentEquippedItem

			if (held.item is ItemBlock) {

				if (Contains((held.item as ItemBlock).block.id, held.itemDamageForDisplay)) {
					sieve.addSievable((held.item as ItemBlock).block.id, held.itemDamageForDisplay)
					removeCurrentItem(player)
				}
			}
		} else {
			if (world.isClientSide) {
				sieve.ProcessContents(false)
			} else {
				if (sieve.mode !== SieveMode.EMPTY) {
					//if (isHuman(player)/* || ModData.ALLOW_SIEVE_AUTOMATION*/) {
						sieve.ProcessContents(false)
					//}
				}
			}
		}

		return true

	}

	private fun isHuman(player: EntityPlayer): Boolean {
		return player is EntityPlayerMP
	}

	private fun removeCurrentItem(player: EntityPlayer) {
		val item = player.currentEquippedItem

		item.consumeItem(player)
	}

}
