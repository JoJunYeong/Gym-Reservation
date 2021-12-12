package org.example.superwyh.gymproject;


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

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Reservation_check extends Activity implements OnClickListener {

	
	String year = "";		// 받아올 아이들 미리 변수선언함
	String month = "";
	String day = "";
	String time = "";
	String Cname = "";
	String name = "";
	String age = "";		// 받아올 아이들 미리 변수선언함
	String perpose = "";
	String phone = "";
	String yesno="";
	ArrayList<String> data;
	ArrayAdapter<String> adapter;
	private static final String SERVER_ADDRESS = "http://115.144.76.143";
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reservation_check);
		
		
		data = new ArrayList<String>();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
		
		//intent 결과 등록
				Intent intent = getIntent();
				year = intent.getStringExtra("year");		// year값을 받아옴
				month = intent.getStringExtra("month");		// month값을 받아옴
				day = intent.getStringExtra("day");			// day값을 받아옴
				time = intent.getStringExtra("time");		// time값을 받아옴		
				name = intent.getStringExtra("name");		// name값을 받아옴
				age = intent.getStringExtra("age");
				perpose = intent.getStringExtra("perpose");
				phone = intent.getStringExtra("phone");
				Cname = intent.getStringExtra("Cname");
				Toast.makeText(Reservation_check.this, ""+year+"/"+month+"////"+day+"//"+time+"//"+name, Toast.LENGTH_SHORT).show(); // 값이 제대로 넘어왔는지 확인
				
				try{//////////////////////////////예약 신청 / 취소
					URL url = new URL(SERVER_ADDRESS + "/reservation_check_yesno.php?"
							+ "name=" + URLEncoder.encode(name,"UTF-8")
							+ "&age=" + URLEncoder.encode(age,"UTF-8")
							);					
					url.openStream();		
					String result = getXmlData("reservation_check_yesno.xml", "result");
					yesno = result;
				} catch(Exception e) {
					Toast.makeText(Reservation_check.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
					Log.e("Error", e.getMessage());
				}
				
				
				if(perpose==null)
				{
					try{//////////////////////////////예약 신청 / 취소
						URL url = new URL(SERVER_ADDRESS + "/reservation_check_year.php?"
								+ "name=" + URLEncoder.encode(name,"UTF-8")
								+ "&age=" + URLEncoder.encode(age,"UTF-8")
								);					
						url.openStream();		
						String result = getXmlData("reservation_check_year.xml", "result");
						year = result;
					} catch(Exception e) {
						Toast.makeText(Reservation_check.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
						Log.e("Error", e.getMessage());
					}
					
					
					
					try{//////////////////////////////예약 성공 / 실패
						URL url = new URL(SERVER_ADDRESS + "/reservation_check_month.php?"
								+ "name=" + URLEncoder.encode(name,"UTF-8")
								+ "&age=" + URLEncoder.encode(age,"UTF-8")
								);					
						url.openStream();		
						String result = getXmlData("reservation_check_month.xml", "result");
						month = result;
					} catch(Exception e) {
						Log.e("Error", e.getMessage());
					}
					
					
					try{//////////////////////////////seat_check
						URL url = new URL(SERVER_ADDRESS + "/reservation_check_day.php?"
								+ "name=" + URLEncoder.encode(name,"UTF-8")
								+ "&age=" + URLEncoder.encode(age,"UTF-8")
								);					
						url.openStream();		
						String result = getXmlData("reservation_check_day.xml", "result");
						day = result;
					} catch(Exception e) {
						Log.e("Error", e.getMessage());
					}
					
					
					try{//////////////////////////////예약 일시
						URL url = new URL(SERVER_ADDRESS + "/reservation_check_time.php?"
								+ "name=" + URLEncoder.encode(name,"UTF-8")
								+ "&age=" + URLEncoder.encode(age,"UTF-8")
								);					
						url.openStream();		
						String result = getXmlData("reservation_check_time.xml", "result");
						time = result;
					} catch(Exception e) {
						Log.e("Error", e.getMessage());
					}
					
					
					try{//////////////////////////////PC방 번호
						URL url = new URL(SERVER_ADDRESS + "/reservation_check_perpose.php?"
								+ "name=" + URLEncoder.encode(name,"UTF-8")
								+ "&age=" + URLEncoder.encode(age,"UTF-8")
								);					
						url.openStream();		
						String result = getXmlData("reservation_check_perpose.xml", "result");
						perpose = result;
					} catch(Exception e) {
						Log.e("Error", e.getMessage());
					}
					
					try{//////////////////////////////PC방 번호
						URL url = new URL(SERVER_ADDRESS + "/reservation_check_phone.php?"
								+ "name=" + URLEncoder.encode(name,"UTF-8")
								+ "&age=" + URLEncoder.encode(age,"UTF-8")
								);					
						url.openStream();		
						String result = getXmlData("reservation_check_phone.xml", "result");
						phone = result;
					} catch(Exception e) {
						Log.e("Error", e.getMessage());
					}
					
					try{//////////////////////////////PC방 번호
						URL url = new URL(SERVER_ADDRESS + "/reservation_check_Cname.php?"
								+ "name=" + URLEncoder.encode(name,"UTF-8")
								+ "&age=" + URLEncoder.encode(age,"UTF-8")
								);					
						url.openStream();		
						String result = getXmlData("reservation_check_Cname.xml", "result");
						Cname = result;
					} catch(Exception e) {
						Log.e("Error", e.getMessage());
					}
					
		
					
				}
				
				
				
				
				
				
				
				
				
				
				
				 Button bt1 = (Button)findViewById(R.id.button1);
					bt1.setOnClickListener(this);
					
					TextView testView1 = (TextView)findViewById(R.id.textView1);
					testView1.setText(year+"/"+month+"/"+day);
					TextView testView2 = (TextView)findViewById(R.id.textView2);
					testView2.setText(time);
					TextView testView3 = (TextView)findViewById(R.id.textView3);
					testView3.setText(name);
					TextView testView4 = (TextView)findViewById(R.id.textView4);
					testView4.setText(age);
					TextView testView5 = (TextView)findViewById(R.id.textView5);
					testView5.setText(perpose);
					TextView testView6 = (TextView)findViewById(R.id.textView6);
					testView6.setText(phone);
					if(Cname.equals("bohun"))
						Cname="수원보훈요양원";
					else if(Cname.equals("dasol"))
						Cname="다솔초등학교";
					else if(Cname.equals("gyounggi"))
						Cname="경기대학교";
					TextView testView7 = (TextView)findViewById(R.id.textView7);
					testView7.setText(Cname);
					if(yesno.equals("0"))
						yesno="예약성공";
					else if(yesno.equals("1"))
						yesno="예약대기중";
					else if(yesno.equals("2"))
						yesno="예약실패";
					TextView testView8 = (TextView)findViewById(R.id.textView8);
					testView8.setText(yesno);
					
					
					
					
					
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
		
	    private ArrayList<String> getXmlDataList(String filename, String str) { //占승그곤옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌨아울옙占쏙옙占쏙옙占쏙옙 ArrayList<String>占쏙옙 占쏙옙占쏙옙
			String rss = SERVER_ADDRESS + "/";
			ArrayList<String> ret = new ArrayList<String>();
			
			try { //XML 占식쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				factory.setNamespaceAware(true);
				XmlPullParser xpp = factory.newPullParser();
				URL server = new URL(rss + filename);
				InputStream is = server.openStream();
				xpp.setInput(is, "UTF-8");
				
				int eventType = xpp.getEventType();
				
				while(eventType != XmlPullParser.END_DOCUMENT) {
					if(eventType == XmlPullParser.START_TAG) {
						if(xpp.getName().equals(str)) { //占승깍옙 占싱몌옙占쏙옙 str 占쏙옙占쌘곤옙占쏙옙 占쏙옙占쏙옙 占쏙옙占�
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
			Intent intent1 = new Intent(this,Personal_tworoad.class);
			intent1.putExtra("i","0");//여긴 체육관이름을 보냅니다.
			startActivity(intent1);			
			break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reservation_check, menu);
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
