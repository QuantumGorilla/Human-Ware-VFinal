package humanware_betancourtandres_manotasalejandro;

import AppPackage.AnimationClass;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manotasja
 */
public class HumanWare extends javax.swing.JFrame {
    
    class Nodo {
        
        String titulacion;
        String habilidad;
        int nivel;
        Nodo link;
    }
    Nodo ptr, ptr2;
    
    File archivo;
    File Foto = null;
    Empresa empresa = new Empresa();
    CreacionUsuario usuario = new CreacionUsuario();
    
    public HumanWare() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        agregarFrame.setLocationRelativeTo(null);
        solicitantes.setLocationRelativeTo(null);
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/mundoGlobal.jpg")).getImage());
        agregarFrame.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/mundoGlobal.jpg")).getImage());
        solicitantes.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/mundoGlobal.jpg")).getImage());
        
        DefaultListModel model = new DefaultListModel();
        listaTitulacion.setModel(model);
        ptr = null;
        ptr2 = null;
        model = new DefaultListModel();
        listaHabilidad.setModel(model);
        
        noPasteNomField();
        
        noPasteEmailField();
        
        noPasteTelefonoField();
        
        noPasteRetribucionField();
        
        noPasteHabilidadField();
        
        noPastePuntuacionField();
        
    }
    
    public void noPasteNomField() {
        //Para que no copie y pegue caracteres invalidos en el campo del nombre del solicitante
        InputMap map2 = nombreField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteEmailField() {
        //Para que no copie y pegue caracteres invalidos en el campo del email del solicitante
        InputMap map2 = emailField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteTelefonoField() {
        //Para que no copie y pegue caracteres invalidos en el campo del telefono del solicitante
        InputMap map2 = telefonoField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteRetribucionField() {
        //Para que no copie y pegue caracteres invalidos en el campo de retribución del solicitante
        InputMap map2 = retribucionField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteTitulacionField() {
        //Para que no copie y pegue caracteres invalidos en el campo de titulación del solicitante
        InputMap map2 = titulacionField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteHabilidadField() {
        //Para que no copie y pegue caracteres invalidos en el campo de habilidad del solicitante
        InputMap map2 = habilidadField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPastePuntuacionField() {
        //Para que no copie y pegue caracteres invalidos en el campo de puntuación del solicitante
        InputMap map2 = puntuacionField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public JTextField dameUsuarioTextField() {
        return usuarioField;
    }
    
    public JTextField dameContraseñaField() {
        return contraseñaField;
    }
    
    public Nodo Agregartit(Nodo ptr, String tit) {
        //Agrega titulaciones a la lista
        Nodo p = new Nodo();
        p.titulacion = tit;
        if (ptr == null) {
            ptr = p;
        } else {
            Nodo q = ptr;
            while (q.link != null) {
                q = q.link;
            }
            q.link = p;
        }
        return ptr;
    }
    
    public void MostrarLista(Nodo ptr) {
        //Muestra las titulaciones en la lista
        DefaultListModel model = (DefaultListModel) listaTitulacion.getModel();
        model.clear();
        Nodo p = ptr;
        while (p != null) {
            model.addElement(p.titulacion);
            p = p.link;
        }
    }
    
    public void mostrarListaHabilidad(Nodo ptr2) {
//Muestra las habilidades con su respectiva puntuación en la lista
        DefaultListModel modelo = (DefaultListModel) listaHabilidad.getModel();
        modelo.clear();
        Nodo p = ptr2;
        while (p != null) {
            modelo.addElement(p.habilidad + "," + p.nivel);
            p = p.link;
        }
    }
    
    public Nodo agregarHabilidad(Nodo ptr2, String habilidad, int nivel) {
        //Agrega habilidades y una respectiva puntuación a la lista
        Nodo p = new Nodo();
        
        p.habilidad = habilidad;
        p.nivel = nivel;
        
        if (ptr == null) {
            ptr2 = p;
        } else {
            Nodo q = ptr2;
            while (q.link != null) {
                q = q.link;
            }
            q.link = p;
        }
        return ptr2;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        solicitantes = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        solicitantesTable = new javax.swing.JTable();
        agregarTabla = new javax.swing.JButton();
        cargarDatosSolicitantesBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        eliminarSolicitanteBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        guardarTable = new javax.swing.JButton();
        nombreArchivoField = new javax.swing.JTextField();
        retrocederFrame = new javax.swing.JLabel();
        cerrarF = new javax.swing.JLabel();
        agregarFrame = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        agregarSolicitanteBoton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        usuarioCambio = new javax.swing.JLabel();
        cerrarTodo = new javax.swing.JLabel();
        devolverseFrame = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        retribucionField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaHabilidad = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        telefonoField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ingresarBtn1 = new javax.swing.JButton();
        titulacionField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jornadaOpcionCombo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        agregarFotoBtn = new javax.swing.JButton();
        ubicacionFotoField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        puntuacionField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        habilidadField = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTitulacion = new javax.swing.JList<>();
        ingresarBtn2 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelIngreso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        usuarioField = new javax.swing.JTextField();
        contraseñaField = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ingresarButton = new javax.swing.JButton();
        crearUsuarioBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        cerrarFrame = new javax.swing.JLabel();

        solicitantes.setMaximumSize(new java.awt.Dimension(760, 423));
        solicitantes.setMinimumSize(new java.awt.Dimension(760, 423));
        solicitantes.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Solicitantes");
        solicitantes.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 114, 37));

        solicitantesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Email", "Telefono", "Retribución mínima", "Foto", "Jornada", "Titulación", "Habilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(solicitantesTable);
        if (solicitantesTable.getColumnModel().getColumnCount() > 0) {
            solicitantesTable.getColumnModel().getColumn(0).setResizable(false);
            solicitantesTable.getColumnModel().getColumn(1).setResizable(false);
            solicitantesTable.getColumnModel().getColumn(2).setResizable(false);
            solicitantesTable.getColumnModel().getColumn(3).setResizable(false);
            solicitantesTable.getColumnModel().getColumn(4).setResizable(false);
            solicitantesTable.getColumnModel().getColumn(5).setResizable(false);
            solicitantesTable.getColumnModel().getColumn(6).setResizable(false);
            solicitantesTable.getColumnModel().getColumn(7).setResizable(false);
        }

        solicitantes.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 740, 116));

        agregarTabla.setBackground(new java.awt.Color(255, 255, 255));
        agregarTabla.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        agregarTabla.setForeground(new java.awt.Color(255, 255, 255));
        agregarTabla.setText("Agregar solicitante");
        agregarTabla.setBorder(null);
        agregarTabla.setContentAreaFilled(false);
        agregarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTablaActionPerformed(evt);
            }
        });
        solicitantes.getContentPane().add(agregarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 170, 40));

        cargarDatosSolicitantesBtn.setBackground(new java.awt.Color(255, 255, 255));
        cargarDatosSolicitantesBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        cargarDatosSolicitantesBtn.setForeground(new java.awt.Color(255, 255, 255));
        cargarDatosSolicitantesBtn.setText("Seleccionar datos");
        cargarDatosSolicitantesBtn.setBorder(null);
        cargarDatosSolicitantesBtn.setContentAreaFilled(false);
        cargarDatosSolicitantesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarDatosSolicitantesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosSolicitantesBtnActionPerformed(evt);
            }
        });
        solicitantes.getContentPane().add(cargarDatosSolicitantesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 160, 40));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Archivo: ");
        solicitantes.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 70, 30));

        eliminarSolicitanteBtn.setBackground(new java.awt.Color(255, 255, 255));
        eliminarSolicitanteBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        eliminarSolicitanteBtn.setForeground(new java.awt.Color(255, 255, 255));
        eliminarSolicitanteBtn.setText("Eliminar solicitante");
        eliminarSolicitanteBtn.setBorder(null);
        eliminarSolicitanteBtn.setContentAreaFilled(false);
        eliminarSolicitanteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarSolicitanteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarSolicitanteBtnActionPerformed(evt);
            }
        });
        solicitantes.getContentPane().add(eliminarSolicitanteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 160, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setForeground(new java.awt.Color(0, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 150, 20));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 140, 20));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 140, 20));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 150, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Menu_32px.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        guardarTable.setBackground(new java.awt.Color(255, 255, 255));
        guardarTable.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        guardarTable.setForeground(new java.awt.Color(255, 255, 255));
        guardarTable.setText("Guardar solicitante");
        guardarTable.setBorder(null);
        guardarTable.setContentAreaFilled(false);
        guardarTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardarTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarTableActionPerformed(evt);
            }
        });
        jPanel3.add(guardarTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 160, 30));

        nombreArchivoField.setBackground(new java.awt.Color(0, 0, 51));
        nombreArchivoField.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        nombreArchivoField.setForeground(new java.awt.Color(255, 255, 255));
        nombreArchivoField.setBorder(null);
        jPanel3.add(nombreArchivoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 280, -1));

        retrocederFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Back_64px.png"))); // NOI18N
        retrocederFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retrocederFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retrocederFrameMouseClicked(evt);
            }
        });
        jPanel3.add(retrocederFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 30, 30, 40));

        cerrarF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Multiply_32px.png"))); // NOI18N
        cerrarF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarFMouseClicked(evt);
            }
        });
        jPanel3.add(cerrarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 70, 40, 40));

        solicitantes.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        agregarFrame.setMaximumSize(new java.awt.Dimension(742, 530));
        agregarFrame.setMinimumSize(new java.awt.Dimension(742, 530));
        agregarFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(0, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 150, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Inscripción del solicitante");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, -1));

        agregarSolicitanteBoton.setBackground(new java.awt.Color(255, 255, 255));
        agregarSolicitanteBoton.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        agregarSolicitanteBoton.setForeground(new java.awt.Color(255, 255, 255));
        agregarSolicitanteBoton.setText("Agregar solicitante");
        agregarSolicitanteBoton.setBorder(null);
        agregarSolicitanteBoton.setContentAreaFilled(false);
        agregarSolicitanteBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarSolicitanteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarSolicitanteBotonActionPerformed(evt);
            }
        });
        jPanel4.add(agregarSolicitanteBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 170, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Handshake_96px.png"))); // NOI18N
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 100, 110));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Menu_32px.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        usuarioCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_customer_32px_1.png"))); // NOI18N
        usuarioCambio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuarioCambio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioCambioMouseClicked(evt);
            }
        });
        jPanel4.add(usuarioCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 70, -1, -1));

        cerrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Multiply_32px.png"))); // NOI18N
        cerrarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarTodoMouseClicked(evt);
            }
        });
        jPanel4.add(cerrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 110, -1, -1));

        devolverseFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Back_64px.png"))); // NOI18N
        devolverseFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        devolverseFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                devolverseFrameMouseClicked(evt);
            }
        });
        jPanel4.add(devolverseFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 30, 40, 30));

        agregarFrame.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 550));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        retribucionField.setBackground(new java.awt.Color(255, 255, 255));
        retribucionField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        retribucionField.setForeground(new java.awt.Color(0, 0, 0));
        retribucionField.setText("Ingrese la retribución");
        retribucionField.setBorder(null);
        retribucionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retribucionFieldMouseClicked(evt);
            }
        });
        retribucionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                retribucionFieldKeyTyped(evt);
            }
        });
        jPanel5.add(retribucionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 170, 20));

        listaHabilidad.setBackground(new java.awt.Color(255, 255, 255));
        listaHabilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaHabilidad.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jScrollPane3.setViewportView(listaHabilidad);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 150, 80));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nombre:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 20));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("E-mail:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 60, -1));

        nombreField.setBackground(new java.awt.Color(255, 255, 255));
        nombreField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        nombreField.setForeground(new java.awt.Color(0, 0, 0));
        nombreField.setText("Ingrese el nombre");
        nombreField.setBorder(null);
        nombreField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreFieldMouseClicked(evt);
            }
        });
        nombreField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreFieldKeyTyped(evt);
            }
        });
        jPanel5.add(nombreField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 170, 20));

        telefonoField.setBackground(new java.awt.Color(255, 255, 255));
        telefonoField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        telefonoField.setForeground(new java.awt.Color(0, 0, 0));
        telefonoField.setText("Ingrese el telefono");
        telefonoField.setBorder(null);
        telefonoField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoFieldMouseClicked(evt);
            }
        });
        telefonoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoFieldKeyTyped(evt);
            }
        });
        jPanel5.add(telefonoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 170, 20));

        emailField.setBackground(new java.awt.Color(255, 255, 255));
        emailField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        emailField.setForeground(new java.awt.Color(0, 0, 0));
        emailField.setText("Ingrese el email");
        emailField.setBorder(null);
        emailField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailFieldMouseClicked(evt);
            }
        });
        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailFieldKeyTyped(evt);
            }
        });
        jPanel5.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 170, 20));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Teléfono: ");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Retribución:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, -1));

        ingresarBtn1.setBackground(new java.awt.Color(0, 0, 0));
        ingresarBtn1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        ingresarBtn1.setForeground(new java.awt.Color(0, 0, 0));
        ingresarBtn1.setText("Añadir");
        ingresarBtn1.setBorder(null);
        ingresarBtn1.setContentAreaFilled(false);
        ingresarBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingresarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBtn1ActionPerformed(evt);
            }
        });
        jPanel5.add(ingresarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 80, 20));

        titulacionField.setBackground(new java.awt.Color(255, 255, 255));
        titulacionField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        titulacionField.setForeground(new java.awt.Color(0, 0, 0));
        titulacionField.setText("Ingrese la titulación");
        titulacionField.setBorder(null);
        titulacionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titulacionFieldMouseClicked(evt);
            }
        });
        titulacionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                titulacionFieldKeyTyped(evt);
            }
        });
        jPanel5.add(titulacionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 150, 20));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Titulación:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 70, 20));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Jornada:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 60, 20));

        jornadaOpcionCombo.setBackground(new java.awt.Color(255, 255, 255));
        jornadaOpcionCombo.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jornadaOpcionCombo.setForeground(new java.awt.Color(0, 0, 0));
        jornadaOpcionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completa", "Parcial", "Ambas" }));
        jornadaOpcionCombo.setToolTipText("");
        jornadaOpcionCombo.setBorder(null);
        jornadaOpcionCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(jornadaOpcionCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 170, -1));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Foto:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 40, -1));

        agregarFotoBtn.setBackground(new java.awt.Color(0, 0, 0));
        agregarFotoBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        agregarFotoBtn.setForeground(new java.awt.Color(0, 0, 0));
        agregarFotoBtn.setText("Seleccionar foto");
        agregarFotoBtn.setBorder(null);
        agregarFotoBtn.setContentAreaFilled(false);
        agregarFotoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarFotoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarFotoBtnActionPerformed(evt);
            }
        });
        jPanel5.add(agregarFotoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 140, 30));

        ubicacionFotoField.setBackground(new java.awt.Color(255, 255, 255));
        ubicacionFotoField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        ubicacionFotoField.setForeground(new java.awt.Color(0, 0, 0));
        ubicacionFotoField.setBorder(null);
        jPanel5.add(ubicacionFotoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 210, 20));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Puntuación:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 80, 20));

        puntuacionField.setBackground(new java.awt.Color(255, 255, 255));
        puntuacionField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        puntuacionField.setForeground(new java.awt.Color(0, 0, 0));
        puntuacionField.setText("Ingrese la puntuación");
        puntuacionField.setBorder(null);
        puntuacionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                puntuacionFieldMouseClicked(evt);
            }
        });
        puntuacionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                puntuacionFieldKeyTyped(evt);
            }
        });
        jPanel5.add(puntuacionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 150, 20));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Habilidad:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 70, -1));

        habilidadField.setBackground(new java.awt.Color(255, 255, 255));
        habilidadField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        habilidadField.setForeground(new java.awt.Color(0, 0, 0));
        habilidadField.setText("Ingrese la habilidad");
        habilidadField.setBorder(null);
        habilidadField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habilidadFieldMouseClicked(evt);
            }
        });
        habilidadField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                habilidadFieldKeyTyped(evt);
            }
        });
        jPanel5.add(habilidadField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 170, 20));

        jSeparator17.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator17.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 140, 30));

        listaTitulacion.setBackground(new java.awt.Color(255, 255, 255));
        listaTitulacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaTitulacion.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(listaTitulacion);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 150, 50));

        ingresarBtn2.setBackground(new java.awt.Color(0, 0, 0));
        ingresarBtn2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        ingresarBtn2.setForeground(new java.awt.Color(0, 0, 0));
        ingresarBtn2.setText("Añadir");
        ingresarBtn2.setBorder(null);
        ingresarBtn2.setContentAreaFilled(false);
        ingresarBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingresarBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBtn2ActionPerformed(evt);
            }
        });
        jPanel5.add(ingresarBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 80, 20));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 120, 10));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 60, 10));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 60, 20));

        jSeparator12.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 110, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 110, 10));

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 110, 10));

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 120, 10));

        jSeparator16.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator16.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 200, 10));

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator18.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 150, 20));

        jSeparator19.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator19.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 150, 10));

        agregarFrame.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 510, 530));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(756, 425));
        setMinimumSize(new java.awt.Dimension(756, 425));
        setPreferredSize(new java.awt.Dimension(501, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 520, 360));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setForeground(new java.awt.Color(0, 0, 51));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 520, 70));

        panelIngreso.setBackground(new java.awt.Color(0, 0, 51));
        panelIngreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panelIngreso.setForeground(new java.awt.Color(0, 0, 51));
        panelIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contraseña");
        panelIngreso.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 90, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario");
        panelIngreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 60, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_User_96px_2.png"))); // NOI18N
        panelIngreso.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 80));

        usuarioField.setBackground(new java.awt.Color(0, 0, 51));
        usuarioField.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        usuarioField.setForeground(new java.awt.Color(153, 153, 153));
        usuarioField.setText("Ingrese usuario");
        usuarioField.setBorder(null);
        usuarioField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioFieldMouseClicked(evt);
            }
        });
        usuarioField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuarioFieldKeyTyped(evt);
            }
        });
        panelIngreso.add(usuarioField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 170, 30));

        contraseñaField.setBackground(new java.awt.Color(0, 0, 51));
        contraseñaField.setText("Ingrese contraseña");
        contraseñaField.setBorder(null);
        contraseñaField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contraseñaFieldMouseClicked(evt);
            }
        });
        contraseñaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraseñaFieldKeyTyped(evt);
            }
        });
        panelIngreso.add(contraseñaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 170, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelIngreso.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 210, 20));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panelIngreso.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, 20));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_customer_32px_1.png"))); // NOI18N
        jLabel23.setText("jLabel23");
        panelIngreso.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 30, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Key_32px.png"))); // NOI18N
        panelIngreso.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Menu_32px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        panelIngreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        ingresarButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ingresarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/Enter_OFF.png"))); // NOI18N
        ingresarButton.setBorder(null);
        ingresarButton.setContentAreaFilled(false);
        ingresarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingresarButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/Enter_ON.png"))); // NOI18N
        ingresarButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/Enter_ON.png"))); // NOI18N
        ingresarButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/Enter_ON.png"))); // NOI18N
        ingresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarButtonActionPerformed(evt);
            }
        });
        panelIngreso.add(ingresarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 110, 40));

        crearUsuarioBtn.setBackground(new java.awt.Color(255, 255, 255));
        crearUsuarioBtn.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        crearUsuarioBtn.setForeground(new java.awt.Color(255, 255, 255));
        crearUsuarioBtn.setText("¿Aun no eres miembro? Registrate");
        crearUsuarioBtn.setBorder(null);
        crearUsuarioBtn.setContentAreaFilled(false);
        crearUsuarioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearUsuarioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioBtnActionPerformed(evt);
            }
        });
        panelIngreso.add(crearUsuarioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 220, 30));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        panelIngreso.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 200, 20));

        cerrarFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Multiply_32px.png"))); // NOI18N
        cerrarFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarFrameMouseClicked(evt);
            }
        });
        panelIngreso.add(cerrarFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 40, -1, 30));

        getContentPane().add(panelIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarButtonActionPerformed
//Accesibilidad 
        if (usuario.dameUsuario(usuarioField.getText(), contraseñaField.getText(), "Evaluador")) {
            new Empresa().setVisible(true);
            this.dispose();
        } else if (usuario.dameUsuario(usuarioField.getText(), contraseñaField.getText(), "Usuario")) {
            solicitantes.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_ingresarButtonActionPerformed

    private void agregarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTablaActionPerformed
//Muestre la tabla y agregar solicitantes
        nombreField.setText("Ingrese el nombre");
        emailField.setText("Ingrese el email");
        titulacionField.setText("Ingrese la titulación");
        telefonoField.setText("Ingrese el telefono");
        retribucionField.setText("Ingrese la retribución");
        habilidadField.setText("Ingrese la habilidad");
        puntuacionField.setText("Ingrese la puntuación");
        ubicacionFotoField.setText("");
        Foto = null;
        
        agregarFrame.setLocationRelativeTo(null);
        agregarFrame.setVisible(true);
        

    }//GEN-LAST:event_agregarTablaActionPerformed

    private void agregarSolicitanteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSolicitanteBotonActionPerformed
        //Frame para agregar datos del solicitante

        boolean vacio = false, vacioFoto = false;
        long telefono = 0;
        long retribucion = 0;
        DefaultTableModel model = (DefaultTableModel) solicitantesTable.getModel();
        
        String nombre = nombreField.getText();
        if (nombreField.getText().isEmpty()) {
            vacio = true;
        }
        
        String email = emailField.getText();
        if (emailField.getText().isEmpty()) {
            vacio = true;
        }
        
        String jornada = (String) jornadaOpcionCombo.getSelectedItem();
        
        if (telefonoField.getText().isEmpty()) {
            vacio = true;
        } else {
            telefono = Integer.parseInt(telefonoField.getText());
        }
        
        Object foto = Foto;
        if (Foto == null) {
            vacio = true;
        }
        
        if (retribucionField.getText().isEmpty()) {
            vacio = true;
        } else {
            retribucion = Long.parseLong(retribucionField.getText());
        }
        
        List<String> titulacion = listaTitulacion.getSelectedValuesList();
        if (titulacion.isEmpty() || titulacion.size() < 2) {
            vacio = true;
        }
        List<String> habilidadPun = listaHabilidad.getSelectedValuesList();
        if (habilidadPun.isEmpty() || habilidadPun.size() < 3) {
            vacio = true;
        }
        
        if (vacio || vacioFoto) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            model.addRow(new Object[]{nombre, email, telefono, retribucion, foto, jornada, titulacion, habilidadPun});
            agregarFrame.setVisible(false);
        }
        

    }//GEN-LAST:event_agregarSolicitanteBotonActionPerformed

    private void guardarTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarTableActionPerformed
