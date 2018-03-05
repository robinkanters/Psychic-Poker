package com.robinkanters.psychicpoker

import com.robinkanters.psychicpoker.ranking.*

class PokerPlayer {
    fun playGame(input: String): String {
        val hand = Hand.parse(input)
        val deck = Deck.parse(input)

        if ((hand + deck).size < 10)
            throw IllegalArgumentException("Not enough cards! :(")

        val bestHand = calculateBestHand(hand, deck)

        return "Hand: $hand Deck: $deck Best hand: $bestHand"
    }

    private fun calculateBestHand(hand: Hand, deck: Deck): HandRanking {
        val rankings = listOf(
                StraightFlush,
                FourOfAKind,
                FullHouse,
                Flush,
                Straight,
                ThreeOfAKind,
                TwoPairs,
                OnePair,
                HighestCard
        )

        val hands = calculateCardCombinations(hand, deck)

        return rankings.first { ranking ->
            hands.any { hand ->
                ranking.isPossible(hand)
            }
        }
    }

    private fun calculateCardCombinations(hand: Hand, deck: Deck): List<Hand> {
        return (0 until 32).map {
            val deckCards = deck.copy()
            val newHand = hand.copy()
            if (it and 1 > 0) newHand.replaceCard(0, deckCards.draw())
            if (it and 2 > 0) newHand.replaceCard(1, deckCards.draw())
            if (it and 4 > 0) newHand.replaceCard(2, deckCards.draw())
            if (it and 8 > 0) newHand.replaceCard(3, deckCards.draw())
            if (it and 16 > 0) newHand.replaceCard(4, deckCards.draw())
            newHand
        }
    }
}
