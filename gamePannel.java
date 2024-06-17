import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class gamePannel extends JPanel implements Runnable {

    Thread thread;

    enemyClass[] enm = new enemyClass[10];
    playerClass player = new playerClass();

    gamePannel() {
        super();
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.BLACK);
        for(int i=0; i<enm.length; i++){
            enm[i] = new enemyClass();
        }
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                player.update(e);
                System.out.println(e.getKeyCode());
            }
            public void keyReleased(KeyEvent e){
                player.stop();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<enm.length; i++){
            enm[i].paintComponent(g);
        }
        player.paintComponent(g);
        
    }

    public void startGame() {
        thread = new Thread(this);
        thread.start();
    }

    public void updateGame() {
        for(int i=0; i<enm.length; i++){
            enm[i].updateGame();
        }
        player.move();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / 60; // 1 Frame Per Second
        double deltaTime = 0; // Change Time
        long lastPassedTime = System.nanoTime();
        long currentTime = 0;

        while (thread != null) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastPassedTime) / drawInterval;
            lastPassedTime = currentTime;

            if (deltaTime >= 1) {
                updateGame();
                repaint();
                deltaTime--;
            }
        }

    }
}