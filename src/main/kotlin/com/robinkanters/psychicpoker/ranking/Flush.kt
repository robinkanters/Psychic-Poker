package com.robinkanters.psychicpoker.ranking

import com.robinkanters.psychicpoker.CardSet
import com.robinkanters.psychicpoker.Hand

// five cards of the same suit
object Flush : HandRanking() {
    override val name = "flush"

    override fun isPossible(hand: Hand): Boolean {
        return hand.isFlush()
    }

}

internal fun CardSet.isFlush(): Boolean {
    val suit = get(0).suit
    return all { it.suit == suit }
}
