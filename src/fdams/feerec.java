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
public class feerec extends javax.swing.JFrame {

    /**
     * Creates new form feerec
     */
    public feerec() {
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

    
    
    String retword;
   
   
public String[] UNITPLACE = { " ", "ONE ", "TWO ", "THREE ", "FOUR ", "FIVE ", "SIX ", "SEVEN ","EIGHT ", "NINE ", "TEN ", "ELEVEN ", "TWELVE ", "THIRTEEN ", "FOURTEEN ", "FIVETEEN ", "SIXTEEN ","SEVENTEEN ", "EIGHTEEN ", "NINETEEN " }; 
 
public String[] TENPLACE = { " ", "TWENTY ", "THIRTY ", "FOURTY ", "FIVETY ", "SIXTY ", "SEVENTY ","EIGHTY ", "NINETY " }; 
 
public String[] MOREPLACE = { " ", "HUNDRED ", "THOUSAND ", "LAKH ", "CRORE ", "ARAB ","KHARAB ","NIL ","PADM ","SANKH ","MAHA SANKH "}; 
//Call this function from main method and pass no ,digit=0,len=0 
  String numberSplit(long no, int digit, int len) { 
		if (no > 0) { 
			if (len == 2) 
				numberSplit(no / 10, (int) (no % 10), len + 1); 
			else 
				numberSplit(no / 100, (int) (no % 100), len + 2); 
		} 
		if (digit > 0) 
			retword= wordPrint(digit, len); 
                
                return retword+"ONLY";
	} 
        String wrd="";
	String wordPrint(int digit, int len) { 
		if (digit < 20) 
			wrd=wrd+UNITPLACE[digit]; 
		else { 
 
			wrd=wrd+TENPLACE[(digit / 10) - 1]; 
 
			if (digit % 10 != 0) 
				wrd=wrd+UNITPLACE[digit % 10]; 
		} 
		if (len > 2) 
			wrd=wrd+MOREPLACE[len / 2]; 
                
                return wrd;
	}
    
    
    
    
    DefaultTableModel model;
    void fetchRecord()
    {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
    String fr = dateFormat.format(from.getDate());
    String t=dateFormat.format(to.getDate());
    System.out.println(fr+"  "+t);
    try
       {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fdams","root","");
        String fil=(String)filter.getSelectedItem();
       
        if(fil.equals("all"))
        {
        String sql="select * from feedetails where date between ? and ? and course=?";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, fr);
        stmt.setString(2, t);
        stmt.setString(3, (String)core.getSelectedItem());
        ResultSet get=stmt.executeQuery();
        crses.setText((String)core.getSelectedItem());
        int amount=0;
        while(get.next())
        {          
            String crs=get.getString("course");
            String fn=get.getString("first");
            String ln=get.getString("last");
            String phn=get.getString("phone");
            int pad=get.getInt("paid");
            int dues=get.getInt("due");
            int ex=Math.abs(get.getInt("excess"));
            Date date = get.getDate("date"); 
            String rno=get.getString("no");  
            String strDate = dateFormat.format(date);  
            Object[] obj={fn,ln,phn,pad,dues,ex,strDate,crs,rno};
            model=(DefaultTableModel)record.getModel();
            model.addRow(obj);
            amount=amount+get.getInt("paid");   
         } 
        received.setText(Integer.toString(amount));
        inw.setText(numberSplit(amount,0,0));
        }
        else if(fil.equals("due"))
        {
        String sql="select * from feedetails where date between ? and ? and course=? and due>?";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, fr);
        stmt.setString(2, t);
        stmt.setString(3, (String)core.getSelectedItem());
        stmt.setInt(4, 0);
        ResultSet get=stmt.executeQuery();
        crses.setText((String)core.getSelectedItem());
        int amount=0;
        while(get.next())
        {          
            String crs=get.getString("course");
            String fn=get.getString("first");
            String ln=get.getString("last");
            String phn=get.getString("phone");
            int pad=get.getInt("paid");
            int dues=get.getInt("due");
            int ex=Math.abs(get.getInt("excess"));
            Date date = get.getDate("date"); 
            String rno=get.getString("no");  
            String strDate = dateFormat.format(date);  
            Object[] obj={fn,ln,phn,pad,dues,ex,strDate,crs,rno};
            model=(DefaultTableModel)record.getModel();
            model.addRow(obj);
            amount=amount+get.getInt("paid");
         } 
        received.setText(Integer.toString(amount));
        inw.setText(numberSplit(amount,0,0));
        }
        else if(fil.equals("excess"))
        {
        String sql="select * from feedetails where date between ? and ? and course=? and excess>?";
        PreparedStatement stmt;
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, fr);
        stmt.setString(2, t);
        stmt.setString(3, (String)core.getSelectedItem());
        stmt.setInt(4, 0);
        ResultSet get=stmt.executeQuery();
         crses.setText((String)core.getSelectedItem());
        int amount=0;
        while(get.next())
        {          
            String crs=get.getString("course");
            String fn=get.getString("first");
            String ln=get.getString("last");
            String phn=get.getString("phone");
            int pad=get.getInt("paid");
            int dues=get.getInt("due");
            int ex=Math.abs(get.getInt("excess"));
            Date date = get.getDate("date"); 
            String rno=get.getString("no");  
            String strDate = dateFormat.format(date);  
            Object[] obj={fn,ln,phn,pad,dues,ex,strDate,crs,rno};
            model=(DefaultTableModel)record.getModel();
            model.addRow(obj);
            amount=amount+get.getInt("paid");

         } 
        received.setText(Integer.toString(amount));
        inw.setText(numberSplit(amount,0,0));
        }
                   
           
        }
       
       catch(HeadlessException | ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
    
    }
    
    void clearTable()
    {
    DefaultTableModel mode=(DefaultTableModel)record.getModel();
    mode.setRowCount(1);
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
        fname = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        cr = new javax.swing.JLabel();
        cyr = new javax.swing.JLabel();
        paid = new javax.swing.JLabel();
        due = new javax.swing.JLabel();
        duratn = new javax.swing.JLabel();
        filter = new javax.swing.JComboBox<>();
        from = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        to = new com.toedter.calendar.JDateChooser();
        export = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        txt = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        core = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        received = new javax.swing.JLabel();
        inw = new javax.swing.JLabel();
        crses = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        set = new javax.swing.JLabel();
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
        jLabel24 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        record.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "First", "Last", "Phone", "Paid", "Due", "Excess", "Date", "Course", "R.No"
            }
        ));
        record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(record);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 900, 400));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fee Record");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 170, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 255));
        jLabel14.setText("Filter :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, 40));

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

        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "due", "excess" }));
        jPanel2.add(filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 150, 40));
        jPanel2.add(from, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 140, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 255, 255));
        jLabel16.setText("From :");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 30));
        jPanel2.add(to, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 140, 30));

        export.setBackground(new java.awt.Color(153, 0, 51));
        export.setForeground(new java.awt.Color(255, 255, 255));
        export.setText("Export to Excel");
        export.setBorder(null);
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });
        jPanel2.add(export, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 130, 30));

        submit.setBackground(new java.awt.Color(0, 0, 51));
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Submit");
        submit.setBorder(null);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel2.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 130, 40));
        jPanel2.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 360, 30));

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Print");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 130, 40));

        jPanel2.add(core, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 140, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 255, 255));
        jLabel17.setText("To");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, 30));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        received.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        received.setForeground(new java.awt.Color(204, 0, 204));
        jPanel8.add(received, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, 30));

        inw.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inw.setForeground(new java.awt.Color(204, 0, 204));
        inw.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.add(inw, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 280, 30));

        crses.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        crses.setForeground(new java.awt.Color(204, 0, 204));
        jPanel8.add(crses, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 255, 255));
        jLabel21.setText("In Words :");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 255, 255));
        jLabel22.setText("Amount Received :");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 255, 255));
        jLabel23.setText("Course selected :");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 320, 230));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 255, 255));
        jLabel18.setText("Course :");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 30));

        browse.setBackground(new java.awt.Color(102, 0, 51));
        browse.setForeground(new java.awt.Color(255, 255, 255));
        browse.setText("Browse");
        browse.setBorder(null);
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        jPanel2.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 90, 30));

        set.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(set, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 1050, 820));

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

        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 290, 80));

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

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 290, 80));

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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 290, 80));

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/logout.png"))); // NOI18N
        jLabel24.setText("  LOG OUT");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, 60));

        jPanel10.setBackground(new java.awt.Color(0, 51, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/logout.png"))); // NOI18N
        jLabel25.setText("  LOG OUT");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, 60));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 290, 80));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 290, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 820));

        setSize(new java.awt.Dimension(1466, 823));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordMouseClicked
        // TODO add your handling code here:
       /* int rown=record.getSelectedRow();
        TableModel mod=record.getModel();
        String fn=mod.getValueAt(rown, 0).toString();
        String ln=mod.getValueAt(rown, 1).toString();
        String ph=mod.getValueAt(rown, 2).toString();
        String crs=mod.getValueAt(rown, 3).toString();
        String cyrs=mod.getValueAt(rown, 4).toString();
        String pai=mod.getValueAt(rown, 5).toString();
        String du=mod.getValueAt(rown, 6).toString();
        String drn=mod.getValueAt(rown, 7).toString();

        fname.setText(fn);
        lname.setText(ln);
        phone.setText(ph);
        cr.setText(crs);
        cyr.setText(cyrs);
        paid.setText(pai);
        due.setText(du);
        duratn.setText(drn);*/
    }//GEN-LAST:event_recordMouseClicked

    
    boolean isValidation()
    {
    if(from.getDate() == null || to.getDate()==null)
    {
    JOptionPane.showMessageDialog(this,"Please select dates");
    return false;
    }
    return true;
    }
    
    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        if(isValidation())
        {
        clearTable();    
        fetchRecord();
        set.setText("st");
        }
    }//GEN-LAST:event_submitActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    if(isValidation() && !"".equals(set.getText()))    
    {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
    String fr = dateFormat.format(from.getDate());
    String t=   dateFormat.format(to.getDate()); 
     
    MessageFormat header=new MessageFormat("Report from "+fr+" to "+t);
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
    else if(set.getText().equals(""))
        JOptionPane.showMessageDialog(this,"Please select record first");
    }//GEN-LAST:event_jButton3ActionPerformed

    
    void exportToExcel()
    {
    XSSFWorkbook w=new XSSFWorkbook();
    XSSFSheet ws=w.createSheet();
    DefaultTableModel modl=(DefaultTableModel) record.getModel();
    TreeMap<String,Object[]> map=new TreeMap<>();
    map.put("0",new Object[]{modl.getColumnName(0),modl.getColumnName(1),modl.getColumnName(2),modl.getColumnName(3),modl.getColumnName(4),modl.getColumnName(5),modl.getColumnName(6),modl.getColumnName(7),modl.getColumnName(8)});
    for(int i=1;i<modl.getRowCount();i++)
    {
        map.put(Integer.toString(i),new Object[]{modl.getValueAt(i,0),modl.getValueAt(i,1),modl.getValueAt(i,2),modl.getValueAt(i,3),modl.getValueAt(i,4),modl.getValueAt(i,5),modl.getValueAt(i,6),modl.getValueAt(i,7),modl.getValueAt(i,8)});
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
    try
    {
    FileOutputStream fo=new FileOutputStream(new File(txt.getText()));
    w.write(fo);
    fo.close();
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
    
    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        // TODO add your handling code here:
        
         if(isValidation() && !"".equals(set.getText()) && !browse.getText().equals(""))
        {
            exportToExcel();
        }
         else if(set.getText().equals(""))
          JOptionPane.showMessageDialog(this,"Please select record first");
         else if(browse.getText().equals(""))
          JOptionPane.showMessageDialog(this,"Please browse or create file first");
        
        
    }//GEN-LAST:event_exportActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
        if(isValidation() && !"".equals(set.getText()))
        {
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
        }
         else if(set.getText().equals(""))
        JOptionPane.showMessageDialog(this,"Please select record first");
    }//GEN-LAST:event_browseActionPerformed

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
        feesearch1 fs=new feesearch1();
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

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        login lg=new login();
        lg.show();
        this.dispose();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        // TODO add your handling code here:
        Color col=new Color(105,105,105);
        jPanel9.setBackground(col);
        jPanel9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        // TODO add your handling code here:
        Color col=new Color(0,51,51);
        jPanel9.setBackground(col);
    }//GEN-LAST:event_jLabel24MouseExited

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
            java.util.logging.Logger.getLogger(feerec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(feerec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(feerec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(feerec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new feerec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JComboBox<String> core;
    private javax.swing.JPanel course;
    private javax.swing.JLabel cr;
    private javax.swing.JLabel crses;
    private javax.swing.JLabel cyr;
    private javax.swing.JLabel due;
    private javax.swing.JLabel duratn;
    private javax.swing.JButton export;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JLabel fname;
    private com.toedter.calendar.JDateChooser from;
    private javax.swing.JLabel inw;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lname;
    private javax.swing.JLabel paid;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel received;
    private javax.swing.JTable record;
    private javax.swing.JLabel set;
    private javax.swing.JButton submit;
    private com.toedter.calendar.JDateChooser to;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}
