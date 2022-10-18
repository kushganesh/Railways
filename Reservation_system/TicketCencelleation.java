package Reservation_system;


import javax.swing.*;
        import javax.swing.plaf.IconUIResource;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.FocusEvent;
        import java.awt.event.FocusListener;
        import java.sql.*;

public class TicketCencelleation implements ActionListener {
    Container container;
    JFrame frame;
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l51, l15, l16, l91, l161, l71;
    JButton b1, b2, b3, b4;
    JTextField t1;
    JDialog dialog;
    Home home;
    Connection com;

    String train_no = "";
    String user_id = "";


    TicketCencelleation() {
        frame = new JFrame("Cancelletion");
        frame.setFont(new Font("serif", Font.PLAIN, 30));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(400, 60, 500, 550);
        frame.setResizable(false);
        container = frame.getContentPane();
        container.setBackground(Color.darkGray);

        l = new JLabel(" PNR No :");
        l.setFont(new Font("serif", Font.BOLD, 17));
        l.setForeground(Color.WHITE);
        l.setBounds(70, 25, 100, 25);

        t1 = new JTextField();
        t1.setBounds(180, 23, 200, 30);
        t1.setForeground(Color.blue);
        t1.setFont(new Font("sarif", Font.BOLD, 17));

        b4=new JButton("click");
        b4.setFont(new Font("serif", Font.BOLD, 17));
        b4.setForeground(Color.RED);
        b4.setBounds(390, 23, 80, 25);
        b4.addActionListener(this);


        l1 = new JLabel("Train No :");
        l1.setFont(new Font("serif", Font.BOLD, 17));
        l1.setForeground(Color.WHITE);
        l1.setBounds(70, 65, 120, 25);

        l2 = new JLabel();
        l2.setBounds(175, 64, 240, 25);
        l2.setForeground(Color.WHITE);
        l2.setBackground(Color.WHITE);
        l2.setFont(new Font("sarif", Font.BOLD, 17));


        l3 = new JLabel("Train Name :");
        l3.setFont(new Font("serif", Font.BOLD, 17));
        l3.setForeground(Color.WHITE);
        l3.setBounds(70, 105, 120, 25);

        l4 = new JLabel();
        l4.setBounds(175, 105, 200, 25);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("sarif", Font.BOLD, 17));

        l5 = new JLabel("Class :");
        l5.setFont(new Font("serif", Font.BOLD, 17));
        l5.setForeground(Color.WHITE);
        l5.setBounds(70, 152, 80, 25);

        l51 = new JLabel();
        l51.setFont(new Font("serif", Font.BOLD, 17));
        l51.setForeground(Color.WHITE);
        l51.setBounds(175, 152, 80, 25);


        l6 = new JLabel("From  :");
        l6.setFont(new Font("serif", Font.BOLD, 17));
        l6.setForeground(Color.WHITE);
        l6.setBounds(70, 192, 150, 25);


        l7 = new JLabel();
        l7.setBounds(175, 192, 240, 25);
        l7.setForeground(Color.WHITE);
        l7.setFont(new Font("sarif", Font.BOLD, 17));

        l8 = new JLabel("Boarding station:");
        l8.setFont(new Font("serif", Font.BOLD, 17));
        l8.setForeground(Color.WHITE);
        l8.setBounds(70, 232, 150, 25);


        l9 = new JLabel();
        l9.setBounds(210, 232, 202, 25);
        l9.setForeground(Color.WHITE);
        l9.setFont(new Font("sarif", Font.BOLD, 17));

        l91 = new JLabel("Date Of Journey :");
        l91.setFont(new Font("serif", Font.BOLD, 17));
        l91.setForeground(Color.WHITE);
        l91.setBounds(70, 272, 150, 25);


        l10 = new JLabel();
        l10.setBounds(210, 272, 200, 25);
        l10.setForeground(Color.WHITE);
        l10.setFont(new Font("sarif", Font.BOLD, 17));

        l11 = new JLabel("Passenger Name :");
        l11.setBounds(70, 312, 150, 25);
        l11.setForeground(Color.WHITE);
        l11.setFont(new Font("sarif", Font.BOLD, 17));

        l12 = new JLabel();
        l12.setBounds(230, 312, 200, 25);
        l12.setForeground(Color.WHITE);
        l12.setFont(new Font("sarif", Font.BOLD, 17));

        l13 = new JLabel("Date Of Birth :");
        l13.setFont(new Font("serif", Font.BOLD, 17));
        l13.setForeground(Color.WHITE);
        l13.setBounds(70, 352, 200, 25);


