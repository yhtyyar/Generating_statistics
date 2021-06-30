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

        System.out.println("Напишите: \n" + BACK + " - для того, чтобы вернуться назад\n" +
                EXIT + " - для выхода из программы\n");

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
                    System.out.println("Ошибка!  Вы ввели неизвестный запрос! Попробуйте еще раз...");
                    break;
            }
        }
    }


    abstract void back();

    void exit() {

        interrupt = true;
    }
}
