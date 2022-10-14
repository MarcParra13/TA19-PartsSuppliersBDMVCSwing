package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistasCRUD extends JFrame {

	private JPanel contentPane;
	int menu;
	int operacion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistasCRUD frame = new VistasCRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public int menu() {
		return menu;
	}
	
	public String anadirRegistro() {
		
		String anadirCodigo = JOptionPane.showInputDialog("Qué código quieres añadir? (4 num)");
		Integer.parseInt(anadirCodigo);
		
		String anadirNombre = JOptionPane.showInputDialog("Qué nombre quieres añadir?");
		
		return "\'" + anadirCodigo + "\'" + ", " + "\'" + anadirNombre + "\'";
		
	}
	
	public String consultarRegistro() {
		
		String consultarRegistro = "";
		
		String consulta = JOptionPane.showInputDialog("Quieres buscar un codigo o un nombre?");
		
		if(consulta.equalsIgnoreCase("Codigo")) {
			String consultarNombre = JOptionPane.showInputDialog("Introduce el nombre");
			
			consultarRegistro = "Nombre = " + "'" + consultarNombre + "'";
			
			
		} else if (consulta.equalsIgnoreCase("Nombre")) {
			String consultarCodigo = JOptionPane.showInputDialog("Introduce el código (4 num)");
			Integer.parseInt(consultarCodigo);
			
			consultarRegistro = "Codigo = " + consultarCodigo;
		}
		
		
		return consultarRegistro;
		
	}
	
	public String actualizarRegistro() {
		String actualizarRegistro = "";
		
		String actualizar = JOptionPane.showInputDialog("Qué columna quieres modificar?");
		
		if(actualizar.equalsIgnoreCase("Codigo")) {
			String actualizarCodigo = JOptionPane.showInputDialog("Nombre?");
			String actualizarValor = JOptionPane.showInputDialog("Valor?");
			
			actualizarRegistro = "Codigo = " + actualizarValor + " WHERE Nombre = " + "'" + actualizarCodigo + "'";
			
		} else if(actualizar.equalsIgnoreCase("Nombre")) {
			String actualizarNombre = JOptionPane.showInputDialog("Código? (4 num)");
			String actualizarValor = JOptionPane.showInputDialog("Valor?");
			
			actualizarRegistro = "Nombre = " + "'" + actualizarValor + "'" + " WHERE Codigo = " + actualizarNombre;
		}
		
		return actualizarRegistro;
		
	}
	
	public static int eliminarRegistro() {
		String eliminarRegistro = JOptionPane.showInputDialog("De qué Código quieres eliminar la pieza? (4 num)");

		return Integer.parseInt(eliminarRegistro);
	}
	
	public VistasCRUD() {
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAnadir = new JButton("Añadir registro");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				anadirRegistro();
				operacion = 41;
			}
		});
		btnAnadir.setBounds(53, 29, 148, 84);
		contentPane.add(btnAnadir);
		
		JButton btnConsultar = new JButton("Consultar ID/Nombre");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consultarRegistro();
				operacion = 42;
			}
		});
		btnConsultar.setBounds(211, 29, 161, 84);
		contentPane.add(btnConsultar);
		
		JButton btnActualizar = new JButton("Listar registro");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				operacion = 43;
			}
		});
		btnActualizar.setBounds(53, 124, 148, 68);
		contentPane.add(btnActualizar);
		
		JButton btnListar = new JButton("Actualizar registro");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizarRegistro();
				operacion = 44;
			}
		});
		btnListar.setBounds(211, 124, 161, 68);
		contentPane.add(btnListar);
		
		JButton btnBorrar = new JButton("Borrar registro");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminarRegistro();
				operacion = 45;
			}
		});
		btnBorrar.setBounds(138, 202, 137, 68);
		contentPane.add(btnBorrar);
	}
}
