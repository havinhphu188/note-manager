package com.company.component;

import com.company.Mediator;

import javax.swing.*;

public class AddButton extends JButton implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public AddButton(String text) {
        super(text);
        addActionListener(e -> {
            this.mediator.addNote();
        });
    }
}
