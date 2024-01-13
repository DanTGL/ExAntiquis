package dantgl.exantiquis.blocks.tileentities

import com.mojang.nbt.CompoundTag
import dantgl.exantiquis.registries.SieveRegistry
import dantgl.exantiquis.registries.helpers.SiftReward
import net.minecraft.core.block.entity.TileEntity
import net.minecraft.core.entity.EntityItem
import net.minecraft.core.item.ItemStack
import net.minecraft.core.net.packet.Packet
import net.minecraft.core.net.packet.Packet140TileEntityData
import java.awt.Color


class TileEntitySieve: TileEntity() {



	enum class SieveMode {
		EMPTY,
		FILLED
	}

	var contentID = 0;
	var contentMeta = 0;

	var mode = SieveMode.EMPTY;

	private var volume = 0.0f;

	private var timer = 0
	private var update = false
	private var particleMode = false
	private var timesClicked = 0


	fun addSievable(blockID: Int, blockMeta: Int) {
		this.contentID = blockID
		this.contentMeta = blockMeta

		this.mode = SieveMode.FILLED

		volume = 1.0f
		worldObj.markBlockNeedsUpdate(xCoord, yCoord, zCoord)
	}

	override fun updateEntity() {
		if (worldObj.isClientSide && particleMode) {
			// TODO: Add particles for sifting
			//spawnFX(contentID, contentMeta)
		}

		timer++
		if (timer >= UPDATE_INTERVAL) {
			timesClicked = 0;

			timer = 0;
			// TODO: disableParticles()

			if (update) {
				update();
			}

		}
	}

	fun getVolume(): Float {
		return volume
	}


	fun getAdjustedVolume(): Float {
		val capacity = MAX_RENDER_CAPACITY - MIN_RENDER_CAPACITY
		var adjusted = volume * capacity
		adjusted += MIN_RENDER_CAPACITY
		return adjusted
	}

	fun ProcessContents(creative: Boolean) {
		if (creative) {
			volume = 0f
		} else {
			timesClicked++
			if (timesClicked <= 6) {
				volume -= PROCESSING_INTERVAL
			}
		}
		if (volume <= 0) {
			mode = SieveMode.EMPTY
			//give rewards!
			if (!worldObj.isClientSide) {
				val rewards: ArrayList<SiftReward> = SieveRegistry.getRewards(contentID, contentMeta)
				if (rewards.size > 0) {
					val it: Iterator<SiftReward> = rewards.iterator()
					while (it.hasNext()) {
						val reward: SiftReward = it.next()
						if (worldObj.rand.nextInt(reward.rarity) == 0) {
							val entityitem = EntityItem(
								worldObj,
								xCoord.toDouble() + 0.5,
								yCoord.toDouble() + 1.5,
								zCoord.toDouble() + 0.5,
								ItemStack(reward.id, 1, reward.meta)
							)
							val f3 = 0.05
							entityitem.xd = worldObj.rand.nextGaussian() * f3
							entityitem.yd = 0.2
							entityitem.zd = worldObj.rand.nextGaussian() * f3
							worldObj.entityJoinedWorld(entityitem)

							//System.out.println("Spawning: " + reward.id);
						}
					}
				}
			}
		} else {
			particleMode = true
		}
		update = true
	}

	private fun update() {
		update = false
		worldObj.markBlockNeedsUpdate(xCoord, yCoord, zCoord)
	}

	override fun readFromNBT(compound: CompoundTag) {
		super.readFromNBT(compound)
		when (compound.getInteger("mode")) {
			0 -> mode = SieveMode.EMPTY
			1 -> mode = SieveMode.FILLED
		}
		contentID = compound.getInteger("contentID")
		contentMeta = compound.getInteger("contentMeta")
		volume = compound.getFloat("volume")
		particleMode = compound.getBoolean("particles")
	}
	override fun writeToNBT(compound: CompoundTag) {
		super.writeToNBT(compound)
		compound.putInt("mode", mode.ordinal)
		compound.putInt("contentID", contentID)
		compound.putInt("contentMeta", contentMeta)
		compound.putFloat("volume", volume)
		compound.putBoolean("particles", particleMode)
	}

	override fun getDescriptionPacket(): Packet {
		/*val tag = CompoundTag()
		this.writeToNBT(tag);

		return Packet140TileEntityData(this)*/

		return super.getDescriptionPacket()
	}

	companion object {
		private const val MIN_RENDER_CAPACITY = 0.70f
		private const val MAX_RENDER_CAPACITY = 0.9f
		private const val PROCESSING_INTERVAL = 0.075f

		private const val UPDATE_INTERVAL = 20
		private val color: Color = Color(1f, 1f, 1f, 1f)

	}

}
