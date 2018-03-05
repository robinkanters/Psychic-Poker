package com.robinkanters.psychicpoker.ranking

import com.robinkanters.psychicpoker.Hand

object HighestCard : HandRanking() {
    override val name = "highest-card"

    override fun isPossible(hand: Hand) = true
}
