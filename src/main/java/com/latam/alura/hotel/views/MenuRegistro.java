package com.latam.alura.hotel.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.latam.alura.hotel.controller.NivelDeAccesoController;
import com.latam.alura.hotel.controller.UsuarioController;
import com.latam.alura.hotel.modelo.NivelDeAcceso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Cursor;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import java.awt.event.MouseMotionAdapter;

public class MenuRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JPasswordField txtPassword2;
	private JTextField txtNombre;
	private JComboBox<NivelDeAcceso> txtNivelAcceso;
	private int xMouse, yMouse;

	public MenuRegistro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		setTitle("Registro de usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 420);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 105, 142, 20);
		contentPane.add(lblNewLabel);

		JLabel lblIngresaLaContrasea = new JLabel("Contraseña");
		lblIngresaLaContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaLaContrasea.setFont(new Font("Roboto", Font.BOLD, 15));
		lblIngresaLaContrasea.setBounds(50, 160, 142, 20);
		contentPane.add(lblIngresaLaContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 13));
		txtUsuario.setBounds(50, 135, 142, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(50, 190, 142, 20);
		contentPane.add(txtPassword);

		txtNivelAcceso = new JComboBox<NivelDeAcceso>();
		txtNivelAcceso.setBounds(50, 304, 142, 22);
		txtNivelAcceso.setBackground(SystemColor.text);
		contentPane.add(txtNivelAcceso);
		if(new UsuarioController().esPrimeraVez()) {
			txtNivelAcceso.setEnabled(false);
		}

		List<NivelDeAcceso> nivelesDeAcceso = new NivelDeAccesoController().ListarNiveles();
		for (NivelDeAcceso nivelDeAcceso : nivelesDeAcceso) {
			txtNivelAcceso.addItem(nivelDeAcceso);
		}

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(50, 357, 142, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
				JLabel lblGuardar = new JLabel("Guardar usuario");
				lblGuardar.setForeground(SystemColor.textHighlightText);
				lblGuardar.setBounds(0, 0, 142, 36);
				panel.add(lblGuardar);
				lblGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblGuardar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						char[] passwordChars = txtPassword.getPassword();
						char[] passwordChars2 = txtPassword2.getPassword();
						String password = new String(passwordChars);
						String password2 = new String(passwordChars2);
						String usuario = txtUsuario.getText();
						String nombre = txtNombre.getText();
						NivelDeAcceso nivelSeleccionado = (NivelDeAcceso) txtNivelAcceso.getSelectedItem();
						

						if (!usuario.isEmpty() && !nombre.isEmpty() && passwordChars != null && passwordChars2 != null) {
							if (password.equals(password2)) {
								UsuarioController uc = new UsuarioController();
								uc.nuevoUsuario(nombre,usuario, password, nivelSeleccionado);
								JOptionPane.showMessageDialog(null, "Usuario Creado con exito");
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
							}

						} else {
							JOptionPane.showMessageDialog(null, "Debes ingresar todos los campos");
						}

					}
				});
				lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
				lblGuardar.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel lblRepiteLaContrasea = new JLabel("Repite la contraseña");
		lblRepiteLaContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepiteLaContrasea.setFont(new Font("Roboto", Font.BOLD, 15));
		lblRepiteLaContrasea.setBounds(50, 215, 142, 20);
		contentPane.add(lblRepiteLaContrasea);

		txtPassword2 = new JPasswordField();
		txtPassword2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword2.setBorder(null);
		txtPassword2.setBounds(50, 245, 142, 20);
		contentPane.add(txtPassword2);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Roboto", Font.BOLD, 15));
		lblNombre.setBounds(50, 50, 142, 20);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBorder(null);
		txtNombre.setBounds(50, 80, 142, 20);
		contentPane.add(txtNombre);

		JSeparator separator = new JSeparator();
		separator.setBounds(50, 101, 142, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 156, 142, 2);
		contentPane.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(50, 211, 142, 2);
		contentPane.add(separator_1_1);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(50, 266, 142, 2);
		contentPane.add(separator_1_2);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MenuRegistro.class.getResource("/imagenes/aH-40px.png")));
		lblNewLabel_2.setBounds(100, 3, 40, 36);
		contentPane.add(lblNewLabel_2);

		JPanel btnexit = new JPanel();
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(233, 0, 40, 36);

		contentPane.add(btnexit);

		JLabel labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 40, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario");
		lblTipoDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeUsuario.setFont(new Font("Roboto", Font.BOLD, 15));
		lblTipoDeUsuario.setBounds(50, 273, 142, 20);
		contentPane.add(lblTipoDeUsuario);

		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(new Color(12, 138, 199));
				labelExit.setForeground(Color.white);
			}
		});
	}

	
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
