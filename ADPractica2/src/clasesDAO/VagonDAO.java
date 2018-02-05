package clasesDAO;

import java.util.List;

import javax.persistence.TypedQuery;


import clasesBean.Vagon;
import main.Principal;

public class VagonDAO
{
	//static Session session = HibernateUtil.getSession();

		public static void guardar(Vagon dep)
		{
			// esto es un insert, si es un registro nuevo,
			// sino usar session.update(dep);
			
			Principal.session.beginTransaction();
			Principal.session.save(dep);
			Principal.session.getTransaction().commit();
			//session.close();
		}

		public static Vagon buscarPorID(int id)
		{
			// aquí busco el id
			Vagon dep = (Vagon) Principal.session.get(Vagon.class, id);
			return dep;
		}

		public static void modificar(Vagon v)
		{
			
			Principal.session.beginTransaction();
			Principal.session.update(v);
			Principal.session.getTransaction().commit();
			//session.close();
		}

		public static void borrar(Vagon prod)
		{
			Principal.session.beginTransaction();
			Principal.session.delete(prod); // esto es un delete
			Principal.session.getTransaction().commit();
			//session.close();
		}

		public void borrarByID(int id)
		{
			Vagon prod = buscarPorID(id);
			Principal.session.beginTransaction();
			Principal.session.delete(prod); // esto es un delete
			Principal.session.getTransaction().commit();
			//session.close();
		}
		

		
		public static List<Vagon> buscarTodos() {
			@SuppressWarnings("unchecked")
			TypedQuery<Vagon> query = Principal.session.createQuery("FROM Vagon");
		    List<Vagon> result = query.getResultList();
			return result;
			} 
}
