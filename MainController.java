package app;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable {

	@FXML
	private JFXTabPane View;

	// Tabla de productos
	@FXML
	private TableView<Usuario> ProductosView; // new
	@FXML
	private TableColumn<Usuario, String> nombreProductoColumn; // new cambiar a producto
	@FXML
	private TableColumn<Usuario, Double> precioProductoColumn; // new cambiar a producto

	// Tabla de clientes
	/*
	 * @FXML private TableView<Cliente> ClientesView;
	 * 
	 * @FXML private TableColumn<Cliente, Integer> idClienteColumn;
	 * 
	 * @FXML private TableColumn<Cliente, String> nombreClienteColumn;
	 */

	@FXML
	private JFXButton AñadirButton;

	@FXML
	private JFXButton BorrarButton;

	@FXML
	private JFXButton ModificarButton;

	@FXML
	void onAñadirAction(ActionEvent event) {
		// Lógica para añadir un nuevo producto o cliente
	}

	@FXML
	void onBorrarAction(ActionEvent event) {
		// Lógica para borrar un producto o cliente
	}

	@FXML
	void onModificarButton(ActionEvent event) {
		// Lógica para modificar un producto o cliente
	}

	// INICIALIZAR
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// CARGAR DATOS DE JSON CON LOS DETALLES DE TODOS LOS PRODUCTOS Y PROVEEDORES

		// CONTROLADORES
		/*
		 * public MainController() throws IOException { FXMLLoader loader = new
		 * FXMLLoader(getClass().getResource("/resource/Main.fxml"));
		 * loader.setController(this); loader.load(); }
		 * 
		 * 
		 * // OBTENER VISTA public JFXTabPane getView() { return View; }
		 * 
		 * // GETTERS Y SETTERS PARA TABLA DE PRODUCTOS public TableView<Producto>
		 * getProductosView() { return ProductosView; }
		 * 
		 * public void setProductosView(TableView<Producto> productosView) {
		 * ProductosView = productosView; }
		 * 
		 * public TableColumn<Producto, String> getNombreProductoColumn() { return
		 * nombreProductoColumn; }
		 * 
		 * public void setNombreProductoColumn(TableColumn<Producto, String>
		 * nombreProductoColumn) { this.nombreProductoColumn = nombreProductoColumn; }
		 * 
		 * public TableColumn<Producto, Double> getPrecioProductoColumn() { return
		 * precioProductoColumn; }
		 * 
		 * public void setPrecioProductoColumn(TableColumn<Producto, Double>
		 * precioProductoColumn) { this.precioProductoColumn = precioProductoColumn; }
		 * 
		 * // GETTERS Y SETTERS PARA TABLA DE CLIENTES public TableView<Cliente>
		 * getClientesView() { return ClientesView; }
		 * 
		 * public void setClientesView(TableView<Cliente> clientesView) { ClientesView =
		 * clientesView; }
		 * 
		 * public TableColumn<Cliente, Integer> getIdClienteColumn() { return
		 * idClienteColumn; }
		 * 
		 * public void setIdClienteColumn(TableColumn<Cliente, Integer> idClienteColumn)
		 * { this.idClienteColumn = idClienteColumn; }
		 * 
		 * public TableColumn<Cliente, String> getNombreClienteColumn() { return
		 * nombreClienteColumn; }
		 * 
		 * public void setNombreClienteColumn(TableColumn<Cliente, String>
		 * nombreClienteColumn) { this.nombreClienteColumn = nombreClienteColumn; }
		 */

		this.ProductosView = new TableView();

		// TableColumn<Usuario, String> firstNameColumn = new TableColumn<>("First
		// Name");
		this.nombreProductoColumn = new TableColumn<>("First Name");
		this.nombreProductoColumn.setCellValueFactory(new PropertyValueFactory<>("usuario"));

		this.precioProductoColumn = new TableColumn<>("Last Name");
		this.precioProductoColumn.setCellValueFactory(new PropertyValueFactory<>("contrasena"));

		this.ProductosView.getColumns().add(this.nombreProductoColumn);
		this.ProductosView.getColumns().add(this.precioProductoColumn);

		Usuario newUsr = new Usuario("Angel", "123");

		this.ProductosView.getItems().add(newUsr);
	
}
