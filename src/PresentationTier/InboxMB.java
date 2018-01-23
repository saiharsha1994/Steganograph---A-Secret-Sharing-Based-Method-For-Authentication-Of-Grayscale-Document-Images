package PresentationTier;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import utility.AppConfig;

import BusinessTier.DecryptImage;
import BusinessTier.InboxTO;
import PersistenceTier.InboxService;

public class InboxMB {

    private	List <InboxTO> list=new ArrayList<InboxTO>();
	private LoginMB loginMB;
	private HtmlDataTable table;
	private String imageNameInbox;
	private String s;
	private String name;
	private String there;
	
		
   
	public String getThere() {
		return there;
	}

	public void setThere(String there) {
		this.there = there;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getImageNameInbox() {
		return imageNameInbox;
	}

	public void setImageNameInbox(String imageNameInbox) {
		this.imageNameInbox = imageNameInbox;
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}

	public LoginMB getLoginMB() {
		return loginMB;
	}

	public void setLoginMB(LoginMB loginMB) {
		this.loginMB = loginMB;
	}

	
	public List<InboxTO> getList() {
		return list;
	}

	public void setList(List<InboxTO> list) {
		this.list = list;
	}

	public String inboxView(){
		this.there="";
		
		InboxService inboxService=new InboxService();
		list=inboxService.inboxview(loginMB.getUsername());
		
		if(list.size()==0){
			this.there=AppConfig.PROPERTIES.getProperty("NO_INBOX");
			return "failure";
		}
		
		return "success";
	}
	public String click(){
		this.s=null;
		
		InboxTO x=(InboxTO) table.getRowData();
		
		InboxService inboxService=new InboxService();
		inboxService.viewDate(x.getDate1());
		this.setImageNameInbox(x.getImageName());
		this.setName(x.getSender());
		return "success1";
	}
	public String decrypted(){
		 DecryptImage decryptImage=new DecryptImage();
		 String as=decryptImage.texted(this.getImageNameInbox());
		 this.s=as;
		 return "success1";
		
	}
}
