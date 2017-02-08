package testFeatures.Files;

import java.io.*;

public class Encryp {
    private String host;
    private String User;
    private String port;
    private String pass;
    private String fileName; // путь к файлу
    private	String key="sachkalox"; // Ключ)

    Encryp(String User, String host, String port, String pass, String fileName) throws FileNotFoundException {
        this.User=User;
        this.host=host;
        this.port=port;
        this.pass=pass;
        this.fileName=fileName;
        Write();
    }

    private void Write() throws FileNotFoundException {
        String mas[] = {User, pass, host, port};
        String mas1[] = new String[4];
        byte ba[] = new byte[8];
        int n;
        //String key="sachkalox";
        fileName = "C://123/a.txt";
        //Определяем файл
        File file = new File(fileName); // путь C://123/a.txt
        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }
            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                //Записываем текст в файл
                // TODO Где тут его нужно будет зашифровать
                for(int i = 0; i < 4; i++) {
                    //	if(!(i%2==1)){
                    ba = (encrypt( mas[i],  key));
                    //System.out.println(ba[1]);
                    try{
                        for (int j = 0; j < 20; j++) {
                            out.print(ba[j]);
                            out.print('a');
                        }
                    } catch (Exception e) {
                        out.print("b");
                    }
                }
                //   		else
                //  	out.print( mas[i]);}
            } finally {
                //закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] encrypt(String text, String keyWord) {
        byte[] arr = text.getBytes();
        byte[] keyarr = keyWord.getBytes();
        byte[] result = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]);
        }
        return result;
    }
}