import java.util.Scanner;
/*
 * Sort array after converting elements to their squares
 * Examples:

Input  : arr[] =  {-6, -3, -1, 2, 4, 5}
Output : 1, 4, 9, 16, 25, 36 

Input  : arr[] = {-5, -4, -2, 0, 1}
Output : 0, 1, 4, 16, 25

 */

public class Test 
{
	public static void main(String[] args) 
	{
		int number[],j=0;
		boolean flag=true,set=false;
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Enter the String :");
			String input=sc.next();
			int size=input.length();
			number=new int[size];
			for(int i=0;i<size;i++)
			{
				char ch=input.charAt(i);
				int no=Character.getNumericValue(ch);
				if(no==0||no==1||no==2||no==3||no==4||no==5||no==6||no==7||no==8||no==9||ch=='-')
				{
					if (ch == '-' || set == true) {
						if (no == 1 || no == 2 || no == 3 || no == 4 || no == 5
								|| no == 6 || no == 7 || no == 8 || no == 9
								|| no == 0) {
							number[j] = (-(no)*-(no));
							j++;
							set = false;
						} else {
							set = true;
						}
					} else {
						number[j] = no*no;
						j++;
					}
				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				AfterConvertingArray.Result(number,j);
			} else {
				System.out.println("Not possible");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			sc.close();
		}
	}
}
