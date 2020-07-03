package com.example.infs3605assignment.ui.achievements;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.DatabaseHelper;
import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.MyViewHolder> {

    Context mContext;
    Achievements achievements = new Achievements();
    Cursor cursor;


    public AchievementsAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.cursor = cursor;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievements_item, parent, false);
        return new MyViewHolder(v);
    }

    // Replace contents of the view with data
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if(!cursor.moveToPosition(position)){
            return;
        }

        int progress = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.PROGRESS));
        String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.NAME));

        holder.name.setText(name);
        holder.description.setText(achievements.searchAchievements(name).getDescription());
        holder.image.setImageResource(achievements.searchAchievements(name).getImage());

        holder.progressBar.setProgress(progress);

        if (progress == 100){
            holder.name.setAlpha((float) 0.3);
            holder.description.setAlpha((float) 0.3);
            holder.image.setAlpha((float) 0.3);
            holder.progressBar.setAlpha((float) 0.3);
            holder.completed.setVisibility(View.VISIBLE);
        }

        /*holder.reward.setOnClickListener(new View.OnClickListener() {
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
        });*/
    }

    // Return size of dataset
    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public void swapCursor (Cursor newCursor){
        // Deletes the cursor if it isn't null
        if (cursor != null){
            cursor.close();
        }
        // Assigns newCursor to cursor
        cursor = newCursor;

        if (newCursor != null){
            notifyDataSetChanged();
        }
    }

    // Create ViewHolder for achievements_item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image, completed;
        ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.description);
            this.image = itemView.findViewById(R.id.image);
            this.progressBar = itemView.findViewById(R.id.progressBar);
            this.completed = itemView.findViewById(R.id.completed);
        }
    }
}
