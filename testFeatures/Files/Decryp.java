package testFeatures.Files;

import java.io.*;
import java.util.*;

public class Decryp {
    private static String host;
    private static String  User;
    private static String port;
    private static String pass;
    private static	String key="sachkalox";

    // Принимает путь к файлу, дешефрует и отдает
    // массив String mas[] = {User, pass, host, port};
    // Вызывай где хош я заебался :D
    /*Decryp (String fileName){

    }*/

    public static String[] read(String fileName) throws FileNotFoundException {
        // fileName = "C://123/a.txt";
        File file = new File(fileName);
        // char alp[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int  q, y;
        q = y = 0;

        List<Byte> list = new ArrayList(); // Подобие динамических массивов в Джава
        byte [] byArray3 = new byte[100];
        int [] inter = new int[100];
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();
        exists(fileName);
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getCanonicalFile()));
            FileReader fr = new FileReader(new File(fileName));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    // c = s.length();
                }
                //Приведение типов...
                s = sb.toString()+'q';
                // System.out.println(s);
                char[] chart = s.toCharArray();
                try{
                    String s1 = Character.toString(chart[0]);
                    // Далее 50 строк которые мне лень комментить,
                    // просто поверь что они работают
                    for(int i = 1, j = 0; j < 200; i++){
                        if (chart[i]!= 'b') {
                            if (chart[i] != 'a') {
                                s1 += chart[i];
                            } else {
                                inter[j] = new Integer(s1);
                                byArray3[j] = (byte) inter[j];
                                list.add(byArray3[j]);
                                if (chart[i+1] != 'b') {
                                    s1 = Character.toString(chart[i+1]);
                                    i++;
                                }
                                j++;
                            }
                        } else {
                            byte [] byArray = new byte[list.size()];
                            byte [] byArray1 = new byte[list.size() - (list.size() - j)];
                            try{
                                y = list.size() - j;
                                if (q == 0) {
                                    for (int n = 0; n < list.size(); y++, n++) {
                                        //	System.out.println(list.get(y));
                                        byArray[n] = list.get(y);
                                    }
                                } else {
                                    for (int n = 0; n <(list.size() - (list.size() - j)); y++, n++)
                                    {
                                    //System.out.println(list.get(y));
                                    byArray1[n] = list.get(y);
                                    //System.out.println(byArray1[n]);
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            //  if(q==0){
                            s1 = Character.toString(chart[i + 1]);
                            //  System.out.println(s1);
                            i++;
                            if (q == 0) {
                                User = decrypt(byArray, key);
                                System.out.println("User: " + User);
                            }
                            if (q == 1) {
                                pass = decrypt(byArray1, key);
                                System.out.println("pass: " + pass);
                            }
                            if (q == 2) {
                                host = decrypt(byArray1, key);
                                System.out.println("host: " + host);
                            }
                            if (q == 3) {
                                port = decrypt(byArray1, key);
                                System.out.println("port: "+port);
                            }
                            q++;
                            j=0;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Забей, это ошибка индексации :D");}
                // c=chart.length;
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] mas = {User, pass, host, port};
        return  mas;
    }

    public static String decrypt(byte[] text, String keyWord) {
        byte[] result  = new byte[text.length];
        byte[] keyarr = keyWord.getBytes();
        for (int i = 0; i < text.length; i++) {
            result[i] = (byte) (text[i] ^ keyarr[i % keyarr.length]);
        }
        return new String(result);
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }
}