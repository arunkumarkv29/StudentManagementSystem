package SMSWS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener{
    JButton login, clear, signup ;
    JTextField studentidTextField ;
    JPasswordField passwordTextField ;
    Login() {
        setLayout(null);

        setTitle("LOGIN PAGE");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("SMSWS/Image/img_1.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 800, 500);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("Enter Your Login Details");
        text.setBounds(150, 40, 600, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);

        JLabel studentid = new JLabel("StudentID");
        studentid.setBounds(120, 150, 150, 30);
        studentid.setFont(new Font("Raleway", Font.BOLD, 28));
        add(studentid);

        JLabel password = new JLabel("Password:");
        password.setBounds(120, 220, 250, 30);
        password.setFont(new Font("Raleway", Font.BOLD, 28));
        add(password);

        studentidTextField = new JTextField();
        studentidTextField.setBounds(300, 150, 230, 30);
        studentidTextField.setFont(new Font("Ariel", Font.BOLD, 14));
        add(studentidTextField);


        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(300, 220, 230, 30);
        passwordTextField.setFont(new Font("Ariel", Font.BOLD, 14));
        add(passwordTextField);


        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);

        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);

        setSize(800, 500);
        setLocation(350, 200);
        setVisible(true);

        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Hello");
        if(ae.getSource()==clear){
            studentidTextField.setText("");
            passwordTextField.setText("");
        }
        else if(ae.getSource()==login){
//            setVisible(false);
//            JOptionPane.showMessageDialog(null,"Login Successfully");
            String sstudentid = studentidTextField.getText() ;
            String spassword = passwordTextField.getText() ;
            StudentDBConnection sdc = new StudentDBConnection() ;
            String query = "SELECT * FROM studentlogin WHERE studentID = '"+sstudentid+"' AND password = '"+spassword+"' " ;
            try {
                PreparedStatement ps = sdc.conn.prepareStatement("query") ;
                ResultSet rs = ps.executeQuery() ;
                if(rs.next()){

                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        else if(ae.getSource()==signup){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }


}

