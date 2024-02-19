package TransactionForm;

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

import MyProperty.Property;
import MyTransaction.Transaction;
import PaymentForm.Paymentform;

//import UsersForm.Usersform;

public class Transactionform implements ActionListener{
	
	JFrame frame;
	JLabel tid_lb=new JLabel("transactionid");
	JLabel uid_lb=new JLabel("userid");
	JLabel pid_lb=new JLabel("propertyid");
	JLabel dt_lb=new JLabel("date");
	JLabel am_lb=new JLabel(" amount");

	JTextField tid_txf=new JTextField();
	JTextField uid_txf=new JTextField();
	JTextField pid_txf=new JTextField();
	JTextField dt_txf=new JTextField();
	JTextField am_txf=new JTextField();

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
	public Transactionform() {
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
		frame.setTitle("TRANSACTION FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.pink);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		tid_lb.setBounds(10, 10, 130, 30);
		uid_lb.setBounds(10, 50, 150, 30);
		pid_lb.setBounds(10, 90, 150, 30);
		dt_lb.setBounds(10, 130, 100, 30);
		am_lb.setBounds(10, 170, 100, 30);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		tid_txf.setBounds(200, 10, 170, 30);
		uid_txf.setBounds(200, 50, 170, 30);
		pid_txf.setBounds(200, 90, 170, 30);
		dt_txf.setBounds(200, 130, 170, 30);
		am_txf.setBounds(200, 170, 170, 30);
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 100, 600, 300);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		tid_lb.setFont(font);
		uid_lb.setFont(font);
		pid_lb.setFont(font);
		dt_lb.setFont(font);
		am_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		tid_txf.setFont(font);
		uid_txf.setFont(font);
		pid_txf.setFont(font);
		dt_txf.setFont(font);
		am_txf.setFont(font);
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(tid_lb);
		frame.add(uid_lb);
		frame.add(pid_lb);
		frame.add(dt_lb);
		frame.add(am_lb);
		
		frame.add(tid_txf);
		frame.add(uid_txf);
		frame.add(pid_txf);
		frame.add(dt_txf);
		frame.add(am_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Transaction tr=new Transaction();
		if(e.getSource()==insert_btn) {
			tr.setUserid(uid_txf.getText());
			tr.setPropertyid(pid_txf.getText());
			tr.setDate(dt_txf.getText());
			tr.setAmount(am_txf.getText());
			/*ag.setTelephone(tel_txf.getText());
			ag.setEmail(eml_txf.getText());*/
			tr.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("transactionid");
            model.addColumn("userid");
            model.addColumn("propertid");
            model.addColumn("date");
            model.addColumn("method");
           /* model.addColumn("Telephone");
            model.addColumn("Email");*/
           
            ResultSet resultSet =Transaction.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(pid_txf.getText());
	    	tr.setUserid(uid_txf.getText());
			tr.setPropertyid(pid_txf.getText());
			tr.setDate(dt_txf.getText());
			tr.setAmount(am_txf.getText());
			/*ag.setTelephone(tel_txf.getText());
			ag.setEmail(eml_txf.getText());*/
			
			tr.update(id);
	    }
	  else {
			int id=Integer.parseInt(tid_txf.getText());
			tr.delete(id);}

	  }		
		public static void main(String[] args) {
			Transactionform tf=new Transactionform();
			System.out.println(tf);
		
			
		}

	}


