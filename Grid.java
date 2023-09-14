import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Grid {

    private JFrame frame;
    private boolean xNext = true;

    public Grid(String name, int row, int col, int size) {
        frame = new JFrame(name);
        frame.setLayout(new GridLayout(row, col));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < row * col; i++) {
            JLabel squareCell = new JLabel();
            squareCell.setPreferredSize(new Dimension(size, size));
            squareCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            squareCell.setFont(new Font("Arial", Font.BOLD, 42));
            squareCell.setHorizontalAlignment(SwingConstants.CENTER);
            squareCell.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if ("".equals(squareCell.getText())) {
                        if (xNext) {
                            squareCell.setText("X");
                            xNext = false;
                        } else {
                            squareCell.setText("O");
                            xNext = true;
                        }
                    }
                }
            });
            frame.add(squareCell);
        }
        frame.pack();
    }

    private void open() {
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Grid grid = new Grid("Test", 3, 3, 50);
        grid.open();
    }

}
