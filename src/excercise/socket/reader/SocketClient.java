package excercise.socket.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	Socket s=null;	
	public void sendMessageOut(String sql, Object... args) throws IOException{
		
		try {
			s = new Socket(InetAddress.getByName("localhost"), 12345);
			PrintWriter out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
			
			out.println(sql);
			out.println(args.length);
			for(int i=0;i<args.length;i++){
				out.println(args[i]);	
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void getMessageIN(){
		try {
			s = new Socket(InetAddress.getByName("localhost"), 12345);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
