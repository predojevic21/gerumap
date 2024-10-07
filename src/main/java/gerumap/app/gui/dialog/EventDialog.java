package gerumap.app.gui.dialog;

import gerumap.app.gui.view.MainFrame;
import gerumap.app.messageGenerator.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EventDialog extends JDialog {
    public EventDialog(Message message){
        super(MainFrame.getInstance(),"Null",true);

        setSize(500,100);
        setLocationRelativeTo(MainFrame.getInstance());
        setLayout(new FlowLayout());

        JLabel info = new JLabel(message.toString());

        JButton okBTN = new JButton("OK");
        okBTN.setMaximumSize(new Dimension(5,5));
        okBTN.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        add(info);
        add(okBTN);

    }
}
