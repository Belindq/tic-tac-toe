import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import sun.audio.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


public class TicTacToeGame extends JPanel implements MouseListener, MouseMotionListener 
{
    AudioStream Song2; 
    AudioStream Song3;
    AudioStream Song;// background music
    AudioStream Click; // click sound effect
    AudioStream Switch; // 2nd click sound
    AudioStream Drop; //menu button sounds

    Image title;
    Image background;
    Image xImage;
    Image oImage;
    Image XWin;
    Image OWin;
    Image tie;
    Image shop;
    Image ChooseDifficulty;
    Image ChoosePlayer;
    Image button1;
    Image info;
    Image menubutton1;
    Image menubutton2;
    Image menubutton3;
    Image menushopbutton;
    Image helpshop;
    Image bought;
    Image broke;
    Image help;
    Image coin;
    Image equip;
    Image equiphelp;
    Image help2;
    Image equipped;
    Image notequipped;
    Image board2;
    Image board3;
    Image resetdefault;
    Image unlockpink;
    Image unlockblue;
    Image unlockpurple;
    Image unlockgreen;


    int screen = 1; //what screen we're on
    int players; //how many players
    int turn =1; // whose turn it is( either 1 ot 2)
    int difficulty =1;
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e1 = 0;
    int f = 0;
    int g1 = 0;
    int h = 0;
    int i = 0;
    int money = 0;
    int win =0;
    int player=0;
    //shop items 
    boolean pink= false;
    boolean blue= false;
    boolean green= false;
    boolean purple= false;
    
    // equip shop items
    boolean equippink= false;
    boolean equipblue= false;
    boolean equipgreen= false;
    boolean equippurple= false;

