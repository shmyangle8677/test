package xyl.home;

import xyl.home.GUI.Jfd_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 枚举应用
 */
public class ActionTest {
    public static void main(String[] args) {
        //m1();
        Jfd_1 jfdTest = new Jfd_1();
        jfdTest.setVisible(true);

    }

    private static void m1() {
        System.out.println(Color.BLANK.getIndex());
        System.out.println(Color.YELLO.getName());
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mailconfig.properties");
        System.out.println(resourceAsStream);
        InputStream resourceAsStream1 = ActionTest.class.getResourceAsStream("/mailconfig.properties");
        System.out.println(resourceAsStream1);
        URL resource = ActionTest.class.getResource("/mailconfig.properties");
        System.out.println(resource);
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("path::::"+path);
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(new File("D:\\codes\\IdeaProjects\\test\\project1\\src\\main\\resources\\mailconfig.properties"));
            properties.load(fis);
            System.out.println(properties.getProperty("host"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
