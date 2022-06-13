import java.awt.*;

public class Board{
        public final static int LINE_THICKNESS=14;
        public final static int BOARD_START_X=75;
        public final static int BOARD_START_Y=60;
        public final static int BOARD_WIDTH_HEIGHT=630;
        public final static int LINE_DISTANCE=BOARD_WIDTH_HEIGHT/3;
        public final Color LINE_COLOR=Color.gray;

        private final CustomRectangle boardBase =new CustomRectangle(BOARD_START_X,BOARD_START_Y,BOARD_WIDTH_HEIGHT,BOARD_WIDTH_HEIGHT, Color.gray);

        public void paint(Graphics graphics) {
                this.boardBase.paint(graphics);
        }
}