
class Modifiers
{

	void cls()
	{
		int clear;
		for(clear=0;clear<60;clear++)
  		{
    		 System.out.println();
 		 }
	}
	void center()
	{
		int i;
		for(i=0;i<40;i++)
		{
			System.out.print(" ");
		}
	}
	void print(String s)
	{
		center();
		System.out.print(s);
	}
	void println(String s)
	{
		center();
		System.out.println(s);
	}
	void printLine()
	{
		for(int i=0;i<120;i++)
		{
			System.out.print("_");
		}
		System.out.println();
	}
	void printLine(char c)
	{
		for(int i=0;i<120;i++)
		{
			System.out.print(c);
		}
		System.out.println();
	}
	void printTLine()
	{
		System.out.print("+");
		for(int i=0;i<120-2;i++)
		{
			System.out.print("-");
		}

		System.out.println("+");
	}
}