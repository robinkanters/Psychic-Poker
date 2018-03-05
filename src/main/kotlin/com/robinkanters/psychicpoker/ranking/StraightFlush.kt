package com.robinkanters.psychicpoker.ranking

import com.robinkanters.psychicpoker.Hand

// incrementing card values of the same suit
object StraightFlush : HandRanking() {
    override val name = "straight-flush"

    override fun isPossible(hand: Hand): Boolean {
        return hand.isFlush() && hand.isStraight()
    }
}
