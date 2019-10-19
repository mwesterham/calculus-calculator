package toolBox;

import java.util.Scanner;
//put all the operational methods in a different class called Formatting TOperate and TrigOperate

class Formatting
{
	public static String formatOriginal(String expression)
	{
		expression = expression.toUpperCase();
		expression = expression.replaceAll("\\s", "");//replace all spaces with empty
		expression = expression.replace("-", "+-");
		expression = expression.replace("T^+", "T^");
		expression = expression + "+";
		expression = expression.replace("T+", "T^1+");
		expression = "+" + expression;
		expression = expression.replace("+T", "+1T");
		expression = expression.replace("-T", "-1T");
		expression = expression.replace("(+-", "(-");
		expression = expression.replace("+COS", "+1COS");
		expression = expression.replace("-COS", "-1COS");
		expression = expression.replace("+SIN", "+1SIN");
		expression = expression.replace("-SIN", "-1SIN");
		expression = expression.replace("COS(T", "COS(1T");
		expression = expression.replace("SIN(T", "SIN(1T");
		return expression;
	}
	
	public static String formatDerivative(String expression)
	{
		expression = expression.toUpperCase();
		expression = expression.replaceAll("\\s", "");
		expression = expression.replace("+-", " - ");
		expression = expression.replace("+", " + ");
		expression = expression.replace("T^0.0", "");
		expression = expression.replace("T^1.0", "T");
		expression = expression.replace(".0", "");
		expression = expression.replace("1COS(1T)", "COS(T)");
		expression = expression.replace("1SIN(1T)", "SIN(T)");
		expression = expression.replace("+ -", "- ");
		expression = expression.toLowerCase();
		return expression;
	}
}

class TOperate
{
	public static int getTCounter(String expression)
	{
		int i = 0;
		int tcounter = 0;
		while (i < expression.length()-2)
		{
			String scant = expression.substring(i, i+2);
			if (scant.equals("T^"))
			{
				tcounter++;
			}
			i++;
		}
		return tcounter;
	}
	
	public static String[] getTCoe(String expression)
	{
		int i = 0;
		int tcounter = getTCounter(expression);
		String[] TCoe = new String[tcounter];
		int arraypos = 0;
		while (i < expression.length()-2)
		{//4823t^2
			String scant = expression.substring(i,i+2);
			int a = i;
			if (scant.equals("T^"))
			{
				int breaker = 1;
				while (breaker != 0)
				{
					String addedTCoe = expression.substring(i - 1, i);
					if (addedTCoe.equals("+"))
					{
						arraypos++;
						breaker = 0;
					}
					else if (addedTCoe.equals("-"))
					{
						TCoe[arraypos] = "-" + TCoe[arraypos];
						arraypos++;
						breaker = 0;
					}
					else
					{
						TCoe[arraypos] = addedTCoe + TCoe[arraypos];
						TCoe[arraypos] = TCoe[arraypos].replace("null", "");
						i--;
					}
				}
				breaker = 1;
			}
			i = ++a;
		}
		return TCoe;
	}
	
	public static String[] getTExp(String expression)
	{
		int i = 0;
		int tcounter = getTCounter(expression);
		String[] TExp = new String[tcounter];
		int arraypos = 0;
		while (i < expression.length()-2)
		{//4823t^2
			String scant = expression.substring(i,i+2);
			int a = i;
			if (scant.equals("T^"))
			{
				int breaker = 1;		
				while (breaker != 0)
				{
					String expressionplus = expression + "+";
					String addedTExp = expressionplus.substring(i + 2, i + 3);
					if (addedTExp.equals("+"))
					{
						arraypos++;
						breaker = 0;
					}
					else 
					{
						TExp[arraypos] = TExp[arraypos] + addedTExp;
						TExp[arraypos] = TExp[arraypos].replace("null", "");
						i++;
					}
				}
			}
			i = ++a;
		}
		return TExp;
	}
}

