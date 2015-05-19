package com.example.practicaltest02.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import android.util.Log;
import android.widget.TextView;

import com.example.practicaltest02.utils.Constants;
import com.example.practicaltest02.utils.Utilities;

public class ClientThread extends Thread {
	
	private int operator1;
	private int operator2;
	private String operation;
	private int port;
	private TextView result;
	
	private Socket   socket;
	
	public ClientThread(int operator1, int operator2, String operation, int port, TextView result) {
		this.operation = operation;
		this.operator1 = operator1;
		this.operator2 = operator2;
		this.port = port;
		this.result = result;
	}
	
	@Override
	public void run() {
		try {
			socket = new Socket("localhost", port);
			if (socket == null) {
				Log.e(Constants.TAG, "[CLIENT THREAD] Could not create socket!");
			}
			
			BufferedReader bufferedReader = Utilities.getReader(socket);
			PrintWriter    printWriter    = Utilities.getWriter(socket);
			if (bufferedReader != null && printWriter != null) {
				printWriter.println(operator1);
				printWriter.flush();
				printWriter.println(operator2);
				printWriter.flush();
				printWriter.println(operation);
				printWriter.flush();
				String data;
				while ((data = bufferedReader.readLine()) != null) {
					final String finalizedResult = data;
					result.post(new Runnable() {
						@Override
						public void run() {
							result.append(finalizedResult + "\n");
						}
					});
				}
			} else {
				Log.e(Constants.TAG, "[CLIENT THREAD] BufferedReader / PrintWriter are null!");
			}
			socket.close();
		} catch (IOException ioException) {
			Log.e(Constants.TAG, "[CLIENT THREAD] An exception has occurred: " + ioException.getMessage());
			if (Constants.DEBUG) {
				ioException.printStackTrace();
			}
		}
	}

}

