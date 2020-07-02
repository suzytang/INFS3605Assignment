package com.example.infs3605assignment.ui.knowledge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.infs3605assignment.MainActivity;
import com.example.infs3605assignment.R;

import static android.content.ContentValues.TAG;
import static com.example.infs3605assignment.ui.knowledge.ModuleCategories.getCategories;

public class LearnActivity extends AppCompatActivity {
    private ScrollView scrollView;
    private TextView heading1, content1, heading2, content2, heading3, content3, heading4, content4,
            heading5, heading6, heading7, content5, content6, content7, moduleTitle;
    private Button backButton, activityButton, quizButton;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        Intent intent = getIntent();
        level = intent.getIntExtra("Level",0);
        ModuleData data = ModuleData.getData().get(level - 1);
        moduleTitle = findViewById(R.id.moduleTitle);
        moduleTitle.setText(getCategories().get(level-1).getCategoryName());
        scrollView = findViewById(R.id.scrollView);
        heading1 = findViewById(R.id.heading1);
        content1 = findViewById(R.id.content1);
        heading2 = findViewById(R.id.heading2);
        content2 = findViewById(R.id.content2);
        heading3 = findViewById(R.id.heading3);
        content3 = findViewById(R.id.content3);
        heading4 = findViewById(R.id.heading4);
        content4 = findViewById(R.id.content4);
        heading5 = findViewById(R.id.heading5);
        content5 = findViewById(R.id.content5);
        heading6 = findViewById(R.id.heading6);
        content6 = findViewById(R.id.content6);
        heading7 = findViewById(R.id.heading7);
        content7 = findViewById(R.id.content7);

        if (data.getHead1() != "") {
            heading1.setText(data.getHead1());
            content1.setText(data.getCon1());
        } else {
            heading1.setVisibility(View.GONE);
            content1.setVisibility(View.GONE);
        }

        if (data.getHead2() != "") {
            heading2.setText(data.getHead2());
            content2.setText(data.getCon2());
        } else {
            heading2.setVisibility(View.GONE);
            content2.setVisibility(View.GONE);
        }

        if (data.getHead3() != "") {
            heading3.setText(data.getHead3());
            content3.setText(data.getCon3());
        } else {
            heading3.setVisibility(View.GONE);
            content3.setVisibility(View.GONE);
        }

        if (data.getHead4() != "") {
            heading4.setText(data.getHead4());
            content4.setText(data.getCon4());
        } else {
            heading4.setVisibility(View.GONE);
            content4.setVisibility(View.GONE);
        }

        if (data.getHead5() != "") {
            heading5.setText(data.getHead5());
            content5.setText(data.getCon5());
        } else {
            heading5.setVisibility(View.GONE);
            content5.setVisibility(View.GONE);
        }

        if (data.getHead6() != "") {
            heading6.setText(data.getHead6());
            content6.setText(data.getCon6());
        } else {
            heading6.setVisibility(View.GONE);
            content6.setVisibility(View.GONE);
        }

        if (data.getHead7() != "") {
            heading7.setText(data.getHead7());
            content7.setText(data.getCon7());
        } else {
            heading7.setVisibility(View.GONE);
            content7.setVisibility(View.GONE);
        }


        Log.i(TAG, "Module Content Fragment Opened");
        backButton = findViewById(R.id.backButton);
        activityButton = findViewById(R.id.activityButton);
        quizButton = findViewById(R.id.quizButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Module Recycler Clicked");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Quiz Module Clicked");
                Intent intent = new Intent(getApplicationContext(), MCQActivity.class);
                intent.putExtra("Level",level);
                getApplicationContext().startActivity(intent);
            }
        });
    }
}
