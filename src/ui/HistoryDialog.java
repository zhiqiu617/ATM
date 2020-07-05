package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HistoryDialog extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jp_center = new JPanel();   //中间界面
	private JPanel jp_Ccenter = new JPanel();   //中间界面的中间画板
	private JPanel jp_west = new JPanel();     //左按钮面板
	private JPanel jp_east = new JPanel();     //右按钮面板
	private JPanel jp_W = new JPanel();   //左边界面
	private JPanel jp_E = new JPanel();   //右边界面
	private JPanel jp_Cfloor= new JPanel();  //中间底部的面板
	private JPanel jp_Ctable = new JPanel();  //表格的面板
	//private JPanel jp_return = new JPanel();  //返回的面板
	
	private String[] iaW = {"1","3","5","7"};    
	private String[] iaE = {"2","4","6","8"};
	private JButton[] eastB = new JButton[iaE.length];  //东面按钮
	private JButton[] westB = new JButton[iaW.length];  //西面按钮

	String[] columnNames = {"交易日期","支出","收入","对方帐号"};
	Object[][] data = {
			{"2018-06-01 12:00:00","480.0","0.0","13001642000000502422"},
			{"2018-06-13 16:00:00","2000.0","0.0","13001642000000502488"},
			{"2018-06-24 21:00:00","480.0","0.0","13001642000000502455"},
			{"2018-06-30 13:00:00","470.0","0.0","13001642000000502466"},
			{"2018-06-30 13:00:00","470.0","0.0","13001642000000502466"},
			{"2018-06-30 13:00:00","470.0","0.0","13001642000000502466"},
			{"2018-06-30 13:00:00","470.0","0.0","13001642000000502466"},
	};
	private JTable table = new JTable(data,columnNames);     //构造表格
	private JScrollPane jsc;
	
	private JLabel jl_month = new JLabel("<<近一个月");
	private JLabel jl_return = new JLabel("返回>>");
	
	public HistoryDialog(){
		super("欢迎使用银行ATM机!");
		init();
	}
	
	public void init(){
		setSize(480,320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//右边按钮设置
		jp_east.setLayout(new GridLayout(4,1,8,26));
		for(int i=0;i<iaE.length;i++){
			eastB[i] = new JButton(iaE[i]);
			jp_east.add(eastB[i]);
		}
		eastB[3].addActionListener(this);
		jp_E.setLayout(new BorderLayout());
		jp_E.add(jp_east,BorderLayout.CENTER);
		//左边按钮设置
		jp_west.setLayout(new GridLayout(4,1,8,26));
		for(int j=0;j<iaW.length;j++){
			westB[j] = new JButton(iaW[j]);
			jp_west.add(westB[j]);
		}
		westB[3].addActionListener(this);
		jp_W.setLayout(new BorderLayout());
		jp_W.add(jp_west,BorderLayout.CENTER);
		
		//数据表建立
		table.getTableHeader().setFont(new Font("宋体",Font.BOLD,13));   //设置表格字体
		table.setFont(new Font("宋体",Font.PLAIN,12));  //设置表格字体
		table.setRowHeight(20);  //设置行高
		jsc = new JScrollPane(table);  //设置垂直滚动条
		table.setFillsViewportHeight(true);
		//jsc.setPreferredSize(new Dimension(320, 180));// 设置JScrollPane的大小
        //jsc.setBounds(15, 8, 180, 80);
		jsc.setSize(180, 80);
		
		//设置指定列的宽度
		int[] ia = {140,50,40,160};
		for(int i=0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(ia[i]);
			table.getColumnModel().getColumn(i).setMaxWidth(ia[i]);
			table.getColumnModel().getColumn(i).setMinWidth(ia[i]);
		}
		jp_Ctable.add(table,BorderLayout.CENTER);
		jp_Ctable.add(jsc,BorderLayout.CENTER);
		System.out.println(jsc.getBounds());
		
		//中间界面布局
		jp_Cfloor.setLayout(new GridLayout(1,2,10,10));
		jp_Cfloor.add(jl_month);
		jl_return.setHorizontalAlignment(SwingConstants.RIGHT);
		jp_Cfloor.add(jl_return);
		
		jp_Ccenter.setLayout(new GridLayout(2,1,5,30));
        jp_Ccenter.add(jp_Ctable);
		jp_Ccenter.add(jp_Cfloor);
        
		jp_center.setBorder(BorderFactory.createTitledBorder("历史数据查询窗口"));
		jp_center.setLayout(new BorderLayout(5,5));
		jp_center.setPreferredSize(new Dimension(30,40));
		jp_center.add(jp_Ccenter,BorderLayout.CENTER);
		
		//整体布局
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gblc = new GridBagConstraints();
		setLayout(gbl);
		gblc.fill = GridBagConstraints.BOTH;
		gblc.gridwidth = 1;
		gblc.weightx = 1.0;
		gblc.weighty = 5.0;
		gbl.setConstraints(jp_W, gblc);
		add(jp_west);
		gblc.gridwidth = 8;
		gblc.weightx = 6.0;
		gbl.setConstraints(jp_center, gblc);
		add(jp_center);
		gblc.gridwidth = 1;
		gblc.weightx = 1.0;
		gbl.setConstraints(jp_E, gblc);
		add(jp_east);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//点击返回按钮
		if(e.getSource() == westB[3]){
				   		
		}
		//点击返回按钮
		if(e.getSource() == eastB[3]){
		    MainUI main = new MainUI();
		    setVisible(false);
			main.setVisible(true);		
		}
	}
	
	public static void main(String args[]) {
		new HistoryDialog();
	}

	
	
}

