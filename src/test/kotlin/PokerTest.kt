import com.robinkanters.psychicpoker.PokerPlayer
import com.robinkanters.psychicpoker.ranking.*
import org.junit.Test
import kotlin.test.assertEquals

class PokerTest {
    private val player = PokerPlayer()

    /**
     * @see [StraightFlush]
     */
    @Test
    fun straightFlush() {
        val input = "TH JH QC QD QS QH KH AH 2S 6S"
        val output = "Hand: TH JH QC QD QS Deck: QH KH AH 2S 6S Best hand: straight-flush"

        assertEquals(output, player.playGame(input))
    }

    /**
     * @see [FourOfAKind]
     */
    @Test
    fun fourOfAKind() {
        val input = "2H 2S 3H 3S 3C 2D 3D 6C 9C TH"
        val output = "Hand: 2H 2S 3H 3S 3C Deck: 2D 3D 6C 9C TH Best hand: four-of-a-kind"

        assertEquals(output, player.playGame(input))
    }

    /**
     * @see [FullHouse]
     */
    @Test
    fun fullHouse() {
        val input = "2H 2S 3H 3S 3C 2D 9C 3D 6C TH"
        val output = "Hand: 2H 2S 3H 3S 3C Deck: 2D 9C 3D 6C TH Best hand: full-house"

        assertEquals(output, player.playGame(input))
    }

    /**
     * @see [Flush]
     */
    @Test
    fun flush() {
        val input = "2H AD 5H AC 7H AH 6H 9H 4H 3C"
        val output = "Hand: 2H AD 5H AC 7H Deck: AH 6H 9H 4H 3C Best hand: flush"

        assertEquals(output, player.playGame(input))
    }

    /**
     * @see [Straight]
     */
    @Test
    fun straight() {
        val input = "AC 2D 9C 3S KD 5S 4D KS AS 4C"
        val output = "Hand: AC 2D 9C 3S KD Deck: 5S 4D KS AS 4C Best hand: straight"

        assertEquals(output, player.playGame(input))
    }

    /**
     * @see [ThreeOfAKind]
     */
    @Test
    fun threeOfAKind() {
        val input = "KS AH 2H 3C 4H KC 2C TC 2D AS"
        val output = "Hand: KS AH 2H 3C 4H Deck: KC 2C TC 2D AS Best hand: three-of-a-kind"

        assertEquals(output, player.playGame(input))
    }

    /**
     * @see [TwoPairs]
     */
    @Test
    fun twoPairs() {
        val input = "AH 2C 9S AD 3C QH KS JS JD KD"
        val output = "Hand: AH 2C 9S AD 3C Deck: QH KS JS JD KD Best hand: two-pairs"

        assertEquals(output, player.playGame(input))
    }

    /**
     * @see [OnePair]
     */
    @Test
    fun onePair() {
        val input = "6C 9C 8C 2D 7C 2H TC 4C 9S AH"
        val output = "Hand: 6C 9C 8C 2D 7C Deck: 2H TC 4C 9S AH Best hand: one-pair"

        assertEquals(output, player.playGame(input))
    }

    /**
     * @see [HighestCard]
     */
    @Test
    fun highestCard() {
        val input = "3D 5S 2H QD TD 6S KH 9H AD QH"
        val output = "Hand: 3D 5S 2H QD TD Deck: 6S KH 9H AD QH Best hand: highest-card"

        assertEquals(output, player.playGame(input))
    }
}
