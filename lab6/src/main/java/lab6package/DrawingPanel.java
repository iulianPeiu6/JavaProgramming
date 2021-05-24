package lab6package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    public BufferedImage image;
    private Image loadedImage;
    int currentShapeX, currentShapeY;
    List<Shape> shapes;
    List<Color> colors;
    List<Point> points;
    private int currentX, currentY, oldX, oldY;

    public DrawingPanel(MainFrame frame) {
        currentShapeX = currentShapeY = -1;
        loadedImage = null;

        shapes = new ArrayList<>();
        colors = new ArrayList<>();
        points = new ArrayList<>();

        this.frame = frame;

        init();
        setVisible(true);
    }

    private void init(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                currentShapeX = e.getX();
                currentShapeY = e.getY();

                //points.add(new Point(e.getX(),e.getY()));
                //oldX = e.getX();
                //oldY = e.getY();

                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                points.add(null);

                System.out.println(points);
            }

        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                //currentX = e.getX();
                //currentY = e.getY();

                points.add(new Point(e.getX(),e.getY()));
                //lines.add(new Line(oldX,oldY,currentX,currentY));

                //oldX = currentX;
                //oldY = currentY;

                repaint();
            }
        });

    }

    public void paint(Graphics graphics){

        super.paint(graphics);

        if (!(currentShapeX == -1 || currentShapeY == -1)) {
            shapes.add(new Polygon(generateRandomArray((Integer) frame.configPanel.sidesField.getValue(),currentShapeX,getWidth()),
                    generateRandomArray((Integer) frame.configPanel.sidesField.getValue(),currentShapeY,getHeight()),
                    (Integer) frame.configPanel.sidesField.getValue()));

            if (frame.configPanel.colorCombo.getSelectedItem().toString().equals("Random")) {
                Random rand = new Random();
                colors.add(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
            }
            else
                colors.add(Color.BLACK);

        }
        if (loadedImage!=null)
                graphics.drawImage(loadedImage,0,0,this);

        for (int i=0;i<shapes.size();i++){
            graphics.setColor(colors.get(i));
            graphics.drawPolygon((Polygon) shapes.get(i));
        }
        graphics.setColor(Color.BLACK);

        for (int i=1;i<points.size();i++){

            Point oldPoint = points.get(i-1);
            Point currentPoint = points.get(i);
            if (oldPoint == null || currentPoint==null)
                continue;
            graphics.drawLine(oldPoint.x,oldPoint.y,currentPoint.x,currentPoint.y);
        }

    }

    private int[] generateRandomArray(int n, int init, int max) {
        int[] arrayList = new int[n];
        arrayList[0] = init;

        for (int i=1;i<n;i++){
            arrayList[i]=(int) (Math.random()*max);
        }

        return arrayList;
    }

    public void erase(){
        shapes.clear();
        colors.clear();
        points.clear();
        currentShapeX = -1;
        currentShapeY = -1;
        loadedImage = null;
        repaint();
    }

    public BufferedImage createImage() {

        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();
        currentShapeX = currentShapeY = -1;
        this.paint(g);
        return bufferedImage;
    }

    public void putImage(Image image){
        loadedImage = image;
        currentShapeX=currentShapeY=-1;
        repaint();
    }

    public void deleteShape(int index){
        shapes.remove(index);
        colors.remove(index);
        repaint();
    }



}
