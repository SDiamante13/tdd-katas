package com.diamantetechcoaching;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StackTest {

    /*
    Test List
    ---------
    [x] - new stack should be empty
    [x] - stack with one element should not be empty
    [x] - stack with two elements has size of 2
    [x] - peek returns the last added element without removing it
    [x] - pop returns the last element that was pushed
    [x] - Stack handles generics
    */
    @Test
    void newStackIsEmpty() {
        Stack<Integer> stack = new Stack<>();

        assertThat(stack.isEmpty())
                .isTrue();
    }

    @Test
    void stackWithOneElementIsNotEmpty() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    void stackWithTwoElementsHasSizeOfTwo() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        assertThat(stack.size()).isEqualTo(2);
    }

    @Test
    void peekReturnsFirstElementWithoutRemovingIt() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        assertThat(stack.peek()).isEqualTo(2);
        assertThat(stack.size()).isEqualTo(2);
    }

    @Test
    void popReturnsAndRemovesTheLastElement() {
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(8);
        stack.push(7);

        assertThat(stack.pop()).isEqualTo(7);
        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(8);
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.pop()).isEqualTo(9);
        assertThat(stack.size()).isZero();
    }

    @Test
    void stackHandlesOtherTypes() {
        Stack<String> stack = new Stack<>();

        stack.push("one");
        stack.push("three");

        assertThat(stack.pop()).isEqualTo("three");
        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    void cannotPeekWhenStackIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertThatThrownBy(stack::peek)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void cannotPopWhenStackIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertThatThrownBy(stack::pop)
                .isInstanceOf(IllegalStateException.class);
    }

    private static class Stack<T> {

        private T[] elements;
        private int numberOfElements = 0;

        public Stack() {
            this.elements = (T[]) new Object[10];
        }

        public boolean isEmpty() {
            return numberOfElements == 0;
        }

        public void push(T element) {
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

        public T peek() {
            requireNotEmpty();
            return elements[numberOfElements - 1];
        }

        public T pop() {
            requireNotEmpty();
            T lastElement = elements[numberOfElements - 1];
            elements[numberOfElements - 1] = null;
            numberOfElements--;
            return lastElement;
        }

        private void requireNotEmpty() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
        }
    }
}
