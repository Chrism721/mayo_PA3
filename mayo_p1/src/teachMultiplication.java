import java.util.Scanner;
import java.security.SecureRandom;

public class teachMultiplication {

    public static int problemType(Scanner scnr){
        System.out.println("Please select the type of problem to be studied with the associated digit...");
        System.out.println("1: Addition only");
        System.out.println("2: Multiplication only");
        System.out.println("3: Subtraction only");
        System.out.println("4: Division only");
        System.out.println("5: Mixed");
        int type = scnr.nextInt();
        return type;
    }

    public static int levelOfDifficulty(Scanner scnr){
        System.out.println("Please select a difficulty level from 1 to 4: ");
        int lvl = scnr.nextInt();
        return lvl;
    }

    public static void percentage(int correct){
        double percentage = ((double)correct / 10.00) * 100.00;
        if(percentage < 75.00){
            System.out.println("Please ask your teacher for extra help.");
        }
        else{
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
    }

    // chooses responses to right/wrong answers
    public static void generateResponses(int i){
        SecureRandom secureRandom = new SecureRandom();
        if(i == 1){
            switch(secureRandom.nextInt(4) + 1){
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        if(i == 0){
            switch(secureRandom.nextInt(4) + 1){
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don’t give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }

    // generating question/numbers and returning answer
    public static double generateQuestionAndNumbers(int j, int t) {
        SecureRandom secureRandom = new SecureRandom();
        int num1 = 0;
        int num2 = 0;
        double answer = 0;
        switch (j){
            case 1:
                num1 = secureRandom.nextInt(9) + 1;
                num2 = secureRandom.nextInt(9) + 1;
                break;
            case 2:
                num1 = secureRandom.nextInt((99 - 10) + 1) + 10;
                num2 = secureRandom.nextInt((99 - 10) + 1) + 10;
                break;
            case 3:
                num1 = secureRandom.nextInt((999 - 100) + 1) + 100;
                num2 = secureRandom.nextInt((999 - 100) + 1) + 100;
                break;
            case 4:
                num1 = secureRandom.nextInt((9999 - 1000) + 1) + 1000;
                num2 = secureRandom.nextInt((9999 - 1000) + 1) + 1000;
                break;
        }
        switch (t){
            case 1:
                System.out.println("How much is " + num1 + " plus " + num2 + "?");
                answer = (double)num1 + (double)num2;
                break;
            case 2:
                System.out.println("How much is " + num1 + " times " + num2 + "?");
                answer = (double)num1 * (double)num2;
                break;
            case 3:
                System.out.println("How much is " + num1 + " minus " + num2 + "?");
                answer = (double)num1 - (double)num2;
                break;
            case 4:
                System.out.println("How much is " + num1 + " divided by " + num2 + "?");
                answer = (double)num1 / (double)num2;
                break;
            case 5:
                switch (secureRandom.nextInt(4) + 1){
                    case 1:
                        System.out.println("How much is " + num1 + " plus " + num2 + "?");
                        answer = (double)num1 + (double)num2;
                        break;
                    case 2:
                        System.out.println("How much is " + num1 + " times " + num2 + "?");
                        answer = (double)num1 * (double)num2;
                        break;
                    case 3:
                        System.out.println("How much is " + num1 + " minus " + num2 + "?");
                        answer = (double)num1 - (double)num2;
                        break;
                    case 4:
                        System.out.println("How much is " + num1 + " divided by " + num2 + "?");
                        answer = (double)num1 / (double)num2;
                        break;
                }
                break;
        }
        return answer;
    }

    // check answer
    public static int checkAnswer(Scanner scnr, double correctAns){
        double ans = scnr.nextDouble();
        int rightCounter = 0;
        if (Math.abs(ans - correctAns) < 0.01){
            rightCounter++;
            generateResponses(1);
        }
        else {
            generateResponses(0);
        }
        return rightCounter;
    }

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        char sessionContinue = 'a';
        while(sessionContinue != 'q'){
            int lod = levelOfDifficulty(scnr);
            int probType = problemType(scnr);
            int questionCounter = 0;
            int correctCounter = 0;
            // Q & A
            while(questionCounter < 10) {
                double correctAnswer = generateQuestionAndNumbers(lod, probType); // student response
                correctCounter += checkAnswer(scnr, correctAnswer);
                questionCounter++;
            }
            // results
            System.out.println("Correct: " + correctCounter + "\tIncorrect: " + (10 - correctCounter));
            percentage(correctCounter);
            // end of current session
            System.out.println("If you wish to not begin a new session please enter 'q', otherwise enter any other key.");
            sessionContinue = scnr.next().charAt(0);
        }

    }

}
