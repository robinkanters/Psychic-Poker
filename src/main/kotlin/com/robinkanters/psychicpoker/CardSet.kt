package com.robinkanters.psychicpoker

open class CardSet(cards: List<Card>) : MutableList<Card> by cards.toMutableList() {
    override fun toString(): String {
        return joinToString(" ")
    }

    operator fun plusAssign(other: CardSet) {
        addAll(other)
    }

    operator fun plus(other: CardSet): CardSet {
        return CardSet(this.toList() + other.toList())
    }
}
