import java.awt.*;

public class MovingBird {
    int xPosition;
    int yPosition;
    int width;
    int length;
    int velocity;
    Rectangle collisionBox;

    public MovingBird(int x, int y, int w, int l){
        xPosition = x;
        yPosition = y;
        width = w;
        length = l;
        collisionBox = new Rectangle(xPosition, yPosition, length, width);
    }

    public void drawBird(Graphics g){
        Color colorBird = new Color(226,226,31);

        yPosition = moveBird(); //update y position of bird
        g.setColor(colorBird);
        g.fillOval(xPosition, yPosition, length, width);
        g.setColor(Color.black);
        g.drawOval(xPosition, yPosition, length, width);


        collisionBox = new Rectangle(xPosition, yPosition, length, width);
    }

    //move bird downwards
    public int moveBird() {
        if (velocity < 15){
            velocity += 7;
        }
        return yPosition += velocity;
    }

    //move bird upwards
    public void fly(){
            velocity = -35;
    }

}