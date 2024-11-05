package airIndia;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener  {
    JButton  submit,reset,close;
    JTextField tusername;
    JPasswordField tpassword;

    public Login() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel luserName = new JLabel("Username"); // create label uername
        luserName.setBounds(20, 20,  100, 20);
        add(luserName); // add on frame

        tusername = new JTextField();
        tusername.setBounds(130,20,200,20);
        add(tusername);

        JLabel lpassword = new JLabel("Password "); // create label uername
        lpassword.setBounds(20, 60,  100, 20);
        add(lpassword); // add on frame

        tpassword = new JPasswordField();
        tpassword.setBounds(130,60,200,20);
        add(tpassword);

        reset = new JButton("Reset");
        reset.setBounds(50,120,120,20) ;
        reset.addActionListener(this);
        add(reset);

        submit = new JButton("Submit");
        submit.setBounds(190,120,120,20) ;
        submit.addActionListener(this);
        add(submit);

        close = new JButton("Close");
        close.setBounds(120,160,120,20) ;
        close.addActionListener(this);
        add(close);

        setSize(500,350);
        setLocation(400,250);
        setVisible(true);

    }


    public static void main(String[] args) {

        new Login(); //  AnonmusObject

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == submit) {
            String username = tusername.getText(); // for get the value
            String password = tpassword.getText();

            try {
                JDBCConnection jc = new JDBCConnection();
                String query = " SELECT *  FROM login  WHERE username = '"+username+"' AND  password = '"+password+"'";
                ResultSet  rs = jc.s.executeQuery(query);

                if (rs.next()) {

                    new Home();

                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        } else if(e.getSource() == reset) {
            tpassword.setText("");
            tusername.setText("");


        } else if(e.getSource() == close) {
            setVisible(false);
        }

    }

}

