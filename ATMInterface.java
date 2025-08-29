import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMInterfaceGUI extends JFrame {
    private double balance = 1000.00; // Starting balance

    private JLabel balanceLabel;
    private JTextArea messageArea;
    private JButton checkBalanceBtn, depositBtn, withdrawBtn, exitBtn;

    public ATMInterfaceGUI() {
        setTitle("🏦 ATM Interface");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Top Label
        balanceLabel = new JLabel("💰 Current Balance: ₹" + String.format("%.2f", balance), JLabel.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(balanceLabel, BorderLayout.NORTH);

        // Center - Message Area
        messageArea = new JTextArea(8, 30);
        messageArea.setEditable(false);
        messageArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        messageArea.setBorder(BorderFactory.createTitledBorder("Transaction Messages"));
        add(new JScrollPane(messageArea), BorderLayout.CENTER);

        // Bottom - Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        checkBalanceBtn = new JButton("Check Balance");
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");
        exitBtn = new JButton("Exit");

        buttonPanel.add(checkBalanceBtn);
        buttonPanel.add(depositBtn);
        buttonPanel.add(withdrawBtn);
        buttonPanel.add(exitBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        checkBalanceBtn.addActionListener(e -> checkBalance());
        depositBtn.addActionListener(e -> depositMoney());
        withdrawBtn.addActionListener(e -> withdrawMoney());
        exitBtn.addActionListener(e -> exitATM());
    }

    // Check Balance
    private void checkBalance() {
        messageArea.append("💰 Current Balance: ₹" + String.format("%.2f", balance) + "\n");
        updateBalanceLabel();
    }

    // Deposit Money
    private void depositMoney() {
        String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
        if (input != null) {
            try {
                double depositAmount = Double.parseDouble(input);
                if (depositAmount <= 0) {
                    messageArea.append("⚠️ Enter a valid amount greater than 0.\n");
                } else {
                    balance += depositAmount;
                    messageArea.append("✅ ₹" + String.format("%.2f", depositAmount) + " deposited successfully!\n");
                    updateBalanceLabel();
                }
            } catch (NumberFormatException ex) {
                messageArea.append("❌ Invalid input. Please enter a numeric value.\n");
            }
        }
    }

    // Withdraw Money
    private void withdrawMoney() {
        String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        if (input != null) {
            try {
                double withdrawAmount = Double.parseDouble(input);
                if (withdrawAmount <= 0) {
                    messageArea.append("⚠️ Enter a valid amount greater than 0.\n");
                } else if (withdrawAmount > balance) {
                    messageArea.append("❌ Insufficient balance!\n");
                } else {
                    balance -= withdrawAmount;
                    messageArea.append("✅ ₹" + String.format("%.2f", withdrawAmount) + " withdrawn successfully!\n");
                    updateBalanceLabel();
                }
            } catch (NumberFormatException ex) {
                messageArea.append("❌ Invalid input. Please enter a numeric value.\n");
            }
        }
    }

    // Exit ATM
    private void exitATM() {
        JOptionPane.showMessageDialog(this, "👋 Thank you for using the ATM. Goodbye!");
        System.exit(0);
    }

    // Update balance label
    private void updateBalanceLabel() {
        balanceLabel.setText("💰 Current Balance: ₹" + String.format("%.2f", balance));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ATMInterfaceGUI().setVisible(true);
        });
    }
}
