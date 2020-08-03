package com.example.infs3605assignment.ui.knowledge.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infs3605assignment.MainActivity;
import com.example.infs3605assignment.R;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.infs3605assignment.ui.knowledge.ModuleCategories.getCategories;
import static com.example.infs3605assignment.ui.knowledge.activity.TrueFalse.getQuestions;

public class TrueFalseActivity extends AppCompatActivity {

    private static final String TAG = "TrueFalse";
    private ConstraintLayout questionBox, feedbackBox;
    private TextView questionText, result, feedback, moduleTitle, textViewQuestionCount;
    private ImageView screenshot;
    private ImageButton nextButton, correctButton, incorrectButton;
    private int questionCounter, level, questionTotal;
    private TrueFalse currentQuestion, input;
    private boolean answered, last;
    private ArrayList<TrueFalse> questionList;
    private ArrayList<TrueFalse> inputList;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);
        Intent intent = getIntent();
        level = intent.getIntExtra("Level", 0);
        questionList = getQuestions(level);
        // Inflate the layout for this fragment
        // Radio buttons for each question
        // Store user answers
        //Bundle args = new Bundle();
        //// Pass arraylist with MCQInput and categories
        //args.putSerializable("arraylist", answers);
        //intent2.putExtra("bundle", args);
        questionBox = findViewById(R.id.questionBox);
        questionText = findViewById(R.id.questionText);
//        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.questionNo);
        feedbackBox = findViewById(R.id.feedbackBox);
//        textViewCountDown = findViewById(R.id.text_view_countdown);
        result = findViewById(R.id.feedbackTitle);
        feedback = findViewById(R.id.feedbackText);
        moduleTitle = findViewById(R.id.moduleTitle);
        moduleTitle.setText(getCategories().get(level - 1).getCategoryName());
        if (level == 4) {
            questionText.setText("Is this site safe to browse?");
        }
        if (level == 5) {
            questionText.setText("Is this app safe to install?");
        }
        nextButton = findViewById(R.id.imageButton);
        correctButton = findViewById(R.id.correctButton);
        incorrectButton = findViewById(R.id.incorrectButton);
        screenshot = findViewById(R.id.screenshot);
        startTrueFalse();
    }

    private void quizFinished() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.fragment_m_c_q_dialog);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHI‌​ND);
        feedbackBox.setVisibility(View.INVISIBLE);
        questionBox.setVisibility(View.INVISIBLE);
        // Link to XMl
        TextView grade = dialog.findViewById(R.id.grade);
        TextView score = dialog.findViewById(R.id.score);
        TextView commentText = dialog.findViewById(R.id.commentText);
        ImageView reaction = dialog.findViewById(R.id.reaction);
        Button modulesButton = dialog.findViewById(R.id.modulesButton);
        Button retryButton = dialog.findViewById(R.id.retryButton);
        Button resultButton = dialog.findViewById(R.id.resultButton);

        // Initalise variables
        int total = 0;

        // Calculate total score and coins earned
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).getUser() == 1) {
                total++;
            }
        }
        // Calculate grade and set text
        double percentage = Double.valueOf(total) / Double.valueOf(inputList.size());
        score.setText("You scored " + total + " out of " + inputList.size());

        if (percentage < 0.5) {
            // Set text for fail
            grade.setText("Failed");
            grade.setTextColor(Color.RED);
            reaction.setImageResource(R.drawable.sad);
            commentText.setText("Don't give up, revise and you'll pass in no time!");
        } else if (percentage == 1) {
            // Set text for 100% in self learn
            grade.setText("Perfect!");
            reaction.setImageResource(R.drawable.trophy);
            commentText.setText("Good job, you aced the quiz!");
        } else {
            // Set text for pass
            grade.setText("Passed");
            grade.setTextColor(Color.GREEN);
            commentText.setText("Congratulations!");
            reaction.setImageResource(R.drawable.happy);
        }

        // Button to retry
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTrueFalse();
                dialog.dismiss();
            }
        });

        // Button to go back to modules
        modulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Module Recycler Clicked");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        resultButton.setVisibility(View.GONE);

//        // Button to view results
//        resultButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "Result Clicked");
//                Intent intent = new Intent(getApplicationContext(), MCQResults.class);
//                Bundle args = new Bundle();
//                intent.putExtra("bundle", args);
//                intent.putExtra("Level", level);
//                intent.putExtra("Activity","TrueFalse");
//                args.putSerializable("Input", inputList);
//                startActivity(intent);
//            }
//        });
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    private void startTrueFalse() {
        inputList = new ArrayList<>();
        questionCounter = 0;
        last = false;
        feedbackBox.setVisibility(View.VISIBLE);
        questionBox.setVisibility(View.VISIBLE);
        questionBox.setAlpha((float) 1);
        questionTotal = questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (last) {
                    quizFinished();
                } else {
                    showNextQuestion();
                }
                if (questionCounter == questionTotal) {
                    last = true;
                }
            }
        });

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableButtons(false);
                input = currentQuestion;
                if (currentQuestion.isAnswer()) {
                    input.setUser(1);
                } else {
                    input.setUser(0);
                }
                inputList.add(input);
                feedback();
            }
        });
        incorrectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableButtons(false);
                input = currentQuestion;
                if (currentQuestion.isAnswer()) {
                    input.setUser(0);
                } else {
                    input.setUser(1);
                }
                inputList.add(input);
                feedback();
            }
        });
    }

    private void feedback() {
        enableButtons(false);
        questionBox.setAlpha((float) 0.5);
        feedbackBox.setVisibility(View.VISIBLE);
        if (input.getUser()==1) {
            result.setText("Correct!");
        } else {
            result.setText("Incorrect!");
        }
    }

    private void showNextQuestion() {
        enableButtons(true);
        feedbackBox.setVisibility(View.INVISIBLE);
        questionBox.setAlpha((float) 1);
        if (questionCounter < questionTotal) {
            currentQuestion = questionList.get(questionCounter);
            feedback.setText(currentQuestion.getFeedback());
            screenshot.setImageResource(currentQuestion.getImage());
            questionCounter++;
            textViewQuestionCount.setText("Question " + questionCounter + " OUT OF " + questionTotal);
            answered = false;
        }
    }

    private void enableButtons(boolean enable) {
        correctButton.setEnabled(enable);
        incorrectButton.setEnabled(enable);
        if (enable) {
            correctButton.setAlpha((float) 1);
            incorrectButton.setAlpha((float) 1);
        } else {
            correctButton.setAlpha((float) 0.5);
            incorrectButton.setAlpha((float) 0.5);
        }
    }
}