package com.example.infs3605assignment.ui.knowledge;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.infs3605assignment.DatabaseHelper;
import com.example.infs3605assignment.R;

import java.util.ArrayList;

import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collections;
import java.util.List;

public class MCQ extends Fragment {
    private static final String TAG = "MCQ";
    private TextView questionText, result, feedback;
    private TextView textViewQuestionCount;
    private RadioGroup rbGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button buttonConfirmNext;
    private List<MCQuestion> questionList;
    private int questionCounter, level, questionTotal;
    private MCQuestion currentQuestion;
    private boolean answered, last;
    private List<MCQInput> inputList;
    private Dialog dialog;
    private View root;
    DatabaseHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.removeAllViews();
        level = getArguments().getInt("Level");
        root = inflater.inflate(R.layout.fragment_m_c_q, container, false);
        // Inflate the layout for this fragment
        // Radio buttons for each question
        // Store user answers
        //Bundle args = new Bundle();
        //// Pass arraylist with MCQInput and categories
        //args.putSerializable("arraylist", answers);
        //intent2.putExtra("bundle", args);
        questionText = root.findViewById(R.id.questionText);
//        textViewScore = root.findViewById(R.id.text_view_score);
        textViewQuestionCount = root.findViewById(R.id.text_view_question_count);
//        textViewCountDown = root.findViewById(R.id.text_view_countdown);
        rbGroup = root.findViewById(R.id.radio_group);
        rb1 = root.findViewById(R.id.radio_button1);
        rb2 = root.findViewById(R.id.radio_button2);
        rb3 = root.findViewById(R.id.radio_button3);
        rb4 = root.findViewById(R.id.radio_button4);
        result = root.findViewById(R.id.result);
        feedback = root.findViewById(R.id.feedback);
        buttonConfirmNext = root.findViewById(R.id.button_confirm_next);
        dbHelper = new DatabaseHelper(getContext());
        questionList = dbHelper.getQuestions(level);
        startQuiz();

        return root;
    }

    @SuppressLint("SetTextI18n")
    private void quizFinished() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_m_c_q_dialog);
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

        // Calculate grade and set text
        double percentage = Double.valueOf(total)/Double.valueOf(inputList.size());
        score.setText(total+" OUT OF "+inputList.size());
        if (percentage < 0.5) {
            // Set text for fail
            grade.setText("Failed!");
            grade.setTextColor(Color.RED);
//            reaction.setImageResource(R.drawable.sad);
        } else if (percentage == 1) {
            // Set text for 100% in self learn
            grade.setText("Perfect!");
//            reaction.setImageResource(R.drawable.happy);
        } else {
            // Set text for pass
            grade.setText("Passed!");
            grade.setTextColor(Color.GREEN);
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
                dialog.dismiss();
            }
        });

        // Button to view results
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void showNextQuestion() {
        enableButtons(true);
        feedback.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
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
            buttonConfirmNext.setText("Confirm");
        }
    }

    private void enableButtons(boolean enable) {
        rb1.setEnabled(enable);
        rb2.setEnabled(enable);
        rb3.setEnabled(enable);
        rb4.setEnabled(enable);
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
        result.setVisibility(View.INVISIBLE);
        feedback.setVisibility(View.INVISIBLE);
        questionTotal = questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion();
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (last) {
                    quizFinished();
                }
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        MCQInput input = new MCQInput();
                        input.setQuestion(currentQuestion.getQuestion());
                        input.setFeedback(currentQuestion.getFeedback());

                        RadioButton rbSelected = root.findViewById(rbGroup.getCheckedRadioButtonId());
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
                        enableButtons(false);

                        if (questionCounter < questionTotal) {
                            buttonConfirmNext.setText("Next");
                        } else {
                            buttonConfirmNext.setText("Finish");
                            last = true;
                        }
                    } else {
                        Toast.makeText(getActivity(), "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }
}
