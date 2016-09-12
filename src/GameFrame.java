import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    GameFrame forCopy = this;
    private JPanel contentPane;
    Gamer gamer1;
    Gamer gamer2;
    private boolean butWait = true; // ожидание нажатия кнопок от игрока
    JLabel turn;
    JLabel shipDown;
    JLabel someWin;
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    ArrayList<JButton> buttons1 = new ArrayList<JButton>();
    Thread myThread = new Thread(new ForMyThread());
    Object lock = new Object();


    /**
     * Create the frame.
     */
    public void butWait() {
        butWait = butWait == true ? false : true;
    }

    class Attack implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton jb = (JButton) e.getSource();
            if (buttons.contains(jb)) {
                int i = buttons.indexOf(jb);
                int z = gamer1.checkScope(gamer1.fromIntToString(i), gamer2);
                if (gamer1.fieldEnemy[i] == 2) {
                    jb.setBackground(Color.ORANGE);
                    jb.removeActionListener(this);
                    butWait();
                } else if (gamer1.fieldEnemy[i] == 1) {
                    jb.setBackground(Color.RED);
                    jb.removeActionListener(this);
                }
                if (z == 2) {
                    shipDown.setText("<html>КОРАБЛЬ <br>ПОТОПЛЕН</html>");
                } else {
                    shipDown.setText("");
                }
                synchronized (lock) {
                    lock.notifyAll();
                }
            }
        }
    }


    public void defenseTable() {
        for (int i = 0; i < buttons1.size(); i++) {
            if (gamer1.fieldGamer[i] == 2) {
                buttons1.get(i).setBackground(Color.ORANGE);
            } else if (gamer1.fieldGamer[i] == 1) {
                buttons1.get(i).setBackground(Color.BLACK);
            } else if (gamer1.fieldGamer[i] == 3) {
                buttons1.get(i).setBackground(Color.RED);
            } else if (gamer1.fieldGamer[i] == 4) {
                buttons1.get(i).setBackground(Color.LIGHT_GRAY);
            }
            //System.out.println("Buttons 1 size" + buttons1.size());
        }
    }


    public GameFrame(Gamer gamer_1, Gamer gamer_2) {
        gamer1 = gamer_1;
        gamer2 = gamer_2;


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(250, 250, 721, 526);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.menu);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        {
            JPanel panel_4 = new JPanel();
            panel_1.add(panel_4);
            panel_4.setLayout(new FormLayout(new ColumnSpec[]{
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(10dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.RELATED_GAP_COLSPEC,
                    FormSpecs.DEFAULT_COLSPEC,
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(50dlu;pref)"),},
                    new RowSpec[]{
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,}));

            JLabel lbln = new JLabel("");
            panel_4.add(lbln, "17, 10, 1, 2, fill, center");
            shipDown = lbln;

            JLabel label_24 = new JLabel("");
            panel_4.add(label_24, "17, 5, 1, 2, fill, center");
            someWin = label_24;

            JLabel label = new JLabel("А");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label, "4, 2");

            JLabel label_1 = new JLabel("Б");
            label_1.setHorizontalAlignment(SwingConstants.CENTER);
            label_1.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_1, "5, 2");

            JLabel label_2 = new JLabel("В");
            label_2.setHorizontalAlignment(SwingConstants.CENTER);
            label_2.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_2, "6, 2");

            JLabel label_3 = new JLabel("Г");
            label_3.setHorizontalAlignment(SwingConstants.CENTER);
            label_3.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_3, "7, 2");

            JLabel label_4 = new JLabel("Д");
            label_4.setHorizontalAlignment(SwingConstants.CENTER);
            label_4.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_4, "8, 2");

            JLabel label_5 = new JLabel("Е");
            label_5.setHorizontalAlignment(SwingConstants.CENTER);
            label_5.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_5, "9, 2");

            JLabel label_6 = new JLabel("Ж");
            label_6.setHorizontalAlignment(SwingConstants.CENTER);
            label_6.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_6, "10, 2");

            JLabel label_7 = new JLabel("З");
            label_7.setHorizontalAlignment(SwingConstants.CENTER);
            label_7.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_7, "11, 2");

            JLabel label_8 = new JLabel("И");
            label_8.setHorizontalAlignment(SwingConstants.CENTER);
            label_8.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_8, "12, 2");

            JLabel label_9 = new JLabel("К");
            label_9.setHorizontalAlignment(SwingConstants.CENTER);
            label_9.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_9, "13, 2");

            JLabel label_10 = new JLabel("1");
            label_10.setHorizontalAlignment(SwingConstants.CENTER);
            label_10.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_10, "2, 4, 2, 1");

            JLabel label_11 = new JLabel("2");
            label_11.setHorizontalAlignment(SwingConstants.CENTER);
            label_11.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_11, "2, 5, 2, 1");

            JLabel label_12 = new JLabel("3");
            label_12.setHorizontalAlignment(SwingConstants.CENTER);
            label_12.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_12, "2, 6, 2, 1");

            JLabel label_13 = new JLabel("4");
            label_13.setHorizontalAlignment(SwingConstants.CENTER);
            label_13.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_13, "2, 7, 2, 1");

            JLabel label_14 = new JLabel("5");
            label_14.setHorizontalAlignment(SwingConstants.CENTER);
            label_14.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_14, "2, 8, 2, 1");

            JLabel lblNewLabel = new JLabel("ВАШ ХОД!!!");
            label_14.setHorizontalAlignment(SwingConstants.CENTER);
            panel_4.add(lblNewLabel, "17, 8, fill, center");
            turn = lblNewLabel;

            JLabel label_15 = new JLabel("6");
            label_15.setHorizontalAlignment(SwingConstants.CENTER);
            label_15.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_15, "2, 9, 2, 1");

            JLabel label_16 = new JLabel("7");
            label_16.setHorizontalAlignment(SwingConstants.CENTER);
            label_16.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_16, "2, 10, 2, 1");

            JLabel label_17 = new JLabel("8");
            label_17.setHorizontalAlignment(SwingConstants.CENTER);
            label_17.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_17, "2, 11, 2, 1");

            JLabel label_18 = new JLabel("9");
            label_18.setHorizontalAlignment(SwingConstants.CENTER);
            label_18.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_18, "2, 12, 2, 1");

            JLabel label_19 = new JLabel("10");
            label_19.setHorizontalAlignment(SwingConstants.CENTER);
            label_19.setPreferredSize(new Dimension(20, 20));
            panel_4.add(label_19, "2, 13, 2, 1");

            JButton button = new JButton("");
            button.setBackground(Color.YELLOW);
            button.setPreferredSize(new Dimension(20, 20));
            panel_4.add(button, "4, 4, fill, fill");

            JButton button_1 = new JButton("");
            button_1.setPreferredSize(new Dimension(20, 20));
            button_1.setBackground(Color.YELLOW);
            panel_4.add(button_1, "5, 4");

            JButton button_2 = new JButton("");
            button_2.setPreferredSize(new Dimension(20, 20));
            button_2.setBackground(Color.YELLOW);
            panel_4.add(button_2, "6, 4");

            JButton button_3 = new JButton("");
            button_3.setPreferredSize(new Dimension(20, 20));
            button_3.setBackground(Color.YELLOW);
            panel_4.add(button_3, "7, 4");

            JButton button_4 = new JButton("");
            button_4.setPreferredSize(new Dimension(20, 20));
            button_4.setBackground(Color.YELLOW);
            panel_4.add(button_4, "8, 4");

            JButton button_5 = new JButton("");
            button_5.setPreferredSize(new Dimension(20, 20));
            button_5.setBackground(Color.YELLOW);
            panel_4.add(button_5, "9, 4");

            JButton button_6 = new JButton("");
            button_6.setPreferredSize(new Dimension(20, 20));
            button_6.setBackground(Color.YELLOW);
            panel_4.add(button_6, "10, 4");

            JButton button_7 = new JButton("");
            button_7.setPreferredSize(new Dimension(20, 20));
            button_7.setBackground(Color.YELLOW);
            panel_4.add(button_7, "11, 4");

            JButton button_8 = new JButton("");
            button_8.setPreferredSize(new Dimension(20, 20));
            button_8.setBackground(Color.YELLOW);
            panel_4.add(button_8, "12, 4");

            JButton button_9 = new JButton("");
            button_9.setPreferredSize(new Dimension(20, 20));
            button_9.setBackground(Color.YELLOW);
            panel_4.add(button_9, "13, 4");


            JButton button_10 = new JButton("");
            button_10.setPreferredSize(new Dimension(20, 20));
            button_10.setBackground(Color.YELLOW);
            panel_4.add(button_10, "4, 5");

            JButton button_11 = new JButton("");
            button_11.setPreferredSize(new Dimension(20, 20));
            button_11.setBackground(Color.YELLOW);
            panel_4.add(button_11, "5, 5");

            JButton button_12 = new JButton("");
            button_12.setPreferredSize(new Dimension(20, 20));
            button_12.setBackground(Color.YELLOW);
            panel_4.add(button_12, "6, 5");

            JButton button_13 = new JButton("");
            button_13.setPreferredSize(new Dimension(20, 20));
            button_13.setBackground(Color.YELLOW);
            panel_4.add(button_13, "7, 5");

            JButton button_14 = new JButton("");
            button_14.setPreferredSize(new Dimension(20, 20));
            button_14.setBackground(Color.YELLOW);
            panel_4.add(button_14, "8, 5");

            JButton button_15 = new JButton("");
            button_15.setPreferredSize(new Dimension(20, 20));
            button_15.setBackground(Color.YELLOW);
            panel_4.add(button_15, "9, 5");

            JButton button_16 = new JButton("");
            button_16.setPreferredSize(new Dimension(20, 20));
            button_16.setBackground(Color.YELLOW);
            panel_4.add(button_16, "10, 5");

            JButton button_17 = new JButton("");
            button_17.setPreferredSize(new Dimension(20, 20));
            button_17.setBackground(Color.YELLOW);
            panel_4.add(button_17, "11, 5");

            JButton button_18 = new JButton("");
            button_18.setPreferredSize(new Dimension(20, 20));
            button_18.setBackground(Color.YELLOW);
            panel_4.add(button_18, "12, 5");

            JButton button_19 = new JButton("");
            button_19.setPreferredSize(new Dimension(20, 20));
            button_19.setBackground(Color.YELLOW);
            panel_4.add(button_19, "13, 5");


            JButton button_20 = new JButton("");
            button_20.setPreferredSize(new Dimension(20, 20));
            button_20.setBackground(Color.YELLOW);
            panel_4.add(button_20, "4, 6");

            JButton button_21 = new JButton("");
            button_21.setPreferredSize(new Dimension(20, 20));
            button_21.setBackground(Color.YELLOW);
            panel_4.add(button_21, "5, 6");

            JButton button_22 = new JButton("");
            button_22.setPreferredSize(new Dimension(20, 20));
            button_22.setBackground(Color.YELLOW);
            panel_4.add(button_22, "6, 6");

            JButton button_23 = new JButton("");
            button_23.setPreferredSize(new Dimension(20, 20));
            button_23.setBackground(Color.YELLOW);
            panel_4.add(button_23, "7, 6");

            JButton button_24 = new JButton("");
            button_24.setPreferredSize(new Dimension(20, 20));
            button_24.setBackground(Color.YELLOW);
            panel_4.add(button_24, "8, 6");

            JButton button_25 = new JButton("");
            button_25.setPreferredSize(new Dimension(20, 20));
            button_25.setBackground(Color.YELLOW);
            panel_4.add(button_25, "9, 6");

            JButton button_26 = new JButton("");
            button_26.setPreferredSize(new Dimension(20, 20));
            button_26.setBackground(Color.YELLOW);
            panel_4.add(button_26, "10, 6");

            JButton button_27 = new JButton("");
            button_27.setPreferredSize(new Dimension(20, 20));
            button_27.setBackground(Color.YELLOW);
            panel_4.add(button_27, "11, 6");

            JButton button_28 = new JButton("");
            button_28.setPreferredSize(new Dimension(20, 20));
            button_28.setBackground(Color.YELLOW);
            panel_4.add(button_28, "12, 6");

            JButton button_29 = new JButton("");
            button_29.setPreferredSize(new Dimension(20, 20));
            button_29.setBackground(Color.YELLOW);
            panel_4.add(button_29, "13, 6");


            JButton button_30 = new JButton("");
            button_30.setPreferredSize(new Dimension(20, 20));
            button_30.setBackground(Color.YELLOW);
            panel_4.add(button_30, "4, 7");

            JButton button_31 = new JButton("");
            button_31.setPreferredSize(new Dimension(20, 20));
            button_31.setBackground(Color.YELLOW);
            panel_4.add(button_31, "5, 7");

            JButton button_32 = new JButton("");
            button_32.setPreferredSize(new Dimension(20, 20));
            button_32.setBackground(Color.YELLOW);
            panel_4.add(button_32, "6, 7");

            JButton button_33 = new JButton("");
            button_33.setPreferredSize(new Dimension(20, 20));
            button_33.setBackground(Color.YELLOW);
            panel_4.add(button_33, "7, 7");

            JButton button_34 = new JButton("");
            button_34.setPreferredSize(new Dimension(20, 20));
            button_34.setBackground(Color.YELLOW);
            panel_4.add(button_34, "8, 7");

            JButton button_35 = new JButton("");
            button_35.setPreferredSize(new Dimension(20, 20));
            button_35.setBackground(Color.YELLOW);
            panel_4.add(button_35, "9, 7");

            JButton button_36 = new JButton("");
            button_36.setPreferredSize(new Dimension(20, 20));
            button_36.setBackground(Color.YELLOW);
            panel_4.add(button_36, "10, 7");

            JButton button_37 = new JButton("");
            button_37.setPreferredSize(new Dimension(20, 20));
            button_37.setBackground(Color.YELLOW);
            panel_4.add(button_37, "11, 7");

            JButton button_38 = new JButton("");
            button_38.setPreferredSize(new Dimension(20, 20));
            button_38.setBackground(Color.YELLOW);
            panel_4.add(button_38, "12, 7");

            JButton button_39 = new JButton("");
            button_39.setPreferredSize(new Dimension(20, 20));
            button_39.setBackground(Color.YELLOW);
            panel_4.add(button_39, "13, 7");


            JButton button_40 = new JButton("");
            button_40.setPreferredSize(new Dimension(20, 20));
            button_40.setBackground(Color.YELLOW);
            panel_4.add(button_40, "4, 8");

            JButton button_41 = new JButton("");
            button_41.setPreferredSize(new Dimension(20, 20));
            button_41.setBackground(Color.YELLOW);
            panel_4.add(button_41, "5, 8");

            JButton button_42 = new JButton("");
            button_42.setPreferredSize(new Dimension(20, 20));
            button_42.setBackground(Color.YELLOW);
            panel_4.add(button_42, "6, 8");

            JButton button_43 = new JButton("");
            button_43.setPreferredSize(new Dimension(20, 20));
            button_43.setBackground(Color.YELLOW);
            panel_4.add(button_43, "7, 8");

            JButton button_44 = new JButton("");
            button_44.setPreferredSize(new Dimension(20, 20));
            button_44.setBackground(Color.YELLOW);
            panel_4.add(button_44, "8, 8");

            JButton button_45 = new JButton("");
            button_45.setPreferredSize(new Dimension(20, 20));
            button_45.setBackground(Color.YELLOW);
            panel_4.add(button_45, "9, 8");

            JButton button_46 = new JButton("");
            button_46.setPreferredSize(new Dimension(20, 20));
            button_46.setBackground(Color.YELLOW);
            panel_4.add(button_46, "10, 8");

            JButton button_47 = new JButton("");
            button_47.setPreferredSize(new Dimension(20, 20));
            button_47.setBackground(Color.YELLOW);
            panel_4.add(button_47, "11, 8");

            JButton button_48 = new JButton("");
            button_48.setPreferredSize(new Dimension(20, 20));
            button_48.setBackground(Color.YELLOW);
            panel_4.add(button_48, "12, 8");

            JButton button_49 = new JButton("");
            button_49.setPreferredSize(new Dimension(20, 20));
            button_49.setBackground(Color.YELLOW);
            panel_4.add(button_49, "13, 8");


            JButton button_50 = new JButton("");
            button_50.setPreferredSize(new Dimension(20, 20));
            button_50.setBackground(Color.YELLOW);
            panel_4.add(button_50, "4, 9");

            JButton button_51 = new JButton("");
            button_51.setPreferredSize(new Dimension(20, 20));
            button_51.setBackground(Color.YELLOW);
            panel_4.add(button_51, "5, 9");

            JButton button_52 = new JButton("");
            button_52.setPreferredSize(new Dimension(20, 20));
            button_52.setBackground(Color.YELLOW);
            panel_4.add(button_52, "6, 9");

            JButton button_53 = new JButton("");
            button_53.setPreferredSize(new Dimension(20, 20));
            button_53.setBackground(Color.YELLOW);
            panel_4.add(button_53, "7, 9");

            JButton button_54 = new JButton("");
            button_54.setPreferredSize(new Dimension(20, 20));
            button_54.setBackground(Color.YELLOW);
            panel_4.add(button_54, "8, 9");

            JButton button_55 = new JButton("");
            button_55.setPreferredSize(new Dimension(20, 20));
            button_55.setBackground(Color.YELLOW);
            panel_4.add(button_55, "9, 9");

            JButton button_56 = new JButton("");
            button_56.setPreferredSize(new Dimension(20, 20));
            button_56.setBackground(Color.YELLOW);
            panel_4.add(button_56, "10, 9");

            JButton button_57 = new JButton("");
            button_57.setPreferredSize(new Dimension(20, 20));
            button_57.setBackground(Color.YELLOW);
            panel_4.add(button_57, "11, 9");

            JButton button_58 = new JButton("");
            button_58.setPreferredSize(new Dimension(20, 20));
            button_58.setBackground(Color.YELLOW);
            panel_4.add(button_58, "12, 9");

            JButton button_59 = new JButton("");
            button_59.setPreferredSize(new Dimension(20, 20));
            button_59.setBackground(Color.YELLOW);
            panel_4.add(button_59, "13, 9");


            JButton button_60 = new JButton("");
            button_60.setPreferredSize(new Dimension(20, 20));
            button_60.setBackground(Color.YELLOW);
            panel_4.add(button_60, "4, 10");

            JButton button_61 = new JButton("");
            button_61.setPreferredSize(new Dimension(20, 20));
            button_61.setBackground(Color.YELLOW);
            panel_4.add(button_61, "5, 10");

            JButton button_62 = new JButton("");
            button_62.setPreferredSize(new Dimension(20, 20));
            button_62.setBackground(Color.YELLOW);
            panel_4.add(button_62, "6, 10");

            JButton button_63 = new JButton("");
            button_63.setPreferredSize(new Dimension(20, 20));
            button_63.setBackground(Color.YELLOW);
            panel_4.add(button_63, "7, 10");

            JButton button_64 = new JButton("");
            button_64.setPreferredSize(new Dimension(20, 20));
            button_64.setBackground(Color.YELLOW);
            panel_4.add(button_64, "8, 10");

            JButton button_65 = new JButton("");
            button_65.setPreferredSize(new Dimension(20, 20));
            button_65.setBackground(Color.YELLOW);
            panel_4.add(button_65, "9, 10");

            JButton button_66 = new JButton("");
            button_66.setPreferredSize(new Dimension(20, 20));
            button_66.setBackground(Color.YELLOW);
            panel_4.add(button_66, "10, 10");

            JButton button_67 = new JButton("");
            button_67.setPreferredSize(new Dimension(20, 20));
            button_67.setBackground(Color.YELLOW);
            panel_4.add(button_67, "11, 10");

            JButton button_68 = new JButton("");
            button_68.setPreferredSize(new Dimension(20, 20));
            button_68.setBackground(Color.YELLOW);
            panel_4.add(button_68, "12, 10");

            JButton button_69 = new JButton("");
            button_69.setPreferredSize(new Dimension(20, 20));
            button_69.setBackground(Color.YELLOW);
            panel_4.add(button_69, "13, 10");


            JButton button_70 = new JButton("");
            button_70.setPreferredSize(new Dimension(20, 20));
            button_70.setBackground(Color.YELLOW);
            panel_4.add(button_70, "4, 11");

            JButton button_71 = new JButton("");
            button_71.setPreferredSize(new Dimension(20, 20));
            button_71.setBackground(Color.YELLOW);
            panel_4.add(button_71, "5, 11");

            JButton button_72 = new JButton("");
            button_72.setPreferredSize(new Dimension(20, 20));
            button_72.setBackground(Color.YELLOW);
            panel_4.add(button_72, "6, 11");

            JButton button_73 = new JButton("");
            button_73.setPreferredSize(new Dimension(20, 20));
            button_73.setBackground(Color.YELLOW);
            panel_4.add(button_73, "7, 11");

            JButton button_74 = new JButton("");
            button_74.setPreferredSize(new Dimension(20, 20));
            button_74.setBackground(Color.YELLOW);
            panel_4.add(button_74, "8, 11");

            JButton button_75 = new JButton("");
            button_75.setPreferredSize(new Dimension(20, 20));
            button_75.setBackground(Color.YELLOW);
            panel_4.add(button_75, "9, 11");

            JButton button_76 = new JButton("");
            button_76.setPreferredSize(new Dimension(20, 20));
            button_76.setBackground(Color.YELLOW);
            panel_4.add(button_76, "10, 11");

            JButton button_77 = new JButton("");
            button_77.setPreferredSize(new Dimension(20, 20));
            button_77.setBackground(Color.YELLOW);
            panel_4.add(button_77, "11, 11");

            JButton button_78 = new JButton("");
            button_78.setPreferredSize(new Dimension(20, 20));
            button_78.setBackground(Color.YELLOW);
            panel_4.add(button_78, "12, 11");

            JButton button_79 = new JButton("");
            button_79.setPreferredSize(new Dimension(20, 20));
            button_79.setBackground(Color.YELLOW);
            panel_4.add(button_79, "13, 11");


            JButton button_80 = new JButton("");
            button_80.setPreferredSize(new Dimension(20, 20));
            button_80.setBackground(Color.YELLOW);
            panel_4.add(button_80, "4, 12");

            JButton button_81 = new JButton("");
            button_81.setPreferredSize(new Dimension(20, 20));
            button_81.setBackground(Color.YELLOW);
            panel_4.add(button_81, "5, 12");

            JButton button_82 = new JButton("");
            button_82.setPreferredSize(new Dimension(20, 20));
            button_82.setBackground(Color.YELLOW);
            panel_4.add(button_82, "6, 12");

            JButton button_83 = new JButton("");
            button_83.setPreferredSize(new Dimension(20, 20));
            button_83.setBackground(Color.YELLOW);
            panel_4.add(button_83, "7, 12");

            JButton button_84 = new JButton("");
            button_84.setPreferredSize(new Dimension(20, 20));
            button_84.setBackground(Color.YELLOW);
            panel_4.add(button_84, "8, 12");

            JButton button_85 = new JButton("");
            button_85.setPreferredSize(new Dimension(20, 20));
            button_85.setBackground(Color.YELLOW);
            panel_4.add(button_85, "9, 12");

            JButton button_86 = new JButton("");
            button_86.setPreferredSize(new Dimension(20, 20));
            button_86.setBackground(Color.YELLOW);
            panel_4.add(button_86, "10, 12");

            JButton button_87 = new JButton("");
            button_87.setPreferredSize(new Dimension(20, 20));
            button_87.setBackground(Color.YELLOW);
            panel_4.add(button_87, "11, 12");

            JButton button_88 = new JButton("");
            button_88.setPreferredSize(new Dimension(20, 20));
            button_88.setBackground(Color.YELLOW);
            panel_4.add(button_88, "12, 12");

            JButton button_89 = new JButton("");
            button_89.setPreferredSize(new Dimension(20, 20));
            button_89.setBackground(Color.YELLOW);
            panel_4.add(button_89, "13, 12");


            JButton button_90 = new JButton("");
            button_90.setPreferredSize(new Dimension(20, 20));
            button_90.setBackground(Color.YELLOW);
            panel_4.add(button_90, "4, 13");

            JButton button_91 = new JButton("");
            button_91.setPreferredSize(new Dimension(20, 20));
            button_91.setBackground(Color.YELLOW);
            panel_4.add(button_91, "5, 13");

            JButton button_92 = new JButton("");
            button_92.setPreferredSize(new Dimension(20, 20));
            button_92.setBackground(Color.YELLOW);
            panel_4.add(button_92, "6, 13");

            JButton button_93 = new JButton("");
            button_93.setPreferredSize(new Dimension(20, 20));
            button_93.setBackground(Color.YELLOW);
            panel_4.add(button_93, "7, 13");

            JButton button_94 = new JButton("");
            button_94.setPreferredSize(new Dimension(20, 20));
            button_94.setBackground(Color.YELLOW);
            panel_4.add(button_94, "8, 13");

            JButton button_95 = new JButton("");
            button_95.setPreferredSize(new Dimension(20, 20));
            button_95.setBackground(Color.YELLOW);
            panel_4.add(button_95, "9, 13");

            JButton button_96 = new JButton("");
            button_96.setPreferredSize(new Dimension(20, 20));
            button_96.setBackground(Color.YELLOW);
            panel_4.add(button_96, "10, 13");

            JButton button_97 = new JButton("");
            button_97.setPreferredSize(new Dimension(20, 20));
            button_97.setBackground(Color.YELLOW);
            panel_4.add(button_97, "11, 13");

            JButton button_98 = new JButton("");
            button_98.setPreferredSize(new Dimension(20, 20));
            button_98.setBackground(Color.YELLOW);
            panel_4.add(button_98, "12, 13");

            JButton button_99 = new JButton("");
            button_99.setPreferredSize(new Dimension(20, 20));
            button_99.setBackground(Color.YELLOW);
            panel_4.add(button_99, "13, 13");
            buttons.add(button);
            buttons.add(button_1);
            buttons.add(button_2);
            buttons.add(button_3);
            buttons.add(button_4);
            buttons.add(button_5);
            buttons.add(button_6);
            buttons.add(button_7);
            buttons.add(button_8);
            buttons.add(button_9);
            buttons.add(button_10);
            buttons.add(button_11);
            buttons.add(button_12);
            buttons.add(button_13);
            buttons.add(button_14);
            buttons.add(button_15);
            buttons.add(button_16);
            buttons.add(button_17);
            buttons.add(button_18);
            buttons.add(button_19);
            buttons.add(button_20);
            buttons.add(button_21);
            buttons.add(button_22);
            buttons.add(button_23);
            buttons.add(button_24);
            buttons.add(button_25);
            buttons.add(button_26);
            buttons.add(button_27);
            buttons.add(button_28);
            buttons.add(button_29);
            buttons.add(button_30);
            buttons.add(button_31);
            buttons.add(button_32);
            buttons.add(button_33);
            buttons.add(button_34);
            buttons.add(button_35);
            buttons.add(button_36);
            buttons.add(button_37);
            buttons.add(button_38);
            buttons.add(button_39);
            buttons.add(button_40);
            buttons.add(button_41);
            buttons.add(button_42);
            buttons.add(button_43);
            buttons.add(button_44);
            buttons.add(button_45);
            buttons.add(button_46);
            buttons.add(button_47);
            buttons.add(button_48);
            buttons.add(button_49);
            buttons.add(button_50);
            buttons.add(button_51);
            buttons.add(button_52);
            buttons.add(button_53);
            buttons.add(button_54);
            buttons.add(button_55);
            buttons.add(button_56);
            buttons.add(button_57);
            buttons.add(button_58);
            buttons.add(button_59);
            buttons.add(button_60);
            buttons.add(button_61);
            buttons.add(button_62);
            buttons.add(button_63);
            buttons.add(button_64);
            buttons.add(button_65);
            buttons.add(button_66);
            buttons.add(button_67);
            buttons.add(button_68);
            buttons.add(button_69);
            buttons.add(button_70);
            buttons.add(button_71);
            buttons.add(button_72);
            buttons.add(button_73);
            buttons.add(button_74);
            buttons.add(button_75);
            buttons.add(button_76);
            buttons.add(button_77);
            buttons.add(button_78);
            buttons.add(button_79);
            buttons.add(button_80);
            buttons.add(button_81);
            buttons.add(button_82);
            buttons.add(button_83);
            buttons.add(button_84);
            buttons.add(button_85);
            buttons.add(button_86);
            buttons.add(button_87);
            buttons.add(button_88);
            buttons.add(button_89);
            buttons.add(button_90);
            buttons.add(button_91);
            buttons.add(button_92);
            buttons.add(button_93);
            buttons.add(button_94);
            buttons.add(button_95);
            buttons.add(button_96);
            buttons.add(button_97);
            buttons.add(button_98);
            buttons.add(button_99);
        }
        {
            JPanel panel_2 = new JPanel();
            panel_1.add(panel_2);
            panel_2.setLayout(new FormLayout(new ColumnSpec[]{
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(20dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,
                    FormSpecs.PREF_COLSPEC,},
                    new RowSpec[]{
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,}));

            JLabel label1 = new JLabel("А");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1, "4, 2");

            JLabel label1_1 = new JLabel("Б");
            label1_1.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_1, "5, 2");

            JLabel label1_2 = new JLabel("В");
            label1_2.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_2, "6, 2");

            JLabel label1_3 = new JLabel("Г");
            label1_3.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_3, "7, 2");

            JLabel label1_4 = new JLabel("Д");
            label1_4.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_4, "8, 2");

            JLabel label1_5 = new JLabel("Е");
            label1_5.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_5, "9, 2");

            JLabel label1_6 = new JLabel("Ж");
            label1_6.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_6, "10, 2");

            JLabel label1_7 = new JLabel("З");
            label1_7.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_7, "11, 2");

            JLabel label1_8 = new JLabel("И");
            label1_8.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_8, "12, 2");

            JLabel label1_9 = new JLabel("К");
            label1_9.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_9, "13, 2");

            JLabel label1_10 = new JLabel("1");
            label1_10.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_10, "2, 4, 2, 1");

            JButton button1 = new JButton("");
            button1.setBackground(Color.YELLOW);
            button1.setPreferredSize(new Dimension(20, 20));
            panel_2.add(button1, "4, 4, fill, fill");

            JButton button1_1 = new JButton("");
            button1_1.setPreferredSize(new Dimension(20, 20));
            button1_1.setBackground(Color.YELLOW);
            panel_2.add(button1_1, "5, 4");

            JButton button1_2 = new JButton("");
            button1_2.setPreferredSize(new Dimension(20, 20));
            button1_2.setBackground(Color.YELLOW);
            panel_2.add(button1_2, "6, 4");

            JButton button1_3 = new JButton("");
            button1_3.setPreferredSize(new Dimension(20, 20));
            button1_3.setBackground(Color.YELLOW);
            panel_2.add(button1_3, "7, 4");

            JButton button1_4 = new JButton("");
            button1_4.setPreferredSize(new Dimension(20, 20));
            button1_4.setBackground(Color.YELLOW);
            panel_2.add(button1_4, "8, 4");

            JButton button1_5 = new JButton("");
            button1_5.setPreferredSize(new Dimension(20, 20));
            button1_5.setBackground(Color.YELLOW);
            panel_2.add(button1_5, "9, 4");

            JButton button1_6 = new JButton("");
            button1_6.setPreferredSize(new Dimension(20, 20));
            button1_6.setBackground(Color.YELLOW);
            panel_2.add(button1_6, "10, 4");

            JButton button1_7 = new JButton("");
            button1_7.setPreferredSize(new Dimension(20, 20));
            button1_7.setBackground(Color.YELLOW);
            panel_2.add(button1_7, "11, 4");

            JButton button1_8 = new JButton("");
            button1_8.setPreferredSize(new Dimension(20, 20));
            button1_8.setBackground(Color.YELLOW);
            panel_2.add(button1_8, "12, 4");

            JButton button1_9 = new JButton("");
            button1_9.setPreferredSize(new Dimension(20, 20));
            button1_9.setBackground(Color.YELLOW);
            panel_2.add(button1_9, "13, 4");

            JLabel label1_11 = new JLabel("2");
            label1_11.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_11, "2, 5, 2, 1");

            JButton button1_10 = new JButton("");
            button1_10.setPreferredSize(new Dimension(20, 20));
            button1_10.setBackground(Color.YELLOW);
            panel_2.add(button1_10, "4, 5");

            JButton button1_11 = new JButton("");
            button1_11.setPreferredSize(new Dimension(20, 20));
            button1_11.setBackground(Color.YELLOW);
            panel_2.add(button1_11, "5, 5");

            JButton button1_12 = new JButton("");
            button1_12.setPreferredSize(new Dimension(20, 20));
            button1_12.setBackground(Color.YELLOW);
            panel_2.add(button1_12, "6, 5");

            JButton button1_13 = new JButton("");
            button1_13.setPreferredSize(new Dimension(20, 20));
            button1_13.setBackground(Color.YELLOW);
            panel_2.add(button1_13, "7, 5");

            JButton button1_14 = new JButton("");
            button1_14.setPreferredSize(new Dimension(20, 20));
            button1_14.setBackground(Color.YELLOW);
            panel_2.add(button1_14, "8, 5");

            JButton button1_15 = new JButton("");
            button1_15.setPreferredSize(new Dimension(20, 20));
            button1_15.setBackground(Color.YELLOW);
            panel_2.add(button1_15, "9, 5");

            JButton button1_16 = new JButton("");
            button1_16.setPreferredSize(new Dimension(20, 20));
            button1_16.setBackground(Color.YELLOW);
            panel_2.add(button1_16, "10, 5");

            JButton button1_17 = new JButton("");
            button1_17.setPreferredSize(new Dimension(20, 20));
            button1_17.setBackground(Color.YELLOW);
            panel_2.add(button1_17, "11, 5");

            JButton button1_18 = new JButton("");
            button1_18.setPreferredSize(new Dimension(20, 20));
            button1_18.setBackground(Color.YELLOW);
            panel_2.add(button1_18, "12, 5");

            JButton button1_19 = new JButton("");
            button1_19.setPreferredSize(new Dimension(20, 20));
            button1_19.setBackground(Color.YELLOW);
            panel_2.add(button1_19, "13, 5");

            JLabel label1_12 = new JLabel("3");
            label1_12.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_12, "2, 6, 2, 1");

            JButton button1_20 = new JButton("");
            button1_20.setPreferredSize(new Dimension(20, 20));
            button1_20.setBackground(Color.YELLOW);
            panel_2.add(button1_20, "4, 6");

            JButton button1_21 = new JButton("");
            button1_21.setPreferredSize(new Dimension(20, 20));
            button1_21.setBackground(Color.YELLOW);
            panel_2.add(button1_21, "5, 6");

            JButton button1_22 = new JButton("");
            button1_22.setPreferredSize(new Dimension(20, 20));
            button1_22.setBackground(Color.YELLOW);
            panel_2.add(button1_22, "6, 6");

            JButton button1_23 = new JButton("");
            button1_23.setPreferredSize(new Dimension(20, 20));
            button1_23.setBackground(Color.YELLOW);
            panel_2.add(button1_23, "7, 6");

            JButton button1_24 = new JButton("");
            button1_24.setPreferredSize(new Dimension(20, 20));
            button1_24.setBackground(Color.YELLOW);
            panel_2.add(button1_24, "8, 6");

            JButton button1_25 = new JButton("");
            button1_25.setPreferredSize(new Dimension(20, 20));
            button1_25.setBackground(Color.YELLOW);
            panel_2.add(button1_25, "9, 6");

            JButton button1_26 = new JButton("");
            button1_26.setPreferredSize(new Dimension(20, 20));
            button1_26.setBackground(Color.YELLOW);
            panel_2.add(button1_26, "10, 6");

            JButton button1_27 = new JButton("");
            button1_27.setPreferredSize(new Dimension(20, 20));
            button1_27.setBackground(Color.YELLOW);
            panel_2.add(button1_27, "11, 6");

            JButton button1_28 = new JButton("");
            button1_28.setPreferredSize(new Dimension(20, 20));
            button1_28.setBackground(Color.YELLOW);
            panel_2.add(button1_28, "12, 6");

            JButton button1_29 = new JButton("");
            button1_29.setPreferredSize(new Dimension(20, 20));
            button1_29.setBackground(Color.YELLOW);
            panel_2.add(button1_29, "13, 6");

            JLabel label1_13 = new JLabel("4");
            label1_13.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_13, "2, 7, 2, 1");

            JButton button1_30 = new JButton("");
            button1_30.setPreferredSize(new Dimension(20, 20));
            button1_30.setBackground(Color.YELLOW);
            panel_2.add(button1_30, "4, 7");

            JButton button1_31 = new JButton("");
            button1_31.setPreferredSize(new Dimension(20, 20));
            button1_31.setBackground(Color.YELLOW);
            panel_2.add(button1_31, "5, 7");

            JButton button1_32 = new JButton("");
            button1_32.setPreferredSize(new Dimension(20, 20));
            button1_32.setBackground(Color.YELLOW);
            panel_2.add(button1_32, "6, 7");

            JButton button1_33 = new JButton("");
            button1_33.setPreferredSize(new Dimension(20, 20));
            button1_33.setBackground(Color.YELLOW);
            panel_2.add(button1_33, "7, 7");

            JButton button1_34 = new JButton("");
            button1_34.setPreferredSize(new Dimension(20, 20));
            button1_34.setBackground(Color.YELLOW);
            panel_2.add(button1_34, "8, 7");

            JButton button1_35 = new JButton("");
            button1_35.setPreferredSize(new Dimension(20, 20));
            button1_35.setBackground(Color.YELLOW);
            panel_2.add(button1_35, "9, 7");

            JButton button1_36 = new JButton("");
            button1_36.setPreferredSize(new Dimension(20, 20));
            button1_36.setBackground(Color.YELLOW);
            panel_2.add(button1_36, "10, 7");

            JButton button1_37 = new JButton("");
            button1_37.setPreferredSize(new Dimension(20, 20));
            button1_37.setBackground(Color.YELLOW);
            panel_2.add(button1_37, "11, 7");

            JButton button1_38 = new JButton("");
            button1_38.setPreferredSize(new Dimension(20, 20));
            button1_38.setBackground(Color.YELLOW);
            panel_2.add(button1_38, "12, 7");

            JButton button1_39 = new JButton("");
            button1_39.setPreferredSize(new Dimension(20, 20));
            button1_39.setBackground(Color.YELLOW);
            panel_2.add(button1_39, "13, 7");

            JLabel label1_14 = new JLabel("5");
            label1_14.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_14, "2, 8, 2, 1");

            JButton button1_40 = new JButton("");
            button1_40.setPreferredSize(new Dimension(20, 20));
            button1_40.setBackground(Color.YELLOW);
            panel_2.add(button1_40, "4, 8");

            JButton button1_41 = new JButton("");
            button1_41.setPreferredSize(new Dimension(20, 20));
            button1_41.setBackground(Color.YELLOW);
            panel_2.add(button1_41, "5, 8");

            JButton button1_42 = new JButton("");
            button1_42.setPreferredSize(new Dimension(20, 20));
            button1_42.setBackground(Color.YELLOW);
            panel_2.add(button1_42, "6, 8");

            JButton button1_43 = new JButton("");
            button1_43.setPreferredSize(new Dimension(20, 20));
            button1_43.setBackground(Color.YELLOW);
            panel_2.add(button1_43, "7, 8");

            JButton button1_44 = new JButton("");
            button1_44.setPreferredSize(new Dimension(20, 20));
            button1_44.setBackground(Color.YELLOW);
            panel_2.add(button1_44, "8, 8");

            JButton button1_45 = new JButton("");
            button1_45.setPreferredSize(new Dimension(20, 20));
            button1_45.setBackground(Color.YELLOW);
            panel_2.add(button1_45, "9, 8");

            JButton button1_46 = new JButton("");
            button1_46.setPreferredSize(new Dimension(20, 20));
            button1_46.setBackground(Color.YELLOW);
            panel_2.add(button1_46, "10, 8");

            JButton button1_47 = new JButton("");
            button1_47.setPreferredSize(new Dimension(20, 20));
            button1_47.setBackground(Color.YELLOW);
            panel_2.add(button1_47, "11, 8");

            JButton button1_48 = new JButton("");
            button1_48.setPreferredSize(new Dimension(20, 20));
            button1_48.setBackground(Color.YELLOW);
            panel_2.add(button1_48, "12, 8");

            JButton button1_49 = new JButton("");
            button1_49.setPreferredSize(new Dimension(20, 20));
            button1_49.setBackground(Color.YELLOW);
            panel_2.add(button1_49, "13, 8");

            JLabel label1_15 = new JLabel("6");
            label1_15.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_15, "2, 9, 2, 1");

            JButton button1_50 = new JButton("");
            button1_50.setPreferredSize(new Dimension(20, 20));
            button1_50.setBackground(Color.YELLOW);
            panel_2.add(button1_50, "4, 9");

            JButton button1_51 = new JButton("");
            button1_51.setPreferredSize(new Dimension(20, 20));
            button1_51.setBackground(Color.YELLOW);
            panel_2.add(button1_51, "5, 9");

            JButton button1_52 = new JButton("");
            button1_52.setPreferredSize(new Dimension(20, 20));
            button1_52.setBackground(Color.YELLOW);
            panel_2.add(button1_52, "6, 9");

            JButton button1_53 = new JButton("");
            button1_53.setPreferredSize(new Dimension(20, 20));
            button1_53.setBackground(Color.YELLOW);
            panel_2.add(button1_53, "7, 9");

            JButton button1_54 = new JButton("");
            button1_54.setPreferredSize(new Dimension(20, 20));
            button1_54.setBackground(Color.YELLOW);
            panel_2.add(button1_54, "8, 9");

            JButton button1_55 = new JButton("");
            button1_55.setPreferredSize(new Dimension(20, 20));
            button1_55.setBackground(Color.YELLOW);
            panel_2.add(button1_55, "9, 9");

            JButton button1_56 = new JButton("");
            button1_56.setPreferredSize(new Dimension(20, 20));
            button1_56.setBackground(Color.YELLOW);
            panel_2.add(button1_56, "10, 9");

            JButton button1_57 = new JButton("");
            button1_57.setPreferredSize(new Dimension(20, 20));
            button1_57.setBackground(Color.YELLOW);
            panel_2.add(button1_57, "11, 9");

            JButton button1_58 = new JButton("");
            button1_58.setPreferredSize(new Dimension(20, 20));
            button1_58.setBackground(Color.YELLOW);
            panel_2.add(button1_58, "12, 9");

            JButton button1_59 = new JButton("");
            button1_59.setPreferredSize(new Dimension(20, 20));
            button1_59.setBackground(Color.YELLOW);
            panel_2.add(button1_59, "13, 9");

            JLabel label1_16 = new JLabel("7");
            label1_16.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_16, "2, 10, 2, 1");

            JButton button1_60 = new JButton("");
            button1_60.setPreferredSize(new Dimension(20, 20));
            button1_60.setBackground(Color.YELLOW);
            panel_2.add(button1_60, "4, 10");

            JButton button1_61 = new JButton("");
            button1_61.setPreferredSize(new Dimension(20, 20));
            button1_61.setBackground(Color.YELLOW);
            panel_2.add(button1_61, "5, 10");

            JButton button1_62 = new JButton("");
            button1_62.setPreferredSize(new Dimension(20, 20));
            button1_62.setBackground(Color.YELLOW);
            panel_2.add(button1_62, "6, 10");

            JButton button1_63 = new JButton("");
            button1_63.setPreferredSize(new Dimension(20, 20));
            button1_63.setBackground(Color.YELLOW);
            panel_2.add(button1_63, "7, 10");

            JButton button1_64 = new JButton("");
            button1_64.setPreferredSize(new Dimension(20, 20));
            button1_64.setBackground(Color.YELLOW);
            panel_2.add(button1_64, "8, 10");

            JButton button1_65 = new JButton("");
            button1_65.setPreferredSize(new Dimension(20, 20));
            button1_65.setBackground(Color.YELLOW);
            panel_2.add(button1_65, "9, 10");

            JButton button1_66 = new JButton("");
            button1_66.setPreferredSize(new Dimension(20, 20));
            button1_66.setBackground(Color.YELLOW);
            panel_2.add(button1_66, "10, 10");

            JButton button1_67 = new JButton("");
            button1_67.setPreferredSize(new Dimension(20, 20));
            button1_67.setBackground(Color.YELLOW);
            panel_2.add(button1_67, "11, 10");

            JButton button1_68 = new JButton("");
            button1_68.setPreferredSize(new Dimension(20, 20));
            button1_68.setBackground(Color.YELLOW);
            panel_2.add(button1_68, "12, 10");

            JButton button1_69 = new JButton("");
            button1_69.setPreferredSize(new Dimension(20, 20));
            button1_69.setBackground(Color.YELLOW);
            panel_2.add(button1_69, "13, 10");

            JLabel label1_17 = new JLabel("8");
            label1_17.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_17, "2, 11, 2, 1");

            JButton button1_70 = new JButton("");
            button1_70.setPreferredSize(new Dimension(20, 20));
            button1_70.setBackground(Color.YELLOW);
            panel_2.add(button1_70, "4, 11");

            JButton button1_71 = new JButton("");
            button1_71.setPreferredSize(new Dimension(20, 20));
            button1_71.setBackground(Color.YELLOW);
            panel_2.add(button1_71, "5, 11");

            JButton button1_72 = new JButton("");
            button1_72.setPreferredSize(new Dimension(20, 20));
            button1_72.setBackground(Color.YELLOW);
            panel_2.add(button1_72, "6, 11");

            JButton button1_73 = new JButton("");
            button1_73.setPreferredSize(new Dimension(20, 20));
            button1_73.setBackground(Color.YELLOW);
            panel_2.add(button1_73, "7, 11");

            JButton button1_74 = new JButton("");
            button1_74.setPreferredSize(new Dimension(20, 20));
            button1_74.setBackground(Color.YELLOW);
            panel_2.add(button1_74, "8, 11");

            JButton button1_75 = new JButton("");
            button1_75.setPreferredSize(new Dimension(20, 20));
            button1_75.setBackground(Color.YELLOW);
            panel_2.add(button1_75, "9, 11");

            JButton button1_76 = new JButton("");
            button1_76.setPreferredSize(new Dimension(20, 20));
            button1_76.setBackground(Color.YELLOW);
            panel_2.add(button1_76, "10, 11");

            JButton button1_77 = new JButton("");
            button1_77.setPreferredSize(new Dimension(20, 20));
            button1_77.setBackground(Color.YELLOW);
            panel_2.add(button1_77, "11, 11");

            JButton button1_78 = new JButton("");
            button1_78.setPreferredSize(new Dimension(20, 20));
            button1_78.setBackground(Color.YELLOW);
            panel_2.add(button1_78, "12, 11");

            JButton button1_79 = new JButton("");
            button1_79.setPreferredSize(new Dimension(20, 20));
            button1_79.setBackground(Color.YELLOW);
            panel_2.add(button1_79, "13, 11");

            JLabel label1_18 = new JLabel("9");
            label1_18.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_18, "2, 12, 2, 1");

            JButton button1_80 = new JButton("");
            button1_80.setPreferredSize(new Dimension(20, 20));
            button1_80.setBackground(Color.YELLOW);
            panel_2.add(button1_80, "4, 12");

            JButton button1_81 = new JButton("");
            button1_81.setPreferredSize(new Dimension(20, 20));
            button1_81.setBackground(Color.YELLOW);
            panel_2.add(button1_81, "5, 12");

            JButton button1_82 = new JButton("");
            button1_82.setPreferredSize(new Dimension(20, 20));
            button1_82.setBackground(Color.YELLOW);
            panel_2.add(button1_82, "6, 12");

            JButton button1_83 = new JButton("");
            button1_83.setPreferredSize(new Dimension(20, 20));
            button1_83.setBackground(Color.YELLOW);
            panel_2.add(button1_83, "7, 12");

            JButton button1_84 = new JButton("");
            button1_84.setPreferredSize(new Dimension(20, 20));
            button1_84.setBackground(Color.YELLOW);
            panel_2.add(button1_84, "8, 12");

            JButton button1_85 = new JButton("");
            button1_85.setPreferredSize(new Dimension(20, 20));
            button1_85.setBackground(Color.YELLOW);
            panel_2.add(button1_85, "9, 12");

            JButton button1_86 = new JButton("");
            button1_86.setPreferredSize(new Dimension(20, 20));
            button1_86.setBackground(Color.YELLOW);
            panel_2.add(button1_86, "10, 12");

            JButton button1_87 = new JButton("");
            button1_87.setPreferredSize(new Dimension(20, 20));
            button1_87.setBackground(Color.YELLOW);
            panel_2.add(button1_87, "11, 12");

            JButton button1_88 = new JButton("");
            button1_88.setPreferredSize(new Dimension(20, 20));
            button1_88.setBackground(Color.YELLOW);
            panel_2.add(button1_88, "12, 12");

            JButton button1_89 = new JButton("");
            button1_89.setPreferredSize(new Dimension(20, 20));
            button1_89.setBackground(Color.YELLOW);
            panel_2.add(button1_89, "13, 12");

            JLabel label1_19 = new JLabel("10");
            label1_19.setHorizontalAlignment(SwingConstants.CENTER);
            panel_2.add(label1_19, "2, 13, 2, 1");

            JButton button1_90 = new JButton("");
            button1_90.setPreferredSize(new Dimension(20, 20));
            button1_90.setBackground(Color.YELLOW);
            panel_2.add(button1_90, "4, 13");

            JButton button1_91 = new JButton("");
            button1_91.setPreferredSize(new Dimension(20, 20));
            button1_91.setBackground(Color.YELLOW);
            panel_2.add(button1_91, "5, 13");

            JButton button1_92 = new JButton("");
            button1_92.setPreferredSize(new Dimension(20, 20));
            button1_92.setBackground(Color.YELLOW);
            panel_2.add(button1_92, "6, 13");

            JButton button1_93 = new JButton("");
            button1_93.setPreferredSize(new Dimension(20, 20));
            button1_93.setBackground(Color.YELLOW);
            panel_2.add(button1_93, "7, 13");

            JButton button1_94 = new JButton("");
            button1_94.setPreferredSize(new Dimension(20, 20));
            button1_94.setBackground(Color.YELLOW);
            panel_2.add(button1_94, "8, 13");

            JButton button1_95 = new JButton("");
            button1_95.setPreferredSize(new Dimension(20, 20));
            button1_95.setBackground(Color.YELLOW);
            panel_2.add(button1_95, "9, 13");

            JButton button1_96 = new JButton("");
            button1_96.setPreferredSize(new Dimension(20, 20));
            button1_96.setBackground(Color.YELLOW);
            panel_2.add(button1_96, "10, 13");

            JButton button1_97 = new JButton("");
            button1_97.setPreferredSize(new Dimension(20, 20));
            button1_97.setBackground(Color.YELLOW);
            panel_2.add(button1_97, "11, 13");

            JButton button1_98 = new JButton("");
            button1_98.setPreferredSize(new Dimension(20, 20));
            button1_98.setBackground(Color.YELLOW);
            panel_2.add(button1_98, "12, 13");

            JButton button1_99 = new JButton("");
            button1_99.setPreferredSize(new Dimension(20, 20));
            button1_99.setBackground(Color.YELLOW);
            panel_2.add(button1_99, "13, 13");


            buttons1.add(button1);
            buttons1.add(button1_1);
            buttons1.add(button1_2);
            buttons1.add(button1_3);
            buttons1.add(button1_4);
            buttons1.add(button1_5);
            buttons1.add(button1_6);
            buttons1.add(button1_7);
            buttons1.add(button1_8);
            buttons1.add(button1_9);
            buttons1.add(button1_10);
            buttons1.add(button1_11);
            buttons1.add(button1_12);
            buttons1.add(button1_13);
            buttons1.add(button1_14);
            buttons1.add(button1_15);
            buttons1.add(button1_16);
            buttons1.add(button1_17);
            buttons1.add(button1_18);
            buttons1.add(button1_19);
            buttons1.add(button1_20);
            buttons1.add(button1_21);
            buttons1.add(button1_22);
            buttons1.add(button1_23);
            buttons1.add(button1_24);
            buttons1.add(button1_25);
            buttons1.add(button1_26);
            buttons1.add(button1_27);
            buttons1.add(button1_28);
            buttons1.add(button1_29);
            buttons1.add(button1_30);
            buttons1.add(button1_31);
            buttons1.add(button1_32);
            buttons1.add(button1_33);
            buttons1.add(button1_34);
            buttons1.add(button1_35);
            buttons1.add(button1_36);
            buttons1.add(button1_37);
            buttons1.add(button1_38);
            buttons1.add(button1_39);
            buttons1.add(button1_40);
            buttons1.add(button1_41);
            buttons1.add(button1_42);
            buttons1.add(button1_43);
            buttons1.add(button1_44);
            buttons1.add(button1_45);
            buttons1.add(button1_46);
            buttons1.add(button1_47);
            buttons1.add(button1_48);
            buttons1.add(button1_49);
            buttons1.add(button1_50);
            buttons1.add(button1_51);
            buttons1.add(button1_52);
            buttons1.add(button1_53);
            buttons1.add(button1_54);
            buttons1.add(button1_55);
            buttons1.add(button1_56);
            buttons1.add(button1_57);
            buttons1.add(button1_58);
            buttons1.add(button1_59);
            buttons1.add(button1_60);
            buttons1.add(button1_61);
            buttons1.add(button1_62);
            buttons1.add(button1_63);
            buttons1.add(button1_64);
            buttons1.add(button1_65);
            buttons1.add(button1_66);
            buttons1.add(button1_67);
            buttons1.add(button1_68);
            buttons1.add(button1_69);
            buttons1.add(button1_70);
            buttons1.add(button1_71);
            buttons1.add(button1_72);
            buttons1.add(button1_73);
            buttons1.add(button1_74);
            buttons1.add(button1_75);
            buttons1.add(button1_76);
            buttons1.add(button1_77);
            buttons1.add(button1_78);
            buttons1.add(button1_79);
            buttons1.add(button1_80);
            buttons1.add(button1_81);
            buttons1.add(button1_82);
            buttons1.add(button1_83);
            buttons1.add(button1_84);
            buttons1.add(button1_85);
            buttons1.add(button1_86);
            buttons1.add(button1_87);
            buttons1.add(button1_88);
            buttons1.add(button1_89);
            buttons1.add(button1_90);
            buttons1.add(button1_91);
            buttons1.add(button1_92);
            buttons1.add(button1_93);
            buttons1.add(button1_94);
            buttons1.add(button1_95);
            buttons1.add(button1_96);
            buttons1.add(button1_97);
            buttons1.add(button1_98);
            buttons1.add(button1_99);

        }
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).addActionListener(new Attack());
        }
        {
            JPanel panel_3 = new JPanel();
            panel_3.setPreferredSize(new Dimension(0, 150));
            panel.add(panel_3);
            panel_3.setLayout(new FormLayout(new ColumnSpec[]{
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(15dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),
                    FormSpecs.RELATED_GAP_COLSPEC,
                    ColumnSpec.decode("center:max(11dlu;pref)"),},
                    new RowSpec[]{
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,
                            FormSpecs.RELATED_GAP_ROWSPEC,
                            FormSpecs.DEFAULT_ROWSPEC,}));

            JButton button_103 = new JButton("");
            button_103.setPreferredSize(new Dimension(20, 20));
            button_103.setBackground(Color.ORANGE);
            panel_3.add(button_103, "36, 4");

            JLabel label_20 = new JLabel("- ПРОМАХ ПК");
            panel_3.add(label_20, "38, 4, fill, center");

            JButton button_102 = new JButton("");
            button_102.setPreferredSize(new Dimension(20, 20));
            button_102.setBackground(Color.BLACK);
            panel_3.add(button_102, "36, 6");

            JLabel label_21 = new JLabel("- ВАШИ КОРАБЛИ");
            panel_3.add(label_21, "38, 6, fill, center");

            JButton button_101 = new JButton("");
            button_101.setPreferredSize(new Dimension(20, 20));
            button_101.setBackground(Color.RED);
            panel_3.add(button_101, "36, 8");

            JLabel label_22 = new JLabel("- ПОПАДАНИЕ ПК");
            panel_3.add(label_22, "38, 8, fill, center");

            JButton button_100 = new JButton("");
            button_100.setPreferredSize(new Dimension(20, 20));
            button_100.setBackground(Color.LIGHT_GRAY);
            panel_3.add(button_100, "36, 10");

            JLabel label_23 = new JLabel("- НЕ ИСПОЛЬЗ ОБЛАСТЬ");
            panel_3.add(label_23, "38, 10, fill, center");

            JButton btnEnd = new JButton("END");
            btnEnd.addActionListener(new ForEnd());
            panel_3.add(btnEnd, "8, 4");
        }

        Component verticalStrut = Box.createVerticalStrut(100);
        panel.add(verticalStrut);


        setVisible(true);

    }

    class ForEnd implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            forCopy.dispose();
        }
    }


    class ForMyThread implements Runnable {
        @Override
        public void run() {

            while (!gamer1.win && !gamer2.win) {
                defenseTable();
                while (butWait) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                for (int i = 0; i < buttons.size(); i++) {
                    buttons.get(i).setEnabled(false);
                }
                if(gamer1.win){
                    break;
                }
                turn.setText("ПК ХОДИТ");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                gamer2.tryScope(gamer1, forCopy);
                //defenseTable();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                turn.setText("ВАШ ХОД!!!");

                for (int i = 0; i < buttons.size(); i++) {
                    buttons.get(i).setEnabled(true);
                }

                butWait();

                // сделать очередность ходов и связать gamer1.fieldGamer и попытки попадания
            }
            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).setEnabled(false);
            }
            if (gamer1.win) {
                someWin.setText("<html>ВАША <br>ПОБЕДА</html>");
            } else if (gamer2.win) {
                someWin.setText("<html>ЗА ПК<br>ПОБЕДА</html>");
            }
        }
    }
}
