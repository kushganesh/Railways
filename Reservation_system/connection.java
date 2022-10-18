package Reservation_system;

import java.sql.Connection;
        import java.sql.DriverManager;

public class  connection {
    static Connection com;

    public  static  Connection Connect()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            com=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return  com;

    }
}
