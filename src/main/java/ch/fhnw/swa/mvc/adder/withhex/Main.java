package ch.fhnw.swa.mvc.adder.withhex;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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
    private IntegerProperty value1 = new SimpleIntegerProperty(), value2 = new SimpleIntegerProperty();

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
        NumberStringConverter decConv = new NumberStringConverter(10), hexConv = new NumberStringConverter(16);
        Bindings.bindBidirectional(op1.textProperty(), value1, decConv);
        Bindings.bindBidirectional(op2.textProperty(), value2, decConv);
        sum.textProperty().bind(value1.add(value2).asString());
        Bindings.bindBidirectional(op1Hex.textProperty(), value1, hexConv);
        Bindings.bindBidirectional(op2Hex.textProperty(), value2, hexConv);
        sumHex.textProperty().bind(value1.add(value2).asString("%x"));
    }

    private static class NumberStringConverter extends StringConverter<Number> {

        private final int base;

        private NumberStringConverter(int base) {
            this.base = base;
        }

        @Override
        public String toString(Number number) {
            return Integer.toString(number.intValue(), base);
        }

        @Override
        public Number fromString(String string) {
            try {
                return Integer.parseInt(string, base);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }
}
