package clasesDAO;

import java.util.List;

import javax.persistence.TypedQuery;


import clasesBean.Mecanico;
import main.Principal;

public class MecanicoDAO
{
	//static Session session = HibernateUtil.getSession();

		public static void guardar(Mecanico dep)
		{
			// esto es un insert, si es un registro nuevo,
			// sino usar session.update(dep);
			
			Principal.session.beginTransaction();
			Principal.session.save(dep);
			Principal.session.getTransaction().commit();
			//session.close();
		}

		public static Mecanico buscarPorID(Integer id)
		{
			// aquí busco el id
			Mecanico dep = (Mecanico) Principal.session.get(Mecanico.class, id);
			return dep;
		}

		public static void modificar(Mecanico m)
		{

			Principal.session.beginTransaction();
			Principal.session.update(m);
			Principal.session.getTransaction().commit();
			//session.close();
		}

		public static void borrar(Mecanico prod)
		{
			Principal.session.beginTransaction();
			Principal.session.delete(prod); // esto es un delete
			Principal.session.getTransaction().commit();
			//session.close();
		}

		public void borrarByID(int id)
		{
			Mecanico prod = buscarPorID(id);
			Principal.session.beginTransaction();
			Principal.session.delete(prod); // esto es un delete
			Principal.session.getTransaction().commit();
			//session.close();
		}
		

		
		public static List<Mecanico> buscarTodos() {
			@SuppressWarnings("unchecked")
			TypedQuery<Mecanico> query = Principal.session.createQuery("FROM Mecanico");
		    List<Mecanico> result = query.getResultList();
			return result;
			} 
}
