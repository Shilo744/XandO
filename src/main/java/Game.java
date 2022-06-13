import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
private Board board=new Board();
private final int START_POSITION=0;
private  XandOBottom [] xAndOBottom =new XandOBottom[9];
private final int CORRECTION=2;
private boolean xTorn=true;
private int victoryO=0;
private int victoryX=0;
private final JButton REPLAY =new JButton();
private TextField scoreX=new TextField();
private TextField scoreO =new TextField();
private final int SCORE_FONT_SIZE=20;
Game(){
        this.setBounds(START_POSITION,START_POSITION,Main.WINDOW_WIDTH,Main.WINDOW_HEIGHT);
        this.setLayout(null);
        this.setDoubleBuffered(true);
        REPLAY.setText("replay");
        REPLAY.setBounds(335,5,100,50);
        REPLAY.addActionListener((e)->{resetGame();});
        scoreX.setBounds(285,5,50,50);
        scoreO.setBounds(440,5,50,50);
        scoreX.setText("X="+victoryX);
        scoreO.setText("O="+ victoryO);
        scoreX.setEnabled(false);
        scoreO.setEnabled(false);
        scoreX.setFont(new Font("arial", Font.BOLD, SCORE_FONT_SIZE));
        scoreO.setFont(new Font("arial", Font.BOLD, SCORE_FONT_SIZE));
        add(REPLAY);
        add(scoreX);
        add(scoreO);

    newGame();
}
public void newGame(){
    int k=0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            xAndOBottom[k]=new XandOBottom(Board.BOARD_START_X+Board.LINE_DISTANCE*(i)+CORRECTION,Board.BOARD_START_Y+Board.LINE_DISTANCE*(j)+CORRECTION);
            this.add(xAndOBottom[k]);
            int finalK = k;
            xAndOBottom[k].addActionListener((e)->{
                if(!(xAndOBottom[finalK].isClicked())){
                    xAndOBottom[finalK].setClicked(true);
                    xAndOBottom[finalK].applyText(xTorn);
                    xTorn=!xTorn;
                    checkVictory();
                }
            });
            k++;
        }
    }
}
public void checkVictory(){
    int[]locations=new int[xAndOBottom.length];
    //check line
    for (int i = 0; i < xAndOBottom.length; i++) {
    locations[i]=xAndOBottom[i].getMark();
    }
    //line win
    checkStraight(locations[0],locations[1],locations[2]);
    checkStraight(locations[3],locations[4],locations[5]);
    checkStraight(locations[6],locations[7],locations[8]);
    //row win
    checkStraight(locations[0],locations[3],locations[6]);
    checkStraight(locations[1],locations[4],locations[7]);
    checkStraight(locations[2],locations[5],locations[8]);
    //cross win
    checkStraight(locations[0],locations[4],locations[8]);
    checkStraight(locations[2],locations[4],locations[6]);

}
public void checkStraight(int a,int b,int c){
if(a>0 && a==b && b==c){
    String winner;
    if(a==1){winner="X";
    victoryX++;
        scoreX.setText("X="+victoryX);
    }
    else{
        winner="O";
        victoryO++;
        scoreO.setText("O="+victoryO);
    }
for (int i = 0; i < xAndOBottom.length; i++) {
        xAndOBottom[i].setClicked(true);
    xAndOBottom[i].setText(winner);
    }
    xAndOBottom[1].setText("W");
    xAndOBottom[4].setText("O");
    xAndOBottom[7].setText("N");

}
}
public void resetGame(){
        for (int i = 0; i < xAndOBottom.length; i++) {
            xAndOBottom[i].reset();
        }
        xTorn=true;
}
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        this.board.paint(graphics);
    }
}
