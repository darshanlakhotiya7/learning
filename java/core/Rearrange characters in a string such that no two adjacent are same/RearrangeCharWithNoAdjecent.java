import java.util.Scanner;

public class RearrangeCharWithNoAdjecent 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Enter the String :");
			String given_string=sc.next();
			given_string=given_string.toLowerCase();
			String result=RearrangeCharWithNoAdjecent.Check(given_string);
			System.out.println("OUTPUT :"+result);
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			sc.close();
		}
	}

	private static String Check(String given_string) 
	{
		int length=given_string.length();
		int next=1,prior=-1,cnt=0;
		char charr[]=given_string.toCharArray();
		char current=charr[0];
		while(next<length)
		{
			if(charr[next]!=current)
			{
				char temp=charr[prior];
				charr[prior]=charr[next];
				charr[next]=temp;
				cnt--;
				prior=prior+2;
				if(cnt==0)
				{
					prior=-1;
				}
				current=charr[next];
			}
			else
			{
				if(prior==-1)
				{
					prior=next;
				}
				cnt++;
			}
			next++;
		}
		if(cnt!=0)
		{
			return "Not Posible";
		}
		else
		{
			return new String(charr);
		}
	}
}
