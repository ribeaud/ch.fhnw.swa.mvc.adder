package ch.fhnw.swa.mvc.adder.withhex;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class View {
    // A view renders some or all of the data contained within the model.
    private Model model = null;
    @FXML
    private TextField op1;
    @FXML
    private TextField op2;
    @FXML
    private TextField sum;
    @FXML
    private TextField op1Hex;
    @FXML
    private TextField op2Hex;
    @FXML
    private TextField sumHex;

    public void setModel(Model model) {
        if (this.model != null) {
            throw new IllegalStateException();
        }
        this.model = model;
        model.value1.addListener((observable, oldValue, newValue) -> op1.textProperty().set(newValue.toString()));
        model.value2.addListener((observable, oldValue, newValue) -> op2.textProperty().set(newValue.toString()));
        sum.textProperty().bind(model.sumVal.asString());
        model.value1
                .addListener((observable, oldValue, newValue) -> op1Hex.textProperty().set(stringFromInt(newValue, 16)));
        model.value2
                .addListener((observable, oldValue, newValue) -> op2Hex.textProperty().set(stringFromInt(newValue, 16)));
        sumHex.textProperty().bind(model.sumVal.asString("%x"));
    }

    public Model getModel() {
        return model;
    }

    public TextField getOp1() {
        return op1;
    }

    public TextField getOp2() {
        return op2;
    }

    public TextField getSum() {
        return sum;
    }

    public TextField getOp1Hex() {
        return op1Hex;
    }

    public TextField getOp2Hex() {
        return op2Hex;
    }

    public TextField getSumHex() {
        return sumHex;
    }

    private String stringFromInt(Number n, int base) {
        return Integer.toString(n.intValue(), base);
    }
}
