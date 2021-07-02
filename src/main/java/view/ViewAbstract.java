package view;

import java.util.Scanner;

public abstract class ViewAbstract {

    private final Scanner scanner;
    private boolean interrupt;

    final String EXIT = "exit";
    final String BACK = "back";

    ViewAbstract(Scanner input) {

        this.scanner = input;
    }

    public void start() {

        System.out.println("Write: \n" + BACK + " - in order to go back\n" +
                EXIT + " - to exit the program\n");

        while (!interrupt) {

            String console = scanner.nextLine();


            switch (console) {

                case BACK:
                    back();
                    break;

                case EXIT:
                    exit();
                    break;

                default:
                    System.out.println("Error! You entered an unknown request! Try again...");
                    break;
            }
        }
    }


    abstract void back();

    void exit() {
        interrupt = true;
    }
}
