/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tc2tpv.ConfigurationNotFoundException;
import tc2tpv.DocumentExtensionNotFoundException;
import tc2tpv.DocumentURLOverflowException;
import tc2tpv.InvalidParameterException;
import tc2tpv.InvalidParameterTypeException;
import tc2tpv.ItemNotFoundException;
import tc2tpv.MaterialNotFoundException;
import tc2tpv.TC2TPV;
import tc2tpv.TPVBOM;
import tc2tpv.TPVItem;
import tc2tpv.TPVSQL;

/**
 *
 * @author TPV
 */
public class TCCom {

    private static String logString;
    private static String logFileStr;

    public static void main(String[] args) throws IOException {
        System.out.println("Aplikace spuštěna");
        try {
            if (args.length == 1) { // BUDE ZMENENO NA 1
                String sourceFileStr = args[0];
                //String sourceFileStr = "E:\\CSV\\000415.csv";

                System.out.println("Načítám soubor se vstupními daty: " + sourceFileStr);

                String server = "";
                String database = "";
                String user = "";
                String password = "";
                String uloziste = "";

                logFileStr = "";
                logString = "Výpis záznamu importu: \n";

                boolean isError = false;

                File configFile = new File("config.txt");
                BufferedReader brConfig;
                try {
                    brConfig = new BufferedReader(new FileReader(configFile));
                    String line;
                    while ((line = brConfig.readLine()) != null) {
                        if (line.split("=")[0].equals("SERVER")) {
                            server = line.split("=")[1];
                        }
                        if (line.split("=")[0].equals("DATABASE")) {
                            database = line.split("=")[1];
                        }
                        if (line.split("=")[0].equals("USER")) {
                            user = line.split("=")[1];
                        }
                        if (line.split("=")[0].equals("PASSWORD")) {
                            password = line.split("=")[1];
                        }
                        if (line.split("=")[0].equals("LOG")) {
                            logFileStr = line.split("=")[1];
                        }
                        if (line.split("=")[0].equals("DA")) {
                            uloziste = line.split("=")[1];
                        }
                    }
                } catch (FileNotFoundException ex) {
                    //System.out.println("Nebyl nalezen konfigurační soubor");
                    logString = "Nebyl nalezen konfigurační soubor";
                    exitWithError();
                } catch (IOException ex) {
                    //System.out.println("Z konfiguračního souboru nelze číst");
                    logString = "Z konfiguračního souboru nelze číst";
                    exitWithError();
                }

                System.out.println("Načteny parametry configu: " + server + "/" + database + "/" + user + "/" + password + "/" + logFileStr + "/" + uloziste);

                File sourceFile = new File(sourceFileStr);
            //File logFile = new File(logFileStr);

                //FileWriter logWriter;
                try {
                    //logWriter = new FileWriter(logFile);
                    try {
                        BufferedReader brSource = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), "Windows-1250"));

                        try {
                            List<String> headers = new ArrayList<>();

                            System.out.println("Načítám řádek s hlavičkou");

                            TPVSQL tpvsql = new TPVSQL(server, database, user, password);
                            String line;
                            boolean firstLine = true;
                            int columnCount = 0;
                            int actualRow = 1;

                            while ((line = brSource.readLine()) != null) {
                                line = line.replace(" #", "#");
                                if (firstLine) {
                                    // hlavicky zaznamu
                                    String[] headersArray = line.split("#");
                                    if (headersArray.length < 9) {
                                        logString += "Err: Vstupní soubor nemá potřebný počet parametrů \n";
                                        //logWriter.append("Err: Vstupní soubor nemá potřebný počet parametrů");
                                        isError = true;
                                    }
                                    if (!headersArray[0].equals("poradi")) {
                                        logString += "Err: Sloupec číslo 1 se musí jmenovat 'poradi' \n";
                                        //logWriter.append("Err: Sloupec číslo 1 se musí jmenovat 'poradi'");
                                        isError = true;
                                    }
                                    if (!headersArray[1].equals("idv")) {
                                        logString += "Err: Sloupec číslo 2 se musí jmenovat 'idv' \n";
                                        //logWriter.append("Err: Sloupec číslo 2 se musí jmenovat 'idv'");
                                        isError = true;
                                    }
                                    if (!headersArray[2].equals("id")) {
                                        logString += "Err: Sloupec číslo 3 se musí jmenovat 'id' \n";
                                        //logWriter.append("Err: Sloupec číslo 3 se musí jmenovat 'id'");
                                        isError = true;
                                    }
                                    if (!headersArray[3].equals("nazev")) {
                                        logString += "Err: Sloupec číslo 4 se musí jmenovat 'nazev' \n";
                                        //logWriter.append("Err: Sloupec číslo 4 se musí jmenovat 'nazev'");
                                        isError = true;
                                    }
                                    if (!headersArray[4].equals("revize")) {
                                        logString += "Err: Sloupec číslo 5 se musí jmenovat 'revize' \n";
                                        //logWriter.append("Err: Sloupec číslo 5 se musí jmenovat 'revize'");
                                        isError = true;
                                        continue;
                                    }
                                    if (!headersArray[5].equals("mnozstvi")) {
                                        logString += "Err: Sloupec číslo 6 se musí jmenovat 'mnozstvi' \n";
                                        //logWriter.append("Err: Sloupec číslo 6 se musí jmenovat 'mnozstvi'");
                                        isError = true;
                                    }
                                    if (!headersArray[6].equals("prilohy")) {
                                        logString += "Err: Sloupec číslo 7 se musí jmenovat 'prilohy' \n";
                                        //logWriter.append("Err: Sloupec číslo 7 se musí jmenovat 'prilohy'");
                                        isError = true;
                                    }
                                    if (!headersArray[7].equals("material")) {
                                        logString += "Err: Sloupec číslo 8 se musí jmenovat 'material' \n";
                                        //logWriter.append("Err: Sloupec číslo 8 se musí jmenovat 'material'");
                                        exitWithError();
                                        isError = true;
                                    }
                                    if (!headersArray[8].equals("typ")) {
                                        logString += "Err: Sloupec číslo 9 se musí jmenovat 'typ' \n";
                                        //logWriter.append("Err: Sloupec číslo 9 se musí jmenovat 'typ'");
                                        isError = true;
                                    }
                                    if (!headersArray[9].equals("klic")) {
                                        logString += "Err: Sloupec číslo 10 se musí jmenovat 'klic' \n";
                                        isError = true;
                                    }
                                    if (!headersArray[10].equals("zmena")) {
                                        logString += "Err: Sloupec číslo 11 se musí jmenovat 'změna' \n";
                                        isError = true;
                                    }

                                    columnCount = headersArray.length;
                                    headers.addAll(Arrays.asList(headersArray));

                                    firstLine = false;

                                    System.out.println("Hlavička načtena - kontrola OK");

                                    if (isError) {
                                        System.out.println("Hlavička načtena - něco je špatně (viz log) OK");
                                        exitWithError();
                                    }
                                } else {
                                    if (line.endsWith("#")) {
                                        line += " ";
                                    }

                                    System.out.println("Načítám řádek importu dat");

                                    String[] valuesArray = line.split("#");
                                    if (valuesArray.length != columnCount) {
                                        logString += "Err: Řádek číslo " + actualRow + " nemá správný počet parametrů - nebude importován \n";
                                        //logWriter.append("Err: Řádek číslo " + actualRow + " nemá správný počet parametrů - nebude importován");
                                        isError = true;
                                        actualRow++;
                                        continue;
                                    }

                                    if (valuesArray[1].equals("") || valuesArray[1].equals("(null)")) {
                                        // jedna se o vrchol
                                        TPVItem root;
                                        try {
                                            root = new TPVItem(TPVItem.TYPE_ASSEMBLY, valuesArray[2], valuesArray[3], valuesArray[4]);
                                        } catch (InvalidParameterTypeException ex) {
                                            logString += "Err: řádek " + actualRow + " :" + ex.getMessage() + " \n";
                                            actualRow++;
                                            isError = true;
                                            continue;
                                        }
                                        
                                        // Zmena ??
                                        if (!valuesArray[10].replace(" ", "").equals("") && !valuesArray[10].replace(" ", "").equals("(null)")) {
                                            root.setChangenum(valuesArray[10]);
                                        }

                                        // Parametry
                                        for (int i = 11; i < valuesArray.length; i++) {
                                            if (valuesArray[i].replace(" ", "").equals("(null)") || valuesArray[i].replace(" ", "").equals("")) {
                                                continue;
                                            }
                                            try {
                                                root.setParameter(headers.get(i), (Object) valuesArray[i]);
                                            } catch (InvalidParameterException ex) {
                                                logString += "Err: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                                //logWriter.append("Err: řádek importu " + actualRow + ": " + ex.getMessage());
                                                isError = true;
                                            } catch (InvalidParameterTypeException ex) {
                                                logString += "Err: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                                //logWriter.append("Err: řádek importu " + actualRow + ": " + ex.getMessage());
                                                isError = true;
                                            }
                                        }

                                        if (isError) {
                                            actualRow++;
                                            continue;
                                        }

                                        // Prilohy
                                        String prilohy = valuesArray[6];
                                        if (!prilohy.replace(" ", "").equals("") || prilohy.replace(" ", "").equals("(null)")) {
                                            String[] prilohyList = prilohy.split(";");
                                            String path = "";
                                            for (int i = 0; i < prilohyList.length; i++) {
                                                try {
                                                    if (uloziste.equals("")) {
                                                        path = prilohyList[i];
                                                        root.addFile(prilohyList[i]);
                                                        logFileStr += "Inf: Byl přidán soubor " + path + "\n";
                                                        System.out.println("Přidána příloha " + path);
                                                    } else {
                                                        path = prilohyList[i];
                                                        if (path.contains("\\")) {
                                                            path = path.substring(path.lastIndexOf("\\"), path.length());
                                                            path = path.replace("\\", "/");
                                                            path = path.substring(path.lastIndexOf("/") + 1, path.length());
                                                            path = uloziste + "\\" + path;
                                                        }
                                                        root.addFile(path);
                                                        logString += "Inf: Byl přidán soubor " + path + "\n";
                                                        System.out.println("Přidána příloha " + path);
                                                    }
                                                } catch (DocumentURLOverflowException ex) {
                                                    logString += ex.getMessage() + " \n";
                                                } catch (DocumentExtensionNotFoundException ex) {
                                                    logString += ex.getMessage() + " \n";
                                                } catch (FileNotFoundException ex) {
                                                    logString += "Wrn: řádek: " + actualRow + " - soubor přílohy nebyl nalezen " + path + " \n";
                                                }
                                            }
                                        }
                                                                                
                                        // Material zadany klicem
                                        if (!valuesArray[9].replace(" ", "").equals("") && !valuesArray[9].replace(" ", "").equals("(null)")) {
                                            int klic = Integer.valueOf(valuesArray[9]);
                                            try {
                                                root.setMaterial(klic, 1);
                                            } catch (MaterialNotFoundException ex) {
                                                logString += "Wrn: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                            }
                                        } else {
                                            // Material zadany IDckem
                                            if (!valuesArray[7].replace(" ", "").equals("") && !valuesArray[7].replace(" ", "").equals("(null)")) {
                                                try {
                                                    root.setMaterial(valuesArray[7], 1);
                                                } catch (MaterialNotFoundException ex) {
                                                    logString += "Wrn: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                                    //logWriter.append("Err: řádek importu " + actualRow + ": " + ex.getMessage());
                                                }
                                            }
                                        }
                                        
                                        TPVBOM.insertRootItem(root);

                                        System.out.println("Vlozen vrcholovy radek kusovniku");
                                    } else {
                                        int itemType;
                                        if (valuesArray[8].equals("S")) {
                                            itemType = TPVItem.TYPE_ASSEMBLY;
                                        } else if (valuesArray[8].equals("D")) {
                                            itemType = TPVItem.TYPE_SEMI;
                                        } else if (valuesArray[8].equals("N")) {
                                            itemType = TPVItem.TYPE_NORM;
                                        } else if (valuesArray[8].equals("F")){
                                            itemType = TPVItem.TYPE_FINAL;
                                        } else {
                                            itemType = TPVItem.TYPE_ASSEMBLY;
                                        }
                                        TPVItem item;
                                        try {
                                            if (itemType == TPVItem.TYPE_NORM) {
                                                if (uloziste.equals("")) {
                                                    // nejedna se o dimenzi pokracujeme standardne
                                                    item = new TPVItem(itemType, valuesArray[2], valuesArray[3], valuesArray[4]);
                                                } else {
                                                    item = new TPVItem(itemType, Integer.valueOf(valuesArray[9]), valuesArray[4], true);
                                                }
                                            } else {
                                                item = new TPVItem(itemType, valuesArray[2], valuesArray[3], valuesArray[4]);
                                            }                                            
                                        } catch (InvalidParameterTypeException ex) {
                                            logString += "Err: řádek " + actualRow + " :" + ex.getMessage() + " \n";
                                            actualRow++;
                                            isError = true;
                                            continue;
                                        }
                                        
                                        // Zmena ??
                                        if (!valuesArray[10].replace(" ", "").equals("") && !valuesArray[10].replace(" ", "").equals("(null)")) {
                                            item.setChangenum(valuesArray[10]);
                                        }

                                        // Parametry
                                        for (int i = 11; i < valuesArray.length; i++) {
                                            if (valuesArray[i].replace(" ", "").equals("(null)") || valuesArray[i].replace(" ", "").equals("")) {
                                                continue;
                                            }
                                            try {
                                                item.setParameter(headers.get(i), (Object) valuesArray[i]);
                                            } catch (InvalidParameterException ex) {
                                                logString += "Err: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                                //logWriter.append("Err: řádek importu " + actualRow + ": " + ex.getMessage());
                                                isError = true;
                                            } catch (InvalidParameterTypeException ex) {
                                                logString += "Err: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                                //logWriter.append("Err: řádek importu " + actualRow + ": " + ex.getMessage());
                                                isError = true;
                                            }
                                        }

                                        if (isError) {
                                            actualRow++;
                                            continue;
                                        }

                                        // Prilohy
                                        String prilohy = valuesArray[6];
                                        if (!prilohy.replace(" ", "").equals("") || prilohy.replace(" ", "").equals("(null)")) {
                                            String[] prilohyList = prilohy.split(";");
                                            String path = "";
                                            for (int i = 0; i < prilohyList.length; i++) {
                                                try {
                                                    if (uloziste.equals("")) {
                                                        path = prilohyList[i];
                                                        item.addFile(prilohyList[i]);
                                                        logFileStr = "Inf: Byl přidán soubor " + path + "\n";
                                                        System.out.println("Přidána příloha " + path);
                                                    } else {
                                                        path = prilohyList[i];
                                                        if (path.contains("\\")) {
                                                            path = path.substring(path.lastIndexOf("\\"), path.length());
                                                            path = path.replace("\\", "/");
                                                            path = path.substring(path.lastIndexOf("/") + 1, path.length());
                                                            path = uloziste + "\\" + path;
                                                        }
                                                        item.addFile(path);
                                                        logFileStr = "Inf: Byl přidán soubor " + path + "\n";
                                                        System.out.println("Přidána příloha " + path);
                                                    }
                                                } catch (DocumentURLOverflowException ex) {
                                                    logString += ex.getMessage() + " \n";
                                                } catch (DocumentExtensionNotFoundException ex) {
                                                    logString += ex.getMessage() + " \n";
                                                } catch (FileNotFoundException ex) {
                                                    logString += "Wrn: řádek: " + actualRow + " - soubor přílohy  nebyl nalezen " + path + " \n";
                                                }
                                            }
                                        }
                                        
                                        // Material zadany klicem
                                        if (!valuesArray[9].replace(" ", "").equals("") && !valuesArray[9].replace(" ", "").equals("(null)")) {
                                            int klic = Integer.valueOf(valuesArray[9]);
                                            try {
                                                item.setMaterial(klic, 1);
                                            } catch (MaterialNotFoundException ex) {
                                                logString += "Wrn: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                            }
                                        } else {
                                            // Material zadany IDckem ??
                                            if (!valuesArray[7].replace(" ", "").equals("") && !valuesArray[7].replace(" ", "").equals("(null)")) {
                                                try {
                                                    item.setMaterial(valuesArray[7], 1);
                                                } catch (MaterialNotFoundException ex) {
                                                    logString += "Wrn: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                                    //logWriter.append("Err: řádek importu " + actualRow + ": " + ex.getMessage());
                                                }
                                            }
                                        }

                                        TPVBOM.insertItem(item);
                                        System.out.println("Přidána položka " + item.getItemId());
                                        float mnozstvi;
                                        try {
                                            mnozstvi = Float.valueOf(valuesArray[5].replace(",", ".").replace(" ", ""));
                                        } catch (Exception ex) {
                                            mnozstvi = 1;
                                        }
                                        try {
                                            TPVBOM.insertBomLine(valuesArray[1], valuesArray[2], mnozstvi);
                                            System.out.println("Založena vazba mezi " + valuesArray[1] + " a " + valuesArray[2]);
                                        } catch (ItemNotFoundException ex) {
                                            logString += "Err: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                            //logWriter.append("Err: řádek importu " + actualRow + " :" + ex.getMessage());
                                            isError = true;
                                            actualRow++;
                                            continue;
                                        }
                                    }
                                }
                                actualRow++;

                                System.out.println("Zpracvan radek " + actualRow);
                            }

                            try {
                                if (isError) {
                                    exitWithError();
                                } else {
                                    // Import v poradku
                                    //TPVBOM.getRoot().printTree();

                                    int klicImportu;
                                    try {
                                        klicImportu = TPVBOM.getRoot().insertItemToTPV();
                                        String kontResult = TC2TPV.provedKontrolu(klicImportu);
                                        System.out.println("Provedena kontrola importu");
                                        //String kontResult = "";
                                        if (kontResult.equals("")) {
                                            try {
                                                TC2TPV.provedImport(klicImportu);
                                                System.out.println("Kontrola OK spoustim import a ukoncuji - vysledek v LOGU");
                                                exitOK();
                                            } catch (SQLException ex) {
                                                System.out.println("Kontrola neprosla - ukoncuji - vysledek v LOGU");
                                                logString += "Err: Chyba SQL při importu / " + ex.getMessage() + " \n";
                                                exitWithError();
                                            }
                                        } else {
                                            logString += kontResult;
                                            exitWithError();
                                        }
                                    } catch (ConfigurationNotFoundException ex) {
                                        logString += "Err: " + ex.getMessage() + " \n";
                                        //logWriter.append("Err: řádek importu " + actualRow + ": " + ex.getMessage());
                                        exitWithError();
                                    }
                                }
                            } catch (ItemNotFoundException ex) {
                                logString += "Err: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                //logWriter.append("Err: řádek importu " + actualRow + ": " + ex.getMessage());
                                exitWithError();
                            }

                        } catch (ClassNotFoundException ex) {
                            logString += "Err: Nebyl nalezen ovladač pro připojení k MS SQL Serveru \n";
                            //logWriter.append("Err: Nebyl nalezen ovladač pro připojení k MS SQL Serveru");
                            exitWithError();
                        } catch (SQLException ex) {
                            logString += "Err: Chyba SQL / " + ex.getMessage() + " \n";
                            //logWriter.append("Err: Chyba SQL / " + ex.getMessage());
                            exitWithError();
                        }
                    } catch (FileNotFoundException ex) {
                        logString += "Err: Zdrojový soubor s daty nebyl nalezen \n";
                        //logWriter.append("Err: Zdrojový soubor s daty nebyl nalezen");
                        exitWithError();
                    }
                } catch (IOException ex) {
                    //System.out.println("Nelze otevřít umístění logovacího souboru");
                    logString += "Nelze otevřít umístění logovacího souboru \n";
                    exitWithError();
                }
            } else {
                //System.out.println("Nesprávně zadané parametry");
                logString += "Nesprávně zadané parametry aplikace (cesta na soubor)\n";
                exitWithError();
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            StackTraceElement[] elm = ex.getStackTrace();
            for (int i = 0; i < elm.length; i++) {
                logString += elm[i].toString() + " \n";
            }
            exitWithError();
        }
    }

    public static void exitWithError() {
        try {
            printLog();
            System.exit(-1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exitOK() {
        try {
            printLog();
            System.exit(0);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void printLog() throws FileNotFoundException, UnsupportedEncodingException {
        if (logFileStr == null) {
            logFileStr = "log.txt";
            logString = "Nepodařilo se založit log na zadaném umístění!\n";
        }
        File f = new File(logFileStr);
        //FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(f, "Windows-1250");
        logString += "Inf: Data byla naimportována \n";
        logString = logString.replace("\n", "\r\n");
        pw.write(logString);
        pw.close();
    }

}
