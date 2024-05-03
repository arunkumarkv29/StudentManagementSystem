package SMSWS;

import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDBConnection {
    Connection conn ;
    StudentDBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_world","root","root") ;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
