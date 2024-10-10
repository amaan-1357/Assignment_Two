package com.example.assignment_two;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.AdapterView;
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

        ArrayList<Task> completedTasks = TaskRepository.getInstance().getCompletedTasks();

        ListView listView = view.findViewById(R.id.completed_list);
        adapter = new TaskAdapter(getActivity(), completedTasks);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = adapter.getItem(position);
                if (task != null) {
                    ((MainActivity) getActivity()).showTaskDetails(task.getTitle(), task.getDetails());
                }
            }
        });

        return view;
    }
}