//Creación del archivo de solicitantes 
        archivo = new File("./Solicitantes.txt");
        
        DefaultTableModel model = (DefaultTableModel) solicitantesTable.getModel();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            
            int filas = solicitantesTable.getRowCount();
            
            for (int i = 0; i < filas; i++) {
                
                Object nombre = model.getValueAt(i, 0);
                Object email = model.getValueAt(i, 1);
                Object telefono = model.getValueAt(i, 2);
                Object retribucion = model.getValueAt(i, 3);
                Object foto = model.getValueAt(i, 4);
                Object jornada = model.getValueAt(i, 5);
                Object titulacion = model.getValueAt(i, 6).toString();
                Object habilidad = model.getValueAt(i, 7).toString();
                
                bw.write(nombre + "," + email + "," + telefono + "," + retribucion + ","
                        + foto + "," + jornada + "," + titulacion + "," + habilidad);
                
                bw.newLine();
            }
            
        } catch (Exception e) {
            
        }

    }//GEN-LAST:event_guardarTableActionPerformed

    private void agregarFotoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFotoBtnActionPerformed
        //Escoger una foto
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos.jpg", "jpeg", "png", "jpg", "jpeg", "png");
        
        fileChooser.setFileFilter(filter);
        
        int op = fileChooser.showOpenDialog(null);
        
        if (op == JFileChooser.APPROVE_OPTION) {
            
            Foto = fileChooser.getSelectedFile();//Lugar
            ubicacionFotoField.setText(Foto.getAbsolutePath());
            
        }

    }//GEN-LAST:event_agregarFotoBtnActionPerformed

    private void telefonoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoFieldKeyTyped
