package com.robinkanters.psychicpoker.ranking

import com.robinkanters.psychicpoker.Card
import com.robinkanters.psychicpoker.CardRank
import com.robinkanters.psychicpoker.Hand

object ThreeOfAKind : NOfAKind() {
    override val requiredCards = 3
    override val name = "three-of-a-kind"
}

object FourOfAKind : NOfAKind() {
    override val requiredCards = 4
    override val name = "four-of-a-kind"
}

sealed class NOfAKind : HandRanking() {
    abstract val requiredCards: Int

    override fun isPossible(hand: Hand): Boolean {
        return (hand
                .map { it.rank }
                .map { rank -> rank to countCardsWithRank(rank, hand) }
                .maxBy { it.occurrences })!!
                .occurrences >= requiredCards
    }

    private fun countCardsWithRank(rank: CardRank, totalCards: List<Card>): Int {
        return totalCards.count { it.rank == rank }
    }

    private val Pair<CardRank, Int>.occurrences
        get() = second
}
