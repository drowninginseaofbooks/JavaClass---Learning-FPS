
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class enemyClass extends JPanel{

    Random randNum = new Random();

    private Image asteroidPNG;

    int x = randNum.nextInt(500);
    int y = randNum.nextInt(200);

        enemyClass(){
        super();
        // spaceShip = ImageIO.read(new File("/assets/ship2.png"));
        try{
            asteroidPNG = ImageIO.read(new File("./assets/aesteroid.png"));
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(asteroidPNG, x, y, 30, 30, this);
        // g.setColor(Color.red);
        // g.fillRect(x , y, 100, 100);
    }

    public void updateGame(){
        y += 1;
    }
}
