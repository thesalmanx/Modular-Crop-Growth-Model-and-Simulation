import java.awt.*;
import javax.swing.*;

public class ProjectLoginForm extends JPanel {
    private JButton signupBtn;
    private JButton loginBtn;
    private JTextField userName;

    private JLabel jcomp4;
    private JLabel jcomp5;
    private JPasswordField password;
    private JLabel jcomp7;
    private JLabel displayLabel;
    private JLabel logo;


    public ProjectLoginForm() {
        //construct components
        signupBtn = new JButton("SignUp");
        loginBtn = new JButton("Login");
        userName = new JTextField(5);
        jcomp4 = new JLabel("Username");
        jcomp5 = new JLabel("Password");
        password = new JPasswordField(5);
        jcomp7 = new JLabel("Welcome to Modular Crop Growth Model and Simulation");
        displayLabel = new JLabel("");

        //adjust size and set layout
        setPreferredSize(new Dimension(476, 326));
        setLayout(null);

        //add components
        add(signupBtn);
        add(loginBtn);
        add(userName);
        add(jcomp4);
        add(jcomp5);
        add(password);
        add(jcomp7);
        add(displayLabel);

        //set component bounds (only needed by Absolute Positioning)
        signupBtn.setBounds(250, 210, 75, 30);
        loginBtn.setBounds(130, 210, 75, 30);
        userName.setBounds(130, 120, 195, 20);
        jcomp4.setBounds(130, 95, 190, 25);
        jcomp5.setBounds(130, 145, 135, 25);
        password.setBounds(130, 170, 195, 20);
        jcomp7.setBounds(85, 30, 335, 55);
        displayLabel.setBounds(130, 255, 195, 20);

        ///frame
        ImageIcon background_Image = new ImageIcon("Crops.jpg");
        Image img = background_Image.getImage();
        Image temp_img = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_Image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_Image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 600);
        add(background);
        loginBtn.addActionListener(e-> buttonPressed());

    }

    private void buttonPressed() {
        String pass = "salman";
        if (pass.equals(password.getText())){
            Simulation simulation = new Simulation();
            simulation.executeFrames();

        }else{
            displayLabel.setText("Incorrect Password or username");
        }
    }

    public void executeFrames() {
        JFrame frame = new JFrame("WELCOME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ProjectLoginForm());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args){

        ProjectLoginForm login = new ProjectLoginForm();
        login.executeFrames();

    }

}
