package toolBox;

public class VectorCalculate 
{
	private double vecux;
	private double vecuy;
	private double vecuz;
	private double vecvx;
	private double vecvy;
	private double vecvz;
	
	private double[] magnitude;
	/*
	 * magnitude[0] = magnitude of u
	 * magnitude[1] = magnitude of u^2
	 * magnitude[2] = magnitude of v
	 * magnitude[3] = magnitude of v^2		
	 */
	
	private double[] dotproduct;
	/*
	 * dotproduct[0] = dotproduct of u and v
	 * dotproduct[1] = dotproduct of u and u
	 * dotproduct[2] = dotproduct of v and v
	 */
	
	private double[] coeproj;
	/*
	 * coeproj[0] = coefficient of the projection of u onto v
	 * coeproj[1] = magnitude of the projection of u onto v
	 * coeproj[2] = coefficient of the projection of v onto u
	 * coeproj[3] = magnitude of the projection of v onto u
	 */
	
	private double[] perpendicularproj;
	/*
	 * perpendicularproj[0] = The x-component value of the vector perpendicular to the projection of u onto v
	 * perpendicularproj[1] = The y-component value of the vector perpendicular to the projection of u onto v
	 * perpendicularproj[2] = The z-component value of the vector perpendicular to the projection of u onto v
	 * perpendicularproj[3] = The value of the magnitude of the perpendicular vector u onto v
	 * perpendicularproj[4] = The x-component value of the vector perpendicular to the projection of v onto u
	 * perpendicularproj[5] = The y-component value of the vector perpendicular to the projection of v onto u
	 * perpendicularproj[6] = The z-component value of the vector perpendicular to the projection of v onto u
	 * perpendicularproj[7] = The value of the magnitude of the perpendicular vector v onto u
	 */
	
	private double[] anglebetweenuv;
	/*
	 * anglebetweenuv[0] = The angle between vector u and vector v in radians
	 * anglebetweenuv[1] = The angle between vector u and vector v in degrees	
	 */
	
	private double[] crossproduct;
	/*
	 * crossproduct[0] = The x-component of the cross-product of the vector u to vector v
	 * crossproduct[1] = The y-component of the cross-product of the vector u to vector v
	 * crossproduct[2] = The z-component of the cross-product of the vector u to vector v
	 * crossproduct[3] = The magnitude of the cross-product of vector u to vector v
	 */
	
	
	/**
	 * Constructor that sets the values of 3 dimensional vectors as given
	 * @param vecux
	 * @param vecuy
	 * @param vecuz
	 * @param vecvx
	 * @param vecvy
	 * @param vecvz
	 */
	public VectorCalculate(double vecux, double vecuy, double vecuz, double vecvx, double vecvy, double vecvz)
	{
		this.vecux = vecux;
		this.vecuy = vecuy;
		this.vecuz = vecuz;
		this.vecvx = vecvx;
		this.vecvy = vecvy;
		this.vecvz = vecvz;
		this.magnitude = new double[4]; 
		this.dotproduct = new double[3];
		this.coeproj = new double[4];
		this.perpendicularproj = new double[8];
		this.anglebetweenuv = new double[2];
		this.crossproduct = new double[4];
	}
	
	/**
	 * Constructor that sets the values of 3 dimensional vectors to zero
	 * @param vecux
	 * @param vecuy
	 * @param vecuz
	 * @param vecvx
	 * @param vecvy
	 * @param vecvz
	 */
	public VectorCalculate()
	{
		this.vecux = 0;
		this.vecuy = 0;
		this.vecuz = 0;
		this.vecvx = 0;
		this.vecvy = 0;
		this.vecvz = 0;
		this.magnitude = new double[4]; 
		this.dotproduct = new double[3];
		this.coeproj = new double[4];
		this.perpendicularproj = new double[8];
		this.anglebetweenuv = new double[2];
		this.crossproduct = new double[4]; 
	}
	
