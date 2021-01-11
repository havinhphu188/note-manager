package com.company.component;

import com.company.Mediator;
import com.company.model.Note;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoteList extends JList<Note> implements Component{
    private Mediator mediator;
    private final NoteListFilterMapper noteListFilterMapper = new NoteListFilterMapper();

    public NoteList() {
        addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                mediator.selectNote(this.getSelectedValue());
            }
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setFilter(String filterText) {
        noteListFilterMapper.setFilterText(filterText);
    }

    public void refreshList(){
        setListData(noteListFilterMapper.getFilterdArray());
    }

    public void addNote() {
        Note[] filteredArray = noteListFilterMapper.addNote(new Note("New Note", "Note Body"));
        setListData(filteredArray);
        setSelectedIndex(0);
    }

    public void saveNote(Note note){
        if (this.getSelectedIndex() <0) return;
        int index = this.getSelectedIndex();
        setListData(noteListFilterMapper.saveNote(note, index));
        setSelectedIndex(index);
    }

    public void deleteNote() {
        if (this.getSelectedIndex() >= 0) {
            setListData(noteListFilterMapper.deleteNote(this.getSelectedIndex()));
        }
    }

    private class NoteListFilterMapper {
        private List<Note> allNotes = new ArrayList<>();
        private Note[] filteredArray ;
        private String filterText="";

        public void setFilterText(String filterText) {
            this.filterText = filterText;
        }

        public Note[] addNote(Note note) {
            allNotes.add(note);
            return getFilterdArray();
        }

        public Note[] deleteNote(int index){
            Note note = filteredArray[index];
            allNotes.removeIf(n -> n == note);
            return getFilterdArray();
        }

        public Note[] saveNote(Note note, int index){
            Note oldNote = filteredArray[index];
            allNotes = allNotes.stream().map(n -> n == oldNote ? note:n).collect(Collectors.toList());
            return getFilterdArray();
        }

        private Note[] getFilterdArray(){
            filteredArray = allNotes.stream().filter(note -> note.getTitle().contains(filterText)).toArray(Note[]::new);
            return filteredArray;
        }
    }
}
