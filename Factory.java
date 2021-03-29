/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.jguiextension;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author a31r1z
 */
public class Factory {
       private static  JFrame frame;
    
    public Factory() {
        
    }
    
    public static GuiBase create(EnumTipoGui typeGui) {
        
        GuiBase gui= null;
       
        switch(typeGui) {
            
            case SIMPLE -> gui= new GuiSimple();   
           // case TABBED -> gui= new JTabbedGui();   
           // case TREE -> gui= new JTreeGui();
            default -> throw new AssertionError(typeGui.name());
        }
        return gui;        
    }
 
    public static JFrame crearFrame() {
        
        frame= new JFrame();
        
        frame.setLayout(new GridLayout(1,0));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        
        return frame;
    }
    
    public static JFrame crearFrameConBtns() {
        
        crearFrame();
        frame.setLayout(new BorderLayout());
        
        return agregarBtns(frame);        
    }
    
    private static JFrame agregarBtns(JFrame frame) {
        
        JButton btnOk = new JButton("Ok");
        JButton btnCancel = new JButton("Cancel");
        JPanel panel = new JPanel();
        
        panel.add(btnOk);
        panel.add(btnCancel); 
        
        frame.add(panel,BorderLayout.SOUTH);
        
        return frame;
    }
    
}
