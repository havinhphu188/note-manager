package com.company.component;

import com.company.Mediator;
import com.company.model.Note;

import javax.swing.*;

public class NoteList extends JList<Note> implements Component{
    private Mediator mediator;

    public NoteList() {
        addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()){
                mediator.selectNote(this.getSelectedValue());
            }
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
