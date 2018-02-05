package clasesBean;

import java.io.Serializable;
import java.util.Set;

public class Mecanico implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int idMecanico;
	private String nombreMecanico;
	private String apellido1Mecanico;
	private String apellido2Mecanico;
	private String dniMecanico;
	private int sueldoMecanico;
	private Set <Mantenimiento> mantenimiento;
	
	public Mecanico(){}
	
	public Mecanico(int idMecanico, String nombreMecanico, String apellido1Mecanico, String apellido2Mecanico,String dniMecanico, int sueldoMecanico)
	{
		this.idMecanico=idMecanico;
		this.nombreMecanico=nombreMecanico;
		this.apellido1Mecanico=apellido1Mecanico;
		this.apellido2Mecanico=apellido2Mecanico;
		this.dniMecanico=dniMecanico;
		this.sueldoMecanico=sueldoMecanico;
	}
	public Mecanico(String nombreMecanico, String apellido1Mecanico, String apellido2Mecanico, String dniMecanico, int sueldoMecanico)
	{
		this.nombreMecanico=nombreMecanico;
		this.apellido1Mecanico=apellido1Mecanico;
		this.apellido2Mecanico=apellido2Mecanico;
		this.dniMecanico=dniMecanico;
		this.sueldoMecanico=sueldoMecanico;
	}
	public Mecanico(String nombreMecanico, String apellido1Mecanico, String apellido2Mecanico, String fechaMecanico,String dniMecanico, int sueldoMecanico,Set<Mantenimiento> mantenimiento)
	{
		this.nombreMecanico=nombreMecanico;
		this.apellido1Mecanico=apellido1Mecanico;
		this.apellido2Mecanico=apellido2Mecanico;
		this.dniMecanico=dniMecanico;
		this.sueldoMecanico=sueldoMecanico;
		this.mantenimiento=mantenimiento;
	}

	public int getIdMecanico()
	{
		return idMecanico;
	}

	public void setIdMecanico(int idMecanico)
	{
		this.idMecanico = idMecanico;
	}

	public String getNombreMecanico()
	{
		return nombreMecanico;
	}

	public void setNombreMecanico(String nombreMecanico)
	{
		this.nombreMecanico = nombreMecanico;
	}

	public String getApellido1Mecanico()
	{
		return apellido1Mecanico;
	}

	public void setApellido1Mecanico(String apellido1Mecanico)
	{
		this.apellido1Mecanico = apellido1Mecanico;
	}

	public String getApellido2Mecanico()
	{
		return apellido2Mecanico;
	}

	public void setApellido2Mecanico(String apellido2Mecanico)
	{
		this.apellido2Mecanico = apellido2Mecanico;
	}

	public String getDniMecanico()
	{
		return dniMecanico;
	}

	public void setDniMecanico(String dniMecanico)
	{
		this.dniMecanico = dniMecanico;
	}

	public int getSueldoMecanico()
	{
		return sueldoMecanico;
	}

	public void setSueldoMecanico(int sueldoMecanico)
	{
		this.sueldoMecanico = sueldoMecanico;
	}

	public Set<Mantenimiento> getMantenimiento()
	{
		return mantenimiento;
	}

	public void setMantenimiento(Set<Mantenimiento> mantenimiento)
	{
		this.mantenimiento = mantenimiento;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
}
