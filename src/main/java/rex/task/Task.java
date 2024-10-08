package rex.task;

import java.time.LocalDate;

/**
 * Represents a generic task in the Rex application.
 * It contains information about the task description, its completion status,
 * and manages the count of tasks created.
 */
public abstract class Task {
    private static int numberOfTasks = 0;
    private final String description;
    private boolean isDone;

    /**
     * The {@code Task} class represents a generic task in the Rex application.
     * It contains information about the task description, its completion status,
     * and manages the count of tasks created.
     */
    protected Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
        numberOfTasks++;
    }

    /**
     * Marks the task as done by setting its completion status to true.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done by setting its completion status to false.
     */
    public void unMarkDone() {
        this.isDone = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the status icon representing whether the task is done or not.
     *
     * @return "X" if the task is done, otherwise a blank space.
     */
    private String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    /**
     * Returns the total number of tasks created.
     *
     * @return The total number of tasks.
     */
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * Decrements the total number of tasks by one.
     * This method should be called when a task is removed.
     */
    public static void removeTask() {
        assert numberOfTasks >= 0 : "total number of tasks should not be less than 0";
        numberOfTasks--;
    }

    /**
     * Returns a string representation of the task, including its status icon and description.
     *
     * @return A string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Returns a formatted string suitable for saving to a file.
     * The format includes the task's completion status and description.
     *
     * @return A formatted string representing the task.
     */
    public String formatter() {
        return (isDone ? "1" : "0") + " | " + description;
    }

    /**
     * Determines whether the task is scheduled on a specific date.
     *
     * @param date The date to check.
     * @return {@code true} if the task is scheduled on the specified date, {@code false} otherwise.
     */
    public abstract boolean isScheduledOnDate(LocalDate date);
}
