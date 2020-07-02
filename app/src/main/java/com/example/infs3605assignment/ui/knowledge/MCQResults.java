package com.example.infs3605assignment.ui.knowledge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class MCQResults extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_c_q_results);

        // Initialise recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // Initialise lay`outManager for recyclerView
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        // Get useranswers - requires put and get bundles from MCQ
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        ArrayList<MCQInput> inputList = (ArrayList<MCQInput>) args.getSerializable("MCQInput");

        // Create adapter object
        adapter = new MCQAdapter(this, inputList);

        // Attach adapter to recycler
        recyclerView.setAdapter(adapter);
    }
}