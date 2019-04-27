package deneme2;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.NoSuchElementException;

public class ClientForm extends JFrame{
    private JPanel panel1;
    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    private javax.swing.JScrollPane JScrollPane;

    public ClientForm() throws IOException {
        String ipandport = JOptionPane.showInputDialog("Please Enter ip Ip and Port Number EX:xxx.xxx.x.xx,xxxx");
        client client = new client();
        String[] a = ipandport.split(",");
        client.setclient(a[0],Integer.parseInt(a[1]));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel1);
        setSize(400,500);
        JScrollPane.createHorizontalScrollBar();
        setVisible(false);
        button1.setText("Send");


        cv.deneme2.ClientForm clientForm = new cv.deneme2.ClientForm();
        String UserName = JOptionPane.showInputDialog("Enter a UserName");

        clientForm.button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String i =clientForm.textField1.getText();
                clientForm.textArea1.append("["+UserName+"]:"+i+"\n");
                clientForm.textField1.setText("");
                try {
                    client.sendOutput("["+UserName+"]:"+i+"\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        while (true) {
            try
            {
                String i =client.getinput().nextLine();
                clientForm.textArea1.append(i+"\n");
            }
            catch (NoSuchElementException e )
            {

            }
        }


    }
}
