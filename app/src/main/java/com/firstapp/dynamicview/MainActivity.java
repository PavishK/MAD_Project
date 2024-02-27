package com.firstapp.dynamicview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name,pass;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editTextText2);
        pass=findViewById(R.id.editTextTextPassword2);
        but=findViewById(R.id.button);
        Bundle bundle=new Bundle();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=name.getText().toString();
                String password=pass.getText().toString();
                Intent in=new Intent(MainActivity.this,MainActivity3.class);
                bundle.putString("keyName",username);
                bundle.putString("keyPass",password);
                in.putExtras(bundle);
                builder.setMessage("Do you want to SigIn as "+username).setTitle("LogIn Info").setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(in);
                            }
                        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(getApplicationContext(),"Canceld ✖️ by User.",Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert=builder.create();
                alert.setTitle("Confirmation ");
                alert.show();

            }
        });

    }
}