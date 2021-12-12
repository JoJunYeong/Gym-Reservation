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

public class Conform_no extends Activity {

	
	String ID = "";
	String Password = "";		// 받아올 아이들 미리 변수선언함
	Button ok,no;
	String ok1,no1;
	String year = "";		// 받아올 아이들 미리 변수선언함
	String month = "";
	String day = "";
	String time = "";
	String t="";
	String Cname = "";
	String name = "";
	String age = "";		// 받아올 아이들 미리 변수선언함
	String perpose = "";
	String phone = "";
	String yesno="";
	String ready="";
	String check="";
	int i=0;
	
	
	ArrayList<String> data;
	ArrayAdapter<String> adapter;
	private static final String SERVER_ADDRESS = "http://115.144.76.143";
	
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conform_no);
		data = new ArrayList<String>();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
		
	    Intent intent = getIntent();
		ID = intent.getStringExtra("ID");		// ID값을 받아옴
		Password = intent.getStringExtra("Password");		// Password값을 받아옴
		
		
		ok= (Button)findViewById(R.id.button1);
        no= (Button)findViewById(R.id.button2);
   	
        
        
        
        try{//////////////////////////////예약 신청 / 취소
			URL url = new URL(SERVER_ADDRESS + "/admin_check_Cname.php?"
					+ "ID=" + URLEncoder.encode(ID,"UTF-8")
					+ "&Password=" + URLEncoder.encode(Password,"UTF-8")
					);					
			url.openStream();		
			String result = getXmlData("admin_check_Cname.xml", "result");
			Cname = result;
		} catch(Exception e) {
			Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
			Log.e("Error", e.getMessage());
		}
        try{//////////////////////////////예약 신청 / 취소
			URL url = new URL(SERVER_ADDRESS + "/admin_check_ready.php?"
					+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
					);					
			url.openStream();		
			String result = getXmlData("admin_check_ready.xml", "result");
			ready = result;
		} catch(Exception e) {
			Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
			Log.e("Error", e.getMessage());
		}
		if(ready.equals("0"))
		{
			i=1;
			Toast.makeText(Conform_no.this, "예약신청이 없습니다.", Toast.LENGTH_SHORT).show();
		}
        
        if(i==0)
	    {
        	try{//////////////////////////////예약 신청 / 취소
    			URL url = new URL(SERVER_ADDRESS + "/admin_check_t.php?"
    					+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
    					);					
    			url.openStream();		
    			String result = getXmlData("admin_check_t.xml", "result");
    			t = result;
    		} catch(Exception e) {
    			Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
    			Log.e("Error", e.getMessage());
    		}
	        
	        try{//////////////////////////////예약 신청 / 취소
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_year1.php?"
						+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
						+ "&t=" + URLEncoder.encode(t,"UTF-8")						
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_year.xml", "result");
				year = result;
			} catch(Exception e) {
				Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
				Log.e("Error", e.getMessage());
			}
			
			
			
			try{//////////////////////////////예약 성공 / 실패
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_month1.php?"
						+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
						+ "&t=" + URLEncoder.encode(t,"UTF-8")				
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_month.xml", "result");
				month = result;
			} catch(Exception e) {
				Log.e("Error", e.getMessage());
			}
			
			
			try{//////////////////////////////seat_check
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_day1.php?"
						+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
						+ "&t=" + URLEncoder.encode(t,"UTF-8")				
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_day.xml", "result");
				day = result;
			} catch(Exception e) {
				Log.e("Error", e.getMessage());
			}
			
			
			try{//////////////////////////////예약 일시
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_time1.php?"
						+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
						+ "&t=" + URLEncoder.encode(t,"UTF-8")				
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_time.xml", "result");
				time = result;
			} catch(Exception e) {
				Log.e("Error", e.getMessage());
			}
			
			
			try{//////////////////////////////PC방 번호
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_perpose1.php?"
						+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
						+ "&t=" + URLEncoder.encode(t,"UTF-8")				
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_perpose.xml", "result");
				perpose = result;
			} catch(Exception e) {
				Log.e("Error", e.getMessage());
			}
			
			try{//////////////////////////////PC방 번호
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_phone1.php?"
						+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
						+ "&t=" + URLEncoder.encode(t,"UTF-8")				
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_phone.xml", "result");
				phone = result;
			} catch(Exception e) {
				Log.e("Error", e.getMessage());
			}
			        
			
			try{//////////////////////////////예약 신청 / 취소
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_yesno1.php?"
						+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
						+ "&t=" + URLEncoder.encode(t,"UTF-8")				
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_yesno.xml", "result");
				yesno = result;
			} catch(Exception e) {
				Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
				Log.e("Error", e.getMessage());
			}
			
			try{//////////////////////////////예약 신청 / 취소
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_name1.php?"
						+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
						+ "&t=" + URLEncoder.encode(t,"UTF-8")				
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_name.xml", "result");
				name = result;
			} catch(Exception e) {
				Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
				Log.e("Error", e.getMessage());
			}
			
			try{//////////////////////////////예약 신청 / 취소
				URL url = new URL(SERVER_ADDRESS + "/reservation_check_age1.php?"
						+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
						+ "&t=" + URLEncoder.encode(t,"UTF-8")				
						);					
				url.openStream();		
				String result = getXmlData("reservation_check_age.xml", "result");
				age = result;
			} catch(Exception e) {
				Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
				Log.e("Error", e.getMessage());
			}
	        
	    }
        else if(i==1)
        {
        name="예약신청 없음";
        			
        }
        
        no.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(i==1)
				{
					Toast.makeText(Conform_no.this, "거절할 예약이 없습니다.", Toast.LENGTH_SHORT).show();					
				}
				else if(i==0)
				{
				//	Toast.makeText(Conform_no.this, Cname +"/"+ name+"/"+t, Toast.LENGTH_SHORT).show();					
					if(Cname.equals("수원보훈요양원"))
						Cname="bohun";
					else if(Cname.equals("다솔초등학교"))
						Cname="dasol";
					else if(Cname.equals("경기대학교"))
						Cname="gyounggi";
				//	Toast.makeText(Conform_no.this, Cname +"/"+ name+"/"+t, Toast.LENGTH_SHORT).show();					
					
					try{//////////////////////////////예약 신청 / 취소
						URL url = new URL(SERVER_ADDRESS + "/no.php?"
								+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
								+ "&name=" + URLEncoder.encode(name,"UTF-8")
								+ "&t=" + URLEncoder.encode(t,"UTF-8")				
								);					
						url.openStream();		
						String result = getXmlData("no.xml", "result");
						no1 = result;
					} catch(Exception e) {
						Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
						Log.e("Error", e.getMessage());
					}
					try{//////////////////////////////예약 신청 / 취소
						URL url = new URL(SERVER_ADDRESS + "/no_check.php?"
								+ "Cname=" + URLEncoder.encode(Cname,"UTF-8")
								+ "&name=" + URLEncoder.encode(name,"UTF-8")
								+ "&t=" + URLEncoder.encode(t,"UTF-8")				
								);					
						url.openStream();		
						String result = getXmlData("no_check.xml", "result");
						no1 = result;
					} catch(Exception e) {
						Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
						Log.e("Error", e.getMessage());
					}
					if(no1.equals("1"))
					{
					
					Toast.makeText(Conform_no.this, "거절하였습니다.", Toast.LENGTH_SHORT).show();
					finish();
					}
					else
						Toast.makeText(Conform_no.this, "일시적인 오류가 발생했습니다 잠시후에 다시 시도해주시기 바랍니다.", Toast.LENGTH_SHORT).show();
					
				}
				
				
				
				
				
				
			}
		});
		
        
        ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(i==1)
				{
					Toast.makeText(Conform_no.this, "수락할 예약이 없습니다.", Toast.LENGTH_SHORT).show();										
				}
				else if(i==0) {
					//		Toast.makeText(Conform_no.this, Cname +"/"+ name+"/"+t, Toast.LENGTH_SHORT).show();
					if (Cname.equals("수원보훈요양원"))
						Cname = "bohun";
					else if (Cname.equals("다솔초등학교"))
						Cname = "dasol";
					else if (Cname.equals("경기대학교"))
						Cname = "gyounggi";
					//		Toast.makeText(Conform_no.this, Cname +"/"+ name+"/"+t, Toast.LENGTH_SHORT).show();

					/////////////////////////////////////////////////////////////////////////////////


					try {//////////////////////////////예약 신청 / 취소
						URL url = new URL(SERVER_ADDRESS + "/ok_before_check.php?"
								+ "Cname=" + URLEncoder.encode(Cname, "UTF-8")
								+ "&name=" + URLEncoder.encode(name, "UTF-8")
								+ "&t=" + URLEncoder.encode(t, "UTF-8")
								+ "&year=" + URLEncoder.encode(year, "UTF-8")
								+ "&month=" + URLEncoder.encode(month, "UTF-8")
								+ "&day=" + URLEncoder.encode(day, "UTF-8")
								+ "&time=" + URLEncoder.encode(time, "UTF-8")
						);
						url.openStream();
						String result = getXmlData("ok_before_check.xml", "result");
						check = result;
					} catch (Exception e) {
						Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
						Log.e("Error", e.getMessage());
					}


					if (check.equals("0")) {


						////////////////////////////////////////////////////////////////////////////////
						try {//////////////////////////////예약 신청 / 취소
							URL url = new URL(SERVER_ADDRESS + "/ok.php?"
									+ "Cname=" + URLEncoder.encode(Cname, "UTF-8")
									+ "&name=" + URLEncoder.encode(name, "UTF-8")
									+ "&t=" + URLEncoder.encode(t, "UTF-8")
							);
							url.openStream();
							String result = getXmlData("ok.xml", "result");

						} catch (Exception e) {
							Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
							Log.e("Error", e.getMessage());
						}
						try {//////////////////////////////예약 신청 / 취소
							URL url = new URL(SERVER_ADDRESS + "/ok_check.php?"
									+ "Cname=" + URLEncoder.encode(Cname, "UTF-8")
									+ "&name=" + URLEncoder.encode(name, "UTF-8")
									+ "&t=" + URLEncoder.encode(t, "UTF-8")
							);
							url.openStream();
							String result = getXmlData("ok_check.xml", "result");
							ok1 = result;
						} catch (Exception e) {
							Toast.makeText(Conform_no.this, "인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
							Log.e("Error", e.getMessage());
						}
						if (ok1.equals("1")) {
							finish();
							Toast.makeText(Conform_no.this, "수락하였습니다.", Toast.LENGTH_SHORT).show();

						} else
							Toast.makeText(Conform_no.this, "일시적인 오류가 발생했습니다 잠시후에 다시 시도해주시기 바랍니다.", Toast.LENGTH_SHORT).show();

					}
					else if(check.equals("1"))
						Toast.makeText(Conform_no.this, "같은시간에 예약이 이미있습니다. 거절해주세요.", Toast.LENGTH_SHORT).show();

				}
				
				
				
			}
		});
        
        
        
        
        
        
        
        
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
		
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.conform_no, menu);
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
