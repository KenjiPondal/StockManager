package app;

public class Producto {

	private String ID;
	private String Nombre;
	private String CodProveedor;
	private double PrecioCompra;
	private double PrecioVenta;
	// private Date Caducidad;

	// CONSTRUCTOR
	public Producto(String iD, String nombre, String codProveedor, double precioCompra, double precioVenta) {
		ID = iD;
		Nombre = nombre;
		CodProveedor = codProveedor;
		PrecioCompra = precioCompra;
		PrecioVenta = precioVenta;
		// Caducidad = caducidad;
	}

	// GETTER AND SETTER
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCodProveedor() {
		return CodProveedor;
	}

	public void setCodProveedor(String codProveedor) {
		CodProveedor = codProveedor;
	}

	public double getPrecioCompra() {
		return PrecioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		PrecioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return PrecioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		PrecioVenta = precioVenta;
	}

	/*
	 * public Date getCaducidad() { return Caducidad; }
	 * 
	 * public void setCaducidad(Date caducidad) { Caducidad = caducidad; }
	 */

	public Producto() {
		super();
	}

	@Override
	public String toString() {
		return "Producto [ID=" + ID + ", Nombre=" + Nombre + ", CodProveedor=" + CodProveedor + ", PrecioCompra="
				+ PrecioCompra + ", PrecioVenta=" + PrecioVenta + "]";
	}

}
