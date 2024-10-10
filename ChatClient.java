import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ChatClient{
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println(
			       "Usage: java ChatClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0]; 
        int portNumber = Integer.parseInt(args[1]);

 
        try{
	    
	    Socket serverSocket = new Socket(hostName, portNumber);
	    PrintWriter socketOut = new PrintWriter(serverSocket.getOutputStream(), true);
	    BufferedReader socketIn = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
	    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter a username below: ");
	    String userName = stdIn.readLine();
	    socketOut.println(userName);
	    ClientReceiver receiverThread = new ClientReceiver(socketIn);
	    receiverThread.start();
	    

	    //Connect to the server by instantiating a Socket object
	    //Set the Socket output stream to a PrintWriter object
	    //Set the Socket input stream to a Buffered Reader           	    
	    //Read in username from terminal
	    //Send username string to server
	    //Fire up a ClientReceiver thread

	    //Chatting below
	    String userInput; 
	    while ((userInput = stdIn.readLine()) != null) {
		socketOut.println(userInput);
            }
	    // serverSocket.close();
        } catch (Exception e) {
            System.err.println("ChatClient: " + e);
            System.exit(1);
        }
    }


}
