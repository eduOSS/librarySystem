package excercise.socket.forAll;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class BookInfo extends JPanel implements ActionListener
{
	JPanel p1,p2,p3,p4,p5;
	JLabel jl1,jl2;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jtable;
	JScrollPane jsp;
	BookModel bk,addbook;
	public BookInfo()
	{
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jl1 = new JLabel("请输入图书名字：");
		jtf = new JTextField(20);
		jb1 = new JButton("查询");
		p1.add(jl1);
		p1.add(jtf);
		p1.add(jb1);
		//zhongjian
		
		bk = new BookModel();
		String[] paras = {"1"};
		bk.query("select bookId,bookName,bookAuthor,bookPublicName,bookIntroduction,bookPublicDate from allbooks where 1=?", paras);
		jtable = new JTable(bk.rows,bk.colums);
		p2 = new JPanel(new BorderLayout());
		jsp = new JScrollPane(jtable);
		//p2.add(jsp);
		
		//xia
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jl2 = new JLabel("总记录数是"+jtable.getRowCount()+"条");
		p3.add(jl2);
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jb2 = new JButton("详细信息");
		jb3 = new JButton("添加");
		jb3.addActionListener(this);
		jb4 = new JButton("修改");
		jb4.addActionListener(this);
		jb5 = new JButton("删除");
		jb5.addActionListener(this);
		p4.add(jb2);
		p4.add(jb3);
		p4.add(jb4);
		p4.add(jb5);
		p5 = new JPanel(new BorderLayout());
		p5.add(p3,"West");
		p5.add(p4,"East");
		
		this.setLayout(new BorderLayout());
		this.add(p1,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.CENTER);
		this.add(p5,BorderLayout.SOUTH);
		this.setBackground(Color.PINK);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(jb5==arg0.getSource())
		{
			int selRowNum=jtable.getSelectedRow();
			String bookNo =(String)bk.getValueAt(selRowNum,0);
			if(bk.delebook(bookNo))
			{
				JOptionPane.showMessageDialog(null, "删除成功");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "删除不成功");
				
			}
			
			String[] paras = {"1"};
			String sql = "select bookId,bookName,bookAuthor,bookPublicName,bookIntroduction,bookPublicDate from allbooks where 1=?";
			bk = new BookModel();
			bk.query(sql, paras);
			jtable.setModel(bk);
		}
        if(jb3==arg0.getSource())
		{
			BookDialog bd = new BookDialog();
			//更新表格
			
			
		}
        if(arg0.getSource()==jb4)
        {
        	int rowNums = this.jtable.getSelectedRow();
        	if(rowNums == -1)
        	{
        		JOptionPane.showMessageDialog(this,"请选择一行");
        		return;
        	}
        	BookUpdate bup = new BookUpdate(bk,rowNums);
        	
        }
		
	}
}
