import java.lang.*;
import java.io.*;
import java.net.*;

class Client {
   public static void main(String args[]) {
      try {
		  Socket s=new Socket("localhost", 80);
         System.out.println("Welcome");

         InputStreamReader isr=new InputStreamReader(s.getInputStream());
		           BufferedReader bfip=new BufferedReader(isr);
		           String ip = bfip.readLine();
		           while(ip!=null)
		           {
		 			  System.out.println(ip);
			}

         InputStreamReader isrkey= new InputStreamReader(System.in);
         BufferedReader bfkey = new BufferedReader(isrkey);

         
         try
         {
            System.out.println("Message");
            String msg=bfkey.readLine();
			System.out.println(msg);
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
			OutputStreamWriter osw=new OutputStreamWriter(bos,"US-ASCII");

			osw.write(msg);
          }
          catch(IOException err)
          {
          System.out.println("Error");
          }


      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n");
      }
   }
}