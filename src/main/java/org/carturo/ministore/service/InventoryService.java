package org.carturo.ministore.service;

import org.carturo.ministore.model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class InventoryService {

    private final ArrayList<String> productNames;
    private double[] prices;
    private final HashMap<String, Integer> stock;
    private double totalPurchases;

    public InventoryService() {
        productNames = new ArrayList<>();
        prices = new double[0];
        stock = new HashMap<>();
        totalPurchases = 0;
    }

    public void addProduct(String name, double price, int stockAmount) {
        if (productNames.contains(name)) {
            JOptionPane.showMessageDialog(null, "Product already exists.");
            return;
        }
        productNames.add(name);
        prices = expandPrices(prices, price);
        stock.put(name, stockAmount);
        JOptionPane.showMessageDialog(null, "Product added successfully.");
    }

    private double[] expandPrices(double[] oldPrices, double newPrice) {
        double[] newPrices = new double[oldPrices.length + 1];
        System.arraycopy(oldPrices, 0, newPrices, 0, oldPrices.length);
        newPrices[oldPrices.length] = newPrice;
        return newPrices;
    }

    public int indexOfName(String name) {
        return productNames.indexOf(name);
    }

    public void listInventory() {
        if (productNames.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products in inventory.");
            return;
        }
        StringBuilder sb = new StringBuilder("Inventory:\n");
        for (int i = 0; i < productNames.size(); i++) {
            sb.append(String.format("%d. %s | Price: %.2f | Stock: %d\n",
                    i + 1,
                    productNames.get(i),
                    prices[i],
                    stock.get(productNames.get(i))));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void purchaseProduct(String name, int quantity) {
        int idx = indexOfName(name);
        if (idx == -1) {
            JOptionPane.showMessageDialog(null, "Product not found.");
            return;
        }
        int currentStock = stock.get(name);
        if (quantity > currentStock) {
            JOptionPane.showMessageDialog(null, "Insufficient stock.");
            return;
        }
        stock.put(name, currentStock - quantity);
        double subtotal = prices[idx] * quantity;
        totalPurchases += subtotal;
        JOptionPane.showMessageDialog(null, String.format(
                "Purchase successful: %s x%d → Subtotal: %.2f",
                name, quantity, subtotal));
    }

    public void showStatistics() {
        if (prices.length == 0) {
            JOptionPane.showMessageDialog(null, "No products available.");
            return;
        }
        double minPrice = prices[0];
        double maxPrice = prices[0];
        String minName = productNames.get(0);
        String maxName = productNames.get(0);

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minName = productNames.get(i);
            }
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
                maxName = productNames.get(i);
            }
        }

        JOptionPane.showMessageDialog(null, String.format(
                "Cheapest product: %s → %.2f\nMost expensive product: %s → %.2f",
                minName, minPrice, maxName, maxPrice));
    }

    public void searchProduct(String query) {
        StringBuilder sb = new StringBuilder("Search results:\n");
        boolean found = false;
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).toLowerCase().contains(query.toLowerCase())) {
                sb.append(String.format("%s | Price: %.2f | Stock: %d\n",
                        productNames.get(i), prices[i], stock.get(productNames.get(i))));
                found = true;
            }
        }
        JOptionPane.showMessageDialog(null, found ? sb.toString() : "No matches found.");
    }

    public void showFinalReceipt() {
        JOptionPane.showMessageDialog(null, String.format("Total purchases: %.2f", totalPurchases));
    }
}