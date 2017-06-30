package lkrazy.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtils {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kpi");
	
	public static EntityManagerFactory getEntityManagerFactory() {
		
		return entityManagerFactory;
	}

}
