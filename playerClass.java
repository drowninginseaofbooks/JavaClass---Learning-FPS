
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class playerClass extends JPanel{

    int x=0;
    int y=0;

    int speed = 3;
    int directionX = 0;
    int directionY = 0;

    Image image;

    playerClass(){
        super();
        try{
            image = ImageIO.read(new File("./assets/Ship2.png"));
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawImage(image, x, y, 50, 50, this);
        // g.fillRect(x, y, 50, 50);
    }

    public void update(KeyEvent e){
        int code = e.getKeyCode();
        if(code == 37){
            directionX-=1;
        }
        else if(code == 39){
            directionX+=1;
        }
        else if(code == 38){
            directionY-=1;
        }
        else if(code == 40){
            directionY+=1;
        }
    }

    public void move(){
        x = x + directionX * speed;
        y = y + directionY * speed;
    }

    public void stop(){
        directionX = 0;
        directionY = 0;
    }
}
