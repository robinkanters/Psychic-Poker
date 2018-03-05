package com.robinkanters.psychicpoker.ranking

import com.robinkanters.psychicpoker.CardRank
import com.robinkanters.psychicpoker.Hand

object FullHouse : HandRanking() {
    override val name = "full-house"

    override fun isPossible(hand: Hand): Boolean {
        val cardOccurrences = hand
                .getOccurrencesOfMostCommonRanks()
                .sortedDescending()

        return cardOccurrences.size > 1 // should always be true, but let's be sure
                && cardOccurrences[0] >= 3
                && cardOccurrences[1] >= 2
    }

    private fun Hand.getOccurrencesOfMostCommonRanks(): List<Int> {
        return CardRank.values()
                .map { rank ->
                    count { it.rank == rank }
                }
    }
}
