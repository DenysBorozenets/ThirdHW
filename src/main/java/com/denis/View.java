package com.denis;

    public class View {
        public static final String INPUT_DATA = "Start game! Guess number! Your range [%d, %d]: ";
        public static final String SECRET_NUMBER = "Secret number %d! ";
        public static final String SPACE = " ";
        public static final String TRIES = "Tries ";

        public static final String OUT_OF_RANGE = "Out of range [%d, %d]. Try one more!";
        public static final String NOT_CORRECT_VALUE = "Not int value. Try one more!";
        public static final String NOT_GUESS = "Not guessed. Try one more";
        public static final String BIGGER = "Bigger than correct value";
        public static final String SMALLER = "Smaller than correct value";

        public static final String CONGRATULATION = "Success number. Good job! ";
        public static final String STATISTICS = "Your tries! ";

        public void printMessage(String message){
            System.out.println(message);
        }

        public void printMessageAndValue(String message, Object... objects){
            System.out.printf(message, objects);
        }
        public void printTries(Iterable<Integer> tries){
            StringBuilder stringBuilder = new StringBuilder(TRIES);
            for (int tryWay: tries) {
                stringBuilder.append(tryWay).append(SPACE);
            }
            //stringBuilder.delete(stringBuilder.length()-SPACE.length(), stringBuilder.length());
            printMessage(stringBuilder.toString());
        }
    }

