package com.example.infs3605assignment.ui.knowledge.activity;

import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class TrueFalse {
//        categories.add(new ModuleCategories(1, "Cyber Attacks", R.drawable.cyberattack));
//        categories.add(new ModuleCategories(2, "Social Engineering", R.drawable.socialengineering));
//        categories.add(new ModuleCategories(3, "Password Security",R.drawable.password));
//        categories.add(new ModuleCategories(4, "Untrusted Sites",R.drawable.untrustedsites));
//        categories.add(new ModuleCategories(5, "Mobile Practices",R.drawable.mobilepractices));
//        categories.add(new ModuleCategories(6, "Physical Security",R.drawable.physicalsecurity));

    private int level;
    private int image;
    private boolean answer;
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public TrueFalse(int level, int image, boolean answer, int user, String feedback) {
        this.level = level;
        this.image = image;
        this.answer = answer;
        this.user = user;
        this.feedback = feedback;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    private int user;

    public boolean isAnswer() {
        return answer;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static ArrayList<TrueFalse> createQuestions() {
        ArrayList<TrueFalse> questions = new ArrayList<>();
        questions.add(new TrueFalse(4, R.drawable.untrustedsites,true,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(4, R.drawable.untrustedsites,true,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(4, R.drawable.untrustedsites,false,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(4, R.drawable.untrustedsites,false,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(5, R.drawable.untrustedsites,true,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(5, R.drawable.untrustedsites,true,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(5, R.drawable.untrustedsites,false,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(5, R.drawable.untrustedsites,false,0,"Add feedback text here to explain why it is true or false."));
        return questions;
    }

    public static ArrayList<TrueFalse> getQuestions(int level) {
        ArrayList<TrueFalse> allQuestions = createQuestions();
        ArrayList<TrueFalse> questions = new ArrayList<>();
        for (int i = 0; i < allQuestions.size(); i++) {
            if (allQuestions.get(i).getLevel() == level) {
                questions.add(allQuestions.get(i));
            }
        }
        return questions;
    }
}
