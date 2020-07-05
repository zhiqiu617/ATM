package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class TransferAccountDialog extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jp_center = new JPanel();   //中间界面
	private JPanel jp_Ctop = new JPanel();     //中间画板的顶部画板
	private JPanel jp_Ccenter = new JPanel();  //中间界面的中间画板
	private JPanel jp_Cnum = new JPanel();     //存放账号画板
	private JPanel jp_Ccash = new JPanel();     //存放金额画板
	private JPanel jp_west = new JPanel();     //左按钮面板
	private JPanel jp_east = new JPanel();     //右按钮面板
	private JPanel jp_W = new JPanel();   //左边界面
	private JPanel jp_E = new JPanel();   //右边界面
	private JPanel jp_Cfloor = new JPanel();   //中间界面的底部画板
	private JPanel jp_correct = new JPanel();  //更正的面板
	
	private String[] iaW = {" "," "," "," "};    
	private String[] iaE = {" "," "," "," "};
	private JButton[] eastB = new JButton[iaE.length];  //东面按钮
	private JButton[] westB = new JButton[iaW.length];  //西面按钮
	
	private JLabel jl_choice = new JLabel("请选择要转入的帐号和金额!");
	private JLabel jl_num = new JLabel("账户:");
	private JComboBox jcb_num;   //预置账户的列表
	private Vector<String> n = new Vector<String>();  //账户列表元素
	private JLabel jl_cash = new JLabel("金额:");
	private JTextField jpf_cash = new JTextField(15);
	private JLabel jl_return = new JLabel("<<返回");
	private JLabel jl_correct = new JLabel("更正>>");
	private JLabel jl_verify = new JLabel("确认>>");
	
	public TransferAccountDialog(){
		super("欢迎使用银行ATM机!");
		init();
	}
	
	public void init(){
		setSize(480,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//账户列表预置
		n.addElement("13001642000000502422");
		n.addElement("13001642000000502433");
		n.addElement("13001642000000502444");
		n.addElement("13001642000000502455");
		n.addElement("13001642000000502566");
		n.addElement("13001642000000502577");
		n.addElement("13001642000000502488");
		jcb_num = new JComboBox <String>(n);
		JScrollPane jsp = new JScrollPane(jcb_num);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);   //设置垂直滚动条自动出现
		jcb_num.setSize(5, 20);
		
		//右边按钮设置
		jp_east.setLayout(new GridLayout(4,1,8,32));
		for(int i=0;i<iaE.length;i++){
			eastB[i] = new JButton(iaE[i]);
			jp_east.add(eastB[i]);
		}
		eastB[2].addActionListener(this);
		eastB[3].addActionListener(this);
		jp_E.setLayout(new BorderLayout());
		jp_E.add(jp_east,BorderLayout.CENTER);
		//左边按钮设置
		jp_west.setLayout(new GridLayout(4,1,8,32));
		for(int j=0;j<iaW.length;j++){
			westB[j] = new JButton(iaW[j]);
			jp_west.add(westB[j]);
		}
		westB[3].addActionListener(this);
		jp_W.setLayout(new BorderLayout());
		jp_W.add(jp_west,BorderLayout.CENTER);
		
		//中间界面布局
		jp_Ctop.add(jl_choice);
		
		jp_Cnum.setLayout(new FlowLayout());
		jp_Cnum.add(jl_num);
		jp_Cnum.add(jcb_num);
		jp_Ccash.setLayout(new FlowLayout());
		jp_Ccash.add(jl_cash);
		jp_Ccash.add(jpf_cash);
	
		jp_Cfloor.setLayout(new GridLayout(1,2,10,5));
		jp_Cfloor.add(jl_return);
		jl_verify.setHorizontalAlignment(SwingConstants.RIGHT);  //标签右对齐
		jp_Cfloor.add(jl_verify);
		jp_correct.setLayout(new FlowLayout(FlowLayout.RIGHT));  //布局右对齐
		jp_correct.add(jl_correct);
		jp_Ccenter.setLayout(new GridLayout(4,1));
		jp_Ccenter.add(jp_Cnum);
		jp_Ccenter.add(jp_Ccash);
		jp_Ccenter.add(jp_correct);
		jp_Ccenter.add(jp_Cfloor);
		
		jp_center.setBorder(BorderFactory.createTitledBorder("转账窗口"));
		jp_center.setLayout(new BorderLayout(5,5));
		jp_center.setPreferredSize(new Dimension(30,40));
		jp_center.add(jp_Ctop,BorderLayout.NORTH);
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
		    MainUI main = new MainUI();
			setVisible(false);
			main.setVisible(true);		
		}
		//点击更正按钮
		if(e.getSource() == eastB[2]){
									
		}
		//点击确认按钮
		if(e.getSource() == eastB[3]){
							
		}	
	}
	
	public static void main(String args[]) {
		new TransferAccountDialog();
	}

	
}

