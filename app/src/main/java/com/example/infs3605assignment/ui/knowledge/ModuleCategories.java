package com.example.infs3605assignment.ui.knowledge;

import java.util.ArrayList;

public class ModuleCategories {
    private int level;
    private String categoryName;
//    private int image;

//    public ModuleCategories(int level, String categoryName, int image) {
//        this.level = level;
//        this.categoryName = categoryName;
//        this.image = image;
//    }
    public ModuleCategories(int level, String categoryName) {
        this.level = level;
        this.categoryName = categoryName;
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

//    public int getImage() {
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }

    public static ArrayList<ModuleCategories> getCategories() {
        ArrayList<ModuleCategories> categories = new ArrayList<>();
        categories.add(new ModuleCategories(1, "Module 1"));
        categories.add(new ModuleCategories(2, "Module 2"));
        categories.add(new ModuleCategories(3, "Module 3"));
        return categories;
    }
}
