package com.company.component;

import com.company.Mediator;
import com.company.model.Note;

import javax.swing.*;

public class NoteList extends JList<Note> implements Component{
    private Mediator mediator;
    private DefaultListModel<Note> listModel;

    public NoteList(DefaultListModel<Note> listModel) {
        super(listModel);
        this.listModel = listModel;
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

    public void addNote(){
        this.listModel.add(0,new Note("New Note","Note Body"));
        setSelectedIndex(0);
    }

    public void saveNote(Note note){
        this.listModel.set(this.getSelectedIndex(),note);
    }
}
