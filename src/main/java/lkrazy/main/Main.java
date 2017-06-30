package lkrazy.main;
import java.util.List;

import javax.persistence.EntityManager;

import lkrazy.pojo.User;
import lkrazy.util.PersistenceUtils;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = PersistenceUtils.getEntityManagerFactory().createEntityManager();
		List<User> users = entityManager.createQuery("SELECT u FROM User u").getResultList();
		System.out.println(users.toString());
		
		System.out.println(entityManager.createQuery("SELECT u FROM User u WHERE u.username LIKE '%1'").getResultList());
		entityManager.close();
		PersistenceUtils.getEntityManagerFactory().close();
		
	}
}
