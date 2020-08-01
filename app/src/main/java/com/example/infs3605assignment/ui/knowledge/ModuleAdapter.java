package com.example.infs3605assignment.ui.knowledge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.MainActivity;
import com.example.infs3605assignment.R;
import com.example.infs3605assignment.ui.knowledge.activity.PasswordActivity;
import com.example.infs3605assignment.ui.knowledge.activity.TrueFalseActivity;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ModuleCategories> categories;

    // The following code is modified from: INFS3634 Week 4 - Simple RecyclerView Example

    // Constructor
    public ModuleAdapter(Context context,ArrayList<ModuleCategories> categories) {
        this.categories = categories;
        this.context = context;
    }

    // Inflate learn_levels and return view
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_cards, parent, false);
        return new MyViewHolder(v);
    }

    // Replace contents of the view with data
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.moduleName.setText(categories.get(position).getCategoryName());
        holder.moduleImage.setImageResource(categories.get(position).getImage());
        // On click buttons start respective activities and passes on the category
        holder.learnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Learn Module "+position+1+" Clicked");
                Intent intent = new Intent(context, LearnActivity.class);
                intent.putExtra("Level",position+1);
                context.startActivity(intent);
            }
        });
        holder.activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Activity Module "+position+1+" Clicked");
                // Create fragment and give it an argument specifying the article it should show

                Bundle args = new Bundle();
                args.putInt("Level", position+1);
                switch (position + 1) {
                    case 3: Intent intent = new Intent(context, PasswordActivity.class);
                        intent.putExtra("Level",position+1);
                        context.startActivity(intent);; break;
                    case 1:
                        context.startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://haveibeenpwned.com/")));
                        break;
//                    case 2: break;
                    case 4:
                    case 5: Intent intent2 = new Intent(context, TrueFalseActivity.class);
                        intent2.putExtra("Level",position+1);
                        context.startActivity(intent2);
                        break;
                }
            }
        });

        holder.quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Quiz Module "+position+1+" Clicked");
                Intent intent = new Intent(context, MCQActivity.class);
                intent.putExtra("Level",position+1);
                context.startActivity(intent);
            }
        });
    }

    // Return size of dataset
    @Override
    public int getItemCount() {
        return categories.size();
    }

    // Create ViewHolder for learn_levels
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView moduleName;
        Button learnButton;
        Button activityButton;
        Button quizButton;
        ImageView moduleImage;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.moduleName = itemView.findViewById(R.id.moduleName);
            this.learnButton = itemView.findViewById(R.id.learnButton);
            this.activityButton = itemView.findViewById(R.id.activityButton);
            this.quizButton = itemView.findViewById(R.id.quizButton);
            this.moduleImage = itemView.findViewById(R.id.moduleImage);
        }
    }
}
