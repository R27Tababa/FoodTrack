import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class RegisterArea {
    
    JFrame frameRegis;
    JPanel panelRegis;

    Button_Label_TextField blt = new Button_Label_TextField();

    RegisterArea(){
        frameRegis = new JFrame("FoodTracker Management");
        panelRegis = new JPanel();

        //Border
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        //Login method
        blt.login();
        blt.Register();

        //ComboBox
        panelRegis.add(blt.loginBox);

        //Panel
        panelRegis.setBounds(45,30,400,600);
        panelRegis.setLayout(null);
        panelRegis.setBorder(border);
        frameRegis.add(panelRegis);

        //Frame logo
        ImageIcon logo = new ImageIcon("FrameLogo.png");
        frameRegis.setIconImage(logo.getImage());

        //add TextField
        panelRegis.add(blt.idField);
        panelRegis.add(blt.passField);

        //add Label
        panelRegis.add(blt.lblRegister);
        panelRegis.add(blt.user);
        panelRegis.add(blt.id);
        panelRegis.add(blt.password);

        //add Buttons
        panelRegis.add(blt.btnDone);
        blt.btnDone.addActionListener(new doneButton());

        panelRegis.add(blt.btnBack);
        blt.btnBack.addActionListener(new backButton());

        //Frame
        frameRegis.setLayout(null);
        frameRegis.setResizable(false);
        frameRegis.setSize(500,700);
        frameRegis.getContentPane().setBackground(Color.CYAN);
        frameRegis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegis.setVisible(true);
    }

    class doneButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userID = blt.idField.getText();
            String passwordd = blt.passField.getText();
            String userType = blt.loginBox.getSelectedItem().toString();

            if (userType.equalsIgnoreCase("Admin")){
                if (userID.isEmpty() ||  passwordd.isEmpty() || userID.isEmpty() && passwordd.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please input your information");
                } else {
                    try{
                        // Create File
                        File file = new File("Admin.txt");
                        // Writer
                        FileWriter createNewFile = new FileWriter(file, true);
                        BufferedWriter writer = new BufferedWriter(createNewFile);
    
                        writer.write(userID + ":" + passwordd + "\n");
    
                        writer.close();
                    }catch(IOException e2){
                        e2.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Successfully registerd");
                }

            } else if (userType.equalsIgnoreCase("Seller")){
                if (userID.isEmpty() ||  passwordd.isEmpty() || userID.isEmpty() && passwordd.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please input your information");
                } else {
                    try{
                        // Create File
                        File file = new File("Seller.txt");
                        // Writer
                        FileWriter createNewFile = new FileWriter(file, true);
                        BufferedWriter writer = new BufferedWriter(createNewFile);
    
                        writer.write(userID + ":" + passwordd + "\n");
    
                        writer.close();
                    }catch(IOException e2){
                        e2.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "Successfully registerd");
                }
            }
        }
    }

    class backButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frameRegis.dispose();
            new LoginArea();
        }
    }
}
