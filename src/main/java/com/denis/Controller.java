package com.denis;

import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processData(){
        Scanner scanner = new Scanner(System.in);
        view.printMessageAndValue(View.SECRET_NUMBER, model.getGUESS_NUMBER());
        System.out.println();
        int compareNumber;
        int userInput;
        do {
            userInput = validationUserInputData(scanner);
            compareNumber = model.userNumber(userInput);
            comparing(compareNumber, userInput);
        } while (compareNumber != Model.COMPARE);
    }

    public void comparing(int compareNumber, int userInput){
        if (compareNumber == Model.LESS)
            view.printMessageAndValue(View.NOT_GUESS, View.SMALLER, userInput);
        else if (compareNumber == Model.MORE)
            view.printMessageAndValue(View.NOT_GUESS, View.BIGGER, userInput);
        else if (compareNumber == Model.OUT_OF_RANGE)
            view.printMessageAndValue(View.OUT_OF_RANGE, model.getMinBarrier(), model.getMaxBarrier());
        else if (compareNumber == Model.COMPARE){
            view.printMessageAndValue(View.CONGRATULATION, userInput);
            view.printMessageAndValue(View.STATISTICS, model.triesSize());
            view.printTries(model.getTries());
        }
    }

    public int validationUserInputData(Scanner scanner){
        processTries();
        view.printMessageAndValue(View.INPUT_DATA, model.getMinBarrier(), model.getMaxBarrier());
        while (!scanner.hasNextInt()) {
            processTries();
            view.printMessage(View.NOT_CORRECT_VALUE);
            view.printMessageAndValue(View.INPUT_DATA, model.getMinBarrier(), model.getMaxBarrier());
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void processTries() {
        if (model.triesSize() != 0)
            view.printTries(model.getTries());
    }
}
