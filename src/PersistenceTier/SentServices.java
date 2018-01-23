package PersistenceTier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import BusinessTier.SentTO;

public class SentServices {

	
		public List<SentTO> sentView(String username){
			List<SentTO> list=new ArrayList<SentTO>();
			String driverName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "project";
			String userName = "root";
			String password = "admin";
			Connection con = null;
			try{
				Class.forName(driverName);
				con = DriverManager.getConnection(url+dbName,userName,password);
				PreparedStatement stmt = con.prepareStatement("select sender,reciver,image,date from composeentity where sender=? order by date DESC");
				stmt.setString(1,username);
				ResultSet rs = stmt.executeQuery();
				int i = 0;
				while (rs.next()) {
					SentTO sentTO=new SentTO();
					sentTO.setReciver(rs.getString(2));
					sentTO.setSender(rs.getString(1));
					sentTO.setImageName("test"+i+".png");
					InputStream in = rs.getBinaryStream(3);
					sentTO.setDate(rs.getDate(4));
					OutputStream f = new FileOutputStream(new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\ImagesSent\\test"+i+".png"));
					
					i++;
					int c = 0;
					while ((c = in.read()) > -1) {
						f.write(c);
					}
					f.close();
					in.close();
					list.add(sentTO);
				}

			}catch(Exception ex){
				Logger logger = Logger.getLogger(this.getClass());
				logger.error(ex.getMessage(), ex);
			}
		return list;
			
		}
}
