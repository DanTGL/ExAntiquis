package dantgl.exantiquis.blocks.models

import net.minecraft.client.render.model.Cube

class ModelBarrel {
	private val bottom: Cube
	private val side1: Cube
	private val side2: Cube
	private val side3: Cube
	private val side4: Cube

	constructor() {
		val textureWidth = 128
		val textureHeight = 128

		bottom = Cube(0, 0, textureWidth, textureHeight);
		bottom.addBox(-7f, 0f, -7f, 14, 1, 14)
		bottom.setRotationPoint(0f, 23f, 0f)
		bottom.mirror = true

		setRotation(bottom, 0f, 0f, 0f)

		side1 = Cube(0, 16, textureWidth, textureHeight)
		side1.addBox(-8f, -8f, 0f, 16, 16, 1)
		side1.setRotationPoint(0f, 16f, 7f)
		side1.mirror = true
		setRotation(side1, 0f, 0f, 0f)

		side2 = Cube(0, 34, textureWidth, textureHeight)
		side2.addBox(-8f, -8f, 0f, 16, 16, 1)
		side2.setRotationPoint(0f, 16f, -8f)
		side2.mirror = true
		setRotation(side2, 0f, 0f, 0f)

		side3 = Cube(35, 16, textureWidth, textureHeight)
		side3.addBox(0f, -8f, -7f, 1, 16, 14)
		side3.setRotationPoint(-8f, 16f, 0f)
		side3.mirror = true
		setRotation(side3, 0f, 0f, 0f)

		side4 = Cube(66, 16, textureWidth, textureHeight)
		side4.addBox(0f, -8f, -7f, 1, 16, 14)
		side4.setRotationPoint(7f, 16f, 0f)
		side4.mirror = true
		setRotation(side4, 0f, 0f, 0f)
	}

	fun render() {
		simpleRender(0.0625f)
	}

	private fun simpleRender(scale: Float) {
		bottom.render(scale)
		side1.render(scale)
		side2.render(scale)
		side3.render(scale)
		side4.render(scale)
	}

	private inline fun setRotation(model: Cube, x: Float, y: Float, z: Float) {
		model.rotateAngleX = x
		model.rotateAngleY = y
		model.rotateAngleZ = z
	}


}
