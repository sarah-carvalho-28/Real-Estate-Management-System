import java.sql.*;
import java.util.Scanner;
class Menu2
{
	int choice;
	Modifiers m;
	DBConn db;
	PreparedStatement st;
	Statement stmt; 
	ResultSet rs;
	String table,tables;
	String fname,lname,addr,phone_no,email,aadhar_no;
	int prop_no;
	boolean b,r;
	static Scanner sc=new Scanner(System.in);
	Menu2(String t)throws Exception
	{
		table=t;
		b=table.equals("buy");
		r=table.equals("rent");
		db=new DBConn();
		stmt=db.con.createStatement();
		m=new Modifiers();
		m.printLine();
		m.print("Type the Property_No in which you are interested:");
		prop_no=sc.nextInt();
		m.printLine();
		String sql="SELECT Property_no,Property_Type,House_No,Building_Name,Street_Name,Area,City,State,Pin_Code,BHKs,Floors,Furnished,Surface_Area,Cost FROM "+table+" WHERE status='A' AND Property_no="+prop_no;
		rs=stmt.executeQuery(sql);
		System.out.println("Details of the property you selected--");
		DBTablePrinter.printResultSet(rs);
		//prop_no=rs.getInt(1);
		m.printLine();
		transaction();
	}
	void transaction()throws Exception
	{
		if(b)
			tables="buyers";
		else if(r)
			tables="renters";
		do{
			m.printLine('*');
			if(b)
				m.println("1.To purchase");
			else if(r)
				m.println("1.To rent");
			m.println("2.Previous Menu");
			m.println("3.Main menu");
			m.println("4.Exit");
			m.printLine('*');
			m.printLine();
			m.print("Enter your choice:");
			choice=sc.nextInt();
			m.printLine();
			switch(choice)
			{
				case 1:form();
						break;
				case 2:
						if(b)
							new Buy();
						else if(r)
							new Rent();
						break;
				case 3:new Menu1();
						break;
				case 4:System.exit(0);
						break;
				default:m.println("No such choice is available!");
			}
		}while(choice>4);
	}
	void form()throws Exception
	{
		m.printLine('*');
		m.println("Buyer's Details-");
		m.print("First Name:");
		fname=sc.next();
		m.print("Last Name:");
		lname=sc.next();
		sc.nextLine();
		m.print("Address:");
		addr=sc.nextLine();
		m.print("Phone Number:");
		phone_no=sc.next();
		m.print("Email:");
		email=sc.next();
		m.print("Aadhar Number:");
		aadhar_no=sc.next();
		String insert_qry="insert into "+tables+" (first_name,last_name,current_address,phone_no,email,aadhar_no,Property_no)values(?,?,?,?,?,?,?)";
		st=db.con.prepareStatement(insert_qry);
		st.setString(1,fname);
		st.setString(2,lname);
		st.setString(3,addr);
		st.setString(4,phone_no);
		st.setString(5,email);
		st.setString(6,aadhar_no);
		st.setInt(7,prop_no);
		int rows=st.executeUpdate();
		if(rows==1)
		{
			
			insert_qry="update "+table+" set status='UA' where Property_no=? AND status='A'";
			st=db.con.prepareStatement(insert_qry);
			st.setInt(1,prop_no);
			rows=st.executeUpdate();
			if(rows==1)
			{
				m.printLine('*');
				m.println("You have successfully brought the Property!");
				m.printLine('*');
				m.println("Do you want to-");
				m.println("1.Continue");
				m.println("2.Sign Out");
				m.printLine();
				m.print("Enter your choice:");
				choice=sc.nextInt();
				switch(choice)
				{
					case 1:
						break;
					case 2:m.printLine('$');
							m.println("Successfully Signed Out!");
							m.printLine('$');
						break;
				}

			}
			else
			{
				m.println("Property cannot be brought!");
			}
		}

	}
}