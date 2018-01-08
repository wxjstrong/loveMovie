package loveMovie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestMysql {
	 PreparedStatement ps =null;
     Connection conn= null;
     ResultSet rs = null;
     
     static String driverClass="com.mysql.jdbc.Driver";
     static String url ="jdbc:mysql://localhost:3306/movie";
     static String username="root";
     static String password="";
	 String sql="select * from user";
	
	   @Test
       public void getConn() throws ClassNotFoundException, SQLException{
    	    List<String> list = new ArrayList<String>();
			Class.forName(driverClass);//加载驱动
			conn= DriverManager.getConnection(url, username, password);//获得连接
			
			//ps=conn.createStatement();
			ps=conn.prepareStatement(sql);//预编译sql
			rs=ps.executeQuery();         //执行查询
			while(rs.next()){
				list.add(rs.getString("username"));
			}
			System.out.println(list);     
			ps.close();
			conn.close();
		
       }
       
}
