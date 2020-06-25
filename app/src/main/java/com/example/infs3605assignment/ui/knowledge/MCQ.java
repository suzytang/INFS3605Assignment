package com.example.infs3605assignment.ui.knowledge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.infs3605assignment.R;

import java.util.ArrayList;


public class MCQ extends Fragment {
    private ArrayList<MCQInput> answers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.removeAllViews();
        int level = getArguments().getInt("Level");
        View root = inflater.inflate(R.layout.fragment_module_content, container, false);
        // Inflate the layout for this fragment
        // Radio buttons for each question
        // Store user answers
        //Bundle args = new Bundle();
        //// Pass arraylist with MCQInput and categories
        //args.putSerializable("arraylist", answers);
        //intent2.putExtra("bundle", args);
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
