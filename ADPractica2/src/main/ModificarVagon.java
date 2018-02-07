package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasesBean.Vagon;
import clasesDAO.VagonDAO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.List;

import javax.swing.JTextField;

public class ModificarVagon extends JDialog implements ActionListener {
	private JTextField txtFabricante;
	private JTextField txtModelo;
	private JTextField txtAntiguedad;
	private JTextField txtCapacidad;
	private JTextField txtMatricula;
	static JButton btnGuardar = new JButton("Guardar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuevoVagon dialog = new NuevoVagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarVagon() {
		ayuda();
		setTitle("Modificar Vagón");
		setBounds(100, 100, 450, 222);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblFabricante = new JLabel("Fabricante:");
			GridBagConstraints gbc_lblFabricante = new GridBagConstraints();
			gbc_lblFabricante.anchor = GridBagConstraints.EAST;
			gbc_lblFabricante.insets = new Insets(0, 0, 5, 5);
			gbc_lblFabricante.gridx = 1;
			gbc_lblFabricante.gridy = 1;
			getContentPane().add(lblFabricante, gbc_lblFabricante);
		}
		{
			txtFabricante = new JTextField();
			GridBagConstraints gbc_txtFabricante = new GridBagConstraints();
			gbc_txtFabricante.insets = new Insets(0, 0, 5, 0);
			gbc_txtFabricante.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFabricante.gridx = 2;
			gbc_txtFabricante.gridy = 1;
			getContentPane().add(txtFabricante, gbc_txtFabricante);
			txtFabricante.setColumns(10);
		}
		{
			JLabel lblModelo = new JLabel("Modelo:");
			GridBagConstraints gbc_lblModelo = new GridBagConstraints();
			gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
			gbc_lblModelo.anchor = GridBagConstraints.EAST;
			gbc_lblModelo.gridx = 1;
			gbc_lblModelo.gridy = 2;
			getContentPane().add(lblModelo, gbc_lblModelo);
		}
		{
			txtModelo = new JTextField();
			GridBagConstraints gbc_txtModelo = new GridBagConstraints();
			gbc_txtModelo.insets = new Insets(0, 0, 5, 0);
			gbc_txtModelo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtModelo.gridx = 2;
			gbc_txtModelo.gridy = 2;
			getContentPane().add(txtModelo, gbc_txtModelo);
			txtModelo.setColumns(10);
		}
		{
			JLabel lblAntigedad = new JLabel("Antig\u00FCedad:");
			GridBagConstraints gbc_lblAntigedad = new GridBagConstraints();
			gbc_lblAntigedad.insets = new Insets(0, 0, 5, 5);
			gbc_lblAntigedad.anchor = GridBagConstraints.EAST;
			gbc_lblAntigedad.gridx = 1;
			gbc_lblAntigedad.gridy = 3;
			getContentPane().add(lblAntigedad, gbc_lblAntigedad);
		}
		{
			txtAntiguedad = new JTextField();
			GridBagConstraints gbc_txtAntiguedad = new GridBagConstraints();
			gbc_txtAntiguedad.insets = new Insets(0, 0, 5, 0);
			gbc_txtAntiguedad.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAntiguedad.gridx = 2;
			gbc_txtAntiguedad.gridy = 3;
			getContentPane().add(txtAntiguedad, gbc_txtAntiguedad);
			txtAntiguedad.setColumns(10);
		}
		{
			JLabel lblCapacidad = new JLabel("Capacidad:");
			GridBagConstraints gbc_lblCapacidad = new GridBagConstraints();
			gbc_lblCapacidad.insets = new Insets(0, 0, 5, 5);
			gbc_lblCapacidad.anchor = GridBagConstraints.EAST;
			gbc_lblCapacidad.gridx = 1;
			gbc_lblCapacidad.gridy = 4;
			getContentPane().add(lblCapacidad, gbc_lblCapacidad);
		}
		{
			txtCapacidad = new JTextField();
			GridBagConstraints gbc_txtCapacidad = new GridBagConstraints();
			gbc_txtCapacidad.insets = new Insets(0, 0, 5, 0);
			gbc_txtCapacidad.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCapacidad.gridx = 2;
			gbc_txtCapacidad.gridy = 4;
			getContentPane().add(txtCapacidad, gbc_txtCapacidad);
			txtCapacidad.setColumns(10);
		}
		{
			JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
			GridBagConstraints gbc_lblMatrcula = new GridBagConstraints();
			gbc_lblMatrcula.insets = new Insets(0, 0, 5, 5);
			gbc_lblMatrcula.anchor = GridBagConstraints.EAST;
			gbc_lblMatrcula.gridx = 1;
			gbc_lblMatrcula.gridy = 5;
			getContentPane().add(lblMatrcula, gbc_lblMatrcula);
		}
		{
			txtMatricula = new JTextField();
			GridBagConstraints gbc_txtMatricula = new GridBagConstraints();
			gbc_txtMatricula.insets = new Insets(0, 0, 5, 0);
			gbc_txtMatricula.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtMatricula.gridx = 2;
			gbc_txtMatricula.gridy = 5;
			getContentPane().add(txtMatricula, gbc_txtMatricula);
			txtMatricula.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 3;
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 6;
			getContentPane().add(panel, gbc_panel);
			{

				panel.add(btnGuardar);
			}
		}
		btnGuardar.addActionListener(this);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(txtAntiguedad.getText().isEmpty()||txtMatricula.getText().isEmpty()||txtCapacidad.getText().isEmpty()||txtFabricante.getText().isEmpty()||txtModelo.getText().isEmpty())
			JOptionPane.showMessageDialog(getContentPane(), "Rellene los campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
		else if (!ControlErrores.isNumeric(txtAntiguedad.getText())) {
			JOptionPane.showMessageDialog(getContentPane(), "La antiguedad tiene que ser un número entero", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (!ControlErrores.isNumeric(txtMatricula.getText())) {
			JOptionPane.showMessageDialog(getContentPane(), "La matricula tiene que ser un número entero", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (!ControlErrores.isNumeric(txtCapacidad.getText())) {
			JOptionPane.showMessageDialog(getContentPane(), "La capacidad tiene que ser un número entero", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else
			GuardarVagon();

	}

	public void GuardarVagon() {
		Vagon v = VagonDAO.buscarPorID(Principal.idVagon);
		v.setAntiguedadVagon(Integer.parseInt(txtAntiguedad.getText()));
		v.setCapacidadVagon(Integer.parseInt(txtCapacidad.getText()));
		v.setFabricanteVagon(txtFabricante.getText());
		v.setMatriculaVagon(Integer.parseInt(txtMatricula.getText()));
		v.setModeloVagon(txtModelo.getText());
		VagonDAO.modificar(v);
		Principal.ActualizarTablas();
		setVisible(false);
	}



	public void CargarDatos(int id) {
		Vagon v = VagonDAO.buscarPorID(Principal.idVagon);
		txtModelo.setText(v.getModeloVagon());
		txtFabricante.setText(v.getFabricanteVagon());
		txtAntiguedad.setText(String.valueOf(v.getAntiguedadVagon()));
		txtMatricula.setText(String.valueOf(v.getMatriculaVagon()));
		txtCapacidad.setText(String.valueOf(v.getCapacidadVagon()));
	}
	
	public void ayuda()
	{
		try
		{
			File fichero = new File("help_set.hs");
			URL hsURL = fichero.toURI().toURL();

			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();

			hb.enableHelpKey(getContentPane(), "modificar", helpset);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}