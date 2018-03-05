package com.robinkanters.psychicpoker

enum class CardSuit(private val letter: Char) {
    CLUBS('C'),
    DIAMONDS('D'),
    HEARTS('H'),
    SPADES('S');

    override fun toString() = this.letter.toString()

    companion object {
        fun parse(input: Char) =
                CardSuit.values().firstOrNull { it.letter == input }
                        ?: throw IllegalArgumentException("$input is not a valid suit")
    }
}
