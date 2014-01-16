package excercise.socket.reader;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReaderDialog extends JDialog implements ActionListener {
	JLabel jl1, jl2, jl3, jl4;
	JTextField jtf1, jtf2, jtf3, jtf4;
	JButton jb1, jb2;
	JPanel jp1, jp2, jp3;

	public ReaderDialog() {
		super();
		jl1 = new JLabel("编号");
		jl2 = new JLabel("性别");
		jl3 = new JLabel("名字");
		jl4 = new JLabel("学院");

		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();

		jb1 = new JButton("添加");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		jb2.addActionListener(this);

		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(7, 1));
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(7, 1));
		jp3 = new JPanel();
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);

		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);

		jp3.add(jb1);
		jp3.add(jb2);

		this.add(jp1, BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setSize(300, 200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		SocketClient sc=new SocketClient();
		if (arg0.getSource() == jb1) {
			String strinsert = "insert into reader values(?,?,?,?)";
			String[] args={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText()};

			sc.sendMessageOut(name, strinsert, args);
		}

		else if (arg0.getSource() == jb2) {
			this.dispose();
		}

	}

}
