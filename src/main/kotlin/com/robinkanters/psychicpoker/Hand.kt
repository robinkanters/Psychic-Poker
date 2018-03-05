package com.robinkanters.psychicpoker

class Hand(cards: List<Card>) : CardSet(cards) {
    fun replaceCard(index: Int, newCard: Card) {
        set(index, newCard)
    }

    fun copy() = Hand(this)

    companion object {
        fun parse(input: String): Hand {
            val parsedCards = input
                    .split(' ')
                    .take(5)
                    .map { Card.parse(it) }
            return Hand(parsedCards)
        }
    }
}
