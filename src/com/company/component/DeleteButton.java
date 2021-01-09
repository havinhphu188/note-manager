package com.company.component;

import com.company.Mediator;

import javax.swing.*;

public class DeleteButton extends JButton implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Creates a button with text.
     *
     * @param text the text of the button
     */
    public DeleteButton(String text) {
        super(text);
        addActionListener(e->{
            this.mediator.deleteNote();
        });
    }
}
