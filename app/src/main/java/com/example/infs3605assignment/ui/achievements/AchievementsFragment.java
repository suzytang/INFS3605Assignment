package com.example.infs3605assignment.ui.achievements;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.DatabaseHelper;
import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class AchievementsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AchievementsAdapter adapter;
    private SQLiteDatabase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();
        View root = inflater.inflate(R.layout.fragment_achievements, container, false);

        final DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        db = databaseHelper.getWritableDatabase();

        // Initialise recyclerView
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // Initialise layoutManager for recyclerView
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Get categories from LearnCategories class
        //ArrayList<Achievements> achievements = Achievements.getAchievements();

        // Create adapter object
        adapter = new AchievementsAdapter(this.getContext(), getAllItems());

        // Attach adapter to recycler
        recyclerView.setAdapter(adapter);
        adapter.swapCursor(getAllItems());

        return root;
    }

    public Cursor getAllItems() {
        return db.query(
                DatabaseHelper.ACHIEVEMENTS,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
