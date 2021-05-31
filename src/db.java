

import java.sql.*;  
//import headless
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.util.Scanner;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.InputMismatchException;

public class db extends JFrame{
 
 private static final long serialVersionUID = 1L;
 
 JTable table1 = new JTable();
 JTable table2 = new JTable();
 JTable table3 = new JTable();
 DefaultTableModel model = new DefaultTableModel();
 JScrollPane tableContainer1 = new JScrollPane(table1);
 JScrollPane tableContainer2 = new JScrollPane(table2);
 JScrollPane tableContainer3 = new JScrollPane(table3);
 
 
 JPanel jp = new JPanel();
 JPanel jp_insert = new JPanel();
 JPanel jp_view = new JPanel();
 JPanel jp_update = new JPanel();
 JPanel jp_delete = new JPanel();
 JButton insert = new JButton("Insert");
 JButton view = new JButton("View");
 JButton update = new JButton("Update");
 JButton delete = new JButton("Delete");
 JButton add = new JButton("Add");
 JButton edit = new JButton("Update");
 JButton destroy = new JButton("Delete");
 JButton back_insert = new JButton("Back");
 JButton back_view = new JButton("Back");
 JButton back_update = new JButton("Back");
 JButton back_delete = new JButton("Back");
 
 JLabel name = new JLabel("Name");
 JLabel price = new JLabel("Price");
 JLabel stock = new JLabel("Stock");
 JLabel price_edit = new JLabel("Price");
 JLabel stock_edit = new JLabel("Stock");
 JLabel id = new JLabel("ID");
 JLabel id_delete = new JLabel("ID");
 JLabel field_validation = new JLabel();
 JLabel intro = new JLabel("BobaCool");

 JTextField form_code = new JTextField();
 JTextField form_name = new JTextField();
 JTextField form_price = new JTextField();
 JTextField form_stock = new JTextField();
 JTextField update_price = new JTextField();
 JTextField update_stock = new JTextField();
 JTextField delete_id = new JTextField();
 
 private void emptyForm() {
	 form_name.setText(null);
	 form_price.setText(null);
	 form_stock.setText(null);
	 update_price.setText(null);
	 update_stock.setText(null);
	 delete_id.setText(null);
	 form_code.setText(null);
 }
 
 public void displayData()throws SQLException {
	 
	
	String dbURL = "jdbc:mysql://localhost:3306/bobacool";
	String username = "root";
	String password = "";
	Connection conn = DriverManager.getConnection(dbURL, username,password);
	 
	try {
 
 			String sql = "SELECT * From menu";
 			Statement state = conn.createStatement();
 			ResultSet result = state.executeQuery(sql);
    
 			while (result.next()){
 				model.addRow(new Object[] {result.getString(1), result.getString(2),result.getInt(3),result.getInt(4)});
 			}
	}catch(SQLException err) {
			System.out.println("ERROR: "+ err.getMessage());
 }
	 
 }
 
