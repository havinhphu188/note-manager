package com.company;

import com.company.model.Note;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class NoteManager {

    private JFrame mainFrame;
    private JTextField txtTitle = new JTextField();
    private JList<Note> lstNotes = new JList<>();

    public void creatGUI() {

        mainFrame = new JFrame();
        mainFrame.setLayout(new GridLayout(1,2));
        mainFrame.setTitle("Note");
        mainFrame.setSize(960, 600);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft,BoxLayout.Y_AXIS));

        JPanel panelFilter = new JPanel();
        panelFilter.setPreferredSize(new Dimension(400, 50));

        Label lblFilter = new Label();
        lblFilter.setText("Filter: ");
        panelFilter.add(lblFilter);

        JTextField txtFilter = new JTextField();
        txtFilter.setColumns(20);
        panelFilter.add(txtFilter);
        panelLeft.add(panelFilter);
        lstNotes.setPreferredSize(new Dimension(400, 410));

        JPanel panelList = new JPanel();
        panelList.add(lstNotes);
        panelLeft.add(panelList);

        JPanel panelButton = new JPanel();
        panelButton.setSize(320, 470);
        JButton btnAdd = new JButton("Add");
        JButton btnDel = new JButton("Del");
        panelButton.add(btnAdd);
        panelButton.add(btnDel);
        panelLeft.add(panelButton);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight,BoxLayout.Y_AXIS));

        JPanel panelTitle = new JPanel();

        txtTitle.setColumns(40);
        JTextArea txtContent = new JTextArea();
        txtContent.setPreferredSize(new Dimension(400, 400));
        panelTitle.add( new JLabel("Title"));
        panelTitle.add(txtTitle);
        panelRight.add(panelTitle);
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new FlowLayout());
        panelRight.add(new JLabel("Text"));
        panelContent.add(txtContent);
        panelRight.add(panelContent);
        JButton btnSave = new JButton("Save");
        JPanel panelSave = new JPanel();
        panelSave.add(btnSave);
        panelRight.add(panelSave);

        mainFrame.add(panelLeft);
        mainFrame.add(panelRight);
        mainFrame.setVisible(true);
    }

    public void addNote() {
        Note[] listNoteData = {new Note("one","content1"),new Note("two", "content2"),new Note("three","content3")};
        lstNotes.setListData(listNoteData);
    }

    public void addListener(){
        lstNotes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    System.out.println("eventCalled");
                    JList source = (JList)e.getSource();
                    String selected = source.getSelectedValue().toString();
                    txtTitle.setText(selected);
                }
            }
        });
    }
}
