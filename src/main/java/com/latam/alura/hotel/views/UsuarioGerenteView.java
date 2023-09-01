package com.latam.alura.hotel.views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.latam.alura.hotel.controller.UsuarioController;
import com.latam.alura.hotel.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Cursor;

public class UsuarioGerenteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private int xMouse, yMouse;

	public UsuarioGerenteView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 244, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
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
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 11, 142, 20);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(SystemColor.menu);
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 13));
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(50, 41, 142, 20);
		contentPane.add(txtUsuario);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 62, 142, 2);
		contentPane.add(separator_1);
		
		JLabel lblIngresaLaContrasea = new JLabel("Contraseña");
		lblIngresaLaContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaLaContrasea.setFont(new Font("Roboto", Font.BOLD, 15));
		lblIngresaLaContrasea.setBounds(50, 66, 142, 20);
		contentPane.add(lblIngresaLaContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(SystemColor.menu);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBorder(null);
		txtPassword.setBounds(50, 96, 142, 20);
		contentPane.add(txtPassword);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(50, 117, 142, 2);
		contentPane.add(separator_1_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(50, 167, 142, 36);
		contentPane.add(panel);
		
		JLabel lblIngresar = new JLabel("INGRESAR");
		lblIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] password = txtPassword.getPassword();
				String passwordIngresado = new String(password);
				String usuario= txtUsuario.getText();
				
				UsuarioController uc = new UsuarioController();
				Usuario userActual = uc.obtenerUsuario(usuario, passwordIngresado);
				
				if(userActual.getNivelDeAcceso().getId() == 1) {
					JOptionPane.showMessageDialog(null, "Ingreso Exitoso");
					dispose();
					MenuRegistro mr = new MenuRegistro();
					mr.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Ingreso Fallido o usuario no tiene permisos");
				}
				
			}
		});
		lblIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIngresar.setForeground(SystemColor.text);
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblIngresar.setBounds(0, 0, 142, 36);
		panel.add(lblIngresar);
		
		JPanel btnexit = new JPanel();
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(205, 0, 40, 36);
		contentPane.add(btnexit);
		
		
		JLabel labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 40, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
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
