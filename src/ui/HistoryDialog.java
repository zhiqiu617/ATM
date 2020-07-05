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
	private JPanel jp_center = new JPanel();   //�м����
	private JPanel jp_Ccenter = new JPanel();   //�м������м仭��
	private JPanel jp_west = new JPanel();     //��ť���
	private JPanel jp_east = new JPanel();     //�Ұ�ť���
	private JPanel jp_W = new JPanel();   //��߽���
	private JPanel jp_E = new JPanel();   //�ұ߽���
	private JPanel jp_Cfloor= new JPanel();  //�м�ײ������
	private JPanel jp_Ctable = new JPanel();  //�������
	//private JPanel jp_return = new JPanel();  //���ص����
	
	private String[] iaW = {"1","3","5","7"};    
	private String[] iaE = {"2","4","6","8"};
	private JButton[] eastB = new JButton[iaE.length];  //���水ť
	private JButton[] westB = new JButton[iaW.length];  //���水ť

	String[] columnNames = {"��������","֧��","����","�Է��ʺ�"};
	Object[][] data = {
			{"2018-06-01 12:00:00","480.0","0.0","13001642000000502422"},
			{"2018-06-13 16:00:00","2000.0","0.0","13001642000000502488"},
			{"2018-06-24 21:00:00","480.0","0.0","13001642000000502455"},
			{"2018-06-30 13:00:00","470.0","0.0","13001642000000502466"},
			{"2018-06-30 13:00:00","470.0","0.0","13001642000000502466"},
			{"2018-06-30 13:00:00","470.0","0.0","13001642000000502466"},
			{"2018-06-30 13:00:00","470.0","0.0","13001642000000502466"},
	};
	private JTable table = new JTable(data,columnNames);     //������
	private JScrollPane jsc;
	
	private JLabel jl_month = new JLabel("<<��һ����");
	private JLabel jl_return = new JLabel("����>>");
	
	public HistoryDialog(){
		super("��ӭʹ������ATM��!");
		init();
	}
	
	public void init(){
		setSize(480,320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�ұ߰�ť����
		jp_east.setLayout(new GridLayout(4,1,8,26));
		for(int i=0;i<iaE.length;i++){
			eastB[i] = new JButton(iaE[i]);
			jp_east.add(eastB[i]);
		}
		eastB[3].addActionListener(this);
		jp_E.setLayout(new BorderLayout());
		jp_E.add(jp_east,BorderLayout.CENTER);
		//��߰�ť����
		jp_west.setLayout(new GridLayout(4,1,8,26));
		for(int j=0;j<iaW.length;j++){
			westB[j] = new JButton(iaW[j]);
			jp_west.add(westB[j]);
		}
		westB[3].addActionListener(this);
		jp_W.setLayout(new BorderLayout());
		jp_W.add(jp_west,BorderLayout.CENTER);
		
		//���ݱ���
		table.getTableHeader().setFont(new Font("����",Font.BOLD,13));   //���ñ������
		table.setFont(new Font("����",Font.PLAIN,12));  //���ñ������
		table.setRowHeight(20);  //�����и�
		jsc = new JScrollPane(table);  //���ô�ֱ������
		table.setFillsViewportHeight(true);
		//jsc.setPreferredSize(new Dimension(320, 180));// ����JScrollPane�Ĵ�С
        //jsc.setBounds(15, 8, 180, 80);
		jsc.setSize(180, 80);
		
		//����ָ���еĿ��
		int[] ia = {140,50,40,160};
		for(int i=0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(ia[i]);
			table.getColumnModel().getColumn(i).setMaxWidth(ia[i]);
			table.getColumnModel().getColumn(i).setMinWidth(ia[i]);
		}
		jp_Ctable.add(table,BorderLayout.CENTER);
		jp_Ctable.add(jsc,BorderLayout.CENTER);
		System.out.println(jsc.getBounds());
		
		//�м���沼��
		jp_Cfloor.setLayout(new GridLayout(1,2,10,10));
		jp_Cfloor.add(jl_month);
		jl_return.setHorizontalAlignment(SwingConstants.RIGHT);
		jp_Cfloor.add(jl_return);
		
		jp_Ccenter.setLayout(new GridLayout(2,1,5,30));
        jp_Ccenter.add(jp_Ctable);
		jp_Ccenter.add(jp_Cfloor);
        
		jp_center.setBorder(BorderFactory.createTitledBorder("��ʷ���ݲ�ѯ����"));
		jp_center.setLayout(new BorderLayout(5,5));
		jp_center.setPreferredSize(new Dimension(30,40));
		jp_center.add(jp_Ccenter,BorderLayout.CENTER);
		
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
				   		
		}
		//������ذ�ť
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

