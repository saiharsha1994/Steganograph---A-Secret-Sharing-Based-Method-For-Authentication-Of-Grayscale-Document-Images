package PresentationTier;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import utility.AppConfig;

import BusinessTier.SentTO;
import PersistenceTier.SentServices;


public class SentMB {
  
	private List<SentTO> list=new ArrayList<SentTO>();
	private LoginMB loginMB;
	private HtmlDataTable htmlDataTable;
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
	public List<SentTO> getList() {
		return list;
	}
	public void setList(List<SentTO> list) {
		this.list = list;
	}
	public LoginMB getLoginMB() {
		return loginMB;
	}
	public void setLoginMB(LoginMB loginMB) {
		this.loginMB = loginMB;
	}
	public HtmlDataTable getHtmlDataTable() {
		return htmlDataTable;
	}
	public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
		this.htmlDataTable = htmlDataTable;
	}
	public String getImageNameInbox() {
		return imageNameInbox;
	}
	public void setImageNameInbox(String imageNameInbox) {
		this.imageNameInbox = imageNameInbox;
	}
	
	public String sentItemsView(){
		this.there="";
		SentServices sentServices=new SentServices();
		this.list=sentServices.sentView(loginMB.getUsername());
		if(list.size()==0){
			this.there=AppConfig.PROPERTIES.getProperty("NO_SENTITEMS");
			return "failure";
		}
		return "success";
	}
	public String click(){
		this.s=null;
		SentTO sentTO= (SentTO) htmlDataTable.getRowData();
		this.setImageNameInbox(sentTO.getImageName());
		this.setName(sentTO.getReciver());
		return "success1";
	}
}
