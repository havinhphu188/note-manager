package com.company;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        NoteManager noteManager = new NoteManager(); // Init component with mediator
        noteManager.creatGUI();
    }
}
