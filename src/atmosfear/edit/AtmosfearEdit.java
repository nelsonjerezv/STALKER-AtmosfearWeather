/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmosfear.edit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Nelson
 */
public class AtmosfearEdit {

    private static int count1 = 0;
    private static int count2 = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        File dir = new File("weathers/");
        String[] ficheros = dir.list();
        for (int i = 0; i < ficheros.length; i++) {
//            System.out.println(ficheros[i].toString());
        }
//        BufferedReader cr = new BufferedReader(new FileReader("weathers/af3_bright_clear_0.ltx"));
//        
//        cr.close();
        for (String fichero : ficheros) {
            try (BufferedReader br = new BufferedReader(new FileReader("weathers/"+fichero))) {
                
                String line;String input = "";

                while ((line = br.readLine()) != null) input += line + '\n';
//                System.out.println("hecho!");
                br.close();
                
                
                    count1++;
                    input = input.replaceAll("sun_shafts_intensity             = 0.30000", "sun_shafts_intensity             = 0.10000");
                    input = input.replaceAll("sun_shafts_intensity             = 0.40000", "sun_shafts_intensity             = 0.20000");
                    input = input.replaceAll("sun_shafts_intensity             = 0.50000", "sun_shafts_intensity             = 0.30000");
                    input = input.replaceAll("sun_shafts_intensity             = 0.[0,4,5,6,7,8,9][0-9][0-9][0-9][0-9]", "sun_shafts_intensity             = 0.30000");
//                    input = input.replaceAll("sun_shafts_intensity             = 0.[0-9][0-9][0-9][0-9][0-9]", "sun_shafts_intensity             = 0.50000");

                    try (FileOutputStream fileOut = new FileOutputStream(fichero)) {
                        fileOut.write(input.getBytes());
                    }
                
            }
        }
        System.out.println(count1);
        System.out.println(count2);
    }
    
}
