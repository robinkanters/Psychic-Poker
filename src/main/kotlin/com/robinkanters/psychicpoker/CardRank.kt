package com.robinkanters.psychicpoker

enum class CardRank(private val letter: Char, val ordinalValue: Int) {
    ACE('A', 14),
    KING('K', 13),
    QUEEN('Q', 12),
    JACK('J', 11),
    TEN('T', 10),
    NINE('9', 9),
    EIGHT('8', 8),
    SEVEN('7', 7),
    SIX('6', 6),
    FIVE('5', 5),
    FOUR('4', 4),
    THREE('3', 3),
    TWO('2', 2);

    override fun toString() = this.letter.toString()

    companion object {
        fun parse(input: Char): CardRank {
            return CardRank.values().firstOrNull { it.letter == input }
                    ?: throw IllegalArgumentException("$input is not a valid card rank")
        }
    }
}
