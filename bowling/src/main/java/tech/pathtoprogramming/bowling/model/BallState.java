package tech.pathtoprogramming.bowling.model;

public enum BallState {
    FIRST_BALL {
        @Override
        public BallState nextState() {
            return BallState.SECOND_BALL;
        }
    },
    SECOND_BALL {
        @Override
        public BallState nextState() {
            return BallState.FIRST_BALL;
        }
    };

    public abstract BallState nextState();
}
