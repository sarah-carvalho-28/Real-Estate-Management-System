import java.util.Scanner;
class Menu1 
{
	int choice;
	Modifiers m;
	static Scanner sc=new Scanner(System.in);
	Menu1()throws Exception
	{
		m=new Modifiers();
		do
		{
			m.printLine();
			m.println("Do you want to--");
			m.println("1.Buy");
			m.println("2.Rent");
			m.println("3.Add a property");
			m.println("4.Exit");
			m.printLine();
			m.print("Enter Your Choice:");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:new Buy();
						break;
				case 2:new Rent();
						break;
				case 3:new InsertProperty();
						break;
				case 4:System.exit(0);
						break;
				default: 
						m.println("No such choice is available!");
			}
		}while(choice>4);
		//m.print("asd");
	}
}