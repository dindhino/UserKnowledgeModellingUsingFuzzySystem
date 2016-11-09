/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.Sheet;
import jxl.Cell;
import jxl.read.biff.BiffException;

/**
 *
 * @author dindhino
 */
public class Main {
    
    

    public static void main(String[] args) throws IOException, BiffException {

        Workbook w = Workbook.getWorkbook(new File("Dataset UNS.xls"));
        Sheet s = w.getSheet(0);

        Data hasil = new Data();

        int hitungData = 0;
        int jumlahbener = 0;

        for (int cekData = 1; cekData < s.getRows(); cekData++) {
            Cell stg = s.getCell(1, cekData);
            Cell scg = s.getCell(2, cekData);
            Cell peg = s.getCell(3, cekData);
            Cell uns = s.getCell(4, cekData);

            double STG = Double.parseDouble(stg.getContents());
            double SCG = Double.parseDouble(scg.getContents());
            double PEG = Double.parseDouble(peg.getContents());
            String UNS = uns.getContents();

            hasil.cekSTG(STG);
            hasil.cekSCG(SCG);
            hasil.cekPEG(PEG);

            hasil.inference();

            System.out.print("Data Ke-" + cekData + "\t ");
            System.out.print("STG = " + STG + " \t ");
            System.out.print("SCG = " + SCG + "\t ");
            System.out.print("PEG = " + PEG + "\t ");
            System.out.print("UNS = " + UNS + "\t ");
            System.out.print("\t => \t HASIL = " + hasil.deffuzification());
            System.out.println("");
            if (UNS.equals(hasil.deffuzification())) {
                jumlahbener += 1;
            }
            hitungData++;
        }

        System.out.println("");
        System.out.println("Banyaknya Data \t \t = \t " + hitungData);
        System.out.println("Jumlah Data Benar \t = \t " + jumlahbener);
        System.out.println("Jumlah Data Salah \t = \t " + (hitungData - jumlahbener));
        System.out.println("Akurasi \t \t = \t " + ((float) (100 * jumlahbener) / hitungData) + "%");
    }
}
