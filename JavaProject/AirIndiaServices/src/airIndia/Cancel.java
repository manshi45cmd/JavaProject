package airIndia;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.*;


public class Cancel  extends JFrame implements  ActionListener{
    JTextField tfpnr;
    JLabel tfname, calcellationno, tfflightcode, lbldate   ;
    JButton   fetchButton, cancel , flight;

    public Cancel() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        Random random = new Random();

        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);


        ImageIcon i1 = new ImageIcon("src/icons/cancel.jpg");
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel limage = new JLabel(image);
        limage.setBounds(470,120,250,250);
        add(limage);

        JLabel  lblpnr = new JLabel("PNR Number");
        lblpnr.setBounds(60, 80, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);

         tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);

        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);

        JLabel  lblcancel = new JLabel("Cancellation No");
        lblcancel.setBounds(60, 180, 150, 25);
        lblcancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcancel);

        calcellationno = new JLabel(" "+ random.nextInt(100000));
        calcellationno.setBounds(220, 180, 150, 25);
        add(calcellationno);

        JLabel  lblflightcode = new JLabel("Flight Code");
        lblflightcode.setBounds(60, 230, 150, 25);
        lblflightcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblflightcode);
        tfflightcode= new JLabel();
        tfflightcode.setBounds(220, 230, 150, 25);
        add(tfflightcode);

        JLabel ldate = new JLabel("Date");
        ldate.setBounds(60, 280, 150, 25);
        ldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(ldate);

        lbldate = new JLabel();
        lbldate.setBounds(220, 280, 150, 25);
        add(lbldate);


        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,330,120,25);
        cancel.addActionListener(this);
        add(cancel);


        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == fetchButton) {
            String pnr = tfpnr.getText();

            try {
                JDBCConnection conn = new JDBCConnection();

                String query = "select * from reservation where  PNR = '" + pnr + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfflightcode.setText(rs.getString("flightcode"));
                    lbldate.setText(rs.getString("ddate"));

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct  PNR");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = calcellationno.getText();
            String fcode = tfflightcode.getText();
            String date1 = lbldate.getText();

            try {
                JDBCConnection conn = new JDBCConnection();

                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date1+"')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR = '" + pnr + "'");

                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Cancel();
    }
    }






