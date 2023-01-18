import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class LoginArea{
    
    JFrame frameLogin;
    JPanel panelLogin;

    Button_Label_TextField blt = new Button_Label_TextField();

    public static void main(String[] args){
        new LoginArea();
    }

    LoginArea(){
        //Create Panel and Frame
        frameLogin = new JFrame("FoodTracker Management");
        panelLogin = new JPanel();

        //Border
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        //Login method
        blt.login();

        //ComboBox
        panelLogin.add(blt.loginBox);

        //Panel
        panelLogin.setBounds(45,30,400,600);
        panelLogin.setLayout(null);
        panelLogin.setBorder(border);
        frameLogin.add(panelLogin);

        //Frame logo
        ImageIcon logo = new ImageIcon("FrameLogo.png");
        frameLogin.setIconImage(logo.getImage());

        //add TextField
        panelLogin.add(blt.idField);
        panelLogin.add(blt.passField);

        //add Label
        panelLogin.add(blt.lblLogin);
        panelLogin.add(blt.user);
        panelLogin.add(blt.id);
        panelLogin.add(blt.password);

        //add Buttons
        panelLogin.add(blt.btnLogin);
        blt.btnLogin.addActionListener(new loginButton());

        panelLogin.add(blt.btnRegis);
        blt.btnRegis.addActionListener(new regisButton());

        //Frame
        frameLogin.setLayout(null);
        frameLogin.setResizable(false);
        frameLogin.setSize(500,700);
        frameLogin.getContentPane().setBackground(Color.CYAN);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setVisible(true);
    }

    class loginButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userID = blt.idField.getText();
            String passwordd = blt.passField.getText();
            String userType = blt.loginBox.getSelectedItem().toString();

            try {
                if (userType.equalsIgnoreCase("Admin")){
                    File file = new File("Admin.txt");
    
                    if (file.exists()){
                        BufferedReader reader = new BufferedReader(new FileReader("Admin.txt"));
                        String line;

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(":");
                            if (parts[0].equalsIgnoreCase(userID) && parts[1].equals(passwordd)) {
                                frameLogin.dispose();
                                new AdminArea();
                                break;
                            }
                        }

                        reader.close();
                        
                        

                    } else if(!file.exists()){
                        JOptionPane.showMessageDialog(null, "You need to register first");
                    }
                }
            } catch (IOException e1){
            e1.printStackTrace();
            }

            try{
                if (userType.equalsIgnoreCase("Seller")){
                    File file = new File("Seller.txt");
    
                    if (file.exists()){
                        BufferedReader reader = new BufferedReader(new FileReader("Seller.txt"));
                        String line;

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(":");
                            if (parts[0].equalsIgnoreCase(userID) && parts[1].equals(passwordd)) {
                                frameLogin.dispose();
                                new SellerArea();
                                break;
                            } 
                        }

                        reader.close();
                    
                    } else if(!file.exists()){
                        JOptionPane.showMessageDialog(null, "You need to register first");
                    }

                }
            } catch (IOException er){
                er.printStackTrace();
            }
        }
    }

    class regisButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frameLogin.dispose();
            new RegisterArea();
        }
    }

}