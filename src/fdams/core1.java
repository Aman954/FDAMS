/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fdams;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author LENOVO
 */
public class core1 extends javax.swing.JFrame {

    /**
     * Creates new form core
     */
    
    
    public core1() {
        initComponents();
        fetchCourse();
    }
    
    
   
    
    DefaultTableModel model;
    
    
    void fetchCourse()
    {
    try
       {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fdams","root","");
        String sql="select * from course";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        ResultSet get=stmt.executeQuery();
        while(get.next())
        {
            int id=get.getInt("id");
            String cor=get.getString("courses");
            String dura=get.getString("duration");
            int fees=get.getInt("fee");
            String bran=get.getString("subcourse");
            
            Object[] obj={id,cor,fees,bran,dura};
            model=(DefaultTableModel)tbl_data.getModel();
            model.addRow(obj);
        }
       }
       catch(HeadlessException | ClassNotFoundException | SQLException e)
       {
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
        tbl_data = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        duration = new javax.swing.JTextField();
        core = new javax.swing.JTextField();
        branch = new javax.swing.JTextField();
        setup = new javax.swing.JButton();
        update = new javax.swing.JButton();
        d = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        oi = new javax.swing.JLabel();
        fh = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Course", "Fee", "Branch", "Duration"
            }
        ));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 640, 550));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Duration :");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 30));

        jButton1.setBackground(new java.awt.Color(0, 51, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/delete.png"))); // NOI18N
        jButton1.setText(" Delete");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 110, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Course :");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Branch :");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 30));
        jPanel5.add(duration, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, 30));
        jPanel5.add(core, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, 30));
        jPanel5.add(branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 140, 30));

        setup.setBackground(new java.awt.Color(0, 102, 51));
        setup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setup.setForeground(new java.awt.Color(255, 255, 255));
        setup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/login.png"))); // NOI18N
        setup.setText(" Set Up fee");
        setup.setBorder(null);
        setup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setupActionPerformed(evt);
            }
        });
        jPanel5.add(setup, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 120, 40));

        update.setBackground(new java.awt.Color(51, 0, 51));
        update.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/update.png"))); // NOI18N
        update.setText(" Update");
        update.setBorder(null);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel5.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 120, 40));

        d.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel5.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, 30));

        add1.setBackground(new java.awt.Color(102, 0, 0));
        add1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add1.setForeground(new java.awt.Color(255, 255, 255));
        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/add2.png"))); // NOI18N
        add1.setText(" Add");
        add1.setBorder(null);
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel5.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 110, 40));
        jPanel5.add(oi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        fh.setForeground(new java.awt.Color(0, 102, 102));
        jPanel5.add(fh, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 20, 10));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 350, 550));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("COURSES");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 140, 50));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 160, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/back-button.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 100));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 820));

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 290, 80));

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

        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 290, 80));

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

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 290, 80));

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/view all record.png"))); // NOI18N
        jLabel5.setText("   REPORT");
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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 290, 80));

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

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 630, 290, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 400, 820));

        setSize(new java.awt.Dimension(1466, 823));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    void feeDeletion(String cor,String dura)
    {
    int n=Integer.parseInt(dura);
    try
       {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fdams","root","");
        
        for(int i=1;i<=n;i++)
        {
        String sql="drop table "+cor+i;
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        }
       }
       catch(HeadlessException | ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
    
    }
    
    
    
    void deleteRecord(String cor,String dura)
    {
    try
       {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fdams","root","");
        String sql="delete from course where courses=?";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,cor);
        int get=stmt.executeUpdate();
        if(get>0)
        {
        JOptionPane.showMessageDialog(this,"Course and its fee structure has been deleted Successfully!");
        feeDeletion(cor,dura);
        clearTable();
        fetchCourse();
        }
        else 
        {
        JOptionPane.showMessageDialog(this,"Some technical glitch..try again!");
        }
       }
       catch(HeadlessException | ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       if(isValida())
        {
         co=core.getText();
         du=duration.getText();

         deleteRecord(co,du);
         duration.show();
         duration.setText("");
         core.setText("");
         branch.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

     boolean isValid(String space) {
     String ePattern = ".*[^ ].*";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(space);
           return m.matches();
   }
    boolean isValidNumber(String no) {
     String ePattern = "^[1-9]+[0-9]*$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(no);
           return m.matches();
   }
    
     
     boolean courseExist(String core)
    {
       boolean res = false;
       try
       {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fdams","root","");
        String sql="select * from course where courses=?";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,core);
           ResultSet get=stmt.executeQuery();
        if(get.next())
        {
        res=true;
        }
        else 
            res=false;
       }
       catch(HeadlessException | ClassNotFoundException | SQLException e)
       {
       }
       return res;
    }
     
     
     
  
     
    
    
    String co,br,du;
    
    
    boolean isValida()
    {
    co=core.getText();
    br=branch.getText();
    du=duration.getText();
    
    if(co.equals(""))
    {
        JOptionPane.showMessageDialog(this,"Please enter your course");
        return false;
    }
    else if(br.equals(""))
    {
        JOptionPane.showMessageDialog(this,"Please enter your branch");
        return false;
    }
    else if(du.equals(""))
    {
        JOptionPane.showMessageDialog(this,"Please enter a duration");
        return false;
    }
    else if(!isValid(co) || !isValid(br) || !isValid(du) )
    {
        JOptionPane.showMessageDialog(this,"Spaces not allowed!");
        return false;
    }
    else if(!isValidNumber(du) )
    {
        JOptionPane.showMessageDialog(this,"Only Digits are allowed in duration...");
        return false;
    }
     return true;
    

    }
    
    
    boolean isValidate()
    {
    co=core.getText();
    br=branch.getText();
    du=duration.getText();
    
    if(co.equals(""))
    {
        JOptionPane.showMessageDialog(this,"Please enter your course");
        return false;
    }
    else if(br.equals(""))
    {
        JOptionPane.showMessageDialog(this,"Please enter your branch");
        return false;
    }
    else if(du.equals(""))
    {
        JOptionPane.showMessageDialog(this,"Please a duration");
        return false;
    }
    else if(!isValid(co) || !isValid(br) || !isValid(du) )
    {
        JOptionPane.showMessageDialog(this,"Spaces not allowed!");
        return false;
    }
    else if(!isValidNumber(du) )
    {
        JOptionPane.showMessageDialog(this,"Only Digits are allowed in duration...");
        return false;
    }
    else if(courseExist(co))
    {
        JOptionPane.showMessageDialog(this,"This course is already registered with us");
        return false;
    }
    
     return true;
     
    }
    
    
    void clearTable()
    {
    DefaultTableModel mode=(DefaultTableModel)tbl_data.getModel();
    mode.setRowCount(0);
    }
    
    
    void insertRecord(String cor,String branc,String dur)
    {
     try
       {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fdams","root","");
        String sql="insert into course(courses,fee,duration,subcourse) values(?,?,?,?)";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,cor);
        stmt.setInt(2,0);
        stmt.setString(3,dur);
        stmt.setString(4,branc);
        int get=stmt.executeUpdate();
        
        if(get>0)
        {
        JOptionPane.showMessageDialog(this,"Course Added Successfuly");
        clearTable();
        fetchCourse();
        core.setText("");
        branch.setText("");
        duration.setText("");
        int cyi=Integer.parseInt(dur);
        int y=1;
        while(cyi>0)
        {    
        String sqli = "CREATE TABLE "+cor+y+
                   " (id INTEGER NOT NULL AUTO_INCREMENT, " +
                   " addmission_fee INTEGER(25), " + 
                   " tuition_fee INTEGER(25), " + 
                   " soft_skill_fee INTEGER(25), " + 
                   " industrial_training_fee INTEGER(25), " + 
                   " university_fee INTEGER(25), " +
                   " internal_exam_fee INTEGER(25), " + 
                   " amount INTEGER(25), " + 
                   " PRIMARY KEY ( id ))"; 
        
        PreparedStatement stmti;
        stmti = conn.prepareStatement(sqli);
        stmti.executeUpdate(sqli);
        cyi--;
        y++;
        }
        }
        else 
        {
        JOptionPane.showMessageDialog(this,"Some technical glitch..try again!");
        }
       }
       catch(HeadlessException | ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
    
    }
    
    
    void updateRecord(String cor,String branc,String dur,int id)
    {
     try
       {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fdams","root","");
        String sql="update course set courses=?,subcourse=? where id=?";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,cor);
        stmt.setString(2,branc);
        stmt.setInt(3,id);
        int get=stmt.executeUpdate();
        
        if(get>0)
        {
        JOptionPane.showMessageDialog(this,"Course has been Updated Successfully!");
        clearTable();
        fetchCourse();
        }
        else 
        {
        JOptionPane.showMessageDialog(this,"Some technical glitch..try again!");
        }
       }
       catch(HeadlessException | ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
    }
    
    
    
    private void setupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setupActionPerformed
        // TODO add your handling code here:
        if(isValida() && Integer.parseInt(fh.getText())<1)
        {
        String cor=core.getText();    
        String dur=duration.getText();
        fee1 fe=new fee1(cor+1,dur,cor);
        fe.show();
        this.dispose();
        }
        else if(Integer.parseInt(fh.getText())>0)
        {
         JOptionPane.showMessageDialog(this,"fees already setup...");
        }
        
    }//GEN-LAST:event_setupActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        if(isValidate())
        {
         co=core.getText();
         br=branch.getText();
         du=duration.getText();
         String id=oi.getText();
         int it=Integer.parseInt(id);
         updateRecord(co,br,du,it);
         duration.show();
         duration.setText("");
         core.setText("");
         branch.setText("");
        }
    }//GEN-LAST:event_updateActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        // TODO add your handling code here:
        int rown=tbl_data.getSelectedRow();
        TableModel mod=tbl_data.getModel();
        oi.setText(mod.getValueAt(rown, 0).toString());
        oi.hide();
        core.setText(mod.getValueAt(rown, 1).toString());
        branch.setText(mod.getValueAt(rown, 3).toString());
        fh.setText(mod.getValueAt(rown, 2).toString());
        //d.setText(mod.getValueAt(rown, 4).toString());
        duration.setText(mod.getValueAt(rown, 4).toString());
        //duration.hide();
        
        
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
        if(isValidate())
        {
         co=core.getText();
         br=branch.getText();
         du=duration.getText();
        insertRecord(co,br,du);
        }
    }//GEN-LAST:event_add1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        studentfeerecord cv=new studentfeerecord();
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
        core1 c=new core1();
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
        feerec stu=new feerec();
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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        studentfeerecord fr=new studentfeerecord();
        fr.show();
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(core1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(core1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(core1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(core1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new core1().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add1;
    private javax.swing.JTextField branch;
    private javax.swing.JTextField core;
    private javax.swing.JPanel course;
    private javax.swing.JLabel d;
    private javax.swing.JTextField duration;
    private javax.swing.JLabel fh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel oi;
    private javax.swing.JButton setup;
    private javax.swing.JTable tbl_data;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
