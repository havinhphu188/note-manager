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

    public void selectNote(Note selectedValue) {
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

}
