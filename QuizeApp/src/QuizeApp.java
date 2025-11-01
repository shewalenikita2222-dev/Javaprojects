import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer; 

   
    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    
    public void displayQuestion() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    
    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
}

public class QuizeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("1. What is the capital of India?",
                new String[]{"Mumbai", "New Delhi", "Kolkata", "Chennai"}, 2));
        quiz.add(new Question("2. Who invented Java?",
                new String[]{"James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum"}, 1));
        quiz.add(new Question("3. Which keyword is used to inherit a class in Java?",
                new String[]{"this", "super", "extends", "implements"}, 3));
        quiz.add(new Question("4. Which data structure uses FIFO?",
                new String[]{"Stack", "Queue", "Array", "Tree"}, 2));
        quiz.add(new Question("5. Which company developed Java?",
                new String[]{"Microsoft", "Sun Microsystems", "Apple", "Google"}, 2));

        int score = 0;

        System.out.println("=== Welcome to the Online Quiz App ===");

       
        for (Question q : quiz) {
            q.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            if (q.isCorrect(answer)) {
                System.out.println(" Correct!");
                score++;
            } else {
                System.out.println(" Wrong!");
            }
        }

      
        System.out.println("\n=== Quiz Completed ===");
        System.out.println("Your Score: " + score + " / " + quiz.size());

        if (score == quiz.size())
            System.out.println("Excellent!");
        else if (score >= 3)
            System.out.println(" Good job!");
        else
            System.out.println(" Keep practicing!");

        sc.close();
    }
}
