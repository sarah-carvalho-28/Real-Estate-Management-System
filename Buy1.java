import java.sql.*;
import java.util.Scanner;

class Buy1
{
	int prop_no,bhks,floors;
	String sql;
	String prop_type,loc,Furnished;
	double lCost,uCost;
	int choice;
	Modifiers m;
	DBConn db=new DBConn();
	Statement stmt=db.con.createStatement(); 
	ResultSet rs;
	static Scanner sc=new Scanner(System.in);
	Buy1()throws Exception
	{
		m=new Modifiers();
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
			case 2:Location();
					break;
			case 3:Cost();
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
		db.con.close();
	}
	void listings()throws Exception
	{
		sql="SELECT Property_no,Property_type,Location,BHKs,Furnished,Surface_Area,Cost FROM buy WHERE status='A'";
		rs = stmt.executeQuery(sql);
		DBTablePrinter.printResultSet(rs);
	}
	void Location()throws Exception
	{
		m.print("Enter Location:");
		loc=sc.next();
		sql="SELECT Property_no,Property_type,Location,BHKs,Floors,Furnished,Surface_Area,Cost FROM buy WHERE status='A' AND Location='"+loc+"'";
		rs = stmt.executeQuery(sql);
		DBTablePrinter.printResultSet(rs);
	}
	void Cost()throws Exception
	{
		m.print("Enter lower limit of budget:");
		lCost=sc.nextDouble();
		m.print("Enter upper limit of budget:");
		uCost=sc.nextDouble();
		sql="SELECT Property_no,Property_type,Location,BHKs,Floors,Furnished,Surface_Area,Cost FROM buy WHERE status='A' AND (Cost BETWEEN "+lCost+" AND "+uCost+")";
		rs = stmt.executeQuery(sql);
		DBTablePrinter.printResultSet(rs);
	}
	void bhks()throws Exception
	{
		m.print("Enter the number of bedrooms you are looking for:");
		bhks=sc.nextInt();
		sql="SELECT Property_no,Property_type,Location,BHKs,Floors,Furnished,Surface_Area,Cost FROM buy WHERE status='A' AND BHKs="+bhks;
		rs=stmt.executeQuery(sql);
		DBTablePrinter.printResultSet(rs);
	}
	void floors()throws Exception
	{
		m.print("Enter the number of floors preferred:");
		floors=sc.nextInt();
		sql="SELECT Property_no,Property_type,Location,BHKs,Floors,Furnished,Surface_Area,Cost FROM buy WHERE status='A' AND Floors="+floors;
	}
}