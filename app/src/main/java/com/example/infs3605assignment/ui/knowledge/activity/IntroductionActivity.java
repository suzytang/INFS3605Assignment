package com.example.infs3605assignment.ui.knowledge.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.infs3605assignment.R;

import static com.example.infs3605assignment.ui.knowledge.ModuleCategories.getCategories;

public class IntroductionActivity extends AppCompatActivity {
    int level;
    TextView activityExplanation, moduleTitle;
    Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        Intent intent = getIntent();
        level = intent.getIntExtra("Level",0);
        moduleTitle = findViewById(R.id.moduleTitle);
        moduleTitle.setText(getCategories().get(level - 1).getCategoryName());
        startButton = findViewById(R.id.startButton);
        activityExplanation = findViewById(R.id.activityExplanation);
        if (level == 1) {
            activityExplanation.setText("\nThis activity involves checking whether you have been a victim of a cyberattack.\n\nClick the link below and follow the instructions to find out.\n\nYour results may surprise you!");
            startButton.setText("Check");
        }
        if (level == 2) {
            activityExplanation.setText("\nThis activity involves looking at an example of a phishing email.\n\nLook at the email and tap the parts which indicates that it is a phishing email.");
            startButton.setText("Start");
        }
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://haveibeenpwned.com/")));
                }
                if (level == 2) {
                    Intent intent3 = new Intent(getApplicationContext(), SocialEngineeringActivity.class);
                    intent3.putExtra("Level",level);
                    startActivity(intent3);
                }
            }
        });
    }


}