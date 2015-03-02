package qa;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class QAUI extends JFrame implements ActionListener{

	String file="/exam.txt";
	JPanel pshow,pbtn,pq,pa;
	JButton bload,bq,ba;
	JLabel Q,A;
	Exam exam;
	QA qa;
	String q;
	String a;
	Boolean key=true;
	
	QAUI(){
		exam=new Exam(this.file);
		this.qa=exam.rand();
		this.q=qa.getQestion();
		this.a=qa.getAwnser();
		
		this.setLayout(new FlowLayout());
		pshow=new JPanel();
		pq=new JPanel();
		pa=new JPanel();
		pshow.setLayout(new GridLayout(2,1));
		Q=new JLabel("题目："+this.q);
		A=new JLabel("");
		Q.setFont(new java.awt.Font("MS Song", 0, 17));
		A.setFont(new java.awt.Font("MS Song", 0, 17));
		pq.add(Q);
		pa.add(A);
		pshow.add(Q);//,BorderLayout.NORTH);
		pshow.add(A);//,BorderLayout.SOUTH);
		
		bq=new JButton("题目");
		bq.addActionListener(this);
		ba=new JButton("答案");
		ba.addActionListener(this);
		ba.setFont(new java.awt.Font("MS Song", 0, 18));
		bq.setFont(new java.awt.Font("MS Song", 0, 18));
		pbtn=new JPanel();
		pbtn.setLayout(new FlowLayout());
		pbtn.add(bq);//,BorderLayout.NORTH);
		pbtn.add(ba);//,BorderLayout.SOUTH);
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(pshow,BorderLayout.CENTER);
		this.getContentPane().add(pbtn,BorderLayout.SOUTH);
		
		this.setTitle(this.exam.name);
		this.setSize(700,300);
		this.setDefaultCloseOperation(QAUI.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(400, 400);
		
	}
	
	public void actionPerformed(ActionEvent action) {
		// TODO Auto-generated method stub
		
		Object btn=action.getSource();
		if(btn.equals(this.bq)){
			this.qa=this.exam.rand();
			this.q=qa.getQestion();
			this.a=qa.getAwnser();
			this.Q.setText("题目："+this.q);
			this.A.setText("");
		}else if(btn.equals(this.ba)){
			if(this.key){
				this.A.setText("答案："+this.a);
				this.key=false;
			}else{
				this.A.setText("");
				this.key=true;
			}
			
		}
		
	}
}
