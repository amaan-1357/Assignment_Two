package com.example.assignment_two;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private final ArrayList<Task> taskList;

    public TaskAdapter(@NonNull Context context, @NonNull ArrayList<Task> taskList) {
        super(context, 0, taskList);
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Task task = getItem(position);

        // Inflate different layout depending on whether the task is completed
        if (task.isCompleted()) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_item_completed_design, parent, false);
            TextView completedTaskTitle = convertView.findViewById(R.id.completedTaskTitle);
            TextView completedTaskDetails = convertView.findViewById(R.id.completedTaskDetails);
            completedTaskTitle.setText(task.getTitle());
            completedTaskDetails.setText(task.getDetails());
        } else {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_item_design, parent, false);
            }

            CheckBox taskCheckbox = convertView.findViewById(R.id.taskCheckbox);
            TextView taskTitle = convertView.findViewById(R.id.taskTitle);
            TextView taskDetails = convertView.findViewById(R.id.taskDetails);
            taskTitle.setText(task.getTitle());
            taskDetails.setText(task.getDetails());
            taskCheckbox.setChecked(task.isCompleted());

            // Handle checkbox click
            taskCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                task.setCompleted(isChecked);
                if (isChecked) {
                    TaskRepository.getInstance().completeTask(task); // Move task to completed
                    notifyDataSetChanged(); // Refresh the list
                }
            });

            // Handle item click for showing details
            convertView.setOnClickListener(v -> {
                ((MainActivity) getContext()).showTaskDetails(task.getTitle(), task.getDetails());
            });
        }

        return convertView;
    }
}