package com.company.component;

import com.company.Mediator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Filter extends JTextField implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Constructs a new <code>TextField</code>.  A default model is created,
     * the initial string is <code>null</code>,
     * and the number of columns is set to 0.
     */
    public Filter() {
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mediator.sendFilter(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mediator.sendFilter(getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}

        });
    }
}
