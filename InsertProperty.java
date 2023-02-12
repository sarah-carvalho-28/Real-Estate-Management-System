import java.sql.*;
import java.util.Scanner;
class InsertProperty
{
	DBConn db;
	Statement st;
	PreparedStatement stmt;
	String insert_qry;
	int oid=0;
	int rows;
	Modifiers m;
	Scanner sc=new Scanner(System.in);
	char choice;
	String fname,lname,bankac,prop_type,houseNum,bldg,strt,area,city,state,pinCode,frnhd,table;
	float surfaceArea;
	double cost;
	int bhk,floor;
	InsertProperty()throws Exception
	{
		db=new DBConn();
		st=db.con.createStatement();
		m=new Modifiers();
		m.printLine();
		m.print("Are you a existing owner?[Y/n]");
		char o=sc.next().charAt(0);
		m.printLine();
		m.printLine('*');
		if(o=='Y'|o=='y')
		{
			m.println("Enter your-");
			m.print("First Name:");
			fname=sc.next();
			m.print("Last Name:");
			lname=sc.next();
			m.print("Bank Account Number:");
			bankac=sc.next();
		}
		else
		{ 
			m.println("Owner's Details-");
			m.print("First Name:");
			fname=sc.next();
			m.print("Last Name:");
			lname=sc.next();
			m.print("Bank Account Number:");
			bankac=sc.next();
			insert_qry="insert into owners (first_name,last_name,bank_acc_no) value (?,?,?)";
			stmt=db.con.prepareStatement(insert_qry);
			stmt.setString(1,fname);
			stmt.setString(2,lname);
			stmt.setString(3,bankac);
			rows=stmt.executeUpdate();
		}
		String sql="Select owners_id from owners where first_name='"+fname+"' AND last_name='"+lname+"' AND bank_acc_no='"+bankac+"'";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
			oid=rs.getInt(1);
		//m.println("No.of rows inserted="+rows);	
		//m.print(insert_qry)
		//Property Form
		m.printLine('*');
		m.printLine();
		m.println("Property Types-");
		m.println("1.Flat");
		m.println("2.House");
		m.println("3.Plot");
		m.println("4.Office Space");
		m.println("5.Shop/Showroom");
		m.println("6.Warehouse");
		m.printLine();
		m.printLine('*');
		m.println("Property Details-");
		m.print("Property Type:");
		int pt=sc.nextInt();
		switch(pt)
		{
			case 1:prop_type="Flat";
				break;
			case 2:prop_type="House";
				break;
			case 3:prop_type="Plot";
				break;
			case 4:prop_type="Office Space";
				break;
			case 5:prop_type="Shop/Showroom";
				break;
			case 6:prop_type="Warehouse";
				break;
			default:prop_type="Flat";
		}
		m.print("House Number:");
		houseNum=sc.next();
		m.print("Building/House Name:");
		bldg=sc.next();
		sc.nextLine();
		m.print("Street Name:");
		strt=sc.next();
		m.print("Area:");
		area=sc.nextLine();
		m.print("City:");
		city=sc.next();
		m.print("State:");
		state=sc.next();
		m.print("Pin Code:");
		pinCode=sc.next();
		m.print("BHKs:");
		bhk=sc.nextInt();
		m.print("Furnished:[Y/n]");
		char f=sc.next().charAt(0);
		if(f=='Y'|f=='y')
			frnhd="YES";
		else 
			frnhd="NO";
		m.print("Do you want to-1.Sell/2.Rent:");
		int i=sc.nextInt();
		if(i==2)
			table="rent";
		else
			table="buy";
		
		m.print("Floors:");
		floor=sc.nextInt();
		m.print("Surface Area:");
		surfaceArea=sc.nextFloat();
		m.print("Cost:");
		cost=sc.nextDouble();
		m.printLine('*');
		m.printLine();
		insert_qry="insert into "+table +" (Property_Type,House_No,Building_Name,Street_Name,Area,City,State,Pin_Code,BHKs,Floors,Furnished,Surface_Area,Cost,owners_id)"+
		"value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		stmt=db.con.prepareStatement(insert_qry);
		stmt.setString(1,prop_type);
		stmt.setString(2,houseNum);
		stmt.setString(3,bldg);
		stmt.setString(4,strt);
		stmt.setString(5,area);
		stmt.setString(6,city);
		stmt.setString(7,state);
		stmt.setString(8,pinCode);
		stmt.setInt(9,bhk);
		stmt.setInt(10,floor);
		stmt.setString(11,frnhd);
		stmt.setFloat(12,surfaceArea);
		stmt.setDouble(13,cost);
		stmt.setInt(14,oid);
		try
		{
		rows=stmt.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			m.printLine('*');
			m.println("Such a Property Type does not exist");
			m.printLine('*');
		}
		if(rows==1)
		m.println("Property Added successfully!");		
	}
	InsertProperty(String table,String fname,String lname,String bankac,String prop_type,String houseNum,String bldg,String strt,String area,String city,String state,String pinCode,int bhk,int floor,String frnhd,float surfaceArea,double cost)
	{
		try{
				db=new DBConn();
				st=db.con.createStatement();
				m=new Modifiers();
				m.println("Form details-");
					m.printLine();
					m.println(fname);
					m.println(lname);
					m.println(bankac);
					m.println(prop_type);
					m.println(houseNum);
					m.println(bldg);
					m.println(strt);
					m.println(area);
					m.println(city);
					m.println(state);
					m.println(pinCode);
					m.println(""+bhk);
					m.println(""+floor);	
					m.println(""+surfaceArea);
					m.println(""+cost);
					m.println(frnhd);
					m.println(table);
					m.printLine();
					m.println("Is the details correct?[Y/n]");
					choice=sc.next().charAt(0);
					if(choice=='n')
					{
						new AddAProperty();
					}
					else if(choice=='Y'|choice=='y')
					{
						insert_qry="insert into owners (first_name,last_name,bank_acc_no) value (?,?,?)";
						stmt=db.con.prepareStatement(insert_qry);
						stmt.setString(1,fname);
						stmt.setString(2,lname);
						stmt.setString(3,bankac);
						int rows=stmt.executeUpdate();
						m.println("No.of rows inserted="+rows);
						Statement st=db.con.createStatement();
						String sql="Select owners_id from owners where first_name='"+fname+"' AND last_name='"+lname+"' AND bank_acc_no='"+bankac+"'";
						ResultSet rs=st.executeQuery(sql);
						int oid=0;
						while(rs.next())
						oid=rs.getInt(1);
						if(rows>0)
						{
							insert_qry="insert into "+table +" (Property_Type,House_No,Building_Name,Street_Name,Area,City,State,Pin_Code,BHKs,Floors,Furnished,Surface_Area,Cost,owners_id)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
							stmt=db.con.prepareStatement(insert_qry);
							stmt.setString(1,prop_type);
							stmt.setString(2,houseNum);
							stmt.setString(3,bldg);
							stmt.setString(4,strt);
							stmt.setString(5,area);
							stmt.setString(6,city);
							stmt.setString(7,state);
							stmt.setString(8,pinCode);
							stmt.setInt(9,bhk);
							stmt.setInt(10,floor);
							stmt.setString(11,frnhd);
							stmt.setFloat(12,surfaceArea);
							stmt.setDouble(13,cost);
							stmt.setInt(14,oid);
						}
					}
			}catch(Exception e){m.println(""+e);
								}
	}
}
