package AgentForm;

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

import MyAgent.realestateagents;
import MyAgent.realestateagents;

//import UsersForm.Usersform;

public class Agentform implements ActionListener{

	JFrame frame;
	JLabel aid_lb=new JLabel("agentid");
	JLabel na_lb=new JLabel("name");
	//JLabel lname_lb=new JLabel("lastname");
	JLabel ph_lb=new JLabel(" phone");
	JLabel eml_lb=new JLabel("email");

	JTextField aid_txf=new JTextField();
	JTextField na_txf=new JTextField();
	//JTextField lname_txf=new JTextField();
	JTextField ph_txf=new JTextField();
	JTextField eml_txf=new JTextField();

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
	public Agentform() {
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
		frame.setTitle("AGENT FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.yellow);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		aid_lb.setBounds(10, 10, 130, 30);
		na_lb.setBounds(10, 50, 150, 30);
		//lname_lb.setBounds(10, 90, 150, 30);
		ph_lb.setBounds(10, 130, 100, 30);
		eml_lb.setBounds(10, 170, 100, 30);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		aid_txf.setBounds(200, 10, 170, 30);
		na_txf.setBounds(200, 50, 170, 30);
		//lname_txf.setBounds(200, 90, 170, 30);
		ph_txf.setBounds(200, 130, 170, 30);
		eml_txf.setBounds(200, 170, 170, 30);
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 300, 300, 300);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		aid_lb.setFont(font);
		na_lb.setFont(font);
		//lname_lb.setFont(font);
		ph_lb.setFont(font);
		eml_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		aid_txf.setFont(font);
		na_txf.setFont(font);
		//lname_txf.setFont(font);
		ph_txf.setFont(font);
		eml_txf.setFont(font);
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(aid_lb);
		frame.add(na_lb);
		//frame.add(lname_lb);
		frame.add(ph_lb);
		frame.add(eml_lb);
		
		frame.add(aid_txf);
		frame.add(na_txf);
		//frame.add(lname_txf);
		frame.add(ph_txf);
		frame.add(eml_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		realestateagents ag=new realestateagents();
		if(e.getSource()==insert_btn) {
			ag.setName(na_txf.getText());
			ag.setPhone(ph_txf.getText());
			ag.setEmail(eml_txf.getText());
			/*ag.setBranchID(Bid_txf.getText());
			ag.setTelephone(tel_txf.getText());
			ag.setEmail(eml_txf.getText());.insertData();*/
			ag.insertData();
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("agentid");
            model.addColumn("name");
            model.addColumn("phone");
            model.addColumn("email");
           /* model.addColumn("BranchID");
            model.addColumn("Telephone");
            model.addColumn("Email");*/
           
            ResultSet resultSet =realestateagents.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getInt(4)}):
                    
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(aid_txf.getText());
	    	ag.setName(na_txf.getText());
			ag.setPhone(ph_txf.getText());
			ag.setEmail(eml_txf.getText());
			/*ag.setBranchID(Bid_txf.getText());
			ag.setTelephone(tel_txf.getText());
			ag.setEmail(eml_txf.getText());*/
			
			ag.update(id);
	    }
	  else {
			int id=Integer.parseInt(aid_txf.getText());
			ag.delete(id);}

	  }		
		public static void main(String[] args) {
			Agentform af=new Agentform();
			System.out.println(af);
		
			
		}

	}
