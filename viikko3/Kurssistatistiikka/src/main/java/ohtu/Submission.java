package ohtu;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;

    public Submission(int week, int hours, int[] exercises) {
        this.week = week;
        this.hours = hours;
        this.exercises = exercises;
    }
    
    

    public void setExercices(int[] exercices) {
        this.exercises = exercices;
    }

    public int[] getExercices() {
        return exercises;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    @Override
    public String toString() {
        return "viikko " + week +  ":tehtyjä tehtäviä yhteensä: "  + exercises.length +
                ", aikaa kului " + hours  +" tuntia, tehdyt tehtävät: " + printArray();
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }
    private String printArray() {
        String tulostus = "";
        for (int i = 0; i < this.exercises.length; i++) {
            tulostus += exercises[i]+" "; 
        }
        return tulostus;
    }
    
}