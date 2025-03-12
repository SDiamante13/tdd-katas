package com.diamantetechcoaching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

    /*
    Test List
    ---------
    [x] - new stack should be empty
    [ ] - stack with one element should not be empty
    [ ] - stack with two elements has size of 2
    [ ] - peek returns the last added element without removing it
    [ ] - pop returns the last element that was pushed
    */
    @Test
    void newStackIsEmpty() {
        Stack stack = new Stack();

        assertThat(stack.isEmpty())
                .isTrue();
    }

    private static class Stack {
        public boolean isEmpty() {
            return true;
        }
    }
}
