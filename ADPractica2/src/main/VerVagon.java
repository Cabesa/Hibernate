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
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.List;

import javax.swing.JTextField;

public class VerVagon extends JDialog
{
	static JLabel lblMatricula2 = new JLabel();
	static JLabel lblCapacidad2 = new JLabel();
	static JLabel lblAntiguedad2 = new JLabel();
	static JLabel lblModelo2 = new JLabel();
	static JLabel lblFabricante2 = new JLabel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			VerVagon dialog = new VerVagon();
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
	public VerVagon()
	{
		
		
		setTitle("Ver Vagón");
		setBounds(100, 100, 450, 222);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
			
			GridBagConstraints gbc_txtFabricante = new GridBagConstraints();
			gbc_txtFabricante.insets = new Insets(0, 0, 5, 0);
			gbc_txtFabricante.fill = GridBagConstraints.WEST;
			gbc_txtFabricante.gridx = 2;
			gbc_txtFabricante.gridy = 1;
			getContentPane().add(lblFabricante2, gbc_txtFabricante);
			
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
			
			GridBagConstraints gbc_lblModelo2 = new GridBagConstraints();
			gbc_lblModelo2.insets = new Insets(0, 0, 5, 0);
			gbc_lblModelo2.fill = GridBagConstraints.WEST;
			gbc_lblModelo2.gridx = 2;
			gbc_lblModelo2.gridy = 2;
			getContentPane().add(lblModelo2, gbc_lblModelo2);
			
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
			
			GridBagConstraints gbc_txtAntiguedad = new GridBagConstraints();
			gbc_txtAntiguedad.insets = new Insets(0, 0, 5, 0);
			gbc_txtAntiguedad.fill = GridBagConstraints.WEST;
			gbc_txtAntiguedad.gridx = 2;
			gbc_txtAntiguedad.gridy = 3;
			getContentPane().add(lblAntiguedad2, gbc_txtAntiguedad);
			
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
			
			GridBagConstraints gbc_txtCapacidad = new GridBagConstraints();
			gbc_txtCapacidad.insets = new Insets(0, 0, 5, 0);
			gbc_txtCapacidad.fill = GridBagConstraints.WEST;
			gbc_txtCapacidad.gridx = 2;
			gbc_txtCapacidad.gridy = 4;
			getContentPane().add(lblCapacidad2, gbc_txtCapacidad);
			
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
			
			GridBagConstraints gbc_txtMatricula = new GridBagConstraints();
			gbc_txtMatricula.insets = new Insets(0, 0, 5, 0);
			gbc_txtMatricula.fill = GridBagConstraints.WEST;
			gbc_txtMatricula.gridx = 2;
			gbc_txtMatricula.gridy = 5;
			getContentPane().add(lblMatricula2, gbc_txtMatricula);
		
		}
		CargarDatos(Principal.idVagon);
		setVisible(true);
		ayuda();
	}


	public void CargarDatos(int id)
	{
		Vagon v=VagonDAO.buscarPorID(Principal.idVagon);
		lblModelo2.setText(v.getModeloVagon());
		lblFabricante2.setText(v.getFabricanteVagon());
		lblAntiguedad2.setText(String.valueOf(v.getAntiguedadVagon()));
		lblMatricula2.setText(String.valueOf(v.getMatriculaVagon()));
		lblCapacidad2.setText(String.valueOf(v.getCapacidadVagon()));
	}
	
	public void ayuda()
	{
		try
		{
			File fichero = new File("help_set.hs");
			URL hsURL = fichero.toURI().toURL();

			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();

			hb.enableHelpKey(getContentPane(), "ver", helpset);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}