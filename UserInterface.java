package toolBox;

import java.util.Scanner;

public class UserInterface 
{
	public static void promptSectionChoice()
	{
		System.out.println("----------------------------------");
		System.out.printf("10.7 %n10.6: Identifying Quadric Surfaces%n10.5 %n10.4: Cross Product %n10.3: Dot Product %n10.0: Simple Derivitives %n0: Quit %n");
		System.out.printf("----------------------------------%n%n");
		System.out.println("What section would you like to work on?");
	}
	
	public static void main(String[] args)
	{
		String breaker = "placeholder";
		while (!breaker.equals("0"))
		{
				promptSectionChoice();
			Scanner in = new Scanner(System.in);
			String Numsection = in.nextLine();
			System.out.println();
			if (Numsection.equals("0"))
			{
				break;
			}
			if (Numsection.equals("10.0"))
			{
				while (0 == 0)
				{
					System.out.printf("Type expression in terms of t, %ntype quit to exit: %n");
					String expression = in.nextLine();				
					if (expression.charAt(0) == 'q' || expression.charAt(0) == 'Q')
					{
						System.out.printf("%nTerminated%n");
						break;
					}
					System.out.printf("%nDerivative: %n");
					System.out.printf(Derivatives.getDerivative(expression) + "0 %n%n");
				}
			}
			
			if (Numsection.equals("10.3") || Numsection.equals("10.4"))
			{
				System.out.print("Vector u x-component: ");
				double input1 = in.nextDouble();
				System.out.print("Vector u y-component: ");
				double input2 = in.nextDouble();
				System.out.print("Vector u z-component: ");
				double input3 = in.nextDouble();
				System.out.print("Vector v x-component: ");
				double input4 = in.nextDouble();
				System.out.print("Vector v y-component: ");
				double input5 = in.nextDouble();
				System.out.print("Vector v z-component: ");
				double input6 = in.nextDouble();
				
				VectorCalculate TwoVectors = new VectorCalculate(input1, input2, input3, input4, input5, input6);
				TwoVectors.display();
				System.out.println();
			}
			
			if (Numsection.equals("10.6"))
			{
				QuadricSurfaceIdentify.execute();
				System.out.println();
			}
		}
		System.out.println("You have quit the program");
	}
}
