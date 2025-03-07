package bingo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BingoBoardTest {

    BingoBoard board;

    @Test
    void aNewlyCreatedBoardIsNotInitialized() {
        givenBingoBoardOfSize(1, 1);
        thenBoardIsNotInitialized();
        assertThat(board).isNotNull();
        assertThat(true).isTrue();
    }

    @Test
    void whenAllFieldsAreSetTheBoardIsAllCellsDefined() {
        String anyValue = "42";
        givenBingoBoardOfSize(1, 1);
        whenCellIsDefined(0, 0, anyValue);
        thenBoardIsAllCellsDefined();
    }

    @Test
    void whenAllFieldsOnRectangularBoardAreSetItIsAllCellsDefined() {
        String one = "0, 0";
        String two = "0, 1";
        givenBingoBoardOfSize(1, 2);
        whenCellIsDefined(0, 0, one);
        whenCellIsDefined(0, 1, two);
        thenBoardIsAllCellsDefined();
    }

    @Test
    void aDefinedCellCantBeRedefinedEvenIfItsTheSameValue() {
        String anyValue = "42";
        givenBingoBoardOfSize(1, 1);
        whenCellIsDefined(0, 0, anyValue);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> whenCellIsDefined(0, 0, anyValue))
                .withMessage("cell already defined");
    }

    @Test
    void duplicateCellsAreNotAllowed() {
        String anyValue = "42";
        givenBingoBoardOfSize(2, 2);
        whenCellIsDefined(0, 1, anyValue);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> whenCellIsDefined(1, 0, anyValue))
                .withMessage(anyValue + " already present at 0,1");
    }

    @Test
    void aNonInitializedBoardCannotBeMarked() {
        givenBingoBoardOfSize(1, 1);

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> whenCellIsMarked(0, 0))
                .withMessage("board not initialized");
    }

    @Test
    void whenAllCellGetsMarkedItIsMarked() {
        String anyValue = "42";
        givenBingoBoardOfSize(1, 1);
        whenCellIsDefined(0, 0, anyValue);
        whenCellIsMarked(0, 0);
        thenCellIsMarked(0, 0);
    }

    void givenBingoBoardOfSize(int width, int height) {
        board = new BingoBoard(width, height);
    }

    void whenCellIsDefined(int x, int y, String value) {
        board.defineCell(x, y, value);
    }

    void whenCellIsMarked(int x, int y) {
        board.markCell(x, y);
    }

    void thenBoardIsNotInitialized() {
        assertThat(boardInitializeState()).isFalse();
    }

    void thenBoardIsAllCellsDefined() {
        assertThat(boardInitializeState()).isTrue();
    }

    boolean boardInitializeState() {
        return board.isAllCellsDefined();
    }

    void thenCellIsMarked(int x, int y) {
        assertThat(board.isMarked(x, y)).isTrue();
    }
}