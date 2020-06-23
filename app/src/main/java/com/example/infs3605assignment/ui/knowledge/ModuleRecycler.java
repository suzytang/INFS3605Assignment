package com.example.infs3605assignment.ui.knowledge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.R;

import java.util.ArrayList;


public class ModuleRecycler extends Fragment {
    private RecyclerView recyclerView;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate view with recycler module fragment
        View root = inflater.inflate(R.layout.fragment_module_recycler, container, false);

        // Initialise recyclerView
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // Initialise layoutManager for recyclerView
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Get categories from LearnCategories class
        ArrayList<ModuleCategories> categories = ModuleCategories.getCategories();

        // Create adapter object
        adapter = new ModuleAdapter(this.getContext(), categories);

        // Attach adapter to recycler
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
