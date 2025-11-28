
class AgeLimitException extends Exception {
    public AgeLimitException(String message) {
        super(message);
    }
}


class School {
    int ageLimit;

    School(int limit) {
        ageLimit = limit;
    }
}

class Student extends School {
    int studentAge;

    Student(int ageLimit, int studentAge) throws AgeLimitException {
        super(ageLimit);  

        if (studentAge < ageLimit) {
            throw new AgeLimitException("Student age is below the school age limit!");
        }

        this.studentAge = studentAge;
    }
}


public class Main {
    public static void main(String[] args) {

        try {
            Student s1 = new Student(5, 7);
            System.out.println("Student admitted: Age = " + s1.studentAge);
        } 
        catch (AgeLimitException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            Student s2 = new Student(5, 3);  
        } 
        catch (AgeLimitException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
