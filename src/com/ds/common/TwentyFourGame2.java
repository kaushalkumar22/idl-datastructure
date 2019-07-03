package com.ds.common;

class TwentyFourGame2 
{
	static double precision = 0.001;
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		double[] nums = new double[4];
		java.util.Random myR = new java.util.Random();

		for(int i=0; i<4;i++)
		{
			nums[i] = myR.nextInt(10)+1;
			System.out.print((int)nums[i]+ " ");
		}
		
		System.out.println();
		TwentyFourResult t1 = Solve24(nums);
		if(t1.success) System.out.println(t1.exp+" = 24");
		else System.out.println(t1.exp+" has no way reach 24");
	}

	public static TwentyFourResult Solve24(double[] nums)//size 4
	{
		TwentyFourResult t1 = new TwentyFourResult(false, "");
		//choose two number and compute
		for(int i=0; i<3;i++)
		{
			for(int j=i+1; j<4;j++)
			{
				double b = -1;
				double c = -1;
				for(int m=0; m<4;m++)
				{
					if(m!=i&&m!=j)
					{
						if(b==-1) b = nums[m];
						else c = nums[m];
					}
				}
				//a+b
				t1 = Solve24(nums[i]+nums[j], b, c, "("+(int)nums[i]+"+"+(int)nums[j]+")", (int)b+"", (int)c+"");//1-3 combo
				if(t1.success) return t1;
				t1 = Solve24(b, c, nums[i]+nums[j], (int)b+"", (int)c+"", "("+(int)nums[i]+"+"+(int)nums[j]+")");
				if(t1.success) return t1;

				//a-b
				t1 = Solve24(nums[i]-nums[j], b, c,  "("+(int)nums[i]+"-"+(int)nums[j]+")", (int)b+"", (int)c+"");//1-3 combo
				if(t1.success) return t1;
				t1 = Solve24(b, c, nums[i]-nums[j], (int)b+"", (int)c+"",  "("+(int)nums[i]+"-"+(int)nums[j]+")");
				if(t1.success) return t1;
				
				//b-a
				t1 = Solve24(nums[j]-nums[i], b, c,  "("+(int)nums[j]+"-"+(int)nums[i]+")", (int)b+"", (int)c+"");//1-3 combo
				if(t1.success) return t1;
				t1 = Solve24(b, c, nums[j]+nums[i], (int)b+"", (int)c+"",  "("+(int)nums[j]+"-"+(int)nums[i]+")");
				if(t1.success) return t1;
				
				//a*b
				t1 = Solve24(nums[i]*nums[j], b, c,  "("+(int)nums[i]+"*"+(int)nums[j]+")", (int)b+"", (int)c+"");//1-3 combo
				if(t1.success) return t1;
				t1 = Solve24(b, c, nums[i]*nums[j], (int)b+"", (int)c+"",  "("+(int)nums[i]+"*"+(int)nums[j]+")");
				if(t1.success) return t1;

				//a/b
				t1 = Solve24(nums[i]/nums[j], b, c,  "("+(int)nums[i]+"/"+(int)nums[j]+")", (int)b+"", (int)c+"");//1-3 combo
				if(t1.success) return t1;
				t1 = Solve24(b, c, nums[i]/nums[j], (int)b+"", (int)c+"",  "("+(int)nums[i]+"/"+(int)nums[j]+")");
				if(t1.success) return t1;
				
				//b/a
				t1 = Solve24(nums[j]/nums[i], b, c,  "("+(int)nums[j]+"/"+(int)nums[i]+")", (int)b+"", (int)c+"");//1-3 combo
				if(t1.success) return t1;
				t1 = Solve24(b, c, nums[j]/nums[i], (int)b+"", (int)c+"", "("+(int)nums[j]+"/"+(int)nums[i]+")");
				if(t1.success) return t1;
			}
		}
		return t1;
	}

	public static TwentyFourResult Solve24(double a, double b, double c, String expa, String expb, String expc)
	{
		TwentyFourResult t1 = Solve24(a+b, c, expa+"+"+expb, expc);
		if(t1.success) return t1;
		t1 = Solve24(a-b, c, expa+"-"+expb, expc);
		if(t1.success) return t1;
		t1 = Solve24(b-a, c, expb+"-"+expa, expc);
		if(t1.success) return t1;
		t1 = Solve24(a*b, c, expa+"*"+expb, expc);
		if(t1.success) return t1;
		t1 = Solve24(a/b, c, expa+"/"+expb, expc);
		if(t1.success) return t1;
		t1 = Solve24(b/a, c, expb+"/"+expa, expc);
		if(t1.success) return t1;
		return t1;
	}

	public static TwentyFourResult Solve24(double a, double b, String expa, String expb)
	{
		if(Math.abs(a+b-24)<precision) return new TwentyFourResult(true, "("+expa+")+"+"("+expb+")");
		if(Math.abs(a-b-24)<precision) return new TwentyFourResult(true, "("+expa+")-"+"("+expb+")");
		if(Math.abs(b-a-24)<precision) return new TwentyFourResult(true, "("+expb+")-"+"("+expa+")");
		if(Math.abs(a*b-24)<precision) return new TwentyFourResult(true, "("+expa+")*"+"("+expb+")");
		if(Math.abs(a/b-24)<precision) return new TwentyFourResult(true, "("+expa+")/"+"("+expb+")");
		if(Math.abs(b/a-24)<precision) return new TwentyFourResult(true, "("+expb+")/"+"("+expa+")");
		return new TwentyFourResult(false, "");
	}
}

class TwentyFourResult
{
	boolean success;
	String exp;
	public TwentyFourResult(boolean suc, String ex)
	{
		success = suc;
		exp = ex;
	}
}


/**
* Please watch at http://www.youtube.com/user/ProgrammingInterview
* Contact: haimenboy@gmail.com
*
* Step by step to crack programming interview questions.
* 1. All questions were searched publicly from Google, Glassdoor, Careercup and StackOverflow.
* 2. All codes were written from scratch and links to download the source files are provided in each video's description. All examples were written in java, and tools I have used include Editplus, Eclipse and IntelliJ.
* 3. All videos were made without using any non-authorized material. All videos are silent sorry. Text comment is provided during coding as additional explanations.
* Thank you very much. 
*/
