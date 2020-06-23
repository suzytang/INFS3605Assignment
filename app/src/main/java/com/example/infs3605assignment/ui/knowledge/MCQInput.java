package com.example.infs3605assignment.ui.knowledge;

public class MCQInput {
    private int question;
    private  int userAnswer;
    private int correctAnswer;

    public MCQInput(int question, int userAnswer, int correctAnswer) {
        this.question = question;
        this.userAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
