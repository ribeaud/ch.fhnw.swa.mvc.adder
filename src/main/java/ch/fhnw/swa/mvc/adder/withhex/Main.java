package ch.fhnw.swa.mvc.adder.withhex;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
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

    private IntegerProperty value1 = new SimpleIntegerProperty(),
            value2 = new SimpleIntegerProperty();

    @Override
    public void start(Stage stage) {
        try {
            stage.setTitle("Adder");
            initStage(stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initStage(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Adder.fxml"));
        stage.setScene(new Scene(loader.load()));
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void initialize() {
        op1.textProperty().addListener(
                (observable, oldValue, newValue) -> value1.set(intFromString(newValue,
                        10)));
        op2.textProperty().addListener(
                (observable, oldValue, newValue) -> value2.set(intFromString(newValue,
                        10)));
        sum.textProperty().bind(value1.add(value2).asString());
    }

    private int intFromString(String s, int base) {
        try {
            return Integer.parseInt(s, base);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @SuppressWarnings("unused")
    private String stringFromInt(Number n, int base) {
        return Integer.toString(n.intValue(), base);
    }
}
