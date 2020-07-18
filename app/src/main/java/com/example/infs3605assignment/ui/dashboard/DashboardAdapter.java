package com.example.infs3605assignment.ui.dashboard;

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
import com.example.infs3605assignment.ui.achievements.Achievements;
import com.example.infs3605assignment.ui.knowledge.ModuleCategories;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<ModuleCategories> categories;
    Cursor cursor;


    public DashboardAdapter(Context context, Cursor cursor, ArrayList<ModuleCategories> categories) {
        this.mContext = context;
        this.cursor = cursor;
        this.categories = categories;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_item, parent, false);
        return new MyViewHolder(v);
    }

    // Replace contents of the view with data
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if(!cursor.moveToPosition(position)){
            return;
        }
        int highScore = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.HIGHSCORE));

        holder.name.setText(categories.get(position).getCategoryName());
        holder.highScore.setText(Integer.toString(highScore));
        holder.image.setImageResource(categories.get(position).getImage());
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

    // Create ViewHolder for dashboard_item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, highScore;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.name);
            this.highScore = itemView.findViewById(R.id.highScore);
            this.image = itemView.findViewById(R.id.image);

        }
    }
}
