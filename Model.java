package app;

import javafx.scene.paint.Color;

public class Model {
	
	static AppController controller;
	
	public static boolean BuscarUsuario(String nombre) {
		boolean respuesta = false;
		if(nombre.equals("ADMIN")) {
			respuesta = true;
		}else{
			respuesta = false;
		}


		System.out.println("Usuario: "+nombre+" Boolean: "+respuesta);
		return respuesta;
	}
	public static boolean BuscarContraseña(String nombre, String contraseña) {
		boolean respuesta = true;
		
		
		//buscar dentro dentro de los datos de usuarios si el nombre de usuario
		//tiene asignada alguna contrseña de ser asi comprobar si es correcta
		
		
		return respuesta;
	}
	public  void ComprobarDatos() {
		/*
		if(BuscarUsuario(controller.getUsuarioTextField().getText())
				&& 
		   BuscarContraseña(controller.getUsuarioTextField().getText().toString(),
				   				  controller.getContraseñaTextField().getText().toString()))
		{
			
    		controller.setRegistroText("Acceso Permitido");
    		controller.getRegistroText().setTextFill(Color.color(0, 1, 0));
    		System.out.println("Acceso Permitido");
    		System.out.println(controller.getUsuarioTextField().getText().toString());
    		System.out.println(controller.getContraseñaTextField().getText().toString());
    		
    	}else if(controller.getUsuarioTextField().getText().toString().equals("") 
    				&& 
    			 controller.getContraseñaTextField().getText().toString().equals("") ){
    		
    		controller.setRegistroText("No ha introducido datos");
    		controller.getRegistroText().setTextFill(Color.color(1, 0, 0));
    		System.out.println("No ha introducido datos");
    		System.out.println(controller.getUsuarioTextField().getText().toString());
    		System.out.println(controller.getContraseñaTextField().getText().toString());
    	}else {
    		controller.setRegistroText("Datos incorrectos");
    		controller.getRegistroText().setTextFill(Color.color(1, 0, 0));
    		System.out.println("Datos Incorrectos");
    		System.out.println(controller.getUsuarioTextField().getText().toString());
    		System.out.println(controller.getContraseñaTextField().getText().toString());
    	}
    	*/
	}
	
	

}
