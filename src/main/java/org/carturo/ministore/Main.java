package org.carturo.ministore;

import org.carturo.ministore.service.InventoryService;
import org.carturo.ministore.util.Validation;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();

        String menu = """
                🛒 Mini Store Menu:
                1. Add product
                2. List inventory
                3. Purchase product
                4. Statistics
                5. Search product
                6. Exit
                """;

        int operation = -1;

        do {
            String input = JOptionPane.showInputDialog(null, menu, "Mini Store", JOptionPane.INFORMATION_MESSAGE);

            if (input == null) {
                break;
            }

            try {
                operation = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "❌ Invalid option. Please enter a number.");
                continue;
            }

            switch (operation) {
                case 0 -> { // Add product
                    String name = Validation.askText("📝 Product name:");
                    double price = Validation.askDouble("💲 Product price:");
                    int stock = Validation.askInteger("📦 Initial stock:");
                    inventory.addProduct(name, price, stock);
                }
                case 1 -> inventory.listInventory();
                case 2 -> {
                    String name = Validation.askText("🛍️ Product name to purchase:");
                    int quantity = Validation.askInteger("🔢 Quantity to purchase:");
                    inventory.purchaseProduct(name, quantity);
                }
                case 3 -> inventory.showStatistics();
                case 4 -> {
                    String name = Validation.askText("🔍 Name to search:");
                    inventory.searchProduct(name);
                }
                case 5 -> inventory.showFinalReceipt();
                default -> JOptionPane.showMessageDialog(null, "❌ Invalid option. Please choose between 1 and 6.");
            }

        } while (operation != 5);

        System.exit(0);
    }
}