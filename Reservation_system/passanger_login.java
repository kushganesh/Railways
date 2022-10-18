package Reservation_system;


import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
import java.util.Locale;
import java.util.concurrent.Callable;

public class passanger_login implements ActionListener {

    JFrame frame;
    JLabel label1,label2,label,l3,l4;
    JTextField field1;
    JPasswordField passwordField;
    Container container;
    JButton button1,button2,button3;
    JDialog dialog;
    Passenger_Details passenger_details;
    Home home;
    Connection com;
    PreparedStatement pr;

    passanger_login()
    {
        frame =new JFrame("Passenger Login");
        frame.setFont(new Font("Aria",Font.PLAIN,30));
        frame.setLayout(null);

        frame.setIconImage(new ImageIcon().getImage());
        frame.setBounds(400,110,350,300);
        frame.setResizable(false);
        container=frame.getContentPane();
        container.setBackground(Color.darkGray);

        label=new JLabel(" PASSENGER LOGIN DESK ");
        label.setFont(new Font("aria",Font.BOLD,16));
        label.setBounds(50,6,250,20);
        label.setForeground(Color.WHITE);


        label1=new JLabel("User Name");
        label1.setFont(new Font("Aria",Font.BOLD,18));
        label1.setBounds(10,60,120,20);
        label1.setForeground((Color.WHITE));

        label2=new JLabel("Password");
        label2.setFont(new Font("Aria",Font.BOLD,18));
        label2.setBounds(10,110,120,20);
        label2.setForeground((Color.WHITE));

        field1=new JTextField();
        field1.setForeground(new Color(53, 53, 116));
        field1.setBounds(140,60,160,30);
        field1.setFont(new Font("Arial",Font.BOLD,18));

        passwordField=new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setForeground(new Color(116, 53, 75));
        passwordField.setBounds(140,110,160,30);
        passwordField.setFont(new Font("Arial",Font.BOLD,28));

        button1=new JButton("Login");
        button1.setForeground(Color.red);
        button1.setBounds(40,165,120,35);
        button1.addActionListener(this);

        button2=new JButton("Sing In");
        button2.setForeground(Color.red);
        button2.setBounds(180,165,120,35);
        button2.addActionListener(this);

        button3=new JButton("cansal");
        button3.setForeground(Color.red);
        button3.setBounds(110,210,120,35);
        button3.addActionListener(this);


        dialog=new JDialog(frame,"password");
        dialog.setLayout(null);
        dialog.setBackground(Color.darkGray);
        dialog.setBounds(450,180,250,150);

        l3=new JLabel(" Please Enter Right" );
        l3.setFont(new Font("serif",Font.BOLD,17));
        l3.setForeground(Color.BLACK);
        l3.setBounds(20,10,270,30);

        l4=new JLabel(" Username or Password ");
        l4.setFont(new Font("serif",Font.BOLD,17));
        l4.setForeground(Color.BLACK);
        l4.setBounds(20,30,270,30);

        dialog.add(l3);
        dialog.add(l4);



        container.add(label1);
        container.add(label2);
        container.add(field1);
        container.add(passwordField);
        container.add(button1);
        container.add(button2);
        container.add(label);
        container.add(button3);




        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1)
        {
            check();

        }
        if(e.getSource()==button2)
        {
            passenger_details=new Passenger_Details();
        }
        if(e.getSource()==button3)
        {
            System.exit(0);
        }
    }
    public void check() {
        try {
            String username = field1.getText();
            String password = String.valueOf(passwordField.getPassword());
            com = connection.Connect();
            String s1="";String s2=" ";

            pr = com.prepareStatement("select user_id,password from pasengar_details where user_id=?");
            pr.setString(1, field1.getText());
            String  p = String.valueOf(passwordField.getPassword());

            ResultSet rs = pr.executeQuery();
            rs.next();
            s1=rs.getString(1);
            s2=rs.getString(2);
            System.out.println(s1+" "+s2);

            if(s1.equals(field1.getText())&&s2.equals(p)) {
                home=new Home();

            }


        }
        catch (SQLException ex) {
            dialog.setVisible(true);
        }
    }

    public static void main(String[] args) {
        passanger_login p=new passanger_login();
    }


}
