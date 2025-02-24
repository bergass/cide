package com.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAccountWindow extends JFrame {
    private JTextField accountNameField, fullNameField;
    private JPasswordField passwordField, repeatPasswordField;
    private JButton addButton, deleteButton, okButton, applyButton, cancelButton;
    private JList<String> userList;
    private DefaultListModel<String> listModel;

    public UserAccountWindow() {
        setTitle("User Accounts");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for new user input
        JPanel newUserPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        newUserPanel.setBorder(BorderFactory.createTitledBorder("New User"));
        newUserPanel.add(new JLabel("Account name:"));
        accountNameField = new JTextField();
        newUserPanel.add(accountNameField);

        newUserPanel.add(new JLabel("Full name:"));
        fullNameField = new JTextField();
        newUserPanel.add(fullNameField);

        newUserPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        newUserPanel.add(passwordField);

        newUserPanel.add(new JLabel("Repeat Password:"));
        repeatPasswordField = new JPasswordField();
        newUserPanel.add(repeatPasswordField);

        add(newUserPanel, BorderLayout.NORTH);

        // Panel for existing users
        JPanel userListPanel = new JPanel(new BorderLayout());
        userListPanel.setBorder(BorderFactory.createTitledBorder("User accounts"));
        listModel = new DefaultListModel<>();
        listModel.addElement("Karl    Karl Marx");
        listModel.addElement("Vlad    Vladimir Lenin");

        userList = new JList<>(listModel);
        userListPanel.add(new JScrollPane(userList), BorderLayout.CENTER);

        add(userListPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        okButton = new JButton("OK");
        applyButton = new JButton("Apply");
        cancelButton = new JButton("Cancel");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(okButton);
        buttonPanel.add(applyButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountName = accountNameField.getText();
                String fullName = fullNameField.getText();
                if (!accountName.isEmpty() && !fullName.isEmpty()) {
                    listModel.addElement(accountName + "    " + fullName);
                    accountNameField.setText("");
                    fullNameField.setText("");
                    passwordField.setText("");
                    repeatPasswordField.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = userList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserAccountWindow().setVisible(true);
            }
        });
    }
}