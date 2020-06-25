package com.example.infs3605assignment.ui.knowledge;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.infs3605assignment.DatabaseHelper;
import com.example.infs3605assignment.MainActivity;
import com.example.infs3605assignment.R;

import static android.content.ContentValues.TAG;

public class ModuleContent extends Fragment {
    private ScrollView scrollView;
    private TextView heading1, content1, heading2, content2, heading3, content3, heading4, content4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate view with recycler module fragment
        container.removeAllViews();
        int level = getArguments().getInt("Level");
        View root = inflater.inflate(R.layout.fragment_module_content, container, false);
        DatabaseHelper data = new DatabaseHelper(getActivity());

        scrollView = root.findViewById(R.id.scrollView);
        heading1 = root.findViewById(R.id.heading1);
        heading1.setText(data.getText("HEAD1", level));
        content1 = root.findViewById(R.id.content1);
        content1.setText(data.getText("CON1", level));
        heading2 = root.findViewById(R.id.heading2);
        heading2.setText(data.getText("HEAD2", level));
        content2 = root.findViewById(R.id.content2);
        content2.setText(data.getText("CON2", level));
        heading3 = root.findViewById(R.id.heading3);
        heading3.setText(data.getText("HEAD3", level));
        content3 = root.findViewById(R.id.content3);
        content3.setText(data.getText("CON3", level));
        heading4 = root.findViewById(R.id.heading4);
        heading4.setText(data.getText("HEAD4", level));
        content4 = root.findViewById(R.id.content4);
        content4.setText(data.getText("CON4", level));

        Log.i(TAG, "Module Content Fragment Opened");
        return root;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
