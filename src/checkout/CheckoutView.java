package checkout;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.Connect;
import homepage.HomepageController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class CheckoutView extends JFrame {
	
	private CheckoutController ControllerInternalRef;
	private static Connect DBConnection = new Connect();
	private HomepageController ContrHomepage;

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	
	private JButton PayNowButton, GoBackButton;
	private JLabel lblCheckout, lblCartContains, lblTotal;
	private DefaultTableModel CheckoutModel;
	private Object[] rowData = new Object[6];
	private static ArrayList<Integer> AllTheRows = new ArrayList<Integer>();
	private String query;

	
	public CheckoutView(CheckoutController controller) {
		this.setLocationRelativeTo(null);
		this.ControllerInternalRef = controller;
		setTitle("Checkout");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblCheckout = new JLabel("Checkout");
		lblCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckout.setFont(new Font("Arial", Font.PLAIN, 22));
		lblCheckout.setBounds(10, 10, 566, 45);
		panel.add(lblCheckout);
		
		lblCartContains = new JLabel("Cart:");
		lblCartContains.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCartContains.setBounds(10, 65, 466, 35);
		panel.add(lblCartContains);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 566, 216);
		panel.add(scrollPane);
		
		table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane.setViewportView(table);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		//ConvertArrayToTable();
		table.setModel(CheckoutModel);
		
		
		PayNowButton = new JButton("PAY NOW");
		PayNowButton.setFont(new Font("Arial", Font.PLAIN, 16));
		PayNowButton.setBounds(60, 428, 120, 50);
		panel.add(PayNowButton);
		PayNowButton.setActionCommand("PayNow");
		PayNowButton.addActionListener((ActionListener) ControllerInternalRef);
		
		GoBackButton = new JButton("GO BACK");
		GoBackButton.setFont(new Font("Arial", Font.PLAIN, 16));
		GoBackButton.setBounds(290, 428, 120, 50);
		panel.add(GoBackButton);
		GoBackButton.setActionCommand("GoBack");
		GoBackButton.addActionListener((ActionListener) ControllerInternalRef);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTotal.setBounds(50, 324, 466, 35);
		panel.add(lblTotal);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setBounds(50, 353, 466, 50);
		panel.add(textField);
		textField.setColumns(10);
	}
	
	/*private void ConvertArrayToTable() {
		
		AllTheRows = ContrHomepage.GetArray();
		System.out.println(AllTheRows);
		for(int i = 0; i < AllTheRows.size();i++) {
			int j = AllTheRows.get(i) + 1;
			
			query = "SELECT * FROM ultravision.titles WHERE IdTitles =  "+ j +";";
			System.out.println(query);
			rowData = DBConnection.ReturnCheckoutTable(query);
			CheckoutModel.insertRow(i, rowData);
		}
		
		
	}*/
}
