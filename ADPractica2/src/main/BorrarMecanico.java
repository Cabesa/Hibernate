package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.List;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBean.Mantenimiento;
import clasesBean.Mecanico;
import clasesBean.Vagon;
import clasesDAO.MantenimientoDAO;
import clasesDAO.MecanicoDAO;

import javax.swing.JLabel;

public class BorrarMecanico extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JLabel lblBorrado = new JLabel();
	private JButton btnBorrar = new JButton("Borrar");
	private Mecanico man;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			BorrarMecanico dialog = new BorrarMecanico();
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
	public BorrarMecanico()
	{
		ayuda();
		setTitle("Borrar Mecánico");
		setBounds(100, 100, 450, 131);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			
			contentPanel.add(lblBorrado);
			JLabel lblBorrado2 = new JLabel("Todos los mantenimientos asociados a este mecánico se borraran.");
			contentPanel.add(lblBorrado2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.	CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				buttonPane.add(btnBorrar);
				getRootPane().setDefaultButton(btnBorrar);
			}
		}
		btnBorrar.addActionListener(this);
	}
	public void CargarDatos(int id){
		man =MecanicoDAO.buscarPorID(id);
		lblBorrado.setText("Está seguro que desea BORRAR el Mecánico "+man.getNombreMecanico()+" "+man.getApellido1Mecanico()+" "+man.getApellido2Mecanico()+".");
		setBounds(100, 100, lblBorrado.getText().length()*8, 130);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		List<Mantenimiento> busqueda = MantenimientoDAO.buscarTodos();
		for (Mantenimiento m : busqueda)
		{
			if(m.getMecanico().getIdMecanico()==man.getIdMecanico())
			{
				MantenimientoDAO.borrar(m);
			}
		}
		MecanicoDAO.borrar(man);
		Principal.ActualizarTablas();
		setVisible(false);
		
	}
	
	public void ayuda()
	{
		try
		{
			File fichero = new File("help_set.hs");
			URL hsURL = fichero.toURI().toURL();

			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();

			hb.enableHelpKey(getContentPane(), "borrar", helpset);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}