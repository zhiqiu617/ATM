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

public class WithDrawDialog extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jp_center = new JPanel();   //�м����
	private JPanel jp_Cwest = new JPanel();     //�м仭�����߻���
	private JPanel jp_Ccenter = new JPanel();   //�м������м仭��
	private JPanel jp_Ceast = new JPanel();  //�м������ұ߻���
	private JPanel jp_west = new JPanel();     //��ť���
	private JPanel jp_east = new JPanel();     //�Ұ�ť���
	private JPanel jp_W = new JPanel();   //��߽���
	private JPanel jp_E = new JPanel();   //�ұ߽���
	
	private String[] iaW = {"1","3","5","7"};    
	private String[] iaE = {"2","4","6","8"};
	private JButton[] eastB = new JButton[iaE.length];  //���水ť
	private JButton[] westB = new JButton[iaW.length];  //���水ť
	
	private JLabel jl_choice = new JLabel("��ѡ����!");
	private String[] iaw = {"<<500","<<1000","<<1500","����"};
	private String[] iae = {"100>>","200>>","300>>","����>>"};
	private JLabel[] jl_west = new JLabel[iaw.length];
	private JLabel[] jl_east = new JLabel[iae.length];
	
	public WithDrawDialog(){
		super("��ӭʹ������ATM��!");
		init();
	}
	
	public void init(){
		setSize(480,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�ұ߰�ť����
		jp_east.setLayout(new GridLayout(4,1,8,36));
		for(int i=0;i<iaE.length;i++){
			eastB[i] = new JButton(iaE[i]);
			jp_east.add(eastB[i]);
			eastB[i].addActionListener(this);
		}
		jp_E.setLayout(new BorderLayout());
		jp_E.add(jp_east,BorderLayout.CENTER);
		//��߰�ť����
		jp_west.setLayout(new GridLayout(4,1,8,36));
		for(int j=0;j<iaW.length;j++){
			westB[j] = new JButton(iaW[j]);
			jp_west.add(westB[j]);
			westB[j].addActionListener(this);
		}
		jp_W.setLayout(new BorderLayout());
		jp_W.add(jp_west,BorderLayout.CENTER);
		
		//�м���沼��
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
		
		jp_center.setBorder(BorderFactory.createTitledBorder("�ֽ���ȡ����"));
		jp_center.setLayout(new BorderLayout(5,5));
		jp_center.setPreferredSize(new Dimension(30,40));
		jp_center.add(jp_Cwest,BorderLayout.WEST);
		jp_center.add(jp_Ccenter,BorderLayout.CENTER);
		jp_center.add(jp_Ceast, BorderLayout.EAST);
		
		//���岼��
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
		//���500��ť
		if(e.getSource() == westB[0]){
			
		}
		//���1000��ť
		if(e.getSource() == westB[1]){
					
		}
		//���1500��ť
		if(e.getSource() == westB[2]){
					
		}
		//���������ť
		if(e.getSource() == westB[3]){
			wd_other other = new wd_other();
			setVisible(false);
			other.setVisible(true);
		}
		//���100��ť
		if(e.getSource() == eastB[0]){
			
		}
		//���200��ť
		if(e.getSource() == eastB[1]){
					
		}
		//���300��ť
		if(e.getSource() == eastB[2]){
					
		}
		//������ذ�ť
		if(e.getSource() == eastB[3]){
			MainUI main = new MainUI();
			setVisible(false);
			main.setVisible(true);
		}
		
	}
	
	public static void main(String args[]) {
		new WithDrawDialog();
	}

	
	
}

