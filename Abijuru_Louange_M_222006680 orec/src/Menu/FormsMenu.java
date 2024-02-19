package Menu;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import AgentForm.Agentform;
import PaymentForm.Paymentform;
import PropertyForm.Propertyform;
import TransactionForm.Transactionform;
import UsersForm.Usersform;

public class FormsMenu extends JFrame implements ActionListener {
		JFrame frame;

		private static final long serialVersionUID = 1L;
		private JMenuBar menuBar;
	    private JMenu Usersmenu;
	    private JMenu realestateagentsmenu;
	    private JMenu Propertymenu;
	    private JMenu Transactionmenu;
	    private JMenu Paymentsmenu;
	    private JMenu Logoutmenu;
	    


		public FormsMenu() {
			// TODO Auto-generated constructor stub
		}
	    
	    private JMenuItem UsersItem;
	    private JMenuItem realestateagentsItem;
	    private JMenuItem PropertyItem;
	    private JMenuItem TransactionItem;
	    private JMenuItem PaymentsItem;
	    private JMenuItem logoutItem;
	    private String loggedInUser;
	    private boolean isSubscribed = false;

	    public FormsMenu(String username) {
	        this.loggedInUser = username;
	        setTitle("Dashboard");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Create menu bar
	        menuBar = new JMenuBar();

	        // Create home menu
	        Usersmenu = new JMenu("Users");
	        realestateagentsmenu = new JMenu("realestateagents");
	        Propertymenu= new JMenu("Property");
	        Transactionmenu = new JMenu("Transaction ");
	        Paymentsmenu = new JMenu("Payments");
	        Logoutmenu = new JMenu("Logout");
	        		

	        // Create menu items
	        menuBar.add(Usersmenu);
	        UsersItem = new JMenuItem("UsersForm");
	        UsersItem.addActionListener(this);
	        
	        menuBar.add(realestateagentsmenu);
	        realestateagentsItem = new JMenuItem("AgentForm");
	        realestateagentsItem.addActionListener(this);
	        
	        menuBar.add(Propertymenu);
	        PropertyItem = new JMenuItem("PropertyForm");
	        PropertyItem.addActionListener(this);
	        
	        menuBar.add(Transactionmenu);
	        TransactionItem = new JMenuItem("TransactionForm");
	        TransactionItem.addActionListener(this);
	        
	        menuBar.add(Paymentsmenu);
	        PaymentsItem = new JMenuItem("PaymentForm");
	        PaymentsItem.addActionListener(this);

	        menuBar.add(Logoutmenu);
	        logoutItem = new JMenuItem("Logout");
	        logoutItem.addActionListener(this);

	        // Add menu items to home menu
	        Usersmenu.add(UsersItem);
	        realestateagentsmenu.add(realestateagentsItem);
	        Propertymenu.add(PropertyItem);
	        Transactionmenu.add(TransactionItem);
	        Paymentsmenu.add(PaymentsItem);
	        Logoutmenu.addSeparator();
	        Logoutmenu.add(logoutItem);

	        // Add home menu to menu bar
	        // Set menu bar to frame
	        setJMenuBar(menuBar);

	        // Initialize dashboard panel with background image
	        JPanel dashboardPanel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                // Load the image
	                ImageIcon imageIcon = new ImageIcon("C:\\Users\\mahoro chany\\Desktop\\New folder\\Bluesky.jpg");
	                // Draw the image
	                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
	            }
	        };



	        // Initialize dashboard panel
	        JPanel dashboardPanel1 = new JPanel();
	        dashboardPanel1.setLayout(new BorderLayout());

	        // Add components to dashboard panel
	        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
	        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	        dashboardPanel1.add(titleLabel, BorderLayout.CENTER);

	        // Add dashboard panel to frame
	        add(dashboardPanel1);

	        setVisible(true);
	    }
	   @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == UsersItem) {
	            new Usersform();
	        
	        } else if (e.getSource() == realestateagentsItem) {
	            new Agentform();
	        
	        } else if (e.getSource() == PropertyItem) {
	            new Propertyform();
	       
	        } else if (e.getSource() == TransactionItem) {
	           new Transactionform();
	        
	        } else if (e.getSource() == PaymentsItem) {
	           new Paymentform();
	       
	        } else if (e.getSource() == logoutItem) {
	            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
	            if (choice == JOptionPane.YES_OPTION) {
	                dispose();
	            }
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new FormsMenu("TO PROJECT"));
	    }
	}






