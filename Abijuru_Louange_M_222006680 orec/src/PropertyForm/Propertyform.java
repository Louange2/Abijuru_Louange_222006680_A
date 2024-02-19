package PropertyForm;

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

import MyPayments.Payments;
import MyProperty.Property;
import PaymentForm.Paymentform;
import UsersForm.Usersform;

public class Propertyform implements ActionListener{
	
	
	JFrame frame;
	JLabel pid_lb=new JLabel("propertyid");
	JLabel add_lb=new JLabel("address");
	//JLabel lname_lb=new JLabel("lastname");
	JLabel ty_lb=new JLabel(".type");
	JLabel pry_lb=new JLabel("price");

	JTextField pid_txf=new JTextField();
	JTextField add_txf=new JTextField();
	//JTextField lname_txf=new JTextField();
	JTextField ty_txf=new JTextField();
	JTextField pry_txf=new JTextField();

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
	public Propertyform() {
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
		frame.setTitle("PROPERTY FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.gray);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		pid_lb.setBounds(10, 10, 130, 30);
		add_lb.setBounds(10, 50, 150, 30);
		//lname_lb.setBounds(10, 90, 150, 30);
		ty_lb.setBounds(10, 130, 100, 30);
		pry_lb.setBounds(10, 130, 100, 80);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		pid_txf.setBounds(200, 10, 170, 30);
		add_txf.setBounds(200, 50, 170, 30);
		//lname_txf.setBounds(200, 90, 170, 30);
		ty_txf.setBounds(200, 130, 170, 30);
		pry_txf.setBounds(200, 170, 170, 30);
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 100, 400, 200);

		
	  

		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		pid_lb.setFont(font);
		add_lb.setFont(font);
		//lname_lb.setFont(font);
		ty_lb.setFont(font);
		pry_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		pid_txf.setFont(font);
		add_txf.setFont(font);
		//lname_txf.setFont(font);
		ty_txf.setFont(font);
		pry_txf.setFont(font);
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(pid_lb);
		frame.add(add_lb);
		//frame.add(lname_lb);
		frame.add(ty_lb);
		frame.add(pry_lb);
		
		frame.add(pid_txf);
		frame.add(add_txf);
		//frame.add(lname_txf);
		frame.add(ty_txf);
		frame.add(pry_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Property pr=new Property();
		if(e.getSource()==insert_btn) {
			pr.setAddress(add_txf.getText());
			pr.setType(ty_txf.getText());
			pr.setPrice(pry_txf.getText());
			/*pr.setMethod(mt_txf.getText());
			ag.setTelephone(tel_txf.getText());
			ag.setEmail(eml_txf.getText());.insertData();*/
			pr.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("propertyid");
            model.addColumn("address");
            model.addColumn("type");
            model.addColumn("price");
           /* model.addColumn("method");
            model.addColumn("Telephone");
            model.addColumn("Email");*/
           
            ResultSet resultSet =Property.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(pid_txf.getText());
	    	pr.setAddress(add_txf.getText());
			pr.setType(ty_txf.getText());
			pr.setPrice(pry_txf.getText());
			/*pay.setMethod(mt_txf.getText());
			ag.setTelephone(tel_txf.getText());
			ag.setEmail(eml_txf.getText());*/
			
			pr.update(id);
	    }
	  else {
			int id=Integer.parseInt(pid_txf.getText());
			pr.delete(id);}

	  }		
		public static void main(String[] args) {
			Propertyform pif=new Propertyform();
			System.out.println(pif);
		
			
		}

	}


