package com.example.infs3605assignment.ui.achievements;

import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class Achievements {

    private String name;
    private String description;
    private int image;

    public Achievements(){

    }

    public Achievements(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static ArrayList<Achievements> getAchievements() {
        ArrayList<Achievements> achievements = new ArrayList<>();
        achievements.add(new Achievements("Champ", "Achieved 100% in 5 quizzes", R.drawable.brain));
        achievements.add(new Achievements("Test", "Testing", R.drawable.brain));
        achievements.add(new Achievements("Test", "Testing", R.drawable.brain));
        achievements.add(new Achievements("Test", "Testing", R.drawable.brain));
        achievements.add(new Achievements("Test", "Testing", R.drawable.brain));

        return achievements;

    }

    public static Achievements searchAchievements(String search) {
        ArrayList<Achievements> achievements = Achievements.getAchievements();
        int i;
        for (i = 0; i <  achievements.size(); i++){
            if (getAchievements().get(i).name.contains(search)) {
                return achievements.get(i);
            }
        }
        return null;
    }

}
