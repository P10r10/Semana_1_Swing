import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exer1 {

	private JFrame frame;

	public Exer1() {
		frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrameContent();
		frame.setSize(300, 150);
		frame.setVisible(true);
	}

	private void addFrameContent() {
		frame.setLayout(new GridLayout(4, 2));
		JLabel lb1 = new JLabel("title");
		JLabel lb2 = new JLabel("width");
		JLabel lb3 = new JLabel("height");
		JTextField tf1 = new JTextField("Hello");
		JTextField tf2 = new JTextField("300");
		JTextField tf3 = new JTextField("150");
		JButton bt1 = new JButton("update");
		JCheckBox cb1 = new JCheckBox("center");
		frame.add(lb1);
		frame.add(tf1);
		frame.add(lb2);
		frame.add(tf2);
		frame.add(lb3);
		frame.add(tf3);
		frame.add(bt1);
		frame.add(cb1);

		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setTitle(tf1.getText());
				int width = Integer.parseInt(tf2.getText());
				int height = Integer.parseInt(tf3.getText());
				frame.setSize(width, height);
				if (cb1.isSelected()) {
					CenterFrame(width, height);
				}
			}
		});

		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// Get the new size of the JFrame
				tf2.setText(Integer.toString(frame.getWidth()));
				tf3.setText(Integer.toString(frame.getHeight()));
			}
		});
	}

	private void CenterFrame(int width, int height) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - width) / 2);
		int y = (int) ((dimension.getHeight() - height) / 2);
		frame.setLocation(x, y);
	}

	public static void main(String[] args) {
		new Exer1();
	}
}
