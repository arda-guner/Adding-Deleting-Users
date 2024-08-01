package All_GUIs_Are_One;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Delete_User extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> list1;
    private DefaultListModel<String> listModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Add_Delete_User frame = new Add_Delete_User();
                    frame.setVisible(true);
                    frame.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Add_Delete_User() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 343, 447);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        listModel = new DefaultListModel<>();
        list1 = new JList<>(listModel);
        list1.setBounds(25, 99, 265, 248);
        contentPane.add(list1);

        JButton button1 = new JButton("Add");
        button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        button1.setBounds(25, 367, 93, 21);
        contentPane.add(button1);

        JButton button2 = new JButton("Delete");
        button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        button2.setBounds(197, 367, 93, 21);
        contentPane.add(button2);

        JLabel label1 = new JLabel("Toestand:");
        label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label1.setBounds(25, 30, 76, 21);
        contentPane.add(label1);

        JLabel label3 = new JLabel("N.V.T");
        label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label3.setBounds(114, 30, 93, 21);
        contentPane.add(label3);

        JLabel label2 = new JLabel("Gebruiker: ");
        label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label2.setBounds(27, 61, 170, 21);
        contentPane.add(label2);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String naam_achternaam = JOptionPane.showInputDialog("Uw naam en achternaam a.u.b: ");

                if (naam_achternaam != null && !naam_achternaam.trim().isEmpty()) {
                    label3.setText("Toegevoed!");
                    label2.setText("Gebruikers: " + naam_achternaam);
                    label3.setBackground(Color.GREEN);
                    label3.setOpaque(true);
                    listModel.addElement(naam_achternaam);
                } else {
                    label3.setText("Oops, er is een fout.");
                    label3.setBackground(Color.RED);
                    label3.setOpaque(true);
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int verkoos_index = list1.getSelectedIndex();

                if (verkoos_index != -1) {
                    listModel.remove(verkoos_index);
                    label3.setText("Verwijderd:(");
                    label3.setBackground(Color.RED);
                    label3.setOpaque(true);
                } else {
                    label3.setText("Verkies een gebruiker te verwijieren");
                }
            }
        });
    }
}