package com.company.component;

import com.company.model.Note;

import javax.swing.*;

public class NoteList extends JList<Note> {
    public NoteList(JTextField txtTitle) {
            addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()){
                    System.out.println("eventCalled");
                    NoteList source = (NoteList) e.getSource();
                    String selected = source.getSelectedValue().toString();
                    txtTitle.setText(selected);
                }
            });
    }
}
