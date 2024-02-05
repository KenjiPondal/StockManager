package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
	private TableView<Proveedor> proveedores;

	@FXML
	private TableColumn<Proveedor, String> idPrvCol;

	@FXML
	private TableColumn<Proveedor, String> namePrvCol;

	@FXML
	private TableView<Cliente> clientes;

	@FXML
	private TableColumn<Cliente, String> idClCol;

	@FXML
	private TableColumn<Cliente, String> nameClCol;

	@FXML
	private JFXButton AñadirButton;

	@FXML
	private JFXButton BorrarButton;

	@FXML
	private JFXButton ModificarButton;

	@FXML
	private Tab tabProductos, tabClientes, tabProveedores;

	@FXML
	void onAñadirAction(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("/resource/Add.fxml");
	}

	@FXML
	void onBorrarAction(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("/resource/Delete.fxml");
	}

	@FXML
	void onModificarButton(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("/resource/Edit.fxml");
	}

	@FXML
	private TextField purchaseQuantityField; // Assume this is linked to your FXML

	@FXML
	void onPurchaseAction(ActionEvent event) {
		Producto selectedProduct = ProductosView.getSelectionModel().getSelectedItem();
		if (selectedProduct != null) {
			try {
				int quantityToPurchase = Integer.parseInt(purchaseQuantityField.getText());
				if (quantityToPurchase > 0) {

					boolean success = StockManager.processPurchase(selectedProduct.getID(), quantityToPurchase);
					if (success) {
						// Update UI accordingly
						refreshProductView();
						purchaseQuantityField.clear();
						// Optionally, show a success message
					} else {
						// Handle failure (e.g., not enough stock)
					}
				} else {
					// Handle invalid quantity input
				}
			} catch (NumberFormatException e) {
				// Handle invalid number format
			}
		} else {
			// Handle no product selected
		}
	}

	public static Vector<Producto> prl = new Vector<Producto>(); // Lista productos
	public static Vector<Proveedor> prvl = new Vector<Proveedor>(); // Lista proveedores
	public static Vector<Cliente> cll = new Vector<Cliente>(); // Lista clientes

	// Manejo archivos json
	// Productos

	public void refreshProductView() {
		// Clear the current items in the TableView
		ProductosView.getItems().clear();

		// Reload the updated list of products from the JSON file
		prl = desserializarJsonAArray();

		// Add the updated list of products to the TableView
		ProductosView.getItems().addAll(prl);
	}

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

	// Clientes
	public Vector<Cliente> desserializarJsonAArrayCl() {
		Vector<Cliente> clientes = new Vector<Cliente>();

		try (Reader reader = new FileReader("clientes.json")) {
			Gson gson = new Gson();
			Type tipoListaClientes = new TypeToken<Vector<Cliente>>() {
			}.getType();
			clientes = gson.fromJson(reader, tipoListaClientes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	// Proveedores
	public Vector<Proveedor> desserializarJsonAArrayPrv() {
		Vector<Proveedor> proveedores = new Vector<Proveedor>();

		try (Reader reader = new FileReader("proveedores.json")) {
			Gson gson = new Gson();
			Type tipoListaProveedores = new TypeToken<Vector<Proveedor>>() {
			}.getType();
			proveedores = gson.fromJson(reader, tipoListaProveedores);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return proveedores;
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

		// Tabla Proveedores
		idPrvCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("ID"));
		namePrvCol.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));
		// Tabla Clientes
		idClCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("ID"));
		nameClCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));

		MainController2 m2 = new MainController2();

		prl = m2.desserializarJsonAArray();
		prvl = m2.desserializarJsonAArrayPrv();
		cll = m2.desserializarJsonAArrayCl();

		for (int i = 0; i < prl.size(); i++) {
			this.ProductosView.getItems().add(prl.get(i));
		}
		for (int i = 0; i < prvl.size(); i++) {
			this.proveedores.getItems().add(prvl.get(i));
		}
		for (int i = 0; i < cll.size(); i++) {
			this.clientes.getItems().add(cll.get(i));
		}

	}

}
