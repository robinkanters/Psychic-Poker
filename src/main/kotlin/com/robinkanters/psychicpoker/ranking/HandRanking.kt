package com.robinkanters.psychicpoker.ranking

import com.robinkanters.psychicpoker.Hand

/**
 * A class of scoring in poker.
 */
abstract class HandRanking {
    /**
     * Returns whether the ranking is possible to achieve with a given [Hand].
     */
    abstract fun isPossible(hand: Hand): Boolean

    /**
     * Serialized name of a ranking.
     */
    abstract val name: String

    override fun toString() = name
}
