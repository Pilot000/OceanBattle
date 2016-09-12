import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BestFrame extends JFrame {

    private JPanel contentPane;
    GameFrame game;


    class StartGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Gamer gamer1 = new Gamer();
            Gamer gamer2 = new CompGamer();
            gamer1.gamerStart();
            gamer2.placeAllShips();
            game = new GameFrame(gamer1, gamer2);
            game.myThread.start();
        }
    }

    public BestFrame() {
        setBounds(350, 250, 500, 500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{30, 30, 30, 30, 30, 30, 30, 0, 0};
        gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 0, 30, 30, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JButton btnNewButton = new JButton("Новая Игра");
        btnNewButton.addActionListener(new StartGame());
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.gridx = 7;
        gbc_btnNewButton.gridy = 7;
        getContentPane().add(btnNewButton, gbc_btnNewButton);
    }


}
