package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.*;

public class UnderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	//private JPanel jp_under = new JPanel();   //�м����
	//private JPanel jp_west = new JPanel();     //��ť���
	//private JPanel jp_east = new JPanel();     //�Ұ�ť���
	//private JPanel jp_south = new JPanel();   //��߽���
	//private JPanel jp_north = new JPanel();   //�ұ߽���

	private JLabel east = new JLabel("     ");
	private JLabel west = new JLabel("     ");
	private JLabel south = new JLabel("     ");
	private JLabel north = new JLabel("     ");
	
	public UnderUI(){
		super("��ӭʹ������ATM��!");
		init();
	}
	
	public void init(){
		setSize(480,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		//jp_under.setLayout(new BorderLayout());
		add(north,BorderLayout.NORTH);
		add(south,BorderLayout.SOUTH);
		add(east,BorderLayout.EAST);
		add(west,BorderLayout.WEST);
		
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new UnderUI();
	}

}

