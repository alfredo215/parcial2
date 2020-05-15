package com.alfredo.Dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alfredo.model.Usuarioparcial;


public class loguinDAO {
	
	public List<Usuarioparcial> EntradaUsuario(Usuarioparcial usu){
		List<Usuarioparcial> User=new ArrayList();
		EntityManager em;
		EntityManagerFactory emf;
		
		emf = Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			User = em.createQuery("from Usuarioparcial as u where u.nombre='"+usu.getNombre()+"' and u.contrasenia='"+usu.getContrasenia()+"'").getResultList();
			
			em.getTransaction().commit();
			
			for (Usuarioparcial datosid:User) {

				usu.setId(datosid.getId());
				
			}
			
		} catch (Exception e) {
			
			System.out.println(e+"Error Dao");
		}
		return User;
		
	}

}
