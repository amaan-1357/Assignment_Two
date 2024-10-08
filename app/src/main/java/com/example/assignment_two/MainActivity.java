package com.example.assignment_two;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Only reference portrait layout

        // Load the Task List Fragment when the app starts
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new TaskListFragment())
                .commit();

        // Set up button listeners
        setupButtons();
    }

    private void setupButtons() {
        Button btnTasks = findViewById(R.id.btn_tasks);
        Button btnCompleted = findViewById(R.id.btn_completed);
        Button btnAdd = findViewById(R.id.btn_add);

        btnTasks.setOnClickListener(view -> loadFragment(new TaskListFragment()));
        btnCompleted.setOnClickListener(view -> loadFragment(new CompletedTasksFragment()));
        btnAdd.setOnClickListener(view -> loadFragment(new AddTaskFragment()));
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void showTaskDetails(String title, String details) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("details", details);
        detailFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }
}
