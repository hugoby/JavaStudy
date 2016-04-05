import javax.swing.*;

/**
 * Package_name PACKAGE_NAME
 * Project_name JavaStudy
 * Created by lenovo on 2015/11/19 1:52
 */

//Frame用于存放用户界面组件
public class MyFrame {
            public static void main(String[]args){
                JFrame frame=new JFrame("Search Engineering");
                frame.setSize(400,300);
                frame.setLocation(50,50);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

