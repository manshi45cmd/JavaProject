package airIndia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

    public class BoardingPass  extends JFrame implements ActionListener {
        JTextField tpnr;
        JLabel tfname, tfnationality, tflblSource, lblfcode, labelfname, labelfcode ,labeldate  ,lbldest;
        JButton   fetchButton;


        public BoardingPass() {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel heading = new JLabel("AIR INDIA");
            heading.setBounds(380, 20, 450, 35);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
            add(heading);

            JLabel subheading = new JLabel("Boarding Pass");
            subheading.setBounds(360, 50, 310, 50);
            subheading.setFont(new Font("Tahoma", Font.PLAIN, 32));
            subheading.setForeground(Color.BLUE);
            add(subheading);

            JLabel  pnrDetails = new JLabel("PNR DETAILS");
            pnrDetails.setBounds(60, 100, 150, 25);
            pnrDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(pnrDetails);

             tpnr = new JTextField();
            tpnr.setBounds(220, 100, 150, 25);
            add(tpnr);

            fetchButton = new JButton("Enter");
            fetchButton.setBackground(Color.BLACK);
            fetchButton.setForeground(Color.WHITE);
            fetchButton.setBounds(380, 100, 120, 25);
            fetchButton.addActionListener(this);
            add(fetchButton);

            JLabel lblname = new JLabel("Name");
            lblname.setBounds(60, 140, 150, 25);
            lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblname);

            tfname = new JLabel();
            tfname.setBounds(220, 140, 150, 25);
            add(tfname);

            JLabel lblnationality = new JLabel("Nationality");
            lblnationality.setBounds(60, 180, 150, 25);
            lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblnationality);

            tfnationality = new JLabel();
            tfnationality.setBounds(220, 180, 150, 25);
            add(tfnationality);

            JLabel  lblSource = new JLabel("Source");
            lblSource.setBounds(60, 220, 150, 25);
            lblSource.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblSource);

             tflblSource = new JLabel();
            tflblSource.setBounds( 220, 220, 150, 25);
            add(tflblSource);

            JLabel lbldest = new JLabel("DESTINATION");
            lbldest.setBounds(380, 220, 150, 25);
            lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lbldest);

            lbldest = new JLabel( );
            lbldest.setBounds( 540, 220, 150, 25);
            add(lbldest);

            JLabel lblfname = new JLabel("Flight Name");
            lblfname.setBounds(60, 260, 150, 25);
            lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblfname);

            labelfname = new JLabel();
            labelfname.setBounds(220, 260, 150, 25);
            add(labelfname);

            JLabel lblfcode = new JLabel("Flight Code");
            lblfcode.setBounds(380, 260, 150, 25);
            lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblfcode);

            labelfcode = new JLabel();
            labelfcode.setBounds(540, 260, 150, 25);
            add(labelfcode);

            JLabel lbldate = new JLabel("Date");
            lbldate.setBounds(60, 300, 150, 25);
            lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lbldate);

            labeldate= new JLabel();
            labeldate.setBounds(220 , 300,150,25);
            add(labeldate);
//
            ImageIcon i1 = new ImageIcon("src/icons/airindia.png");
            Image i2 = i1.getImage().getScaledInstance(300,320,Image.SCALE_DEFAULT);
            ImageIcon image = new ImageIcon(i2);
            JLabel limage = new JLabel(image);
            limage.setBounds(600,0,300,300);
            add(limage);


            setSize(1000,450);
            setLocation(300,150);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String pnr = tpnr.getText();
            try {
                JDBCConnection conn = new JDBCConnection();

                String query = "select * from  reservation where PNR = '" + pnr + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tflblSource.setText(rs.getString("src"));
                    lbldest.setText(rs.getString("des"));
                    lblfcode.setText(rs.getString("flightcode"));
                    labeldate.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct  PNR");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

        public static void main(String[] args) {
            new BoardingPass();
        }
    }


