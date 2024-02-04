package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController2 implements Initializable {

	@FXML
	private JFXTabPane View;

	@FXML
	private TableView<Producto> ProductosView;

	@FXML
	private TableView<Cliente> ClientesView;

	@FXML
	private TableView<Proveedor> ProveedorView;

	@FXML
	private JFXButton AñadirButton;

	@FXML
	private JFXButton BorrarButton;

	@FXML
	private JFXButton ModificarButton;

	@FXML
	private Tab tabProductos, tabClientes, tabProveedores;

	@FXML
	void onAñadirAction(ActionEvent event) {

	}

	@FXML
	void onBorrarAction(ActionEvent event) {

	}

	@FXML
	void onModificarButton(ActionEvent event) {

	}

	public static Vector<Producto> prl = new Vector<Producto>(); // Lista productos

	// Manejo archivos json
	public void serializarArrayAJson(Vector<Producto> productos) {

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter("productos.json")) {
			prettyGson.toJson(productos, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Vector<Producto> desserializarJsonAArray() {
		Vector<Producto> productos = new Vector<Producto>();

		try (Reader reader = new FileReader("productos.json")) {
			Gson gson = new Gson();
			Type tipoListaProductos = new TypeToken<Vector<Producto>>() {
			}.getType();
			productos = gson.fromJson(reader, tipoListaProductos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return productos;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Tabla Productos
		TableColumn<Producto, String> idProductoColumn = new TableColumn<>("ID");
		idProductoColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));

		TableColumn<Producto, String> nombreProductoColumn = new TableColumn<>("Nombre");
		nombreProductoColumn.setCellValueFactory(new PropertyValueFactory<>("Nombre"));

		TableColumn<Producto, String> codProveedorProductoColumn = new TableColumn<>("Codigo Proveedor");
		codProveedorProductoColumn.setCellValueFactory(new PropertyValueFactory<>("CodProveedor"));

		TableColumn<Producto, String> precioCompraProductoColumn = new TableColumn<>("Precio Compra");
		precioCompraProductoColumn.setCellValueFactory(new PropertyValueFactory<>("PrecioCompra"));

		TableColumn<Producto, String> precioVentaProductoColumn = new TableColumn<>("Precio Venta");
		precioVentaProductoColumn.setCellValueFactory(new PropertyValueFactory<>("PrecioVenta"));

		// TableColumn<Producto, String> caducidadProductoColumn = new
		// TableColumn<>("Caducidad");
		// caducidadProductoColumn.setCellValueFactory(new
		// PropertyValueFactory<>("Caducidad"));

		this.ProductosView.getColumns().add(idProductoColumn);
		this.ProductosView.getColumns().add(nombreProductoColumn);
		this.ProductosView.getColumns().add(codProveedorProductoColumn);
		this.ProductosView.getColumns().add(precioCompraProductoColumn);
		this.ProductosView.getColumns().add(precioVentaProductoColumn);
		// this.ProductosView.getColumns().add(caducidadProductoColumn);

		// Date dt = new Date(2025, 1, 29);
		// Producto newPrd = new Producto("1", "Gelatina", "Angel", 1, 3, dt);

		// this.ProductosView.getItems().add(newPrd);

		/*
		 * Atributos Producto private String ID; private String Nombre; private String
		 * CodProveedor; private double PrecioCompra; private double PrecioVenta;
		 * private Date Caducidad;
		 */
		MainController2 m2 = new MainController2();
		prl = m2.desserializarJsonAArray();

		for (int i = 0; i < prl.size(); i++) {
			this.ProductosView.getItems().add(prl.get(i));
		}

	}

}
