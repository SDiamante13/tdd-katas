package com.diamantetechcoaching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

    /*
    Test List
    ---------
    [x] - new stack should be empty
    [x] - stack with one element should not be empty
    [ ] - stack with two elements has size of 2
    [ ] - peek returns the last added element without removing it
    [ ] - pop returns the last element that was pushed
    [ ] - Stack handles generics
    */
    @Test
    void newStackIsEmpty() {
        Stack stack = new Stack();

        assertThat(stack.isEmpty())
                .isTrue();
    }

    @Test
    void stackWithOneElementIsNotEmpty() {
        Stack stack = new Stack();
        stack.push(1);

        assertThat(stack.isEmpty()).isFalse();
    }

    private static class Stack {

        private int element = -1;

        public boolean isEmpty() {
            if (element != -1) {
                return false;
            }
            return true;
        }

        public void push(int element) {
            this.element = element;
        }
    }
}
