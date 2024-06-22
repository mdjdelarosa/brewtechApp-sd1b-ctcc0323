package brewtech;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrinkTypeFrame extends JFrame {

    public DrinkTypeFrame() {
        initComponents();
        setTitle("Choose Drink Type");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
    }

    DrinkTypeFrame(ArrayList<OrderItemData> cart) {
        
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        String[] drinkTypes = {"Hot Coffee", "Iced Coffee", "Fruity Drink", "Milk Tea", "Soda"};
        for (String drinkType : drinkTypes) {
            JButton button = createButton(drinkType);
            panel.add(button);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        getContentPane().add(scrollPane);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 20)); // Set button dimensions
        button.setBackground(new Color(90, 60, 30)); // Set button color to brown
        button.setForeground(Color.WHITE); // Set text color to white
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMenu(text);
            }
        });
        return button;
    }

    private void openMenu(String drinkType) {
        MenuFrame menuFrame = new MenuFrame(drinkType);
        menuFrame.setVisible(true);
        this.setVisible(false); // Hide the current frame
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrinkTypeFrame().setVisible(true);
            }
        });
    }

}
