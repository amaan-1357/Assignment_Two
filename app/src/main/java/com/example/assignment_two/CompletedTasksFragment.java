package com.example.assignment_two;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class CompletedTasksFragment extends Fragment {

    private TaskAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed_tasks, container, false);

        // Get completed tasks from the repository
        ArrayList<Task> completedTasks = TaskRepository.getInstance().getCompletedTasks();

        ListView listView = view.findViewById(R.id.completed_list);
        adapter = new TaskAdapter(getActivity(), completedTasks);
        listView.setAdapter(adapter);

        return view;
    }
}