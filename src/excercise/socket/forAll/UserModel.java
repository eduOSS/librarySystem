package excercise.socket.forAll;
import java.sql.ResultSet;
public class UserModel 
{
	/**
	 * 
	 * @param uid用户地址
	 * @param upwd用户名
	 * @return该用户的用户名没如果该用户不存在则返回""
	 */
	
	public String checkUser(String uid, String upwd)
	{
		 
		String query = "";
		SqlHelp splh =null;
		ResultSet rs;
		try
		{
			
			String sqla = "select peoplemanage.query from admin, peoplemanage where admin.useNo=peoplemanage.useNo and admin.adminName=? and admin.adminPassword=?";
			String sqlr = "select peoplemanage.query from reader, peoplemanage where reader.useNo=peoplemanage.useNo and reader.userName=? and reader.userPassword=?";
			String paras[] = {uid,upwd};
			splh = new SqlHelp();
			
			//rs = splh.query(sqla, paras);
			if((rs = splh.query(sqla, paras)).next())
			{
				query = rs.getString(1);
			}
			else if((rs = splh.query(sqlr, paras)).next())
			{
				query = rs.getString(1);
			}
		System.out.println(query);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			splh.close();
		}
		return query;
	}
}
