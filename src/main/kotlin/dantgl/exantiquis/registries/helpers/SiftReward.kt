package dantgl.exantiquis.registries.helpers

import dantgl.exantiquis.data.ModData

class SiftReward {

	val sourceID: Int
	val sourceMeta: Int
	val ignoreMeta: Boolean
	val id: Int
	val meta: Int
	val rarity: Int

	constructor(sourceID: Int, sourceMeta: Int, id: Int, meta: Int, rarity: Int) {
		this.sourceID = sourceID
		this.sourceMeta = sourceMeta
		this.ignoreMeta = false
		this.id = id
		this.meta = meta
		this.rarity = calculateRarity(rarity)
	}

	constructor(sourceID: Int, id: Int, meta: Int, rarity: Int) {
		this.sourceID = sourceID
		sourceMeta = 0
		ignoreMeta = true
		this.id = id
		this.meta = meta
		this.rarity = calculateRarity(rarity)
	}

	private fun calculateRarity(base: Int): Int {
		val multiplier: Int = ModData.SIEVE_PAIN_MULTIPLIER + 1
		return base * multiplier + (multiplier.toFloat() / 2.0f).toInt()
	}

}
