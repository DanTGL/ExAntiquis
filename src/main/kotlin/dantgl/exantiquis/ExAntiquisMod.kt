package dantgl.exantiquis

import dantgl.exantiquis.blocks.BlockBarrel
import dantgl.exantiquis.blocks.BlockSieve
import dantgl.exantiquis.blocks.renderers.TileEntityRendererBarrel
import dantgl.exantiquis.blocks.renderers.TileEntityRendererSieve
import dantgl.exantiquis.blocks.tileentities.TileEntityBarrel
import dantgl.exantiquis.blocks.tileentities.TileEntitySieve
import dantgl.exantiquis.registries.SieveRegistry
import net.fabricmc.api.ModInitializer
import net.minecraft.core.block.Block
import net.minecraft.core.block.material.Material
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import turniplabs.halplibe.helper.BlockBuilder
import turniplabs.halplibe.helper.EntityHelper

object ExAntiquisMod: ModInitializer {
	@JvmField
	val MODID: String = "examplemod"

	@JvmField
	val LOGGER: Logger = LoggerFactory.getLogger(MODID)

	val blockBarrel: Block = BlockBuilder(MODID)
		.build(BlockBarrel("barrel", 1001, Material.wood))

	val blockSieve: Block = BlockBuilder(MODID)
		.build((BlockSieve("sieve", 1002, Material.wood)))

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!")


		EntityHelper.createSpecialTileEntity(TileEntityBarrel::class.java, TileEntityRendererBarrel(), "Barrel")
		EntityHelper.createSpecialTileEntity(TileEntitySieve::class.java, TileEntityRendererSieve(), "Sieve")

		SieveRegistry.registerRewards()
	}

}
