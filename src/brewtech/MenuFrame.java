package brewtech;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MenuFrame extends JFrame {
    private ArrayList<OrderItemData> cart;
    private JPanel menuPanel;
    private JPanel orderDetailsPanel;
    private JComboBox<String> sizeComboBox;
    private JPanel addonsPanel;
    private HashMap<String, Double> addonsPrices;
    private JLabel sizePriceLabel;
    private JLabel addonsPriceLabel;
    private JLabel totalPriceLabel;  // Add a label to show total price
    private double basePrice;

    public MenuFrame(String drinkType) {
        this(drinkType, new ArrayList<>()); // Default to an empty cart if not provided
    }

    public MenuFrame(String drinkType, ArrayList<OrderItemData> cart) {
        setTitle("BrewTech - " + drinkType);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);

        this.cart = cart; // Initialize cart with provided items

        getContentPane().setBackground(new Color(102, 51, 0)); // Dark brown background
        setLayout(new BorderLayout()); // Ensure border layout for components

        initComponents(drinkType);
    }

    private void initComponents(String drinkType) {
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        displayMenu(drinkType);

        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(new Color(90, 60, 30)); // Dark brown background
        scrollPane.getViewport().setBackground(new Color(102, 51, 0)); // Set viewport background

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        orderDetailsPanel = new JPanel();
        orderDetailsPanel.setLayout(new BoxLayout(orderDetailsPanel, BoxLayout.Y_AXIS));
        orderDetailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding
        orderDetailsPanel.setVisible(false); // Initially hidden

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(90, 60, 30)); // Dark brown background

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(90, 60, 30)); // Set button color to brown
        backButton.setForeground(Color.WHITE); // Set text color to white
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDrinkTypeFrame();
            }
        });
        bottomPanel.add(backButton);

        JButton cartButton = new JButton("Open Cart");
        cartButton.setBackground(new Color(90, 60, 30)); // Set button color to brown
        cartButton.setForeground(Color.WHITE); // Set text color to white
        cartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCartFrame();
            }
        });
        bottomPanel.add(cartButton);

        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        getContentPane().add(orderDetailsPanel, BorderLayout.EAST);
    }

    private void displayMenu(String drinkType) {
        menuPanel.removeAll();
        menuPanel.setBackground(new Color(90, 60, 30)); // Dark brown background

        
        HashMap<String, Double> menuItems = getMenuItems(drinkType);
        for (String item : menuItems.keySet()) {
            JPanel itemPanel = createItemPanel(item, menuItems.get(item));
            menuPanel.add(itemPanel);
        }

        revalidate();
        repaint();
    }

    private HashMap<String, Double> getMenuItems(String drinkType) {
        HashMap<String, Double> items = new HashMap<>();
        switch (drinkType) {
            case "Hot Coffee":
                items.put("Espresso", 140.00);
                items.put("Latte", 160.00);
                items.put("Cappuccino", 170.00);
                items.put("Americano", 120.00);
                items.put("Flat White", 160.00);
                items.put("Mocha", 180.00);
                items.put("Macchiato", 120.00);
                break;
            case "Iced Coffee":
                items.put("Iced Latte", 180.00);
                items.put("Iced Mocha", 190.00);
                items.put("Iced Americano", 140.00);
                items.put("Iced Caramel Macchiato", 200.00);
                break;
            case "Milkshake":
                items.put("Vanilla Milkshake", 150.00);
                items.put("Chocolate Milkshake", 160.00);
                items.put("Strawberry Milkshake", 160.00);
                items.put("Caramel Milkshake", 170.00);
                break;
            case "Tea":
                items.put("Green Tea", 130.00);
                items.put("Black Tea", 120.00);
                items.put("Oolong Tea", 140.00);
                items.put("Herbal Tea", 110.00);
                break;
            case "Frappuccino":
                items.put("Java Chip Frappuccino", 200.00);
                items.put("Mocha Frappuccino", 210.00);
                items.put("Caramel Frappuccino", 220.00);
                items.put("Coffee Frappuccino", 190.00);
                break;
            default:
                break;
        }
        return items;
    }

    private JPanel createItemPanel(String itemName, double price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        itemPanel.setBackground(new Color(90, 60, 30)); // Dark brown background
        itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel itemLabel = new JLabel(itemName + " - Php" + price);
        itemLabel.setFont(itemLabel.getFont().deriveFont(18.0f));
        itemLabel.setForeground(Color.WHITE);
        itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemPanel.add(itemLabel);

        JButton orderButton = new JButton("Order");
        orderButton.setBackground(new Color(90, 60, 30)); // Set button color to brown
        orderButton.setForeground(Color.WHITE); // Set text color to white
        orderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openOrderDetails(itemName, price);
            }
        });
        itemPanel.add(orderButton);

        return itemPanel;
    }

    private void openOrderDetails(String itemName, double price) {
        basePrice = price;

        orderDetailsPanel.removeAll();
        orderDetailsPanel.setVisible(true);
        getContentPane().setBackground(new Color(102, 51, 0));

        JLabel itemLabel = new JLabel(itemName);
        itemLabel.setFont(itemLabel.getFont().deriveFont(18.0f));
        orderDetailsPanel.add(itemLabel);

        JLabel sizeLabel = new JLabel("Select Size:");
        sizeLabel.setFont(sizeLabel.getFont().deriveFont(13.0f));
        orderDetailsPanel.add(sizeLabel);

        String[] sizes = {"Short", "Tall", "Grande", "Venti"};
        double[] sizePrices = {0, 15, 25, 35}; // Price increments for each size
        sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.setPreferredSize(new Dimension(100, 20));
        sizeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = sizeComboBox.getSelectedIndex();
                double sizePrice = sizePrices[selectedIndex];
                double totalDrinkPrice = basePrice + sizePrice;
                sizePriceLabel.setText(String.format("Drink Price: Php%.2f", totalDrinkPrice));
                updateTotalPrice(); // Call updateTotalPrice() method to handle other price updates
            }
        });
        orderDetailsPanel.add(sizeComboBox);

        // Initialize size price label with base price + initial size price
        double initialSizePrice = sizePrices[sizeComboBox.getSelectedIndex()];
        double initialTotalDrinkPrice = basePrice + initialSizePrice;
        sizePriceLabel = new JLabel(String.format("Drink Price: Php%.2f", initialTotalDrinkPrice));
        sizePriceLabel.setFont(sizePriceLabel.getFont().deriveFont(13.0f));
        orderDetailsPanel.add(sizePriceLabel);

        JLabel addonsLabel = new JLabel("Select Add-ons:");
        addonsLabel.setFont(addonsLabel.getFont().deriveFont(13.0f));
        orderDetailsPanel.add(addonsLabel);

        addonsPrices = new HashMap<>();
        addonsPrices.put("Ice", 15.00);
        addonsPrices.put("Milk", 20.00);
        addonsPrices.put("Whipped Cream", 20.00);
        addonsPrices.put("Extra Shot", 30.00);
        addonsPrices.put("Caramel Syrup", 25.00);
        addonsPrices.put("Chocolate Syrup", 25.00);
        addonsPrices.put("Vanilla Syrup", 25.00);
        addonsPrices.put("Soy Milk", 20.00);
        

        addonsPanel = new JPanel();
        addonsPanel.setLayout(new BoxLayout(addonsPanel, BoxLayout.Y_AXIS));
        

        for (String addon : addonsPrices.keySet()) {
            JCheckBox addonCheckBox = new JCheckBox(addon);
            addonCheckBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    updateTotalPrice();
                }
            });
            addonsPanel.add(addonCheckBox);
        }
        orderDetailsPanel.add(addonsPanel);

        addonsPriceLabel = new JLabel("Add-ons Price: Php0.00");
        addonsPriceLabel.setFont(addonsPriceLabel.getFont().deriveFont(16.0f));
        
        orderDetailsPanel.add(addonsPriceLabel);

        totalPriceLabel = new JLabel("Total Price: Php0.00");
        totalPriceLabel.setFont(totalPriceLabel.getFont().deriveFont(16.0f));
        
        orderDetailsPanel.add(totalPriceLabel);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBackground(new Color(90, 60, 30)); // Set button color to brown
        addToCartButton.setForeground(Color.WHITE); // Set text color to white
        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToCart(itemName, basePrice);
            }
        });
        orderDetailsPanel.add(addToCartButton);

        revalidate();
        repaint();
    }

    private void updateTotalPrice() {
        double sizePrice = 0;
        if (sizeComboBox != null) {
            int selectedIndex = sizeComboBox.getSelectedIndex();
            double[] sizePrices = {0, 20, 40, 60};
            sizePrice = sizePrices[selectedIndex];
        }

        double addonsPrice = 0;
        if (addonsPanel != null) {
            Component[] components = addonsPanel.getComponents();
            for (Component component : components) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) component;
                    if (checkBox.isSelected()) {
                        addonsPrice += addonsPrices.get(checkBox.getText());
                    }
                }
            }
        }

        double totalPrice = basePrice + sizePrice + addonsPrice;
        
        sizePriceLabel.setText(String.format("Size Price: Php%.2f", sizePrice));
        addonsPriceLabel.setText(String.format("Add-ons Price: Php%.2f", addonsPrice));
        totalPriceLabel.setText(String.format("Total Price: Php%.2f", totalPrice));  // Update the total price label
    }

    private void addItemToCart(String itemName, double basePrice) {
        String size = (String) sizeComboBox.getSelectedItem();

        ArrayList<String> addons = new ArrayList<>();
        Component[] components = addonsPanel.getComponents();
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                if (checkBox.isSelected()) {
                    addons.add(checkBox.getText());
                }
            }
        }

        double sizePrice = 0;
        int selectedIndex = sizeComboBox.getSelectedIndex();
        double[] sizePrices = {0, 20, 40, 60};
        sizePrice = sizePrices[selectedIndex];

        double addonsPrice = 0;
        for (String addon : addons) {
            addonsPrice += addonsPrices.get(addon);
        }

        double totalPrice = basePrice + sizePrice + addonsPrice;

        OrderItemData orderItem = new OrderItemData(itemName, size, addons, totalPrice);
        cart.add(orderItem);

        JOptionPane.showMessageDialog(this, "Item added to cart", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearOrderDetails();  // Clear order details after adding to cart
    }

    private void clearOrderDetails() {
        orderDetailsPanel.removeAll();
        orderDetailsPanel.setVisible(false);
    }

    private void openCartFrame() {
        CartFrame cartFrame = new CartFrame(cart);
        cartFrame.setVisible(true);
    }

    private void openDrinkTypeFrame() {
        DrinkTypeFrame drinkTypeFrame = new DrinkTypeFrame(cart);
        drinkTypeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame("Hot Coffee").setVisible(true);
            }
        });
    }
}