//Validar que el usuario digite solo números en el campo de telefono
        char car = evt.getKeyChar();
        String largo = telefonoField.getText();
        
        if (car < '0' || car > '9') {
            evt.consume();
        }
        
        if (largo.length() > 16) {
            evt.consume();
        }

    }//GEN-LAST:event_telefonoFieldKeyTyped

    private void nombreFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreFieldKeyTyped
//Validar que el usuario digite solo letras en el campo de nombre
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puede digitar letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_nombreFieldKeyTyped

    private void retribucionFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_retribucionFieldKeyTyped
//Validar que solo sean números en el campo de retribución
        char car = evt.getKeyChar();
        
        if (car < '0' || car > '9') {
            evt.consume();
        }

    }//GEN-LAST:event_retribucionFieldKeyTyped

    private void titulacionFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titulacionFieldKeyTyped
//Validar lo que el usuario digite en el campo de titulación, que solo sean letras
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puede digitar letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_titulacionFieldKeyTyped

    private void puntuacionFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_puntuacionFieldKeyTyped
//Hace que el usuario no digite letras en el campo de la puntuación y la longitud no sea mayor a 1
        char car = evt.getKeyChar();
        String largo = puntuacionField.getText();
        
        if (car < '1' || car > '5') {
            evt.consume();
        }
        if (largo.length() > 0) {
            evt.consume();
        }

    }//GEN-LAST:event_puntuacionFieldKeyTyped

    private void habilidadFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_habilidadFieldKeyTyped
