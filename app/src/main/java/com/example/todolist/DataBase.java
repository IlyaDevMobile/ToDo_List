package com.example.todolist;

import java.util.ArrayList;
import java.util.Random;

public class DataBase {

    private ArrayList<Note> notes = new ArrayList<>();
    private static DataBase instanse = null;

    public static DataBase getInstance(){
        if (instanse == null){
            instanse = new DataBase();

        }
        return instanse;
    }

    public DataBase(){
        Random random = new Random();
        for (int i =0; i < 20; i++){
            Note note = new Note(i,"Note" + i,random.nextInt(3));
            notes.add(note);
        }
    }

    public void add(Note note) {
        notes.add(note);
    }

    public void remove(int id) {
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if (note.getId() == id) {
                notes.remove(note);
            }
        }
    }

    public ArrayList<Note> getNotes() {

        return new ArrayList<>(notes);
    }
}
