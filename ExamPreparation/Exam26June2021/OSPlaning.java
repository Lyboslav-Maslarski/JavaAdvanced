package ExamPreparation.Exam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] tasksArr = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] threadsArr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int searchedTask = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(tasksArr).forEach(tasks::push);
        Arrays.stream(threadsArr).forEach(threads::offer);

        while (!threads.isEmpty()) {
            Integer task = tasks.pop();

            if (task == searchedTask) {
                System.out.printf("Thread with value %d killed task %d%n", threads.peek(), task);
                threads.forEach(t -> System.out.print(t + " "));
                break;
            }

            Integer thread = threads.poll();

            if (thread < task) {
                tasks.push(task);
            }
        }
    }
}
