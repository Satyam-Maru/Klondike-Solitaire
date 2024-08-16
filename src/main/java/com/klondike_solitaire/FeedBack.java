package com.klondike_solitaire;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FeedBack extends JFrame{
    private JTextArea feedbackArea;

    public FeedBack() {

        this.setTitle("Game FeedBack");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);

        feedbackArea = new JTextArea(10, 30);
        feedbackArea.setLineWrap(true);
        feedbackArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        // Layout the components in the frame
        this.setLayout(new BorderLayout());
        JLabel header=new JLabel("Please Provide Your FeedBack");
        header.setFont(new Font("Consalas", Font.BOLD, 25));
        header.setSize(new Dimension(200,300));
        this.add(header,BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(submitButton, BorderLayout.SOUTH);

    }

    private void handleSubmit() {
        String feedback = feedbackArea.getText();
        if (feedback.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Feedback cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Feedback received: " + feedback);

            feedbackArea.setText("");

            JOptionPane.showMessageDialog(this, "Thank you for your feedback!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new FeedBack();
    }
}
