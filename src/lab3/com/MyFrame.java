package lab3.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyFrame extends JFrame {
    List<Person> list= new ArrayList<>();
    MyFrame(){

        this.setSize(400,300);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("LOGOWANIE");
        this.setResizable(false);

        list.add(new Person("Mateusz","1234"));
        list.add(new Person("Piotr","5678"));
        list.add(new Person("Tomek","PPP1234"));
        list.add(new Person("Radek","TTT5678"));
        list.add(new Person("Mariusz","2345"));
        list.add(new Person("Alicja","6789"));
        list.add(new Person("Kacper","RRR2345"));
        list.add(new Person("Paulina","UUU5678"));

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400,300);
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        JTextField ID = new JTextField();
        ID.setBackground(Color.white);
        ID.setBounds(150,50,100,25);

        JPasswordField password = new JPasswordField();
        password.setBackground(Color.white);
        password.setBounds(150,100,100,25);

        JLabel labelID = new JLabel();
        labelID.setText("ID");
        labelID.setForeground(Color.black);
        labelID.setBounds(120,35,50,50);

        JLabel labelPassword = new JLabel();
        labelPassword.setText("PASSWORD");
        labelPassword.setBounds(65,85,100,50);
        labelID.setForeground(Color.black);

        JButton loginButton= new JButton("LOGIN");
        loginButton.setBounds(100,175,85,50);
        loginButton.setBackground(Color.white);


        loginButton.addActionListener(e -> {

            for (Person person : list) {
                if (Objects.equals(ID.getText(), person.getLogin())) {
                    if (Objects.equals(String.valueOf(password.getPassword()), person.getPassword())) {
                        panel.setBackground(Color.green);
                    } else
                        panel.setBackground(Color.red);
                } else if (Objects.equals(String.valueOf(password.getPassword()), person.getPassword())) {
                    if (Objects.equals(ID.getText(), person.getLogin())) {
                        panel.setBackground(Color.green);
                    } else
                        panel.setBackground(Color.red);
                }

            }

        });

        JButton cancelButton= new JButton("CANCEL");
        cancelButton.setBounds(200,175,85,50);
        cancelButton.setBackground(Color.white);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID.setText("");
                password.setText("");
            }
        });
        this.setSize(400,300);
        this.setVisible(true);
        panel.add(ID);
        panel.add(password);
        panel.add(labelID);
        panel.add(labelPassword);
        panel.add(loginButton);
        panel.add(cancelButton);
        this.add(panel);

    }
}