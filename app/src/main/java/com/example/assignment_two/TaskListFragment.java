package com.example.assignment_two;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TaskListFragment extends Fragment {

    private TaskAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        ListView listView = view.findViewById(R.id.mylist);

        // Get the latest tasks from the repository
        adapter = new TaskAdapter(getActivity(), TaskRepository.getInstance().getTasks());
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Refresh the adapter when coming back to this fragment
        adapter.notifyDataSetChanged();
    }
}