//Validar lo que teclea el usuario en habilidad
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puede digitar letras", "Error", JOptionPane.WARNING_MESSAGE);
        }
        

    }//GEN-LAST:event_habilidadFieldKeyTyped

    private void emailFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyTyped
//Validar lo que teclea el usuario en su email
        String teclas = String.valueOf(evt.getKeyChar());
        
        if (!(teclas.matches("[a-zA-Z0-9._@-]"))) {
            evt.consume();
        }

    }//GEN-LAST:event_emailFieldKeyTyped

    private void usuarioFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioFieldKeyTyped
//Validar lo que teclea el usuario al momento de ingresar
        String teclas = String.valueOf(evt.getKeyChar());
        
        if (!(teclas.matches("[a-zA-Z0-9]"))) {
            evt.consume();
        }

    }//GEN-LAST:event_usuarioFieldKeyTyped

    private void contraseñaFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaFieldKeyTyped
//Validar lo que teclea el usuario en su contraseña
        String teclas = String.valueOf(evt.getKeyChar());
        
        if (!(teclas.matches("[a-zA-Z0-9]"))) {
            evt.consume();
        }

    }//GEN-LAST:event_contraseñaFieldKeyTyped

    private void cargarDatosSolicitantesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDatosSolicitantesBtnActionPerformed
