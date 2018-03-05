package com.robinkanters.psychicpoker.ranking

import com.robinkanters.psychicpoker.Card
import com.robinkanters.psychicpoker.CardSet
import com.robinkanters.psychicpoker.Hand

sealed class Pairs : HandRanking() {
    abstract val requiredPairs: Int

    override fun isPossible(hand: Hand): Boolean {
        val candidates = hand.findPairs()

        return candidates.size >= requiredPairs
    }

    private fun CardSet.findPairs(): List<List<Pair<Card, Int>>> {
        // List of pairs (Lists) of cards
        return map { card1 -> filter { card2 -> card1.rank == card2.rank } }
                .filter { it.size > 1 }
                .map { it.map { it to indexOf(it) } }
                .distinct()
    }
}

object OnePair : Pairs() {
    override val name = "one-pair"
    override val requiredPairs = 1
}

object TwoPairs : Pairs() {
    override val name = "two-pairs"
    override val requiredPairs = 2
}
