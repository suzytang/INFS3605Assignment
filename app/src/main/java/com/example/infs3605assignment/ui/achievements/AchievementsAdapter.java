package com.example.infs3605assignment.ui.achievements;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.R;

public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.MyViewHolder> {

    Achievements achievements = new Achievements();

    public AchievementsAdapter() {

    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievements_item, parent, false);
        return new MyViewHolder(v);
    }

    // Replace contents of the view with data
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(achievements.getAchievements().get(position).getName());
        holder.description.setText(achievements.getAchievements().get(position).getDescription());
        holder.image.setImageResource(achievements.getAchievements().get(position).getImage());
    }

    // Return size of dataset
    @Override
    public int getItemCount() {
        return achievements.getAchievements().size();
    }

    // Create ViewHolder for achievements_item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        ImageView image;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.description);
            this.image = itemView.findViewById(R.id.image);
        }
    }
}
