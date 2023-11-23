package com.epam.mjc;

public class StudentManager {

    private static final long[] IDs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public class StudentNotFoundException extends RuntimeException {

        public StudentNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public Student find(long studentID) {
        try {
            return Student.getValueOf(studentID);
        } catch (IllegalArgumentException e) {
            // Talaba topilmaganida istisno chiqarish
            throw new StudentNotFoundException("Student not found with ID: " + studentID, e);
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        for (int i = 0; i < IDs.length; i++) {
            try {
                Student student = manager.find(IDs[i]);
                System.out.println("Student name: " + student.getName());
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
