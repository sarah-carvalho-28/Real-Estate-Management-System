import java.sql.*;
import java.util.Scanner;

class Buy
{
	int prop_no,bhks,floors;
	String sql;
	String prop_type,loc;
	double lCost,uCost;
	int choice;
	Modifiers m;
	DBConn db;
	Statement stmt; 
	ResultSet rs;
	static Scanner sc=new Scanner(System.in);
	Buy()throws Exception
	{
		db=new DBConn();
		stmt=db.con.createStatement();
		m=new Modifiers();
		do{
			m.printLine();
			m.println("Display--");
			m.println("1.All Listings");
			m.println("2.According to Location");
			m.println("3.According to Cost");
			m.println("4.No. of bedrooms");
			m.println("5.No. of floors");
			m.println("6.Previous menu");
			m.println("7.Exit");
			m.printLine();
			m.print("Enter Your Choice:");
			choice=sc.nextInt();		
			m.printLine();
			switch(choice)
			{
				case 1:listings();
						break;
				case 2:location();
						break;
				case 3:cost();
						break;
				case 4:bhks();
						break;
				case 5:floors();
						break;
				case 6:new Menu1();
						break;		
				case 7:System.exit(0);
						break;
				default: 
						m.println("No such choice is available!");
			}
		}while(choice>7);
		select();
		db.con.close();
	}
	void listings()throws Exception
	{
		sql="SELECT Property_no,Property_Type,House_No,Building_Name,Street_Name,Area,City,State,Pin_Code,BHKs,Floors,Furnished,Surface_Area,Cost FROM buy WHERE status='A'";
		rs = stmt.executeQuery(sql);
		DBTablePrinter.printResultSet(rs);
	}
	void location()throws Exception
	{
		m.print("Enter Location:");
		loc=sc.nextLine();
		sql="SELECT Property_no,Property_Type,House_No,Building_Name,Street_Name,Area,City,State,Pin_Code,BHKs,Floors,Furnished,Surface_Area,Cost FROM buy WHERE status='A' AND Area='"+loc+"'";
		rs = stmt.executeQuery(sql);
		DBTablePrinter.printResultSet(rs);
	}
	void cost()throws Exception
	{
		m.print("Enter lower limit of budget:");
		lCost=sc.nextDouble();
		m.print("Enter upper limit of budget:");
		uCost=sc.nextDouble();
		sql="SELECT Property_no,Property_Type,House_No,Building_Name,Street_Name,Area,City,State,Pin_Code,BHKs,Floors,Furnished,Surface_Area,Cost FROM buy WHERE status='A' AND (Cost BETWEEN "+lCost+" AND "+uCost+")";
		rs = stmt.executeQuery(sql);
		DBTablePrinter.printResultSet(rs);
	}
	void bhks()throws Exception
	{
		m.print("Enter the number of bedrooms you are looking for:");
		bhks=sc.nextInt();
		sql="SELECT Property_no,Property_Type,House_No,Building_Name,Street_Name,Area,City,State,Pin_Code,BHKs,Floors,Furnished,Surface_Area,Cost FROM buy WHERE status='A' AND BHKs="+bhks;
		rs=stmt.executeQuery(sql);
		DBTablePrinter.printResultSet(rs);
	}
	void floors()throws Exception
	{
		m.print("Enter the number of floors preferred:");
		floors=sc.nextInt();
		sql="SELECT Property_no,Property_Type,House_No,Building_Name,Street_Name,Area,City,State,Pin_Code,BHKs,Floors,Furnished,Surface_Area,Cost FROM buy WHERE status='A' AND Floors="+floors;
		rs=stmt.executeQuery(sql);
		DBTablePrinter.printResultSet(rs);
	}
	void select()throws Exception
	{
		m.printLine();
		m.println("1.Continue");
		m.println("2.Go back");
		m.println("3.Exit");
		m.printLine();
		m.print("Enter your choice:");
		choice=sc.nextInt();
		switch(choice)
		{
			case 1:new Menu2("buy");
					break;
			case 2:new Buy();
					break;
			case 3:System.exit(0);
					break;
		}
	}
}