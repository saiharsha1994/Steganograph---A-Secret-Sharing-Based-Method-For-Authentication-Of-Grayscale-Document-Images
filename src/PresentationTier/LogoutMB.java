package PresentationTier;

import java.io.File;
import javax.faces.context.FacesContext;

public class LogoutMB {
   
	private int flag=0;
	
	
	
	public int getFlag() {
		return flag;
	}



	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public String cancleButtonss(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uploadMB", null);
		return "cancle";
	}
	public String logoutFunction(){
		flag=1;
		//session.invalidate();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginMB", null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("inboxMB", null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sentMB", null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uploadMB", null);
		//uploadimages
		File index = new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\UploadedImages\\");
		String[]entries = index.list();
		for(String s: entries){
		    File currentFile = new File(index.getPath(),s);
		    currentFile.delete();
		}
		//encryptedimages
		File index1 = new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\EncryptedImages\\");
		String[]entries1 = index1.list();
		for(String s: entries1){
		    File currentFile = new File(index1.getPath(),s);
		    currentFile.delete();
		}
		
		//ImagesRetrived
		File index2 = new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\ImagesRetrived\\");
		String[]entries2 = index2.list();
		for(String s: entries2){
		    File currentFile = new File(index2.getPath(),s);
		    currentFile.delete();
		}
		
		//imagesSent
		File index3 = new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\ImagesSent\\");
		String[]entries3 = index3.list();
		for(String s: entries3){
		    File currentFile = new File(index3.getPath(),s);
		    currentFile.delete();
		}
		return "success";
	}
}
