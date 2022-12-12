package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import negocio.RecursosHumanos;

import util.RHException;

public class Ventana extends JFrame {
    private RecursosHumanos rh;
    private BorderLayout layoutMain = new BorderLayout();
    private JPanel panelCenter = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuHelpAbout = new JMenuItem();
    private JLabel statusBar = new JLabel();
    private JToolBar toolBar = new JToolBar();
    private JButton buttonOpen = new JButton();
    private JButton buttonClose = new JButton();
    private JButton buttonHelp = new JButton();
    private ImageIcon imageOpen = new ImageIcon(Ventana.class.getResource("openfile.gif"));
    private ImageIcon imageClose = new ImageIcon(Ventana.class.getResource("closefile.gif"));
    private ImageIcon imageHelp = new ImageIcon(Ventana.class.getResource("help.gif"));
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField3 = new JTextField();
    private JTextField jTextField4 = new JTextField();
    private JButton jButton1 = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JTextField jTextField5 = new JTextField();
    private JButton jButton2 = new JButton();
    private JTextField jTextField6 = new JTextField();
    private JLabel jLabel7 = new JLabel();

    public Ventana() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        rh = new RecursosHumanos();
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( layoutMain );
        panelCenter.setLayout( null );
        this.setSize( new Dimension(400, 300) );
        this.setTitle( "Recursos Humanos" );
        menuFile.setText( "File" );
        menuFileExit.setText( "Exit" );
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        menuHelp.setText( "Help" );
        menuHelpAbout.setText( "About" );
        menuHelpAbout.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { helpAbout_ActionPerformed( ae ); } } );
        statusBar.setText( "" );
        buttonOpen.setToolTipText( "Open File" );
        buttonOpen.setIcon( imageOpen );
        buttonClose.setToolTipText( "Close File" );
        buttonClose.setIcon( imageClose );
        buttonClose.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonClose_actionPerformed(e);
                }
            });
        buttonHelp.setToolTipText( "About" );
        buttonHelp.setIcon( imageHelp );
        jTextField1.setBounds(new Rectangle(130, 45, 125, 20));
        jTextField1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jTextField1_actionPerformed(e);
                }
            });
        jTextField2.setBounds(new Rectangle(130, 70, 125, 20));
        jTextField3.setBounds(new Rectangle(130, 95, 125, 20));
        jTextField4.setBounds(new Rectangle(130, 120, 125, 20));
        jButton1.setText("Incluir Empleado");
        jButton1.setBounds(new Rectangle(15, 190, 135, 20));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jLabel1.setText("Nombre");
        jLabel1.setBounds(new Rectangle(40, 45, 90, 15));
        jLabel2.setText("Apellido");
        jLabel2.setBounds(new Rectangle(40, 70, 55, 15));
        jLabel3.setText("Trabajo ID");
        jLabel3.setBounds(new Rectangle(40, 95, 55, 20));
        jLabel4.setText("Email");
        jLabel4.setBounds(new Rectangle(40, 120, 34, 14));
        jLabel5.setText("jLabel5");
        jLabel6.setText("Empleado ID");
        jLabel6.setBounds(new Rectangle(40, 20, 75, 20));
        jTextField5.setBounds(new Rectangle(130, 20, 125, 20));
        jButton2.setText("Actualizar salario");
        jButton2.setBounds(new Rectangle(160, 190, 135, 20));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jTextField6.setBounds(new Rectangle(130, 150, 125, 20));
        jTextField6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jTextField6_actionPerformed(e);
                }
            });
        jLabel7.setText("Salario");
        jLabel7.setBounds(new Rectangle(45, 150, 34, 14));
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        menuHelp.add( menuHelpAbout );
        menuBar.add( menuHelp );
        this.getContentPane().add( statusBar, BorderLayout.SOUTH );
        this.getContentPane().add( toolBar, BorderLayout.NORTH);
        toolBar.add( buttonOpen );
        toolBar.add( buttonClose );
        toolBar.add( buttonHelp );
        panelCenter.add(jLabel7, null);
        panelCenter.add(jTextField6, null);
        panelCenter.add(jButton2, null);
        panelCenter.add(jTextField5, null);
        panelCenter.add(jLabel6, null);
        panelCenter.add(jLabel4, null);
        panelCenter.add(jLabel3, null);
        panelCenter.add(jLabel2, null);
        panelCenter.add(jLabel1, null);
        panelCenter.add(jButton1, null);
        panelCenter.add(jTextField4, null);
        panelCenter.add(jTextField3, null);
        panelCenter.add(jTextField2, null);
        panelCenter.add(jTextField1, null);
        this.getContentPane().add( panelCenter, BorderLayout.CENTER );
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    void helpAbout_ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new Ventana_AboutBoxPanel1(), "About", JOptionPane.PLAIN_MESSAGE);
    }

    private void jButton1_actionPerformed(ActionEvent e) {
          try {
              System.out.println(jTextField5.getText());
               rh.incluirEmpleado(Integer.parseInt(jTextField5.getText()),jTextField1.getText(), jTextField2.getText(),jTextField3.getText(),jTextField4.getText(), Double.parseDouble(jTextField6.getText()),"2012-11-05");
              JOptionPane.showMessageDialog(null,  "Registro Incluido Exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
          } catch (RHException f) {
              JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);
              
          }
      }

    private void jTextField1_actionPerformed(ActionEvent e) {
    }

    private void buttonClose_actionPerformed(ActionEvent e) {
    }

    private void jButton2_actionPerformed(ActionEvent e) {
      try {
          Double salario = Double.parseDouble(jTextField6.getText());
          Integer id = Integer.parseInt(jTextField5.getText());
          System.out.println("salario "+ salario);
          rh.actualizarSalario(id, salario);
          JOptionPane.showMessageDialog(null,  "Salario Modificado Exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
      } catch (RHException f) {
          JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);
      } catch (NumberFormatException e1) {
          JOptionPane.showMessageDialog(null, "El valor debe ser numérico", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

    private void jTextField6_actionPerformed(ActionEvent e) {
    }
}
