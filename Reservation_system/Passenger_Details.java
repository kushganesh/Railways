package Reservation_system;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.FocusEvent;
        import java.awt.event.FocusListener;
        import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passenger_Details implements ActionListener, FocusListener
{
    JFrame frame;
    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9;
    JPasswordField p1,p2;
    JTextField t1,t2,t3,t4,t5;
    Container container;
    CheckboxGroup cbg;
    Checkbox c1,c2;
    JButton b1,b2,b3;
    passanger_login login;


    JDialog dialog;



    Passenger_Details()
    {
        frame=new JFrame("Registration");
        frame.setFont(new Font("serif",Font.PLAIN,30));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(400,60,500,500);
        frame.setResizable(false);
        container=frame.getContentPane();
        container.setBackground(Color.darkGray);


        label1=new JLabel("First Name :");
        label1.setFont(new Font("serif",Font.BOLD,17));
        label1.setForeground(Color.WHITE);
        label1.setBounds(94,15,120,25);

        t1=new JTextField();
        t1.setBounds(220,16,200,25);
        t1.setForeground(Color.blue);
        t1.setFont(new Font("sarif",Font.BOLD,17));

        label2=new JLabel("Last Name :");
        label2.setFont(new Font("serif",Font.BOLD,17));
        label2.setForeground(Color.WHITE);
        label2.setBounds(100,55,120,25);

        t2=new JTextField();
        t2.setBounds(220,57,200,25);
        t2.setForeground(Color.blue);
        t2.setFont(new Font("sarif",Font.BOLD,17));

        label3=new JLabel("User Name :");
        label3.setFont(new Font("serif",Font.BOLD,17));
        label3.setForeground(Color.WHITE);
        label3.setBounds(97,95,120,25);

        t3=new JTextField();
        t3.setBounds(220,97,200,25);
        t3.setForeground(Color.blue);
        t3.setFont(new Font("sarif",Font.BOLD,17));

        label4=new JLabel("Password :");
        label4.setFont(new Font("serif",Font.BOLD,17));
        label4.setForeground(Color.WHITE);
        label4.setBounds(105,135,120,25);

        p1=new JPasswordField();
        p1.setBounds(220,137,200,25);
        p1.setForeground(Color.blue);
        p1.setFont(new Font("sarif",Font.BOLD,17));
        p1.setEchoChar('*');
         p1.addFocusListener(this);

        label5=new JLabel("Re-Enter Password :");
        label5.setFont(new Font("serif",Font.BOLD,17));
        label5.setForeground(Color.WHITE);
        label5.setBounds(34,175,180,25);

        p2=new JPasswordField();
        p2.setBounds(220,177,200,25);
        p2.setForeground(Color.blue);
        p2.setFont(new Font("sarif",Font.BOLD,17));
        p2.setEchoChar('*');
        p2.addFocusListener(this);

        label6=new JLabel("Date of Birth :");
        label6.setFont(new Font("serif",Font.BOLD,17));
        label6.setForeground(Color.WHITE);
        label6.setBounds(80,215,120,25);


        t4=new JTextField("YY-MM-DD");
        t4.setBounds(220,217,200,25);
        t4.setForeground(Color.blue);
        t4.setFont(new Font("sarif",Font.BOLD,17));

        label7=new JLabel("Mobile Number :");
        label7.setFont(new Font("serif",Font.BOLD,17));
        label7.setForeground(Color.WHITE);
        label7.setBounds(61,255,140,25);

        t5=new JTextField();
        t5.setBounds(220,257,200,25);
        t5.setForeground(Color.blue);
        t5.setFont(new Font("sarif",Font.BOLD,17));

        label8=new JLabel("Gender :");
        label8.setFont(new Font("serif",Font.BOLD,17));
        label8.setForeground(Color.WHITE);
        label8.setBounds(120,295,140,25);

        cbg=new CheckboxGroup();
        c1=new Checkbox("Male",cbg,true);
        c1.setBounds(220,295,100,30);
        c1.setForeground(Color.white);
        c1.setFont(new Font("serif",Font.BOLD,17));

        c2=new Checkbox("Female",cbg,false);
        c2.setBounds(340,295,100,30);
        c2.setFont(new Font("serif",Font.BOLD,17));
        c2.setForeground(Color.white);


        b1=new JButton("Ragistration");
        b2=new JButton("cancel");
        b3=new JButton("Log In");
        b1.setFont(new Font("serif",Font.BOLD,17));
        b1.setForeground(Color.RED);
        b1.setBounds(70,340,140,25);

        b2.setFont(new Font("serif",Font.BOLD,17));
        b2.setForeground(Color.RED);
        b2.setBounds(250,340,100,25);

        b3.setFont(new Font("serif",Font.BOLD,17));
        b3.setForeground(Color.RED);
        b3.setBounds(380,340,90,25);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

         t3.addFocusListener(this);


        dialog=new JDialog(frame,"Registration");
        dialog.setLayout(null);
        dialog.setBackground(Color.darkGray);
        dialog.setBounds(500,150,280,200);

        label9=new JLabel();
        label9.setFont(new Font("serif",Font.BOLD,17));
        label9.setForeground(Color.BLACK);
        label9.setBounds(20,30,270,30);

        dialog.add(label9);

        container.add(label1);
        container.add(t1);
        container.add(label2);
        container.add(t2);
        container.add(label3);
        container.add(t3);
        container.add(label4);
        container.add(p1);
        container.add(label5);
        container.add(p2);
        container.add(label6);
        container.add(t4);
        container.add(label7);
        container.add(t5);
        container.add(c1);
        container.add(c2);
        container.add(label8);
        container.add(b1);
        container.add(b2);
        container.add(b3);


        frame.setVisible(true);
    }

    public  void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
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
            login=new passanger_login();
        }
    }
