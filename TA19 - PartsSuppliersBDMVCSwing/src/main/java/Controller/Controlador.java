package Controller;

import java.sql.SQLException;

import Model.Conexion;
import Model.Modelo;
import View.Vistas;
import View.VistasCRUD;

public class Controlador {
	private Modelo model;
	private Vistas view;
	private VistasCRUD view2;
	
	public Controlador(Modelo model, Vistas view, VistasCRUD view2) {
		this.model = model;
		this.view = view;
		this.view2 = view2;
	}

	public void iniciarVista() {
		try {
			if (Conexion.getConnection() != null) {
				int mostrarMenu;

				do {
					mostrarMenu = view.menu();
					
					switch (mostrarMenu) {
					case 1:
						if (Modelo.inicializacionTabla()) {
							view.mostrarMensaje("Inicilización de tablas correcta.");
							break;
						} else {
							view.mostrarMensaje("Error al inicializar las tablas.");
						}
						break;
					case 2:
						if (Modelo.insertarPaqueteDatos()) {
							view.mostrarMensaje("Paquete de datos insertados correctamente.");
						} else {
							view.mostrarMensaje("Error al insertar el paquete de datos. No hay tabla.");
						}
						break;
					case 3:
						if (Modelo.borrarTabla()) {
							view.mostrarMensaje("Tabla borrada correctamente.");
						} else {
							view.mostrarMensaje("Tabla no borrada. Ya está borrada.");
						}
						break;
					case 41:
						
						String anadirRegistro = view2.anadirRegistro();
						
						if (Modelo.añadirRegistro(anadirRegistro)) {
							view.mostrarMensaje("Registro añadido correctamente.");
						} else {
							view.mostrarMensaje("Error al añadir el registro. No hay tabla.");
						}
						break;
					case 42:
						
						String consultarRegistro = view2.consultarRegistro();
						
						if (Modelo.consultarIDNombre(consultarRegistro)) {
							view.mostrarMensaje("Consulta realizada correctamente");
						} else {
							view.mostrarMensaje("Error al consultar los datos. No hay tabla.");
						}
						break;
					case 43:
						if (Modelo.listarTabla()) {
							view.mostrarMensaje("Tabla listada correctamente.");
						} else {
							view.mostrarMensaje("Error al listar la tabla. No hay tabla.");
						}
						break;
					case 44:
						
						String actualizarRegistro = view2.actualizarRegistro();
						
						if (Modelo.actualizarRegistro(actualizarRegistro)) {
							view.mostrarMensaje("Registro actualizado correctamente");
						} else {
							view.mostrarMensaje("Error al actualizar el registro. No hay tabla.");
						}
						break;
					case 45:
						
						int eliminarRegistro = VistasCRUD.eliminarRegistro();
						
						if (Modelo.eliminarRegistro(eliminarRegistro)) {
							view.mostrarMensaje("Registro eliminado correctamente");
						} else {
							view.mostrarMensaje("Error al eliminar el registro. No hay tabla.");
						}
						break;
					case 5:
						view.mostrarMensaje("Conexion cerrada correctamente");
						Conexion.getConnection().close();
						break;
					default:
						view.mostrarMensaje("Algo ha salido mal...");
					}
				} while (mostrarMenu != 5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
