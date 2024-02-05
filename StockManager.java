package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class StockManager {
	private List<Producto> productos;
	private List<Usuario> usuarios;
	private List<Cliente> clientes; // Added list for clients
	private List<Proveedor> proveedores; // Added list for providers
	private Gson gson;
	private static final String PRODUCTOS_JSON_FILE_PATH = "productos.json";
	private static final String USUARIOS_JSON_FILE_PATH = "usuarios.json";
	private static final String CLIENTES_JSON_FILE_PATH = "clientes.json"; // File path for clients
	private static final String PROVEEDORES_JSON_FILE_PATH = "proveedores.json"; // File path for providers

	public StockManager() {
		gson = new Gson();
		productos = loadDataFromJson(PRODUCTOS_JSON_FILE_PATH, new TypeToken<ArrayList<Producto>>() {
		}.getType());
		usuarios = loadDataFromJson(USUARIOS_JSON_FILE_PATH, new TypeToken<ArrayList<Usuario>>() {
		}.getType());
		clientes = loadDataFromJson(CLIENTES_JSON_FILE_PATH, new TypeToken<ArrayList<Cliente>>() {
		}.getType()); // Load clients from JSON
		proveedores = loadDataFromJson(PROVEEDORES_JSON_FILE_PATH, new TypeToken<ArrayList<Proveedor>>() {
		}.getType()); // Load providers from JSON
	}

	// Add a product to the stock
	public void addProduct(Producto producto) {
		productos.add(producto);
		saveDataToJson(PRODUCTOS_JSON_FILE_PATH, productos);
	}

	// Update the quantity of a product in the stock
	public void updateProductQuantity(String productId, int newQuantity) {
		for (Producto producto : productos) {
			if (producto.getID().equals(productId)) {
				// producto.setCantidad(newQuantity);
				saveDataToJson(PRODUCTOS_JSON_FILE_PATH, productos);
				break;
			}
		}
	}

	// Remove a product from the stock
	public void removeProduct(String productId) {
		productos.removeIf(producto -> producto.getID().equals(productId));
		saveDataToJson(PRODUCTOS_JSON_FILE_PATH, productos);
	}

	// Add a user to the list
	public void addUser(Usuario usuario) {
		usuarios.add(usuario);
		saveDataToJson(USUARIOS_JSON_FILE_PATH, usuarios);
	}

	// public Vector<Usuario> desserializarJsonAArray() {
	// return StockManager.getUsuarios();
	// }

	// Display the current stock
	public void displayStock() {
		// Implement display logic here
	}

	// Save data to JSON file
	private <T> void saveDataToJson(String filePath, List<T> data) {
		try (FileWriter writer = new FileWriter(filePath)) {
			gson.toJson(data, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Load data from JSON file
	private <T> List<T> loadDataFromJson(String filePath, Type type) {
		try (Reader reader = new FileReader(filePath)) {
			return gson.fromJson(reader, type);
		} catch (IOException e) {
			return new ArrayList<>();
		}
	}
	// Getters and Setters

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public static void main(String[] args) {
		StockManager sm = new StockManager();
		for (Producto p : sm.getProductos()) {
			System.out.println(p.toString());
		}
		for (Usuario u : sm.getUsuarios()) {
			System.out.println(u.toString());
		}
	}

	// Methods for managing clients
	public void addClient(Cliente cliente) {
		clientes.add(cliente);
		saveDataToJson(CLIENTES_JSON_FILE_PATH, clientes);
	}

	public void removeClient(String clientId) {
		clientes.removeIf(cliente -> cliente.getID().equals(clientId));
		saveDataToJson(CLIENTES_JSON_FILE_PATH, clientes);
	}

	public void listClients() {
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

	// Method to add a provider
	public void addProvider(Proveedor proveedor) {
		proveedores.add(proveedor);
		saveDataToJson(PROVEEDORES_JSON_FILE_PATH, proveedores);
	}

	// Method to remove a provider by ID
	public void removeProvider(String providerId) {
		proveedores.removeIf(proveedor -> proveedor.getID().equals(providerId));
		saveDataToJson(PROVEEDORES_JSON_FILE_PATH, proveedores);
	}

	// Method to list all providers
	public void listProviders() {
		for (Proveedor proveedor : proveedores) {
			System.out.println(proveedor);
		}
	}

	// Method to process a purchase
	public void processPurchase(List<Producto> purchasedProducts) {
		// Remove sold products from stock
		productos.removeAll(purchasedProducts);
		saveDataToJson(PRODUCTOS_JSON_FILE_PATH, productos);

		// Add transaction to sales history
		addTransactionToSalesHistory(purchasedProducts);
	}

	// Method to add transaction details to sales history JSON file
	private void addTransactionToSalesHistory(List<Producto> purchasedProducts) {
		// Assuming there's a class Transaction to represent the transaction details
		// and a method getSalesHistoryFilePath() to get the path of the sales history
		// JSON file
		List<Transaction> salesHistory = loadDataFromJson(getSalesHistoryFilePath(),
				new TypeToken<ArrayList<Transaction>>() {
				}.getType());
		Transaction transaction = new Transaction(purchasedProducts);
		salesHistory.add(transaction);
		saveDataToJson(getSalesHistoryFilePath(), salesHistory);
	}

	public void processSale(String productId, int quantitySold) {
		for (Producto producto : productos) {
			if (producto.getID().equals(productId)) {
				int newQuantity = producto.getQuantity() - quantitySold;
				if (newQuantity >= 0) {
					producto.setQuantity(newQuantity);
					saveDataToJson(PRODUCTOS_JSON_FILE_PATH, productos);
					System.out.println("Sale processed for product ID: " + productId);
				} else {
					System.out.println("Insufficient stock for product ID: " + productId);
				}
				break;
			}
		}
	}
}