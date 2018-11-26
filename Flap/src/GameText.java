import java.awt.*;

public class GameText {

    Font font1 = new Font("Bank Gothic", Font.BOLD, 100);
    Font font2 = new Font ("Bank Gothic", Font.PLAIN, 40);

    public GameText(){
    }

    public void gameOver(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,1000,1000);

        g.setColor(Color.white);
        g.setFont(font1);
        g.drawString("GAME OVER", 180,500);

        g.setColor(Color.white);
        g.setFont(font2);
        g.drawString("Click to Replay", 350, 600);
    }

    public void gameScore(Graphics g, int counter) {
        g.setColor(Color.white);
        g.setFont(font1);
        g.drawString(String.valueOf(counter), 500,100);
    }


}
