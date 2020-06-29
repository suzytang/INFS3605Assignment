package com.example.infs3605assignment.ui.knowledge;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605assignment.R;

import java.util.ArrayList;

public class MCQAdapter extends RecyclerView.Adapter<MCQAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<MCQInput> inputList;

    // The following code is modified from: INFS3634 Week 4 - Simple RecyclerView Example

    // Constructor
    public MCQAdapter(Context context,ArrayList<MCQInput> inputList) {
        this.inputList = inputList;
        this.context = context;
    }

    // Inflate learn_levels and return view
    @Override
    public MCQAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mcq_cards, parent, false);
        return new MCQAdapter.MyViewHolder(v);
    }

    // Replace contents of the view with data
    @Override
    public void onBindViewHolder(MCQAdapter.MyViewHolder holder, final int position) {
        int no = position+1;
        holder.questionNumber.setText("QUESTION "+no+" OUT OF "+inputList.size());
        holder.questionText.setText(inputList.get(position).getQuestion());
        holder.userInput.setText("Your answer: "+inputList.get(position).getUserAnswer());
        holder.correctAnswer.setText("Correct answer: "+inputList.get(position).getCorrectAnswer());
        holder.feedbackText.setText(inputList.get(position).getFeedback());
        if (inputList.get(position).getScore() == 0) {
            holder.userInput.setTextColor(Color.RED);
        } else {
            holder.userInput.setTextColor(Color.GREEN);
        }
    }

    // Return size of dataset
    @Override
    public int getItemCount() {
        return inputList.size();
    }

    // Create ViewHolder for learn_levels
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView questionNumber, questionText, userInput, correctAnswer, feedbackText;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.questionNumber = itemView.findViewById(R.id.questionNumber);
            this.questionText = itemView.findViewById(R.id.questionText);
            this.userInput = itemView.findViewById(R.id.userInput);
            this.correctAnswer = itemView.findViewById(R.id.correctAnswer);
            this.feedbackText = itemView.findViewById(R.id.feedbackText);
        }
    }
}