package br.com.bootcampatos.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence
			.createEntityManagerFactory("elegance_buffet");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}