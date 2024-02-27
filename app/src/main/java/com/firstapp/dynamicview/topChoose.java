package com.firstapp.dynamicview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link topChoose#newInstance} factory method to
 * create an instance of this fragment.
 */
public class topChoose extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_top_choose, container, false);
        getParentFragmentManager().setFragmentResultListener("data from", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle b) {
                TextView tv=v.findViewById(R.id.textView2);
                String name=b.getString("GetName");
                tv.setText(name);
            }
        });
        return v;

    }
}