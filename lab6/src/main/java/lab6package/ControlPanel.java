package lab6package;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        setLayout(new GridLayout(1, 4));

        loadBtn.addActionListener(this::load);
        saveBtn.addActionListener(this::save);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

    }

    private void load(ActionEvent e) {

        File image;

        JFileChooser fileChooser = new JFileChooser(
                "C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\lab6\\src\\main\\java\\files");

        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            image = fileChooser.getSelectedFile();
            String mimeType= null;
            try {
                mimeType = Files.probeContentType(image.toPath());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            String type = mimeType.split("/")[0];
            if(type.equals("image"))
                frame.canvas.putImage(new ImageIcon(String.valueOf(image.toPath())).getImage());
        }
        else{
            System.out.println("NOT an image!");
        }

    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.createImage(), "png", new File(
                    "C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\lab6\\src\\main\\java\\files\\image.png"));
        } catch (IOException exp) { System.err.println(exp); }
    }

    private void reset(ActionEvent e){

        frame.canvas.erase();
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }

}

