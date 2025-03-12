package com.diamantetechcoaching;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

    /*
    Test List
    ---------
    [x] - new stack should be empty
    [x] - stack with one element should not be empty
    [x] - stack with two elements has size of 2
    [x] - peek returns the last added element without removing it
    [x] - pop returns the last element that was pushed
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

    @Test
    void peekReturnsFirstElementWithoutRemovingIt() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);

        assertThat(stack.peek()).isEqualTo(2);
        assertThat(stack.size()).isEqualTo(2);
    }

    @Test
    void popReturnsAndRemovesTheLastElement() {
        Stack stack = new Stack();
        stack.push(9);
        stack.push(8);
        stack.push(7);

        assertThat(stack.pop()).isEqualTo(7);
        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(8);
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.pop()).isEqualTo(9);
        assertThat(stack.size()).isEqualTo(0);
    }

    private static class Stack {

        private int[] elements = {};
        private int numberOfElements = 0;

        public boolean isEmpty() {
            return numberOfElements == 0;
        }

        public void push(int element) {
            if (hasNoCapacity()) {
                grow();
            }
            this.elements[numberOfElements] = element;
            this.numberOfElements++;
        }

        private boolean hasNoCapacity() {
            return this.elements.length == numberOfElements;
        }

        private void grow() {
            this.elements = Arrays.copyOf(this.elements, (this.elements.length + 1) * 2);
        }

        public int size() {
            return numberOfElements;
        }

        public int peek() {
            return elements[numberOfElements - 1];
        }

        public int pop() {
            int lastElement = elements[numberOfElements - 1];
            numberOfElements--;
            return lastElement;
        }
    }
}
