package PresentationTier;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import utility.AppConfig;
import BusinessTier.LoginManager;
import BusinessTier.UserTO;
public class LoginMB {

	private String username;
	private String password;
	private String message;
	private LogoutMB logoutMB;
	private int counter=0;
	
	
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public LogoutMB getLogoutMB() {
		return logoutMB;
	}

	public void setLogoutMB(LogoutMB logoutMB) {
		this.logoutMB = logoutMB;
	}

	public String getUsername() {
		return username;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String validateLogin(){
		counter=1;
		logoutMB.setFlag(0);
		if(this.username.equals("") && this.password.equals("")){
			this.message=AppConfig.PROPERTIES.getProperty("EMPTY_USERNAME_PASSWORD");
		    return "failure";
		}
		else if(this.username.equals("")){
			this.message=AppConfig.PROPERTIES.getProperty("EMPTY_USERNAME");
			return "failure";
		}
		else if(this.password.equals("")){
			this.message=AppConfig.PROPERTIES.getProperty("EMPTY_PASSWORD");
			return "failure";
		}
		UserTO userTO=new UserTO();
		LoginManager loginManager=new LoginManager();
		userTO=loginManager.getUserDetails(this.username, this.password);
		/*if(userTO.getUsername()==null && userTO.getPassword()==null){
			return "failure";
		}*/
		if(userTO.getUsername().equals("$$$")){
			this.message=AppConfig.PROPERTIES.getProperty("NO_USER");
			return "failure";
		}
		else{
			if(!userTO.getPassword().equals(this.password)){
				this.message=AppConfig.PROPERTIES.getProperty("INCORRECT_PASSWORD");
				return "failure";
			}
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("userName", username);
			
			return "success";
		}
		/*if(userTO.getUsername().equals(this.username) && userTO.getPassword().equals(this.password)){ 
			return "success";
		}
		else{
			return "failure";
		}*/
	}
	
	public String registerUsers(){
		counter=1;
		this.message="";
		if(this.username.equals("") && this.password.equals("")){
			this.message=AppConfig.PROPERTIES.getProperty("EMPTY_USERNAME_PASSWORD");
		    return "failure";
		}
		else if(this.username.equals("")){
			this.message=AppConfig.PROPERTIES.getProperty("EMPTY_USERNAME");
			return "failure";
		}
		else if(this.password.equals("")){
			this.message=AppConfig.PROPERTIES.getProperty("EMPTY_PASSWORD");
			return "failure";
		}
		String s=user();
		if(s.equalsIgnoreCase("no")){
			return "failure";
		}
		String p=password();
		if(p.equalsIgnoreCase("no")){
			return "failure";
		}
		
		UserTO userTO=new UserTO();
		LoginManager loginManager=new LoginManager();
		try {
			userTO=loginManager.addUserDetails(this.username.toLowerCase(),this.password);
		} 
		catch (Exception e) {
			this.message=e.getMessage();
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}
		if(userTO.getUsername().equalsIgnoreCase("$$$") && userTO.getPassword().equalsIgnoreCase("$$$")){
			this.message=AppConfig.PROPERTIES.getProperty("DUPLICATE_USER");
			return "failure";
		}
		else{
			return "failure";
		}
	}
	
	public String user(){
		String s=this.username;
		if(s.length()<6){
			this.message=AppConfig.PROPERTIES.getProperty("USERNAME_INCORRECT_LENGTH");
		    return "no";
		}
		else{
			char r=this.username.charAt(0);
			int a1=r;
			if(!((a1>=65 && a1<=90)||(a1>=97 && a1<=122))){
				this.message=AppConfig.PROPERTIES.getProperty("INVALID_FIRSTLETTER");
				return "no";
			}
			int numOfSpecial=0;
			String value=s;
			
			 String specialChars = "(.*[,~,!,#,$,%,^,&,*,(,),-,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
		      if (value.matches(specialChars))
		      {
		              numOfSpecial=1;
		      }
			if(numOfSpecial==1){
				this.message=AppConfig.PROPERTIES.getProperty("USERNAME_SPECIAL_CHARS");
				return "no";
			}
		}
		return "yes";
}
	
public String password(){
	String s=this.password;
	if(s.length()<8){
		this.message=AppConfig.PROPERTIES.getProperty("PASSWORD_INCORRECT_LENGTH");
     return "no";
	}
	int count=0;
	int numOfSpecial=0;
	String value=s;
	
	 String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
      if (value.matches(specialChars))
      {
              numOfSpecial=1;
      }
      
      
	for(int i=0;i<value.length();i++)
	{
		if(value.charAt(i)>='A'&&value.charAt(i)<='Z')
		{
			count=1;
		}
	}
	
	if(count!=1 && numOfSpecial!=1){
		this.message=AppConfig.PROPERTIES.getProperty("PASSWORD_INVALID1");
		return "no";
	}
	if(count!=1){
		this.message=AppConfig.PROPERTIES.getProperty("PASSWORD_INVALID2");
	    return "no";
	}
	if(numOfSpecial!=1){
	   this.message=AppConfig.PROPERTIES.getProperty("PASSWORD_INVALID3");
	   return "no";
	}
    
	return "yes";



}


	
}
