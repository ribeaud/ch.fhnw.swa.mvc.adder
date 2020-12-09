package ch.fhnw.swa.mvc.adder.withhex;

public class Controller {
    public Controller(final View v) {
        // The controller takes input from the user and uses it to update the model
        // and to determine when to redraw the view(s).
        v.getOp1().textProperty()
                .addListener((observable, oldValue, newValue) -> v.getModel().value1.set(intFromString(newValue, 10)));
        v.getOp2().textProperty()
                .addListener((observable, oldValue, newValue) -> v.getModel().value2.set(intFromString(newValue, 10)));
        v.getOp1Hex().textProperty()
                .addListener((observable, oldValue, newValue) -> v.getModel().value1.set(intFromString(newValue, 16)));
        v.getOp2Hex().textProperty()
                .addListener((observable, oldValue, newValue) -> v.getModel().value2.set(intFromString(newValue, 16)));
    }

    private int intFromString(String s, int base) {
        try {
            return Integer.parseInt(s, base);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
