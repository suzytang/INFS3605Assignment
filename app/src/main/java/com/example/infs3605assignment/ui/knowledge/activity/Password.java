package com.example.infs3605assignment.ui.knowledge.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605assignment.R;
import com.google.android.material.textfield.TextInputLayout;

import static android.content.ContentValues.TAG;

public class Password extends Fragment {
    private View root;
    private EditText password;
    private Button checkButton;
    private String feedback;
    private TextView feedbackTitle, feedbackText;
    private TextInputLayout passwordLayout;
    private boolean retry;
    public Password() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.removeAllViews();
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_password, container, false);
        password = root.findViewById(R.id.passwordInput);
        passwordLayout = root.findViewById(R.id.passwordLayout);
        checkButton = root.findViewById(R.id.checkButton);
        feedbackTitle = root.findViewById(R.id.feedbackTitle);

        feedbackText = root.findViewById(R.id.feedbackText);

        retry = true;
        retry();
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable text) {
                // Calculate password strength
                calculateStrength(text.toString());
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Check Button Clicked");
                if (!retry) {
                    if (password.length()<8) {
                        Toast.makeText(getContext(), "Please enter at least 8 characters first", Toast.LENGTH_SHORT).show();
                    } else {
                        feedback();
                    }
                } else {
                    retry();
                }
            }
        });
        return root;
    }

    private void retry() {
        feedbackText.setVisibility(View.INVISIBLE);
        feedbackTitle.setVisibility(View.INVISIBLE);
        password.setText("");
        password.setEnabled(true);
        checkButton.setText("check");
        retry = false;
    }

    private void feedback() {
        feedbackText.setText(feedback);
        feedbackTitle.setVisibility(View.VISIBLE);
        feedbackText.setVisibility(View.VISIBLE);
        password.setEnabled(false);
        checkButton.setText("retry");
        retry = true;
    }

    private void calculateStrength(String passwordText) {
        int strength = 4;
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean specialChar = false;
        feedback = "To make your password stronger, you should consider:\n";

        for (int i = 0; i < passwordText.length(); i++) {
            char c = passwordText.charAt(i);

            if (!specialChar  &&  !Character.isLetterOrDigit(c)) {
                specialChar = true;
            } else {
                if (!digit  &&  Character.isDigit(c)) {
                    digit = true;
                } else {
                    if (!upper || !lower) {
                        if (Character.isUpperCase(c)) {
                            upper = true;
                        } else {
                            lower = true;
                        }
                    }
                }
            }

        }

        if (!specialChar) {
            strength--;
            feedback += " - adding special characters\n";
        }
        if (!upper) {
            strength--;
            feedback += " - using uppercase letters\n";
        }
        if (!lower) {
            strength--;
            feedback +=  " - using lowercase letters\n";
        }
        if (!digit) {
            strength--;
            feedback += " - including numbers\n";
        }

        if (passwordText.length() < 10)
        {
            feedback += " - ensuring your password is at least 10 characters\n";
            passwordLayout.setHelperText("Password Length: Insufficient");
        } else {
            Log.d(TAG, "calculateStrength: "+strength);
            switch  (strength) {
                case 1: passwordLayout.setHelperText("Password Strength: Very Weak"); break;
                case 2: passwordLayout.setHelperText("Password Strength: Weak"); break;
                case 3: passwordLayout.setHelperText("Password Strength: Medium"); break;
                case 4: passwordLayout.setHelperText("Password Strength: Strong");
                    feedback = "Good Job!\n Your password contains special characters, numbers and both uppercase and lowercase letters!";
                    break;
            }
        }

        feedback += "Though this password checker cannot verify this, make sure you are avoiding dictionary words, repeated letters and use different passwords for your accounts.\nStay safe!";

    }
}
