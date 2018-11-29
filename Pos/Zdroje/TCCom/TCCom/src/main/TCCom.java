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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import tc2tpv.InvalidPositionException;
import tc2tpv.ItemNotFoundException;
import tc2tpv.MaterialNotFoundException;
import tc2tpv.PositionAlreadyExistsException;
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

    public static void main(String[] args) {
        System.out.println("Aplikace spuštěna");
        try {
            if (args.length == 1) { // BUDE ZMENENO NA 1
                String sourceFileStr = args[0];
                //String sourceFileStr = "E:\\Instalace\\KomTC\\DAA_000_134_001.csv";

                System.out.println("Načítám soubor se vstupními daty: " + sourceFileStr);

                String server = "";
                String database = "";
                String user = "";
                String password = "";
                String uloziste = "";
                int userTCID = 0;

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
                        BufferedReader brSource = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));

                        try {
                            List<String> headers = new ArrayList<>();

                            System.out.println("Načítám řádek s hlavičkou");

                            TPVSQL tpvsql = new TPVSQL(server, database, user, password);

                            PreparedStatement psUser = TPVSQL.getConnection().prepareStatement("select user_id()");
                            ResultSet rsUser = psUser.executeQuery();
                            if (rsUser.next()) {
                                userTCID = rsUser.getInt(1);
                            }

                            String line;
                            boolean firstLine = true;
                            int columnCount = 0;
                            int actualRow = 1;

                            while ((line = brSource.readLine()) != null) {
                                line = line.replace(" #", "#");
                                if (firstLine) {
                                    // hlavicky zaznamu
                                    String[] headersArray = line.split("#");
                                    if (headersArray.length < 12) {
                                        logString += "Err: Vstupní soubor nemá potřebný počet parametrů \n";
                                        //logWriter.append("Err: Vstupní soubor nemá potřebný počet parametrů");
                                        isError = true;
                                    }
                                    if (!headersArray[0].equals("poradi")) {
                                        logString += "Err: Sloupec číslo 1 se musí jmenovat 'poradi' a jmenuje se '" + headersArray[0] + "'\n";
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
                                    if (!headersArray[11].equals("pozice")) {
                                        logString += "Err: Sloupec číslo 12 se musí jmenovat 'pozice' \n";
                                        isError = true;
                                    }
                                    /*
                                    if (!headersArray[11].equals("stav")) {
                                        logString += "Err: Sloupec číslo 11 se musí jmenovat 'stav' \n";
                                        isError = true;
                                    }
                                     */

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
                                            int itemType;
                                            if (valuesArray[8].equals("S")) {
                                                itemType = TPVItem.TYPE_ASSEMBLY;
                                            } else if (valuesArray[8].equals("D")) {
                                                itemType = TPVItem.TYPE_SEMI;
                                            } else if (valuesArray[8].equals("N")) {
                                                itemType = TPVItem.TYPE_NORM;
                                            } else if (valuesArray[8].equals("F")) {
                                                itemType = TPVItem.TYPE_FINAL;
                                            } else {
                                                itemType = TPVItem.TYPE_ASSEMBLY;
                                            }
                                            root = new TPVItem(itemType, valuesArray[2], valuesArray[3], valuesArray[4]);
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
                                        for (int i = 12; i < valuesArray.length; i++) {
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
                                                        logString += "Inf: Byl přidán soubor " + path + "\n";
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
                                                    exitWithError();
                                                } catch (DocumentExtensionNotFoundException ex) {
                                                    logString += ex.getMessage() + " \n";
                                                    exitWithError();
                                                } catch (FileNotFoundException ex) {
                                                    logString += "Wrn: řádek: " + actualRow + " - soubor přílohy nebyl nalezen " + path + " \n";
                                                    exitWithError();
                                                } catch (Exception ex) {
                                                    logString += "Unexpected Error: " + ex.getMessage();
                                                    exitWithError();
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
                                        } else if (valuesArray[8].equals("F")) {
                                            itemType = TPVItem.TYPE_FINAL;
                                        } else if (valuesArray[8].equals("2")) {
                                            itemType = TPVItem.TYPE_SPECIAL_TOOL;
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
                                        for (int i = 12; i < valuesArray.length; i++) {
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
                                                        logString = "Inf: Byl přidán soubor " + path + "\n";
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
                                                        logString = "Inf: Byl přidán soubor " + path + "\n";
                                                        System.out.println("Přidána příloha " + path);
                                                    }
                                                } catch (DocumentURLOverflowException ex) {
                                                    logString += ex.getMessage() + " \n";
                                                    exitWithError();
                                                } catch (DocumentExtensionNotFoundException ex) {
                                                    logString += ex.getMessage() + " \n";
                                                    exitWithError();
                                                } catch (FileNotFoundException ex) {
                                                    logString += "Wrn: řádek: " + actualRow + " - soubor přílohy  nebyl nalezen " + path + " \n";
                                                    exitWithError();
                                                } catch (Exception ex) {
                                                    logString += "Unexpected Error: " + ex.getMessage();
                                                    exitWithError();
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
                                            int pozice = Integer.valueOf(valuesArray[11]);
                                            TPVBOM.insertBomLine(valuesArray[1], valuesArray[2], mnozstvi, pozice);
                                            System.out.println("Založena vazba mezi " + valuesArray[1] + " a " + valuesArray[2]);
                                        } catch (ItemNotFoundException ex) {
                                            logString += "Err: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                            //logWriter.append("Err: řádek importu " + actualRow + " :" + ex.getMessage());
                                            isError = true;
                                            actualRow++;
                                            continue;
                                        } catch (InvalidPositionException ex) {
                                            logString += "Err: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
                                            isError = true;
                                            actualRow++;
                                            continue;
                                        } catch (PositionAlreadyExistsException ex) {
                                            logString += "Err: řádek importu " + actualRow + ": " + ex.getMessage() + " \n";
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
                                                uploadDocuments(klicImportu, userTCID);
                                                System.out.println("Kontrola OK spoustim import a ukoncuji - vysledek v LOGU");
                                                exitOK();
                                            } catch (SQLException ex) {
                                                System.out.println("Kontrola neprosla - ukoncuji - vysledek v LOGU");
                                                uploadDocuments(klicImportu, userTCID);
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

    public static void uploadDocuments(int klicImportu, int userTCID) {
        try {
            Connection connection = TPVSQL.getConnection();
            PreparedStatement psDocs = connection.prepareStatement("SELECT I.klic_importu, soubor, extenze, alter_nazev, index_vykresu, D.klic_import_priloha FROM tpv_c2t_import I INNER JOIN tpvg_c2t_import_dok D on I.klic_importu = D.klic_importu WHERE I.klic_imp_hlav = ? and D.stav = 'N'");
            psDocs.setInt(1, klicImportu);
            ResultSet rs = psDocs.executeQuery();

            int i = 0;
            boolean partmod;

            while (rs.next()) {
                String fileStr = rs.getString(2);
                String type = rs.getString(3);
                String alterNazev = rs.getString(4);
                String indexVykresu = rs.getString(5);
                int klicImpPriloha = rs.getInt(6);
                int klicPartmod = 0;
                i++;

                PreparedStatement psPartmod = connection.prepareStatement("SELECT klic_modifikace FROM vtp_partmod WHERE alter_nazev = ? AND index_vykresu = ?");
                psPartmod.setString(1, alterNazev);
                psPartmod.setString(2, indexVykresu);
                ResultSet rsPartmod = psPartmod.executeQuery();
                if (rsPartmod.next()) {
                    klicPartmod = rsPartmod.getInt(1);
                    partmod = true;
                } else {
                    partmod = false;
                    PreparedStatement psNakup = connection.prepareStatement("SELECT klic_polozky FROM polozka WHERE alter_nazev = ?");
                    psNakup.setString(1, alterNazev);
                    ResultSet rsNakup = psNakup.executeQuery();
                    if (rsNakup.next()) {
                        klicPartmod = rsNakup.getInt(1);
                    }
                }

                /*
                    Smazani existujicich priloh z tpv_dok_data
                    Smazani vazeb na prilohy z tpv_priloha_objekt dle klice partmod
                 */
                PreparedStatement psDel;
                if (partmod) {
                    psDel = connection.prepareStatement("SELECT klic_dok_data FROM tpv_priloha_objekt WHERE objekt = 'PARTMOD' and klic_objektu = ? AND klic_dok_data is not null and createid = ?");
                } else {
                    psDel = connection.prepareStatement("SELECT klic_dok_data FROM tpv_priloha_objekt WHERE objekt = 'POLOZKA' and klic_objektu = ? AND klic_dok_data is not null and createid = ?");
                }
                psDel.setInt(1, klicPartmod);
                psDel.setInt(2, userTCID);
                ResultSet rsDel = psDel.executeQuery();
                while (rsDel.next()) {
                    PreparedStatement psDelData = connection.prepareStatement("DELETE FROM tpv_dok_data WHERE klic_dok_data = ?");
                    psDelData.setInt(1, rsDel.getInt(1));
                    psDelData.execute();
                    psDelData.close();

                    PreparedStatement psDelPriloha = connection.prepareStatement("DELETE FROM tpv_priloha_objekt WHERE klic_dok_data = ?");
                    psDelPriloha.setInt(1, rsDel.getInt(1));
                    psDelPriloha.execute();
                    psDelPriloha.close();
                }
                psDel.close();

                if (partmod) {
                    psDel = connection.prepareStatement("DELETE FROM tpv_priloha_objekt WHERE objekt = 'PARTMOD' and klic_objektu = ? AND klic_dok_data is null and createid = ?");
                } else {
                    psDel = connection.prepareStatement("DELETE FROM tpv_priloha_objekt WHERE objekt = 'POLOZKA' and klic_objektu = ? AND klic_dok_data is null and createid = ?");
                }
                psDel.setInt(1, klicPartmod);
                psDel.setInt(2, userTCID);
                psDel.execute();

                File file = new File(fileStr);

                PreparedStatement stmntDel = connection.prepareStatement("DELETE FROM tpv_tmp_blob WHERE spid = @@SPID");
                stmntDel.execute();
                stmntDel.close();

                PreparedStatement stmntData = connection.prepareStatement("INSERT INTO tpv_tmp_blob (spid, blob, extenze, file_name) SELECT @@spid, ?, ?, ?");
                FileInputStream fis = new FileInputStream(file);
                stmntData.setBinaryStream(1, fis, (int) file.length());
                stmntData.setString(2, type);
                stmntData.setString(3, file.getName());
                stmntData.execute();
                stmntData.close();

                PreparedStatement stmntPriloha;
                if (partmod) {
                    stmntPriloha = connection.prepareStatement("execute up_BB_update_priloha_objekt 'I' , 'A' , null , 'PARTMOD' , ? , 2 , null , ? , '' , 0 , '01ABCDFGHKMOPQRSTUVXZ(TPV_REKL,POSTAVENI,PRACOVISTE,TPV_EVID_PRAC_CINNOST,TPV_GEN_CISLO_FORMAT,TPV_NORMATIV,TVR_PRACOVNIK)' , 1 , ? , null , 1 ");
                } else {
                    stmntPriloha = connection.prepareStatement("execute up_BB_update_priloha_objekt 'I' , 'A' , null , 'POLOZKA' , ? , 2 , null , ? , '' , 0 , '01ABCDFGHKMOPQRSTUVXZ(TPV_REKL,POSTAVENI,PRACOVISTE,TPV_EVID_PRAC_CINNOST,TPV_GEN_CISLO_FORMAT,TPV_NORMATIV,TVR_PRACOVNIK)' , 1 , ? , null , 1 ");
                }
                stmntPriloha.setInt(1, klicPartmod);
                stmntPriloha.setString(2, file.getAbsolutePath());
                stmntPriloha.setString(3, file.getName());
                stmntPriloha.execute();
                stmntPriloha.close();

                PreparedStatement psOzn = connection.prepareStatement("UPDATE tpvg_c2t_import_dok SET stav = 'H' where klic_import_priloha = ?");
                psOzn.setInt(1, klicImpPriloha);
                psOzn.execute();
                psOzn.close();

                fis.close();
                file.delete();

                logString += "Inf: Soubor byl naimportován do databáze TPV \n";
            }

            logString += "INF: Bylo importováno " + i + " souborů příloh \n";
        } catch (SQLException ex) {
            logString += "Err: Chyba SQL / " + ex.getMessage() + " \n";
            //logWriter.append("Err: Chyba SQL / " + ex.getMessage());
            exitWithError();
        } catch (FileNotFoundException ex) {
            logString += "Err: Soubor nenalezen / " + ex.getMessage() + " \n";
            //logWriter.append("Err: Chyba SQL / " + ex.getMessage());
            exitWithError();
        } catch (Exception ex) {
            logString += "Err: Unspecified / " + ex.getMessage() + " \n";
            //logWriter.append("Err: Chyba SQL / " + ex.getMessage());
            exitWithError();
        }
    }

    public static void exitWithError() {
        try {
            printLog(false);
            TC2TPV.rollback();
            System.exit(-1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exitOK() {
        try {
            printLog(true);
            TC2TPV.commit();
            System.exit(0);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TCCom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void printLog(boolean ok) throws FileNotFoundException, UnsupportedEncodingException {
        if (logFileStr == null) {
            logFileStr = "log.txt";
            logString = "Nepodařilo se založit log na zadaném umístění!\n";
        }
        File f = new File(logFileStr);
        //FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(f, "UTF-8");
        logString += (ok) ? "Inf: Data byla naimportována \n" : "Err: Import dat se nezdařil \n";
        logString = logString.replace("\n", "\r\n");
        pw.write(logString);
        pw.close();
    }

}
