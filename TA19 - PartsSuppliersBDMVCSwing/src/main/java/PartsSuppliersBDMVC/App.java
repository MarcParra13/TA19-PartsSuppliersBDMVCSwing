package PartsSuppliersBDMVC;

import Controller.Controlador;
import Model.Modelo;
import View.Vistas;
import View.VistasCRUD;

public class App {
	public void main(String[] args) {
		Modelo model = new Modelo();
		Vistas view = new Vistas();
		VistasCRUD view2 = new VistasCRUD();
		
		Controlador controller = new Controlador(model, view, view2);
		
		controller.iniciarVista();

	}
}
