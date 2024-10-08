package com.example.assignment_two;

import java.util.ArrayList;

public class TaskRepository {
    private static TaskRepository instance;
    private final ArrayList<Task> tasks;           // Active tasks
    private final ArrayList<Task> completedTasks;  // Completed tasks

    private TaskRepository() {
        tasks = new ArrayList<>();
        completedTasks = new ArrayList<>();
        tasks.add(new Task("Prepare presentation", "Create slides for the team meeting."));
    }

    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Task> getCompletedTasks() {
        return completedTasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void completeTask(Task task) {
        tasks.remove(task);              // Remove from active tasks
        completedTasks.add(task);        // Add to completed tasks
    }
}