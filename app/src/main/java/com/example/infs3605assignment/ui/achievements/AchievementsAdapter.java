package com.example.infs3605assignment.ui.achievements;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Achievements> achievements;


    public AchievementsAdapter(Context context,ArrayList<Achievements> achievements) {
        this.mContext = context;
        this.achievements = achievements;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievements_item, parent, false);
        return new MyViewHolder(v);
    }

    // Replace contents of the view with data
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(achievements.get(position).getName());
        holder.description.setText(achievements.get(position).getDescription());
        holder.image.setImageResource(achievements.get(position).getImage());
        holder.progressBar.setProgress(achievements.get(position).getProgress());

        if (achievements.get(position).getProgress() == 100){
            holder.description.setVisibility(View.INVISIBLE);
            holder.progressBar.setVisibility(View.INVISIBLE);
            holder.reward.setVisibility(View.VISIBLE);
        }

        holder.reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.dialog_reward);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                TextView text = (TextView) dialog.findViewById(R.id.text);
                Button closeButton = (Button) dialog.findViewById(R.id.closeButton);

                text.setText("You earned");

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // update currency
                        // mark as collected? move achievements to the bottom
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    // Return size of dataset
    @Override
    public int getItemCount() {
        return achievements.size();
    }

    // Create ViewHolder for achievements_item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        ImageView image;
        ProgressBar progressBar;
        Button reward;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.description);
            this.image = itemView.findViewById(R.id.image);
            this.progressBar = itemView.findViewById(R.id.progressBar);
            this.reward = itemView.findViewById(R.id.reward);

        }
    }
}
