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
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public TrueFalse(int level, String question, int image, boolean answer, int user, String feedback) {
        this.level = level;
        this.question = question;
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
        questions.add(new TrueFalse(5,"Are these applications legitimate?",R.drawable.mpa1,false,0,"Above are examples of fake applications, that masks itself as a legitimate flashlight service.\nWhen the application is downloaded, the malware activates, by first scanning through what applications are installed on the device and attempts to connect with them through initiating a service which allows it to perform long-term operations in the background. Once connected, the service will attempt to trick the user into giving the application admin rights by pretending to be a Play Store notification.\nHence, Pay attention to the permissions an app request. If a flashlight app requests access to your contacts, photos and media files, this is definitely a warning sign."));
        questions.add(new TrueFalse(5,"Am I allowed to do on-line banking on my phone?",R.drawable.mpa6,true,0,"Most large banks have a mobile application for users to conveniently perform online banking transactions. Make sure that these applications are sourced from the actual website, so that it ensures its legitimacy. Also, remember to check user reviews. Verified mobile banking applications should have millions of downloads, and up to hundred thousands of reviews. However, if you are still unsure, consult your bank to double check.\nAlso, remember to use two-factor authentication if your bank offers it as an option."));
        questions.add(new TrueFalse(5,"Is it safe to install an APK installer?",R.drawable.mpa2,false,0,"Definitely not. Hackers can get into APK files, modify it easily by just by adding an extra app permission. This will give them access to your device, where they can easily steal information from you. APK files might contain malicious software that harm your device, compromising your phone security and steal your personal information."));
        questions.add(new TrueFalse(5,"Are these applications legitimate?",R.drawable.mpa3,false,0,"Thousands of apps use the branding of well-known retailers to attempt to trick users into entering their bank details, which opens them up to potential financial fraud. Fake applications contain malware that can steal personal information or lock the device until the user pays a ransom. Others encourage users to log in using their Facebook or Gmail credentials, potentially exposing sensitive personal information.\nHence, never sign into applications from another account, do not enter banking details onto an application unless it is the verified online banking application."));
        questions.add(new TrueFalse(5,"Are free money earning applications real?",R.drawable.mpa4,false,0,"Sometimes when things look too good to be true, it probably is.\nFake money earning applications require users to enter their bank details. Remember to never enter these details unless it is a verified application."));
        questions.add(new TrueFalse(5,"Backing up contacts on an app seems like a good idea. Am I right?",R.drawable.mpa5,false,0,"Back up contacts on a SIM. Never confirm access for a third-party application to view your stored contact list."));
        questions.add(new TrueFalse(4,"Question here", R.drawable.untrustedsites,true,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(4, "Question here", R.drawable.untrustedsites,true,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(4,"Question here",  R.drawable.untrustedsites,false,0,"Add feedback text here to explain why it is true or false."));
        questions.add(new TrueFalse(4, "Question here", R.drawable.untrustedsites,false,0,"Add feedback text here to explain why it is true or false."));
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