    TicTacToeGame()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
        
        
        //load images
        
        
        try
        {
            title = ImageIO.read(new File("menu2.png"));
            menubutton1 = ImageIO.read(new File("menu1button.png"));
            menubutton2 = ImageIO.read(new File("menu2button.png"));
            menubutton3 = ImageIO.read(new File("menu3button.png"));
            menushopbutton = ImageIO.read(new File("menushopbutton.png"));
            background = ImageIO.read(new File("board.png"));
            xImage = ImageIO.read(new File("X.png"));
            oImage = ImageIO.read(new File("O.png"));
            OWin = ImageIO.read(new File("oWin.png"));
            XWin = ImageIO.read(new File("xWin.png"));
            tie = ImageIO.read(new File("Tie.png"));
            shop = ImageIO.read(new File("Shop.png"));
            button1 = ImageIO.read(new File("button1.png"));
            helpshop = ImageIO.read(new File("helpshop.png"));
            ChooseDifficulty = ImageIO.read(new File("difficulty.png"));
            ChoosePlayer = ImageIO.read(new File("ChoosePlayer.png"));
            info = ImageIO.read(new File("info.png"));
            Song = new AudioStream(new FileInputStream("Song2.wav"));
            Song2 = new AudioStream(new FileInputStream("Song3.wav"));
            Song3 = new AudioStream(new FileInputStream("Song4.wav"));
            Drop = new AudioStream(new FileInputStream("Drop2.wav"));
            bought = ImageIO.read(new File("bought.png"));
            broke = ImageIO.read(new File("broke.png"));
            help = ImageIO.read(new File("help.png"));
            coin = ImageIO.read(new File("coin.png"));
            equip = ImageIO.read(new File("equip.png"));
            equiphelp = ImageIO.read(new File("equiphelp.png"));
            help2 = ImageIO.read(new File("help2.png"));
            equipped = ImageIO.read(new File("equipped.png"));
            notequipped = ImageIO.read(new File("notequipped.png"));
            board2 = ImageIO.read(new File("boardpink.png"));
            board3 = ImageIO.read(new File("boardpurple.png"));
            resetdefault = ImageIO.read(new File("resetdefault.png"));
            unlockpink = ImageIO.read(new File("unlockpink.png"));
            unlockblue = ImageIO.read(new File("unlockblue.png"));
            unlockgreen = ImageIO.read(new File("unlockgreen.png"));
            unlockpurple = ImageIO.read(new File("unlockpurple.png"));
        }
        catch (IOException e)
        {
        }
        //play the song
        
    }

    public void paint(Graphics g)
    {
        if (screen == 1)
        {  
            startScreen(g);
            if(equipgreen == false && equipblue == false)
            {
                AudioPlayer.player.start(Song);
            }
            else if(equipblue ==true)
            {
                AudioPlayer.player.start(Song3);
            }
            else if(equipgreen==true )      
            {
                AudioPlayer.player.start(Song2);
            }
        }
        else if(screen ==2)
        {
            drawBoard(g);
            info(g); 
        }
        else if(screen ==3)
        {
            wait(1000);
            drawOWin(g);
        }
        else if(screen ==4)
        {
            wait(1000);
            drawXWin(g);
        }
        else if(screen ==5)
        {
            wait(1000);
            drawTie(g);
        }
        else if(screen ==6)
        {
            difficulty(g);
        }
        else if(screen ==7)
        {
            Shop(g);
        }
        else if(screen ==8)
        {
            ChoosePlayer(g);
        }
        else if(screen ==9) // button hover
        {
            button1(g);
        }
        else if(screen ==10) // button hover 2
        {
            button2(g);
        }
        else if(screen ==11) // button hover 3
        {
            button3(g);
        }
        else if(screen ==12) // button hover 4
        {
            button4(g);
        }
        else if(screen ==13) //help in the shop
        {
            helpshop(g);
        }
        else if(screen ==14) //successfully bought item
        {
            bought(g);
        }
        else if(screen ==15) // not enough funds
        {
            broke(g);
        }
        else if(screen ==16) //board help 
        {
            help(g);
        }
        else if(screen ==17) // edit items
        {
            equip(g);
        }
        else if(screen ==18) // help button
        {
            equiphelp(g);
        }
        else if(screen ==19) // board help button for single player
        {
            help2(g);
        }
        else if(screen ==20) // successfully equipped
        {
            equipped(g);
        }
        else if(screen ==21) // not equipped
        {
            notequipped(g);
        }
        
    }

    public void startScreen(Graphics g)
    {
        g.setColor(new Color(246,248,253));
        g.fillRect(0,0,1020, 1000);
        g.drawImage(title, 0, 0, null);
    }

    public void drawBoard(Graphics g)
    {
        
        //load baord
        if( equippink ==false && equippurple ==false)
            g.drawImage(background, 0, 0, null);
        else if (equippink ==true)
            g.drawImage(board2, 0, 0, null);
        else if( equippurple ==true)
            g.drawImage(board3, 0, 0, null);
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 45));
        g.drawString(String.valueOf(money), 150, 900);
        g.drawImage(coin, 0, 0, null);
        //X and o icons
        if(a==1)
            g.drawImage(xImage, 198, 188, null);
        else if(a==2)
            g.drawImage(oImage, 198, 188, null);

        if (b == 1)
            g.drawImage(xImage, 410, 188, null);
        else if (b==2)
            g.drawImage(oImage, 410, 188, null);

        if (c == 1)
            g.drawImage(xImage, 620, 188, null);
        else if (c==2)
            g.drawImage(oImage, 620, 188, null);

        if (d == 1)
            g.drawImage(xImage, 195, 400, null);
        else if (d==2)
            g.drawImage(oImage, 195, 400, null);

        if (e1 == 1)
            g.drawImage(xImage, 410, 400, null);
        else if (e1==2)
            g.drawImage(oImage, 410, 400, null);

        if( f == 1)
            g.drawImage(xImage, 620, 400, null);
        else if (f==2)
            g.drawImage(oImage, 620, 400, null);

        if( g1 == 1)
            g.drawImage(xImage, 193, 612, null);
        else if (g1==2)
            g.drawImage(oImage, 193, 612, null);

        if(h == 1)
            g.drawImage(xImage, 410, 612, null);
        else if (h==2)
            g.drawImage(oImage, 410, 612, null);

        if(i == 1)
            g.drawImage(xImage, 620, 612, null);
        else if (i==2)
            g.drawImage(oImage, 620, 612, null);

        checkWinner();
    }

    public void checkWinner()
    {
        // Check if player 1 Wins
        if (a==1 && b==1 && c==1)
            PlayerOneWins();
        else if(d==1 && e1==1 && f==1)
            PlayerOneWins();
        else if(g1==1 && h==1 && i==1)
            PlayerOneWins();
        else if(a==1 && d==1 && g1==1)
            PlayerOneWins();
        else if(b==1 && e1==1 && h==1)
            PlayerOneWins();
        else if(c==1 && f==1 && i==1)
            PlayerOneWins();
        else if(a==1 && e1==1 && i==1)
            PlayerOneWins();
        else if(c==1 && e1==1 && g1==1)
            PlayerOneWins();

        // Check if player 2 wins
        if (a==2 && b==2 && c==2)
            PlayerTwoWins();
        else if(d==2 && e1==2 && f==2)
            PlayerTwoWins();
        else if(g1==2 && h==2 && i==2)
            PlayerTwoWins();
        else if(a==2 && d==2 && g1==2)
            PlayerTwoWins();
        else if(b==2 && e1==2 && h==2)
            PlayerTwoWins();
        else if(c==2 && f==2 && i==2)
            PlayerTwoWins();
        else if(a==2 && e1==2 && i==2)
            PlayerTwoWins();
        else if(c==2 && e1==2 && g1==2)
            PlayerTwoWins();

        //check if there is a tie    
        if (a != 0 && b != 0 && c != 0 && d != 0 && e1 != 0 && f != 0 && g1 != 0 && h != 0 && i !=0)    
            {   
                if (a==1 && b==1 && c==1)
                    PlayerOneWins();
                else if(d==1 && e1==1 && f==1)
                    PlayerOneWins();
                else if(g1==1 && h==1 && i==1)
                    PlayerOneWins();
                else if(a==1 && d==1 && g1==1)
                    PlayerOneWins();
                else if(b==1 && e1==1 && h==1)
                    PlayerOneWins();
                else if(c==1 && f==1 && i==1)
                    PlayerOneWins();
                else if(a==1 && e1==1 && i==1)
                    PlayerOneWins();
                else if(c==1 && e1==1 && g1==1)
                    PlayerOneWins();
                else if (a==2 && b==2 && c==2)
                    PlayerTwoWins();
                else if(d==2 && e1==2 && f==2)
                    PlayerTwoWins();
                else if(g1==2 && h==2 && i==2)
                    PlayerTwoWins();
                else if(a==2 && d==2 && g1==2)
                    PlayerTwoWins();
                else if(b==2 && e1==2 && h==2)
                    PlayerTwoWins();
                else if(c==2 && f==2 && i==2)
                    PlayerTwoWins();
                else if(a==2 && e1==2 && i==2)
                    PlayerTwoWins();
                else if(c==2 && e1==2 && g1==2)
                    PlayerTwoWins();
                else 
                    screen =5;
            }

        if(players == 1 && player ==1 && win ==1 || player ==2 && win ==2) //the player wins the game and earns money
            money+=2;

        repaint();
    }


     public static void wait(int ms) //delay feature
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    
    //reset board
    public void resetBoard()
    {
        win = 0;
        a = 0;
        b = 0;
        c = 0;  
        d = 0;
        e1 = 0;
        f = 0;
        g1 = 0;
        h = 0;
        i = 0;
        
    }

    //menu button
    public void Menu()
    {
        resetBoard();
        screen =1;
        AudioPlayer.player.start(Drop);
    }

    //restart button
    public void Restart()
    {
        resetBoard();
        screen =2;
        AudioPlayer.player.start(Drop);
    }

    public void PlayerOneWins()
    {
        screen = 3;
        win = 1;
    }

    public void PlayerTwoWins()
    {
        screen = 4;
        win = 2;
    }
    
    //draw winning screens
    public void drawXWin(Graphics g)
    {
        g.drawImage(XWin, 0, 0, null);
        money(g);
    }

    public void drawOWin(Graphics g)
    {
        g.drawImage(OWin, 0, 0, null);
        money(g);
    }

    public void drawTie(Graphics g)
    {
        g.drawImage(tie, 0, 0, null);
        money(g);
    }

    public void Shop(Graphics g)
    {
        g.drawImage(shop, 0, 0, null);
        money(g);
    }

    public void difficulty(Graphics g) //choose difficulty pop up
    {
        g.drawImage(ChooseDifficulty, 0, 0, null);
    }

    public void ChoosePlayer(Graphics g) //choose player pop up
    {
        g.drawImage(ChoosePlayer, 0, 0, null);
    }

    public void button1(Graphics g) //hover button 1
    {
        g.drawImage(menubutton1, 0, 0, null);
    }
    
        public void button2(Graphics g) //hover button 2
    {
        g.drawImage(menubutton2, 0, 0, null);
    }
    
        public void button3(Graphics g) //hover button 3
    {
        g.drawImage(menubutton3, 0, 0, null);
    }
    
        public void button4(Graphics g) //hover button 4
    {
        g.drawImage(menushopbutton, 0, 0, null);
    }

    public void info(Graphics g) //info hover
    {
        g.drawImage(info, 0, 0, null);
    }
    
    public void helpshop(Graphics g) //info hover for the shop
    {
        g.drawImage(helpshop, 0, 0, null);
    }

    public void bought(Graphics g) // successfully bought pop up
    {
        g.drawImage(bought, 0, 0, null);
    }
    
    public void broke(Graphics g) // not enough money pop up
    {
        g.drawImage(broke, 0, 0, null);
    }
    
     public void help(Graphics g) // help/info hover for single player
    {
        g.drawImage(help, 0, 0, null);
    }
    
    public void equip(Graphics g) // equip menu
    {
        g.drawImage(equip, 0, 0, null);
        g.drawImage(resetdefault, 0, 0, null);
   
        if (pink ==true)
            g.drawImage(unlockpink, 0, 0, null);
        if(blue ==true)
            g.drawImage(unlockblue, 0, 0, null);   
        if(green ==true)
            g.drawImage(unlockgreen, 0, 0, null);
        if(purple ==true)
            g.drawImage(unlockpurple, 0, 0, null);
        
    
    }
    
    
    public void equiphelp(Graphics g) //info hover for equip menu
    {
        g.drawImage(equiphelp, 0, 0, null);
    }
    
    public void money(Graphics g) // money display
    {
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 45));
        g.drawString(String.valueOf(money), 150, 900);
        g.drawImage(coin, 0, 0, null);
    }
    
    public void help2(Graphics g) // help for 2 players
    {
        g.drawImage(help2, 0, 0, null);
    }    
    
    public void equipped(Graphics g) // equipped pop up
    {
        g.drawImage(equipped, 0, 0, null);
    } 
    
    public void notequipped(Graphics g) // not equipped pop up
    {
        g.drawImage(notequipped, 0, 0, null);
    } 
    
    public void mousePressed(MouseEvent e)
    {
        // load sounds
        try
        {
            Click = new AudioStream(new FileInputStream("Click2.wav"));
            Switch = new AudioStream(new FileInputStream("Switch2.wav"));
            Drop = new AudioStream(new FileInputStream("Drop2.wav"));
        }
        catch (IOException ea)
        {
        }

        int x = e.getX();
        int y = e.getY(); //get x and y coordinates 

        if(screen ==1 || screen == 9 || screen == 10 || screen ==11 || screen ==12) // on the title screen
        {
            if(x>= 400 &&x<= 600 && y >= 483 && y<= 591) // player 1 button
            {
                screen = 6;
                players = 1;
                AudioPlayer.player.start(Drop);
            }
            if(x>= 400 && x<= 600 && y>=611 && y<=653) // player 2 button
            {
                screen = 2;
                players = 2;
                AudioPlayer.player.start(Drop);
            }
            if(x>=0 && x<= 238 && y>= 766 && y<= 899) //shop
            {
                screen =7;
                AudioPlayer.player.start(Drop);
            }
            if(x>= 400 && x<= 600 && y>= 676 && y<= 716) // edit button
            {
                screen = 17;
                AudioPlayer.player.start(Drop);
            }
        }
        else if(screen == 2 && players == 2) //on the playing board with 2 players
        {
            player=0;
            if(x>=0 && x<=125 && y>=0 && y<=125)//menu button
            {
                Menu();
            }
            if (x>=190 && x<=395 && y>=185 && y<=388 && a == 0) // clicked on box a
            {
                if( turn == 1)
                {
                    a = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                }
                else 
                {   a = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                }
            }
            if(x>=410 && x<=612 && y>=185 && y<=388 && b == 0) // box b
            {
                if( turn == 1)
                {
                    b = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                }
                else 
                {   b = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                }
            }
            if(x>=620 && x<=820 && y>=185 && y<=388 && c ==0)//box c
            {
                if(turn == 1)
                {
                    c = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                }
                else
                {
                    c = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                }
            }
            if(x>=204 && x<=400 && y>=400 && y<=600 && d ==0) //box d
            {
                if(turn == 1)
                {
                    d = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                }
                else
                {
                    d = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                }
            }
            if(x>=407 && x<=607 && y>=400 && y<=600 && e1 ==0) //box e1
            {
                if(turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                }
                else
                {
                    e1 = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                }
            }
            if(x>=620 && x<=816 && y>=400 && y<=600 && f ==0) //box f
            {
                if(turn == 1)
                {
                    f = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                }
                else
                {
                    f = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                }
            }
            if(x>=190 && x<=394 && y>=612 && y<=812 && g1 ==0)//box g1
            {
                if(turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                }
                else
                {
                    g1 = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                }
            }
            if(x>=410 && x<=607 && y>=612 && y<=812 &&  h==0)//box h
            {
                if(turn == 1)
                {
                    h = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                }
                else
                {
                    h = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                }
            }
            if(x>=620 && x<=820 && y>=612 && y<=816 &&  i==0)//box i
            {
                if(turn == 1)
                {
                    i = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                }
                else
                {
                    i = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                }
            }
        }
        else if(screen == 2 && players == 1 ) //one player
        {
            if(x>=0 && x<=125 && y>=0 && y<=125)//menu button
            {
                screen =1;
                AudioPlayer.player.start(Drop);
            }
            if (x>=190 && x<=395 && y>=185 && y<=388 && a == 0) // clicked on box a
            {
                if( turn == 1)
                {
                    a = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                    computerMove();
                }
                else 
                {   a = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                    computerMove();
                }
            }
            if(x>=410 && x<=612 && y>=185 && y<=416 && b == 0) // box b
            {
                if( turn == 1)
                {
                    b = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                    computerMove();
                }
                else 
                {   b = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                    computerMove();
                }
            }
            if(x>=620 && x<=820 && y>=185 && y<=388 && c ==0)//box c
            {
                if(turn == 1)
                {
                    c = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                    computerMove();
                }
                else
                {
                    c = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                    computerMove();
                }
            }
            if(x>=204 && x<=410 && y>=400 && y<=600 && d ==0) //box d
            {
                if(turn == 1)
                {
                    d = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                    computerMove();
                }
                else
                {
                    d = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                    computerMove();
                }
            }
            if(x>=407 && x<=607 && y>=400 && y<=600 && e1 ==0) //box e1
            {
                if(turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                    computerMove();
                }
                else
                {
                    e1 = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                    computerMove();
                }
            }
            if(x>=620 && x<=816 && y>=400 && y<=600 && f ==0) //box f
            {
                if(turn == 1)
                {
                    f = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                    computerMove();
                }
                else
                {
                    f = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                    computerMove();
                }
            }
            if(x>=190 && x<=416 && y>=612 && y<=816 && g1 ==0)//box g1
            {
                if(turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                    computerMove();
                }
                else
                {
                    g1 = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                    computerMove();
                }
            }
            if(x>=410 && x<=612 && y>=612 && y<=816 &&  h==0)//box i
            {
                if(turn == 1)
                {
                    h = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                    computerMove();
                }
                else
                {
                    h = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                    computerMove();
                }
            }
            if(x>=620 && x<=820 && y>=612 && y<=816 &&  i==0)//box i
            {
                if(turn == 1)
                {
                    i = 1;
                    turn = 2;
                    AudioPlayer.player.start(Click);
                    computerMove();
                }
                else
                {
                    i = 2;
                    turn = 1;
                    AudioPlayer.player.start(Switch);
                    computerMove();
                }
            }
        }

        //ending screens
        else if(screen == 3) // white wins
        {
            if(x>=0 && x<=125 && y>=0 && y<=115)//menu button
            {
                Menu();
                
            }
            if(x>=0 && x<=125 && y>=135 && y<=240)//restart button
            {
                Restart();
            }

        }
        else if(screen == 4)// black wins
        {
            if(x>=0 && x<=125 && y>=0 && y<=115)//menu button
            {
                Menu();
            }
            if(x>=0 && x<=125 && y>=135 && y<=240)//restart button
            {
                Restart();
            }
        }
        else if(screen == 5) // tie
        {
            if(x>=0 && x<=125 && y>=0 && y<=155)//menu button
            {
                Menu();
            }
            if(x>=0 && x<=125 && y>=135 && y<=240)//restart button
            {
                Restart();
            }
        }
        else if(screen == 6) // difficulty choose pop up
        {
            if(x>=115&& x<=434 && y>= 413 && y<= 513) // normal
            {
                resetBoard();
                difficulty = 1;
                screen =8;
                AudioPlayer.player.start(Drop);
            }
            if(x>=610 && x<=900 && y>=413 && y<=513) // harder
            {   
                resetBoard();
                difficulty =2;
                screen =8;
                AudioPlayer.player.start(Drop);
            }
            if(x>=850 && x<= 918 && y>= 201 && y<= 266) //  exit button
            {
                screen=1;
                AudioPlayer.player.start(Drop);
            }
        }
        else if(screen == 8) // choose player pop up
        {
            if(x>=730 && x<=768 && y>= 189 && y<= 225) // exit button
            {
                screen =6;
                AudioPlayer.player.start(Drop);
            }
            if(x>= 535 && x<= 705 && y>= 385 && y<=560)// white
            {
                turn =1;
                screen =2;
                player = 1;
                AudioPlayer.player.start(Drop);
            }
            if(x>=272 && x<= 450 && y>=385 && y<=560) // black
            {
                turn =2;
                screen =2;
                player =2;
                AudioPlayer.player.start(Drop);
            }
        }
        else if(screen==7) //shop
        {
            if(x>=0 && x<=125 && y>=0 && y<=125)//menu button
            {
                Menu();
            }
            if(x>= 95 && x<=286 && y>=307 && y<=499) //buying pink board
            {
                if(money >= 5 && pink ==false)
                {
                    pink = true;
                    screen =14;
                    money-=5;
                }
                else if(money >= 5 && pink==true)
                {
                    pink = true;
                    screen =14;
                }
                else
                    screen = 15;
            }
            if(x>= 415  && x<=618 && y>=307 && y<=499) //buying blue baord
            {
                if(money >= 5 && blue == false)
                {
                    blue = true;
                    screen =14;
                    money-=5;
                }
                  else if(money >= 5 && blue==true)
                {
                    blue = true;
                    screen =14;
                }
                else
                    screen = 15;
            }
            if(x>= 713 && x<=913 && y>=307 && y<=499)
            {
                if(money >= 10 && green == false)
                {
                    green = true;
                    screen =14;
                    money-=10;
                }
                  else if(money >= 10 && green==true)
                {
                    green = true;
                    screen =14;
                }
                else
                
                    screen = 15;
            }
            if(x>= 95 && x<=286 && y>=558 && y<=755)
            {
                if(money >= 7 && purple == false)
                {
                   purple = true;
                    screen =14;
                    money-=7;
                }
                else if(money >= 7 && purple==true)
                {
                    purple = true;
                    screen =14;
                }
                else
                    screen = 15;
            }
        }
        else if (screen == 14) // bought it pop up
        {
            if(x>=850 && x<= 918 && y>= 201 && y<= 266) //  exit button
            {
                screen=7;
                AudioPlayer.player.start(Drop);
            }
        }
        else if (screen == 15) // too broke pop up
        {
            if(x>=850 && x<= 918 && y>= 201 && y<= 266) //  exit button
            {
                screen=7;
                AudioPlayer.player.start(Drop);
            }
        }
        else if(screen ==17) //edit screen to equip items
        {

            if(x>=0 && x<=125 && y>=0 && y<=125)//menu button
            {
                Menu();
            }
            if(x>= 95 && x<=286 && y>=307 && y<=499) //equip pink board
            {
                AudioPlayer.player.start(Drop);
                if(pink == true)
                {
                    equippink =true;
                    equippurple=false;
                    screen=20;
                }
                else
                    screen = 21;
            }
            if(x>= 415  && x<=618 && y>=307 && y<=499) //equip blue soundtrack
            {
                AudioPlayer.player.start(Drop);
                if(blue == true)
                {
                    equipblue =true;
                    equipgreen =false;
                    AudioPlayer.player.stop(Song);
                    AudioPlayer.player.stop(Song2);
                    AudioPlayer.player.start(Song3);
                    screen=20;
                }
                else
                    screen = 21;
            }
            if(x>= 713 && x<=913 && y>=307 && y<=499) //equip green soundtrack
            {
                AudioPlayer.player.start(Drop);
                if(green == true)
                {
                    equipgreen =true;
                    equipblue =false;
                    AudioPlayer.player.stop(Song);
                    AudioPlayer.player.start(Song2);
                    AudioPlayer.player.stop(Song3);
                    screen=20;
                }
                else
                    screen = 21;
            }
            if(x>= 95 && x<=286 && y>=558 && y<=755) //equip purple board
            {
                AudioPlayer.player.start(Drop);
                if(purple == true)
                {
                    equippurple =true;
                    equippink=false;
                    screen=20;
                }
                else
                    screen = 21;
                    
            }
            if(x>=0 && x<=125 && y>=135 && y<=240) //reset to default settings
            {
                equippink =false;
                equippurple =false;
                equipblue=false;
                equipgreen=false;
                AudioPlayer.player.stop(Song2);
                AudioPlayer.player.stop(Song3);
                AudioPlayer.player.start(Song);
                AudioPlayer.player.start(Drop);
            }
        }
        else if (screen ==20) // successfully eqipped
        {
            if(x>=850 && x<= 918 && y>= 201 && y<= 266) //  exit button
            {
                screen=17;
                AudioPlayer.player.start(Drop);
            }
        }
        else if (screen == 21) // need to buy pop up
        {
            if(x>=850 && x<= 918 && y>= 201 && y<= 266) //  exit button
            {
                screen=17;
                AudioPlayer.player.start(Drop);
            }
        }
        

        repaint();

    }

    public void computerMove()
    {
        if (turn == 2 && difficulty ==2)  //harder ai starting with x
        {
           
            //defense
            if (a==1 && b==1 && c==0)
                c=2;
            else if (a==1 && c==1 && b==0)
                b=2;
            else if (b==1 && c==1 && a==0)
                a=2;
            else if (d==1 && e1==1 && f==0)
                f=2;
            else if (d==1 && f==1 && e1==0)
                e1=2;
            else if (e1==1 && f==1 && d==0)
                d=2;
            else if (g1==1 && h==1 && i==0)
                i=2;
            else if (g1==1 && i==1 && h==0)
                h=2;
            else if (h==1 && i==1 && g1==0)
                g1=2;
            else if (a==1 && d==1 && g1==0)
                g1=2;
            else if (a==1 && g1==1 && d==0)
                d=2;
            else if (d==1 && g1==1 && a==0)
                a=2;
            else if (b==1 && e1==1 && h==0)
                h=2;
            else if (b==1 && h==1 && e1==0)
                e1=2;
            else if (e1==1 && h==1 && b==0)
                b=2;
            else if (c==1 && f==1 && i==0)
                i=2;
            else if (c==1 && i==1 && f==0)
                f=2;
            else if (f==1 && i==1 && c==0)
                c=2;
            else if (a==1 && e1==1 && i==0)
                i=2;
            else if (a==1 && i==1 && e1==0)
                e1=2;
            else if (e1==1 && i==1 && a==0)
                a=2;
            else if (c==1 && e1==1 && g1==0)
                g1=2;
            else if (c==1 && g1==1 && e1==0)
                e1=2;
            else if (e1==1 && g1==1 && c==0)
                c=2;
                
           else if (e1==0)
                e1=2;
            else if(g1== 0)
                g1=2;
            else if(a== 0)
                a=2;
            else if(b== 0)
                b=2;
            else if(c== 0)
                c=2; 
            else if(d== 0)
                d=2;  
            else if(f== 0)
                f=2; 
            else if(h== 0)
                h=2;  
            else if(i== 0)
                i =2;

            turn =1;
        }
        else if (turn ==1 && difficulty ==2) //harder ai starting on o
        {
            //defensive play
            if (a==2 && b==2 && c==0 )
                c=1;
            else if (a==2 && c==2 && b==0)
                b=1;
            else if (b==2 && c==2 && a==0)
                a=1;
            else if (d==2 && e1==2 && f==0)
                f=1;
            else if (d==2 && f==2 && e1==0)
                e1=1;
            else if (e1==2 && f==2 && d==0)
                d=1;
            else if (g1==2 && h==2 && i==0)
                i=1;
            else if (g1==2 && i==2 && h==0)
                h=1;
            else if (h==2 && i==2 && g1==0)
                g1=1;
            else if (a==2 && d==2 && g1==0)
                g1=1;
            else if (a==2 && g1==2 && d==0)
                d=1;
            else if (d==2 && g1==2 && a==0)
                a=1;
            else if (b==2 && e1==2 && h==0)
                h=1;
            else if (b==2 && h==2 && e1==0)
                e1=1;
            else if (e1==2 && h==2 && b==0)
                b=1;
            else if (c==2 && f==2 && i==0)
                i=1;
            else if (c==2 && i==2 && f==0)
                f=1;
            else if (f==2 && i==2 && c==0)
                c=1;
            else if (a==2 && e1==2 && i==0)
                i=1;
            else if (a==2 && i==2 && e1==0)
                e1=1;
            else if (e1==2 && i==2 && a==0)
                a=1;
            else if (c==2 && e1==2 && g1==0)
                g1=1;
            else if (c==2 && g1==2 && e1==0)
                e1=1;
            else if (e1==2 && g1==2 && c==0)
                c=1;
                
            else if (e1==0)
                e1=1;
            else if(g1== 0)
                g1=1;
            else if(a== 0)
                a=1;
            else if(b== 0)
                b=1;
            else if(c== 0)
                c=1; 
            else if(d== 0)
                d=1;  
            else if(f== 0)
                f=1; 
            else if(h== 0)
                h=1;  
            else if(i== 0)
                i =1;    
            turn =2;
        }
        // easier difficulty
        else if( turn == 1 && difficulty == 1) 
        {
            if (e1==0)
                e1=1;
            else if(g1== 0)
                g1=1;
            else if(a== 0)
                a=1;
            else if(b== 0)
                b=1;
            else if(c== 0)
                c=1; 
            else if(d== 0)
                d=1;  
            else if(f== 0)
                f=1; 
            else if(h== 0)
                h=1;  
            else if(i== 0)
                i =1;
            turn =2;
        }
        else if( turn == 2 && difficulty == 1)
        {
            if (e1==0)
                e1=2;
            else if(g1== 0)
                g1=2;
            else if(a== 0)
                a=2;
            else if(b== 0)
                b=2;
            else if(c== 0)
                c=2; 
            else if(d== 0)
                d=2;  
            else if(f== 0)
                f=2; 
            else if(h== 0)
                h=2;  
            else if(i== 0)
                i =2;
            turn =1;
        }
    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseMoved(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY(); //get x and y coordinates 
        if(screen ==1 || screen ==9 || screen == 10 || screen ==11 || screen ==12 )
        {
            
            if(x>= 400 &&x<= 600 && y >= 483 && y<= 591) // player 1 button
            {
                screen = 9;
    
            }
            else if (x>= 400 && x<= 600 && y>=611 && y<=653 ) //player 2
            {
                screen = 10;
            }
            else if(x>= 400 && x<= 600 && y>= 676 && y<= 716) // edit button
            {
                screen = 11;
            }
            else if(x>=0 && x<= 238 && y>= 766 && y<= 899 ) //shop
            {
                screen =12;
            }
            
            else 
            {
                screen = 1;
            }
            repaint();
        }
        if(screen == 7 || screen ==13)
        {
            if( x>= 850 && x<= 971 && y>=816 && y<=925) // help info
                screen = 13 ;
            else 
                screen =7;
            repaint();
        }
        if(screen == 2 || screen ==16)
        {
            if( x>= 850 && x<= 971 && y>=816 && y<=925) // help info for board
                screen = 16;
            else 
                screen =2;
            repaint();
        }

        if(screen ==17 || screen == 18)
        {
            if( x>= 850 && x<= 971 && y>=816 && y<=925) // help info
                screen = 18;
            else 
                screen =17;
            repaint();
        }
    }

    public void mouseExited(MouseEvent e)
    {

    }

    public void mouseDragged(MouseEvent e)
    {
    }


}

  