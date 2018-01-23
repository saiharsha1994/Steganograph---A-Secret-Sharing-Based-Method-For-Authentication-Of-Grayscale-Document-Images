package BusinessTier;

import PersistenceTier.UserServices;

public class UserSendManager {
   
	public String setSendDetails(SendTO sendTO){
		UserServices services=new UserServices();
		String s=services.setData(sendTO);
		return s;	
	}
	
}
