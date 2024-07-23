import javax.swing.JFrame;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import sun.audio.*;
public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1020, 1000); 
        frame.setTitle("TicTacToe");  
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TicTacToeGame game = new TicTacToeGame();
        
        frame.add(game);
        frame.setVisible(true);
       
    }
    
}
        