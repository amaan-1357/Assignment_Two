package com.example.assignment_two;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddTaskFragment extends Fragment {

    private EditText taskTitleInput;
    private EditText taskDetailsInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);

        taskTitleInput = view.findViewById(R.id.taskTitleInput);
        taskDetailsInput = view.findViewById(R.id.taskDetailsInput);
        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String title = taskTitleInput.getText().toString();
            String details = taskDetailsInput.getText().toString();

            // Create and add the new task to the repository
            Task newTask = new Task(title, details);
            TaskRepository.getInstance().addTask(newTask);

            // Clear the input fields
            taskTitleInput.setText("");
            taskDetailsInput.setText("");

            // Optionally navigate back to Task List Fragment
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TaskListFragment())
                    .commit();
        });

        return view;
    }
}