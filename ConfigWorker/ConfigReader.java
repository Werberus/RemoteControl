package ConfigWorker;

// из этого класса мы должны получать:
// А. Имя корня дерева +
// Б. Имя ветвей дерева +
// В. конфиги соединений
// Пункты А и Б будут (пере)определяться: 1 - при запуске программы, 2 - при добавлении ноды к дереву

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigReader {
    public String getRoot() throws FileNotFoundException { // возвращает из конфига имя корня дерева
        String root = "";
        StringBuilder stringBuilder = new StringBuilder();
        checkConfigExist("config\\rc.conf");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("config\\rc.conf").getAbsoluteFile()));
            try {
                while (!(root = reader.readLine()).matches("^root.*")) { // пока в конфиге не встретили строку root = блабла, переходим на след. строку
                    stringBuilder.append("\n");
                }
                System.out.print(root.substring(7)); //печатаем имя корневой ветки с 8 символа - пропускаем "root = "

            } finally {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    public String[] getFolders() throws FileNotFoundException { // возвращает из конфига имена ветвей
        ArrayList<String> test = new ArrayList<String>();

        StringBuilder stringBuilder = new StringBuilder();
        checkConfigExist("config\\rc.conf");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("config\\rc.conf").getAbsoluteFile()));
            try {
                //пропустить пустые строки конфига
                String s;
                while ((s = reader.readLine()).equals("")) {
                    stringBuilder.append("\n");
                }
                if (s.charAt(0) == '[') { // пропустить [global]
                    stringBuilder.append("\n");
                }
                while (!(s = reader.readLine()).matches("^\\[.*")) {
                    if (s.matches("^folder.*")) {
                        test.add(s.substring(9));
                        stringBuilder.append("\n");
                    }
                }
                // запихнуть arraylist  в string[]
                String folders[] = new String[test.size()];
                for (int i = 0; i < test.size(); i++) {
                    folders[i] = test.get(i);
                }
                return folders;
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder(); //Этот спец. объект для построения строки
        File file = new File(fileName); // Файл
        checkConfigExist(fileName); // проверка, что файл существует
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) { //В цикле построчно считываем файл
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString(); //Возвращаем полученный текст с файла
    }

    private static void checkConfigExist(String fileName) throws FileNotFoundException { // метод проверки файла на существование
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName()); // если файла нет - пульнуть exception
        }
    }

    //public static void main(String[] args) throws FileNotFoundException {
        //Чтение файла
        /*String fileName = "config\\rc.conf";
        String textFromFile = ConfigReader.read(fileName);
        System.out.println(textFromFile);*/


    //}
}
