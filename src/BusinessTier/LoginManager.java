package BusinessTier;

import org.apache.log4j.Logger;

import PersistenceTier.LoginServices;

public class LoginManager {

	public UserTO getUserDetails(String username,String password){
		UserTO userTO=new UserTO();
	    LoginServices loginServices=new LoginServices();
	    try{
	    
	    	userTO=loginServices.findUsers(username, password);	
	    
	    }
	    catch (Exception e) {
	    	Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}
		return userTO;		
	}
	
	public UserTO addUserDetails(String username,String password){
		UserTO userTO=new UserTO();
		LoginServices loginServices=new LoginServices();

		try{
			
			userTO= loginServices.findUsers(username,password);
			if(userTO.getPassword().equalsIgnoreCase("$$$") && userTO.getUsername().equalsIgnoreCase("$$$"))
			{
				userTO=loginServices.addUsers(username,password);
			}
			else{
				userTO.setUsername("$$$");
				userTO.setPassword("$$$");
			}
			}
		catch (Exception e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}
		return userTO;
		
		
	}
	
}
