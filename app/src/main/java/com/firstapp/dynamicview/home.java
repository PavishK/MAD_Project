package com.firstapp.dynamicview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {
    private Button btn,btn1;
    private EditText get;
    private String getName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_home,container,false);
        btn=v.findViewById(R.id.button4);
        btn1=v.findViewById(R.id.button12);
        get=v.findViewById(R.id.editTextText);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getName=get.getText().toString();
                Bundle b=new Bundle();
                b.putString("GetName",getName);
                getParentFragmentManager().setFragmentResult("data from",b);
            }

        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setMessage("Place Order For the item ROG 7.").setTitle("Order Info").setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(),"Order Confirmed ✔️.",Toast.LENGTH_SHORT).show();
                                Intent in=new Intent(getContext(),MainActivity4.class);
                                startActivity(in);
                            }
                        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(getContext(),"Order Canceld ✖️.",Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert=builder.create();
                alert.setTitle("Confirmation Order");
                alert.show();

            }
        });
        return v;
    }
}