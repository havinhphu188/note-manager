package com.company.component;

import com.company.Mediator;

import javax.swing.*;

public class Title extends JTextField implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
