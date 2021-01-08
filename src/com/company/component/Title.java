package com.company.component;

import com.company.Mediator;

import javax.swing.*;

public class Title extends JTextField {
    private Mediator mediator;

    public Title(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.setTxtTitle(this);

    }
}
