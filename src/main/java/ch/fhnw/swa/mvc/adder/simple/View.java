package ch.fhnw.swa.mvc.adder.simple;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class View {
    private Model model = null;
    @FXML
    private TextField op1;
    @FXML
    private TextField op2;
    @FXML
    private TextField sum;

    public void setModel(Model model) {
        if (this.model != null) {
            throw new IllegalStateException();
        }
        this.model = model;
        model.value1.addListener((observable, oldValue, newValue) -> op1.textProperty().set(newValue.toString()));
        model.value2.addListener((observable, oldValue, newValue) -> op2.textProperty().set(newValue.toString()));
        sum.textProperty().bind(model.sumVal.asString());
    }

    public Model model() {
        return model;
    }

    public TextField op1() {
        return op1;
    }

    public TextField op2() {
        return op2;
    }

    public TextField sum() {
        return sum;
    }
}
