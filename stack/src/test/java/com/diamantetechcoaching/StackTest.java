package com.diamantetechcoaching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

    /*
    Test List
    ---------
    [x] - new stack should be empty
    [x] - stack with one element should not be empty
    [x] - stack with two elements has size of 2
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
        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    void stackWithTwoElementsHasSizeOfTwo() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);

        assertThat(stack.size()).isEqualTo(2);
    }

    private static class Stack {

        private int[] elements = {-1};
        private int numberOfElements = 0;

        public boolean isEmpty() {
            if (elements[0] != -1) {
                return false;
            }
            return true;
        }

        public void push(int element) {
            this.elements[0] = element;
            this.numberOfElements++;
        }

        public int size() {
            return numberOfElements;
        }
    }
}
