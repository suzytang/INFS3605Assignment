package com.example.infs3605assignment.ui.knowledge;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.infs3605assignment.DatabaseHelper;
import com.example.infs3605assignment.MainActivity;
import com.example.infs3605assignment.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static com.example.infs3605assignment.ui.knowledge.ModuleCategories.getCategories;

public class MCQActivity extends AppCompatActivity {
    private static final String TAG = "MCQ";
    private ConstraintLayout questionBox, feedbackBox;
    private TextView questionText, result, feedback, moduleTitle, textViewQuestionCount;
    private RadioGroup rbGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button confirmButton;
    private ImageButton nextButton;
    private List<MCQuestion> questionList;
    private int questionCounter, level, questionTotal;
    private MCQuestion currentQuestion;
    private boolean answered, last;
    private ArrayList<MCQInput> inputList;
    private Dialog dialog;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_c_q);
        Intent intent = getIntent();
        level = intent.getIntExtra("Level",0);
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
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        result = findViewById(R.id.result);
        feedback = findViewById(R.id.feedback);
        moduleTitle = findViewById(R.id.moduleTitle);
        moduleTitle.setText(getCategories().get(level-1).getCategoryName());
        confirmButton = findViewById(R.id.confirmButton);
        nextButton = findViewById(R.id.imageButton);
        dbHelper = new DatabaseHelper(getApplicationContext());

        questionList = dbHelper.getQuestions(level);

        dbHelper.setTime(System.currentTimeMillis(), level);
        startQuiz();
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
            if (inputList.get(i).getScore() == 1) {
                total++;

            }
        }
        // set high score for quiz in database
        dbHelper.setHighScore(total, level);

        // Calculate grade and set text
        double percentage = Double.valueOf(total) / Double.valueOf(inputList.size());
        score.setText("You scored "+total + " out of " + inputList.size());

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
            // set progress for Champ and Master achievements if the quiz has not been completed to 100% before
            if (dbHelper.checkQuiz("COMPLETED",level)) {
                commentText.setText("Set Completed");
            } else {
                dbHelper.setProgress("Champ", 34);
                dbHelper.setProgress("Master", 17);
                // set progress for Scholar achievement if the quiz has not been completed to 100% before and was finished in less than 2 mins
                calculateScholar();
                calculateWeekend();
                dbHelper.setQuiz("COMPLETED", level);
                dbHelper.setQuiz("PASS", level);
            }
            commentText.setText("Good job, you aced the quiz!");
        } else {
            // Set text for pass
            grade.setText("Passed");
            grade.setTextColor(Color.GREEN);
            commentText.setText("Congratulations!");
            reaction.setImageResource(R.drawable.happy);
            // set Progress for Conqueror achievement if quiz hasn't been passed before
            if(dbHelper.checkQuiz("PASS", level) == false){
                dbHelper.setProgress("Conqueror", 17);
            }
            // update database to pass
            dbHelper.setQuiz("PASS", level);
            // set progress for Scholar achievement if the quiz has not been completed to 100% before and was finished in less than 2 mins
            calculateScholar();
            calculateWeekend();
//            reaction.setImageResource(R.drawable.happy);
        }

        // Button to retry
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
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

        // Button to view results
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Result Clicked");
                Intent intent = new Intent(getApplicationContext(), MCQResults.class);
                Bundle args = new Bundle();
                intent.putExtra("bundle", args);
                intent.putExtra("Level", level);
                args.putSerializable("MCQInput",inputList);
                startActivity(intent);
            }
        });
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    // calculate time for Scholar achievement
    private void calculateScholar(){
        long start = dbHelper.getTime(level);
        long end = System.currentTimeMillis();
        if (end - start <= 120000 && dbHelper.checkQuiz("COMPLETED", level) == false){
            dbHelper.setProgress("Scholar", 100);
        }
    }

    public void calculateWeekend(){
        // calculate day and set progress for Weekend Winner achievement
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_WEEK);

        // checks that it is a weekend, the quiz hasn't been completed before (100%) and a quiz hasn't been completed on the weekend day
        if (today == Calendar.SATURDAY && dbHelper.checkQuiz("COMPLETED", level) == false && dbHelper.checkDay("Saturday") == false){
            dbHelper.setProgress("Weekend Winner", 50);
            dbHelper.setDay("Saturday", level);
        } else if (today == Calendar.SUNDAY && dbHelper.checkQuiz("COMPLETED", level) == false && dbHelper.checkDay("Sunday") == false){
            dbHelper.setProgress("Weekend Winner", 50);
            dbHelper.setDay("Sunday", level);
        }
    }

    private void showNextQuestion() {
        enableButtons(true);
        feedbackBox.setVisibility(View.INVISIBLE);
        feedback.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        questionBox.setAlpha((float) 1);
        colourText(Color.BLACK);
        rbGroup.clearCheck();
        if (questionCounter < questionTotal) {
            currentQuestion = questionList.get(questionCounter);
            questionText.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            questionCounter++;
            textViewQuestionCount.setText("Question " + questionCounter + " OUT OF " + questionTotal);
            answered = false;
            confirmButton.setText("Confirm");
        }
    }

    private void enableButtons(boolean enable) {
        rb1.setEnabled(enable);
        rb2.setEnabled(enable);
        rb3.setEnabled(enable);
        rb4.setEnabled(enable);
        confirmButton.setEnabled(enable);
    }

    private void colourText(int colour) {
        rb1.setTextColor(colour);
        rb2.setTextColor(colour);
        rb3.setTextColor(colour);
        rb4.setTextColor(colour);
    }

    private void startQuiz() {
        inputList = new ArrayList<>();
        questionCounter = 0;
        last = false;
        feedbackBox.setVisibility(View.VISIBLE);
        questionBox.setVisibility(View.VISIBLE);
        result.setVisibility(View.INVISIBLE);
        feedback.setVisibility(View.INVISIBLE);
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

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        MCQInput input = new MCQInput();
                        input.setQuestion(currentQuestion.getQuestion());
                        Log.v(TAG, "input question set: "+currentQuestion.getQuestion());
                        input.setFeedback(currentQuestion.getFeedback());
                        Log.v(TAG, "input feedback set: "+currentQuestion.getFeedback());

                        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
                        int answer = rbGroup.indexOfChild(rbSelected) + 1;
                        if (answer == currentQuestion.getAnswer()) {
                            dbHelper.setAnswered(level, currentQuestion.getNumber());
                            Log.v(TAG, "answered: "+currentQuestion.getQuestion());
                            result.setText("Correct!");
                            input.setScore(1);
                        } else {
                            result.setText("Incorrect!");
                            input.setScore(0);
                        }

                        if (rb1.isChecked()) {
                            input.setUserAnswer((String) rb1.getText());
                            Log.v(TAG, "user answer: "+input.getUserAnswer());
                        } else if (rb2.isChecked()) {
                            input.setUserAnswer((String) rb2.getText());
                            Log.v(TAG, "user answer: "+input.getUserAnswer());
                        } else if (rb3.isChecked()) {
                            input.setUserAnswer((String) rb3.getText());
                            Log.v(TAG, "user answer: "+input.getUserAnswer());
                        } else if (rb4.isChecked()) {
                            input.setUserAnswer((String) rb4.getText());
                            Log.v(TAG, "user answer: "+input.getUserAnswer());
                        }

                        answered = true;

                        colourText(Color.RED);
                        switch (currentQuestion.getAnswer()) {
                            case 1:
                                rb1.setTextColor(Color.GREEN);
                                input.setCorrectAnswer((String) rb1.getText());
                                Log.v(TAG, "correct answer: "+input.getCorrectAnswer());
                                break;
                            case 2:
                                rb2.setTextColor(Color.GREEN);
                                input.setCorrectAnswer((String) rb2.getText());
                                Log.v(TAG, "correct answer: "+input.getCorrectAnswer());
                                break;
                            case 3:
                                rb3.setTextColor(Color.GREEN);
                                input.setCorrectAnswer((String) rb3.getText());
                                Log.v(TAG, "correct answer: "+input.getCorrectAnswer());
                                break;
                            case 4:
                                rb4.setTextColor(Color.GREEN);
                                input.setCorrectAnswer((String) rb4.getText());
                                Log.v(TAG, "correct answer: "+input.getCorrectAnswer());
                                break;
                        }

                        inputList.add(input);
                        feedback.setText(currentQuestion.getFeedback());
                        result.setVisibility(View.VISIBLE);
                        feedback.setVisibility(View.VISIBLE);
                        feedbackBox.setVisibility(View.VISIBLE);
                        questionBox.setAlpha((float) 0.5);
                        enableButtons(false);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                }
            }
        });
    }

    /*private void AchievementsDialog(String achievement){
        final Dialog dialog = new Dialog (this);
        dialog.setContentView(R.layout.dialog_reward);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        TextView text = (TextView) dialog.findViewById(R.id.text);
        Button closeButton=(Button)dialog.findViewById(R.id.closeButton);

        text.setText("You have unlocked the " +achievement+ " achievement!");

        closeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.dismiss();
            }
        });
    }*/
}