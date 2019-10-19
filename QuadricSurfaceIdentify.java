package toolBox;

import java.util.Scanner;

public class QuadricSurfaceIdentify 
{
	public static void execute()
	{
	Scanner in = new Scanner(System.in);	
	System.out.println("Please simplify your equation to this format: ");
	System.out.println("Ex. 2(x-2)^1 - 4(y+3)^2 + 2(z-3)^1 = 1");
	System.out.println("(Coeffiecient of x must be positive)");
	String answer = "placeholder";
	
	System.out.printf("%nHow many variables are squared? 0, 1, 2, or 3%n");
	String strinput1 = in.next();
	int input1 = Integer.valueOf(strinput1);//converts strinput1 to an integer
	int numVarSquared = 0;	
	switch (input1)//input1
	{
		case 0:
		{
			numVarSquared = 0;
			System.out.printf("%n# of coefficients = zero? 0, 1, 2, or 3%n");
			String strinput = in.next();
			if (strinput.contentEquals("0") || strinput.contentEquals("1"))
				answer = "a plane";
			else if (strinput.contentEquals("2"))
				answer = "a horizontal or vertical plane";
			else if (strinput.contentEquals("3"))
				System.out.printf("%nChief why");
			System.out.printf("%nThis quadric surface is %s", answer);
			System.exit(0);
			break;
		}
		case 1:
			numVarSquared = 1;
			break;
		case 2:
			numVarSquared = 2;
			break;
		case 3:
			numVarSquared = 3;
			break;
		default:
			System.out.printf("%nError: mispelling");
			System.exit(0);
			
	}
	System.out.printf("%nHow many coefficients are negative? 0, 1, or 2%n");
	String strinput2 = in.next();
	int input2 = Integer.valueOf(strinput2);
	int numOfNeg = 0;
	switch(input2)
	{
		case 0:
			numOfNeg = 0;
			break;
		case 1:
			numOfNeg = 1;
			break;
		case 2:
			numOfNeg = 2;
			break;
		default:
			System.out.printf("%nError: mispelling");
			System.exit(0);
	}
			
	switch (numVarSquared)//numVarSquared
	{
		case 1:
			if (numOfNeg == 0 || numOfNeg == 1)
				answer = "a parabola";
			else if (numOfNeg == 2)
			{
				System.out.printf("%nCannot have more than 1 negatives in a parabola");
				System.exit(0);
			}
			break;
		case 2:
		{
			if (numOfNeg == 1)
				answer = "an eliptic parabaloid";
			else if (numOfNeg == 2)
				answer = "a saddle/hyperbolic paraboloid";
			else if (numOfNeg == 0)
				answer = "an elliptic cyllinder";
			break;
		}
		case 3:
		{
			if (numOfNeg == 0)
			{
				System.out.printf("%nAre all coefficients equal to eachother? yes or no%n");
				String input3 = in.next();
				
				boolean coefEqual = false;
				if (input3.contentEquals("yes") || input3.contentEquals("y"))
					coefEqual = true;	
				else if (input3.contentEquals("no") || input3.contentEquals("n"))
					coefEqual = false;
				else
				{
					System.out.printf("%nError: mispelling");
					System.exit(0);
				}
				if (coefEqual)
					answer = "a sphere";
				else
					answer = "an ellipsoid";
			}
			else if (numOfNeg == 1)
			{
				System.out.printf("%nIs the right hand side zero? yes or no%n");
				String input4 = in.next();
				
				boolean rhsZero = false;
				if (input4.contentEquals("yes") || input4.contentEquals("y"))
					rhsZero = true;	
				else if (input4.contentEquals("no") || input4.contentEquals("n"))
					rhsZero = false;
				else
				{
					System.out.printf("%nError: mispelling");
					System.exit(0);
				}
				if (rhsZero)
					answer = "a cone";
				else
					answer = "a hyperboloid of one sheet";
			}
			else if (numOfNeg == 2)
			{
				System.out.printf("%nIs the right hand side zero? yes or no%n");
				String input5 = in.next();
				
				boolean rhsZero = false;
				if (input5.contentEquals("yes") || input5.contentEquals("y"))
					rhsZero = true;	
				else if (input5.contentEquals("no") || input5.contentEquals("n"))
					rhsZero = false;
				else
				{
					System.out.printf("%nError: mispelling");
					System.exit(0);
				}
				if (rhsZero)
					answer = "an elliptical cone";
				else
					answer = "a hyperboloid of two sheets";
			}
			break;
		}
	}
	System.out.printf("%nThis quadric surface is %s", answer);
	if (numVarSquared == 1 && (numOfNeg == 0 || numOfNeg == 1))
	{
		System.out.printf("%nassuming that one coefficient is zero.");
	}
}
}
