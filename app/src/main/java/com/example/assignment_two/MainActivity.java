package com.example.assignment_two;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_land);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_task_list, new TaskListFragment())
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_detail, new DetailFragment())
                    .commit();
        } else {
            setContentView(R.layout.activity_main);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TaskListFragment())
                    .commit();
        }

        setupButtons();
    }

    private void setupButtons() {
        Button btnTasks = findViewById(R.id.btn_tasks);
        Button btnCompleted = findViewById(R.id.btn_completed);

        btnTasks.setOnClickListener(view -> {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_task_list, new TaskListFragment())
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_detail, new DetailFragment())
                        .commit();
                findViewById(R.id.fragment_task_list).setVisibility(View.VISIBLE);
                findViewById(R.id.fragment_detail).setVisibility(View.VISIBLE);
                findViewById(R.id.fragment_add).setVisibility(View.GONE);
            } else {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new TaskListFragment())
                        .commit();
            }
        });

        btnCompleted.setOnClickListener(view -> {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_task_list, new CompletedTasksFragment())
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_detail, new DetailFragment())
                        .commit();
                findViewById(R.id.fragment_task_list).setVisibility(View.VISIBLE);
                findViewById(R.id.fragment_detail).setVisibility(View.VISIBLE);
                findViewById(R.id.fragment_add).setVisibility(View.GONE);

            } else {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new CompletedTasksFragment())
                        .commit();
            }
        });
    }

    public void addTask(View view){
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            findViewById(R.id.fragment_task_list).setVisibility(View.GONE);
            findViewById(R.id.fragment_detail).setVisibility(View.GONE);
            findViewById(R.id.fragment_add).setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_add, new AddTaskFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new AddTaskFragment())
                    .commit();
        }
    }


    public void showTaskDetails(String title, String details) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("details", details);
        detailFragment.setArguments(bundle);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_detail, detailFragment)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .commit();
        }
    }

    public void saveTask() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_task_list, new TaskListFragment())
                .commit();
        findViewById(R.id.fragment_task_list).setVisibility(View.VISIBLE);
        findViewById(R.id.fragment_detail).setVisibility(View.VISIBLE);
        findViewById(R.id.fragment_add).setVisibility(View.GONE);
        }else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TaskListFragment())
                    .commit();
        }

    }
    public void clearTaskDetails() {
        DetailFragment detailFragment = new DetailFragment();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_detail, detailFragment)
                    .commit();
        }
        else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TaskListFragment())
                    .commit();
        }
    }
}
