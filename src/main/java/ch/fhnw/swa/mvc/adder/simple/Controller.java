package ch.fhnw.swa.mvc.adder.simple;

public class Controller {

    public Controller(final View view) {
        Model m = view.model();
        view.op1().textProperty().addListener((observable, oldValue, newValue) -> m.setValue1(intFromString(newValue, 10)));
        view.op2().textProperty().addListener((observable, oldValue, newValue) -> m.setValue2(intFromString(newValue, 10)));
    }

    private int intFromString(String s, int base) {
        try {
            return Integer.parseInt(s, base);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
