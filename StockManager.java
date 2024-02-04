package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class StockManager {
	private List<Producto> productos;
	private List<Usuario> usuarios;
	private Gson gson;
	private static final String PRODUCTOS_JSON_FILE_PATH = "productos.json";
	private static final String USUARIOS_JSON_FILE_PATH = "usuarios.json";

	public StockManager() {
		gson = new Gson();
		productos = loadDataFromJson(PRODUCTOS_JSON_FILE_PATH, new TypeToken<ArrayList<Producto>>() {
		});
		usuarios = loadDataFromJson(USUARIOS_JSON_FILE_PATH, new TypeToken<ArrayList<Usuario>>() {
		});
	}

	// Add a product to the stock
	public void addProduct(Producto producto) {
		productos.add(producto);
		saveDataToJson(PRODUCTOS_JSON_FILE_PATH, productos);
	}

	// Update the quantity of a product in the stock
	public void updateProductQuantity(String productId, int newQuantity) {
		// Implement update logic here
	}

	// Remove a product from the stock
	public void removeProduct(String productId) {
		// Implement removal logic here
	}

	// Add a user to the list
	public void addUser(Usuario usuario) {
		usuarios.add(usuario);
		saveDataToJson(USUARIOS_JSON_FILE_PATH, usuarios);
	}

	public Vector<Usuario> desserializarJsonAArray() {
		return StockManager.getUsuarios();
	}

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

}
