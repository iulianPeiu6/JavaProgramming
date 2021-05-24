package lab6package;

import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    MenuPanel menuPanel;


    public MainFrame() {
        super("Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1600,900));
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        menuPanel = new MenuPanel(this);


        add(configPanel, BorderLayout.PAGE_START);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.PAGE_END);
        add(menuPanel,BorderLayout.EAST);
        pack();
        setVisible(true);

    }
}

