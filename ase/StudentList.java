package ase;
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
    if(args.length == 0){
		System.out.println("Usage: java ase.StudentList (a|r|c|?word|+word)");
		return;
	}
//		Check arguments
		if(args[0].equals("a"))
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String contents = fileStream.readLine();
			String words[] = contents.split(",");
			for(String word : words) { System.out.println(word); }
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String contents = fileStream.readLine();
			System.out.println(contents);
			String words[] = contents.split(",");
			Random x = new Random();
				int y = x.nextInt();
					System.out.println(words[y]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+"))
		{
			System.out.println("Loading data ...");			
			try {
			BufferedWriter s = new BufferedWriter(
					new FileWriter("students.txt", true));
			String t = args[0].substring(1);
	        Date d = new Date();
	        String df = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(df);
	        String fd= dateFormat.format(d);
			s.write(", "+t+"\nList last updated on "+fd);
			s.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String contents = fileStream.readLine();
			String words[] = contents.split(",");
			boolean done = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<words.length && !done; idx++) {
				if(words[idx].equals(t)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String contents = fileStream.readLine();
			char a[] = contents.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char c:a) {
				if(c ==' ') 
				{
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " + a.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
	}
}