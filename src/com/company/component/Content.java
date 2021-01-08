package com.company.component;

import com.company.Mediator;

import javax.swing.*;

public class Content extends JTextArea {
    private Mediator mediator;

    public Content(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.setTxtContent(this);
    }
}
