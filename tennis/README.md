# tennis-kata

[From https://codingdojo.org/kata/Tennis/]

This Kata is about implementing a simple tennis tennisGame. I came up with it while thinking about Wii tennis, where they have simplified tennis, so each set is one tennisGame.

The scoring system is rather simple:

1. Each player can have either of these points in one tennisGame 0 15 30 40

2. If you have 40 and you win the ball you win the tennisGame, however there are special rules.

3. If both have 40 the players are deuce. 
   a. If the tennisGame is in deuce, the winner of a ball will have advantage and tennisGame ball. 
   b. If the player with advantage wins the ball he wins the tennisGame 
   c. If the player without advantage wins they are back at deuce.

4. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.

5. If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.

6. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the tennisGame is “advantage” for the player in the lead.

7. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.