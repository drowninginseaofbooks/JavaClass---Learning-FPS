import javax.swing.JFrame;

public class mainClass extends JFrame{
    mainClass(){

        gamePannel pan = new gamePannel();


        add(pan);
        pan.startGame();
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new mainClass();
    }
}