
package excercise.socket.admin;
import javax.swing.table.*;

import excercise.socket.forAll.SqlHelp;

import java.util.*;
import java.sql.*;

public class ReaderModel extends AbstractTableModel 
{
	Vector<String> colums;
	Vector<Vector> rows;
	
	public boolean delereader(String useNo)
	{
		boolean b=true;
		String sql="delete from reader where useNo=?";
		String[] paras={useNo};
		SqlHelp  sh = new SqlHelp();
		try
		{
			b = sh.exeUpdate(sql, paras);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			sh.close();
		}
		return b;
	}
	
	
	public void query(String sql, String[] paras)
	{
		this.colums = new Vector<String>();
		this.rows = new Vector<Vector>();
		SqlHelp  sh = new SqlHelp();
		ResultSet rs = sh.query(sql, paras);
		
		try {
			
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++)
			{
				this.colums.add(rsmd.getColumnName(i+1));
			}
		
			while(rs.next())
			{
				Vector<String> temp = new Vector<String>();
				for(int i=0;i<rsmd.getColumnCount();i++)
				{
					temp.add(rs.getString(i+1));
				}
				rows.add(temp);
				
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			sh.close();
		}
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return super.getColumnName(column).toString();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.colums.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rows.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return ((Vector)rows.get(arg0)).get(arg1);
	}
	
}
