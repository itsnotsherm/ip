public class Task {
    private static int numberOfTasks = 0;
    private String description;
    private boolean isDone;

    protected Task(String description) {
        this.description = description;
        this.isDone = false;
        numberOfTasks++;
    }

    public void markDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.print("  ");
        System.out.println(this);
    }

    public void unmarkDone() {
        this.isDone = false;
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.print("  ");
        System.out.println(this);
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    public static void removeTask() {
        numberOfTasks--;
    }

    @Override
    public String toString() {
        String output = "[" + getStatusIcon() + "] ";
        output += description;
        return output;
    }

    public String formatted() {
        return ((isDone) ? "1" : "0") + " | " + description;
    }
}