        l14 = new JLabel();
        l14.setBounds(210, 352, 150, 25);
        l14.setForeground(Color.WHITE);
        l14.setFont(new Font("sarif", Font.BOLD, 17));

//        l15=new JLabel("Gender :");
//        l15.setBounds(70,392,150,25);
//        l15.setForeground(Color.WHITE);
//        l15.setFont(new Font("sarif",Font.BOLD,17));
//
//        l161=new JLabel("er");
//        l161.setBounds(210,392,100,25);
//        l161.setForeground(Color.WHITE);
//        l161.setFont(new Font("sarif",Font.BOLD,17));


        l16 = new JLabel("YOU WANT TO CANCAL TICKET");
        l16.setBounds(30, 392, 300, 25);
        l16.setForeground(Color.WHITE);
        l16.setFont(new Font("sarif", Font.BOLD, 17));


        b1 = new JButton("YES");
        b2 = new JButton("NO");
        b3 = new JButton("Home");

        b1.setFont(new Font("serif", Font.BOLD, 17));
        b1.setForeground(Color.RED);
        b1.setBounds(320, 392, 70, 25);
        b1.addActionListener(this);

        b2.setFont(new Font("serif", Font.BOLD, 17));
        b2.setForeground(Color.BLUE);
        b2.setBounds(400, 392, 70, 25);
        b2.addActionListener(this);

        b3.setFont(new Font("serif", Font.BOLD, 17));
        b3.setForeground(Color.GRAY);
        b3.setBounds(320, 430, 80, 25);
        b3.addActionListener(this);


        dialog = new JDialog(frame, "Cancellation");
        dialog.setLayout(null);
        dialog.setBackground(Color.darkGray);
        dialog.setBounds(500, 150, 280, 200);

        l71 = new JLabel("Ticket Successfully cansal");
        l71.setFont(new Font("serif", Font.BOLD, 17));
        l71.setForeground(Color.BLACK);
        l71.setBounds(20, 30, 270, 30);

        dialog.add(l71);


        frame.setVisible(true);
        container.add(l);
        container.add(t1);
        container.add(l1);
        container.add(l2);
        container.add(l3);
        container.add(l4);
        container.add(l5);
        container.add(l51);
        container.add(l6);
        container.add(l7);
        container.add(l8);
        container.add(l9);
        container.add(l91);
        container.add(l10);
        container.add(l11);
        container.add(l12);
        container.add(l13);
        container.add(l14);
        container.add(b4);
        // container.add(l15);
        container.add(l16);
        //    container.add(l161);

        container.add(b1);
        container.add(b2);
        container.add(b3);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            dialog.setVisible(true);
            delete();
        }
        if (e.getSource() == b2) {
            System.exit(0);
        }
        if (e.getSource() == b3) {
            home = new Home();
        }
        if (e.getSource() == b4) {
            Insert_Database();
        }
    }

    public void Insert_Database() {
        try {

            com = connection.Connect();
            PreparedStatement pr = com.prepareStatement("select * from Reservation where PNR_No=?");
            pr.setString(1, t1.getText());
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                train_no = rs.getString(2);
                l2.setText(rs.getString(2));
                l51.setText(rs.getString(3));
                l7.setText(rs.getString(4));
                l9.setText(rs.getString(5));
                l10.setText(rs.getString(6));
                user_id = rs.getString(7);
                System.out.println(user_id);

            }


            PreparedStatement f=com.prepareStatement("select * from Train where Train_No=?");
            f.setString(1,train_no);
            ResultSet  rs1=f.executeQuery();

            while (rs1.next()) {
                l4.setText(rs1.getString(2));

            }


            PreparedStatement fa=com.prepareStatement(" select user_id,first_name,last_name,Date_Of_Birth from pasengar_details where user_id=?");
            fa.setString(1,user_id);
            ResultSet  rs2=fa.executeQuery();

            while (rs2.next()) {

                l12.setText(  rs2.getString(2)+" "+rs2.getString(3));
                l14.setText(rs2.getString(4));
                System.out.println("paasss");

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public  void delete()
    {
        try {


            com = connection.Connect();
            PreparedStatement pr = com.prepareStatement("Delete from Reservation where PNR_No=?");
            pr.setString(1, t1.getText());
            pr.executeUpdate();

            PreparedStatement f=com.prepareStatement("Delete from Train where Train_No=?");
            f.setString(1,train_no);
            f.executeUpdate();

            PreparedStatement fa=com.prepareStatement(" delete from pasengar_details where user_id=?");
            fa.setString(1,user_id);
            fa.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }

}
