package PersistenceTier;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import BusinessTier.SendTO;

public class UserServices {
       
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	
	   public String setData(SendTO sendTO){
		   try{
		    entityManagerFactory = Persistence.createEntityManagerFactory("Demo");
			entityManager = entityManagerFactory.createEntityManager();
			Calendar calendar=Calendar.getInstance();
			java.util.Date d=calendar.getTime();
			String s=findUser(sendTO.getReciver());
			if(s.equalsIgnoreCase("success")){
			ComposeEntity composeEntity=new ComposeEntity();
			File file = new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\EncryptedImages\\saved.png");
			byte[] bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			composeEntity.setImage(bFile);
			composeEntity.setReciver(sendTO.getReciver());
			composeEntity.setSender(sendTO.getSender());
			composeEntity.setDate(d);
			composeEntity.setFlag(1);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(composeEntity);
			entityTransaction.commit();
			return "success";
			}
			else{
				return "failure";
			}
		   }
		   catch (Exception e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		    return "failure";
		   }
	  	   
	   }
	 
	  public String findUser(String username){
		  try{
				entityManagerFactory = Persistence.createEntityManagerFactory("Demo");
				entityManager = entityManagerFactory.createEntityManager();
				if(username.equalsIgnoreCase("")){
					return "failure";
				}
				LoginEntity loginEntity = entityManager.find(LoginEntity.class,username);
				if((loginEntity.getUsername()!=null))
				{
					return "success";
				}

				else{
					throw new Exception("user not found");
				}
			 }
				 catch (Exception e) {
					Logger logger = Logger.getLogger(this.getClass());
					logger.error(e.getMessage(), e);
				}
		 return "failure";
	  }
	   
}
