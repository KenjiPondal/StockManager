/**
 * Sample Skeleton for 'RegistroUsuario.fxml' Controller Class
 */

package app;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroControlador {

	@FXML // fx:id="username"
	private TextField username;

	@FXML // fx:id="password"
	private PasswordField password;

	@FXML // fx:id="button"
	private Button button;

	@FXML // fx:id="wrongLogIn"
	private Label wrongLogIn;

	@FXML
	public void registro(ActionEvent event) throws IOException {

		// Anadiendo el nuevo usuario
		String newUser = username.getText();
		String newPassword = password.getText();

		Usuario newUsuario = new Usuario(newUser, newPassword);
		LogIn.usl.add(newUsuario);

		LogIn l = new LogIn();
		l.serializarArrayAJson(LogIn.usl);

		Main m = new Main();
		m.changeScene("/resource/App.fxml");
	}
}