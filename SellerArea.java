import java.awt.Color;
import javax.swing.JFrame;

public class SellerArea {
    
    JFrame sellerFrame;


    SellerArea(){
        // Create frame and panel
        sellerFrame = new JFrame("FoodTracker Management");

        //Frame
        sellerFrame.setLayout(null);
        sellerFrame.setResizable(false);
        sellerFrame.getContentPane().setBackground(new Color(213,193,170));
        sellerFrame.setSize(1000,800);
        sellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sellerFrame.setVisible(true);
    }
}