 db()throws SQLException{
	 
	 String dbURL = "jdbc:mysql://localhost:3306/bobacool";
	 String username = "root";
	 String password = "";
	 Connection conn = DriverManager.getConnection(dbURL, username,password);
		 
	 setTitle("BobaCool");
	 setSize(720, 720);
	 setLocationRelativeTo(null);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 setVisible(true);
	 setResizable(false);
	
	 getContentPane().add(jp);

	 model.addColumn("ID");
	 model.addColumn("Name");
	 model.addColumn("Price");
	 model.addColumn("Stock");
	 
	 table1.setModel(model);
	 table2.setModel(model);
	 table3.setModel(model);

	 jp_view.add(tableContainer1);
	 jp_update.add(tableContainer2);
	 jp_delete.add(tableContainer3);

	 jp.setLayout(new GridLayout(2,2));
	 jp.setSize(300, 500);
	 jp.setLocation(500,300);
	 jp.add(insert);
	 jp.add(view);
	 jp.add(update);
	 jp.add(delete);
	 
	 jp_insert.setLayout(new GridLayout(4,4));
	 jp_insert.add(name);
	 jp_insert.add(form_name);
	 jp_insert.add(price);
	 jp_insert.add(form_stock);
	 jp_insert.add(stock);
	 jp_insert.add(form_price);
	 jp_insert.add(add);
	 jp_insert.add(back_insert);
	 
	 jp_view.add(back_view);
	 
	 jp_update.add(id);
	 jp_update.add(form_code);
	 jp_update.add(price_edit);
	 jp_update.add(update_price);
	 jp_update.add(stock_edit);
	 jp_update.add(update_stock);
	 jp_update.add(edit);
	 jp_update.add(back_update);
	  
	 jp_delete.add(destroy);
	 jp_delete.add(back_delete);

	form_code.setEditable(false);
	delete_id.setEditable(false);
	delete_id.setPreferredSize(new Dimension(210,24));
	form_name.setPreferredSize(new Dimension(150,24));
	form_price.setPreferredSize(new Dimension(150,24));
	form_stock.setPreferredSize(new Dimension(150,24));
	add.setPreferredSize(new Dimension(130,24));
	

	 SpringLayout sl_jp_update = new SpringLayout();
	 sl_jp_update.putConstraint(SpringLayout.WEST, tableContainer2, 59, SpringLayout.WEST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.EAST, tableContainer2, -245, SpringLayout.EAST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.WEST, edit, 59, SpringLayout.WEST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.EAST, edit, -245, SpringLayout.EAST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.WEST, update_stock, 59, SpringLayout.WEST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.EAST, update_stock, -245, SpringLayout.EAST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.NORTH, edit, 27, SpringLayout.SOUTH, tableContainer2);
	 sl_jp_update.putConstraint(SpringLayout.SOUTH, edit, -40, SpringLayout.SOUTH, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.SOUTH, tableContainer2, -90, SpringLayout.SOUTH, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.NORTH, tableContainer2, 23, SpringLayout.SOUTH, update_stock);
	 sl_jp_update.putConstraint(SpringLayout.NORTH, update_stock, -4, SpringLayout.NORTH, stock_edit);
	 sl_jp_update.putConstraint(SpringLayout.EAST, stock_edit, -400, SpringLayout.EAST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.WEST, stock_edit, 12, SpringLayout.WEST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.NORTH, form_code, -4, SpringLayout.NORTH, id);
	 sl_jp_update.putConstraint(SpringLayout.WEST, form_code, 0, SpringLayout.WEST, update_price);
	 sl_jp_update.putConstraint(SpringLayout.SOUTH, form_code, 19, SpringLayout.NORTH, id);
	 sl_jp_update.putConstraint(SpringLayout.EAST, form_code, -245, SpringLayout.EAST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.WEST, update_price, 59, SpringLayout.WEST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.EAST, id, -418, SpringLayout.EAST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.EAST, update_price, -245, SpringLayout.EAST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.WEST, id, 12, SpringLayout.WEST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.WEST, price_edit, 12, SpringLayout.WEST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.EAST, price_edit, -15, SpringLayout.WEST, update_price);
	 sl_jp_update.putConstraint(SpringLayout.NORTH, update_price, -4, SpringLayout.NORTH, price_edit);
	 sl_jp_update.putConstraint(SpringLayout.NORTH, price_edit, 65, SpringLayout.NORTH, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.NORTH, stock_edit, 99, SpringLayout.NORTH, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.NORTH, id, 30, SpringLayout.NORTH, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.EAST, back_update, -19, SpringLayout.EAST, jp_update);
	 sl_jp_update.putConstraint(SpringLayout.NORTH, back_update, 10, SpringLayout.NORTH, jp_update);
	 jp_update.setLayout(sl_jp_update);
	  
	 insert.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	setContentPane(jp_insert);
	        	invalidate();
	        	validate();
	        }
	    });
	 
	 view.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	try {
					displayData();
				} catch (SQLException e1) {
					System.out.println("Error"+e1.getMessage());
				}
	        	
	        	setContentPane(jp_view);
	        	invalidate();
	        	validate();
	        }
	    });
	 

	 table2.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table2.rowAtPoint(evt.getPoint());
		        String code = table2.getValueAt(row, 0).toString();
		        form_code.setText(code);
		        
		        String price = table2.getValueAt(row, 2).toString();
		        update_price.setText(price);
		        
		        String stock = table2.getValueAt(row, 3).toString();
		        update_stock.setText(stock);
		    }
		});
	 
	 update.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        
	        	try {
					displayData();
				} catch (SQLException e1) {
					System.out.println("Error"+e1.getMessage());
				}
	        	setContentPane(jp_update);
	        	invalidate();
	        	validate();
	        }
	    });
	 

	 table3.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table3.rowAtPoint(evt.getPoint());
		        String code = table3.getValueAt(row, 0).toString();
		        delete_id.setText(code);
		    }
		});
	 
	 
	 delete.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	try {
					displayData();
				} catch (SQLException e1) {
					System.out.println("Error"+e1.getMessage());
				}
	        	setContentPane(jp_delete);
	        	invalidate();
	        	validate();
	        }
	    });
	 
	 
	 add.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	try {
	        		String code="BC-";
	        		Random r = new Random();
	        		for(int i=0; i<3; i++) {
	        			char num = (char)(r.nextInt(9) + '0');
	        			code += num;
	        		}
	        		
	        		String sql = "INSERT INTO menu (code,name, price,stock) VALUES (?,'"+form_name.getText()+"','"+form_price.getText()+"','"+form_stock.getText()+"')";
	        	    PreparedStatement statement = conn.prepareStatement(sql);
	        	    statement.setString(1, code);
	        	    
	        	    int rows = statement.executeUpdate();
	        	    
	        	    if(rows > 0){
	        	    	JOptionPane.showMessageDialog(null, "Success");
	        	    }
	        	    
	        	    setContentPane(jp);
		        	invalidate();
		        	validate();
		        	model.setRowCount(0);
	        	 
	        	}
	        	catch(HeadlessException | SQLException err) {
	        		JOptionPane.showMessageDialog(add, err.getMessage());
	        	}
	        	emptyForm();
	        	
	        }
	    });
	 
	 edit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	try {
	        		String sql = "UPDATE menu set price='"+update_price.getText()+"',stock='"+update_stock.getText()+"' where code= '"+form_code.getText()+"'";
	        		PreparedStatement statement = conn.prepareStatement(sql);
	        		int rows = statement.executeUpdate();
	        		JOptionPane.showMessageDialog(null, "Success");
	        		setContentPane(jp);
		        	invalidate();
		        	validate();
		        	model.setRowCount(0);
	        	}
	        	catch(HeadlessException | SQLException err) {
	        		JOptionPane.showMessageDialog(edit, err.getMessage());
	        	}
	        	emptyForm();
	        	
	        }
	    });
	 
	 destroy.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	try {
	        		String delete= "Delete from menu  where code= '"+delete_id.getText()+"'";
	        	    PreparedStatement statement = conn.prepareStatement(delete);
	        		int rows = statement.executeUpdate();
	        		JOptionPane.showMessageDialog(null, "Success");
	        		setContentPane(jp);
		        	invalidate();
		        	validate();
		        	model.setRowCount(0);
	        	}
	        	catch(HeadlessException | SQLException err) {
	        		JOptionPane.showMessageDialog(destroy, err.getMessage());
	        	}
	        	
	        	emptyForm();
	        	
	        }
	    });
	 
	 back_insert.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	try {
	        		setContentPane(jp);
		        	invalidate();
		        	validate();
		        	model.setRowCount(0);
	        	}
	        	catch(HeadlessException err) {
	        		JOptionPane.showMessageDialog(back_insert, err.getMessage());
	        	}
	        	
	        	emptyForm();
	        	
	        }
	    });
	 
	 back_view.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	try {
	        		setContentPane(jp);
		        	invalidate();
		        	validate();
		        	model.setRowCount(0);
	        	}
	        	catch(HeadlessException err) {
	        		JOptionPane.showMessageDialog(back_view, err.getMessage());
	        	}
	        	
	        	emptyForm();
	        	
	        }
	    });
	 
	 back_update.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	try {
	        		setContentPane(jp);
		        	invalidate();
		        	validate();
		        	model.setRowCount(0);
	        	}
	        	catch(HeadlessException err) {
	        		JOptionPane.showMessageDialog(back_update, err.getMessage());
	        	}
	        	
	        	emptyForm();
	        	
	        }
	    });
	 
	 back_delete.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	try {
	        		setContentPane(jp);
		        	invalidate();
		        	validate();
		        	model.setRowCount(0);
	        	}
	        	catch(HeadlessException err) {
	        		JOptionPane.showMessageDialog(back_delete, err.getMessage());
	        	}
	        	
	        	emptyForm();
	        	
	        }
	    });
	 //
	 
 }
 

 
 public static void main(String[] args) throws SQLException {    
  
	 new db();
	 
 }
 
}
