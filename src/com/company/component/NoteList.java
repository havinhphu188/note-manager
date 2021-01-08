package com.company.component;

import com.company.Mediator;
import com.company.model.Note;

import javax.swing.*;

public class NoteList extends JList<Note> {
    private Mediator mediator;
    public NoteList(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.setLstNote(this);
        addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()){
                System.out.println("eventCalled");
                NoteList source = (NoteList) e.getSource();
                mediator.selectNote(source.getSelectedValue());
            }
        });
    }
}
