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
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
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

public class ModificarMantenimiento extends JDialog implements ActionListener
{
	private JTextField txtNombre;
	private JTextField txtCoste;
	private JTextField txtHoras;
	private Choice choiVagon = new Choice();
	private Choice choiMecanico = new Choice();
	static JButton btnGuardar = new JButton("Guardar");
	static ArrayList idsMecanicos = new ArrayList();
	static ArrayList idsVagones = new ArrayList();
	static JTextArea txtInforme = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			NuevoMantenimiento dialog = new NuevoMantenimiento();
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
	public ModificarMantenimiento()
	{
		ayuda();
		setTitle("Modificar Mantenimiento");
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
			txtCoste = new JTextField();
			GridBagConstraints gbc_txtCoste = new GridBagConstraints();
			gbc_txtCoste.insets = new Insets(0, 0, 5, 0);
			gbc_txtCoste.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCoste.gridx = 2;
			gbc_txtCoste.gridy = 2;
			getContentPane().add(txtCoste, gbc_txtCoste);
			txtCoste.setColumns(10);
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
			txtHoras = new JTextField();
			GridBagConstraints gbc_txtHoras = new GridBagConstraints();
			gbc_txtHoras.insets = new Insets(0, 0, 5, 0);
			gbc_txtHoras.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHoras.gridx = 2;
			gbc_txtHoras.gridy = 3;
			getContentPane().add(txtHoras, gbc_txtHoras);
			txtHoras.setColumns(10);
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
	
			GridBagConstraints gbc_choiMecanico = new GridBagConstraints();
			gbc_choiMecanico.fill = GridBagConstraints.HORIZONTAL;
			gbc_choiMecanico.insets = new Insets(0, 0, 5, 0);
			gbc_choiMecanico.gridx = 2;
			gbc_choiMecanico.gridy = 5;
			getContentPane().add(choiMecanico, gbc_choiMecanico);
		}
		{
			JLabel lblVagon = new JLabel("Vag\u00F3n:");
			lblVagon.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_lblVagon = new GridBagConstraints();
			gbc_lblVagon.insets = new Insets(0, 0, 5, 5);
			gbc_lblVagon.gridx = 1;
			gbc_lblVagon.gridy = 7;
			getContentPane().add(lblVagon, gbc_lblVagon);
		}
		{
			
			GridBagConstraints gbc_choiVagon = new GridBagConstraints();
			gbc_choiVagon.fill = GridBagConstraints.HORIZONTAL;
			gbc_choiVagon.insets = new Insets(0, 0, 5, 0);
			gbc_choiVagon.gridx = 2;
			gbc_choiVagon.gridy = 7;
			getContentPane().add(choiVagon, gbc_choiVagon);
		}
		{
			Panel pnl = new Panel();
			GridBagConstraints gbc_pnl = new GridBagConstraints();
			gbc_pnl.gridwidth = 3;
			gbc_pnl.gridx = 0;
			gbc_pnl.gridy = 8;
			getContentPane().add(pnl, gbc_pnl);
			{
				
				pnl.add(btnGuardar);
			}
		}
		btnGuardar.addActionListener(this);
		
		
		
		setVisible(false);
		}
	public void CargarChoices(){
		List<Mecanico> busqueda = MecanicoDAO.buscarTodos();
		choiVagon.removeAll();
		choiMecanico.removeAll();
		idsMecanicos.clear();
		idsVagones.clear();
		for (Mecanico m : busqueda)
		{
			idsMecanicos.add(m.getIdMecanico());
			choiMecanico.addItem(m.getNombreMecanico()+" "+m.getApellido1Mecanico()+" "+m.getApellido2Mecanico());
		
		}
		List<Vagon> busqueda2 = VagonDAO.buscarTodos();

		for (Vagon v : busqueda2)
		{
			idsVagones.add(v.getIdVagon());
			choiVagon.addItem(v.getModeloVagon()+" "+v.getMatriculaVagon());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(txtHoras.getText().isEmpty()||txtCoste.getText().isEmpty()||txtNombre.getText().isEmpty())
			JOptionPane.showMessageDialog(getContentPane(), "Rellene los campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
		else if(!ControlErrores.isNumeric(txtHoras.getText()))
		{
			JOptionPane.showMessageDialog(getContentPane(), "Las horas tienen que ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(!ControlErrores.isNumeric(txtCoste.getText()))
		{
			JOptionPane.showMessageDialog(getContentPane(), "El coste tiene que ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		GuardarMantenimiento(Principal.idMantenimiento);
		
	}
	public void GuardarMantenimiento(int id){
		Mantenimiento m=MantenimientoDAO.buscarPorID(id);
		m.setNombreMantenimiento(txtNombre.getText());
		m.setCosteMantenimiento(Integer.parseInt(txtCoste.getText()));
		m.setHorasMantenimiento(Integer.parseInt(txtHoras.getText()));
		m.setInformeMantenimiento(txtInforme.getText());
		int idvagon=choiVagon.getSelectedIndex();
		int idmecanico=choiMecanico.getSelectedIndex();
		Vagon vagon=VagonDAO.buscarPorID((int) idsVagones.get(idvagon));
		Mecanico mecanico=MecanicoDAO.buscarPorID((int) idsMecanicos.get(idmecanico));
		m.setMecanico(mecanico);
		m.setVagon(vagon);
		
		MantenimientoDAO.modificarLoc(m);
		ActualizarTabla();
		this.dispose();
		
	}
	public void ActualizarTabla(){
		List<Mantenimiento> busqueda3 = MantenimientoDAO.buscarTodos();
		DefaultTableModel modelo=(DefaultTableModel) Principal.tableSegunda.getModel();
		int filas=Principal.tableSegunda.getRowCount();
		for (int i=0;filas>i;i++)
			 modelo.removeRow(0);
		for (Mantenimiento m : busqueda3)
		{
			
			modelo.addRow(new Object[]{m.getIdMantenimiento(),m.getNombreMantenimiento(),m.getCosteMantenimiento()+"€"});
		
		}
	}
	public void CargarDatos(int id){
		Mantenimiento man=MantenimientoDAO.buscarPorID(id);
		txtNombre.setText(man.getNombreMantenimiento());
		txtCoste.setText(String.valueOf(man.getCosteMantenimiento()));
		txtHoras.setText(String.valueOf(man.getHorasMantenimiento()));
		txtInforme.setText(man.getInformeMantenimiento());
		
		for (int i = 0; i < idsVagones.size(); i++)
		{
			if(idsVagones.get(i).equals(man.getMecanico().getIdMecanico()))
			{
				choiVagon.select(i);
			}
			
		}
		for (int i = 0; i < idsMecanicos.size(); i++)
		{
			if(idsMecanicos.get(i).equals(man.getMecanico().getIdMecanico()))
			{
				choiMecanico.select(i);
			}
			
		}
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
