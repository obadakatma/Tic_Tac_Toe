package TicTacToe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Grid extends JPanel {
    Random random = new Random();
    Image image;
    public static final ArrayList<Button> buttons = new ArrayList<Button>();
    public static final int[] xoTurn = new int[9];
    public static int X = 2;
    public static int O = 1;
    public static boolean Turn;
    public static int winner;
    private static int PhotoNum;

    public Grid() {
        firstTurn();
        for (int i = 0; i < 261; i += 87) {
            for (int j = 0; j < 285; j += 95) {
                buttons.add(new Button(i, j));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        this.setBackground(new Color(38, 38, 147));
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setStroke(new BasicStroke(6));
        g2.setColor(new Color(232, 86, 21));
        g2.drawRect(0, 0, 283, 260);
        for (int i = 1; i < 3; i++) {
            g2.drawLine(94 * i, 0, 94 * i, 260);
            g2.drawLine(0, 86 * i, 283, 86 * i);
        }

        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            add(buttons.get(i).getButton());
            int x = buttons.get(i).getButtonX();
            int y = buttons.get(i).getButtonY();
            int width = buttons.get(i).getButtonWidth();
            int height = buttons.get(i).getButtonHeight();
            int val1 = 5;
            int val2 = 10;
            g2.drawImage(setImage(), x + val1, y + val1, width - val2, height - val2, null);
        }
    }

    public static void setPhotoNum(int n) {
        PhotoNum = n;
    }

    public int getPhotoNum() {
        return PhotoNum;
    }

    public Image setImage() {
        String photo;
        switch (getPhotoNum()) {
            case 0:
                photo = "E";
                break;
            case 1:
                photo = "O";
                break;
            case 2:
                photo = "X";
                break;
            default:
                photo = "E";
                break;
        }
        try {
            image = ImageIO.read(new File("src/TicTacToe/Photo/" + photo + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }


    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            Turn = true;
            JOptionPane.showMessageDialog(null, "X will start");
        } else {
            Turn = false;
            JOptionPane.showMessageDialog(null, "O will start");
        }

    }

    public static boolean checkWin() {

        if (xoTurn[0] == xoTurn[1] && xoTurn[0] == xoTurn[2] && (xoTurn[0] == X || xoTurn[0] == O)) {
            winner = xoTurn[0];
            return true;
        }
        if (xoTurn[3] == xoTurn[4] && xoTurn[3] == xoTurn[5] && (xoTurn[3] == X || xoTurn[3] == O)) {
            winner = xoTurn[3];
            return true;
        }
        if (xoTurn[6] == xoTurn[7] && xoTurn[6] == xoTurn[8] && (xoTurn[6] == X || xoTurn[6] == O)) {
            winner = xoTurn[6];
            return true;
        }
        if (xoTurn[0] == xoTurn[3] && xoTurn[0] == xoTurn[6] && (xoTurn[0] == X || xoTurn[0] == O)) {
            winner = xoTurn[0];
            return true;
        }
        if (xoTurn[1] == xoTurn[4] && xoTurn[1] == xoTurn[7] && (xoTurn[1] == X || xoTurn[1] == O)) {
            winner = xoTurn[1];
            return true;
        }
        if (xoTurn[2] == xoTurn[5] && xoTurn[2] == xoTurn[8] && (xoTurn[2] == X || xoTurn[2] == O)) {
            winner = xoTurn[2];
            return true;
        }
        if (xoTurn[0] == xoTurn[4] && xoTurn[0] == xoTurn[8] && (xoTurn[0] == X || xoTurn[0] == O)) {
            winner = xoTurn[0];
            return true;
        }
        if (xoTurn[2] == xoTurn[4] && xoTurn[2] == xoTurn[6] && (xoTurn[2] == X || xoTurn[2] == O)) {
            winner = xoTurn[2];
            return true;
        }
        return false;
    }

    public static void winnerPanel(boolean bool) {
        if (bool) {
            if (winner == X)
                JOptionPane.showMessageDialog(null, "X is the winner");
            else
                JOptionPane.showMessageDialog(null, "O is the winner");
        }
    }
}