//Cargar los datos que estan en el archivo a la tabla para que se muestren
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos.txt", "text", "TEXT", "txt");
        
        fileChooser.setFileFilter(filter);
        int op = fileChooser.showOpenDialog(this);
        
        if (op == fileChooser.APPROVE_OPTION) {
            archivo = fileChooser.getSelectedFile();
            
            nombreArchivoField.setText(archivo.getAbsolutePath());
            
            DefaultTableModel model = (DefaultTableModel) solicitantesTable.getModel();
            
            try (Scanner leer = new Scanner(archivo)) {
                while (leer.hasNextLine()) {
                    String linea = leer.nextLine();
                    
                    String[] datos = linea.split(",");
                    
                    String nombre = datos[0];
                    String email = datos[1];
                    long telefono = Long.parseLong(datos[2]);
                    long retribucion = Long.parseLong(datos[3]);
                    Object foto = datos[4];
                    String jornada = datos[5];
                    String titulacion = (datos[6] + datos[7]);
                    String habilidad = (datos[8] + datos[9] + datos[10] + datos[11] + datos[12] + datos[13]);
                    
                    model.addRow(new Object[]{nombre, email, telefono, retribucion, foto, jornada, titulacion,
                        habilidad});
                    
                }
                
            } catch (Exception e) {
                
            }
        }
        

    }//GEN-LAST:event_cargarDatosSolicitantesBtnActionPerformed

    private void eliminarSolicitanteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarSolicitanteBtnActionPerformed
//Borrar un solicitante
        DefaultTableModel model = (DefaultTableModel) solicitantesTable.getModel();
        
        int fila = solicitantesTable.getSelectedRow();
        
        model.removeRow(fila);

    }//GEN-LAST:event_eliminarSolicitanteBtnActionPerformed

    private void crearUsuarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioBtnActionPerformed
//Muestra el frame para crear un usuario
        CreacionUsuario usuario = new CreacionUsuario();
        
        usuario.dameCreacionUsuarioField().setText("Ingrese el nombre de usuario");
        usuario.dameCreacionContraseñaField().setText("Ingrese la contraseña de usuario");
        new CreacionUsuario().setVisible(true);
        

    }//GEN-LAST:event_crearUsuarioBtnActionPerformed

    private void ingresarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBtn1ActionPerformed
        //Sirve para agregar titulaciones a la lista
        
        DefaultListModel model = (DefaultListModel) listaTitulacion.getModel();
        
        if (model.getSize() < 2) {
            if (!titulacionField.getText().isEmpty()) {
                String titulacion = titulacionField.getText();
                ptr = Agregartit(ptr, titulacion);
                MostrarLista(ptr);
            } else {
                JOptionPane.showMessageDialog(null, "No ha incluido ninguna titulacion", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo puede agregar 2 titulaciones", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ingresarBtn1ActionPerformed

    private void ingresarBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBtn2ActionPerformed
//Sirve para agregar habilidades y una respectiva puntuación a la lista
        DefaultListModel model = (DefaultListModel) listaHabilidad.getModel();
        
        if (model.getSize() < 3) {
            if (!habilidadField.getText().isEmpty() && !puntuacionField.getText().isEmpty()) {
                String habilidad = habilidadField.getText();
                int nivel = Integer.parseInt(puntuacionField.getText());
                ptr2 = agregarHabilidad(ptr2, habilidad, nivel);
                mostrarListaHabilidad(ptr2);
            } else {
                JOptionPane.showMessageDialog(null, "Complete los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo puede ingresar 3 habilidad", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ingresarBtn2ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
//Desde el login
        AnimationClass cerrar = new AnimationClass();
        //Se desplaza hacia la derecha
        cerrar.jLabelXRight(-30, 10, 10, 5, cerrarFrame);

        //Se desplaza hacia la izquierda
        AnimationClass cerrarf = new AnimationClass();
        cerrarf.jLabelXLeft(10, -30, 10, 5, cerrarFrame);
        

    }//GEN-LAST:event_jLabel3MouseClicked

    private void cerrarFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarFrameMouseClicked
//Cierra el programa una vez se doble clickea al icono de cerrar 
        if (evt.getClickCount() == 2) {
            System.exit(0);
        }
        
    }//GEN-LAST:event_cerrarFrameMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
//Desde el frame de soliciantes
        AnimationClass cerrar = new AnimationClass();
        AnimationClass retroceder = new AnimationClass();
        //Se desplaza hacia la derecha
        retroceder.jLabelXRight(-30, 10, 10, 5, retrocederFrame);
        cerrar.jLabelXRight(-30, 10, 10, 5, cerrarF);

        //Se desplaza hacia la izquierda
        AnimationClass cerrarf = new AnimationClass();
        AnimationClass retrocederr = new AnimationClass();
        
        retrocederr.jLabelXLeft(10, -30, 10, 5, retrocederFrame);
        cerrarf.jLabelXLeft(10, -30, 10, 5, cerrarF);
        

    }//GEN-LAST:event_jLabel6MouseClicked

    private void retrocederFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retrocederFrameMouseClicked
//Retrocede al frame inicial 
        if (evt.getClickCount() == 2) {
            usuarioField.setText("Ingrese usuario");
            contraseñaField.setText("Ingrese contraseña");
            this.setVisible(true);
            solicitantes.dispose();
        }
        
    }//GEN-LAST:event_retrocederFrameMouseClicked

    private void cerrarFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarFMouseClicked
//Cierra el programa
        if (evt.getClickCount() == 2) {
            System.exit(0);
        }
        
    }//GEN-LAST:event_cerrarFMouseClicked

    private void nombreFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreFieldMouseClicked
//Una vez clickea el campo borrro en el campo del nombre
        if (evt.getClickCount() == 1) {
            nombreField.setText("");
        }
        
    }//GEN-LAST:event_nombreFieldMouseClicked

    private void emailFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailFieldMouseClicked
