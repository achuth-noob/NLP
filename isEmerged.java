import java.util.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class isEmerged
{
	public static int getCount(String temp,String key)
	{
		String hello = temp; //String you want to 'examine'
		Pattern pattern = Pattern.compile(key); //Pattern string you want to be matched
		Matcher  matcher = pattern.matcher(hello);
		int count = 0;
		while (matcher.find())
		{
		    count++; //count any matched pattern
		}		
		return count;
	}

	public static void main(String[] args)
	{
		BufferedReader br = null;
		int countBihar =0;
	    int countPast = 0;

		try 
		{
			String CurrentLine;
			br = new BufferedReader(new FileReader("C:/Users/Kandikunnta Achuth/Desktop/NLP/Emerged_word/src/bihar.txt"));
			String temp="";
			int tmpcount=0;



			while ((CurrentLine = br.readLine()) != null) 
			{
				temp = CurrentLine;
				StringTokenizer tok = new StringTokenizer(temp, "'");
				String headline = tok.nextToken().nextToken();

				//--------------------------------------insert a keyword here.--------------------------
				
				tmpcount += getCount(headline,"-------keyword--------");
			}

			countBihar = tmpcount;
		}

		catch(Exception e)
		{
		
		}

		try 
		{
			String CurrentLine;
			br = new BufferedReader(new FileReader("C:/Users/Kandikunnta Achuth/Desktop/NLP/Emerged_word/src/past.txt"));
			//sCurrentLine = br.readLine();		
			String temp="";
			int tmpcount=0;

			while ((CurrentLine = br.readLine()) != null) 
			{
				temp = CurrentLine;
				StringTokenizer tok = new StringTokenizer(temp, "'");
				String headline = tok.nextToken().nextToken();

				//--------------------------------------insert the same keyword here.--------------------------
				
				tmpcount += getCount(temp,"-------keyword-----------");
			}

			countPast = tmpcount;
		}

		catch(Exception e)
		{
		
		}

		//System.out.println(countBihar);
		//System.out.println(countPast);

		if(countPast*10<countBihar)
		{
			System.out.println("Emerged in this event!!");
		}
		else
		{
			System.out.println("Not Emerged in this event!!");
		}

	}
}


























}