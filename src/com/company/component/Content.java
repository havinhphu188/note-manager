package com.company.component;

import com.company.Mediator;

import javax.swing.*;

public class Content extends JTextArea implements Component{
    private Mediator mediator;

    public Content() {
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
