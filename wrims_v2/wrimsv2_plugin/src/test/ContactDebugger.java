package test;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.debug.core.DebugException;

import wrimsv2_plugin.debugger.model.IWPPEventListener;

public class ContactDebugger implements IWPPEventListener{
	private ServerSocket requestSocket;
	private Socket requestConnection;
	private ServerSocket eventSocket;
	private Socket eventConnection;
	private PrintWriter out;
	private BufferedReader in;
	public int pauseIndex=-1;
	public int i=-1;
	private Runner runner;
	private FileWriter statusFile;
	public PrintWriter fileOut;
	private boolean isStart=false;
	
	public ContactDebugger(int requestPort, int eventPort){
		try{	
			statusFile = new FileWriter("SocketTest.txt");
		}catch (IOException e){
			e.printStackTrace();
		}
		fileOut = new PrintWriter(statusFile);
		fileOut.println("good!");
		try {
			requestSocket = new ServerSocket(requestPort);
			eventSocket = new ServerSocket(eventPort);
			requestConnection=requestSocket.accept();
			eventConnection=eventSocket.accept();
			out=new PrintWriter(requestConnection.getOutputStream());
			out.flush();
			in=new BufferedReader(new InputStreamReader(requestConnection.getInputStream()));
			String message="";
			runner=new Runner(this);
			do {
				try{
					message=(String)in.readLine();
					handleEvent (message);
				}catch (Exception e){
					e.printStackTrace();
				}
			}while (i<=10000);
		} catch (IOException e){
			System.out.println(e.getMessage());
		}		
		
		finally{
			try{
				fileOut.close();
				in.close();
				out.close();
				requestSocket.close();
				eventSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}

	}
		
	public void handleEvent(String event) {
		String[] eventParts=event.split(":");
		if (eventParts[0].equals("to")) {
			pauseIndex=Integer.parseInt(eventParts[1]);
			if (isStart){
				runner.resume();
			}else{
				isStart=true;
				runner.start();
			}
		} else if (event.equals("step: ")) {
			pauseIndex=pauseIndex+1;
			if (isStart){
				runner.resume();
			}else{
				isStart=true;
				runner.start();
			}
		}
	}
	
	public void sendRequest(String request) throws IOException {
		synchronized (requestConnection){
			try{
				out.println(request);
				out.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}  
	
}
