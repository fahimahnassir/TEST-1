package TEST;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;

public class TEST1 {

	public static void main(String[] args) throws IOException {
	     
	     try{
	          File readFIRST = new File ("FIRST.txt");
	          
	          if (!(readFIRST.exists()))
	          	{
	              System.out.println("File NOT exists");
	              System.exit(0);
	          	}
	          String txt, s1 = "";
	          Scanner inf = new Scanner (readFIRST);
	          while (inf.hasNext())
	          {
	              txt = inf.nextLine();
	              System.out.println(txt);
	              byte[] infoBin = null;
	              infoBin = txt.getBytes("UTF-8");
	              for (byte b : infoBin) 
	              	{
	                  s1 += Integer.toBinaryString(b);
	              	}         
	          }
	          System.out.println(s1);
	          PrintWriter fileOut = new PrintWriter ("SECOND.bin");
	          try{
	              fileOut.printf (s1);
	          }
	          finally{
	              fileOut.close();
	          }
	      }catch (IOException ex){
	          System.out.println (ex.getMessage());
	      }
	        File file = new File("SECOND.bin");

	        Scanner sc = new Scanner(file);
	        String lastString = "";
	        String st="";

	        while (sc.hasNextLine()) {
	            String line = sc.nextLine();
	            lastString = lastString + line;
	            System.out.println(lastString);
	        }
	        char[] result = new char[lastString.length() / 7];
	    
	        for (int i = 0; i < lastString.length(); i += 7) {
	                String sub = lastString.substring(i, i + 7);
	                result[i / 7] = (char) Integer.parseInt(sub, 2);
	        }   
	        
	        int i=result.length;
	        
	        for (int x=result.length; x>0; x--){
	                i=i - 1;
	                st += new String(result).substring(i, x);
	            
	        }
	        System.out.println(st);
	        PrintWriter fileOut = new PrintWriter ("THIRD.txt");
	        try{
	            fileOut.printf (st);
	        }finally{
	              fileOut.close();
	        }
	}
}