class TrigOperate
{
	public static int[] getTrigCounter(String expression)
	{
		int i = 0;
		int coscounter = 0;
		int sincounter = 0;
		int tancounter = 0;
		while (i < expression.length()-3)
		{
			String scan = expression.substring(i, i+4);
			if (scan.equals("COS("))
				coscounter++;
			else if (scan.equals("SIN("))
				sincounter++;
			else if (scan.equals("TAN("))
				tancounter++;
			i++;
		}
		int[] ans = new int[3];
			ans[0] = coscounter;
			ans[1] = sincounter;
			ans[2] = tancounter;
		return ans;
	}
	
	public static String[] getCosExpCoe(String expression)
	{
		int i = 0;
		int[] trigcounter = getTrigCounter(expression);
		String[] CosExpCoe = new String[trigcounter[0]];
		int arraypos = 0;
		while (i < (expression.length())-3)
		{
			String scancos = expression.substring(i,i+4);
			if (scancos.equals("COS("))
			{
				int breaker = 0; 
				while (breaker != 1)
				{
					String coschar = expression.substring(i + 4, i + 5);
					if (coschar.equals("T"))
					{	
						arraypos++;
						breaker = 1;
					}
					else
					{
						CosExpCoe[arraypos] = CosExpCoe[arraypos] + coschar;
						CosExpCoe[arraypos] = CosExpCoe[arraypos].replace("null", "");
					}
					i++;
				}
			}//Stores characters inside cosine in CosExpCoe[0]
			i++;
		}
		return CosExpCoe;			
	}
	
	public static String[] getCosCoe(String expression)
	{
		int i = 0;
		int[] trigcounter = getTrigCounter(expression);
		String[] CosCoe = new String[trigcounter[0]];
		int arraypos = 0;
		while (i < (expression.length())-3)
		{
			int a = i;
			String scan = expression.substring(i,i+4);
			if (scan.equals("COS("))
			{
				int breaker = 0; 
				while (breaker != 1)
				{
					String coschar = expression.substring(i - 1, i);
					if (coschar.equals("+"))
					{	
						arraypos++;
						breaker = 1;
					}
					else
					{
						CosCoe[arraypos] = coschar + CosCoe[arraypos] ;
						CosCoe[arraypos] = CosCoe[arraypos].replace("null", "");
					}
					i--;
				}
			}//Stores characters outside cosine in CosCoe[0]
			i = ++a;
		}
		return CosCoe;
	}
	
	public static String[] getSinExpCoe(String expression)
	{
		int i = 0;
		int[] trigcounter = getTrigCounter(expression);
		String[] SinExpCoe = new String[trigcounter[1]];
		int arraypos = 0;
		while (i < (expression.length())-3)
		{
			String scansin = expression.substring(i,i+4);
			if (scansin.equals("SIN("))
			{
				int breaker = 0; 
				while (breaker != 1)
				{
					String sinchar = expression.substring(i + 4, i + 5);
					if (sinchar.equals("T"))
					{	
						arraypos++;
						breaker = 1;
					}
					else
					{
						SinExpCoe[arraypos] = SinExpCoe[arraypos] + sinchar;
						SinExpCoe[arraypos] = SinExpCoe[arraypos].replace("null", "");
					}
					i++;
				}
			}//Stores characters inside sinine in SinExpCoe[0]
			i++;
		}
		return SinExpCoe;			
	}
	
	public static String[] getSinCoe(String expression)
	{
		int i = 0;
		int[] trigcounter = getTrigCounter(expression);
		String[] SinCoe = new String[trigcounter[1]];
		int arraypos = 0;
		while (i < (expression.length())-3)
		{
			int a = i;
			String scan = expression.substring(i,i+4);
			if (scan.equals("SIN("))
			{
				int breaker = 0; 
				while (breaker != 1)
				{
					String sinchar = expression.substring(i - 1, i);
					if (sinchar.equals("+"))
					{	
						arraypos++;
						breaker = 1;
					}
					else
					{
						SinCoe[arraypos] = sinchar + SinCoe[arraypos] ;
						SinCoe[arraypos] = SinCoe[arraypos].replace("null", "");
					}
					i--;
				}
			}//Stores characters outside sin in SinCoe[0]
			i = ++a;
		}
		return SinCoe;
	}
}
class Derivatives
{
	public static String[] getnewTCoe(String expression)
	{
		int counter = TOperate.getTCounter(expression);
		String[] TCoe = TOperate.getTCoe(expression);
		String[] TExp = TOperate.getTExp(expression);

		String[] newTCoe = new String[counter];
		for (int i = 0; i < counter; i++)
		{
			double currentintTCoe = Float.parseFloat(TCoe[i]);
			double currentintTExp = Float.parseFloat(TExp[i]);
			double intnewTCoe = currentintTCoe * currentintTExp;
			String newTCoeElement = Double.toString(intnewTCoe);
			newTCoe[i] = newTCoeElement;
		}
		return newTCoe;
	}
	
