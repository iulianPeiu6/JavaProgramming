package lab6package;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
    final MainFrame frame;
    JButton deleteBtn;
    JLabel deleteLabel;
    JSpinner indexShape;
    public MenuPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init(){
        deleteLabel = new JLabel("Delete shape from index:");

        indexShape = new JSpinner(new SpinnerNumberModel(0, 0, 100 , 1));

        deleteBtn = new JButton("Delete");

        deleteBtn.addActionListener(this::deleteShape);
        add(deleteLabel);
        add(indexShape);
        add(deleteBtn);
    }

    private void deleteShape(ActionEvent e){
        int fromIndex = (int) indexShape.getValue();
        frame.canvas.shapes.remove(fromIndex);
        frame.canvas.currentShapeX = frame.canvas.currentShapeY = -1;
        frame.canvas.repaint();
    }

}
