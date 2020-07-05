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

public class LoginUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jp_center = new JPanel();   //�м����
	private JPanel jp_Ctop = new JPanel();     //�м仭��Ķ�������
	private JPanel jp_Ccenter = new JPanel();  //�м������м仭��
	private JPanel jp_Cnum = new JPanel();     //����˺Ż���
	private JPanel jp_Cpsd = new JPanel();     //������뻭��
	private JPanel jp_Cfloor = new JPanel();   //�м����ĵײ�����
	private JPanel jp_west = new JPanel();     //��ť���
	private JPanel jp_east = new JPanel();     //�Ұ�ť���
	private JPanel jp_W = new JPanel();   //��߽���
	private JPanel jp_E = new JPanel();   //�ұ߽���
		
	private String[] iaW = {" "," "," "," "};    
	private String[] iaE = {" "," "," "," "};
	private JButton[] eastB = new JButton[iaE.length];  //���水ť
	private JButton[] westB = new JButton[iaW.length];  //���水ť
	
	private JLabel jl_choice = new JLabel("��ѡ��Ԥ���˺�!");
	private JLabel jl_num = new JLabel("�˻�:");
	private JComboBox jcb_num;   //Ԥ���˻����б�
	private Vector<String> n = new Vector<String>();  //�˻��б�Ԫ��
	private JLabel jl_password = new JLabel("����:");
	private JPasswordField jpf_password = new JPasswordField(15);
	private JLabel jl_cancel = new JLabel("<<ȡ��");
	private JLabel jl_verify = new JLabel("ȷ��>>");
	
	public LoginUI(){
		super("��ӭʹ������ATM��!");
		init();
	}
	
	public void init(){
		setSize(480,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�˻��б�Ԥ��
		n.addElement("13001642000000502422");
		n.addElement("13001642000000502433");
		n.addElement("13001642000000502444");
		n.addElement("13001642000000502455");
		n.addElement("13001642000000502566");
		n.addElement("13001642000000502577");
		n.addElement("13001642000000502488");
		jcb_num = new JComboBox <String>(n);
		JScrollPane jsp = new JScrollPane(jcb_num);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);   //���ô�ֱ�������Զ�����
		jcb_num.setSize(5, 20);
		
		//�ұ߰�ť����
		jp_east.setLayout(new GridLayout(4,1,8,30));
		for(int i=0;i<iaE.length;i++){
			eastB[i] = new JButton(iaE[i]);
			jp_east.add(eastB[i]);
		}
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
		jp_Ctop.add(jl_choice);
		
		jp_Cnum.setLayout(new FlowLayout());
		jp_Cnum.add(jl_num);
		jp_Cnum.add(jcb_num);
		jp_Cpsd.setLayout(new FlowLayout());
		jp_Cpsd.add(jl_password);
		jp_Cpsd.add(jpf_password);
		jp_Cfloor.setLayout(new GridLayout(1,2,10,10));
		jp_Cfloor.add(jl_cancel);
		jl_verify.setHorizontalAlignment(SwingConstants.RIGHT);
		jp_Cfloor.add(jl_verify);
		jp_Ccenter.setLayout(new GridLayout(3,1));
		jp_Ccenter.add(jp_Cnum);
		jp_Ccenter.add(jp_Cpsd);
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
		//jp_overall.setLayout(new GridLayout(1,3,100,5));
		//jp_overall.add(jp_west);
		//jp_overall.add(jp_center);
		//jp_overall.add(jp_east);
		//add(jp_overall,BorderLayout.CENTER);
		//add(jp_center,BorderLayout.CENTER);
		//add(jp_east,BorderLayout.EAST);
		//add(jp_west,BorderLayout.WEST);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//StringBuffer s = new StringBuffer();
		//���ȷ�ϰ�ť
		if(e.getSource() == eastB[3]){
			/*Object num = jcb_num.getSelectedItem();
			s.append(";\n�˻�:").append(num);
			String psd = new String(jpf_password.getPassword()).trim();
			if(!jpf_password.equals(arg0)){
				JOptionPane.showMessageDialog(this, "�����������������");
				jpf_password.requestFocus(true);
				return;
			}
			else{
				s.append(";\n����:").append(psd);
			}
			JOptionPane.showMessageDialog(this, s.toString()); */
			MainUI main = new MainUI();
			setVisible(false);
			main.setVisible(true);
		}
		//���ȡ����ť�˳�ϵͳ
		if(e.getSource() == westB[3]){
			System.exit(0);
		}
	}
	
	public static void main(String args[]) {
		new LoginUI();
	}

}

