
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeCalculator {
    private static final Scanner scanner = new Scanner(System.in);
    
    // Class to store subject information
    static class Subject {
        String name;
        double marks;
        
        Subject(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }
    }
    
    // Calculate grade based on average percentage
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // Validate marks input
    private static boolean isValidMarks(double marks) {
        return marks >= 0 && marks <= 100;
    }
    
    public static void main(String[] args) {
        ArrayList<Subject> subjects = new ArrayList<>();
        double totalMarks = 0;
        
        System.out.println("Welcome to Student Grade Calculator");
        System.out.println("----------------------------------");
        
        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Input marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("\nEnter name of subject " + i + ": ");
            String subjectName = scanner.nextLine();
            
            double marks;
            while (true) {
                System.out.print("Enter marks (out of 100) for " + subjectName + ": ");
                marks = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                
                if (isValidMarks(marks)) {
                    break;
                } else {
                    System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                }
            }
            
            subjects.add(new Subject(subjectName, marks));
            totalMarks += marks;
        }
        
        // Calculate average percentage
        double averagePercentage = totalMarks / numSubjects;
        
        // Calculate grade
        String grade = calculateGrade(averagePercentage);
        
        // Display results
        System.out.println("\n=== Results ===");
        System.out.println("Subject-wise Marks:");
        for (Subject subject : subjects) {
            System.out.printf("%s: %.2f%n", subject.name, subject.marks);
        }
        
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
        
        // Add performance comment
        System.out.println("\nPerformance Comment:");
        if (grade.equals("A+") || grade.equals("A")) {
            System.out.println("Excellent performance! Keep up the great work!");
        } else if (grade.equals("B")) {
            System.out.println("Good performance! There's room for improvement.");
        } else if (grade.equals("C")) {
            System.out.println("Fair performance. More effort needed.");
        } else if (grade.equals("D")) {
            System.out.println("Pass. Significant improvement needed.");
        } else {
            System.out.println("Failed. Please seek additional help and try again.");
        }
        
        scanner.close();
    }
}