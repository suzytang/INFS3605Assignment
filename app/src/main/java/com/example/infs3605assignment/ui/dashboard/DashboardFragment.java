package com.example.infs3605assignment.ui.dashboard;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
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
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    DatabaseHelper dbHelper;
    Cursor cursor;
    SQLiteDatabase db;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DashboardAdapter adapter;
    TextView name;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        container.removeAllViews();

        dbHelper = new DatabaseHelper(getContext());

        if(dbHelper.checkUsername() == false){
            openUsernameDialog();
        }

        if(dbHelper.checkFeedback()){
            openFeedbackDialog();
        }

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

        name = root.findViewById(R.id.name);
        TextView completed = root.findViewById(R.id.completed);
        TextView outstanding = root.findViewById(R.id.outstanding);

        name.setText(dbHelper.getUsername());

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

     public void openUsernameDialog(){
        final Dialog dialog = new Dialog (this.getContext());
        dialog.setContentView(R.layout.dialog_username);
        dialog.show();

        final TextInputEditText usernameInput = dialog.findViewById(R.id.usernameInput);
        Button submitButton = dialog.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username = usernameInput.getText().toString();
                dbHelper.setUsername(username);
                name.setText(dbHelper.getUsername());
                dialog.dismiss();
            }
        });
    }

    public void openFeedbackDialog(){
        final Dialog dialog = new Dialog (this.getContext());
        dialog.setContentView(R.layout.dialog_feedback);
        dialog.show();

        Button submitButton = dialog.findViewById(R.id.submitButton);
        Button cancelButton = dialog.findViewById(R.id.cancelButton);
        /*final RatingBar ratingBar = dialog.findViewById(R.id.ratingBar);
        final RatingBar ratingBar2 = dialog.findViewById(R.id.ratingBar2);
        final RatingBar ratingBar3 = dialog.findViewById(R.id.ratingBar3);
        final TextInputEditText feedbackText = dialog.findViewById(R.id.feedbackText);*/

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.setFeedback();
                dialog.dismiss();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dbHelper.setFeedback();

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://forms.gle/5fZWsxWXRSAGUU237")));

                /*int modules = ratingBar.getNumStars();
                int quizzes = ratingBar2.getNumStars();
                int activities = ratingBar3.getNumStars();
                String text = feedbackText.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","cybermind.info@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Modules: " +modules+ "\nQuizzes: " +quizzes+ "\nActivities: "+activities+
                        "\nAdditional comments: "+ text);
                startActivity(Intent.createChooser(emailIntent, "Send email..."));*/

                dialog.dismiss();
            }
        });
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
