package com.example.infs3605assignment.ui.knowledge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class MCQAdapter extends RecyclerView.Adapter<MCQAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<MCQInput> answers;

    // The following code is modified from: INFS3634 Week 4 - Simple RecyclerView Example

    // Constructor
    public MCQAdapter(Context context,ArrayList<MCQInput> answers) {
        this.answers = answers;
        this.context = context;
    }

    // Inflate learn_levels and return view
    @Override
    public MCQAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_cards, parent, false);
        return new MCQAdapter.MyViewHolder(v);
    }

    // Replace contents of the view with data
    @Override
    public void onBindViewHolder(MCQAdapter.MyViewHolder holder, final int position) {
//        holder.levelText.setText(categories.get(position).getCategoryName());
//        holder.categoryImage.setImageResource(categories.get(position).getImage());
//
//        // On click buttons start respective activities and passes on the category
//        holder.learn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, LearnFlashcards.class);
//                intent.putExtra("category",categories.get(position).getLevel());
//                mContext.startActivity(intent);
//            }
//        });
//        holder.practice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, Practice.class);
//                intent.putExtra("category",categories.get(position).getLevel());
//                mContext.startActivity(intent);
//            }
//        });
//
//        holder.quiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, QuizTest.class);
//                intent.putExtra("category", categories.get(position).getLevel());
//                mContext.startActivity(intent);
//            }
//        });
    }

    // Return size of dataset
    @Override
    public int getItemCount() {
        return answers.size();
    }

    // Create ViewHolder for learn_levels
    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView levelText;
//        Button quiz;
//        Button learn;
//        Button practice;
//        ImageView categoryImage;


        public MyViewHolder(View itemView) {
            super(itemView);

//            this.levelText = itemView.findViewById(R.id.category);
//            this.quiz = itemView.findViewById(R.id.storeButton);
//            this.learn = itemView.findViewById(R.id.learn);
//            this.practice = itemView.findViewById(R.id.practice);
//            this.categoryImage = itemView.findViewById(R.id.categoryImage);
        }
    }
}