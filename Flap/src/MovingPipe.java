import java.awt.*;
import java.util.Random;

public class MovingPipe {
    //width and xPosition of both pipes will be the same
    public int xPosition;
    public int width;
    //length and yPosition of both pipes will be different and will change
    public int yPositionT;
    public int lengthT;
    public int yPositionB;
    public int lengthB;
    //rectangles used for collision detection
    Rectangle collisionBox1;
    Rectangle collisionBox2;

    public int pipeLength = 400;

    public MovingPipe(int x, int y, int w, int l){
        xPosition = x;
        yPositionT = y;
        width = w;
        lengthT = l;
        yPositionB = yPositionT + 600;
        lengthB = lengthT + 50;
    }

    public void movePipeSideways(){
        xPosition -= 25; //move pipe to left
    }

    //Recreate pipe after xPosition reaches 0
    public int repeatPipe(){
        Random x = new Random();

        if (xPosition < 0){
            xPosition = 1000;

            return pipeLength = x.nextInt(400) + 100; //return # between 100 - 400
        }
        return 0;
    }

    public void drawTopPipe(Graphics g){
        Color colorPipe = new Color(0,204,0);
        g.setColor(colorPipe);
        lengthT = pipeLength; //randomize lengthT of pipe
        g.fillRect(xPosition, 0, width, lengthT);
        repeatPipe();
        collisionBox1 = new Rectangle(xPosition, yPositionT, width, lengthT); //set & update rectangle dimensions

    }

    public void drawBottomPipe(Graphics g){
        yPositionB = pipeLength + 200; //randomize y position of pipe
        lengthB = 1000 - pipeLength + 200; // randomize the lengthT of pipe

        Color colorPipe = new Color(0,204,0);
        g.setColor(colorPipe);
        g.fillRect(xPosition, yPositionB, width, lengthB);
        repeatPipe();
        collisionBox2 = new Rectangle(xPosition, yPositionB, width, lengthB); //set & update rectangle dimensions
    }

    public void drawPipes(Graphics g){
        movePipeSideways();
        drawBottomPipe(g);
        drawTopPipe(g);
    }


}
