package com.company.component;

import com.company.Mediator;
import com.company.model.Note;

import javax.swing.*;

public class NoteList extends JList<Note> implements Component{
    private Mediator mediator;

    public NoteList() {
        addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()){
                System.out.println("eventCalled");
                NoteList source = (NoteList) e.getSource();
                mediator.selectNote(source.getSelectedValue());
            }
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
