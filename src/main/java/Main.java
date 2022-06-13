import javax.swing.*;

public class Main extends JFrame{
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 800;

    Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("X and O");
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        Game game=new Game();
        this.add(game);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}
