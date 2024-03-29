package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stg;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stg = primaryStage;
		primaryStage.setResizable(false);

		Parent root = FXMLLoader.load(getClass().getResource("/resource/App.fxml"));
		primaryStage.setTitle("Manager de Stock");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.setResizable(true); // Hacer que el tamano de las ventanas pueda cambiar
		primaryStage.show();
	}

	// Metodo para cambiar escena
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
