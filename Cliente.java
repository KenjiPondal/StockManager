package app;

public class Cliente {
	private String nombre;
	private String ID;

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
	public Cliente(String nombre, String iD) {
		super();
		this.nombre = nombre;
		ID = iD;
	}

	public Cliente() {
		this.nombre = "";
		this.ID = "";
	}

	// toString
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", ID=" + ID + "]";
	}

}
