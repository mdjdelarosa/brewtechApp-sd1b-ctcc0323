package brewtech;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CartFrame extends JFrame {
    private ArrayList<OrderItemData> cart;

    public CartFrame(ArrayList<OrderItemData> cart) {
        setTitle("Cart");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Use DISPOSE_ON_CLOSE to allow returning to the main frame
        setSize(900, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(102, 51, 0)); // Dark brown background

        this.cart = cart;

        initComponents();
    }

    private void initComponents() {
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
        cartPanel.setBackground(new Color(90, 60, 30)); // Dark brown background

        JScrollPane scrollPane = new JScrollPane(cartPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(new Color(90, 60, 30)); // Dark brown background

        for (OrderItemData item : cart) {
            JPanel itemPanel = createItemPanel(item);
            cartPanel.add(itemPanel);
        }

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBackground(new Color(90, 60, 30)); // Dark brown background

        JLabel totalPriceLabel = new JLabel();
        totalPriceLabel.setFont(totalPriceLabel.getFont().deriveFont(18.0f));
        totalPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalPriceLabel.setForeground(Color.WHITE);

        updateTotalPrice(totalPriceLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(90, 60, 30)); // Dark brown background

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setBackground(new Color(90, 60, 30)); // Set button color to brown
        checkoutButton.setForeground(Color.WHITE); // Set text color to white
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCheckoutDialog();
            }
        });
        buttonPanel.add(checkoutButton);

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(90, 60, 30)); // Set button color to brown
        backButton.setForeground(Color.WHITE); // Set text color to white
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(backButton);

        bottomPanel.add(totalPriceLabel);
        bottomPanel.add(buttonPanel);

        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createItemPanel(OrderItemData item) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemPanel.setBackground(new Color(90, 60, 30)); // Dark brown background

        JLabel itemLabel = new JLabel(item.getItemName() + " (" + item.getSize() + ")");
        itemLabel.setFont(itemLabel.getFont().deriveFont(18.0f));
        itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemLabel.setForeground(Color.WHITE);

        JLabel addonsLabel = new JLabel("Add-ons: " + String.join(", ", item.getAddons()));
        addonsLabel.setFont(addonsLabel.getFont().deriveFont(16.0f));
        addonsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addonsLabel.setForeground(Color.WHITE);

        JLabel priceLabel = new JLabel(String.format("Total: Php%.2f", item.getTotalPrice()));
        priceLabel.setFont(priceLabel.getFont().deriveFont(16.0f));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setForeground(Color.WHITE);

        itemPanel.add(itemLabel);
        itemPanel.add(addonsLabel);
        itemPanel.add(priceLabel);
        itemPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        return itemPanel;
    }

    private void updateTotalPrice(JLabel totalPriceLabel) {
        double totalCartPrice = 0;
        for (OrderItemData item : cart) {
            totalCartPrice += item.getTotalPrice();
        }
        totalPriceLabel.setText(String.format("Total Price of All Items: Php%.2f", totalCartPrice));
    }
    private void showCheckoutDialog() {
        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new GridLayout(0, 1));
        

        JTextField addressField = new JTextField(20);
        JTextField contactNumberField = new JTextField(20);

        JPanel paymentPanel = new JPanel();
        
        JLabel paymentLabel = new JLabel("Select Payment Method:");
        
        JComboBox<String> paymentMethodComboBox = new JComboBox<>(new String[]{"Cash", "Credit Card", "PayPal", "Maya", "G-cash"});
        paymentPanel.add(paymentLabel);
        paymentPanel.add(paymentMethodComboBox);

        checkoutPanel.add(new JLabel("Enter Address:"));
       
        checkoutPanel.add(addressField);
        checkoutPanel.add(new JLabel("Enter Contact Number:"));
      
        checkoutPanel.add(contactNumberField);
        checkoutPanel.add(paymentPanel);

        int option = JOptionPane.showConfirmDialog(this, checkoutPanel, "Checkout Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String address = addressField.getText();
            String contactNumber = contactNumberField.getText();
            String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();

            // Validate inputs (you can add more thorough validation as needed)
            if (address.isEmpty() || contactNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                performCheckout(address, contactNumber, paymentMethod);
            }
        }
    }

    private void performCheckout(String address, String contactNumber, String paymentMethod) {
        // Perform actual checkout process (e.g., send data to server, process payment, etc.)
        // For now, let's just show a confirmation message
        JOptionPane.showMessageDialog(this, "Checkout successful!\nAddress: " + address + "\nContact Number: " + contactNumber + "\nPayment Method: " + paymentMethod, "Checkout Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Sample data for testing
        ArrayList<OrderItemData> sampleCart = new ArrayList<>();
        sampleCart.add(new OrderItemData("Coffee", "Large", new ArrayList<>(java.util.List.of("Milk", "Sugar")), 120));
        sampleCart.add(new OrderItemData("Tea", "Medium", new ArrayList<>(java.util.List.of("Lemon")), 100));

        // Launch the CartFrame
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CartFrame(sampleCart).setVisible(true);
            }
        });
    }
}