	/**
	 * Accessor method that calculates magnitude
	 */
	public double[] getMagnitude()
	{
		double magnitudeu;
		double magnitudeusqrd;
		magnitudeu = Math.sqrt(Math.pow(vecux, 2) + Math.pow(vecuy, 2) + Math.pow(vecuz, 2));
		magnitudeusqrd = Math.pow(magnitudeu, 2);
		
		double magnitudev;
		double magnitudevsqrd;
		magnitudev = Math.sqrt(Math.pow(vecvx, 2) + Math.pow(vecvy, 2) + Math.pow(vecvz, 2));
		magnitudevsqrd = Math.pow(magnitudev, 2);
		
		
		magnitude[0] = magnitudeu;
		magnitude[1] = magnitudeusqrd;
		magnitude[2] = magnitudev;
		magnitude[3] = magnitudevsqrd;
		
		return magnitude;
	}
	
	/**
	 * Accessor method that calculates dotproducts
	 */
	public double[] getDotProduct()
	{	
		double dotproductuv;
		double dotproductuu;
		double dotproductvv;
		dotproductuv = (vecux*vecvx) + (vecuy*vecvy) + (vecuz*vecvz);
		dotproductuu = Math.pow(vecux, 2) + Math.pow(vecuy, 2) + Math.pow(vecuz, 2);
		dotproductvv = Math.pow(vecvx, 2) + Math.pow(vecvy, 2) + Math.pow(vecvz, 2);
		
		dotproduct[0] = dotproductuv;
		dotproduct[1] = dotproductuu;
		dotproduct[2] = dotproductvv;
		
		return dotproduct;
	}
	
	/**
	 * Accessor method that calculates the coefficients of projections
	 */
	public double[] getCoeProj()
	{
		double coeprojuONv;
		double magprojuONv;
		double coeprojvONu;
		double magprojvONu;
		
		coeprojuONv = dotproduct[0] / dotproduct[2]; //coeprojuONv = dotproductuv / dotproductvv;
		magprojuONv = coeprojuONv * magnitude[2];//magprojuONv = coeprojuONv * magnitudev;
		coeprojvONu = dotproduct[0] / dotproduct[1]; //coeprojvONu = dotproductuv / dotproductuu;
		magprojvONu = coeprojuONv * magnitude[0];//magprojvONu = coeprojvONu * magnitudeu;

		coeproj[0] = coeprojuONv;
		coeproj[1] = magprojuONv;
		coeproj[2] = coeprojvONu;
		coeproj[3] = magprojvONu;
		
		return coeproj;
	}
	
	/**
	 * Accessor method that calculates the perpendicular projections
	 */
	public double[] getPerpendicularProj()
	{
		double vecperpprojuONvx;
		double vecperpprojuONvy;
		double vecperpprojuONvz;
		double magvecperprojuv;
		vecperpprojuONvx = vecux - (coeproj[0] * vecvx);
		vecperpprojuONvy = vecuy - (coeproj[0] * vecvy);
		vecperpprojuONvz = vecuz - (coeproj[0] * vecvz);
		magvecperprojuv = Math.sqrt(Math.pow(vecperpprojuONvx, 2) + Math.pow(vecperpprojuONvy, 2) + Math.pow(vecperpprojuONvz, 2));
	
		double vecperpprojvONux;
		double vecperpprojvONuy;
		double vecperpprojvONuz;
		double magvecperprojvu;
		vecperpprojvONux = vecvx - (coeproj[2] * vecux);
		vecperpprojvONuy = vecvy - (coeproj[2] * vecuy);
		vecperpprojvONuz = vecvz - (coeproj[2] * vecuz);
		magvecperprojvu = Math.sqrt(Math.pow(vecperpprojvONux, 2) + Math.pow(vecperpprojvONuy, 2) + Math.pow(vecperpprojvONuz, 2));
		
		perpendicularproj[0] = vecperpprojuONvx;
		perpendicularproj[1] = vecperpprojuONvy;
		perpendicularproj[2] = vecperpprojuONvz;
		perpendicularproj[3] = magvecperprojuv;
		perpendicularproj[4] = vecperpprojvONux;
		perpendicularproj[5] = vecperpprojvONuy;
		perpendicularproj[6] = vecperpprojvONuz;
		perpendicularproj[7] = magvecperprojvu;
		
		return perpendicularproj;
	}
	
