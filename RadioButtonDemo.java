import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEVENT;
import java.awt.event.ActionListener;

public class RadioButtonDemo extends JFrame {

    public radioButtonDemo(){
        setTittle("RadioButtonDemo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());
   
JPanel mainPanel= new Jpanel();
mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 25, 20));

  JRadioButton birdRadio = new JRadioButton("Bird");
        JRadioButton catRadio = new JRadioButton("Cat");
        JRadioButton dogRadio = new JRadioButton("Dog");
        JRadioButton rabbitRadio = new JRadioButton("Rabbit");
        JRadioButton pigRadio = new JRadioButton("Pig");

        
        ButtonGroup petGroup = new ButtonGroup();
        petGroup.add(birdRadio);
        petGroup.add(catRadio);
        petGroup.add(dogRadio);
        petGroup.add(rabbitRadio);
        petGroup.add(pigRadio);

ActionListeners radioListener = new ActionListener(){
    @Overridepublic void acionPerformed(ActionEvent e){
        JRadioButton selected = (JRadioButton)e.getSource();
        System.out.printIn("Selected:" +selected.getText());
    }
};

birdRadio.addActionListner(radioListener);
catRadio.addActionListner(radioListener);
dogRadioRadio.addActionListner(radioListener);
rabbitRadio.addActionListner(radioListener);
pigRadio.addActionListner(radioListener);

 add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new RadioButtonDemo();
            }
        });
}

} 
