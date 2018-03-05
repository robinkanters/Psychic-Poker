package com.robinkanters.psychicpoker.ranking

import com.robinkanters.psychicpoker.CardSet
import com.robinkanters.psychicpoker.Hand

// incrementing card values
object Straight : HandRanking() {
    override val name = "straight"

    override fun isPossible(hand: Hand) = hand.isStraight()
}

internal fun CardSet.isStraight(): Boolean {
    return map { it.rank.ordinalValue }.isStraight
            || isStraightWithAcesValuedAtOne()
}

private fun CardSet.isStraightWithAcesValuedAtOne(): Boolean {
    return map { it.rank.ordinalValue }.map { if (it == 14) 1 else it }.isStraight
}
