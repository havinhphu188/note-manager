package com.company.component;

import com.company.Mediator;

import javax.swing.*;

public class SaveButton extends JButton implements Component {
    private Mediator mediator;

    public SaveButton(String text) {
        super(text);
        addActionListener(e->{
            mediator.saveNote();
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
