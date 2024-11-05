package airIndia;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

//import net.proteanit.sql.DbUtils;


public class FlightInfo extends JFrame {

    public FlightInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JTable table = new JTable();
        try {
            JDBCConnection jc = new JDBCConnection(); // Ensure JDBCConnection is defined
            ResultSet rs = jc.s.executeQuery("SELECT * FROM flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading flight data."); // User feedback
        }
        JScrollPane  jsp = new JScrollPane(table);
        jsp.setBounds(0,0,800,500);
        add(jsp);

        setSize(800,500);

        setLocation(400,200);
        setVisible(true);

    }

    public static void main(String[] args) {

        new FlightInfo();
    }

}



