package PresentationTier;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.event.ValueChangeEvent;
import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import utility.AppConfig;
import BusinessTier.EncryptImage;
import BusinessTier.SendTO;
import BusinessTier.UserSendManager;
import PersistenceTier.UserServices;

public class UploadMB {
	private UploadedFile upload;
	private String data;
	private String s;
    private String imageName;
    private String userName;
    private String toUserName;
    private LoginMB loginMB;
    private InboxMB inboxMB;
    private String message;
    private String flag;
    private String recive;
    private String message1;
    private String put;
    private String message2;
    private int count;
    private String data1;
    private long size;
    private int view=0;
    
    
   
    
    
   
    
    public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}
	public String getPut() {
		return put;
	}
	public void setPut(String put) {
		this.put = put;
	}
	public String getMessage1() {
		return message1;
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getRecive() {
		return recive;
	}
	public void setRecive(String recive) {
		this.recive = recive;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public InboxMB getInboxMB() {
		return inboxMB;
	}
	public void setInboxMB(InboxMB inboxMB) {
		this.inboxMB = inboxMB;
	}
	public LoginMB getLoginMB() {
		return loginMB;
	}
	public void setLoginMB(LoginMB loginMB) {
		this.loginMB = loginMB;
	}
	public UploadMB() {
	}
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
			this.imageName = imageName;	
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
    
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public UploadedFile getUpload() {

		return upload;

	}


	public void setUpload(UploadedFile upload) {

		this.upload = upload;

	}
	public String loadGif(){
		
		 return "success";
	}
	public String uploadFile() {
		this.message="";
		this.message1="";
		this.message2="";
		if(this.toUserName.equalsIgnoreCase("")){
			this.message2=AppConfig.PROPERTIES.getProperty("EMPTY_TO_USER");
			return "failure";
		}
		String g11=this.toUserName;
    	UserServices userServices=new UserServices();
		String ss=userServices.findUser(g11);
		if(ss.equalsIgnoreCase("failure")){
			message2=AppConfig.PROPERTIES.getProperty("INVALID_TO_USER");
			return "failure";
		}
		
		File savedFileName;

		String dirPath = "C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\UploadedImages\\";

		InputStream fileContent = null;

		if (upload == null) {
			return "success1";

		}

		try {

			fileContent = upload.getInputStream();


		} catch (IOException e) {

			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);

		}

		String uploadFileName = trimFilePath(upload.getName());
		int k= uploadFileName.lastIndexOf(".");
		String g=uploadFileName.substring(k+1);
		if(!g.equalsIgnoreCase("png")){
			if(!g.equalsIgnoreCase("jpeg")){ 
				if(!g.equalsIgnoreCase("jpg")){
					if(!g.equalsIgnoreCase("gif")){
						if(!g.equalsIgnoreCase("bmp")){
			  this.message=AppConfig.PROPERTIES.getProperty("EMPTY_IMAGE");
			   return "failure";
			}}}}}
		this.setImageName(uploadFileName.substring(0,k+1)+"png");
		savedFileName = new File(dirPath + imageName);

		BufferedOutputStream bos = null;

		try {

			bos = new BufferedOutputStream(new FileOutputStream(savedFileName));

		} catch (FileNotFoundException e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}

		byte[] buffer = new byte[1024];

		int len;

		try {

			while ((len = fileContent.read(buffer)) >= 0) {

				bos.write(buffer, 0, len);

			}

		} catch (IOException e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}

		try {

			fileContent.close();

			bos.close();

		} catch (IOException e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}
        try {
			Thread.sleep(15000);
			
		} catch (InterruptedException e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}
		try {
			BufferedImage i1=ImageIO.read(new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\UploadedImages\\"+imageName));
			int width=i1.getWidth();
			int height=i1.getHeight();
			size=((width*height)/8)-4;
			view=1;	
		} catch (IOException e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}
		return "success1";

	}


	public static String trimFilePath(String fileName) {

		return fileName.substring(fileName.lastIndexOf("/") + 1).substring(

				fileName.lastIndexOf("\\") + 1);

	}

	public String Encrypted(){
		this.message="";
		this.message1="";
		this.message2="";
		this.data1="";
		this.count=0;
		for (int i = 0; i < this.data.length(); i++) {
			char a=this.data.charAt(i);
			int a1=a;
			if(a1==32){
				count++;
			}
		}
		if(this.toUserName.equalsIgnoreCase("")&&!this.data.equalsIgnoreCase("")){
			this.message="enter the To user name Image not encrypted press encrypt button";
			return "failure";
		}
		if(this.toUserName.equalsIgnoreCase("")){
			this.message="enter the To user name";
			return "failure";
		}
		UserServices userServices=new UserServices();
		String ss=userServices.findUser(toUserName);
		this.recive=ss;
		if(this.data.equalsIgnoreCase("")){
			
			this.message=AppConfig.PROPERTIES.getProperty("EMPTY_MESSAGE");
			return "failure";
		}
		else if(this.count==this.data.length()){
			this.message=AppConfig.PROPERTIES.getProperty("MESSAGE_SPACES");
			return "failure";
		}
		else {
			if(ss.equalsIgnoreCase("failure")){
				this.recive=ss;
				this.flag="%%%";
				System.out.println(flag);
				this.message1="enter correct TO: username enter the details again";
				this.put="yes";
				return "failure";
			}
		else{
			this.data1="yes";
		EncryptImage encryptImage=new EncryptImage();
		String s=encryptImage.Image(this.data,this.imageName);
		this.put="yes";
		if(s.equalsIgnoreCase("success1")){
			this.message=AppConfig.PROPERTIES.getProperty("ENCRYPT_SUCCESS");
		}
		return s;
	}
	}
	}
    public String sendMessage(){
    	this.message="";
    	if(this.recive.equalsIgnoreCase("failure")){
    		this.imageName=null;
        	this.toUserName=null;
        	this.data=null;
        	this.flag="";
        	this.message="";
        	this.message1="";
        	this.put="";
        	this.view=0;
        	this.data1="";
    		return "failure";
    	}
    	else{
    	SendTO sendTO=new SendTO();
    	sendTO.setSender(loginMB.getUsername());
    	sendTO.setReciver(this.toUserName);
        UserSendManager manager=new UserSendManager();
        String s=manager.setSendDetails(sendTO);
        this.imageName=null;
    	this.toUserName=null;
    	this.data=null;
    	this.flag="";
    	this.message="";
    	this.message1="";
    	this.put="";
    	this.view=0;
    	this.data1="";
    	return s;
    }
}
    public void sendtoo(ValueChangeEvent valueChangeEvent){
    	message="";
    	String g=(String) valueChangeEvent.getNewValue();
    	UserServices userServices=new UserServices();
		String ss=userServices.findUser(g);
		if(ss.equalsIgnoreCase("success")){
			
		}
		else{
			this.message2=AppConfig.PROPERTIES.getProperty("INVALID_TO_USER");
		}
    	
    }

}
