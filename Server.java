import java.lang.*;
import java.io.*;
import java.net.*;

class Server {
   public static void main(String args[]) {
      try {
		  ServerSocket s=new ServerSocket(6565);
         System.out.println("ServerSocket Initialized");
         Socket conn = s.accept();

         InputStreamReader isr=new InputStreamReader(conn.getInputStream());
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
			BufferedOutputStream bos = new BufferedOutputStream(conn.getOutputStream());
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