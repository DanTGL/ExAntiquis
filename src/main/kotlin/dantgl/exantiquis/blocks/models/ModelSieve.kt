package dantgl.exantiquis.blocks.models

import dantgl.exantiquis.data.ModData
import net.minecraft.client.render.model.Cube
import net.minecraft.client.render.model.ModelBase


class ModelSieve: ModelBase {

	private val Leg1: Cube
	private val Leg2: Cube
	private val Leg3: Cube
	private val Leg4: Cube
	private val BoxSide1: Cube
	private val BoxSide2: Cube
	private val BoxSide3: Cube
	private val BoxSide4: Cube

	constructor() {
		Leg1 = Cube(0,  0, 128, 128)
		Leg1.addBox(0f, 0f, 0f, 1, 11, 1)
		Leg1.setRotationPoint(-7f, 13f, -7f)
		Leg1.mirror = true
		setRotation(Leg1, 0f, 0f, 0f)
		Leg2 = Cube(0,  0, 128, 128)
		Leg2.addBox(0f, 0f, 0f, 1, 11, 1)
		Leg2.setRotationPoint(-7f, 13f, 6f)
		Leg2.mirror = true
		setRotation(Leg2, 0f, 0f, 0f)
		Leg3 = Cube(0,  0, 128, 128)
		Leg3.addBox(0f, 0f, 0f, 1, 11, 1)
		Leg3.setRotationPoint(6f, 13f, 6f)
		Leg3.mirror = true
		setRotation(Leg3, 0f, 0f, 0f)
		Leg4 = Cube(0,  0, 128, 128)
		Leg4.addBox(0f, 0f, 0f, 1, 11, 1)
		Leg4.setRotationPoint(6f, 13f, -7f)
		Leg4.mirror = true
		setRotation(Leg4, 0f, 0f, 0f)
		BoxSide1 = Cube(6,  0, 128, 128)
		BoxSide1.addBox(0f, 0f, 0f, 16, 6, 1)
		BoxSide1.setRotationPoint(-8f, 8f, -8f)
		BoxSide1.mirror = true
		setRotation(BoxSide1, 0f, 0f, 0f)
		BoxSide2 = Cube(6,  8, 128, 128)
		BoxSide2.addBox(0f, 0f, 0f, 16, 6, 1)
		BoxSide2.setRotationPoint(-8f, 8f, 7f)
		BoxSide2.mirror = true
		setRotation(BoxSide2, 0f, 0f, 0f)
		BoxSide3 = Cube(6,  16, 128, 128)
		BoxSide3.addBox(0f, 0f, 0f, 1, 6, 14)
		BoxSide3.setRotationPoint(7f, 8f, -7f)
		BoxSide3.mirror = true
		setRotation(BoxSide3, 0f, 0f, 0f)
		BoxSide4 = Cube(6,  37, 128, 128)
		BoxSide4.addBox(0f, 0f, 0f, 1, 6, 14)
		BoxSide4.setRotationPoint(-8f, 8f, -7f)
		BoxSide4.mirror = true
		setRotation(BoxSide4, 0f, 0f, 0f)
	}

	override fun render(f: Float, f1: Float, f2: Float, f3: Float, f4: Float, f5: Float) {
		super.render(f, f1, f2, f3, f4, f5)
		setRotationAngles(f, f1, f2, f3, f4, f5)
		simpleRender(f5)
	}

	fun simpleRender(scale: Float) {
		Leg1.render(scale)
		Leg2.render(scale)
		Leg3.render(scale)
		Leg4.render(scale)
		BoxSide1.render(scale)
		BoxSide2.render(scale)
		BoxSide3.render(scale)
		BoxSide4.render(scale)
	}

	private fun setRotation(model: Cube, x: Float, y: Float, z: Float) {
		model.rotateAngleX = x
		model.rotateAngleY = y
		model.rotateAngleZ = z
	}

	companion object {
		const val texture = "/assets/examplemod/block/ModelSieveOak.png"
	}


}
