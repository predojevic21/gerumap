package gerumap.app.gui.dialog;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InfoDialog extends JDialog {

    public InfoDialog() {
        super(MainFrame.getInstance(),"Info",true);

        setSize(200,130);
        setLocationRelativeTo(MainFrame.getInstance());
        setLayout(new FlowLayout());

        JLabel info1 = new JLabel("Jelena Drljan RN46/2020");
        JLabel info2 = new JLabel("Filip Predojevic RN 67/2020");

        JButton okBTN = new JButton("OK");
        okBTN.setMaximumSize(new Dimension(5,5));
        okBTN.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        add(info1);
        add(info2);
        add(okBTN);
    }
}
