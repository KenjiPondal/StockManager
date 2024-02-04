package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

//Controlador de App.fxml
public class LogIn {

	public void serializarArrayAJson(Vector<Usuario> usuarios) {

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		// String representacionBonita = prettyGson.toJson(usuarios);
		// System.out.println(representacionBonita);

		try (FileWriter writer = new FileWriter("usuarios.json")) {
			prettyGson.toJson(usuarios, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Vector<Usuario> desserializarJsonAArray() {
		Vector<Usuario> usuarios = new Vector<Usuario>();

		try (Reader reader = new FileReader("usuarios.json")) {
			Gson gson = new Gson();
			Type tipoListaUsuarios = new TypeToken<Vector<Usuario>>() {
			}.getType();
			usuarios = gson.fromJson(reader, tipoListaUsuarios);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public LogIn() {

	}

	@FXML
	private Button button;
	@FXML
	private Label wrongLogIn;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	public static Vector<Usuario> usl = new Vector<Usuario>(); // Lista usuarios

	public void userLogIn(ActionEvent event) throws IOException {
		checkLogin();
	}

	private void checkLogin() throws IOException {
		Main m = new Main();

		LogIn miManejadorJson = new LogIn();
		usl = miManejadorJson.desserializarJsonAArray();

		// Recorremos la lista de usarios del fichero usuarios.json

		for (int i = 0; i < usl.size(); i++) {
			// Usuarios registrados
			if (username.getText().toString().equals(usl.get(i).getUsuario())
					&& password.getText().toString().equals(usl.get(i).getContrasena())) {
				m.changeScene("/resource/Main.fxml");
			}
			// Campo vacio
			else if (username.getText().isEmpty() || password.getText().isEmpty()) {
				wrongLogIn.setText("Porfavor introduce tus datos.");
			}
			// Contrasena o usuario incorrectos
			else {
				wrongLogIn.setText("Usuario o contrasena incorrectos!");
			}
		}

	}

	@FXML
	public void irRegistro(ActionEvent event) throws IOException {
		Main c = new Main();
		c.changeScene("/resource/RegistroUsuario.fxml");
	}

}