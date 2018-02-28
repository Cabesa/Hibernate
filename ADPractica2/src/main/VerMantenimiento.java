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

import clasesBean.Mantenimiento;
import clasesBean.Mecanico;
import clasesBean.Vagon;
import clasesDAO.MantenimientoDAO;
import clasesDAO.MecanicoDAO;
import clasesDAO.VagonDAO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VerMantenimiento extends JDialog
{
	private JLabel txtNombre;
	private JLabel txtCoste;
	private JLabel txtHoras;
	private JLabel txtVagon;
	private JLabel txtMecanico;

	static JTextArea txtInforme = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			VerMantenimiento dialog = new VerMantenimiento();
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
	public VerMantenimiento()
	{
		ayuda();
		setTitle("Ver Mantenimiento");
		setBounds(100, 100, 450, 342);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 1;
			getContentPane().add(lblNombre, gbc_lblNombre);
		}
		{
			txtNombre = new JLabel();
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 2;
			gbc_txtNombre.gridy = 1;
			getContentPane().add(txtNombre, gbc_txtNombre);
			
		}
		{
			JLabel lblCoste = new JLabel("Coste:");
			lblCoste.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_lblCoste = new GridBagConstraints();
			gbc_lblCoste.anchor = GridBagConstraints.EAST;
			gbc_lblCoste.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoste.gridx = 1;
			gbc_lblCoste.gridy = 2;
			getContentPane().add(lblCoste, gbc_lblCoste);
		}
		{
			txtCoste = new JLabel();
			GridBagConstraints gbc_txtCoste = new GridBagConstraints();
			gbc_txtCoste.insets = new Insets(0, 0, 5, 0);
			gbc_txtCoste.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCoste.gridx = 2;
			gbc_txtCoste.gridy = 2;
			getContentPane().add(txtCoste, gbc_txtCoste);
		
		}
		{
			JLabel lblHoras = new JLabel("Horas:");
			lblHoras.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_lblHoras = new GridBagConstraints();
			gbc_lblHoras.anchor = GridBagConstraints.EAST;
			gbc_lblHoras.insets = new Insets(0, 0, 5, 5);
			gbc_lblHoras.gridx = 1;
			gbc_lblHoras.gridy = 3;
			getContentPane().add(lblHoras, gbc_lblHoras);
		}
		{
			txtHoras = new JLabel();
			GridBagConstraints gbc_txtHoras = new GridBagConstraints();
			gbc_txtHoras.insets = new Insets(0, 0, 5, 0);
			gbc_txtHoras.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHoras.gridx = 2;
			gbc_txtHoras.gridy = 3;
			getContentPane().add(txtHoras, gbc_txtHoras);
			
		}
		{
			JLabel lblInforme = new JLabel("Informe:");
			lblInforme.setVerticalAlignment(SwingConstants.TOP);
			lblInforme.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_lblInforme = new GridBagConstraints();
			gbc_lblInforme.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblInforme.insets = new Insets(0, 0, 5, 5);
			gbc_lblInforme.gridx = 1;
			gbc_lblInforme.gridy = 4;
			getContentPane().add(lblInforme, gbc_lblInforme);
		}
		{
			
			GridBagConstraints gbc_txtInforme = new GridBagConstraints();
			gbc_txtInforme.insets = new Insets(0, 0, 5, 0);
			gbc_txtInforme.fill = GridBagConstraints.BOTH;
			gbc_txtInforme.gridx = 2;
			gbc_txtInforme.gridy = 4;
			getContentPane().add(txtInforme, gbc_txtInforme);
			txtInforme.setEditable(false);
		}
		{
			JLabel lblMecnico = new JLabel("Mec\u00E1nico:");
			lblMecnico.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_lblMecnico = new GridBagConstraints();
			gbc_lblMecnico.insets = new Insets(0, 0, 5, 5);
			gbc_lblMecnico.gridx = 1;
			gbc_lblMecnico.gridy = 5;
			getContentPane().add(lblMecnico, gbc_lblMecnico);
		}
		{
			txtMecanico=new JLabel();
			GridBagConstraints gbc_txtMecanico = new GridBagConstraints();
			gbc_txtMecanico.anchor = GridBagConstraints.WEST;
			gbc_txtMecanico.insets = new Insets(0, 0, 5, 0);
			gbc_txtMecanico.gridx = 2;
			gbc_txtMecanico.gridy = 5;
			getContentPane().add(txtMecanico, gbc_txtMecanico);
		}
		
		{
			JLabel lblVagn = new JLabel("Vag\u00F3n:");
			GridBagConstraints gbc_lblVagn = new GridBagConstraints();
			gbc_lblVagn.anchor = GridBagConstraints.EAST;
			gbc_lblVagn.insets = new Insets(0, 0, 5, 5);
			gbc_lblVagn.gridx = 1;
			gbc_lblVagn.gridy = 6;
			getContentPane().add(lblVagn, gbc_lblVagn);
		}
		{
			txtVagon = new JLabel();
			GridBagConstraints gbc_txtVagon = new GridBagConstraints();
			gbc_txtVagon.anchor = GridBagConstraints.WEST;
			gbc_txtVagon.insets = new Insets(0, 0, 5, 0);
			gbc_txtVagon.gridx = 2;
			gbc_txtVagon.gridy = 6;
			getContentPane().add(txtVagon, gbc_txtVagon);
		}
		
	
		CargarDatos(Principal.idMantenimiento);
		setVisible(true);
		}
	

	public void CargarDatos(int id){
		Mantenimiento man=MantenimientoDAO.buscarPorID(id);
		txtNombre.setText(man.getNombreMantenimiento());
		txtCoste.setText(String.valueOf(man.getCosteMantenimiento()));
		txtHoras.setText(String.valueOf(man.getHorasMantenimiento()));
		txtInforme.setText(man.getInformeMantenimiento());
		txtMecanico.setText(man.getMecanico().getNombreMecanico()+" "+man.getMecanico().getApellido1Mecanico()+" "+man.getMecanico().getApellido2Mecanico());
		txtVagon.setText(man.getVagon().getModeloVagon()+" "+man.getVagon().getMatriculaVagon());
	
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