package app;

public class Proveedor {
	private String ID;
	private String nombre;

	// Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	// Constructores
	public Proveedor(String nombre, String iD) {
		super();
		this.nombre = nombre;
		ID = iD;
	}

	public Proveedor() {
		this.nombre = "";
		this.ID = "";
	}

	// toString
	@Override
	public String toString() {
		return "Proveedor [nombre=" + nombre + ", ID=" + ID + "]";
	}
}
