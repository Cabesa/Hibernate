package clasesBean;

import java.io.Serializable;
import java.util.Set;

public class Vagon implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int idVagon;
	private String fabricanteVagon;
	private String modeloVagon;
	private int antiguedadVagon;
	private int capacidadVagon;
	private int matriculaVagon;
	private Set <Mantenimiento> mantenimiento;
	
	public Vagon(){}
	
	public Vagon(int idVagon,String fabricanteVagon, String modeloVagon, int antiguedadVagon, int capacidadVagon, int matriculaVagon)
	{
		this.idVagon=idVagon;
		this.fabricanteVagon=fabricanteVagon;
		this.modeloVagon=modeloVagon;
		this.antiguedadVagon=antiguedadVagon;
		this.capacidadVagon=capacidadVagon;
		this.matriculaVagon=matriculaVagon;
	}
	public Vagon(String fabricanteVagon, String modeloVagon, int antiguedadVagon, int capacidadVagon, int matriculaVagon)
	{
		this.fabricanteVagon=fabricanteVagon;
		this.modeloVagon=modeloVagon;
		this.antiguedadVagon=antiguedadVagon;
		this.capacidadVagon=capacidadVagon;
		this.matriculaVagon=matriculaVagon;
	}
	public Vagon(String fabricanteVagon, String modeloVagon, int antiguedadVagon, int capacidadVagon, int matriculaVagon, Set <Mantenimiento> mantenimiento)
	{
		this.fabricanteVagon=fabricanteVagon;
		this.modeloVagon=modeloVagon;
		this.antiguedadVagon=antiguedadVagon;
		this.capacidadVagon=capacidadVagon;
		this.matriculaVagon=matriculaVagon;
		this.mantenimiento=mantenimiento;
	}

	public int getIdVagon()
	{
		return idVagon;
	}

	public void setIdVagon(int idVagon)
	{
		this.idVagon = idVagon;
	}

	public String getFabricanteVagon()
	{
		return fabricanteVagon;
	}

	public void setFabricanteVagon(String fabricanteVagon)
	{
		this.fabricanteVagon = fabricanteVagon;
	}

	public String getModeloVagon()
	{
		return modeloVagon;
	}

	public void setModeloVagon(String modeloVagon)
	{
		this.modeloVagon = modeloVagon;
	}

	public int getAntiguedadVagon()
	{
		return antiguedadVagon;
	}

	public void setAntiguedadVagon(int antiguedadVagon)
	{
		this.antiguedadVagon = antiguedadVagon;
	}

	public int getCapacidadVagon()
	{
		return capacidadVagon;
	}

	public void setCapacidadVagon(int capacidadVagon)
	{
		this.capacidadVagon = capacidadVagon;
	}

	public int getMatriculaVagon()
	{
		return matriculaVagon;
	}

	public void setMatriculaVagon(int matriculaVagon)
	{
		this.matriculaVagon = matriculaVagon;
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
