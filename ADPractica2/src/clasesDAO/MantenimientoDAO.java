package clasesDAO;

import java.util.List;

import javax.persistence.TypedQuery;


import clasesBean.Mantenimiento;
import main.Principal;

public class MantenimientoDAO
{
	//static Session session = HibernateUtil.getSession();

		public static void guardar(Mantenimiento dep)
		{
			// esto es un insert, si es un registro nuevo,
			// sino usar session.update(dep);
			
			Principal.session.beginTransaction();
			Principal.session.save(dep);
			Principal.session.getTransaction().commit();
			//session.close();
		}

		public static Mantenimiento buscarPorID(Integer id)
		{
			// aquí busco el id
			Mantenimiento dep = (Mantenimiento) Principal.session.get(Mantenimiento.class, id);
			return dep;
		}
		

		public static void modificarLoc(Mantenimiento m)
		{
			
			Principal.session.beginTransaction();
			Principal.session.update(m);
			Principal.session.getTransaction().commit();
			//session.close();
		}

		public static void borrar(Mantenimiento prod)
		{
			Principal.session.beginTransaction();
			Principal.session.delete(prod); // esto es un delete
			Principal.session.getTransaction().commit();
			//session.close();
		}

		public void borrarByID(int id)
		{
			Mantenimiento prod = buscarPorID(id);
			Principal.session.beginTransaction();
			Principal.session.delete(prod); // esto es un delete
			Principal.session.getTransaction().commit();
			//session.close();
		}
		

		
		public static List<Mantenimiento> buscarTodos() {
			@SuppressWarnings("unchecked")
			TypedQuery<Mantenimiento> query = Principal.session.createQuery("FROM Mantenimiento");
		    List<Mantenimiento> result = query.getResultList();
			return result;
			} 
}
