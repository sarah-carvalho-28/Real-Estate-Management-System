import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
public class AddAProperty extends Frame implements ActionListener,ItemListener
{
	Modifiers m;
	char choice;
	Scanner sc=new Scanner(System.in);
	TextField t[]=new TextField[14];
	Label fname,lname,bankac,prop_type,houseNum,bldg,strt,area,city,state,pinCode,bhk,floor,surfaceArea,cost;
	Label mandatory;
	Choice propType;
	CheckboxGroup option,furnished;
	Checkbox sell,rent,yes,no;
	Button submit,exit;
	Font f=new Font("Serif", Font.BOLD,25);
	public AddAProperty()
	{
		
		addWindowListener(new MyWindowListener(this));
		setLayout(new GridLayout(23,2,5,3));
		setFont(new Font("Serif", Font.ROMAN_BASELINE,20));
		for(int i=0;i<14;i++)
		{
			t[i]=new TextField(10);
		}
		
		fname=new Label("First Name:");
		lname=new Label("Last Name:");
		bankac=new Label("Bank Account Number:");
		prop_type=new Label("Property Type:");
		houseNum=new Label("House Number:");
		bldg=new Label("Building/House Name:");
		strt=new Label("Street Name:");
		area=new Label("Area:");
		city=new Label("City:");
		state=new Label("State:");
		pinCode=new Label("Pin Code:");
		bhk=new Label("BHKs:");
		floor=new Label("Floors:");
		surfaceArea=new Label("Surface Area:");
		cost=new Label("Cost:");
		propType=new Choice();
		propType.addItemListener(this);
		option=new CheckboxGroup();
		furnished=new CheckboxGroup();
		sell=new Checkbox("Sell",option,true);
		rent=new Checkbox("Rent",option,false);
		yes=new Checkbox("YES",furnished,false);
		no=new Checkbox("NO",furnished,true);
		submit=new Button("Submit");
		exit=new Button("EXIT");
		exit.setForeground(Color.red);
		mandatory=new Label("*All Fields are mandatory");
		mandatory.setForeground(Color.red);
		mandatory.setFont(new Font("Consolas",Font.ROMAN_BASELINE,10));
		//adding controls
		Label l1,l2;
		l1=new Label("Owner's Details");
		l1.setFont(new Font("Serif",Font.BOLD,25));
		//add(mandatory);
		//add(new Label(""));
		add(l1);
		add(mandatory);
		//add(new Label(""));
		add(fname);
		add(t[0]);
		add(lname);
		add(t[1]);
		add(bankac);
		add(t[2]);
		l2=new Label("Property Details");
		l2.setFont(f);
		add(l2);
		//add(mandatory);
		add(new Label(""));
		add(prop_type);
		propType.add("Flat");
		propType.add("House/Villa");
		propType.add("Plot");
		propType.add("Office Space");
		propType.add("Shop/Showroom");
		propType.add("Warehouse");
		add(propType);
		add(houseNum);
		add(t[3]);
		add(bldg);
		add(t[4]);
		add(strt);
		add(t[5]);
		add(area);
		add(t[6]);
		add(city);
		add(t[7]);
		add(state);
		add(t[8]);
		add(pinCode);
		add(t[9]);
		add(bhk);
		add(t[10]);
		add(floor);
		add(t[11]);
		add(surfaceArea);
		add(t[12]);
		add(cost);
		add(t[13]);
		add(new Label("Do you want to-"));
		add(new Label(""));
		add(sell);
		add(rent);
		add(new Label("Furnished-"));
		add(new Label(""));
		add(yes);
		add(no);
		add(submit);
		add(exit);
		//
		submit.addActionListener(this);
		exit.addActionListener(this);
		sell.addItemListener(this);
		rent.addItemListener(this);
		yes.addItemListener(this);
		no.addItemListener(this);
		setTitle("Form");
		setSize(450,1000);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Button b=(Button)ae.getSource();
		if(b==exit)
		{
			//setVisible(false);
			System.exit(0);
		}
		if(b==submit)
		{
			for(int i=0;i<14;i++)
			{
				if(t[i].getText().equals(""))
				{
					Label l4=new Label("*Please ensure all fields are filled!");
					l4.setForeground(Color.red);
					add(l4);
					setVisible(true);
					break;
					/*String str=null;
					Label l3;

					switch(i)
					{
						case 0: str=("Please enter your first name!");
								break;
						case 1:str=("Please enter your last name!");
								break;
						case 2:str=("Please enter your Account Number!");
								break;
						case 3:str=("Please enter your House Number!");
								break;
						case 4:str=("Please enter your Building name!");
								break;
						case 5:str=("Please enter your Street name!");
								break;
						case 6:str=("Please enter your area/locality!");
								break;
						case 7:str=("Please enter your City!");
								break;
						case 8:str=("Please enter your State!");
								break;
						case 9:str=("Please enter your Pin code!");
								break;
						case 10:str=("Please enter the surface area!");
								break;
						case 11:str=("Please enter the cost!");
								break;																																															
						default:add(new Label("Please do not leave any field empty!"));
							break;
					}
					l3=new Label(str);
					add(l3);*/
				}
				else
				{
					try
					{
					//setVisible(false);
					String s,frnhd;
							if(option.getSelectedCheckbox().getLabel().equals("Rent"))
								s="rent";
							else
								s="buy";
							if(furnished.getSelectedCheckbox().getLabel().equals("NO"))
								frnhd="NO";
							else
								frnhd="YES";
					/*new InsertProperty(s,
						t[0].getText(),
						t[1].getText(),
						t[2].getText(),
						propType.getSelectedItem(),
						t[3].getText(),
						t[4].getText(),
						t[5].getText(),
						t[6].getText(),
						t[7].getText(),
						t[8].getText(),
						t[9].getText(),
						Integer.parseInt(t[10].getText()),
						Integer.parseInt(t[11].getText()),
						frnhd,
						Float.parseFloat(t[12].getText()),
						Double.parseDouble(t[13].getText()));*/
					}catch(Exception e){add(new Label(e.toString()));}
					/*m.println("Form details-");
					m.printLine();
					m.println(fname.getText()+t[0].getText());
					m.println(lname.getText()+t[1].getText());
					m.println(bankac.getText()+t[2].getText());
					m.println(prop_type.getText()+propType.getSelectedItem());
					m.println(houseNum.getText()+t[3].getText());
					m.println(bldg.getText()+t[4].getText());
					m.println(strt.getText()+t[5].getText());
					m.println(area.getText()+t[6].getText());
					m.println(city.getText()+t[7].getText());
					m.println(state.getText()+t[8].getText());
					m.println(pinCode.getText()+t[9].getText());
					m.println(bhk.getText()+t[10].getText());
					m.println(floor.getText()+t[11].getText());	
					m.println(surfaceArea.getText()+t[12].getText());
					m.println(cost.getText()+t[13].getText());
					m.println("You want to-"+option.getSelectedCheckbox());
					m.println("Furnished:"+furnished.getSelectedCheckbox());
					m.printLine();
					m.println("Is the details correct?[Y/n]");
					choice=sc.next().charAt(0);
					if(choice=='n')
					{
						new AddAProperty();
					}
					else if(choice=='Y'|choice=='y')
					{*/

					setVisible(false);
				}
			}		
		}


	}
	public void itemStateChanged(ItemEvent ie) 
	{

	}
}
class MyWindowListener extends WindowAdapter
{
	AddAProperty a;
	MyWindowListener(AddAProperty a)
	{
		this.a=a;
	}
	public void windowClosing(WindowEvent we)
	{
		a.setVisible(false);
		a.dispose();
	}
}