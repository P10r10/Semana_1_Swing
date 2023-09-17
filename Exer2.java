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
    private int nbImages;
    private String path;
    File[] files;

    public Exer2(String path) {
        this.path = path;
        files = new File(path).listFiles();
        if (files == null) {
            System.out.println("Folder \"" + path + "\" not found!");
            System.exit(1);
        }
        frame = new JFrame("Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrameContent();
        frame.pack();
        frame.setVisible(true);
    }

    private void addFrameContent() {
        frame.setLayout(new BorderLayout());
        JLabel lbFile = new JLabel();
        JButton btLeft = new JButton("<");
        JButton btRight = new JButton(">");
        JButton btUpdate = new JButton("update");
        JLabel lbImage = new JLabel();
        frame.add(lbFile, BorderLayout.NORTH);
        frame.add(btLeft, BorderLayout.WEST);
        frame.add(btRight, BorderLayout.EAST);
        frame.add(btUpdate, BorderLayout.SOUTH);
        frame.add(lbImage, BorderLayout.CENTER);

        nbImages = files.length;
        lbImage.setIcon(new ImageIcon(files[currentImage].getAbsolutePath()));
        lbFile.setText(files[currentImage].getName());

        btLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentImage != -1) {
                    currentImage--;
                }
                if (currentImage == -1) {
                    clearImage(lbImage, lbFile);
                }
                if (currentImage >= 0) {
                    setImage(lbImage, lbFile, files);
                }
            }
        });

        btRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentImage != nbImages) {
                    currentImage++;
                }
                if (currentImage == nbImages) {
                    clearImage(lbImage, lbFile);
                }
                if (currentImage <= nbImages - 1) {
                    setImage(lbImage, lbFile, files);
                }
            }
        });

        btUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                files = new File(path).listFiles();
                nbImages = files.length;
                currentImage = 0;
                setImage(lbImage, lbFile, files);
            }
        });
    }

    private void clearImage(JLabel lbImage, JLabel lbFile) {
        lbImage.setIcon(null);
        lbImage.setText("Fim das imagens :(");
        lbFile.setText(" ");
    }

    private void setImage(JLabel lbImage, JLabel lbFile, File[] files) {
        lbImage.setIcon(new ImageIcon(files[currentImage].getAbsolutePath()));
        lbFile.setText(files[currentImage].getName());
    }

    public static void main(String[] args) {
        // args[0] must contain images folder
        new Exer2(args[0]);
    }
}
