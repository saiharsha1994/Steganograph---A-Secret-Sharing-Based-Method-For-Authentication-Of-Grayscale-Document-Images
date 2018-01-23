package PersistenceTier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import BusinessTier.UserTO;

public class LoginServices {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	 
	
	public UserTO findUsers(String username,String password){
		 UserTO userTO=new UserTO();
		 try{
		entityManagerFactory = Persistence.createEntityManagerFactory("Demo");
		entityManager = entityManagerFactory.createEntityManager();
		LoginEntity loginEntity = entityManager.find(LoginEntity.class,username);
		
		if(loginEntity==null){
        	userTO.setUsername("$$$");
        	userTO.setPassword("$$$");
            throw new Exception("No User Found");
		}
        else{
        	userTO.setUsername(loginEntity.getUsername());
        	
    		userTO.setPassword(loginEntity.getPassword());
        }
		if((loginEntity.getUsername()!=null))
		{
		}
		else{
			throw new Exception("user not found");
		}
	 }
		 catch (Exception e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}
		 
		 finally{
			 if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
			 
		 }
	 return userTO;	 
	 }
	
	  public UserTO addUsers(String username,String password){
		  UserTO userTO=new UserTO();
			 try{
			entityManagerFactory = Persistence.createEntityManagerFactory("Demo");
			entityManager = entityManagerFactory.createEntityManager(); 
			 LoginEntity loginEntity=new LoginEntity();
			 loginEntity.setUsername(username);
			 loginEntity.setPassword(password);
			 EntityTransaction entityTransaction = entityManager.getTransaction();
			 entityTransaction.begin();
			 entityManager.persist(loginEntity);
			 entityTransaction.commit();
			 userTO=findUsers(username, password);
			 }
			 
			 catch (Exception e) {
				 Logger logger = Logger.getLogger(this.getClass());
					logger.error(e.getMessage(), e);
					System.out.println(e.getMessage());
				}
				 
				 finally{
					 if (entityManagerFactory != null) {
							entityManagerFactory.close();
						}
					 
				 }
		return userTO;	 
	 }
	
}
