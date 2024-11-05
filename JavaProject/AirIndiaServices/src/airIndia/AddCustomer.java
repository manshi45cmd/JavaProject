package airIndia;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener  {

    JRadioButton rbmale,rbfemale;
    JTextField tname ,tnationality,taadhar,taddress,temail, tphoneno;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD CUSTOMER DETAILS ");
        heading.setBounds( 250,20,500,30);
        heading.setFont(new Font ("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lname = new JLabel("Name");
        lname.setBounds( 60,80,150,25);
        lname.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(lname);

        tname = new JTextField();
        tname.setBounds(220, 80,150,25);
        add(tname);

        JLabel lnationality = new JLabel("Nationality");
        lnationality.setBounds( 60,130,150,25);
        lnationality.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(lnationality);

        tnationality = new JTextField();
        tnationality.setBounds(220, 130,150,25);
        add(tnationality);

        JLabel laadhar = new JLabel("Aadhar Number");
        laadhar.setBounds( 60,180,150,25);
        laadhar.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(laadhar);

        taadhar = new JTextField();
        taadhar.setBounds(220, 180,150,25);
        add(taadhar);

        JLabel  laddress = new JLabel("Address");
        laddress.setBounds( 60,230,150,25);
        laddress.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(laddress);

        taddress = new JTextField();
        taddress.setBounds(220, 230,150,25);
        add(taddress);

        JLabel   gender = new JLabel("Gender");
        gender.setBounds( 60,280,150,25);
        gender.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(gender);

        ButtonGroup gendergroup = new ButtonGroup();

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        gendergroup.add(rbfemale);
        gendergroup.add(rbmale);

        JLabel   phoneno = new JLabel("Phone No.");
        phoneno.setBounds( 60,330,150,25);
        phoneno.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(phoneno);

        tphoneno = new JTextField();
        tphoneno.setBounds(220, 330,150,25);
        add(tphoneno);

        JLabel   email = new JLabel("Email ID");
        email.setBounds( 60,380,150,25);
        email.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(220, 380,150,25);
        add(temail);

        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 420,150,30);
        save.addActionListener(this);
        add(save);

        ImageIcon i1 = new ImageIcon("src/icons/emp.png");
        JLabel image = new JLabel(i1);
        image.setBounds(450,80,280,400);
        add(image);

        setSize(900,600);
        setLocation(300,150);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String name = tname.getText();
        String nationality = tnationality.getText();
        String phoneno = tphoneno.getText();
        String address = taddress.getText();
        String aadhar = taadhar.getText();
        String gender = null;
        if(rbmale.isSelected()) {
            gender = "Male";
        }else {
            gender = "Female";
        }
        try {
            JDBCConnection jc = new JDBCConnection();
            String query = "insert into passenger values( '"+name+"','"+nationality+"','"+phoneno+"','"+address+"','"+aadhar+"','"+gender+"' )";
            jc.s.executeUpdate(query);

            JOptionPane.showMessageDialog( null, "Customer Details Added Successfully");
            setVisible(false);

        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}
