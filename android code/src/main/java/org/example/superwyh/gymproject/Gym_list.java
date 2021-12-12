package org.example.superwyh.gymproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Gym_list extends Activity implements OnClickListener {


    String i = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_list);


        ImageView bohun = (ImageView) findViewById(R.id.bohun_letter_img);
        bohun.setOnClickListener(this);
        ImageView dasol = (ImageView) findViewById(R.id.dasol_letter_img);
        dasol.setOnClickListener(this);
        ImageView kyunggi = (ImageView) findViewById(R.id.kyunggi_letter_img);
        kyunggi.setOnClickListener(this);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bohun_letter_img:
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.putExtra("i", i);//���� �̸��� �����ϴ�.
                intent1.putExtra("name", "bohun");
                startActivity(intent1);
                break;

            case R.id.dasol_letter_img:
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.putExtra("i", i);//���� �̸��� �����ϴ�.
                intent2.putExtra("name", "dasol");
                startActivity(intent2);
                break;

            case R.id.kyunggi_letter_img:
                Intent intent3 = new Intent(this, MainActivity.class);
                intent3.putExtra("i", i);//���� �̸��� �����ϴ�.
                intent3.putExtra("name", "gyounggi");
                startActivity(intent3);
                break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gym_list, menu);
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