	public static String[] getnewTExp(String expression)
	{
		int counter = TOperate.getTCounter(expression);
		String[] TExp = TOperate.getTExp(expression);
		
		String[] newTExp = new String[counter];
		for (int i = 0; i < counter; i++)
		{
			double currentintTExp = Float.parseFloat(TExp[i]);
			double intnewTExp = currentintTExp - 1;
			String newTExpElement = Double.toString(intnewTExp);
			newTExp[i] = newTExpElement;
		}
		return newTExp;
	}
	
	public static String getTDerivative(String expression)
	{
		int counter = TOperate.getTCounter(expression);
		String[] newTCoe = getnewTCoe(expression);
		String[] newTExp = getnewTExp(expression);
		
		String dexpression = "";
		for (int i = 0; i < counter; i++)
		{
			dexpression = dexpression + newTCoe[i] + "T^" + newTExp[i] + "+";
		}
		dexpression = Formatting.formatDerivative(dexpression);
		return dexpression;
	}
	
	public static String[] getnewTrigCosCoe(String expression)
	{
		
		int[] counter = TrigOperate.getTrigCounter(expression);
		String[] TrigCosCoe = TrigOperate.getCosCoe(expression);
		String[] TrigCosExpCoe = TrigOperate.getCosExpCoe(expression);		

		String[] newTrigCosCoe = new String[counter[0]];
		for (int i = 0; i < counter[0]; i++)
		{
			double currentintTrigCosCoe = Float.parseFloat(TrigCosCoe[i]);
			double currentintTrigCosExpCoe = Float.parseFloat(TrigCosExpCoe[i]);
			double intnewTrigCosCoe = currentintTrigCosCoe * currentintTrigCosExpCoe * -1;
			String newTrigCosCoeElement = Double.toString(intnewTrigCosCoe);
			newTrigCosCoe[i] = newTrigCosCoeElement;
		}
		
		String[] ans = newTrigCosCoe;
		return ans;
	}
	
	public static String[] getnewTrigSinCoe(String expression)
	{
		
		int[] counter = TrigOperate.getTrigCounter(expression);
		String[] TrigSinCoe = TrigOperate.getSinCoe(expression);
		String[] TrigSinExpCoe = TrigOperate.getSinExpCoe(expression);
		
		String[] newTrigSinCoe = new String[counter[1]];
		for (int i = 0; i < counter[1]; i++)
		{
			double currentintTrigSinCoe = Float.parseFloat(TrigSinCoe[i]);
			double currentintTrigSinExpCoe = Float.parseFloat(TrigSinExpCoe[i]);
			double intnewTrigSinCoe = currentintTrigSinCoe * currentintTrigSinExpCoe;
			String newTrigSinCoeElement = Double.toString(intnewTrigSinCoe);
			newTrigSinCoe[i] = newTrigSinCoeElement;
		}
		
		String[] ans = newTrigSinCoe;
		return ans;
	}
	
	public static String getTrigCosDerivative(String expression)
	{
		int[] counter = TrigOperate.getTrigCounter(expression);
		String[] OriginalCosExpCoe = TrigOperate.getCosExpCoe(expression);
		String[] newTrigCosCoe = getnewTrigCosCoe(expression);

		String dexpression = "";
		for (int i = 0; i < counter[0]; i++)
		{
			dexpression = dexpression + newTrigCosCoe[i] + "SIN(" + OriginalCosExpCoe[i] + "T) + ";
		}

		dexpression = Formatting.formatDerivative(dexpression);
		return dexpression;
	}
	
