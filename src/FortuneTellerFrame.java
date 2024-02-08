import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Toolkit;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;

    JButton fortuneBtn;
    JButton quitBtn;

    ArrayList<String> fortunes = new ArrayList<>();
    ArrayList<Integer> check = new ArrayList<>();

    public FortuneTellerFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3*(screenWidth / 4), 3*(screenHeight / 4));
        setLocationRelativeTo(null);

        add(mainPnl);
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        fortunes.add("A muscular and loving person will be coming into your life.");
        fortunes.add("A yeat fan may be an friend in disguise.");
        fortunes.add("Your kindness will lead you to unexpected blessings");
        fortunes.add("Believe in yourself, for you are capable of greatness");
        fortunes.add("Trust in your intuition; it will guide you to greatness.");
        fortunes.add("Your creativity will spark inspiration in those around you");
        fortunes.add("A joyful heart attracts abundance in all aspects of life");
        fortunes.add("Gratitude opens the door to abundance");
        fortunes.add("Trust in your intuition; it will guide you to greatness");
        fortunes.add("APatience is the key that unlocks many doors");
        fortunes.add("Success is on the horizon; keep pushing forward.");
        fortunes.add("Your determination will lead you to success.");
    }

    private void createTopPanel() {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/Teller1.jpg");

        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLbl);
    }

    private void createMiddlePanel() {
        displayPnl = new JPanel();
        displayTA = new JTextArea(10, 35);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        displayPnl.add(scroller);
    }

    private void createBottomPanel() {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        fortuneBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit");

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);

        fortuneBtn.addActionListener((ActionEvent ae) -> {
            Random rnd = new Random();
            int previousNum;
            int x;

            if (check.size() < 1) {
                previousNum = 0;
            }
            else {
                previousNum = check.size()-1;
            }

            while (true){
                x = rnd.nextInt(fortunes.size());
                check.add(x);
                if (x != check.get(previousNum)) {
                    break;
                }
            }
            displayTA.append(fortunes.get(x) + "\n");
        });
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    }
}