void passwordLenth()
{
    Pattern p=Pattern.compile("((?=.*[0-9])(.*[a-z]=?)(?=.*[#$@]).{8,15})");
    String pass=String.valueOf(p1.getPassword());
    Matcher pa=p.matcher(pass);
    if(pa.matches()==false)
    {
        JOptionPane.showMessageDialog(frame,"Password range (8-15) and atleast one degiht ,charcter and spacial letter reuer","Error",JOptionPane.ERROR_MESSAGE);
    }

}
    void Username()
    {
        Pattern p=Pattern.compile("(?=.*[0-9])(.*[a-z]=?)*.{6,15}");

        Matcher pa=p.matcher(t3.getText());
        if(pa.matches()==false)
        {
            JOptionPane.showMessageDialog(frame,"user name have charector","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public  void check() throws SQLException {
        String pass=String.valueOf(p1.getPassword());
        String pas=String.valueOf(p2.getPassword());
        if(t1.getText().length()!=0&& t2.getText().length()!=0&&t3.getText().length()!=0
                &&t4.getText().length()!=0&&t5.getText().length()!=0&&pas.length()!=0&&pass.length()!=0)
        {
            label9.setText("Registration successfully");
            Insert_Into_database();
        }
        else
        {
            label9.setText("Fill all field");
        }
        dialog.setVisible(true);
    }



    @Override
    public void focusGained(FocusEvent e) {}
        @Override
    public void focusLost(FocusEvent e) {


        if (e.getSource() == t3)
            Username();
       if (e.getSource() == p1)

            passwordLenth();
       if (e.getSource() == p2)
            checkPassword();
    }


//        if(e.getSource()==p1)
//        {
////            Connection con = connection.Connect();
//            try {
//
//                 PreparedStatement p=con.prepareStatement("select password from Pasengar_Details  where password=?");
//                String pass=String.valueOf(p1.getPassword());
//                p.setString(1,pass);
//                ResultSet rs=p.executeQuery();
//                String s= String.valueOf(p1.getPassword());
//                boolean bool=false;
//                   rs.next();
//                    String sd=rs.getString(1);
//                    if (s.equals(sd))
//                    {
//                        bool=true;
//
//                    }
//
//                if(true){
//                    label9.setText("Duplicate password");
//                    dialog.setVisible(true);
//                }
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        }



    public  void  checkPassword()
    {
        String pass=String.valueOf(p1.getPassword());
        String pas=String.valueOf(p2.getPassword());
        if(pass.equals(pas))
        {
        }
        else
        {
            label9.setText("Password not match" );
            dialog.setVisible(true);
        }

    }

    public  void  Insert_Into_database() {
        try {
            Connection com = connection.Connect();
            PreparedStatement ps = com.prepareStatement(
                    "insert into Pasengar_Details( user_id, first_name,last_name, password,Date_Of_Birth ,Mobile_No,Gender)values(?,?,?,?,?,?,?)");
            ps.setString(1, t3.getText());
            ps.setString(2, t1.getText());
            ps.setString(3, t2.getText());
            String pa = String.valueOf(p1.getPassword());
            ps.setString(4, pa);
            ps.setString(5, t4.getText());
            ps.setString(6, t5.getText());
            ps.setString(7, cbg.getSelectedCheckbox().getLabel());
            ps.executeUpdate();
            System.out.println("susefulluy");
        }
        catch (Exception e)
        {
            label9.setText("Duplicate password");
            dialog.setVisible(true);
        }

    }






}
