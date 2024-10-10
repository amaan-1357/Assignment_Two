package com.example.assignment_two;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class AddTaskFragment extends Fragment {

    private EditText taskTitleInput;
    private EditText taskDetailsInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);

        taskTitleInput = view.findViewById(R.id.taskTitleInput);
        taskDetailsInput = view.findViewById(R.id.taskDetailsInput);
        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String title = taskTitleInput.getText().toString();
            String details = taskDetailsInput.getText().toString();

            closeKeyboard();
            if (title.isEmpty() || details.isEmpty()) {
                Toast.makeText(getContext(), "Title and Details cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                Task newTask = new Task(title, details);
                TaskRepository.getInstance().addTask(newTask);


                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).saveTask();
                }
            }
        });

        return view;
    }

    private void closeKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
