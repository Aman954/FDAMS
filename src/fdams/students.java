/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fdams;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author LENOVO
 */
public class students extends javax.swing.JFrame {

    /**
     * Creates new form students
     */
    public students() {
        initComponents();
        
        try
       {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fdams","root","");
        String sqli="select * from course";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sqli);
        ResultSet get=stmt.executeQuery();
        while(get.next())
        {
        core.addItem(get.getString("courses"));
        }
       }
       catch(HeadlessException | ClassNotFoundException | SQLException e)
       {
       }
    }
    
    DefaultTableModel model;
    void fetchRecord()
    {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String frm = dateFormat.format(fr.getDate());
    String t=   dateFormat.format(to.getDate());
    try
       {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fdams","root","");
        String sql="select * from student where dt between ? and ? and course=?";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, frm);
        stmt.setString(2,t);
        stmt.setString(3,(String)core.getSelectedItem());
        ResultSet get=stmt.executeQuery();
        while(get.next())
        {          
            String fn=get.getString("fname");
            String ln=get.getString("lname");
            String phn=get.getString("phone");
            String crs=get.getString("course");
            String curyr=get.getString("curyr");
                    
            Object[] obj={fn,ln,phn,crs,curyr};
            model=(DefaultTableModel)record.getModel();
            model.addRow(obj);
               
         }            
           
        }
       
       catch(HeadlessException | ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        record = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt = new javax.swing.JTextField();
        fname = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        cr = new javax.swing.JLabel();
        cyr = new javax.swing.JLabel();
        paid = new javax.swing.JLabel();
        due = new javax.swing.JLabel();
        duratn = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        core = new javax.swing.JComboBox<>();
        browse = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        set = new javax.swing.JLabel();
        fr = new com.toedter.calendar.JDateChooser();
        to = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        course = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        record.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "First name", "Last name", "Phone number", "Course", "Current year"
            }
        ));
        record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(record);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 900, 420));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ALL STUDENTS");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 220, 50));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 255));
        jLabel14.setText("Select Course :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 40));

        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyReleased(evt);
            }
        });
        jPanel2.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 570, 40));

        fname.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        lname.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        phone.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        cr.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        cyr.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(cyr, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        paid.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, -1, -1));

        due.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(due, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, -1, -1));

        duratn.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(duratn, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 250, 10));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Export in Excel");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 150, 40));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Submit");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 140, 40));

        jPanel2.add(core, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 150, 40));

        browse.setBackground(new java.awt.Color(51, 0, 0));
        browse.setForeground(new java.awt.Color(255, 255, 255));
        browse.setText("Browse");
        browse.setBorder(null);
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        jPanel2.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 150, 40));

        jButton4.setBackground(new java.awt.Color(51, 51, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Download PDF");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 140, 40));

        set.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(set, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, -1, -1));
        jPanel2.add(fr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 190, 40));
        jPanel2.add(to, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 210, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("From :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 175, 60, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("To :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 1060, 820));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/home.png"))); // NOI18N
        jLabel1.setText("  HOME");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 290, 80));

        course.setBackground(new java.awt.Color(0, 51, 51));
        course.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        course.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                courseMouseMoved(evt);
            }
        });
        course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                courseMouseExited(evt);
            }
        });
        course.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/edit2.png"))); // NOI18N
        jLabel3.setText(" COURSES");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        course.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, 60));

        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 290, 80));

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/smallfee.png"))); // NOI18N
        jLabel4.setText(" FEE STRUCTURE");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 240, 80));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 290, 80));

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/about.png"))); // NOI18N
        jLabel5.setText("   STUDENTS");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 80));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 290, 80));

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/logout.png"))); // NOI18N
        jLabel21.setText("  LOG OUT");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, 60));

        jPanel10.setBackground(new java.awt.Color(0, 51, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/logout.png"))); // NOI18N
        jLabel22.setText("  LOG OUT");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, 60));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 290, 80));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 290, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 820));

        setSize(new java.awt.Dimension(1466, 823));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_recordMouseClicked

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtKeyReleased

    void clearTable()
    {
    DefaultTableModel mode=(DefaultTableModel)record.getModel();
    mode.setRowCount(1);
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(fr.getDate() == null || to.getDate() == null)
        {
        JOptionPane.showMessageDialog(this,"Please choose dates");
        }
        else
        {
        clearTable();
        fetchRecord();
        set.setText("set");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(this);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String fr = dateFormat.format(new Date());
        try
        {
            File fl=fileChooser.getSelectedFile();
            String path=fl.getAbsolutePath();
            path+="_"+fr+".xlsx";
            txt.setText(path);
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        
    }//GEN-LAST:event_browseActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
     if(!set.getText().equals(""))
     {
    MessageFormat header=new MessageFormat("Students in "+(String)core.getSelectedItem());
    MessageFormat footer=new MessageFormat("page={0,number,integer}");
    
    try
    {
    record.print(JTable.PrintMode.FIT_WIDTH,header,footer);
    }
    catch(PrinterException e)
    {
        e.getMessage();
    }
        }
        else
            JOptionPane.showMessageDialog(this,"Please Select record first");
    }//GEN-LAST:event_jButton4ActionPerformed

    
    
    void exportToExcel()
    {
    XSSFWorkbook w=new XSSFWorkbook();
    XSSFSheet ws=w.createSheet();
    DefaultTableModel modl=(DefaultTableModel) record.getModel();
    TreeMap<String,Object[]> map=new TreeMap<>();
    map.put("0",new Object[]{modl.getColumnName(0),modl.getColumnName(1),modl.getColumnName(2),modl.getColumnName(3),modl.getColumnName(4)});
    for(int i=1;i<modl.getRowCount();i++)
    {
        map.put(Integer.toString(i),new Object[]{modl.getValueAt(i,0),modl.getValueAt(i,1),modl.getValueAt(i,2),modl.getValueAt(i,3),modl.getValueAt(i,4)});
    }
    
    Set<String> id=map.keySet();
    XSSFRow row;
    int ri=0;
    for(String key:id)
    {
    row=ws.createRow(ri++);
    Object[] val=map.get(key);
    int ci=0;
    for(Object ob:val)
    {
    XSSFCell cell=row.createCell(ci++);
    cell.setCellValue(ob.toString());
    }
    }
    try(FileOutputStream fo=new FileOutputStream(new File(txt.getText())))
    {
    w.write(fo);
    JOptionPane.showMessageDialog(this,txt.getText()+" Exported Successfuly");
    }
    catch(FileNotFoundException e)
    {
    e.printStackTrace();
    }   
    catch (IOException ex)
    {
            Logger.getLogger(feerec.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
   
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(!set.getText().equals("") && !txt.getText().equals(""))
        {       
         exportToExcel();     
        }
        else 
            JOptionPane.showMessageDialog(this,"Please select or browse first");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        courses cv=new courses();
        cv.show();
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        Color col=new Color(105,105,105);
        jPanel3.setBackground(col);
        jPanel3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        Color col=new Color(0,51,51);
        jPanel3.setBackground(col);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        core c=new core();
        c.show();
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        Color col=new Color(105,105,105);
        course.setBackground(col);
        course.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        Color col=new Color(0,51,51);
        course.setBackground(col);
    }//GEN-LAST:event_jLabel3MouseExited

    private void courseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseMoved
        // TODO add your handling code here:
        course.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Color col=new Color(105,105,105);
        course.setBackground(col);
    }//GEN-LAST:event_courseMouseMoved

    private void courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseClicked
        // TODO add your handling code here:
        core cor=new core();
        cor.show();
        this.dispose();
    }//GEN-LAST:event_courseMouseClicked

    private void courseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseExited
        // TODO add your handling code here:
        Color col=new Color(0,51,51);
        course.setBackground(col);
    }//GEN-LAST:event_courseMouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        feesearch fs=new feesearch();
        fs.show();
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        Color col=new Color(105,105,105);
        jPanel6.setBackground(col);
        jPanel6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        Color col=new Color(0,51,51);
        jPanel6.setBackground(col);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        students stu=new students();
        stu.show();
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        Color col=new Color(105,105,105);
        jPanel7.setBackground(col);
        jPanel7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        Color col=new Color(0,51,51);
        jPanel7.setBackground(col);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        login lg=new login();
        lg.show();
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        // TODO add your handling code here:
        Color col=new Color(105,105,105);
        jPanel9.setBackground(col);
        jPanel9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        // TODO add your handling code here:
        Color col=new Color(0,51,51);
        jPanel9.setBackground(col);
    }//GEN-LAST:event_jLabel21MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new students().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JComboBox<String> core;
    private javax.swing.JPanel course;
    private javax.swing.JLabel cr;
    private javax.swing.JLabel cyr;
    private javax.swing.JLabel due;
    private javax.swing.JLabel duratn;
    private javax.swing.JLabel fname;
    private com.toedter.calendar.JDateChooser fr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lname;
    private javax.swing.JLabel paid;
    private javax.swing.JLabel phone;
    private javax.swing.JTable record;
    private javax.swing.JLabel set;
    private com.toedter.calendar.JDateChooser to;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}
