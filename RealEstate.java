import java.sql.*;
import java.util.*;
class RealEstate
{
	public static void main(String args[])throws Exception
	{
		Modifiers m=new Modifiers();
		try
		{
			Login l=new Login();
			new Menu1();
		}
		/*catch(NoSuchElementException e)
		{
			m.println("\n");
			m.printLine('!');
			m.println("Abruptly exited");
		}*/
		catch(SQLSyntaxErrorException e)
		{
			m.println("\n");
			m.printLine('!');
			m.println("Please check query properly!");
			m.printLine('!');	
		}
		catch(InputMismatchException e)
		{
			m.println("\n");
			m.printLine('!');
			m.println("Please insert values properly according to the field!");
			m.printLine('!');

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
} 