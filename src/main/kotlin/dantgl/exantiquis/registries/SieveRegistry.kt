package dantgl.exantiquis.registries

import dantgl.exantiquis.registries.helpers.SiftReward
import net.minecraft.core.block.Block
import net.minecraft.core.item.Item


object SieveRegistry {

	var rewards = ArrayList<SiftReward>()

	var dropCopper = false
	var dropTin = false
	var dropSilver = false
	var dropLead = false
	var dropNickel = false
	var dropPlatinum = false
	var dropAluminum = false

	var dropRubberSeeds = false

	fun register(sourceID: Int, sourceMeta: Int, outputID: Int, outputMeta: Int, rarity: Int) {
		val entry = SiftReward(sourceID, sourceMeta, outputID, outputMeta, rarity)
		if (Block.blocksList[sourceID] != null) {
			rewards.add(entry)
		} else {
			println("Ex Nihilo: An item was added to the SieveRegistry which was not a block")
		}
	}

	fun getRewards(id: Int, meta: Int): ArrayList<SiftReward> {
		val rewardList = ArrayList<SiftReward>()
		val it: Iterator<SiftReward> = rewards.iterator()
		while (it.hasNext()) {
			val reward = it.next()
			if (reward.sourceID == id && reward.sourceMeta == meta) {
				rewardList.add(reward)
			}
		}
		return rewardList
	}

	fun Contains(id: Int, meta: Int): Boolean {
		val it: Iterator<SiftReward> = rewards.iterator()
		while (it.hasNext()) {
			val reward = it.next()
			if (reward.sourceID == id && (reward.sourceMeta == meta || reward.ignoreMeta)) {
				return true
			}
		}
		return false
	}

	fun Contains(id: Int): Boolean {
		val it: Iterator<SiftReward> = rewards.iterator()
		while (it.hasNext()) {
			val reward = it.next()
			if (reward.sourceID == id && reward.ignoreMeta) {
				return true
			}
		}
		return false
	}

	fun registerRewards() {
		//Dirt!
		//register(Block.dirt.id, 0, Items.Stones.id, 0, 1)
		//register(Block.dirt.id, 0, Items.Stones.id, 0, 1)
		//register(Block.dirt.id, 0, Items.Stones.id, 0, 2)
		//register(Block.dirt.id, 0, Items.Stones.id, 0, 2)
		//register(Block.dirt.id, 0, Items.Stones.id, 0, 3)
		//register(Block.dirt.id, 0, Items.Stones.id, 0, 3)
		register(Block.dirt.id, 0, Item.seedsWheat.id, 0, 15)
		//register(Block.dirt.id, 0, Items.GrassSeeds.id, 0, 15)
		//register(Block.dirt.id, 0, Item.melonSeeds.id, 0, 32)
		//register(Block.dirt.id, 0, Item.pumpkinSeeds.id, 0, 32)
		/*register(Block.dirt.id, 0, Items.SeedsSugarcane.id, 0, 32)
		register(Block.dirt.id, 0, Items.SeedsCarrot.id, 0, 64)
		register(Block.dirt.id, 0, Items.SeedsPotato.id, 0, 64)
		register(Block.dirt.id, 0, Items.SeedsOak.id, 0, 64)
		register(Block.dirt.id, 0, Items.SeedsSpruce.id, 0, 90)
		register(Block.dirt.id, 0, Items.SeedsBirch.id, 0, 90)*/

		//Gravel!
		register(Block.gravel.id, 0, Item.flint.id, 0, 4)
		//register(Block.gravel.id, 0, Items.IronGravel.id, 0, 5)
		//register(Block.gravel.id, 0, Items.GoldGravel.id, 0, 11)
		register(Block.gravel.id, 0, Item.coal.id, 0, 8)
		register(Block.gravel.id, 0, Item.dye.id, 4, 20) //Lapis Lazuli
		register(Block.gravel.id, 0, Item.diamond.id, 0, 128)
		register(Block.gravel.id, 0, Item.olivine.id, 0, 150)

		//Sand!
		//register(Block.sand.id, 0, Items.IronSand.id, 0, 5)
		//register(Block.sand.id, 0, Items.GoldSand.id, 0, 11)
		register(Block.sand.id, 0, Item.dye.id, 3, 32) //Cocoa beans
		//register(Block.sand.id, 0, Items.SeedsCactus.id, 0, 32)
		//register(Block.sand.id, 0, Items.SeedsJungle.id, 0, 64)
		//register(Block.sand.id, 0, Items.Spores.id, 0, 128)

		//Soul Sand!
		register(Block.soulsand.id, 0, Item.quartz.id, 0, 1)
		register(Block.soulsand.id, 0, Item.quartz.id, 0, 3)
		//register(Block.soulsand.id, 0, Item.netherStalkSeeds.id, 0, 20)
		//register(Block.soulsand.id, 0, Item.ghastTear.id, 0, 64)

		//Dust!
		/*register(Blocks.Dust.id, 0, Items.IronDust.id, 0, 5)
		register(Blocks.Dust.id, 0, Items.GoldDust.id, 0, 11)
		register(Blocks.Dust.id, 0, Item.dyePowder.id, 15, 5) //Bone Meal
		register(Blocks.Dust.id, 0, Item.redstone.id, 0, 8)
		register(Blocks.Dust.id, 0, Item.gunpowder.id, 0, 15)
		register(Blocks.Dust.id, 0, Item.glowstone.id, 0, 16)
		register(Blocks.Dust.id, 0, Item.blazePowder.id, 0, 20)*/
	}

}
