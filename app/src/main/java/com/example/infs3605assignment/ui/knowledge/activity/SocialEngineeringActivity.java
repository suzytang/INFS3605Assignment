package com.example.infs3605assignment.ui.knowledge.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605assignment.MainActivity;
import com.example.infs3605assignment.R;

import static android.content.ContentValues.TAG;
import static com.example.infs3605assignment.ui.knowledge.ModuleCategories.getCategories;

public class SocialEngineeringActivity extends AppCompatActivity {
    int level, found;
    private String feedback;
    private TextView feedbackTitle, feedbackText, moduleTitle;
    private Button button, button2, button3, giveUp, backgroundButton;
    private ImageView border, border2, border3;
    private ConstraintLayout feedbackBox;
    private boolean givenUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_engineering);
        Intent intent = getIntent();
        level = intent.getIntExtra("Level",0);
        moduleTitle = findViewById(R.id.moduleTitle);
        moduleTitle.setText(getCategories().get(level - 1).getCategoryName());
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        border = findViewById(R.id.border);
        border2 = findViewById(R.id.border2);
        border3 = findViewById(R.id.border3);
        giveUp = findViewById(R.id.giveUp);
        feedbackTitle = findViewById(R.id.feedbackTitle);
        feedbackBox = findViewById(R.id.feedbackBox);
        feedbackText = findViewById(R.id.feedbackText);
        backgroundButton = findViewById(R.id.backgroundButton);
        refresh();

        backgroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "This is not an indicator of a suspicious email.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        giveUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!givenUp) {
                    giveUp();
                    feedbackTitle.setText("Oh no! you chose to give up");
                    feedbackText.setText("The three signs were 'Dear Valued Customer' as it uses a generic greeting rather than your name, 'IMMEDIATELY' as it creates a false sense of urgency, and 'CANCEL TRANSACTION' button as it requests you to take action.");
                    giveUp.setText("Home");
                    givenUp = true;
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                found++;
                button.setEnabled(false);
                border.setVisibility(View.VISIBLE);
                if (found == 1) {
                    feedback += "Good job for noticing the cancel transaction requests you take action";
                } else if (found == 2) {
                    feedback += " and the cancel transaction requests you take action";
                }
                feedback();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                found++;
                button2.setEnabled(false);
                border2.setVisibility(View.VISIBLE);
                if (found == 1) {
                    feedback += "Good job for noticing the generic greeting rather than your name";
                } else if (found == 2) {
                    feedback += " and the generic greeting rather than your name";
                }
                feedback();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                found++;
                button3.setEnabled(false);
                border3.setVisibility(View.VISIBLE);
                if (found == 1) {
                    feedback += "Good job for noticing the sense of urgency generated in the email";
                } else if (found == 2) {
                    feedback += " and the sense of urgency generated in the email";
                }
                feedback();
            }
        });
    }
    private void feedback() {
        feedbackBox.setVisibility(View.VISIBLE);
        if (found == 3) {
            feedbackTitle.setText("Congratulations, you noticed all the signs!");
            feedbackText.setText("The three signs were 'Dear Valued Customer' as it uses a generic greeting rather than your name, 'IMMEDIATELY' as it creates a false sense of urgency and 'CANCEL TRANSACTION' button as it requests you to take action.");
            giveUp.setText("Home");
            givenUp = true;
        } else {
            feedbackTitle.setText(found+" found, "+(3-found)+" more to go!");
            feedbackText.setText(feedback);
        }
    }

    private void refresh() {
        button.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        border.setVisibility(View.INVISIBLE);
        border2.setVisibility(View.INVISIBLE);
        border3.setVisibility(View.INVISIBLE);
        found = 0;
        feedback = "";
        feedbackTitle.setText("You have not found anything yet");
        feedbackText.setText("Time to get searching!");
        givenUp = false;
    }
    private void giveUp() {
        button.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        border.setVisibility(View.VISIBLE);
        border2.setVisibility(View.VISIBLE);
        border3.setVisibility(View.VISIBLE);
    }
}