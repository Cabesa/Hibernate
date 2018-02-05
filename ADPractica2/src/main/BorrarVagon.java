package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBean.Mantenimiento;
import clasesBean.Vagon;
import clasesDAO.MantenimientoDAO;
import clasesDAO.MecanicoDAO;
import clasesDAO.VagonDAO;

import javax.swing.JLabel;

public class BorrarVagon extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JLabel lblBorrado = new JLabel();
	private JButton btnBorrar = new JButton("Borrar");
	Vagon vag;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			BorrarVagon dialog = new BorrarVagon();
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
	public BorrarVagon()
	{
		setTitle("Borrar Vagón");
		setBounds(100, 100, 450, 131);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			
			contentPanel.add(lblBorrado);
			JLabel lblBorrado2 = new JLabel("Todos los mantenimientos asociados a este vagón se borraran.");
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
		vag =VagonDAO.buscarPorID(id);
		lblBorrado.setText("Está seguro que desea BORRAR el Vagon con matrícula:"+vag.getMatriculaVagon()+" y módelo: "+vag.getModeloVagon());
		setBounds(100, 100, lblBorrado.getText().length()*8, 130);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		List<Mantenimiento> busqueda = MantenimientoDAO.buscarTodos();
		for (Mantenimiento m : busqueda)
		{
			if(m.getVagon().getIdVagon()==vag.getIdVagon())
			{
				MantenimientoDAO.borrar(m);
			}
		}
		VagonDAO.borrar(vag);
		Principal.ActualizarTablas();
		setVisible(false);
		
	}

}