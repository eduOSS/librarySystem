package excercise.socket.forAll;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

 import javax.swing.*;
import javax.swing.event.*;
public class BookDialog extends JDialog implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;
	
	public BookDialog()
	{
		super();
		jl1 = new JLabel("书号");
		jl2 = new JLabel("书名");
		jl3 = new JLabel("作者");
		jl4 = new JLabel("出版社");
		jl5 = new JLabel("简介");
		jl6 = new JLabel("日期");
		jl7 = new JLabel("是否借出");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		jtf7 = new JTextField();
		
		jb1 = new JButton("添加");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		jb2.addActionListener(this);
		
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(7,1));
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(7,1));
		jp3 = new JPanel();
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setSize(350, 250);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1)
		{
			SqlHelp sq = new SqlHelp();
			String strinsert = "insert into allbooks values(?,?,?,?,?,?,?)";
			
			try 
			{
				sq.ps = sq.ct.prepareStatement(strinsert);
				
				sq.ps.setString(1, jtf1.getText());
				sq.ps.setString(2, jtf2.getText());
				sq.ps.setString(3, jtf3.getText());
				sq.ps.setString(4, jtf4.getText());
				sq.ps.setString(5, jtf5.getText());
				sq.ps.setString(6, jtf6.getText());
				sq.ps.setString(7, jtf7.getText());
				
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
			
			
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
		
	}

}
