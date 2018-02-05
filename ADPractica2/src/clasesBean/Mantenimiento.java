package clasesBean;

import java.io.Serializable;

public class Mantenimiento implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int idMantenimiento;
	private String nombreMantenimiento;
	private int costeMantenimiento;
	private int horasMantenimiento;
	private String informeMantenimiento;
	private Vagon vagon;
	private Mecanico mecanico;
	
	public Mantenimiento(){}
	
	public Mantenimiento(int idMantenimiento, String nombreMantenimiento,int costeMantenimiento, int horasMantenimiento,
			String informeMantenimiento, Vagon vagon, Mecanico mecanico){
		this.idMantenimiento=idMantenimiento;
		this.nombreMantenimiento=nombreMantenimiento;
		this.costeMantenimiento=costeMantenimiento;
		this.horasMantenimiento=horasMantenimiento;
		this.informeMantenimiento=informeMantenimiento;
		this.vagon=vagon;
		this.mecanico=mecanico;
	}
	public Mantenimiento(String nombreMantenimiento,int costeMantenimiento, int horasMantenimiento,
			String informeMantenimiento, Vagon vagon, Mecanico mecanico){
		this.nombreMantenimiento=nombreMantenimiento;
		this.costeMantenimiento=costeMantenimiento;
		this.horasMantenimiento=horasMantenimiento;
		this.informeMantenimiento=informeMantenimiento;
		this.vagon=vagon;
		this.mecanico=mecanico;
	}

	public int getIdMantenimiento()
	{
		return idMantenimiento;
	}

	public void setIdMantenimiento(int idMantenimiento)
	{
		this.idMantenimiento = idMantenimiento;
	}

	public String getNombreMantenimiento()
	{
		return nombreMantenimiento;
	}

	public void setNombreMantenimiento(String nombreMantenimiento)
	{
		this.nombreMantenimiento = nombreMantenimiento;
	}

	public int getCosteMantenimiento()
	{
		return costeMantenimiento;
	}

	public void setCosteMantenimiento(int costeMantenimiento)
	{
		this.costeMantenimiento = costeMantenimiento;
	}

	public int getHorasMantenimiento()
	{
		return horasMantenimiento;
	}

	public void setHorasMantenimiento(int horasMantenimiento)
	{
		this.horasMantenimiento = horasMantenimiento;
	}

	public String getInformeMantenimiento()
	{
		return informeMantenimiento;
	}

	public void setInformeMantenimiento(String informeMantenimiento)
	{
		this.informeMantenimiento = informeMantenimiento;
	}

	public Vagon getVagon()
	{
		return vagon;
	}

	public void setVagon(Vagon vagon)
	{
		this.vagon = vagon;
	}

	public Mecanico getMecanico()
	{
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico)
	{
		this.mecanico = mecanico;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
}
