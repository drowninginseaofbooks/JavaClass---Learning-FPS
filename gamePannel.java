
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class gamePannel extends JPanel implements Runnable{

    int x =0;
    int y=0;

    Thread thread;

    gamePannel(){
        super(); 
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(x, 50, 100, 100);
    }

    public void startGame(){
        thread = new Thread(this);
        thread.start();
    }

    public void updateGame(){

    }

    @Override
    public void run(){
        double drawInterval = 1000000000/60; //1 Frame Per Second
        double deltaTime = 0; //Change Time
        long lastPassedTime = System.nanoTime();
        long currentTime = 0;

        while (thread != null) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastPassedTime)/drawInterval;
            lastPassedTime = currentTime;

            if(deltaTime >= 1){
                x+=5;
                repaint();
                deltaTime--;
            }
        }
    }
}
