package com.company;

import com.company.component.*;
import com.company.model.Note;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;


public class Mediator {
    private NoteList lstNote;
    private Title txtTitle;
    private Content txtContent;
    private AddButton addButton;
    private SaveButton saveButton;
    private DeleteButton deleteButton;

    public void selectNote(Note selectedValue) {
        if (selectedValue == null) {
            txtTitle.setText("");
            txtContent.setText("");
            return;
        }
        txtTitle.setText(selectedValue.getTitle());
        txtContent.setText(selectedValue.getContent());
    }

    public Component setComponent(Component component) throws IllegalAccessException {
        Field[] fields =this.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.getType() == component.getClass()) {
                FieldUtils.writeField(f,this,component,true);
                component.setMediator(this);
                break;
            }
        }
        return component;
    };

    public void addNote() {
        lstNote.addNote();
    }

    public void saveNote() {
        lstNote.saveNote(new Note(txtTitle.getText(),txtContent.getText()));
    }

    public void deleteNote(){
        lstNote.deleteNote();
    }
}
