package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasesBean.Mecanico;
import clasesDAO.MecanicoDAO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

public class NuevoMecanico extends JDialog implements ActionListener
{
	private static JTextField txtNombre;
	private static JTextField txtApellido1;
	private static JTextField txtApellido2;
	private static JTextField txtDNI;
	private static JTextField txtSueldo;
	static JButton btnCrear = new JButton("Crear");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			NuevoMecanico dialog = new NuevoMecanico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuevoMecanico()
	{
		setTitle("Nuevo Mecanico");
		setBounds(100, 100, 450, 226);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 1;
			getContentPane().add(lblNombre, gbc_lblNombre);
		}
		{
			txtNombre = new JTextField();
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 2;
			gbc_txtNombre.gridy = 1;
			getContentPane().add(txtNombre, gbc_txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblApellido = new JLabel("Apellido 1:");
			GridBagConstraints gbc_lblApellido = new GridBagConstraints();
			gbc_lblApellido.anchor = GridBagConstraints.EAST;
			gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellido.gridx = 1;
			gbc_lblApellido.gridy = 2;
			getContentPane().add(lblApellido, gbc_lblApellido);
		}
		{
			txtApellido1 = new JTextField();
			GridBagConstraints gbc_txtApellido1 = new GridBagConstraints();
			gbc_txtApellido1.insets = new Insets(0, 0, 5, 0);
			gbc_txtApellido1.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtApellido1.gridx = 2;
			gbc_txtApellido1.gridy = 2;
			getContentPane().add(txtApellido1, gbc_txtApellido1);
			txtApellido1.setColumns(10);
		}
		{
			JLabel lblApellido_1 = new JLabel("Apellido 2:");
			GridBagConstraints gbc_lblApellido_1 = new GridBagConstraints();
			gbc_lblApellido_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellido_1.anchor = GridBagConstraints.EAST;
			gbc_lblApellido_1.gridx = 1;
			gbc_lblApellido_1.gridy = 3;
			getContentPane().add(lblApellido_1, gbc_lblApellido_1);
		}
		{
			txtApellido2 = new JTextField();
			GridBagConstraints gbc_txtApellido2 = new GridBagConstraints();
			gbc_txtApellido2.insets = new Insets(0, 0, 5, 0);
			gbc_txtApellido2.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtApellido2.gridx = 2;
			gbc_txtApellido2.gridy = 3;
			getContentPane().add(txtApellido2, gbc_txtApellido2);
			txtApellido2.setColumns(10);
		}
		{
			JLabel lblDni = new JLabel("DNI:");
			GridBagConstraints gbc_lblDni = new GridBagConstraints();
			gbc_lblDni.insets = new Insets(0, 0, 5, 5);
			gbc_lblDni.anchor = GridBagConstraints.EAST;
			gbc_lblDni.gridx = 1;
			gbc_lblDni.gridy = 4;
			getContentPane().add(lblDni, gbc_lblDni);
		}
		{
			txtDNI = new JTextField();
			GridBagConstraints gbc_txtDNI = new GridBagConstraints();
			gbc_txtDNI.insets = new Insets(0, 0, 5, 0);
			gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDNI.gridx = 2;
			gbc_txtDNI.gridy = 4;
			getContentPane().add(txtDNI, gbc_txtDNI);
			txtDNI.setColumns(10);
		}
		{
			JLabel lblSueldo = new JLabel("Sueldo:");
			GridBagConstraints gbc_lblSueldo = new GridBagConstraints();
			gbc_lblSueldo.insets = new Insets(0, 0, 5, 5);
			gbc_lblSueldo.anchor = GridBagConstraints.EAST;
			gbc_lblSueldo.gridx = 1;
			gbc_lblSueldo.gridy = 5;
			getContentPane().add(lblSueldo, gbc_lblSueldo);
		}
		{
			txtSueldo = new JTextField();
			GridBagConstraints gbc_txtSueldo = new GridBagConstraints();
			gbc_txtSueldo.insets = new Insets(0, 0, 5, 0);
			gbc_txtSueldo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSueldo.gridx = 2;
			gbc_txtSueldo.gridy = 5;
			getContentPane().add(txtSueldo, gbc_txtSueldo);
			txtSueldo.setColumns(10);
		}
		{
			JPanel pnl = new JPanel();
			GridBagConstraints gbc_pnl = new GridBagConstraints();
			gbc_pnl.gridwidth = 3;
			gbc_pnl.fill = GridBagConstraints.BOTH;
			gbc_pnl.gridx = 0;
			gbc_pnl.gridy = 6;
			getContentPane().add(pnl, gbc_pnl);
			{
				
				pnl.add(btnCrear);
			}
		}
		btnCrear.addActionListener(this);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(txtNombre.getText().isEmpty()||txtApellido1.getText().isEmpty()||txtApellido2.getText().isEmpty()||txtSueldo.getText().isEmpty()||txtDNI.getText().isEmpty())
			JOptionPane.showMessageDialog(getContentPane(), "Rellene los campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
		else if(!ControlErrores.isNumeric(txtSueldo.getText()))
		{
			JOptionPane.showMessageDialog(getContentPane(), "El sueldo tiene que ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		CrearMecanico();
		
	}
	public void CrearMecanico(){
		List<Mecanico> busqueda2 = MecanicoDAO.buscarTodos();
		int id=0;
		for (Mecanico m : busqueda2)
		{
			if(m.getIdMecanico()>id)
			id=m.getIdMecanico();
		
		}
		id++;
		Mecanico Mecanico = new Mecanico(id,txtNombre.getText(),txtApellido1.getText(),txtApellido2.getText(),txtDNI.getText(),Integer.parseInt(txtSueldo.getText()));
		MecanicoDAO.guardar(Mecanico);
		Principal.ActualizarTablas();
		setVisible(false);
	}
	public static void VaciarCampos(){
		txtNombre.setText("");
		txtApellido1.setText("");
		txtApellido2.setText("");
		txtDNI.setText("");
		txtSueldo.setText("");
	}


}
