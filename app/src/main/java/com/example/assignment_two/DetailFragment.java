package com.example.assignment_two;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView taskTitle = view.findViewById(R.id.taskTitle);
        TextView taskDetails = view.findViewById(R.id.taskDetails);

        Bundle bundle = getArguments();
        if (bundle != null) {
            taskTitle.setText(bundle.getString("title"));
            taskDetails.setText(bundle.getString("details"));
        } else {
            taskTitle.setText("No task selected");
            taskDetails.setText("");
        }

        return view;
    }
}