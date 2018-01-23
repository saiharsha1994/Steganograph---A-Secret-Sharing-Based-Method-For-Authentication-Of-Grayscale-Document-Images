package PersistenceTier;

import java.io.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import BusinessTier.InboxTO;





public class InboxService {

	public List<InboxTO> inboxview(String username){
		 
		 List<InboxTO> list=new ArrayList<InboxTO>();
			String driverName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "project";
			String userName = "root";
			String password = "admin";
			Connection con = null;
			try{
				Class.forName(driverName);
				con = DriverManager.getConnection(url+dbName,userName,password);
				PreparedStatement stmt = con.prepareStatement("select sender,reciver,image,date,flag from composeentity where reciver=? order by date DESC");
				stmt.setString(1,username);
				ResultSet rs = stmt.executeQuery();
				int i = 0;
				while (rs.next()) {
					InboxTO inboxTO=new InboxTO();
					inboxTO.setReciver(rs.getString(2));
					inboxTO.setSender(rs.getString(1));
					inboxTO.setImageName("test"+i+".png");
					inboxTO.setFlag(rs.getInt(5));
					InputStream in = rs.getBinaryStream(3);
					inboxTO.setDate(rs.getDate(4));
					inboxTO.setDate1(rs.getTimestamp(4));
					OutputStream f = new FileOutputStream(new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\ImagesRetrived\\test"+i+".png"));
					i++;
					int c = 0;
					while ((c = in.read()) > -1) {
						f.write(c);
					}
					f.close();
					in.close();
					list.add(inboxTO);
				}

			}catch(Exception ex){
				Logger logger = Logger.getLogger(this.getClass());
				logger.error(ex.getMessage(), ex);
			}
		return list;
	}
	public void viewDate(Timestamp timestamp){
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "project";
		String userName = "root";
		String password = "admin";
		Connection con = null;
		try{
		Class.forName(driverName);
		con = DriverManager.getConnection(url+dbName,userName,password);

		PreparedStatement stmt = con.prepareStatement("update composeentity set flag=0 where date=?");
		stmt.setTimestamp(1,timestamp);
		int rs1 = stmt.executeUpdate();
	
		
		}
	catch(Exception ex){
		Logger logger = Logger.getLogger(this.getClass());
		logger.error(ex.getMessage(), ex);
	}
}
}