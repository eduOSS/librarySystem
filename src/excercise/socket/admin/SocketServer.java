package excercise.socket.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import excercise.socket.forAll.SqlHelp;

public class SocketServer {
	
	SqlHelp sq = new SqlHelp();
	
	
	void getMessageIN(){
		try {
			ServerSocket ss = new ServerSocket(12345);
			Socket s=ss.accept();
			
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));//直接从缓存读取
			PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);//先从缓存读取，在输出到console中
			
			while(true){
				str=in.readLine();
				out.println("next");
			}
			
			try 
			{
				sq.ps = sq.ct.prepareStatement(strinsert);
				
				
				
				
				sq.ps.executeUpdate();
				
				this.dispose();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				sq.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
