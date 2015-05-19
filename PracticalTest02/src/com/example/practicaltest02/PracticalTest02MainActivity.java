package com.example.practicaltest02;

import android.app.Activity;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicaltest02.networking.ClientThread;
import com.example.practicaltest02.networking.ServerThread;
import com.example.practicaltest02.utils.Constants;

public class PracticalTest02MainActivity extends Activity {
	
	private EditText     operator1    = null;
	private EditText     operator2       = null;
	
	private EditText     addOp    = null;
	private EditText     mulOp       = null;
	
	private Button 		add = null;
	private Button 		mul = null;
	
	private TextView 	result = null;
	
	private TextView 	portServer = null;
	
	private ServerThread serverThread             = null;
	private ClientThread clientThread             = null;
	
	/*private ConnectButtonClickListener connectButtonClickListener = new ConnectButtonClickListener();
	private class ConnectButtonClickListener implements Button.OnClickListener {
			
			@Override
			public void onClick(View view) {
				String serverPort = portServer.getText().toString();
				if (serverPort == null || serverPort.isEmpty()) {
					Toast.makeText(
						getApplicationContext(),
						"Server port should be filled!",
						Toast.LENGTH_SHORT
					).show();
					return;
				}
				
				serverThread = new ServerThread(Integer.parseInt(serverPort));
				if (serverThread.getServerSocket() != null) {
					serverThread.start();
				} else {
					Log.e(Constants.TAG, "[MAIN ACTIVITY] Could not creat server thread!");
				}
			}
	}*/
		
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test02_main);
		
		operator1 = (EditText)findViewById(R.id.operator1_edit_text);
		operator2 = (EditText)findViewById(R.id.operator2_edit_text);
		addOp = (EditText)findViewById(R.id.display_add_result);
		mulOp = (EditText)findViewById(R.id.display_mul_result);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test02_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
