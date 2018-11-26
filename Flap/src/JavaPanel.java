import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import java.util.Timer;

public class JavaPanel extends JPanel{

    int score;
    boolean gameover = false;
    public int yBird = 400;

    MovingBird bird = new MovingBird(350, yBird, 50, 50);
    MovingPipe pipes = new MovingPipe(800, 0, 80, 350);
    Rectangle groundBox = new Rectangle(0, 900, 1000, 100);
    GameText gameText = new GameText();

    public JavaPanel() {
        this.setSize(1000, 1000);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!gameover) {
                    //Make bird fly up on mouse press
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent mouseEvent) {
                            mouseDetect();
                        }
                    });

                }
                repaint();
            }
        };
        timer.schedule(task, 100, 60);
    }

    public void paintComponent(Graphics g) {
        if (!gameover) {

            //set basic colours for environment
            Color colorSky = new Color(33, 228, 235);
            Color colorGrass = new Color(0, 102, 0);
            Color colorDirt = new Color (153, 102,51);

            g.setColor(colorSky);
            g.fillRect(0, 0, 1000, 1000);

            //draw and update Pipes
            pipes.drawPipes(g);

            //environment
            g.setColor(colorGrass);
            g.fillRect(0, 900, 1000, 100);
            g.setColor(colorDirt);
            g.fillRect(0,920,1000,100);

            //draw and update bird
            bird.drawBird(g);

            //check for collisions
            if (bird.collisionBox.intersects(pipes.collisionBox2)) {
                gameover = true;
            } else if (bird.collisionBox.intersects(pipes.collisionBox1)) {
                gameover = true;
            } else if (bird.collisionBox.intersects(groundBox) || bird.yPosition < 0) {
                gameover = true;
            }

            //Keep score
            gameText.gameScore(g, score);
            if (bird.xPosition == pipes.xPosition) {
                score++;
            }

        } else if (gameover) {
            gameText.gameOver(g);
        }
    }

    //conditions for button click
    public void mouseDetect() {
        if (!gameover) {
            //move bird upwards
            bird.fly();
        } else if (gameover) {
            //reset bird
            yBird = 400;
            bird.yPosition = yBird;

            //reset pipes
            pipes.xPosition = 800;
            pipes.yPositionT = 0;
            pipes.lengthT = 350;

            score = 0;
            gameover = false;
        }
    }
}
