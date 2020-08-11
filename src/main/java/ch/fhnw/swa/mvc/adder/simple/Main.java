package ch.fhnw.swa.mvc.adder.simple;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			stage.setTitle("Adder");
			initStage(stage);
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initStage(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Adder.fxml"));
		stage.setScene(new Scene(loader.load()));
		View v = loader.getController();
		v.setModel(new Model());
		new Controller(v);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
