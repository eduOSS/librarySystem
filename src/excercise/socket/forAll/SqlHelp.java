//对数据库的操作的类
//对数据库的操作，
package excercise.socket.forAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SqlHelp 
{
	public PreparedStatement ps = null;
	ResultSet rs = null;
	public Connection ct = null;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
	String user = "root";
	String passwd = "123456";
	public SqlHelp()
	{
		try
		{
			Class.forName(driverName);
			ct = DriverManager.getConnection(url,user,passwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean exeUpdate(String sql,String[] paras)
	{
		boolean b = true;
		try
		{
			ps = ct.prepareStatement(sql);
			
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			b = false;
			e.printStackTrace();
		}
		return b;
	}
	
	public ResultSet query(String sql, String[] paras)
	{
		try
		{
			ps = ct.prepareStatement(sql);
			
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			rs = ps.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close()
	{
		try
		{
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(ct!=null)ct.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
