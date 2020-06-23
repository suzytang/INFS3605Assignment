package com.example.infs3605assignment.ui.knowledge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.R;

import java.util.ArrayList;


public class MCQRecycler extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate view with recycler module fragment
        View root = inflater.inflate(R.layout.fragment_m_c_q_recycler, container, false);

        // Initialise recyclerView
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // Initialise layoutManager for recyclerView
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Get useranswers - requires put and get bundles from MCQ
        // Bundle args = intent.getBundleExtra("bundle");
        // ArrayList<MCQInput> answers = (ArrayList<MCQInput>) args.getSerializable("arraylist");
        ArrayList<MCQInput> answers = new ArrayList<>();

        // Create adapter object
        adapter = new MCQAdapter(this.getContext(), answers);

        // Attach adapter to recycler
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
