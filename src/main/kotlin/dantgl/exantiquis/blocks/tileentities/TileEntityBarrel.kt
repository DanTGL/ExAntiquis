package dantgl.exantiquis.blocks.tileentities

import net.minecraft.core.block.BlockFluid
import net.minecraft.core.block.entity.TileEntity
import java.awt.Color

class TileEntityBarrel: TileEntity() {

	enum class BarrelMode {
		EMPTY,
		WATER,
		COMPOST,
		DIRT,
		CLAY,
	}

	private var volume = 0.0f;
	private var timer = 0;
	var color = Color.WHITE;
	private var colorBase = color;
	var textureIndex = 0;

	private var isDirty = false;
	private var updateTimer = 0;
	private var barrelMode = BarrelMode.EMPTY;

	override fun updateEntity() {

		super.updateEntity()

		BlockFluid.fluidLavaStill
	}

	fun GetMode(): BarrelMode {
		return barrelMode
	}
}
