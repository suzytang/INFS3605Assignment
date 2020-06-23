package com.example.infs3605assignment.ui.knowledge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;

import com.example.infs3605assignment.R;

public class ModuleContent extends Fragment {
    private ScrollView scrollView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate view with recycler module fragment
        View root = inflater.inflate(R.layout.fragment_module_content, container, false);

        scrollView = root.findViewById(R.id.scrollView);

        return root;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
