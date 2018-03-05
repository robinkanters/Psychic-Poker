package com.robinkanters.psychicpoker

data class Card(val suit: CardSuit, val rank: CardRank) {
    override fun toString() = "$rank$suit"

    companion object {
        fun parse(input: String): Card {
            if (input.trim().length != 2)
                throw IllegalArgumentException("$input is not a valid card")

            return Card(
                    CardSuit.parse(input[1]),
                    CardRank.parse(input[0])
            )
        }
    }
}
