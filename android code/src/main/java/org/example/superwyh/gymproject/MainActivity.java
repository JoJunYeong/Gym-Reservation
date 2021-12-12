package org.example.superwyh.gymproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    String i = "0";
    String name = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button bt2 = (Button) findViewById(R.id.button3);
        bt2.setOnClickListener(this);


        Intent intent = getIntent();
        i = intent.getStringExtra("i");
        name = intent.getStringExtra("name");

        if (i == null)    // 만약에 이게 처음 앱을 키는 거라면 로그인 화면을 띄운다.
        {
            startActivity(new Intent(MainActivity.this, Tworoad.class));
            //	finish();
        }


        //CalendarView 인스턴스 만들기

        CalendarView calendar = (CalendarView) findViewById(R.id.calendarView1);


        //리스너 등록

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {


            @Override

            public void onSelectedDayChange(CalendarView view, int year, int month,

                                            int dayOfMonth) {

                // TODO Auto-generated method stub

                Toast.makeText(MainActivity.this, "" + year + "/" + (month + 1) + "/" + dayOfMonth, Toast.LENGTH_SHORT).show();


                Intent intent1 = new Intent(MainActivity.this, Reservation.class);
                intent1.putExtra("year", Integer.toString(year));//여긴 년도을 보냅니다.
                intent1.putExtra("month", Integer.toString((month + 1)));//여긴 월을 보냅니다.
                intent1.putExtra("dayOfMonth", Integer.toString(dayOfMonth));//여긴 일을 보냅니다.
                intent1.putExtra("name", name);//여긴 체육관이름을 보냅니다.
                startActivity(intent1);


            }

        });


    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                Intent intent2 = new Intent(this, Map.class);
                intent2.putExtra("name", name);//여긴 체육관이름을 보냅니다.
                startActivity(intent2);
                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
