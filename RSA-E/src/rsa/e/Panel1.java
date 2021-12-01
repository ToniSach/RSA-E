/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.e;

/**
 *
 * @author tonis
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Panel1 extends JPanel{
    RSA rsa = new RSA(RSAE.TAMANO);
    
    JComboBox ENCDES;
    JLabel titulo, ENCtxt, DEStxt, lblENCn, lblENCe;
    JTextArea ENCtexto, DEStexto;
    JButton ENC, ENCn,ENCe, DES, DESGen, DESCif;
    File n, e, cifrado;
    
    public Panel1() {
        componentes();
        this.setBackground(Color.decode("#EFD6AC"));
        setLayout(null);
    }
    
    public void componentes() {
        titulo = new JLabel("RSA");
        titulo.setBounds(360, 10, 140, 30);
        titulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        titulo.setForeground(Color.decode("#ffffff"));
        add(titulo);
        
        ENCDES = new JComboBox();
        ENCDES.addItem("ENCRIPTAR/DESENCRIPTAR");
        ENCDES.addItem("ENCRIPTAR");
        ENCDES.addItem("DESENCRIPTAR");
        ENCDES.setBounds(275, 60, 250, 25);
        ENCDES.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        ENCDES.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (ENCDES.getSelectedItem().equals("ENCRIPTAR")) {
                    Enc00();
                    Des01();
                } else if (ENCDES.getSelectedItem().equals("DESENCRIPTAR")) {
                    Enc01();
                    Des00();

                } else if (ENCDES.getSelectedItem().equals("ENCRIPTAR/DESENCRIPTAR")) {
                    Enc01();
                    Des01();
                } else {
                    System.out.println("Error");
                }
            }
        });
        add(ENCDES);
        Enc();
        Des();
    }
    
    
    public void Enc(){
        
        ENCtxt = new JLabel("Texto:");
        //ENCtxt.setBounds(20, 115, 60, 15);
        ENCtxt.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        ENCtxt.setForeground(Color.decode("#ffffff"));
        add(ENCtxt);
        
        ENCtexto = new JTextArea();
        //ENCtexto.setBounds(20, 140, 340, 250);
        ENCtexto.setFont(new Font("Arial", Font.ITALIC, 15));
        ENCtexto.setBackground(Color.decode("#C5CAC9"));
        ENCtexto.setLineWrap(true);
        ENCtexto.setWrapStyleWord(true);
        ENCtexto.setEditable(true);
        add(ENCtexto);
        
        ENC = new JButton("Encriptar");
        ENC.setBackground(Color.decode("#161569"));
        //ENC.setBounds(640, 435, 140, 25);
        ENC.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        ENC.setForeground(Color.decode("#D3E7F3"));
        ENC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cifrar();
            }
        });
        add(ENC);
        
        ENCn = new JButton("Seleccionar archivo n");
        ENCn.setBackground(Color.decode("#161569"));
        //ENCn.setBounds(435, 140, 280, 25);
        ENCn.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        ENCn.setForeground(Color.decode("#D3E7F3"));
        ENCn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setN();
            }
        });
        add(ENCn);
        
        lblENCn = new JLabel();
        lblENCn.setBackground(Color.decode("#161569"));
        lblENCn.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        lblENCn.setForeground(Color.decode("#D3E7F3"));
        add(lblENCn);
        
        ENCe = new JButton("Seleccionar archivo e");
        ENCe.setBackground(Color.decode("#161569"));
        //ENCe.setBounds(435, 180, 280, 25);
        ENCe.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        ENCe.setForeground(Color.decode("#D3E7F3"));
        ENCe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setE();
            }
        });
        add(ENCe);
        
        lblENCe = new JLabel();
        lblENCe.setBackground(Color.decode("#161569"));
        lblENCe.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        lblENCe.setForeground(Color.decode("#D3E7F3"));
        add(lblENCe);
    }
    
    public void Enc00(){
        //valores guccis
        ENCtxt.setBounds(20, 115, 60, 15);
        ENCtexto.setBounds(20, 140, 340, 250);
        ENC.setBounds(640, 435, 140, 25);
        ENCn.setBounds(435, 140, 280, 25);
        lblENCn.setBounds(435, 180, 280, 25);
        ENCe.setBounds(435, 220, 280, 25);
        lblENCe.setBounds(435, 260, 280, 25);
    }
    
    public void Enc01(){
        //valores 1000
        ENCtxt.setBounds(1000, 1000, 60, 15);
        ENCtexto.setBounds(1000, 1000, 340, 250);
        ENC.setBounds(1000, 1000, 140, 25);
        ENCn.setBounds(1000, 1000, 280, 25);
        lblENCn.setBounds(1000, 1000, 280, 25);
        ENCe.setBounds(1000, 1000, 280, 25);
        lblENCe.setBounds(1000, 1000, 280, 25);
    }
    
    public void Des(){
        DEStxt = new JLabel("Texto:");
        //DEStxt.setBounds(120, 165, 60, 15);
        DEStxt.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        DEStxt.setForeground(Color.decode("#000000"));
        add(DEStxt);
        
        DEStexto = new JTextArea();
        //DEStexto.setBounds(180, 165, 450, 250);
        DEStexto.setFont(new Font("Arial", Font.ITALIC, 15));
        DEStexto.setBackground(Color.decode("#C5CAC9"));
        DEStexto.setLineWrap(true);
        DEStexto.setWrapStyleWord(true);
        DEStexto.setEditable(false);
        add(DEStexto);
        
        DES = new JButton("Desencriptar");
        DES.setBackground(Color.decode("#161569"));
        //DES.setBounds(620, 435, 160, 25);
        DES.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        DES.setForeground(Color.decode("#D3E7F3"));
        DES.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DEStexto.setText(RSAE.descifraArchivo(cifrado, rsa));
            }
        });
        add(DES);
        
        DESGen = new JButton("Generar archivos n-e");
        DESGen.setBackground(Color.decode("#161569"));
        //DESGen.setBounds(80, 120, 280, 25);
        DESGen.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        DESGen.setForeground(Color.decode("#D3E7F3"));
        DESGen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarArchivoNE();
            }
        });
        add(DESGen);
        
        DESCif = new JButton("Seleccionar archivo cifrado");
        DESCif.setBackground(Color.decode("#161569"));
        //DESCif.setBounds(395, 120, 320, 25);
        DESCif.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        DESCif.setForeground(Color.decode("#D3E7F3"));
        DESCif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCifrado();
            }
        });
        add(DESCif);
    }
    
    public void Des00(){
        //valores guccis
        DEStxt.setBounds(120, 165, 60, 15);
        DEStexto.setBounds(180, 165, 450, 250);
        DES.setBounds(620, 435, 160, 25);
        DESGen.setBounds(80, 120, 280, 25); 
        DESCif.setBounds(395, 120, 320, 25);
    }
    
    public void Des01(){
        //valores 1000
        DEStxt.setBounds(1000, 1000, 60, 15);
        DEStexto.setBounds(1000, 1000, 450, 250);
        DES.setBounds(1000, 1000, 160, 25);
        DESGen.setBounds(1000, 1000, 280, 25); 
        DESCif.setBounds(1000, 1000, 320, 25);
    }
    
    
    
    private Image fondo;
    //private Image rndm;

    @Override
    public void paint(Graphics g) {
        fondo = new ImageIcon(getClass().getResource("/Img/fondo02.jpeg")).getImage();
        g.drawImage(fondo, 0, 0, 800, 500, this);
        setOpaque(false);
        super.paint(g);
        
        /*rndm = new ImageIcon(getClass().getResource("/Img/imgrndm.jpg")).getImage();
        g.drawImage(rndm, 440, 170, 340, 220, this);
        setOpaque(false);
        super.paint(g);*/

    }

    private void setCifrado() {
        this.cifrado = archivo();
    }
    
    private void setN(){
        this.n = archivo();
        lblENCn.setText(n.getAbsolutePath());
    }
    
    private void setE(){
        this.e = archivo();
        lblENCe.setText(e.getAbsolutePath());
    }
    
    private File archivo() {
        JFileChooser jf = new JFileChooser();
        int seleccion = jf.showOpenDialog(this);
        if(seleccion==JFileChooser.APPROVE_OPTION){
            //Seleccionamos el fichero
            File fichero = jf.getSelectedFile();
            return fichero;
        }
        return null;
    }
    
    private void generarArchivoNE(){
        try {
            FileWriter archivoN = new FileWriter(RSAE.GUARDAR + "\\n.txt");
            
            archivoN.write(rsa.damen().toString());
            archivoN.flush();
            archivoN.close();
            
            FileWriter archivoE = new FileWriter(RSAE.GUARDAR + "\\e.txt");
            
            archivoE.write(rsa.damee().toString());
            archivoE.flush();
            archivoE.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cifrar(){
        RSAE.cifraArchivo(ENCtexto.getText(), n, e);
    }
}
