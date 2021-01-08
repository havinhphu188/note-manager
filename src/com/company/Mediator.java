package com.company;

import com.company.component.SaveButton;
import com.company.component.NoteList;
import com.company.component.Content;
import com.company.model.Note;

import javax.swing.*;
import java.util.List;

public class Mediator {
    private NoteList lstNote;
    private JTextField txtTitle;
    private Content txtContent;

    public void selectNote(Note selectedValue) {
        txtTitle.setText(selectedValue.getTitle());
        txtContent.setText(selectedValue.getContent());
    }

    public void setLstNote(NoteList lstNote) {
        this.lstNote = lstNote;
    }

    public void setTxtTitle(JTextField txtTitle) {
        this.txtTitle = txtTitle;
    }

    public void setTxtContent(Content content) {
        this.txtContent = content;
    }

}
