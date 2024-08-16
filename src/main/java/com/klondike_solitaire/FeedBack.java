package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedBack extends JFrame {
    private JTextArea feedbackArea;
    private JPanel panelMain;
    private JLabel feedback;
    private JTextArea textArea;

    public FeedBack() {

        // this.setTitle("Game FeedBack");
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(500, 450);
        // this.setVisible(true);
        // panelMain=new JPanel();
        // panelMain.setLayout(null);

        // feedbackArea = new JTextArea(10, 30);
        // feedbackArea.setLineWrap(true);
        // feedbackArea.setWrapStyleWord(true);

        // JButton submitButton = new JButton("Submit");
        // submitButton.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // handleSubmit();
        // }
        // });

        // JLabel header=new JLabel("Please Provide Your FeedBack");
        // header.setFont(new Font("Consalas", Font.BOLD, 25));
        // header.setSize(new Dimension(200,300));

        // panelMain.add(header,BorderLayout.NORTH);
        // panelMain.add(scrollPane, BorderLayout.CENTER);
        // panelMain.add(submitButton, BorderLayout.SOUTH);
        // this.add(panelMain);
    }

    private void handleSubmit() {
        String feedback = feedbackArea.getText();
        if (feedback.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Feedback cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Feedback received: " + feedback);

            feedbackArea.setText("");

            JOptionPane.showMessageDialog(this, "Thank you for your feedback!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new FeedBack();
    }

    void initFrame() {
        this.setTitle("Game FeedBack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1020, 650);
        this.setVisible(true);
    }

    void initPanel() {

    }
}
