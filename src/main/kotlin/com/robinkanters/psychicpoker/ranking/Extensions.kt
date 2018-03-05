package com.robinkanters.psychicpoker.ranking

import com.robinkanters.psychicpoker.CardSet
import com.robinkanters.psychicpoker.CardSuit

internal val List<Int>.isStraight: Boolean
    get() {
        val sorted = sorted().distinct()
        val diff = sorted.last() - sorted.first()

        // 1,2,3,4,5 => 5-1 = 4 (size-1)

        return diff == 4 && sorted.size == 5
    }

internal val CardSet.mostCommonSuit: CardSuit
    get() = CardSuit.values()
            .map { suit -> suit to count { it.suit == suit } }
            .sortedByDescending { it.occurrences }
            .first()
            .suit

val Pair<CardSuit, Int>.suit get() = first
val Pair<CardSuit, Int>.occurrences get() = second
