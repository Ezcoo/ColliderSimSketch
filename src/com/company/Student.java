package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Student {
    public ArrayList<Integer> interests;
    public ArrayList<Integer> preferences;
    public int numberOfInterests;
    public ArrayList<Student> matches;

    public Student (int numberOfInterests) {
        this.numberOfInterests = numberOfInterests;
        this.matches = new ArrayList<>();
        generateInterestsAndPreferences();
    }

    public void generateInterestsAndPreferences() {
        this.interests = generateData();
        this.preferences = generateData();
        System.out.println(this.preferences);
        System.out.println(this.interests);
    }

    public ArrayList<Integer> generateData() {
        ArrayList<Integer> data = new ArrayList<>();

        for (int j = 0; j < this.numberOfInterests; j++) {
            data.add(j);
        }

        for (int j = 0; j < this.numberOfInterests * 5; j++) {
            data.add(0);
        }

        Collections.shuffle(data);

        return data;
    }

    public ArrayList<Integer> getInterests() {
        return this.interests;
    }

    public ArrayList<Integer> getPreferences() {
        return this.preferences;
    }

    public void removeTopValueFromInterests() {
        this.interests.remove(Collections.max(this.interests));
    }

    public void removeTopValueFromPreferences() {
        this.preferences.remove(Collections.max(this.preferences));
    }

    public int compare(Student student, int round) {
        if (student.getPreferences().isEmpty() || Collections.max(student.getPreferences()) == 0) {
            return -1;
        }

        int preferencesStudent = student.getPreferences().indexOf(Collections.max(student.getPreferences()));

        if (this.interests.isEmpty() || Collections.max(this.interests) == 0) {
            return -1;
        }

        int interestsThis = this.interests.indexOf(Collections.max(this.interests));

        int match = preferencesStudent - interestsThis;

        if (match >= round) {
            return match;
        }

        return -1;
    }

    public ArrayList<Student> getMatches() {
        return this.matches;
    }

    public void addToBestMatches(Student student) {
        this.matches.add(student);
        System.out.println("Match added!");
    }

    public void removeFromBestMatches(Student student) {
        System.out.println("Match removed!");
        this.matches.remove(student);
    }

}
