import com.robinkanters.psychicpoker.PokerPlayer

// little console interface
fun main(args: Array<String>) {
    val player = PokerPlayer()

    while (true) {
        println("Enter hand and deck (blank to quit):")
        val cardString = readLine() ?: ""

        if (cardString.isBlank())
            System.exit(0)

        try {
            val result = player.playGame(cardString)
            println("Result:\n$result\n")
        } catch (e: Throwable) {
            println("Error: ${e.message}\n")
        }
    }
}
