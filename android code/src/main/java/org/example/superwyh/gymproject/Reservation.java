package org.example.superwyh.gymproject;



import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Reservation extends Activity implements OnClickListener {

	String year = "";		// 받아올 아이들 미리 변수선언함
	String month = "";
	String dayOfMonth = "";
	String time = "";
	String name = "";
	String t[]={"0"};
	String t10="",t11="",t12="",t13="",t14="",t15="",t16="",t17="",t18="",t19="",t20="",t21="";
	String i9="",i10="",i11="",i12="",i13="",i14="",i15="",i16="",i17="",i18="",i19="",i20="",i21="";
	ArrayList<String> data;
	ArrayList<String> array_id;
	ArrayAdapter<String> adapter;
	private static final String SERVER_ADDRESS = "http://115.144.76.143";
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reservation);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
		
		//intent 결과 등록
		Intent intent = getIntent();
		year = intent.getStringExtra("year");		// year값을 받아옴
		month = intent.getStringExtra("month");		// month값을 받아옴
		dayOfMonth = intent.getStringExtra("dayOfMonth");		// dayOfMonth값을 받아옴
		name = intent.getStringExtra("name");		// name값을 받아옴
		  Toast.makeText(Reservation.this, ""+year+"/"+month+"////"+dayOfMonth+"////"+name, 0).show(); // 값이 제대로 넘어왔는지 확인
		  setTitle(year+"년"+month+"월"+dayOfMonth+"일 체육관 시간정보");
		  


	
		  
		    Button bt1 = (Button)findViewById(R.id.button1);
			bt1.setOnClickListener(this);
			Button bt2 = (Button)findViewById(R.id.button2);
			bt2.setOnClickListener(this);
			Button bt3 = (Button)findViewById(R.id.button3);
			bt3.setOnClickListener(this);
			Button bt4 = (Button)findViewById(R.id.button4);
			bt4.setOnClickListener(this);
			Button bt5 = (Button)findViewById(R.id.button5);
			bt5.setOnClickListener(this);
			Button bt6 = (Button)findViewById(R.id.button6);
			bt6.setOnClickListener(this);
			Button bt7 = (Button)findViewById(R.id.button7);
			bt7.setOnClickListener(this);
			Button bt8 = (Button)findViewById(R.id.button8);
			bt8.setOnClickListener(this);
			Button bt9 = (Button)findViewById(R.id.button9);
			bt9.setOnClickListener(this);
			Button bt10 = (Button)findViewById(R.id.button10);
			bt10.setOnClickListener(this);
			Button bt11 = (Button)findViewById(R.id.button11);
			bt11.setOnClickListener(this);
			Button bt12 = (Button)findViewById(R.id.button12);
			bt12.setOnClickListener(this);
			
		    
			
			
			try{//////////////////////////////예약 신청 / 취소
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_9.php?"
						+ "Cname=" + URLEncoder.encode(name,"UTF-8")
						+ "&month=" + URLEncoder.encode(month,"UTF-8")
						+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_9.xml", "result");
				t[0] = result;
			} catch(Exception e) {
				Toast.makeText(Reservation.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
				Log.e("Error", e.getMessage());
			}
			
			
			
				try{//////////////////////////////예약 신청 / 취소
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_10.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_10.xml", "result");
					t10 = result;
				} catch(Exception e) {
					Toast.makeText(Reservation.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
					Log.e("Error", e.getMessage());
				}
				
				
				
				try{//////////////////////////////예약 성공 / 실패
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_11.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
						
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_11.xml", "result");
					t11 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
				
				
				try{//////////////////////////////seat_check
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_12.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
							
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_12.xml", "result");
					t12 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
				
				
				try{//////////////////////////////예약 일시
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_13.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
							
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_13.xml", "result");
					t13 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
				
				
				try{
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_14.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
							
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_14.xml", "result");
					t14 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
				
				try{
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_15.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
						
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_15.xml", "result");
					t15 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
				
				try{
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_16.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
							
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_16.xml", "result");
					t16 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
				
				try{
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_17.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
							
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_17.xml", "result");
					t17 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
	
				try{
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_18.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
							
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_18.xml", "result");
					t18 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
			
				try{
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_19.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
							
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_19.xml", "result");
					t19 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
			
				try{
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_20.php?"
							+ "Cname=" + URLEncoder.encode(name,"UTF-8")
							+ "&month=" + URLEncoder.encode(month,"UTF-8")
							+ "&day=" + URLEncoder.encode(dayOfMonth,"UTF-8")
							
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_20.xml", "result");
					t20 = result;
				} catch(Exception e) {
					Log.e("Error", e.getMessage());
				}
			
				

				if(t[0].equals("0"))
					t[0]="없음";
				else if(t[0].equals("1"))
				{
					i9="1";
					t[0]="예약있음";
				}
				TextView testView3 = (TextView)findViewById(R.id.textView3);
				testView3.setText(t[0]);	
				
				if(t10.equals("0"))
					t10="없음";
				else if(t10.equals("1"))
				{
					i10="1";
					t10="예약있음";
				}
				TextView testView4 = (TextView)findViewById(R.id.textView4);
				testView4.setText(t10);
				
				if(t11.equals("0"))
					t11="없음";
				else if(t11.equals("1"))
				{
					i11="1";
					t11="예약있음";
				}
				TextView testView5 = (TextView)findViewById(R.id.textView5);
				testView5.setText(t11);
				
				if(t12.equals("0"))
					t12="없음";
				else if(t12.equals("1"))
				{
					i12="1";
					t12="예약있음";
				}
				TextView testView6 = (TextView)findViewById(R.id.textView6);
				testView6.setText(t12);
				
				if(t13.equals("0"))
					t13="없음";
				else if(t13.equals("1"))
				{
					i13="1";
					t13="예약있음";
				}
				TextView testView7 = (TextView)findViewById(R.id.textView7);
				testView7.setText(t13);
				
				if(t14.equals("0"))
					t14="없음";
				else if(t14.equals("1"))
				{
					i14="1";
					t14="예약있음";
				}
				TextView testView8 = (TextView)findViewById(R.id.textView8);
				testView8.setText(t14);
				
				if(t15.equals("0"))
					t15="없음";
				else if(t15.equals("1"))
				{
					i15="1";
					t15="예약있음";
				}
				TextView testView9 = (TextView)findViewById(R.id.textView9);
				testView9.setText(t15);
				
				if(t16.equals("0"))
					t16="없음";
				else if(t16.equals("1"))
				{
					i16="1";
					t16="예약있음";
				}
				TextView testView10 = (TextView)findViewById(R.id.textView10);
				testView10.setText(t16);
				
				if(t17.equals("0"))
					t17="없음";
				else if(t17.equals("1"))
				{
					i17="1";
					t17="예약있음";
				}
				TextView testView11 = (TextView)findViewById(R.id.textView11);
				testView11.setText(t17);
				
				if(t18.equals("0"))
					t18="없음";
				else if(t18.equals("1"))
				{
					i18="1";
					t18="예약있음";
				}
				TextView testView12 = (TextView)findViewById(R.id.textView12);
				testView12.setText(t18);
				
				if(t19.equals("0"))
					t19="없음";
				else if(t19.equals("1"))
				{
					i19="1";
					t19="예약있음";
				}
				TextView testView13 = (TextView)findViewById(R.id.textView13);
				testView13.setText(t19);
				
				if(t20.equals("0"))
					t20="없음";
				else if(t20.equals("1"))
				{
					i20="1";
					t20="예약있음";
				}
				TextView testView14 = (TextView)findViewById(R.id.textView14);
				testView14.setText(t20);
				
				
				
				
				  
		  
		  
		  
		  
		  
		  
	}

	
	
	

	
	
	
	
	 private String getXmlData(String filename, String str){
			String rss = SERVER_ADDRESS + "/";
			String ret = "";
			
			try{
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				factory.setNamespaceAware(true);
				XmlPullParser xpp = factory.newPullParser();
				URL server = new URL(rss + filename);
				InputStream is = server.openStream();
				xpp.setInput(is, "UTF-8");
				
				int eventType = xpp.getEventType();
				
				while(eventType != XmlPullParser.END_DOCUMENT) {
					if(eventType == XmlPullParser.START_TAG) {
						if(xpp.getName().equals(str)) {
							ret = xpp.nextText();
						}
					}
					eventType = xpp.next();
					
				}
			} catch(Exception e) {
				Log.e("Error", e.getMessage());
			}
			
			return ret;
		}
		
	    private ArrayList<String> getXmlDataList(String filename, String str) {
			String rss = SERVER_ADDRESS + "/";
			ArrayList<String> ret = new ArrayList<String>();
			
			try {
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				factory.setNamespaceAware(true);
				XmlPullParser xpp = factory.newPullParser();
				URL server = new URL(rss + filename);
				InputStream is = server.openStream();
				xpp.setInput(is, "UTF-8");
				
				int eventType = xpp.getEventType();
				
				while(eventType != XmlPullParser.END_DOCUMENT) {
					if(eventType == XmlPullParser.START_TAG) {
						if(xpp.getName().equals(str)) {
							ret.add(xpp.nextText());
						}
					}
					eventType = xpp.next();
				}
			} catch(Exception e) {
				Log.e("Error", e.getMessage());
			}
			
			return ret;
	    }
		
	
	
	
	public void onClick(View v)
	{
		switch (v.getId()) {
		case R.id.button1:
			if(i9.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent1 = new Intent(this,Send.class);
			intent1.putExtra("year",year);//여긴 년도를 보냅니다.
			intent1.putExtra("month",month);//여긴 달을 보냅니다.
			intent1.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent1.putExtra("time","09:00~10:00");//여긴 시간을 보냅니다.	
			intent1.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent1);	
			}
			break;

		case R.id.button2:
			if(i10.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent2 = new Intent(this,Send.class);
			intent2.putExtra("year",year);//여긴 년도를 보냅니다.
			intent2.putExtra("month",month);//여긴 달을 보냅니다.
			intent2.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent2.putExtra("time","10:00~11:00");//여긴 시간을 보냅니다.
			intent2.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent2);	
			}
			break;
				
		case R.id.button3:
			if(i11.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent3 = new Intent(this,Send.class);
			intent3.putExtra("year",year);//여긴 년도를 보냅니다.
			intent3.putExtra("month",month);//여긴 달을 보냅니다.
			intent3.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent3.putExtra("time","11:00~12:00");//여긴 시간을 보냅니다.
			intent3.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent3);	
			}
			break;
				
		case R.id.button4:
			if(i12.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent4 = new Intent(this,Send.class);
			intent4.putExtra("year",year);//여긴 년도를 보냅니다.
			intent4.putExtra("month",month);//여긴 달을 보냅니다.
			intent4.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent4.putExtra("time","12:00~13:00");//여긴 시간을 보냅니다.
			intent4.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent4);	
			}
			break;
		case R.id.button5:
			if(i13.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent5 = new Intent(this,Send.class);
			intent5.putExtra("year",year);//여긴 년도를 보냅니다.
			intent5.putExtra("month",month);//여긴 달을 보냅니다.
			intent5.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent5.putExtra("time","13:00~14:00");//여긴 시간을 보냅니다.
			intent5.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent5);		
			}
			break;
		case R.id.button6:
			if(i14.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent6 = new Intent(this,Send.class);
			intent6.putExtra("year",year);//여긴 년도를 보냅니다.
			intent6.putExtra("month",month);//여긴 달을 보냅니다.
			intent6.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent6.putExtra("time","14:00~15:00");//여긴 시간을 보냅니다.
			intent6.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent6);		
			}
			break;
		case R.id.button7:
			if(i15.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent7 = new Intent(this,Send.class);
			intent7.putExtra("year",year);//여긴 년도를 보냅니다.
			intent7.putExtra("month",month);//여긴 달을 보냅니다.
			intent7.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent7.putExtra("time","15:00~16:00");//여긴 시간을 보냅니다.
			intent7.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent7);	
			}
			break;
		case R.id.button8:
			if(i16.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent8 = new Intent(this,Send.class);
			intent8.putExtra("year",year);//여긴 년도를 보냅니다.
			intent8.putExtra("month",month);//여긴 달을 보냅니다.
			intent8.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent8.putExtra("time","16:00~17:00");//여긴 시간을 보냅니다.
			intent8.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent8);		
			}
			break;
		case R.id.button9:
			if(i17.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent9 = new Intent(this,Send.class);
			intent9.putExtra("year",year);//여긴 년도를 보냅니다.
			intent9.putExtra("month",month);//여긴 달을 보냅니다.
			intent9.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent9.putExtra("time","17:00~18:00");//여긴 시간을 보냅니다.
			intent9.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent9);	
			}
			break;
		case R.id.button10:
			if(i18.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent10 = new Intent(this,Send.class);
			intent10.putExtra("year",year);//여긴 년도를 보냅니다.
			intent10.putExtra("month",month);//여긴 달을 보냅니다.
			intent10.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent10.putExtra("time","18:00~19:00");//여긴 시간을 보냅니다.
			intent10.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent10);	
			}
			break;
		case R.id.button11:
			if(i19.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent11 = new Intent(this,Send.class);
			intent11.putExtra("year",year);//여긴 년도를 보냅니다.
			intent11.putExtra("month",month);//여긴 달을 보냅니다.
			intent11.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent11.putExtra("time","19:00~20:00");//여긴 시간을 보냅니다.
			intent11.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent11);
			}
			break;
		case R.id.button12:
			if(i20.equals("1"))
			{
				Toast.makeText(Reservation.this, "예약이 있습니다 다른 시간을 선택해 주세요.", Toast.LENGTH_SHORT).show();
			}
			else{
			Intent intent12 = new Intent(this,Send.class);
			intent12.putExtra("year",year);//여긴 년도를 보냅니다.
			intent12.putExtra("month",month);//여긴 달을 보냅니다.
			intent12.putExtra("dayOfMonth",dayOfMonth);//여긴 날짜를 보냅니다.
			intent12.putExtra("time","20:00~21:00");//여긴 시간을 보냅니다.
			intent12.putExtra("name",name);//여긴 체육관이름을 보냅니다.
			startActivity(intent12);		
			}
			break;
			
		}		
		
		
		
		
		
		
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reservation, menu);
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
