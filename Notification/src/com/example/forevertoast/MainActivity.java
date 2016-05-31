package com.example.forevertoast;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button mButton1;
	private Button mButton2;
	private Button mButton3;
	private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
    	context = MainActivity.this;
    	
    	
    	mButton1 = (Button) findViewById(R.id.button1);
    	mButton2 = (Button) findViewById(R.id.button2);
    	mButton3 = (Button) findViewById(R.id.button3);
    	
    	mButton1.setOnClickListener(mOnClickListener);
    	mButton2.setOnClickListener(mOnClickListener);
    	mButton3.setOnClickListener(mOnClickListener);
    }
    
    private OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			switch (v.getId()) {
			case R.id.button1:
				Notification mNotification = new Notification(R.drawable.ic_launcher, "你有新的消息了", System.currentTimeMillis());
				PendingIntent contentIntent = PendingIntent.getActivity(context, 0, getIntent(), 0);
				mNotification.setLatestEventInfo(context, "天气预报", "晴转多云", contentIntent);
				mNotificationManager.notify(1, mNotification);
				break;
				
			case R.id.button2:
				Notification mNotification2 = new Notification(R.drawable.ic_launcher, "你有新的消息了啊", System.currentTimeMillis());
				PendingIntent mIntent = PendingIntent.getActivity(context, 0, new Intent(MainActivity.this, MainActivity.class), 0);
				mNotification2.setLatestEventInfo(context, "notification2", "This is content", mIntent);
				mNotification2.flags = Notification.FLAG_ONGOING_EVENT;
				mNotificationManager.notify(2, mNotification2);
				break;
				
			case R.id.button3:
				mNotificationManager.cancelAll();
				break;

			default:
				break;
			}
			
		}
	};
}