//Una vez clickea el campo borrro en el campo del email
        if (evt.getClickCount() == 1) {
            emailField.setText("");
        }

    }//GEN-LAST:event_emailFieldMouseClicked

    private void telefonoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoFieldMouseClicked
//Una vez clickea el campo borrro en el campo del telefono
        if (evt.getClickCount() == 1) {
            telefonoField.setText("");
        }
        
    }//GEN-LAST:event_telefonoFieldMouseClicked

    private void retribucionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retribucionFieldMouseClicked
//Una vez clickea el campo borrro en el campo de la retribución
        if (evt.getClickCount() == 1) {
            retribucionField.setText("");
        }
        
    }//GEN-LAST:event_retribucionFieldMouseClicked

    private void titulacionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titulacionFieldMouseClicked
//Una vez clickea el campo borrro en el campo de la titulación
        if (evt.getClickCount() == 1) {
            titulacionField.setText("");
        }
        
    }//GEN-LAST:event_titulacionFieldMouseClicked

    private void habilidadFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habilidadFieldMouseClicked
//Una vez clickea el campo borrro en el campo de la habilidad
        if (evt.getClickCount() == 1) {
            habilidadField.setText("");
        }
        
    }//GEN-LAST:event_habilidadFieldMouseClicked

    private void puntuacionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puntuacionFieldMouseClicked
