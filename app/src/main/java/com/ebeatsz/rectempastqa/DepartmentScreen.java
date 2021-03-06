package com.ebeatsz.rectempastqa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class DepartmentScreen extends AppCompatActivity implements View.OnClickListener {
    TextView department_title, department_name;
    CardView card_view, department_card;
    ImageView btn_back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_department_screen);

        department_title = findViewById(R.id.department_title);

        String name = getIntent().getStringExtra("name");
        department_title.setText(name);

        department_card = findViewById(R.id.department_card);
        btn_back = findViewById(R.id.btn_back);
        home = findViewById(R.id.home);

        department_card.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        home.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // Assigning a value to TextView
        department_name = (TextView) findViewById(R.id.department_name);
        Intent i;

        switch (v.getId()) {
            case R.id.department_card:
                //Disable department_card and enable after 200ms
                department_card.setEnabled(false);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        department_card.setEnabled(true);
                    }
                }, 200);

                String name = department_name.getText().toString();

                i = new Intent(this, CourseScreen.class);
                i.putExtra("department_name", name);
                startActivity(i);
                break;

            case R.id.btn_back:
                finish();
                break;

            case R.id.home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;

        }
    }
}