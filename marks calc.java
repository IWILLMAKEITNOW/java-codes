
import java.util.Scanner;

class CourseWork {
    int CAT;
    int assignment;
    Scanner input = new Scanner(System.in);

    void read() {
        System.out.print("Enter CAT marks (out of 20): ");
        CAT = input.nextInt();
        System.out.print("Enter Assignment marks (out of 10): ");
        assignment = input.nextInt();
    }
}


interface Exam {
    void capture(); 
}


class Results extends CourseWork implements Exam {
    int finalExam;
    int finalTotal;
    char grade;


    public void capture() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Final Exam marks (out of 70): ");
        finalExam = input.nextInt();
    }

    void compute() {
        read();     
        capture();   

        finalTotal = CAT + assignment + finalExam;

        if (finalTotal >= 70)
            grade = 'A';
        else if (finalTotal >= 60)
            grade = 'B';
        else if (finalTotal >= 50)
            grade = 'C';
        else if (finalTotal >= 40)
            grade = 'D';
        else
            grade = 'E';

        System.out.println("--------------------------------------------------");
        System.out.println("CAT Marks: " + CAT);
        System.out.println("Assignment Marks: " + assignment);
        System.out.println("Final Exam Marks: " + finalExam);
        System.out.println("Final Total: " + finalTotal + " / 100");
        System.out.println("Grade: " + grade);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        Results r = new Results();
        r.compute();
    }
}