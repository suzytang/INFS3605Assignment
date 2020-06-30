package com.example.infs3605assignment.ui.knowledge;

import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class ModuleCategories {
    private int level;
    private String categoryName;
    private int image;
//    private int image;

//    public ModuleCategories(int level, String categoryName, int image) {
//        this.level = level;
//        this.categoryName = categoryName;
//        this.image = image;
//    }
    public ModuleCategories(int level, String categoryName, int image) {
        this.level = level;
        this.categoryName = categoryName;
        this.image = image;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static ArrayList<ModuleCategories> getCategories() {
        ArrayList<ModuleCategories> categories = new ArrayList<>();
        categories.add(new ModuleCategories(1, "Cyber Attacks", R.drawable.cyberattack));
        categories.add(new ModuleCategories(2, "Social Engineering", R.drawable.socialengineering));
        categories.add(new ModuleCategories(3, "Password Security",R.drawable.password));
        categories.add(new ModuleCategories(4, "Untrusted Sites",R.drawable.untrustedsites));
        return categories;
    }
}
