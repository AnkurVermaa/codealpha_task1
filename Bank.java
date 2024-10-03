import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bank {
    private JFrame frame;
    private JTextField balanceField;
    private JTextField depositField;
    private JTextField withdrawField;

    public Bank() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Banking Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create balance panel
        JPanel balancePanel = new JPanel();
        balancePanel.add(new JLabel("Balance:"));
        balanceField = new JTextField(10);
        balanceField.setEditable(false);
        balancePanel.add(balanceField);

        // Create deposit panel
        JPanel depositPanel = new JPanel();
        depositPanel.add(new JLabel("Deposit:"));
        depositField = new JTextField(10);
        depositPanel.add(depositField);
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositListener());
        depositPanel.add(depositButton);

        // Create withdraw panel
        JPanel withdrawPanel = new JPanel();
        withdrawPanel.add(new JLabel("Withdraw:"));
        withdrawField = new JTextField(10);
        withdrawPanel.add(withdrawField);
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawListener());
        withdrawPanel.add(withdrawButton);

        // Create exit panel
        JPanel exitPanel = new JPanel();
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());
        exitPanel.add(exitButton);

        // Add panels to frame
        frame.add(balancePanel, BorderLayout.NORTH);
        frame.add(depositPanel, BorderLayout.CENTER);
        frame.add(withdrawPanel, BorderLayout.SOUTH);
        frame.add(exitPanel, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }

    private class DepositListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double amount = Double.parseDouble(depositField.getText());
            double balance = Double.parseDouble(balanceField.getText());
            balance += amount;
            balanceField.setText(String.valueOf(balance));
            depositField.setText("");
        }
    }

    private class WithdrawListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double amount = Double.parseDouble(withdrawField.getText());
            double balance = Double.parseDouble(balanceField.getText());
            if (amount > balance) {
                JOptionPane.showMessageDialog(frame, "Insufficient funds");
            } else {
                balance -= amount;
                balanceField.setText(String.valueOf(balance));
                withdrawField.setText("");
            }
        }
    }

    private class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Bank();
    }
}