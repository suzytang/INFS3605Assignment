package com.example.infs3605assignment.ui.knowledge;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.infs3605assignment.DatabaseHelper;
import com.example.infs3605assignment.MainActivity;
import com.example.infs3605assignment.R;

import static android.content.ContentValues.TAG;

public class ModuleContent extends Fragment {
    private ScrollView scrollView;
    private TextView heading1, content1, heading2, content2, heading3, content3, heading4, content4,
    heading5, heading6, heading7, content5, content6, content7;
    private Button backButton, activityButton, quizButton;
    private int level;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate view with recycler module fragment
        container.removeAllViews();
        level = getArguments().getInt("Level");
        View root = inflater.inflate(R.layout.fragment_module_content, container, false);
        ModuleData data = ModuleData.getData().get(level - 1);

        scrollView = root.findViewById(R.id.scrollView);
        heading1 = root.findViewById(R.id.heading1);
        content1 = root.findViewById(R.id.content1);
        heading2 = root.findViewById(R.id.heading2);
        content2 = root.findViewById(R.id.content2);
        heading3 = root.findViewById(R.id.heading3);
        content3 = root.findViewById(R.id.content3);
        heading4 = root.findViewById(R.id.heading4);
        content4 = root.findViewById(R.id.content4);
        heading5 = root.findViewById(R.id.heading5);
        content5 = root.findViewById(R.id.content5);
        heading6 = root.findViewById(R.id.heading6);
        content6 = root.findViewById(R.id.content6);
        heading7 = root.findViewById(R.id.heading7);
        content7 = root.findViewById(R.id.content7);

        if (data.getHead1() != "") {
            heading1.setText(data.getHead1());
            content1.setText(data.getCon1());
        } else {
            heading1.setVisibility(View.GONE);
            content1.setVisibility(View.GONE);
        }

        if (data.getHead2() != "") {
            heading2.setText(data.getHead2());
            content2.setText(data.getCon2());
        } else {
            heading2.setVisibility(View.GONE);
            content2.setVisibility(View.GONE);
        }

        if (data.getHead3() != "") {
            heading3.setText(data.getHead3());
            content3.setText(data.getCon3());
        } else {
            heading3.setVisibility(View.GONE);
            content3.setVisibility(View.GONE);
        }

        if (data.getHead4() != "") {
            heading4.setText(data.getHead4());
            content4.setText(data.getCon4());
        } else {
            heading4.setVisibility(View.GONE);
            content4.setVisibility(View.GONE);
        }

        if (data.getHead5() != "") {
            heading5.setText(data.getHead5());
            content5.setText(data.getCon5());
        } else {
            heading5.setVisibility(View.GONE);
            content5.setVisibility(View.GONE);
        }

        if (data.getHead6() != "") {
            heading6.setText(data.getHead6());
            content6.setText(data.getCon6());
        } else {
            heading6.setVisibility(View.GONE);
            content6.setVisibility(View.GONE);
        }

        if (data.getHead7() != "") {
            heading7.setText(data.getHead7());
            content7.setText(data.getCon7());
        } else {
            heading7.setVisibility(View.GONE);
            content7.setVisibility(View.GONE);
        }


        Log.i(TAG, "Module Content Fragment Opened");
        backButton = root.findViewById(R.id.backButton);
        activityButton = root.findViewById(R.id.activityButton);
        quizButton = root.findViewById(R.id.quizButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Module Recycler Clicked");
                // Create fragment and give it an argument specifying the article it should show
                Fragment newFragment = new ModuleRecycler();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.contentFrag, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        });
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Quiz Module Clicked");
                // Create fragment and give it an argument specifying the article it should show
                Fragment newFragment = new MCQ();
                Bundle args = new Bundle();
                args.putInt("Level", level);
                newFragment.setArguments(args);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.contentFrag, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        });

        return root;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
