package Reservation_system;

import java.awt.event.FocusEvent;
        import java.awt.event.FocusListener;
        import java.lang.annotation.Annotation;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import  java.util.Random;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.ActiveEvent;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class Passenger_Reservation  implements ActionListener, FocusListener {
    Container container;
    JFrame frame;
    JLabel l ,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t,t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    Choice choice;
    JDialog dialog;
    PreparedStatement ps;
    Connection com;
    ResultSet rs;
    long PNR;

    Passenger_Reservation()
    {
        frame=new JFrame("Reservation");
        frame.setFont(new Font("serif",Font.PLAIN,30));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(400,60,500,460);
        frame.setResizable(false);
        container=frame.getContentPane();
        container.setBackground(Color.darkGray);

        l=new JLabel("User name :");
        l.setFont(new Font("serif",Font.BOLD,17));
        l.setForeground(Color.WHITE);
        l.setBounds(70,25,120,25);

        t=new JTextField();
        t.setBounds(175,24,240,25);
        t.setForeground(Color.blue);
        t.setFont(new Font("sarif",Font.BOLD,17));




        l1=new JLabel("Train No :");
        l1.setFont(new Font("serif",Font.BOLD,17));
        l1.setForeground(Color.WHITE);
        l1.setBounds(70,65,120,25);

        t1=new JTextField();
        t1.setBounds(175,64,240,25);
        t1.setForeground(Color.blue);
        t1.setFont(new Font("sarif",Font.BOLD,17));
        t1.addFocusListener(this);

        l2=new JLabel("Train Name :");
        l2.setFont(new Font("serif",Font.BOLD,17));
        l2.setForeground(Color.WHITE);
        l2.setBounds(50,105,120,25);

        t2=new JTextField();
        t2.setBounds(175,104,240,25);
        t2.setForeground(Color.blue);
        t2.setFont(new Font("sarif",Font.BOLD,17));

        l3=new JLabel("Class :");
        l3.setFont(new Font("serif",Font.BOLD,17));
        l3.setForeground(Color.WHITE);
        l3.setBounds(100,152,60,25);

        choice=new Choice();
        choice.add("AC");
        choice.add("Sleeper");
        choice.add("General");
        choice.setBackground(new Color(76, 46, 46));
        choice.setFont(new Font("serif",Font.BOLD,17));
        choice.setForeground(Color.WHITE);
        choice.setBounds(175,147,240,25);


        l5=new JLabel("From  :");
        l5.setFont(new Font("serif",Font.BOLD,17));
        l5.setForeground(Color.WHITE);
        l5.setBounds(95,192,150,25);


        t4=new JTextField();
        t4.setBounds(175,192,240,25);
        t4.setForeground(Color.blue);
        t4.setFont(new Font("sarif",Font.BOLD,17));

        l6=new JLabel("Boarding station:");
        l6.setFont(new Font("serif",Font.BOLD,17));
        l6.setForeground(Color.WHITE);
        l6.setBounds(50,232,150,25);


        t5=new JTextField();
        t5.setBounds(210,235,205,25);
        t5.setForeground(Color.blue);
        t5.setFont(new Font("sarif",Font.BOLD,17));

        l4=new JLabel("Date Of Journey :");
        l4.setFont(new Font("serif",Font.BOLD,17));
        l4.setForeground(Color.WHITE);
        l4.setBounds(50,280,150,25);


        t3=new JTextField("YY-MM-DD");
        t3.setBounds(210,279,205,25);
        t3.setForeground(Color.blue);
        t3.setFont(new Font("sarif",Font.BOLD,17));


        b1=new JButton("Reservation");
        b2=new JButton("cancel");
        b3=new JButton("Home");
        b1.setFont(new Font("serif",Font.BOLD,17));
        b1.setForeground(Color.red);
        b1.setBounds(70,328,130,25);
        b1.addActionListener(this);

        b2.setFont(new Font("serif",Font.BOLD,17));
        b2.setForeground(Color.RED);
        b2.setBounds(279,328,130,25);
        b2.addActionListener(this);

        b3.setFont(new Font("serif",Font.BOLD,17));
        b3.setForeground(Color.RED);
        b3.setBounds(170,373,130,25);
        b3.addActionListener(this);

        dialog=new JDialog(frame,"Reservation");
        dialog.setLayout(null);
        dialog.setBackground(Color.darkGray);
        dialog.setBounds(500,150,280,200);

        l7=new JLabel();
        l7.setFont(new Font("serif",Font.BOLD,17));
        l7.setForeground(Color.BLACK);
        l7.setBounds(20,30,270,30);


        l8=new JLabel();
        l8.setFont(new Font("serif",Font.BOLD,17));
        l8.setForeground(Color.BLACK);
        l8.setBounds(20,70,270,30);

        dialog.add(l7);
        dialog.add(l8);



        frame.setVisible(true);
        container.add(l);
        container.add(t);
        container.add(l1);
        container.add(t1);
        container.add(l2);
        container.add(t2);
        container.add(l3);
        container.add(choice);
        container.add(l5);
        container.add(t4);
        container.add(l6);
        container.add(t5);
        container.add(l4);
        container.add(t3);
        container.add(b1);
        container.add(b2);
        container.add(b3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            Random random=new Random();
            PNR=random.nextLong(999999999);
            try {
                check();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        if(e.getSource()==b2)
        {
            System.exit(0);
        }
        if(e.getSource()==b3)
        {
            Home h=new Home();
        }


    }

    public  void check() throws SQLException {

        if(t1.getText().length()!=0&& t2.getText().length()!=0&&t3.getText().length()!=0
                &&t4.getText().length()!=0&&t5.getText().length()!=0)
        {
            l7.setText("Reservation successfully");
            l8.setText("PNR No :"+PNR);
            Insert_Into_database();

        }
        else
        {
            l7.setText("Fill all the field");
        }
        dialog.setVisible(true);
    }


    public  void  Insert_Into_database() throws SQLException {
        com = connection.Connect();
        ps=com.prepareStatement(
                "insert into Reservation(PNR_No, Train_No,class,From_station, Bording_station,Date_Of_Journey,user_id) values(?,?,?,?,?,?,?)");
        ps.setString(1, String.valueOf(PNR));
        ps.setString(2,t1.getText());

        ps.setString(3,choice.getSelectedItem());
        ps.setString(4,t4.getText());
        ps.setString(5,t5.getText());
        ps.setString(6,t3.getText());
        ps.setString(7,t.getText());
        ps.executeUpdate();
        System.out.println("susefulluy");

    }

    public  void set(String train_no)
    {
        try
        {
            com = connection.Connect();
            PreparedStatement f=com.prepareStatement("select * from Train where Train_No=?");
            f.setString(1,train_no);
            ResultSet  rs1=f.executeQuery();

            while (rs1.next()) {
                t2.setText(rs1.getString(2));

            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        System.out.println("gg");
        set(t1.getText());
    }

}
