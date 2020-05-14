package com.alfredo.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alfredo.model.Consulta;

public class datosDAO {
	public List<Consulta> consultaLista() {
		List<Consulta> listac = new ArrayList<>();
		
		EntityManager em;
		EntityManagerFactory emf;
		
		emf = Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			listac = em.createQuery("from Consulta").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return listac;
	}
	
	public void actualizarDatos(Consulta cl) {
		EntityManager em;
		EntityManagerFactory emf;
		
		emf = Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();		
		
		cl.getId();
		cl.getNombre();
		cl.getApellido();
		em.getTransaction().begin();
		em.merge(cl);
		em.flush();
		em.getTransaction().commit();
	};
	
	public void eliminarDatos(Consulta cl) {
		EntityManager em;
		EntityManagerFactory emf;
		
		emf = Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();	
		
		cl = em.getReference(Consulta.class, cl.getId());
		em.getTransaction().begin();
		em.remove(cl);
		em.flush();
		em.getTransaction().commit();
	};
	
}
