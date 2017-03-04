package com.example.ribon.quanliquancafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button banhangButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banhangButton= (Button) findViewById(R.id.bt_ban_hang);
        banhangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbh=new Intent(MainActivity.this,BanHangActivity.class);
                startActivity(intentbh);
            }
        });
    }
}
