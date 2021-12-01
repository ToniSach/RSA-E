/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.e;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tonis
 */
public class RSAE {
    public static final int TAMANO = 40;
    public static final String GUARDAR = "C:\\Users\\tonis\\Downloads\\RSA_UwU-master";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        RSA rsa = new RSA(RSAE.TAMANO);
        System.out.println("p: " + rsa.damep() 
                + "\nq: " + rsa.dameq() 
                + "\nn: " + rsa.damen() 
                + "\nphi: " + rsa.damephi() 
                + "\ne: " + rsa.damee() 
                + "\nd: " + rsa.damed());
        System.out.println("Que quieres hacer");
        System.out.println("1-----Encriptar");
        System.out.println("2-----Desencriptar");
        /*String encodedString;
        BigInteger[] cifrado;
        switch(s.nextInt()){
            case 1:
                s.nextLine();
                System.out.println("Ingresa texto a cifrar");
                String texto = s.nextLine();
                
                System.out.println("Ingresa n:");
                String n2 = s.nextLine();
                
                System.out.println("Ingresa e:");
                String e2 = s.nextLine();
                
                cifrado = rsa.encriptar(texto, n2, e2);
                encodedString = codificar(cifrado);
                System.out.println(encodedString);
                break;
            case 2:
                s.nextLine();
                System.out.println("Ingresa texto cifrado y codificado");
                encodedString = s.nextLine();
                
                cifrado = decodificar(encodedString);
                
                String descifrado = rsa.desencriptar(cifrado);
                System.out.println(descifrado);                
                break;
        }*/
        Ventana1 ve = new Ventana1();
        ve.setVisible(true);
    }
    
    public static BigInteger[] decodificar(String encodedString){
        String[] inter = encodedString.split(" ");
        
        BigInteger[] cifrado = new BigInteger[inter.length];
        for (int i = 0; i < cifrado.length; i++) {
            cifrado[i] = new BigInteger(inter[i]);
        }
        
        System.out.println(Arrays.toString(cifrado));
        
        return cifrado;
    }
    
    public static String codificar(BigInteger[] cifrado){
        System.out.println(Arrays.toString(cifrado));
        String encodedString = "";
        for (BigInteger cifrado1 : cifrado) {
            encodedString += cifrado1 + " ";
        }
        
        return encodedString;
    }
    
    public static boolean cifraArchivo(String mensaje, File n2, File e2){
        RSA rsa = new RSA(RSAE.TAMANO);
        
        try {
            FileReader nR = new FileReader(n2);
            FileReader nE = new FileReader(e2);
            
            //leemos n
            String n = "";
            try {
                int c = nR.read();
                while(c != -1){
                    n += (char)c;
                    c = nR.read();
                }
                
                nR.close();
            } catch (IOException ex) {
                try {
                    System.out.println("Error en E/S de n");
                    nR.close();
                    nE.close();
                } catch (IOException ex1) {
                    System.out.println("Error en el cierre xddxdxxdxd");
                }
                return false;
            }
            
            //leemos e
            String e = "";
            try {
                int c = nE.read();
                while(c != -1){
                    e += (char)c;
                    c = nE.read();
                }
                
                nE.close();
            } catch (IOException ex) {
                try {
                    System.out.println("Error en E/S de r");
                    nE.close();
                } catch (IOException ex1) {
                    System.out.println("Error en el cierre xddxdxxdxd");
                }
                return false;
            }
            
            try {
                //cerramos el archivo en modo lectura y lo abrimos en modo escritura
                FileWriter salida = new FileWriter(RSAE.GUARDAR + "\\encriptado.txt");
                
                //lo encriptamos y guardamos el archivo
                BigInteger[] cifrado = rsa.encriptar(mensaje, n, e);
                String encodedString = codificar(cifrado);
                salida.write(encodedString);
                salida.flush();
                salida.close();
                
            } catch (IOException ex) {
                System.out.println("Error en la E/S u.u");
                return false;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error en el archivo unu");
            return false;
        }
        return true;
    }
    
    public static String descifraArchivo(File archivo, RSA rsa){
        String mensaje = "";
        try(FileReader fr = new FileReader(archivo)) {
            //abrimos el archivo encriptado en modo lectura
            
            String encriptado = "";
            try {
                //leemos el archivo y generamos el mensaje encriptado
                int c = fr.read();
                while(c != -1){
                    encriptado += (char)c;
                    c = fr.read();
                }
                //lo separamos por grupo de numeros
                BigInteger[] nums = decodificar(encriptado);
                
                //lo desencriptamos y guardamos el mensaje
                mensaje = rsa.desencriptar(nums);
                
            } catch (IOException ex) {
                System.out.println("Error en la E/S u.u");
                
                return mensaje;
            }
        } catch (Exception ex) {
            System.out.println("Error en el archivo unu");
            return mensaje;
        }
        return mensaje;
    }
}

   
