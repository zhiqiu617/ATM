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

public class MainUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jp_center = new JPanel();   //中间界面
	private JPanel jp_Cwest = new JPanel();     //中间画板的左边画板
	private JPanel jp_Ccenter = new JPanel();   //中间界面的中间画板
	private JPanel jp_Ceast = new JPanel();  //中间界面的右边画板
	private JPanel jp_west = new JPanel();     //左按钮面板
	private JPanel jp_east = new JPanel();     //右按钮面板
	private JPanel jp_W = new JPanel();   //左边界面
	private JPanel jp_E = new JPanel();   //右边界面
	
	private String[] iaW = {"1","3","5","7"};    
	private String[] iaE = {"2","4","6","8"};
	private JButton[] eastB = new JButton[iaE.length];  //东面按钮
	private JButton[] westB = new JButton[iaW.length];  //西面按钮
	
	private JLabel jl_choice = new JLabel("请选择相应功能!");
	private String[] iaw = {"<<取款","<<存款","<<转账"," "};
	private String[] iae = {"查询余额>>","修改密码>>","历史数据查询>>","退出系统>>"};
	private JLabel[] jl_west = new JLabel[iaw.length];
	private JLabel[] jl_east = new JLabel[iae.length];
	
	public MainUI(){
		super("欢迎使用银行ATM机!");
		init();
	}
	
	public void init(){
		setSize(480,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//右边按钮设置
		jp_east.setLayout(new GridLayout(4,1,8,36));
		for(int i=0;i<iaE.length;i++){
			eastB[i] = new JButton(iaE[i]);
			jp_east.add(eastB[i]);
			eastB[i].addActionListener(this);
		}
		jp_E.setLayout(new BorderLayout());
		jp_E.add(jp_east,BorderLayout.CENTER);
		//左边按钮设置
		jp_west.setLayout(new GridLayout(4,1,8,36));
		for(int j=0;j<iaW.length;j++){
			westB[j] = new JButton(iaW[j]);
			jp_west.add(westB[j]);
			westB[j].addActionListener(this);
		}
		jp_W.setLayout(new BorderLayout());
		jp_W.add(jp_west,BorderLayout.CENTER);
		
		//中间界面布局
		jp_Cwest.setLayout(new GridLayout(4,1,8,28));
		for(int j=0;j<iaw.length;j++){
			jl_west[j] = new JLabel(iaw[j]);
			jp_Cwest.add(jl_west[j]);
		}
		
		jp_Ceast.setLayout(new GridLayout(4,1,8,28));
		for(int i=0;i<iaw.length;i++){
			jl_east[i] = new JLabel(iae[i]);
			jl_east[i].setHorizontalAlignment(SwingConstants.RIGHT);
			jp_Ceast.add(jl_east[i]);
		}
		
		jp_Ccenter.setLayout(new FlowLayout());
		jp_Ccenter.add(jl_choice);
		
		jp_center.setBorder(BorderFactory.createTitledBorder("主窗口"));
		jp_center.setLayout(new BorderLayout(5,5));
		jp_center.setPreferredSize(new Dimension(30,40));
		jp_center.add(jp_Cwest,BorderLayout.WEST);
		jp_center.add(jp_Ccenter,BorderLayout.CENTER);
		jp_center.add(jp_Ceast, BorderLayout.EAST);
		
		//整体布局
		UnderUI under = new UnderUI();
		under.setLayout(new BorderLayout());
		
		
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
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//点击取款按钮
		if(e.getSource() == westB[0]){
			WithDrawDialog wd = new WithDrawDialog();
			setVisible(false);
			wd.setVisible(true);
		}
		//点击存款按钮
		if(e.getSource() == westB[1]){
			DepositDialog dp = new DepositDialog();
			setVisible(false);
			dp.setVisible(true);
		}
		//点击转账按钮
		if(e.getSource() == westB[2]){
			TransferAccountDialog ta = new TransferAccountDialog();
			setVisible(false);
			ta.setVisible(true);
		}
		//点击查询余额按钮
		if(e.getSource() == eastB[0]){
			BalanceDialog ba = new BalanceDialog();
			setVisible(false);
			ba.setVisible(true);
		}
		//点击修改密码按钮
		if(e.getSource() == eastB[1]){
			ModifyPSWDialog mp = new ModifyPSWDialog();
			setVisible(false);
			mp.setVisible(true);
		}
		//点击历史数据查询按钮
        if(e.getSource() == eastB[2]){
			HistoryDialog his = new HistoryDialog();
			setVisible(false);
			his.setVisible(true);
		}
        //点击退出系统按钮
        if(e.getSource() == eastB[3]){
	        LoginUI login = new LoginUI();
	        setVisible(false);
			login.setVisible(true);
        }
		
	}
	
	public static void main(String args[]) {
		new MainUI();
	}
	
	
}

