package gerumap.app.gui.controller;

import gerumap.app.gui.view.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class PictureOfPanelAction extends AbstractGeRuMapAction{

    public PictureOfPanelAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/panelpic.png"));
        putValue(NAME, "Take a picture of panel");
        putValue(SHORT_DESCRIPTION, "Take a picture of panel");
    }

    public static BufferedImage getPicture(Component component){
        BufferedImage image = new BufferedImage(component.getWidth(),component.getHeight(),BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        return image;
    }

    public static void savePicture(Component component, String filename)throws Exception{

        BufferedImage image = getPicture(component);
        ImageIO.write(image, "png", new File(filename));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            savePicture(MainFrame.getInstance().getProjectView().getCurrentMindMapView(),"src/main/resources/mindMapPics/"+"slika" + MainFrame.getInstance().getProjectView().getCurrentMindMapView().getMindMap().getName() + ".png");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
