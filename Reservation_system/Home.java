package Reservation_system;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class Home implements ActionListener {
    JFrame frame;
    Container container;
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JButton b1,b2,b3,b4;

    Home()
    {
        frame=new JFrame("HOME");
        frame.setFont(new Font("serif",Font.PLAIN,30));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(400,60,450,400);
        frame.setResizable(false);
        container=frame.getContentPane();
        container.setBackground(Color.darkGray);

        l1=new JLabel("WELCOME TO INDIAN RAILWAY  ");
        l1.setFont(new Font("serif",Font.BOLD,17));
        l1.setForeground(Color.WHITE);
        l1.setBounds(65,20,300,35);


        l2=new JLabel(" Reservation  :");
        l2.setFont(new Font("serif",Font.BOLD,17));
        l2.setForeground(Color.WHITE);
        l2.setBounds(65,70,190,35);

        b1=new JButton("click");
        b1.setFont(new Font("serif",Font.BOLD,17));
        b1.setForeground(Color.RED);
        b1.setBounds(210,70,120,30);
        b1.addActionListener(this);



        l3=new JLabel("Ticket Cancellation :");
        l3.setFont(new Font("serif",Font.BOLD,17));
        l3.setForeground(Color.WHITE);
        l3.setBounds(20,130,180,30);

        b2=new JButton("click");
        b2.setFont(new Font("serif",Font.BOLD,17));
        b2.setForeground(Color.RED);
        b2.setBounds(210,130,120,30);
        b2.addActionListener(this);



        l4=new JLabel(" PNR Enquiry :");
        l4.setFont(new Font("serif",Font.BOLD,17));
        l4.setForeground(Color.WHITE);
        l4.setBounds(56,190,180,30);

        b3=new JButton("click");
        b3.setFont(new Font("serif",Font.BOLD,17));
        b3.setForeground(Color.RED);
        b3.setBounds(210,190,120,30);
        b3.addActionListener(this);

        b4=new JButton("Exit");
        b4.setFont(new Font("serif",Font.BOLD,17));
        b4.setForeground(Color.RED);
        b4.setBounds(100,260,180,30);
        b4.addActionListener(this);


        container.add(l1);
        container.add(l2);
        container.add(l3);
        container.add(l4);
        container.add(b1);
        container.add(b2);
        container.add(b3);
        container.add(b4);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            Passenger_Reservation p=new Passenger_Reservation();
        }

        if(e.getSource()==b2)
        {
            TicketCencelleation t=new TicketCencelleation();
        }
        if(e.getSource()==b3)
        {
            PNR_DETAILS p=new PNR_DETAILS();
        }
        if(e.getSource()==b4)
        {
            System.exit(0);
        }
    }
   


}
