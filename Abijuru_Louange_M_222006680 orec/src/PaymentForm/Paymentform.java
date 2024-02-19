package PaymentForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AgentForm.Agentform;
import MyAgent.Agent;
import MyPayments.Payments;

//import TransactionForm.Transactionform;

public class Paymentform implements ActionListener{
	
	JFrame frame;
	JLabel paid_lb=new JLabel("paymentsid");
	JLabel tid_lb=new JLabel("transactionid");
	JLabel dt_lb=new JLabel(" date");
	JLabel at_lb=new JLabel(" amount");
	JLabel mt_lb=new JLabel("  method");

	JTextField paid_txf=new JTextField();
	JTextField tid_txf=new JTextField();
	JTextField dt_txf=new JTextField();
	JTextField at_txf=new JTextField();
	JTextField mt_txf=new JTextField();

	//String []gender={"Male", "Female"};
	//JComboBox<String> genderBox = new JComboBox<>(gender);

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public Paymentform() {
		createForm();
		actionEvent();
		setFontforall();
		addComponentToFrame();
		setLocationandSize();
	}
	private void actionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("PAYMENT FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.pink);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		paid_lb.setBounds(10, 10, 130, 30);
		tid_lb.setBounds(10, 50, 150, 30);
		dt_lb.setBounds(10, 90, 150, 30);
		at_lb.setBounds(10, 130, 100, 30);
		mt_lb.setBounds(10, 170, 100, 30);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		paid_txf.setBounds(200, 10, 170, 30);
		tid_txf.setBounds(200, 50, 170, 30);
		dt_txf.setBounds(200, 90, 170, 30);
		at_txf.setBounds(200, 130, 170, 30);
		mt_txf.setBounds(200, 170, 170, 30);
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		paid_lb.setFont(font);
		tid_lb.setFont(font);
		dt_lb.setFont(font);
		at_lb.setFont(font);
		mt_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		paid_txf.setFont(font);
		tid_txf.setFont(font);
		dt_txf.setFont(font);
		at_txf.setFont(font);
		mt_txf.setFont(font);
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(paid_lb);
		frame.add(tid_lb);
		frame.add(dt_lb);
		frame.add(at_lb);
		frame.add(mt_lb);
		
		frame.add(paid_txf);
		frame.add(tid_txf);
		frame.add(dt_txf);
		frame.add(at_txf);
		frame.add(mt_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Payments pay=new Payments();
		if(e.getSource()==insert_btn) {
			pay.setTransactionid(tid_txf.getText());
			pay.setDate(dt_txf.getText());
			pay.setAmount(at_txf.getText());
			pay.setMethod(mt_txf.getText());
			/*ag.setTelephone(tel_txf.getText());
			ag.setEmail(eml_txf.getText());.insertData();*/
			pay.insertData();
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("paymentsid");
            model.addColumn("transactionid");
            model.addColumn("date");
            model.addColumn("amount");
            model.addColumn("method");
           /* model.addColumn("Telephone");
            model.addColumn("Email");*/
           
            ResultSet resultSet =Payments.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(paid_txf.getText());
	    	pay.setTransactionid(tid_txf.getText());
			pay.setDate(dt_txf.getText());
			pay.setAmount(at_txf.getText());
			pay.setMethod(mt_txf.getText());
			/*ag.setTelephone(tel_txf.getText());
			ag.setEmail(eml_txf.getText());*/
			
			pay.update(id);
	    }
	  else {
			int id=Integer.parseInt(paid_txf.getText());
			pay.delete(id);}

	  }		
		public static void main(String[] args) {
			Paymentform pf=new Paymentform();
			System.out.println(pf);
		
			
		}

	}


