import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ExtendedLauncher extends JFrame {
    double version = 1.3;
    String name = "ExtendedLauncher";
    String versionString = "1.3";
    public ExtendedLauncher(){
        super("Loading Launcher...");
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Launching...");

        int w = 700;
        int h = 500;

        //load file saves
        String save1 = ReadFile.readFile("assets/save1.sav");
        String save2 = ReadFile.readFile("assets/save2.sav");
        String save3 = ReadFile.readFile("assets/save3.sav");

        ExtendedLauncher extendedLauncher = new ExtendedLauncher();
        extendedLauncher.setLayout(null);
        extendedLauncher.setSize(w, h);
        extendedLauncher.setResizable(false);
        extendedLauncher.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //BufferedImage myPicture = ImageIO.read(new File("assets/fvec.png"));
        BufferedImage myPicture = null;
        Random r = new Random();
        int rp = r.nextInt(4);
        if(rp == 0){
            myPicture = ImageIO.read(new File("assets/screenshot.png"));
        }
        else if(rp == 1){
            myPicture = ImageIO.read(new File("assets/screenshot2.png"));
        }
        else if(rp == 2){
            myPicture = ImageIO.read(new File("assets/screenshot3.png"));
        }
        else if(rp == 3){
            myPicture = ImageIO.read(new File("assets/screenshot4.png"));
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        JPanel imgPanel = new JPanel();
        imgPanel.setBounds(-200, -250, 1000, 1000);
        imgPanel.add(picLabel);

        //ImageIcon img = new ImageIcon("assets/fleckvec.png");
        ImageIcon img = new ImageIcon("assets/icon.png");
        extendedLauncher.setIconImage(img.getImage());

        JLabel winSubtitle = new JLabel(extendedLauncher.name, null, SwingConstants.CENTER);
        winSubtitle.setBounds((w/2)-20, h/2, w, 20);
        winSubtitle.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        JButton button = new JButton("Launch");

        JPanel panel = new JPanel();
        panel.setBounds(0,h - 69, w + 10, 30);

        JPanel notifyLabelPanel = new JPanel();
        JLabel notifyLabel = new JLabel(MOTSGen.getMOTS());
        notifyLabel.setBounds(10, h - 20, w, 20);
        notifyLabelPanel.add(notifyLabel);


        String[] choices = { "Windows 10","Linux (Not tested!)"};
        JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setBounds(0, 0, 125, 25);
        cb.setVisible(true);


        JTextField patf = new JTextField("", 15);

        String[] choices2 = { "Custom dir", "Current dir", "Save 1", "Save 2", "Save 3"};
        JComboBox<String> cb2 = new JComboBox<String>(choices2);
        cb2.setBounds(0, 0, 125, 25);
        cb2.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb.getSelectedIndex() == 0){
                    if(cb2.getSelectedIndex() == 0){
                        Runtime rt = Runtime.getRuntime();
                        try {
                            notifyLabel.setText("Launching...");
                            rt.exec(new String[]{patf.getText() + "\\bin\\minetest.exe"});
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                    else if(cb2.getSelectedIndex() == 1){
                        Runtime rt = Runtime.getRuntime();
                        try {
                            notifyLabel.setText("Launching...");
                            rt.exec(new String[]{".\\bin\\minetest.exe"});
                            notifyLabel.setText(MOTSGen.getMOTS());
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                    else if(cb2.getSelectedIndex() == 2){
                        Runtime rt = Runtime.getRuntime();
                        try {
                            notifyLabel.setText("Launching...");
                            rt.exec(new String[]{save1 + "\\bin\\minetest.exe"});
                            notifyLabel.setText(MOTSGen.getMOTS());
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                    else if(cb2.getSelectedIndex() == 3){
                        Runtime rt = Runtime.getRuntime();
                        try {
                            notifyLabel.setText("Launching...");
                            rt.exec(new String[]{save2 + "\\bin\\minetest.exe"});
                            notifyLabel.setText(MOTSGen.getMOTS());
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                    else if(cb2.getSelectedIndex() == 4){
                        Runtime rt = Runtime.getRuntime();
                        try {
                            notifyLabel.setText("Launching...");
                            rt.exec(new String[]{save3 + "\\bin\\minetest.exe"});
                            notifyLabel.setText(MOTSGen.getMOTS());
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                }
                else if(cb.getSelectedIndex() == 1){
                    if(cb2.getSelectedIndex() == 0){
                        Runtime rt = Runtime.getRuntime();
                        try {
                            notifyLabel.setText("Launching...");
                            rt.exec(new String[]{patf.getText() + "/bin/minetest.out"});
                            notifyLabel.setText(MOTSGen.getMOTS());

                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                    else if(cb2.getSelectedIndex() == 1){
                        Runtime rt = Runtime.getRuntime();
                        try {
                            notifyLabel.setText("Launching...");
                            rt.exec(new String[]{"./bin/minetest.out"});
                            notifyLabel.setText(MOTSGen.getMOTS());
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                }
            }
        });

        JButton runSaveOne = new JButton();
        runSaveOne.setText("Save 1");
        runSaveOne.setBounds(125, 0, 100, 20);
        runSaveOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime rt = Runtime.getRuntime();
                try {
                    notifyLabel.setText("Launching...");
                    rt.exec(new String[]{save1 + "\\bin\\minetest.exe"});
                    notifyLabel.setText(MOTSGen.getMOTS());
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });

        JButton runSaveTwo = new JButton();
        runSaveTwo.setText("Save 2");
        runSaveTwo.setBounds(225, 0, 100, 20);
        runSaveTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime rt = Runtime.getRuntime();
                try {
                    notifyLabel.setText("Launching...");
                    rt.exec(new String[]{save2 + "\\bin\\minetest.exe"});
                    notifyLabel.setText(MOTSGen.getMOTS());
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });

        JButton runSaveThree = new JButton();
        runSaveThree.setText("Save 3");
        runSaveThree.setBounds(325, 0, 100, 20);
        runSaveThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime rt = Runtime.getRuntime();
                try {
                    notifyLabel.setText("Launching...");
                    rt.exec(new String[]{save3 + "\\bin\\minetest.exe"});
                    notifyLabel.setText(MOTSGen.getMOTS());
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });

        extendedLauncher.getContentPane().add(panel);
        extendedLauncher.getContentPane().add(winSubtitle);
        extendedLauncher.getContentPane().add(panel, BorderLayout.NORTH);
        extendedLauncher.getContentPane().add(winSubtitle, BorderLayout.NORTH);
        extendedLauncher.add(cb);
        panel.add(cb2);
        panel.add(patf);
        panel.add(button);
        panel.add(notifyLabelPanel);
        winSubtitle.setBounds(0, 0, w, h);
        extendedLauncher.add(winSubtitle);

        extendedLauncher.add(runSaveOne);
        extendedLauncher.add(runSaveTwo);
        extendedLauncher.add(runSaveThree);

        extendedLauncher.add(imgPanel);
        extendedLauncher.setVisible(true);


        //loading code here

        extendedLauncher.setTitle(extendedLauncher.name + " v" + extendedLauncher.versionString);
    }

    public static class MOTSGen {
        public static String getMOTS(){
            Random r = new Random();
            int rn = r.nextInt(3);
            if(rn == 0){
                return "GET REKT";
            }
            else if(rn == 1){
                return "BEST CLIENT EVER";
            }
            else if(rn == 2){
                return "I like cookies";
            }
            return "";
        }
    }

    public static class ReadFile {
        public static String readFile(String name){
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(name));
                String line = reader.readLine();
                if(line != null){
                    return line;
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}