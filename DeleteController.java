package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class DeleteController implements Initializable {

	@FXML
	private TableView<Producto> products;

	@FXML
	private TableColumn<Producto, Integer> idCol;

	@FXML
	private TableColumn<Producto, String> nombreCol;

	@FXML
	private TableColumn<Producto, String> provCol;

	@FXML
	private TableColumn<Producto, Double> comCol;

	@FXML
	private TableColumn<Producto, Double> ventCol;

	@FXML
	private TextField inputId;

	@FXML
	private TextField inputName;

	@FXML
	private TextField inputProv;

	@FXML
	private TextField inputCom;

	@FXML
	private TextField inputVen;

	@FXML
	private Button volverBoton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		idCol.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("ID"));
		nombreCol.setCellValueFactory(new PropertyValueFactory<Producto, String>("Nombre"));
		provCol.setCellValueFactory(new PropertyValueFactory<Producto, String>("CodProveedor"));
		comCol.setCellValueFactory(new PropertyValueFactory<Producto, Double>("PrecioCompra"));
		ventCol.setCellValueFactory(new PropertyValueFactory<Producto, Double>("PrecioVenta"));

		for (int i = 0; i < MainController2.prl.size(); i++) {
			this.products.getItems().add(MainController2.prl.get(i));
		}

	}

	@FXML
	void guardar(ActionEvent event) {

		MainController2 m = new MainController2();
		m.serializarArrayAJson(MainController2.prl);

		String currentProductId = inputId.getText();
		for (Producto producto : MainController2.prl) {
			if (producto.getID().equals(currentProductId)) {
				MainController2.prl.remove(producto);
				products.refresh();
				break;
			}
		}

		m.serializarArrayAJson(MainController2.prl);

	}

	@FXML
	void rowClicked(MouseEvent event) {
		Producto clickedProducto = products.getSelectionModel().getSelectedItem();
		inputId.setText(String.valueOf(clickedProducto.getID()));
		inputName.setText(String.valueOf(clickedProducto.getNombre()));
		inputProv.setText(String.valueOf(clickedProducto.getCodProveedor()));
		inputCom.setText(String.valueOf(clickedProducto.getPrecioCompra()));
		inputVen.setText(String.valueOf(clickedProducto.getPrecioVenta()));
	}

	@FXML
	void volverMain(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("/resource/Main.fxml");
	}

}