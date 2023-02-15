package ExamPreparation.Exam25June2022.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (getExerciseCount() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream()
                .filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        return "Workout type: " + type + System.lineSeparator() +
               exercises.stream()
                       .map(Exercise::toString)
                       .collect(Collectors.joining(System.lineSeparator()));
    }
}
