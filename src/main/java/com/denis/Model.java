package com.denis;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static final int MORE = 1;
    public static final int LESS = -1;
    public static final int COMPARE = 0;
    public static final int OUT_OF_RANGE = 2;
    public final int MAX = 100;
    private final int GUESS_NUMBER;
    private int maxBarrier = MAX;
    private int minBarrier = 0;

    private final List<Integer> tries = new ArrayList<>();

    public Model() {
        GUESS_NUMBER = generateGuessNumber();
    }

    public Model(int guessNumber) {
        if (guessNumber >= minBarrier && guessNumber <= maxBarrier) {
            GUESS_NUMBER = guessNumber;
        }
        else {
            GUESS_NUMBER = generateGuessNumber();
        }
    }

    public int generateGuessNumber() {
        return (int) (Math.random() * (MAX + 1));
    }

    public int userNumber(int number) {
        if (minBarrier > number || number > maxBarrier) {
            return OUT_OF_RANGE;
        }
        tries.add(number);
        int compare = Integer.compare(GUESS_NUMBER, number);

        if ((compare == LESS)) {
            maxBarrier = number - 1;
        }
        else if (compare == MORE) {
            minBarrier = number + 1;
        }
        return compare;
    }

    public int getGUESS_NUMBER() {
        return GUESS_NUMBER;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public List<Integer> getTries() {
        return List.copyOf(tries);
    }

    public int triesSize() {
        return tries.size();
    }
}
