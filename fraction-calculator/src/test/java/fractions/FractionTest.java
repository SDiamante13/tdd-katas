package fractions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FractionTest {

    @Test
    void addZeroes() {
        Fraction zero = new Fraction(0, 1);

        Fraction sum = zero.plus(zero);

        assertThat(sum).isEqualTo(zero);
    }

    @Test
    void addZeroAndNonZero() {
        Fraction zero = new Fraction(0, 1);
        Fraction one = new Fraction(1, 1);

        assertThat(zero.plus(one)).isEqualTo(one);
        assertThat(one.plus(zero)).isEqualTo(one);
    }
}

record Fraction(int numerator, int denominator) {

    public Fraction plus(Fraction fraction) {
        int sumOfNumerators = numerator + fraction.numerator();
        return new Fraction(sumOfNumerators, 1);
    }

    @Override
    public String toString() {
        return String.format("%s/%s", numerator, denominator);
    }
}
