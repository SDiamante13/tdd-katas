package tech.pathtoprogramming.bowling.model;

public enum Mark {
    NO_MARK {
        @Override
        public Mark nextState() {
            return SPARE;
        }
    },
    SPARE {
        @Override
        public Mark nextState() {
            return NO_MARK;
        }
    },
    STRIKE {
        @Override
        public Mark nextState() {
            return NO_MARK;
        }
    };

    public abstract Mark nextState();
}