	/**
	 * Accessor method that calculates the angle between vectors u and v
	 */
	public double[] getAngleBetweenuv()
	{
		double anglebetweenuvrad;
		double anglebetweenuvdeg;
		anglebetweenuvrad = Math.acos(coeproj[0] / (magnitude[0] * magnitude[2] / magnitude[3]));
		anglebetweenuvdeg = anglebetweenuvrad * 180 / Math.PI;
	
		anglebetweenuv[0] = anglebetweenuvrad;
		anglebetweenuv[1] = anglebetweenuvdeg;
		
		return anglebetweenuv;
	}
	
	/**
	 * Accessor method that calculates the crossproduct between vector u to vector v
	 */
	public double[] getCrossProduct()
	{
		double crossuvx;
		double crossuvy;
		double crossuvz;
		crossuvx = vecuy * vecvz - vecuz * vecvy;
		crossuvy = -(vecux * vecvz - vecuz * vecvx);
		crossuvz = vecux * vecvy - vecuy * vecvx;
		
		double magcrossuTOv;
		magcrossuTOv = Math.sqrt(Math.pow(crossuvx, 2) + Math.pow(crossuvy, 2) + Math.pow(crossuvz, 2));
		
		crossproduct[0] = crossuvx;
		crossproduct[1] = crossuvy;
		crossproduct[2] = crossuvz;
		crossproduct[3] = magcrossuTOv;
		
		return crossproduct;
	}
	
	public void calculate()
	{
		getMagnitude();
		getDotProduct();
		getCoeProj();
		getPerpendicularProj();
		getAngleBetweenuv();
		getCrossProduct();
	}
	
	public void display()
	{
		calculate();
		System.out.println();
		System.out.print("Magnitude of vector u: ");
		System.out.printf("%8.4f %n", magnitude[0]);
		System.out.print("Magnitude of vector v: ");
		System.out.printf("%8.4f %n", magnitude[2]);
		
		System.out.print("Dot product of u and v: ");
		System.out.printf("%7.4f %n%n", dotproduct[0]);
		
		System.out.printf("Projection u onto v: ( %1.4f ) < %.2f, %.2f, %.2f > %n", coeproj[0], vecvx, vecvy, vecvz);
		System.out.printf("Magnitude of proj uONv:  %1.4f  %n", coeproj[1]);
		
		System.out.printf("Vec perpendicular to proj uONv: < %.4f, %.4f, %.4f > %n", perpendicularproj[0], perpendicularproj[1], perpendicularproj[2]);
		System.out.printf("Magnitude of perpendicular vec uONv:  %.4f %n%n", perpendicularproj[3]);
		
		System.out.printf("Projection v onto u: ( %1.4f ) < %.2f, %.2f, %.2f > %n", coeproj[2], vecux, vecuy, vecuz);
		System.out.printf("Magnitude of proj vONu:  %1.4f  %n", coeproj[3]);
		
		System.out.printf("Vec perpendicular to proj vONu: < %.4f, %.4f, %.4f > %n", perpendicularproj[4], perpendicularproj[5], perpendicularproj[6]);
		System.out.printf("Magnitude of perpendicular vec vONu:  %.4f %n%n", perpendicularproj[7]);
		
		System.out.printf("Angle between u and v in rad: %1.4f %n", anglebetweenuv[0]);
		System.out.printf("Angle between u and v in deg: %1.4f %n", anglebetweenuv[1]);
		
		System.out.printf("Cross product of u to v: < %.2f, %.2f, %.2f > %n", crossproduct[0], crossproduct[1], crossproduct[2]);
		System.out.printf("Magnitude of cross product: %.4f %n", crossproduct[3]);
		
		System.out.println();
		
		System.out.print("Dot product of u and u: ");
		System.out.printf("%7.4f %n", dotproduct[1]);
		System.out.print("Dot product of v and v: ");
		System.out.printf("%7.4f %n", dotproduct[2]);
		System.out.print("Magnitude of u squared: ");
		System.out.printf("%7.4f %n", magnitude[1]);
		System.out.print("Magnitude of v squared: ");
		System.out.printf("%7.4f %n", magnitude[3]);
	}
}
