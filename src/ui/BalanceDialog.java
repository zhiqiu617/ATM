package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BalanceDialog extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jp_center = new JPanel();   //中间界面
	private JPanel jp_Ccenter = new JPanel();   //中间界面的中间画板
	private JPanel jp_west = new JPanel();     //左按钮面板
	private JPanel jp_east = new JPanel();     //右按钮面板
	private JPanel jp_W = new JPanel();   //左边界面
	private JPanel jp_E = new JPanel();   //右边界面
	private JPanel jp_num= new JPanel();  //帐号的面板
	private JPanel jp_balance = new JPanel();  //余额的面板
	private JPanel jp_return = new JPanel();  //返回的面板
	
	private String[] iaW = {"1","3","5","7"};    
	private String[] iaE = {"2","4","6","8"};
	private JButton[] eastB = new JButton[iaE.length];  //东面按钮
	private JButton[] westB = new JButton[iaW.length];  //西面按钮
	
	private JLabel jl_num = new JLabel("帐号");
	private JLabel jl_balance = new JLabel("余额：");
	private JLabel jl_return = new JLabel("返回>>");
	
	public BalanceDialog(){
		super("欢迎使用银行ATM机!");
		init();
	}
	
	public void init(){
		setSize(480,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//右边按钮设置
		jp_east.setLayout(new GridLayout(4,1,8,28));
		for(int i=0;i<iaE.length;i++){
			eastB[i] = new JButton(iaE[i]);
			jp_east.add(eastB[i]);
		}
		eastB[3].addActionListener(this);
		jp_E.setLayout(new BorderLayout());
		jp_E.add(jp_east,BorderLayout.CENTER);
		//左边按钮设置
		jp_west.setLayout(new GridLayout(4,1,8,28));
		for(int j=0;j<iaW.length;j++){
			westB[j] = new JButton(iaW[j]);
			jp_west.add(westB[j]);
		}
		jp_W.setLayout(new BorderLayout());
		jp_W.add(jp_west,BorderLayout.CENTER);
		
		//中间界面布局
		jp_num.setLayout(new FlowLayout());
		jp_num.add(jl_num);
		jp_balance.setLayout(new FlowLayout());
		jp_balance.add(jl_balance);
		jp_return.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_return.add(jl_return);
		jp_Ccenter.setLayout(new GridLayout(3,1,5,30));
        jp_Ccenter.add(jp_num);
        jp_Ccenter.add(jp_balance);
        jp_Ccenter.add(jp_return);
        
		jp_center.setBorder(BorderFactory.createTitledBorder("余额查询窗口"));
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
		if(e.getSource() == eastB[3]){
		    MainUI main = new MainUI();
		    setVisible(false);
			main.setVisible(true);		
		}
	}
	public static void main(String args[]) {
		new BalanceDialog();
	}

	
	
}

