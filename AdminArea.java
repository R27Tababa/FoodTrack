import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminArea {
    JFrame adminFrame;
    JPanel adminPanel, adminPanel1, adminPanel2;

    JTable table;
    DefaultTableModel model;

    Button_Label_TextField blt = new Button_Label_TextField();

    AdminArea(){
        // Create frame and panels
        adminFrame = new JFrame("FoodTracker Management");
        adminPanel = new JPanel();
        adminPanel1 = new JPanel();
        adminPanel2 = new JPanel();

        //Border
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Positioning and resizing panels
        adminPanel.setBounds(0,20,250,725);
        adminPanel.setBackground(new Color(220,200,190));
        adminPanel.setLayout(null);
        adminPanel.setBorder(border);
        
        adminPanel1.setBounds(275,15,685,350);
        adminPanel1.setBackground(new Color(220,200,190));
        adminPanel1.setLayout(null);
        adminPanel1.setBorder(border);

        adminPanel2.setBounds(275,373,685,380);
        adminPanel2.setBackground(new Color(220,200,190));
        adminPanel2.setLayout(new BorderLayout());
        adminPanel2.setBorder(border);

        //Method
        blt.admin();

        //Frame logo
        ImageIcon logo = new ImageIcon("FrameLogo.png");
        adminFrame.setIconImage(logo.getImage());

        //Table and Model
        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        model.addColumn("Type");

        try (BufferedReader br = new BufferedReader(new FileReader("database.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data1 = line.split(",");
                model.addRow(data1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create the table using the table model
        table = new JTable(model);

        adminPanel2.add(table.getTableHeader(), BorderLayout.PAGE_START);
        adminPanel2.add(table, BorderLayout.CENTER);

        // Set the table to cover the background of the panel
        table.setBackground(table.getBackground());
        adminPanel2.add(new JScrollPane(table));

        // Add a mouse listener to the table to detect when a row is selected
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();

                blt.prodIDField.setText(model.getValueAt(selectedRow, 0).toString());
                blt.prodNameField.setText(model.getValueAt(selectedRow, 1).toString());
                blt.quantityField.setText(model.getValueAt(selectedRow, 2).toString());
                blt.priceField.setText(model.getValueAt(selectedRow, 3).toString());
                blt.foodTypes.setSelectedItem(model.getValueAt(selectedRow, 4));
            }
        });

        // Add panel to frame
        adminFrame.add(adminPanel);
        adminFrame.add(adminPanel1);
        adminFrame.add(adminPanel2);

        //ComboBox
        adminPanel1.add(blt.foodTypes);

        //Label
        adminPanel1.add(blt.lblprodID);
        adminPanel1.add(blt.lblprodName);
        adminPanel1.add(blt.lblfoodType);
        adminPanel1.add(blt.lblquantity);
        adminPanel1.add(blt.lblprice);

        //TextFields
        adminPanel1.add(blt.prodIDField);
        adminPanel1.add(blt.prodNameField);
        adminPanel1.add(blt.quantityField);
        adminPanel1.add(blt.priceField);

        //Buttons
        adminPanel1.add(blt.btnAdd);
        blt.btnAdd.addActionListener(new addButton());

        adminPanel1.add(blt.btnUpdate);
        blt.btnUpdate.addActionListener(new updateButton());

        adminPanel1.add(blt.btnDelete);
        blt.btnDelete.addActionListener(new deleteButton());


        adminPanel1.add(blt.btnClear);
        blt.btnClear.addActionListener(new clearButton());

        adminPanel.add(blt.btnLogout);
        blt.btnLogout.addActionListener(new logoutButton());

        // Image
        adminPanel.add(blt.image);

        //Frame
        adminFrame.setLayout(null);
        adminFrame.setResizable(false);
        adminFrame.getContentPane().setBackground(new Color(213,193,170));
        adminFrame.setSize(1000,800);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setVisible(true);
    }

    class addButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String prodID = blt.prodIDField.getText();
            String prodName = blt.prodNameField.getText();
            String prodQuan = blt.quantityField.getText();
            String prodPrice = blt.priceField.getText();
            String prodtype = blt.foodTypes.getSelectedItem().toString();
            
            try {
                FileWriter file = new FileWriter("database.txt", true);
                BufferedWriter addData = new BufferedWriter(file);
                addData.write(prodID + "," + 
                prodName + "," + 
                prodQuan + "," + 
                prodPrice + "," + 
                prodtype + "\n");

                addData.close();

            } catch (IOException e1) {
                e1.printStackTrace();
            }

            String[] baseData = {prodID, prodName, prodQuan, prodPrice, prodtype};
            model.addRow(baseData);

            JOptionPane.showMessageDialog(null, "Added successfully");
        }
    }

    class logoutButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminFrame.dispose();
            new LoginArea();
        }
    }

    class clearButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            blt.prodIDField.setText("");
            blt.prodNameField.setText("");
            blt.quantityField.setText("");
            blt.priceField.setText("");
        }
    }

    class deleteButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1){
                model.removeRow(selectedRow);

                try {
                    FileWriter writer = new FileWriter("database.txt");
                    for (int i = 0; i < model.getRowCount(); i++) {
                        writer.write(model.getValueAt(i, 0) + "," + 
                        model.getValueAt(i, 1) + "," + 
                        model.getValueAt(i, 2) + "," + 
                        model.getValueAt(i, 3) + "," + 
                        model.getValueAt(i, 4) + "\n");
                    }
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Deleted successfully");
            }

        }
    }

    class updateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();

            String prodID = blt.prodIDField.getText();
            String prodName = blt.prodNameField.getText();
            String prodQuan = blt.quantityField.getText();
            String prodPrice = blt.priceField.getText();
            String prodtype = blt.foodTypes.getSelectedItem().toString();


            if (selectedRow != -1){      
                
                model.removeRow(selectedRow);

                try {
                    FileWriter writer = new FileWriter("database.txt");
                    for (int i = 0; i < model.getRowCount(); i++) {

                        writer.write(model.getValueAt(i, 0) + "," + 
                        model.getValueAt(i, 1) + "," + 
                        model.getValueAt(i, 2) + "," + 
                        model.getValueAt(i, 3) + "," + 
                        model.getValueAt(i, 4) + "\n");
                    }
                    
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    FileWriter file = new FileWriter("database.txt", true);
                    BufferedWriter updateData = new BufferedWriter(file);
                    updateData.write(prodID + "," + 
                    prodName + "," + 
                    prodQuan + "," + 
                    prodPrice + "," + 
                    prodtype + "\n");
    
                    updateData.close();
    
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

            String[] baseData = {prodID, prodName, prodQuan, prodPrice, prodtype};
            model.addRow(baseData);
            JOptionPane.showMessageDialog(null, "Updated successfully");

        }
    }
}