package view;

import java.util.Scanner;

public class AddressView extends ViewAbstract {

    private static ViewAbstract viewAbstract;

    AddressView() {
        super(new Scanner(System.in));
    }

    @Override
    void back() {
        ViewAbstract viewAbstract = Views.getView();
        viewAbstract.start();
    }

    static ViewAbstract getInstance() {

        if (viewAbstract == null) {
            viewAbstract = new AddressView();
        }

        return viewAbstract;
    }
}
