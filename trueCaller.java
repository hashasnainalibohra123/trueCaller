import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JTable.*;
import javax.swing.table.*;


public class trueCaller 
{
	JFrame jfrm;
	JPanel panel;
	JCheckBox ckb;
	//JTable jtab;
	JButton jbn,jbn1;
	JLabel jlab;
	JTextField jtx,jtx2,jtx3,jtx4,jtx5,jtx6,jtx7,jtx8,jtx9,jtx10,jtx11;
	DefaultTableModel model;
	String se;
	String name1;//=jtx.getText();
		
	final String colHeads[]={"ROLL NO","NAME","BRANCH","mobilr"};
		final String  col[][]={{"","","",""},{"","","",""}};
		 JTable jtab ;
		
  public static void main(String args[]) {
    
	SwingUtilities.invokeLater(
						new Runnable()
						{
							public void run()
							{
							trueCaller p=new trueCaller();
								p.create();
							}	
				        }	
						);

	
}	
	
	
  
  public void create()
  {
			jfrm  = new JFrame(" ............database ...........");
			jfrm.setSize(1600,1600);
			jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);
			jfrm.setVisible(true);	
			jfrm.setLayout(null);
				
			
			
			
		  	  panel = new JPanel();
			panel.setLayout(null);
			//jfrm.add(new JScrollPane(panel),BorderLayout.CENTER);
			panel.setBounds(0,0,1500,1500);
			JButton jbn=new JButton("Enter the name or phone No");
			jbn.setBounds(0,0,150,30);
			panel.add(jbn);
			
			ckb=new JCheckBox("phone no");
			ckb.setBounds(50,50,10,15);
			panel.add(ckb);
			//ckb=new JCheckBox("name");
			
			//panel.add(ckb);
			
			model= new DefaultTableModel(col,colHeads);
			jtab=new JTable(model);
			jtab.setBounds(500,50,1005,250);
		
			panel.add(jtab);
			
			jlab=new JLabel("Enter the name or phone No");
			jlab.setBounds(0,75,150,20);
			panel.add(jlab);
	
			
			jtx= new JTextField("      ");
			jtx.setBounds(0,150,200,30);
			panel.add(jtx);
			
			JScrollPane jsp=new JScrollPane(jtab);
			jsp.setBounds(250,550,800,50);
			panel.add(jsp);
			
						
						
			
			
			jfrm.add(panel);	
			jbn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e5)
					{
				
				
				
					try {
							Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							System.out.println("1");
							}
					catch (Exception e)
						{
							System.out.println("JDBC-ODBC driver failed to load.");
							return;
						}

					try {
								name1=jtx.getText();
									//Connection con = DriverManager.getConnection("jdbc:odbc:abbas", "", "");
								if(ckb.isSelected())
								{
									 se="select * from school where  mobile="+name1+";";
										//se1=se;
								}
								else
								{
									se="select * from school where name = '"+ name1+"';";
							
								}
						
						
						
						
						
						
						
						
						System.out.println("2");
							
 							Connection con = DriverManager.getConnection("jdbc:odbc:abbas", "", "");
							System.out.println(se);
							String s2,s3,s4,s1;
							Statement S=con.createStatement();
							ResultSet rs = S.executeQuery(se);

							while(rs.next())
							{						
								s1=" "+rs.getInt(1);
								System.out.println(s1);
								s2=rs.getString(2);
								s3=rs.getString(3);
								s4=" "+rs.getInt(4);
											jlab.setText(s2);
											model.insertRow(1,new String[]{s1,s2,s3,s4});
															
									}		

					
				con.close();
			}
	catch (Exception e) {
							System.out.println(e);
							}


 }
  
  
});
}//create()
}