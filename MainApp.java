/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.jguiextension;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
   
       private final GuiBase panelMain= new GuiSimple();
       private final Factory factory= new Factory();;

    public MainApp()   {
       
        
        // JFrame frame = factory.crearFrameConBtns();       
        //añadirPanel();
        // agregarPanel();
         insertarPanel();
          
        // panelMain.crearGui();
       // frame.add(panelMain);
         //frame.pack();
         //configurarFrame();
               
    }
    
    /*   private void configurarFrame() {
    //Dimension dimension = new Dimension(200,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    getPreferredSize();
    setMinimumSize(getMinimumSize());
    
    
    setVisible(false);
    pack();
    }*/
    
     private void añadirPanel() {
        GuiBase panel;
        panel = new GuiSimple() ;
        Factory.create(EnumTipoGui.SIMPLE);
        
        panel.setBackground(Color.blue);
              
        panelMain.addGui(panel);
      
        
    }
    
     private void agregarPanel() {
       GuiBase panel = Factory.create(EnumTipoGui.SIMPLE);
       GuiBase panel2 = Factory.create(EnumTipoGui.SIMPLE);
        panel.setBackground(Color.yellow);
        panelMain.addGui(panel);
        panelMain.addGui(panel2);         
    }
     
    private void insertarPanel() {
        GuiBase panel = Factory.create(EnumTipoGui.SIMPLE);
        GuiBase panel2 = Factory.create(EnumTipoGui.SIMPLE);
        GuiBase panel3 = Factory.create(EnumTipoGui.SIMPLE);
        panel3.setName("SEGUNDA");
        panel2.setName("PRIMERA");
        
       
       
        panel.addGui(panel2);
        //panel.addGui(panel3);
        //panel2.addGui(panel3);
       
        panel.crearGui();
        //panelMain.addGui(panel);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new MainApp();
             
    }
    
    
}
