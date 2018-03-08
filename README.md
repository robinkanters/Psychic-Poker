
The Psychic Poker Player
========================

This repo implements the [Psychic Poker][1] challenge for the BTC.com hiring process.

Author: [Robin Kanters][2]


Getting started 
---------------

### Clone the repo

```
git clone git@github.com:robinkanters/Psychic-Poker.git
```

### Open project in IntelliJ

- File -> Open -> `build.gradle`
- 'Open as Project'
- 'OK' in the dialog


Running the tests
-----------------

Press Shift twice to open the `PokerTest.kt` file and use the buttons in the gutter to run the test, or right-click the
file and select 'Run'.


Running the CLI tool
--------------------

The CLI tool takes inputs as seen in the exercise example, so one line of 10 cards, separated by spaces.

### Running from IntelliJ

- Open the `ConsoleInterface.kt` file in `src/main/kotlin` (or use double Shift again).
- Click the 'Play' icon in the gutter, next to the `main` function.

### Running from the command line

- Run `./gradlew jar` to create a runnable jar. It will be placed in `build/libs`
- Run the jar with `java -jar build/libs/pokerexercise-1.0-SNAPSHOT.jar`

About the implementation
========================

In a nut shell, these are the steps that are taken when determining the optimal score:

1. Take all cards in the hand and deck and compile a list of hands based on all combinations of discarding/keeping
   certain cards.
2. Loop through all scoring types. Nested in that loop, we loop through all combinations to see if any hands match that
   score type. If it does, quit both loops, and we have our answer.

The project was started by creating the test cases, so that the tests could be run throughout development.

Tools/languages/libraries used
=================================

* Tools:
    * IntelliJ
    * Git
    * Gradle
    * JUnit
* Languages: 
    * Kotlin
    * Gradle (Grails)
* Libraries:
    * Kotlin stdlib

<sub>
(since no java dependencies were used, so the code could very easily be modified to be compilable to Javascript and native code)
</sub>

Complexity
----------

The complexity of this solution is exponential, as adding more cards creates exponentially more hands to check (2^N)
where N = number of cards in hand = number of cards in deck. The solution currently does _not_ support different amounts
of cards in the hand and in the deck.

I've settled on the exponential complexity because it is very unlikely that the rules of poker change such that the
amounts of cards change.

Earlier implementation
----------------------

An earlier version compiled the cards into hand and deck instances (one of each) and 'manually' drew from the deck in
all score implementations, to see if the hand could be improved. Though this code might've been slightly faster, the
code complexity did not weigh up against this. The code is now much simpler and therefore easier to understand.

[1]: https://github.com/btccom/Hire/blob/master/exercise/psychic-poker-en.md
[2]: mailto:robin@robinkanters.nl
