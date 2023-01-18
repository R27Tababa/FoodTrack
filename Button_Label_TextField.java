import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
class Button_Label_TextField{

    //-----------Login---------

    // Create buttons
    JButton btnLogin, btnRegis;
    // Create labels
    JLabel user, id, password, lblLogin;
    // Create TextFIeld
    JTextField idField, passField;
    // Create ComboBox
    JComboBox<String> loginBox;

    //-----------Register---------

    // Create buttons
    JButton btnBack, btnDone;
    // Create label
    JLabel lblRegister;

    //-----------Admin---------

    // Create labels
    JLabel lblprodID, lblprodName, lblquantity, lblfoodType, lblprice;
    // Create textfields
    JTextField prodNameField, prodIDField, quantityField, priceField;
    // Create combobox
    JComboBox<String> foodTypes;
    // Create buttons
    JButton btnAdd, btnClear, btnDelete, btnUpdate, btnLogout;
    // Create image icon
    JLabel image;
    ImageIcon logo;

    void login() {
        //ComboBox
        String[] typeLogin = {"Admin", "Seller"};
        loginBox = new JComboBox<>(typeLogin);
        loginBox.setBounds(100,200,200,40);

        //TextFields
        idField = new JTextField();
        idField.setBounds(100,300,200, 40);

        passField = new JPasswordField();
        passField.setBounds(100,400,200,40);

        //Labels
        lblLogin = new JLabel("LOGIN");
        lblLogin.setBounds(130,50,200,50);
        lblLogin.setFont(new Font("Font", Font.BOLD,50));

        user = new JLabel("User");
        user.setBounds(180,150,100,50);
        user.setFont(new Font("Font", Font.PLAIN,18));

        id = new JLabel("ID");
        id.setBounds(185,250,100,50);
        id.setFont(new Font("Font", Font.PLAIN,18));

        password = new JLabel("Password");
        password.setBounds(160,350,100,50);
        password.setFont(new Font("Font", Font.PLAIN,18));

        //Buttons
        btnLogin = new JButton("Login");
        btnLogin.setBounds(100,500,200,30);

        btnRegis = new JButton("Register");
        btnRegis.setBounds(100,540,200,30);
    }

    void admin(){
        //Labels
        lblprodID = new JLabel("ProdID");
        lblprodID.setBounds(25, 25, 100, 15);
        lblprodID.setFont(new Font("Font", Font.PLAIN,15));
        
        lblprodName = new JLabel("Name");
        lblprodName.setBounds(25, 125, 100, 15);
        lblprodName.setFont(new Font("Font", Font.PLAIN,15));

        lblfoodType = new JLabel("Type");
        lblfoodType.setBounds(25, 225, 100, 15);
        lblfoodType.setFont(new Font("Font", Font.PLAIN,15));

        lblquantity = new JLabel("Quantity");
        lblquantity.setBounds(450, 25, 100, 15);
        lblquantity.setFont(new Font("Font", Font.PLAIN,15));

        lblprice = new JLabel("Price");
        lblprice.setBounds(450, 125, 100, 15);
        lblprice.setFont(new Font("Font", Font.PLAIN,15));

        //TextFields
        prodIDField = new JTextField();
        prodIDField.setBounds(150, 25, 100, 25);

        prodNameField = new JTextField();
        prodNameField.setBounds(150, 125, 100, 25);
        
        quantityField = new JTextField();
        quantityField.setBounds(550, 25, 100, 25);
        
        priceField = new JTextField();
        priceField.setBounds(550, 125, 100, 25);

        //ComboBox
        String[] foodListType = {"Beverages", "Meat", "Fish", "Bread"};
        foodTypes = new JComboBox<>(foodListType);
        foodTypes.setBounds(150,225,100,25);

        //Buttons
        btnAdd = new JButton("Add");
        btnAdd.setBounds(150, 300, 75, 20);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(250, 300, 75, 20);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(350, 300, 75, 20);

        btnClear = new JButton("Clear");
        btnClear.setBounds(450, 300, 75, 20);

        btnLogout = new JButton("LOGOUT");
        btnLogout.setBounds(25, 650, 200, 50);

        // Image
        image = new JLabel();
        logo = new ImageIcon("logo.png");
        image.setIcon(logo);
        image.setBounds(0, 150, 250, 300);
        

    }

    void Register(){
        lblRegister = new JLabel("Register");
        lblRegister.setBounds(110,15,300,100);
        lblRegister.setFont(new Font("Font", Font.BOLD,50));

        //Buttons
        btnDone = new JButton("Done");
        btnDone.setBounds(100,470,200,30);

        btnBack = new JButton("Back");
        btnBack.setBounds(100,510,200,30);
    }
}