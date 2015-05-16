package com.example.hiit;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Timer mtimer = new Timer();
    private int count = 0;
    private TextView mtextView;
    private Message msg = new Message();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mtextView = (TextView)findViewById(R.id.Display);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onStartClick(View view){
		 
		TextView textView = (TextView)findViewById(R.id.Display);
		textView.setText("button clicked!");
		Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE); 
		long [] pattern = {100,400,100,400};   
        vibrator.vibrate(pattern,-1);
        
        mtimer.schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				++ count;
				
	        	switch (count)
	            {
	            case 1:
	            	msg.what = 1;
	                mhandler.sendMessage(msg);
	            	break;
	            case 10:
	            case 13:
	            case 16:
	            case 19:
	            case 22:
	            case 25:
	            case 28:
	            case 31:
	            case 34:
	            case 37:
	            	msg.what = 2;
	                mhandler.sendMessage(msg);
	            	break;
	            case 11:
	            case 14:
	            case 17:
	            case 20:
	            case 23:
	            case 26:
	            case 29:
	            case 32:
	            case 35:
	            case 38:
	            	msg.what = 3;
	                mhandler.sendMessage(msg);
	            	break;
	            case 40:
	            	msg.what = 4;
	                mhandler.sendMessage(msg);
	            	break;
	            case 50:
	            	msg.what = 5;
	                mhandler.sendMessage(msg);
	            	break;
	            default :
	            	break;
	            }
			}
        	
        }, 30*1000, 30*1000);
	}
	
	Handler mhandler = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what)
			{
			case 1:
				mtextView.setText("热身");
				Log.d("hehe", "热身");
				break;
			case 2:
				mtextView.setText("加速");
				Log.d("hehe", "加速");
				break;
			case 3:
				mtextView.setText("慢跑");
				Log.d("hehe", "慢跑");
				break;
			case 4:
				mtextView.setText("拉伸");
				Log.d("hehe", "拉伸");
				break;
			case 5:
				mtextView.setText("结束");
				Log.d("hehe", "结束");
			default:
				break;
			}
		}
	};
	
	
}
