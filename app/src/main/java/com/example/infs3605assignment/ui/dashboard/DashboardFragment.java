package com.example.infs3605assignment.ui.dashboard;

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

import com.example.infs3605assignment.DatabaseHelper;
import com.example.infs3605assignment.R;

public class DashboardFragment extends Fragment {

    DatabaseHelper dbHelper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        container.removeAllViews();

        dbHelper = new DatabaseHelper(getContext());
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

        if(completedValue > 0){
            completed.setText(Integer.toString(completedValue));
            int outstandingValue = 6 - completedValue;
            outstanding.setText(Integer.toString(outstandingValue));
        } else{
            outstanding.setText("6");
        }

        return root;

    }
}