//Una vez clickea el campo borrro en el campo de la puntuación
        if (evt.getClickCount() == 1) {
            puntuacionField.setText("");
        }

    }//GEN-LAST:event_puntuacionFieldMouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked

//Desde el frame para agregar solicitantes
        AnimationClass cerrar = new AnimationClass();
        AnimationClass cambior = new AnimationClass();
        AnimationClass retroceder = new AnimationClass();
        //Se desplaza hacia la derecha
        retroceder.jLabelXRight(-30, 10, 10, 5, devolverseFrame);
        cambior.jLabelXRight(-30, 10, 10, 5, usuarioCambio);
        cerrar.jLabelXRight(-30, 10, 10, 5, cerrarTodo);

        //Se desplaza hacia la izquierda
        AnimationClass cerrarf = new AnimationClass();
        AnimationClass cambio = new AnimationClass();
        AnimationClass retrocederr = new AnimationClass();
        
        retrocederr.jLabelXLeft(10, -30, 10, 5, devolverseFrame);
        cambio.jLabelXLeft(10, -30, 10, 5, usuarioCambio);
        cerrarf.jLabelXLeft(10, -30, 10, 5, cerrarTodo);
        

    }//GEN-LAST:event_jLabel16MouseClicked

    private void usuarioFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioFieldMouseClicked
//Pone el campo vacio al momento de digitar el usuario
        if (evt.getClickCount() == 1) {
            usuarioField.setText("");
        }
        
    }//GEN-LAST:event_usuarioFieldMouseClicked

    private void contraseñaFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseñaFieldMouseClicked
//Pone el campo vacio al momento de digitar la contraseña 
        if (evt.getClickCount() == 1) {
            contraseñaField.setText("");
        }
        
    }//GEN-LAST:event_contraseñaFieldMouseClicked

    private void usuarioCambioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioCambioMouseClicked
//Cambia inmediatamente al frame inicial
        if (evt.getClickCount() == 2) {
            agregarFrame.dispose();
            solicitantes.dispose();
            this.setVisible(true);
            usuarioField.setText("Ingrese usuario");
            contraseñaField.setText("Ingrese contraseña");
        }

    }//GEN-LAST:event_usuarioCambioMouseClicked

    private void cerrarTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarTodoMouseClicked
//Cierra todo el programa
        if (evt.getClickCount() == 2) {
            System.exit(0);
        }
        
    }//GEN-LAST:event_cerrarTodoMouseClicked

    private void devolverseFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devolverseFrameMouseClicked
//Devuelve al frame donde estan todos los soliciantes inscritos
        if (evt.getClickCount() == 2) {
            agregarFrame.dispose();
            solicitantes.setVisible(true);
        }
        
    }//GEN-LAST:event_devolverseFrameMouseClicked
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HumanWare.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HumanWare.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HumanWare.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HumanWare.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HumanWare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarFotoBtn;
    private javax.swing.JFrame agregarFrame;
    private javax.swing.JButton agregarSolicitanteBoton;
    private javax.swing.JButton agregarTabla;
    private javax.swing.JButton cargarDatosSolicitantesBtn;
    private javax.swing.JLabel cerrarF;
    private javax.swing.JLabel cerrarFrame;
    private javax.swing.JLabel cerrarTodo;
    private javax.swing.JPasswordField contraseñaField;
    private javax.swing.JButton crearUsuarioBtn;
    private javax.swing.JLabel devolverseFrame;
    private javax.swing.JButton eliminarSolicitanteBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton guardarTable;
    private javax.swing.JTextField habilidadField;
    private javax.swing.JButton ingresarBtn1;
    private javax.swing.JButton ingresarBtn2;
    private javax.swing.JButton ingresarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JComboBox<String> jornadaOpcionCombo;
    private javax.swing.JList<String> listaHabilidad;
    private javax.swing.JList<String> listaTitulacion;
    private javax.swing.JTextField nombreArchivoField;
    private javax.swing.JTextField nombreField;
    private javax.swing.JPanel panelIngreso;
    private javax.swing.JTextField puntuacionField;
    private javax.swing.JTextField retribucionField;
    private javax.swing.JLabel retrocederFrame;
    private javax.swing.JFrame solicitantes;
    private javax.swing.JTable solicitantesTable;
    private javax.swing.JTextField telefonoField;
    private javax.swing.JTextField titulacionField;
    private javax.swing.JTextField ubicacionFotoField;
    private javax.swing.JLabel usuarioCambio;
    private javax.swing.JTextField usuarioField;
    // End of variables declaration//GEN-END:variables
}