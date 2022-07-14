package tech.pathtoprogramming.bowling;

import tech.pathtoprogramming.bowling.model.BallState;
import tech.pathtoprogramming.bowling.model.Mark;

import static tech.pathtoprogramming.bowling.model.BallState.*;
import static tech.pathtoprogramming.bowling.model.Mark.*;

public class BowlingGame1 {
    private int score;
    private int frameScore;
    private BallState ballState;
    private Mark mark;

    public BowlingGame1() {
        this.score = 0;
        this.ballState = FIRST_BALL;
        this.mark = NO_MARK;
    }

    public int score() {
        return score;
    }

    public void roll(int pins) {
        addToTotalScore(pins);
        addToFrameScore(pins);

        if (this.ballState.equals(FIRST_BALL)) {
            BallState.values()
            if (mark.equals(STRIKE)) {
                addToTotalScore(pins);
            }

            if (pins == 10) {
                mark = STRIKE;
                resetFrameScore();
                return;
            }

            if (mark.equals(SPARE)) {
                addToTotalScore(pins);
                mark = mark.nextState();
            }

            completeRoll();
        } else if (ballState.equals(SECOND_BALL)) {
            if (mark.equals(STRIKE)) {
                addToTotalScore(pins);
            }

            if (frameScore == 10) {
                mark = mark.nextState();
            }
            
            resetFrameScore();
            completeRoll();
        }
    }

    private void addToTotalScore(int pins) {
        score += pins;
    }

    private void completeRoll() {
        ballState = ballState.nextState();
    }

    private void addToFrameScore(int pins) {
        frameScore += pins;
    }

    private void resetFrameScore() {
        frameScore = 0;
    }
}

