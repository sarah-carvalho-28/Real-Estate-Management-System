import java.sql.*;
import java.io.Console;
import java.util.Scanner;
class Login
{
	Modifiers m;
	Login()throws Exception
	{
		Scanner sc=new Scanner(System.in);
		m=new Modifiers();
		DBConn db=new DBConn();
		Statement stmt=db.con.createStatement(); 
		String ret_str;
		ResultSet rs;
		boolean l=false;
		boolean p=false;
	 	do
	 	{
			m.printLine();
			m.print("Enter Username:");
			String uname=sc.next();
			
					ret_str="SELECT * FROM login WHERE username='"+uname+"' ";
					rs=stmt.executeQuery(ret_str);
			while(rs.next())
			{
				if(uname.equals(rs.getString(1)))
				{
							l=true;
							break;
							//String s=sc.next();
							//m.cls();
				}
				
			}
			if(l)
			{

				do{
					Console console = System.console();
        			if (console == null) 
        			{
            			m.println("Couldn't get Console instance");
           			 	System.exit(0);
       				}
       				m.center();
        			char passwordArray[] = console.readPassword("Enter password: ");
					String pass = new String(passwordArray);
					ret_str="SELECT * FROM login WHERE username='"+uname+"'AND password='"+pass+"'";
					rs=stmt.executeQuery(ret_str);
					while(rs.next())
					{
						if(pass.equals(rs.getString(2)))
						{
							p=true;
							m.printLine();
							m.println("Successfully Logged In");
							m.printLine();
							m.center();
							String s=sc.next();
							m.cls();
							m.center();
							System.out.println("Welcome "+uname);
						}
					}
						if(!p)
						{
							m.println("Incorrect Password!!");
							m.println("Re-enter your password..");
						}
					
				}while(!p);
						
			}
			else
			{
				m.println("Please re-enter the correct username!");
			}			
			
			
		}while(!l);
		db.con.close();  
	}
}