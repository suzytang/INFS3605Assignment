package com.example.infs3605assignment.ui.dashboard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.DatabaseHelper;
import com.example.infs3605assignment.R;
import com.example.infs3605assignment.ui.achievements.AchievementsAdapter;
import com.example.infs3605assignment.ui.knowledge.ModuleCategories;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    DatabaseHelper dbHelper;
    Cursor cursor;
    SQLiteDatabase db;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DashboardAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        container.removeAllViews();

        dbHelper = new DatabaseHelper(getContext());

        final DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        db = databaseHelper.getWritableDatabase();

        // Initialise recyclerView
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // Initialise layoutManager for recyclerView
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Get categories from LearnCategories class
        ArrayList<ModuleCategories> categories = ModuleCategories.getCategories();

        // Create adapter object
        adapter = new DashboardAdapter(this.getContext(), getAllItems(), categories);

        // Attach adapter to recycler
        recyclerView.setAdapter(adapter);
        adapter.swapCursor(getAllItems());

        TextView completed = root.findViewById(R.id.completed);
        TextView outstanding = root.findViewById(R.id.outstanding);

        int level = 1;
        int completedValue = 0;
        for(int i = 0; i < 4; i++){
            if(dbHelper.checkQuiz("COMPLETED",level)){
                completedValue = completedValue + 1;
            }
            level++;
        }

        int modules = categories.size();

        if(completedValue > 0){
            completed.setText(Integer.toString(completedValue));
            int outstandingValue = modules - completedValue;
            outstanding.setText(Integer.toString(outstandingValue));
        } else{
            outstanding.setText(Integer.toString(modules));
        }

        return root;
    }

    public Cursor getAllItems() {
        return db.query(
                DatabaseHelper.QUIZ,
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
