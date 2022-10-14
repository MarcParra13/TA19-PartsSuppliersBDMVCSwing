package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Vistas extends JFrame {

	private JPanel contentPane;
	int operacion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vistas frame = new Vistas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int menu() {
		return operacion;
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
		operacion = 0;
	}
	
	public int showMessageDialog(String msg) {
		int showMessageDialog = JOptionPane.showConfirmDialog(null,
				msg, "Aviso", JOptionPane.YES_NO_OPTION);
		
		return showMessageDialog;
	}

	public Vistas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CRUD MVC");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(97, 11, 156, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnInicializarTablas = new JButton("Inicializar tablas");
		btnInicializarTablas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showMessageDialog("Quieres inicilizar las tablas?") == 0) {
					operacion = 1;
				} else {
				}
			}
		});
		btnInicializarTablas.setBounds(97, 60, 156, 50);
		contentPane.add(btnInicializarTablas);

		JButton btnInsertarDatos = new JButton("Insertar datos");
		btnInsertarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showMessageDialog("Quieres insertar datos?") == 0) {
					operacion = 2;
				} else {
				}
			}
		});
		btnInsertarDatos.setBounds(97, 136, 156, 53);
		contentPane.add(btnInsertarDatos);

		JButton btnBorrarTabla = new JButton("Borrar tabla");
		btnBorrarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showMessageDialog("Quieres borrar la tabla?") == 0) {
					operacion = 3;
				} else {
				}
			}
		});
		btnBorrarTabla.setBounds(97, 220, 156, 50);
		contentPane.add(btnBorrarTabla);

		JButton btnCRUD = new JButton("CRUD");
		btnCRUD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistasCRUD.main(null);
			}
		});
		btnCRUD.setBounds(97, 301, 156, 44);
		contentPane.add(btnCRUD);
	}
}
