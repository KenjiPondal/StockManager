package app;

public class Usuario {
	// Atributos
	private String usuario;
	private String contrasena;

	public String getUsuario() {
		return usuario;
	}

	// Getters and setters
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	// Constructores
	public Usuario(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public Usuario() {
		this.usuario = "";
		this.contrasena = "";
	}

	// toString
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}

}
