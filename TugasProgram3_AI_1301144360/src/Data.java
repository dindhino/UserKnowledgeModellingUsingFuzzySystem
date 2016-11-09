/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dindhino
 */
public class Data {

    public double nSTG[] = new double[2];
    public double nSCG[] = new double[2];
    public double nPEG[] = new double[2];

    public String sSTG[] = new String[2];
    public String sSCG[] = new String[2];
    public String sPEG[] = new String[2];

    public double nUNS;
    public String sUNS;

    public double[] nHasil = new double[16];
    public String[] sHasil = new String[16];

    public void cekSTG(double data) {
        if ((data <= 0.08)) {
            sSTG[0] = "very_low";
            nSTG[0] = 1;
            sSTG[1] = "very_low";
            nSTG[1] = 1;
        } else if ((data > 0.08) && (data <= 0.2)) {
            sSTG[0] = "very_low";
            nSTG[0] = (0.2 - data) / (0.2 - 0.08);
            sSTG[1] = "Low";
            nSTG[1] = (data - 0.08) / (0.2 - 0.08);
        } else if ((data > 0.2) && (data <= 0.6)) {
            sSTG[0] = "Low";
            nSTG[0] = (0.6 - data) / (0.6 - 0.25);
            sSTG[1] = "Middle";
            nSTG[1] = (data - 0.2) / (0.6 - 0.2);
        } else if ((data > 0.6) && (data <= 0.76)) {
            sSTG[0] = "Middle";
            nSTG[0] = (0.76 - data) / (0.76 - 0.6);
            sSTG[1] = "High";
            nSTG[1] = (data - 0.6) / (0.76 - 0.6);
        } else if (data > 0.76) {
            sSTG[0] = "High";
            nSTG[0] = 1;
            sSTG[1] = "High";
            nSTG[1] = 1;
        }
    }

    public void cekSCG(double data) {
        if ((data <= 0.08)) {
            sSCG[0] = "very_low";
            nSCG[0] = 1;
            sSCG[1] = "very_low";
            nSCG[1] = 1;
        } else if ((data > 0.08) && (data <= 0.2)) {
            sSCG[0] = "very_low";
            nSCG[0] = (0.2 - data) / (0.2 - 0.08);
            sSCG[1] = "Low";
            nSCG[1] = (data - 0.08) / (0.2 - 0.08);
        } else if ((data > 0.2) && (data <= 0.6)) {
            sSCG[0] = "Low";
            nSCG[0] = (0.6 - data) / (0.6 - 0.2);
            sSCG[1] = "Middle";
            nSCG[1] = (data - 0.2) / (0.6 - 0.2);
        } else if ((data > 0.6) && (data <= 0.76)) {
            sSCG[0] = "Middle";
            nSCG[0] = (0.76 - data) / (0.76 - 0.6);
            sSCG[1] = "High";
            nSCG[1] = (data - 0.6) / (0.76 - 0.6);
        } else if (data > 0.76) {
            sSCG[0] = "High";
            nSCG[0] = 1;
            sSCG[1] = "High";
            nSCG[1] = 1;
        }
    }

    public void cekPEG(double data) {
        if ((data <= 0.08)) {
            sPEG[0] = "very_low";
            nPEG[0] = 1;
            sPEG[1] = "very_low";
            nPEG[1] = 1;
        } else if ((data > 0.08) && (data <= 0.2)) {
            sPEG[0] = "very_low";
            nPEG[0] = (0.2 - data) / (0.2 - 0.08);
            sPEG[1] = "Low";
            nPEG[1] = (data - 0.08) / (0.2 - 0.08);
        } else if ((data > 0.2) && (data <= 0.6)) {
            sPEG[0] = "Low";
            nPEG[0] = (0.6 - data) / (0.6 - 0.2);
            sPEG[1] = "Middle";
            nPEG[1] = (data - 0.2) / (0.6 - 0.2);
        } else if ((data > 0.6) && (data <= 0.76)) {
            sPEG[0] = "Middle";
            nPEG[0] = (0.76 - data) / (0.76 - 0.6);
            sPEG[1] = "High";
            nPEG[1] = (data - 0.6) / (0.76 - 0.6);
        } else if (data > 0.76) {
            sPEG[0] = "High";
            nPEG[0] = 1;
            sPEG[1] = "High";
            nPEG[1] = 1;
        }
    }

    public void inference() {
        int cek = 0;

        for (int stg = 0; stg < 2; stg++) {
            for (int scg = 0; scg < 2; scg++) {
                for (int peg = 0; peg < 2; peg++) {

                    if (("very_low".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("very_low".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Low".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("Middle".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("very_low".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("Low".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("Middle".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("very_low".equals(sPEG[peg]))) {
                        sUNS = "very_low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("Low".equals(sPEG[peg]))) {
                        sUNS = "Low";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("Middle".equals(sPEG[peg]))) {
                        sUNS = "Middle";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    } else if (("High".equals(sSTG[stg])) && ("High".equals(sSCG[scg])) && ("High".equals(sPEG[peg]))) {
                        sUNS = "High";
                        nUNS = Math.min(nSTG[stg], Math.min(nSTG[scg], nPEG[peg]));
                    }

                    if (cek < 16) {
                        sHasil[cek] = sUNS;
                        nHasil[cek] = nUNS;
                        cek++;
                    } else {
                        cek = 0;
                        sHasil[cek] = sUNS;
                        nHasil[cek] = nUNS;
                        cek++;
                    }
                }
            }
        }
    }

    public double cekHasil(String data) {
        double nilai = 0;
        if ("very_low".equals(data)) {
            nilai = 0.08;
        } else if ("Low".equals(data)) {
            nilai = 0.2;
        } else if ("Middle".equals(data)) {
            nilai = 0.6;
        } else if ("High".equals(data)) {
            nilai = 0.76;
        }
        return nilai;
    }

    public String deffuzification() {
        String hasilUNS = "";

        double cek1 = 0;
        double cek2 = 0;

        double NHasilXSHasil = 0;
        double JumlahNHasil = 0;
        double COG = 0;

        for (int dt = 0; dt < nHasil.length; dt++) {
            NHasilXSHasil = NHasilXSHasil + (nHasil[dt] * cekHasil(sHasil[dt]));
            JumlahNHasil = JumlahNHasil + nHasil[dt];
        }

        COG = NHasilXSHasil / JumlahNHasil;

        if (COG <= 0.08) {
            hasilUNS = "very_low";
        } else if ((COG > 0.08) && (COG <= 0.2)) {
            cek1 = (0.2 - COG) / (0.2 - 0.08); //verylow
            cek2 = (COG - 0.08) / (0.2 - 0.08); //low
            if (cek1 > cek2) {
                hasilUNS = "very_low";
            } else {
                hasilUNS = "Low";
            }
        } else if ((COG > 0.2) && (COG <= 0.6)) {
            cek1 = (0.6 - COG) / (0.6 - 0.2); //low
            cek2 = (COG - 0.2) / (0.6 - 0.2); //middle
            if (cek1 > cek2) {
                hasilUNS = "Low";
            } else {
                hasilUNS = "Middle";
            }
        } else if ((COG > 0.6) && (COG <= 0.76)) {
            cek1 = (0.76 - COG) / (0.76 - 0.6); //middle
            cek2 = (COG - 0.6) / (0.76 - 0.6); //high
            if (cek1 > cek2) {
                hasilUNS = "Middle";
            } else {
                hasilUNS = "High";
            }
        } else if (COG > 0.76) {
            hasilUNS = "High";
        }

        return hasilUNS;
    }

}
