package com.firstapp.dynamicview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Button btn1,btn2,btn3;
    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle b=getIntent().getExtras();
        String UserName=b.getString("keyName");
        String pass=b.getString("keyPass");
        btn1=findViewById(R.id.button5);
        btn2=findViewById(R.id.button7);
        btn3=findViewById(R.id.button6);
        name=findViewById(R.id.textView7);
        name.setText("User : "+UserName);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("KeyName",UserName);
                Toast.makeText(MainActivity3.this, "Opening Home.", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivityAbout.class);
                startActivity(i);
                finish();
            }
        });
    }
}