	public static String getTrigSinDerivative(String expression)
	{
		int[] counter = TrigOperate.getTrigCounter(expression);
		String[] OriginalSinExpCoe = TrigOperate.getSinExpCoe(expression);
		String[] newTrigSinCoe = getnewTrigSinCoe(expression);
		
		String dexpression = "";
		for (int i = 0; i < counter[1]; i++)
		{
			dexpression = dexpression + newTrigSinCoe[i] + "COS(" + OriginalSinExpCoe[i] + "T) + ";
		}
		dexpression = Formatting.formatDerivative(dexpression);
		return dexpression;
	}
	
	public static String getDerivative(String expression)
	{
		expression = Formatting.formatOriginal(expression);
		
		int tcounter = TOperate.getTCounter(expression);
		int[] trigcounter = TrigOperate.getTrigCounter(expression);
		
		String dexpression = "";
		if (tcounter != 0)
			dexpression = dexpression + Derivatives.getTDerivative(expression);
		if (trigcounter[0] != 0)
			dexpression = dexpression + Derivatives.getTrigCosDerivative(expression);
		if (trigcounter[1] != 0)
			dexpression = dexpression + Derivatives.getTrigSinDerivative(expression);
		
		expression = Formatting.formatDerivative(dexpression);
		
		return expression;
	}
	
}

public class SimpleDerivatives 
{
	public static void main(String[] args)
	{//example expression: 12t^3 + 23cos(4t) - 45sin(-654t) - 432t^234 + 32cos(-56t) - sin(t) + t^2 - 67t^9
		Scanner in = new Scanner(System.in);
		while (0 == 0)
		{
			System.out.printf("Type expression in terms of t, %ntype quit to exit: %n");
			String expression = in.nextLine();				
			if (expression.equals("quit"))
			{
				System.out.printf("%nTerminated%n");
				break;
			}
			System.out.printf("%nDerivative: %n");
			System.out.printf(Derivatives.getDerivative(expression) + "0 %n%n");
			expression = Derivatives.getDerivative(expression);
		}
		
		//Debug.dispAll(expression);
	}
}

class Debug
{
	public static void dispAll(String expression)
	{
		Debug.dispRecordedT(expression);
		Debug.dispRecordedTrig(expression);
		Debug.dispErrCheck(expression);
	}
	
	public static void dispRecordedT(String expression)
	{
		int tcounter = TOperate.getTCounter(expression);
		String[] tcoe = TOperate.getTCoe(expression);
		String[] texp = TOperate.getTExp(expression);
		for (int pos = 0; pos < tcounter; pos++)
		{
			System.out.println("t" + (pos) + " exponent: " + texp[pos]);
			System.out.println("t" + (pos) + " coefficient: " + tcoe[pos]);
		}
	}
	
	public static void dispRecordedTrig(String expression) 
	{
		int[] trigcounter = TrigOperate.getTrigCounter(expression);
		String[] cosexpcoe = TrigOperate.getCosExpCoe(expression);
		String[] coscoe = TrigOperate.getCosCoe(expression);
		for (int pos = 0; pos < trigcounter[0]; pos++)
		{
			System.out.println("cos " + (pos) + " expression coefficient: " + cosexpcoe[pos]);
			System.out.println("cos " + (pos) + " coefficient: " + coscoe[pos]);
		}
		
		String[] sinexpcoe = TrigOperate.getSinExpCoe(expression);
		String[] sincoe = TrigOperate.getSinCoe(expression);
		for (int pos = 0; pos < trigcounter[1]; pos++)
		{
			System.out.println("sin " + (pos) + " expression coefficient: " + sinexpcoe[pos]);
			System.out.println("sin " + (pos) + " coefficient: " + sincoe[pos]);
		}
	}
	
	public static void dispErrCheck(String expression)
	{
		int tcounter = TOperate.getTCounter(expression);
		int[] trigcounter = TrigOperate.getTrigCounter(expression);
		if (TOperate.getTCounter(expression) == 0 && trigcounter[0] == 0 && trigcounter[1] == 0 && trigcounter[2] == 0)
		{
			System.out.printf("%nError: THE DEBUG CLASS IS BUGGED%n");
		}
	}
}
