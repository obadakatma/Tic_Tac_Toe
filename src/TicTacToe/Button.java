package TicTacToe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Button extends JButton implements MouseListener, ActionListener {
    private final int sizeW = 90;
    private final int sizeH = 83;
    private boolean state;

    Image image;
    JButton button;

    public Button(int i, int j) {
        super();
        button = new JButton(new ImageIcon(setIcon()));
        button.setPreferredSize(new Dimension(sizeW, sizeH));
        button.setMaximumSize(button.getPreferredSize());
        button.setBounds(2 + j, 2 + i, sizeW, sizeH);
        button.addMouseListener(this);
        button.addActionListener(this);
        state = true;
    }
    public JButton getButton() {
        return button;
    }

    public void setState(boolean state1) {
        state = state1;
        button.setVisible(state);
    }
    public int getButtonX() {
        return button.getX();
    }

    public int getButtonY() {
        return button.getY();
    }

    public int getButtonWidth() {
        return button.getWidth();
    }

    public int getButtonHeight() {
        return button.getHeight();
    }

    public Image setIcon() {
        try {
            image = ImageIO.read(new File("src/TicTacToe/Photo/Button.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 1) {
            setState(false);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index;
        if (e.getSource() == button) {
            if (Grid.Turn) {
                index = Grid.buttons.indexOf(this);
                Grid.setPhotoNum(Grid.X);
                Grid.xoTurn[index] = Grid.X;
                Grid.Turn = false;
            } else {
                index = Grid.buttons.indexOf(this);

                Grid.setPhotoNum(Grid.O);
                Grid.xoTurn[index] = Grid.O;
                Grid.Turn = true;
            }
            Grid.winnerPanel(Grid.checkWin());
        }
    }
}
