import javax.swing.*;

public class JavaFrame extends JFrame {

    public JavaFrame(){

        JavaPanel javaPanel = new JavaPanel();
        this.setSize(1000,1000);
        this.setVisible(true);
        this.add(javaPanel);
    }


}
