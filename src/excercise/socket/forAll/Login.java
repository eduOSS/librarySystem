package excercise.socket.forAll;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import excercise.socket.admin.AdminLogin;
import excercise.socket.reader.ReaderLogin;

public class Login extends JFrame implements ActionListener
{
	JMenuBar jmb;
	JButton jb1,jb2,jb3;
	JLabel jl1,jl2,jl3;
	JMenu menu1,menu2;
	JTextField jtf;
	JPasswordField jpf;
	JPanel jp1,jp2,jp3;
	
	public static void main(String[] agrs)
	{
		Login login = new Login();
	}
	
	public Login()
	{
		jmb = new JMenuBar();
		menu1 = new JMenu("File");
		menu1.setFont(new Font("宋体",Font.PLAIN, 20));
		menu2 = new JMenu("Help");
		menu2.setFont(new Font("宋体",Font.PLAIN,20));
		jmb.add(menu1);
		jmb.add(menu2);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
	    
		
		jl1 = new JLabel(new ImageIcon("image/book.png"));
		jp1.add(jl1);
		
		jl2 = new JLabel("用户名：",JLabel.CENTER);
		jl2.setFont(new Font("宋体", Font.PLAIN,20));
		jl3 = new JLabel("密  码：",JLabel.CENTER);
		jl3.setFont(new Font("宋体", Font.PLAIN,20));
		jtf = new JTextField(JTextField.WEST);
		jtf.setBorder(BorderFactory.createLoweredBevelBorder());
		jpf = new JPasswordField(JPasswordField.WEST);
		jpf.setBorder(BorderFactory.createLoweredBevelBorder());
		jp2.setLayout(new GridLayout(2,2));
		jp2.add(jl2);
		
		jp2.add(jtf);
		jp2.add(jl3);
		jp2.add(jpf);
		jb1 = new JButton("登陆");
		jb1.addActionListener(this);
		jb1.setFont(new Font("宋体", Font.PLAIN,16));
		jb2 = new JButton("取消");
		jb2.addActionListener(this);
		jb2.setFont(new Font("宋体", Font.PLAIN,16));
		jb3 = new JButton("注册");
		jb3.addActionListener(this);
		jb3.setFont(new Font("宋体", Font.PLAIN,16));
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		
		this.setJMenuBar(jmb);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		
		ImageIcon image = new ImageIcon("image/book3.png");
		this.setIconImage(image.getImage());
		this.setTitle("Library Manager System");
		this.setSize(300, 300);
		this.setBounds(500, 200, 320, 320);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//取出用户名和密码
			String u = this.jtf.getText().trim();
			String p =new String( this.jpf.getPassword());
			UserModel um = new UserModel();
			String res = um.checkUser(u, p);
			//这个必须放到服务器上，一个输入，返回一个用户类就可以
			
			System.out.println(u+"用户名："+res);
			
			if(res.equals("admin"))
			{
				new AdminLogin();
				this.dispose();
			}
			else if (res.equals("reader"))
			{
				new ReaderLogin();
				this.dispose();
			}
		}
		else if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}
	
}
