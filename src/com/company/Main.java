package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int persons = 100;
        int numberOfInterests = 5;
        int enoughMatches = 5;

        // RNG interests

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < persons; i++) {
            students.add(new Student(numberOfInterests));
        }

        for (int round = numberOfInterests; round > 0; round--) {

            ArrayList<Student> studentsCopy2 = new ArrayList<>();

            for (Student student : students) {
                studentsCopy2.add(student);
            }

            Iterator<Student> studentsWithoutEnoughMatches = studentsCopy2.iterator();

            while (studentsWithoutEnoughMatches.next().getMatches().size() < enoughMatches) {

                ArrayList<Student> studentsCopy = new ArrayList<>();

                for (Student student : students) {
                    studentsCopy.add(student);
                }

                Iterator<Student> leftStudentsPreferences = studentsCopy.iterator();

                while (leftStudentsPreferences.hasNext()) {
                    Student studentWithPreferences = leftStudentsPreferences.next();

                    studentsCopy = new ArrayList<>();

                    for (Student student : students) {
                        studentsCopy.add(student);
                    }

                    Iterator<Student> leftStudentsInterests = studentsCopy.iterator();

                    while (leftStudentsInterests.hasNext()) {
                        Student studentWithInterests = leftStudentsInterests.next();

                        if (studentWithPreferences != studentWithInterests) {
                            int score = studentWithInterests.compare(studentWithPreferences, round);

                            if (score == round) {
                                System.out.println("Match with score " + score + "! " + students.indexOf(studentWithPreferences) + " + " + studentsCopy.indexOf(studentWithInterests));
                                studentWithPreferences.addToBestMatches(studentWithInterests);
                            }

                        }

                    }

                }

            }

        }


        for (Student student : students) {
            System.out.print("Student's --- " + students.indexOf(student) + " --- matches based on their preferences:");

            for (Student match : student.getMatches()) {
                System.out.print(" " + students.indexOf(match));
            }

            System.out.println();
        }

    }

    public static void selectBestMatch(Student student, Student student2, int round) {

    }

}


        // Offer the most interested students to students with matching preferences
        /*

        ArrayList<Integer> preliminarySelection = new ArrayList<>();

        ArrayList<ArrayList<Integer>> interestsCopy = interests;
        ArrayList<ArrayList<Integer>> preferencesCopy = preferences;

        int highestInterest = 0;

        for (int i = 0; i < persons; i++) {
            highestInterest = Collections.max(interestsCopy.get(i));
        }

        for (int i = numberOfInterests; i > 0; i++) {
            for (int j = 0; j < persons; j++) {
                if (preferencesCopy.get(i).get(highestInterest) == i) {
                    preliminarySelection.add(highestInterest);
                }
            }
        }

        */

        /*
        // Count match score

        ArrayList<ArrayList<ArrayList<Double>>> matches = new ArrayList<>();

        for (int i = 0; i < persons; i++) {
            ArrayList<ArrayList<Double>> matchesByPerson = new ArrayList<>();
            for (int j = 0; j < persons; j++) {
                if (i != j) {
                    ArrayList<Double> matchValues = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        double match = 0;
                        if (preferences.get(i).get(j) > interests.get(i).get(j)) {
                            match = (1 - (preferences.get(i).get(j) / interests.get(i).get(j))) / 1.0;
                        } else {
                            match = (1 - (interests.get(i).get(j) / preferences.get(i).get(j))) / 1.0;
                        }
                        matchValues.add(match);
                    }
                }
                matchesByPerson.add(matchValues);
            }
            matches.add(matchesByPerson);
        }


        // Select the best matches
        ArrayList<ArrayList<Double>> matchesPerPerson = new ArrayList<>();

        for (int i = 0; i < matches.size(); i++) {
            for (int j = 0; j < matches.get(i).size(); j++) {
                if (i != j) {
                    for (int k = 0; k < 5; k++) {

                    }
                }
            }
        }
    }



    public static int sortMatchesPerPerson(ArrayList<ArrayList<Integer>> interests, ArrayList<ArrayList<Integer>> preferences, int preferencesOf, int indexOfInterestedIn, int leftRounds) {
        for (int i = 0; i < leftRounds; i++) {
            if ()
        }

        return 0;
    }
}
*/