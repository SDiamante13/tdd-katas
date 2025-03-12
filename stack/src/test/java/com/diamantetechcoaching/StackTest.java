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

//    @Test
//    void peekReturnsFirstElementWithoutRemovingIt() {
//        Stack stack = new Stack();
//        stack.push(1);
//        stack.push(2);
//
//        assertThat(stack.peek()).isEqualTo(2);
//        assertThat(stack.size()).isEqualTo(2);
//    }

    private static class Stack {

        private int[] elements = {};
        private int numberOfElements = 0;

        public boolean isEmpty() {
            return numberOfElements == 0;
        }

        public void push(int element) {
            if (this.elements.length == numberOfElements) {
                grow();
            }
            this.elements[numberOfElements] = element;
            this.numberOfElements++;
        }

        private void grow() {
            this.elements = Arrays.copyOf(this.elements, (this.elements.length + 1) * 2);
        }

        public int size() {
            return numberOfElements;
        }

        public int peek() {
            return 0;
        }
    }
}
