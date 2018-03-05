package com.robinkanters.psychicpoker

class Deck(cards: List<Card>) : CardSet(cards) {
    fun draw() = removeAt(0)

    companion object {
        fun parse(input: String): Deck {
            val parsedCards = input
                    .split(' ')
                    .drop(5)
                    .take(5)
                    .map { Card.parse(it) }
            return Deck(parsedCards)
        }
    }

    fun copy() = Deck(this)
}
