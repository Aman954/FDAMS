/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fdams;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 *
 * @author LENOVO
 */
public class feer extends javax.swing.JFrame {

    /**
     * Creates new form feer
     */
    public feer() {
        initComponents();
    }

    
     public feer(String rno,String frst,String lst,String phon,String co,int cury,String mode,String cheqText,String cbankText,String ddnText,String ddbText,String utrnText,String utrbText,String dte,String yr,String a,String t,String s,String i,String u,String intern,int tot,int nblc,int ne,String note,String words) {
        initComponents();
        
        md.setText(mode);
        if(mode.equals("Cash"))
        {
        cl1.hide();
        cb.hide();
        ct.hide();
        cbt.hide();
        ddl.hide();
        ddbl.hide();
        dt.hide();
        ddbt.hide();
        nl.hide();
        nbl.hide();
        ut.hide();
        ubt.hide();
        }
        else if(mode.equals("Cheque"))
        {
        ct.setText(cheqText);
        cbt.setText(cbankText);
        cl1.show();
        cb.show();
        ct.show();
        cbt.show();
        
        ddl.hide();
        ddbl.hide();
        dt.hide();
        ddbt.hide();
        nl.hide();
        nbl.hide();
        ut.hide();
        ubt.hide();
        }
        else if(mode.equals("DD"))
        {
        cl1.hide();
        cb.hide();
        ct.hide();
        cbt.hide();
        
        dt.setText(ddnText);
        ddbt.setText(ddbText);
        
        ddl.show();
        ddbl.show();
        dt.show();
        ddbt.show();
        
        nl.hide();
        nbl.hide();
        ut.hide();
        ubt.hide();
        }
        else if(mode.equals("NEFT"))
        {
        cl1.hide();
        cb.hide();
        ct.hide();
        cbt.hide();
        ddl.hide();
        ddbl.hide();
        dt.hide();
        ddbt.hide();
        
        ut.setText(utrnText);
        ubt.setText(utrbText);
        
        nl.show();
        nbl.show();
        ut.show();
        ubt.show();
        }
        
        
        rn.setText(rno);
        can.setText(frst+" "+lst);
        phone.setText(phon);
        cour.setText(co);
        dat.setText(dte);
        cur.setText(Integer.toString(cury));
        ad.setText(a);
        tu.setText(t);
        so.setText(s);
        in.setText(i);
        un.setText(u);
        inter.setText(intern);
        paid.setText(Integer.toString(tot));
        balance.setText(Integer.toString(nblc));
        excess.setText(Integer.toString(ne));
        inwords.setText(words);
        not.setText(note);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        feeprin = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cr = new javax.swing.JLabel();
        ct = new javax.swing.JLabel();
        cbt = new javax.swing.JLabel();
        ddl = new javax.swing.JLabel();
        ddbl = new javax.swing.JLabel();
        nl = new javax.swing.JLabel();
        nbl = new javax.swing.JLabel();
        md = new javax.swing.JLabel();
        can = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        rn = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dat = new javax.swing.JLabel();
        fr = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        tu = new javax.swing.JLabel();
        so = new javax.swing.JLabel();
        in = new javax.swing.JLabel();
        un = new javax.swing.JLabel();
        ad = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        inter = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        yr = new javax.swing.JLabel();
        paid = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        not = new javax.swing.JLabel();
        inwords = new javax.swing.JLabel();
        excess = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        cour = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cur = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cl1 = new javax.swing.JLabel();
        dt = new javax.swing.JLabel();
        ut = new javax.swing.JLabel();
        ddbt = new javax.swing.JLabel();
        ubt = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        cb = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        prr = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        bc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1382, 816));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        feeprin.setBackground(new java.awt.Color(255, 255, 255));
        feeprin.setPreferredSize(new java.awt.Dimension(1300, 1070));
        feeprin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(102, 0, 102));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 32)); // NOI18N
        jLabel8.setText("Shivalik");
        feeprin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 52)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 102));
        jLabel9.setText("College Of Engineering");
        feeprin.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 21)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 102));
        jLabel10.setText("P.O, Shimla Bypass Road Shiniwala, Sherpur, Uttarakhand 248197, Phone: 099971 55111");
        feeprin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, 20));

        jPanel9.setBackground(new java.awt.Color(102, 0, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        feeprin.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 1210, 10));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel14.setText("27AAATLO123");
        feeprin.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 240, -1, 30));

        cr.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        cr.setForeground(new java.awt.Color(102, 0, 102));
        cr.setText("COE-");
        feeprin.add(cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 60, -1));

        ct.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        ct.setText("123467899");
        feeprin.add(ct, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 230, -1));

        cbt.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        cbt.setText("SBI");
        feeprin.add(cbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 480, -1));

        ddl.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        ddl.setText("DD No :");
        feeprin.add(ddl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        ddbl.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        ddbl.setText("Bank Name :");
        feeprin.add(ddbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        nl.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        nl.setText("UTR No :");
        feeprin.add(nl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        nbl.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        nbl.setText("Bank Name :");
        feeprin.add(nbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        md.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        md.setText("Cash");
        feeprin.add(md, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 100, -1));

        can.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        can.setText("Aman Agarwal");
        feeprin.add(can, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        phone.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        phone.setText("8279779072");
        feeprin.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, -1));

        rn.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        rn.setText("d");
        feeprin.add(rn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 110, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel17.setText("GSTIN :");
        feeprin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, -1, 30));

        dat.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        dat.setText("2022-03-12");
        feeprin.add(dat, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, -1, 30));

        fr.setBackground(new java.awt.Color(255, 255, 255));
        fr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frMouseClicked(evt);
            }
        });
        fr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel25.setText("Amount(in Rs)");
        fr.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, -1, 60));
        fr.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 580, 220, 20));
        fr.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 950, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel27.setText("S. No");
        fr.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, 60));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Signature");
        fr.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 1070, 200, 60));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel29.setText("Head");
        fr.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, 60));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel30.setText("6");
        fr.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 30, 40));

        tu.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        tu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tu.setText("15000");
        fr.add(tu, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 270, 120, 40));

        so.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        so.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        so.setText("10000");
        fr.add(so, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 140, 40));

        in.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        in.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        in.setText("7000");
        fr.add(in, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, 80, 50));

        un.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        un.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        un.setText("7900");
        fr.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 80, 50));

        ad.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        ad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ad.setText("35000");
        fr.add(ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 180, 40));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel36.setText("1");
        fr.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 30, 50));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel37.setText("2");
        fr.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 30, 50));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel38.setText("3");
        fr.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 30, 50));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel39.setText("4");
        fr.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 30, 50));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel40.setText("5");
        fr.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 30, 50));
        fr.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 950, 20));

        inter.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        inter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inter.setText("1500");
        fr.add(inter, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 500, 80, 70));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Year :");
        fr.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 72, -1, 30));

        yr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fr.add(yr, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 72, -1, 30));

        paid.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        paid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paid.setText("126300");
        fr.add(paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 610, 240, 40));

        balance.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balance.setText("78000");
        fr.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 660, 240, 50));

        not.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        not.setText("there are two");
        fr.add(not, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1210, 1010, 30));

        inwords.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        inwords.setText("one lakh");
        fr.add(inwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 900, 890, 30));

        excess.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        excess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        excess.setText("1500");
        fr.add(excess, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 710, 260, 50));
        fr.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 983, 110, 0));
        fr.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 1070, 180, 20));

        cour.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        cour.setText("btech");
        fr.add(cour, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel49.setText("Course :");
        fr.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel16.setText("year");
        fr.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, 30));

        cur.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        cur.setText("1");
        fr.add(cur, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel22.setText("Year :");
        fr.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, -1, 30));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel51.setText("Admission fee");
        fr.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, 40));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel52.setText("Tuition fee");
        fr.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, 40));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel53.setText("Soft Skill fee");
        fr.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, 40));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel54.setText("Industrial Training");
        fr.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, -1, 50));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel55.setText("University fee");
        fr.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, -1, 50));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel56.setText("Internal examination fee");
        fr.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 350, 70));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setText("Amount paid :");
        fr.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 210, 40));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel58.setText("Balance Amount to paid :");
        fr.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 660, 350, 50));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel59.setText("Excess fee amount :");
        fr.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 710, 290, 50));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel60.setText("Amount in words : ");
        fr.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 900, -1, 30));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel61.setText("Note : ");
        fr.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1210, 60, 30));

        feeprin.add(fr, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 1060, 1300));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel24.setText("Fee Receipt :");
        feeprin.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel26.setText("Mode Of Payment :");
        feeprin.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        cl1.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        cl1.setText("Cheque No :");
        feeprin.add(cl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        dt.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        dt.setText("123467899");
        feeprin.add(dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 140, -1));

        ut.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        ut.setText("123467899");
        feeprin.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 140, -1));

        ddbt.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        ddbt.setText("SBI");
        feeprin.add(ddbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 400, -1));

        ubt.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        ubt.setText("SBI");
        feeprin.add(ubt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 490, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel28.setText("Received From :");
        feeprin.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel48.setText("Phone No :");
        feeprin.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel18.setText("Course :");
        feeprin.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel50.setText("Date :");
        feeprin.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, -1, 30));

        cb.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        cb.setText("Bank Name :");
        feeprin.add(cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 170, -1));

        jPanel2.add(feeprin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 1820));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prr.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        prr.setForeground(new java.awt.Color(255, 255, 255));
        prr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/printer-.png"))); // NOI18N
        prr.setText("  PRINT");
        prr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prrMouseClicked(evt);
            }
        });
        jPanel4.add(prr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 180, 80));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1910, 210, 80));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        bc.setForeground(new java.awt.Color(255, 255, 255));
        bc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fdams/img/back-button.png"))); // NOI18N
        bc.setText("  BACK");
        bc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bcMouseClicked(evt);
            }
        });
        jPanel5.add(bc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 170, 80));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1910, 210, 80));

        jScrollPane2.setViewportView(jPanel2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 820));

        setSize(new java.awt.Dimension(1466, 823));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prrMouseClicked
        // TODO add your handling code here:

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            pf.setOrientation(PageFormat.LANDSCAPE);
            if(pageNum > 0){
                return Printable.NO_SUCH_PAGE;
            }
            
            Graphics2D g2 = (Graphics2D)pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.scale(0.47,0.47);
            
            feeprin.print(g2);
            
            return Printable.PAGE_EXISTS;
        });
        boolean ok = job.printDialog();
        if(ok){
            try{

                job.print();
            }
            catch (PrinterException ex){
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_prrMouseClicked

    private void frMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_frMouseClicked

    private void bcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcMouseClicked
        // TODO add your handling code here:
        studentfeerecord stf=new studentfeerecord();
        stf.show();
        this.dispose();
    }//GEN-LAST:event_bcMouseClicked

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
            java.util.logging.Logger.getLogger(feer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(feer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(feer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(feer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new feer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ad;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel bc;
    private javax.swing.JLabel can;
    private javax.swing.JLabel cb;
    private javax.swing.JLabel cbt;
    private javax.swing.JLabel cl1;
    private javax.swing.JLabel cour;
    private javax.swing.JLabel cr;
    private javax.swing.JLabel ct;
    private javax.swing.JLabel cur;
    private javax.swing.JLabel dat;
    private javax.swing.JLabel ddbl;
    private javax.swing.JLabel ddbt;
    private javax.swing.JLabel ddl;
    private javax.swing.JLabel dt;
    private javax.swing.JLabel excess;
    private javax.swing.JPanel feeprin;
    private javax.swing.JPanel fr;
    private javax.swing.JLabel in;
    private javax.swing.JLabel inter;
    private javax.swing.JLabel inwords;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel md;
    private javax.swing.JLabel nbl;
    private javax.swing.JLabel nl;
    private javax.swing.JLabel not;
    private javax.swing.JLabel paid;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel prr;
    private javax.swing.JLabel rn;
    private javax.swing.JLabel so;
    private javax.swing.JLabel tu;
    private javax.swing.JLabel ubt;
    private javax.swing.JLabel un;
    private javax.swing.JLabel ut;
    private javax.swing.JLabel yr;
    // End of variables declaration//GEN-END:variables
}
