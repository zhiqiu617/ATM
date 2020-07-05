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

public class wd_other extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jp_center = new JPanel();   //�м����
	private JPanel jp_Ctop = new JPanel();     //�м仭��Ķ�������
	private JPanel jp_Ccenter = new JPanel();  //�м������м仭��
	private JPanel jp_Cchioce = new JPanel();     //��ʾ����
	private JPanel jp_Ccash = new JPanel();     //����
	private JPanel jp_Cfloor = new JPanel();   //�м����ĵײ�����
	private JPanel jp_west = new JPanel();     //��ť���
	private JPanel jp_east = new JPanel();     //�Ұ�ť���
	private JPanel jp_W = new JPanel();   //��߽���
	private JPanel jp_E = new JPanel();   //�ұ߽���
	private JPanel jp_correct = new JPanel();  //���������
	
	private String[] iaW = {" "," "," "," "};    
	private String[] iaE = {" "," "," "," "};
	private JButton[] eastB = new JButton[iaE.length];  //���水ť
	private JButton[] westB = new JButton[iaW.length];  //���水ť
	
	private JLabel jl_choice = new JLabel("������ȡ����(������100)!");
	private JLabel jl_cash = new JLabel("���:");
	private JTextField jpf_cash = new JTextField(15);
	private JLabel jl_return = new JLabel("<<����");
	private JLabel jl_correct = new JLabel("����>>");
	private JLabel jl_verify = new JLabel("ȷ��>>");
	
	
	public wd_other(){
		super("��ӭʹ������ATM��!");
		init();
	}
	
	public void init(){
		setSize(480,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�ұ߰�ť����
		jp_east.setLayout(new GridLayout(4,1,8,30));
		for(int i=0;i<iaE.length;i++){
			eastB[i] = new JButton(iaE[i]);
			jp_east.add(eastB[i]);
		}
		eastB[2].addActionListener(this);
		eastB[3].addActionListener(this);
		jp_E.setLayout(new BorderLayout());
		jp_E.add(jp_east,BorderLayout.CENTER);
		//��߰�ť����
		jp_west.setLayout(new GridLayout(4,1,8,30));
		for(int j=0;j<iaW.length;j++){
			westB[j] = new JButton(iaW[j]);
			jp_west.add(westB[j]);
		}
		westB[3].addActionListener(this);
		jp_W.setLayout(new BorderLayout());
		jp_W.add(jp_west,BorderLayout.CENTER);
		
		//�м���沼��
		jp_Cchioce.setLayout(new FlowLayout());
		jp_Cchioce.add(jl_choice);
		jp_Ccash.setLayout(new FlowLayout());
		jp_Ccash.add(jl_cash);
		jp_Ccash.add(jpf_cash);
		jp_Cfloor.setLayout(new GridLayout(1,2,10,5));
		jp_Cfloor.add(jl_return);
		jl_verify.setHorizontalAlignment(SwingConstants.RIGHT);
		jp_Cfloor.add(jl_verify);
		jp_correct.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_correct.add(jl_correct);
		jp_Ccenter.setLayout(new GridLayout(4,1,10,5));
		jp_Ccenter.add(jp_Cchioce);
		jp_Ccenter.add(jp_Ccash);
		jp_Ccenter.add(jp_correct);
		jp_Ccenter.add(jp_Cfloor);		
		
		jp_center.setBorder(BorderFactory.createTitledBorder("��¼����"));
		jp_center.setLayout(new BorderLayout(5,5));
		jp_center.setPreferredSize(new Dimension(30,40));
		jp_center.add(jp_Ctop,BorderLayout.NORTH);
		jp_center.add(jp_Ccenter,BorderLayout.CENTER);
		//jp_center.add(jp_Cfloor, BorderLayout.SOUTH);
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
		//������ذ�ť
		if(e.getSource() == westB[3]){
			WithDrawDialog wd = new WithDrawDialog();
    		setVisible(false);
			wd.setVisible(true);		
		}
		//���������ť
		if(e.getSource() == eastB[2]){
							
		}
		//���ȷ�ϰ�ť
		if(e.getSource() == eastB[3]){
					
		}		
	}
	
	public static void main(String args[]) {
		new wd_other();
	}

	
	
}

