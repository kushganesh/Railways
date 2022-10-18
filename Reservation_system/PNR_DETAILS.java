package Reservation_system;


import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;

public class PNR_DETAILS implements ActionListener {
    JFrame frame;
    Container container;
    JTextArea t;
    JTextField t1;
    JLabel l1,l;
    JButton b1,b2,b3;
    Home home;
    Connection com;




    PNR_DETAILS()
    {
        frame=new JFrame("PNR_DETAILS");
        frame.setFont(new Font("serif",Font.PLAIN,30));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(400,60,420,550);
        frame.setResizable(false);
        container=frame.getContentPane();
        container.setBackground(Color.darkGray);


        l=new JLabel(" PNR No :");
        l.setFont(new Font("serif",Font.BOLD,17));
        l.setForeground(Color.WHITE);
        l.setBounds(60,20,100,25);

        t1=new JTextField();
        t1.setBounds(165,18,200,30);
        t1.setForeground(Color.blue);
        t1.setFont(new Font("sarif",Font.BOLD,17));

        l1=new JLabel("PNR Details :");
        l1.setFont(new Font("serif",Font.BOLD,17));
        l1.setForeground(Color.WHITE);
        l1.setBounds(60,100,120,25);

        t=new JTextArea();
        t.setFont(new Font("serif",Font.BOLD,17));
        t.setBounds(60,130,250,250);

        b1=new JButton("HOME");
        b2=new JButton("OK");
        b3=new JButton("click");

        b1.setFont(new Font("serif",Font.BOLD,17));
        b1.setForeground(Color.RED);
        b1.setBounds(60,400,100,25);
        b1.addActionListener(this);

        b2.setFont(new Font("serif",Font.BOLD,17));
        b2.setForeground(Color.BLUE);
        b2.setBounds(200,400,100,25);
        b2.addActionListener(this);

        b3.setFont(new Font("serif",Font.BOLD,17));
        b3.setForeground(Color.BLUE);
        b3.setBounds(170,70,100,25);
        b3.addActionListener(this);



        container.add(t1);
        container.add(l);
        container.add(l1);
        container.add(t);
        container.add(b1);
        container.add(b2);
        container.add(b3);
        frame.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            home=new Home();
        }
        if(e.getSource()==b2)
        {
            System.exit(0);
        }
        if(e.getSource()==b3)
        {
            info();
        }

    }
    public  void info() {
        try
        {
            com = connection.Connect();
            PreparedStatement pr = com.prepareStatement("select  PNR_No, Reservation.Train_No,Train.Train_Name,class,From_station, Bording_station,Date_Of_Journey,first_name,last_name , Date_Of_Birth,Gender from Pasengar_Details inner join Reservation on Pasengar_Details.user_id = Reservation.user_id\n" +
                    " inner join Train on Train.Train_No= Reservation.Train_No where PNR_No=?");
            pr.setString(1, t1.getText());
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                t.append("Train No.: "+rs.getString(2)+"\n");
                t.append("Train Name: "+rs.getString(3)+"\n");
                t.append("Class: "+rs.getString(4)+"\n");
                t.append("From: "+rs.getString(5)+"\n");
                t.append("Boarding at: "+rs.getString(6)+"\n");
                t.append("Date of Journey: "+rs.getString(7)+"\n");
                t.append("Passenger Name: "+rs.getString(8)+" "+rs.getString(9)+"\n");
                t.append(" Date Of Birth :"+rs.getString(10)+"\n");
                t.append(" Gander :"+rs.getString(11)+"\n");
                System.out.println("jk");

            }
        }
        catch(Exception x)
        {
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        PNR_DETAILS p=new PNR_DETAILS();
    }


}
