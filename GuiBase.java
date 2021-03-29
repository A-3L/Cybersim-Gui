/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.jguiextension;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
abstract public class GuiBase extends javax.swing.JPanel {
    
      
    List<GuiBase> listaGuisAnidadas = new ArrayList<>();
    
    abstract public void addGui(GuiBase gui);
      
    abstract public  void integrarGuis(Container cont) ;           
    
           
    abstract public  void addComponente(GuiBase componente);
    

    abstract public List<GuiBase> getListaGuisAnidadas();

    abstract public void setListaGuisAnidadas (List<GuiBase> listaGuisAnidadas);
    
    abstract public  void crearGui();
    
}
