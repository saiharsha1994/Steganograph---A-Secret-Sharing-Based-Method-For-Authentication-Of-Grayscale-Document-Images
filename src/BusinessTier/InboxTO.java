package BusinessTier;

import java.sql.Date;
import java.sql.Timestamp;

public class InboxTO {
	private String sender;
	private String reciver;
	private String imageName;
	private Date date;
	private int flag;
	private Timestamp date1;
	
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Timestamp getDate1() {
		return date1;
	}
	public void setDate1(Timestamp date1) {
		this.date1 = date1;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
	
}
