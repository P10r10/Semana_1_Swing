import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Exer2 {

    private JFrame frame;
    private int currentImage = 0;
    private boolean EndOfImages = false;

    public Exer2() {
        frame = new JFrame("Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrameContent();
        frame.pack();
        frame.setVisible(true);
    }

    private void addFrameContent() {
        frame.setLayout(new BorderLayout());
        JLabel lbFile = new JLabel("FILE NAME");
        JButton btLeft = new JButton("<");
        JButton btRight = new JButton(">");
        JButton btUpdate = new JButton("update");
        JLabel lbImage = new JLabel();
        frame.add(lbFile, BorderLayout.NORTH);
        frame.add(btLeft, BorderLayout.WEST);
        frame.add(btRight, BorderLayout.EAST);
        frame.add(btUpdate, BorderLayout.SOUTH);
        frame.add(lbImage, BorderLayout.CENTER);

        File[] files = new File("images").listFiles();
        lbImage.setIcon(new ImageIcon(files[currentImage].getAbsolutePath()));
        lbFile.setText(files[currentImage].getName());

        btLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentImage == 0) {
                    currentImage--;
                    lbImage.setIcon(null);
                    lbImage.setText("Fim das imagens :(");
                    lbFile.setText(" ");
                } else {
                    lbImage.setIcon(new ImageIcon(files[currentImage].getAbsolutePath()));
                    lbFile.setText(files[currentImage].getName());
                }
            }
        });

        btRight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                currentImage++;
                if (currentImage > 2) {
                    lbImage.setIcon(null);
                    lbImage.setText("Fim das imagens :(");
                    lbFile.setText(" ");
                } else {
                    lbImage.setIcon(new ImageIcon(files[currentImage].getAbsolutePath()));
                    lbFile.setText(files[currentImage].getName());
                }
            }

        });

    }

    public static void main(String[] args) {
        new Exer2();
    }
}
