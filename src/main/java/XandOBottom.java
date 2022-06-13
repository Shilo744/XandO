import javax.swing.*;
import java.awt.*;

public class XandOBottom extends JButton {
        private final int X;
        private final int Y;
        private static final int Width=205;
        private final int height=205;
        private final int FONT_SIZE=150;
        private final String X_LETTER="X";
        private final String O_LETTER="O";
        private boolean clicked=false;
        private int mark=0;

    XandOBottom(int x,int y){
            this.X=x;
            this.Y=y;
            setBounds(X,Y,Width,height);
            setFont(new Font("arial", Font.BOLD, FONT_SIZE));
            setBackground(Color.lightGray);
        }
        public void applyText(boolean x){
            if(x){
                setText(X_LETTER);
            setForeground(Color.red);
            mark=1;}
            else{
                setText(O_LETTER);
                setForeground(Color.blue);
                mark=2;
            }
        }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public int getMark() {
        return mark;
    }
    public void reset(){
        setText(null);
        clicked=false;
        mark=0;
    }
}
