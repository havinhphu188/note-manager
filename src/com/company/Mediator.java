package com.company;

import com.company.component.NoteList;
import com.company.component.Content;
import com.company.component.Title;
import com.company.model.Note;

import javax.swing.*;

public class Mediator {
    private NoteList lstNote;
    private JTextField txtTitle;
    private Content txtContent;

    public void selectNote(Note selectedValue) {
        txtTitle.setText(selectedValue.getTitle());
        txtContent.setText(selectedValue.getContent());
    }

    public NoteList setLstNote(NoteList lstNote) {
        this.lstNote = lstNote;
        lstNote.setMediator(this);
        return lstNote;
    }

    public Title setTxtTitle(Title txtTitle) {
        this.txtTitle = txtTitle;
        txtTitle.setMediator(this);
        return txtTitle;
    }

    public Content setTxtContent(Content content) {
        this.txtContent = content;
        content.setMediator(this);
        return content;
    }

}
