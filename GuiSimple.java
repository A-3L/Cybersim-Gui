/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.jguiextension;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class GuiSimple extends GuiBase{

     private javax.swing.JFrame frame;
    /**
     * Creates new form ClaseBase
     */
    public GuiSimple() {
        initComponents();
        
        inicializar();
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Titulo"));

        jRadioButton1.setText("jRadioButton1");

        jRadioButton2.setText("jRadioButton2");

        jRadioButton3.setText("jRadioButton3");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jButton2)
                .addGap(26, 26, 26)
                .addComponent(jButton3)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    // End of variables declaration//GEN-END:variables
  
    
    public void inicializar() {
        
         Dimension tamañoMinimo = calcularTamañoMinimo(this);
         setMinimumSize(tamañoMinimo);
           System.out.println(tamañoMinimo + "Este");
           System.out.println(this.getMinimumSize() + "EsteGet");
    }
    @Override
    public void addGui(GuiBase gui){
     listaGuisAnidadas.add(gui);}
      
    @Override
    public  void integrarGuis(Container cont) {
    
           cont.add(this);
          for (GuiBase gui : getListaGuisAnidadas()) {
                          
              for(GuiBase panel: gui.getListaGuisAnidadas()) {
                  gui.addComponente(panel);
              }         
            cont.add(gui);            
        }
    }
    
     
    @Override
    public  void addComponente(GuiBase componente){
        this.add(componente);
    }
           

    @Override
    public List<GuiBase> getListaGuisAnidadas(){ 
           
        return listaGuisAnidadas;
    }

    @Override
    public void setListaGuisAnidadas (List<GuiBase> listaGuisAnidadas){
    
        this.listaGuisAnidadas= listaGuisAnidadas;
    }
    
    @Override
    public  void crearGui(){
        frame = Factory.crearFrameConBtns();
           
       
          JPanel panel = new JPanel();
          panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                           
          integrarGuis(panel);
          
          /*        var tamañoMinimo = calcularTamañoMinimo(panel);
          panel.setMinimumSize(tamañoMinimo);
          System.out.println(tamañoMinimo + "Panel");
          System.out.println(panel.getMinimumSize() + "Panel");
          */
          frame.add(panel); 
          
               var tamañoMinimoFrame = calcularTamañoMinimo(frame);
          frame.setMinimumSize(tamañoMinimoFrame);
          
          System.out.println(tamañoMinimoFrame + "Frame");
          System.out.println(panel.getMinimumSize() + "Frame");
          
          frame.pack();
    }
    
    private Dimension calcularTamañoMinimo(Container contenedor) {
        
        var layout = contenedor.getLayout();
        var dimensiones = layout.minimumLayoutSize(contenedor);
        
        return dimensiones;
    }
    
     private Dimension calcularTamañoPreferido(Container contenedor) {
        
        var layout = contenedor.getLayout();
        var dimensiones = layout.preferredLayoutSize(contenedor);
        
        return dimensiones;
    }
    
     private Dimension dimensionesComponentes (Container contenedor) {
        
          Component[] componentes = contenedor.getComponents();
          Insets insets = contenedor.getInsets();
          int heightSum = 0;
          int widthSum = 0;
          
          for (Component comp: componentes) {
                            
              var height= comp.getHeight();   
              var width= comp.getWidth();
              
              heightSum += height;
              widthSum += width; 
            
            }
               System.out.println(heightSum);
                System.out.println(widthSum);
             heightSum +=(insets.bottom + insets.top);
             widthSum +=(insets.left + insets.right);
                System.out.println(heightSum);
               System.out.println(widthSum);
               System.out.println("hola");
        return new Dimension(widthSum, heightSum );
    }
    
    }
    
