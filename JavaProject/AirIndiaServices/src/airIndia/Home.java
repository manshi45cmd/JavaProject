package airIndia;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Home  extends JFrame implements ActionListener{

    public Home() {
        setLayout(null);

        ImageIcon i1 = new ImageIcon("src/icons/AirIND.jpeg");

        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1500,700);
        add(image);

        JLabel heading = new JLabel(" AIR INDIA WELCOMES YOU..!");
        heading.setBounds(500,40,800,40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma",Font.PLAIN,40));
        image.add(heading);

        JMenuBar menubar =  new JMenuBar();
        setJMenuBar(menubar);

        JMenu details = new JMenu("Details");
        menubar.add(details);

        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);

        JMenuItem  customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);

        JMenuItem  bookFlight = new JMenuItem("Book Flight ");
        bookFlight.addActionListener(this);
        details.add(bookFlight);

        JMenuItem jouneryDetails = new JMenuItem("Jounery Details");
        jouneryDetails.addActionListener(this);
        details.add(jouneryDetails);

        JMenuItem  ticketCancellation = new JMenuItem("Cancel Ticket ");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation );

        JMenu  ticket = new JMenu("Ticket");
        menubar.add( ticket);

        JMenuItem  boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(400,250);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String text = e.getActionCommand();
        if(text.equals("Add Customer Details"))
        {
            new AddCustomer();
        }else if(text.equals("Flight Details")) {
            new FlightInfo();
        }else if (text.equals("Book Flight")){
            new BookFlight();
        }else if (text.equals("Journey Details")){
            new JourneyDetails();
        }else if (text.equals("Cancel Ticket")){
            new Cancel();
        }

    }
    public static void main(String[] args) {

        new Home();
    }

}


