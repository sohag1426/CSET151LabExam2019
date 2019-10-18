package ase;
import java.io.*;
import java.text.*;
import java.util.*;
import static  ase.Constants.*;
public class StudentList {

	public  static String LoadData(){
		System.out.println(StartDialog);
		String contents = null;
		try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(DataFile)));
			 contents = fileStream.readLine();
		} catch (Exception e){

		}
		return  contents;
	}

	public  static  void  WirteData(String[] args){
		System.out.println(StartDialog);
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

		System.out.println(EndDialog);
	}

	public static void main(String[] args) {
    if(args.length == 0){
		System.out.println(Usage);
		return;
	}
//		Check arguments
		if(args[0].equals("a"))
		{
			String contents = LoadData();
			String words[] = contents.split(",");
			for(String word : words) { System.out.println(word); }
			System.out.println(EndDialog);
		}
		else if(args[0].equals("r")) 
		{
			String contents = LoadData();
			System.out.println(contents);
			String words[] = contents.split(",");
			Random x = new Random();
				int y = x.nextInt();
					System.out.println(words[y]);
			System.out.println(EndDialog);
		}
		else if(args[0].contains("+"))
		{
			WirteData(args);
		}
		else if(args[0].contains("?")) 
		{
			String contents = LoadData();
			String words[] = contents.split(",");
			boolean done = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<words.length && !done; idx++) {
				if(words[idx].equals(t)) {
					System.out.println(Success);
						done=true;
				}
			}
			System.out.println(EndDialog);
		}
		else if(args[0].contains("c")) 
		{
			String contents = LoadData();
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
			System.out.println(EndDialog);
		}
	}
}