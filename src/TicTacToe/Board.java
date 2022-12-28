package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    public Board() {
        super("Tik Tak Toe");
        setIconImage(new ImageIcon("src/TicTacToe/Photo/tic-tac-toe_icon.png").getImage());
        getContentPane().add(new Grid());
        setSize(new Dimension(300, 300));
        setLocation(810,390);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
