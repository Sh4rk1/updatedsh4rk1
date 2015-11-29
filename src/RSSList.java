import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Maciek on 2015-11-29.
 */
public class RSSList {
    public ArrayList<String> RSSList = new ArrayList<String>();

    private String fileName;

    private void saveFile() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(RSSList);
        objectOutputStream.close();
    }

    private void readFile() throws IOException, ClassNotFoundException {
        try{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        RSSList = (ArrayList<String>) objectInputStream.readObject();
        objectInputStream.close();
    }catch(FileNotFoundException e){
            saveFile();
            readFile();
        }
 }
    public void saveCurrentlyList() throws IOException {
        fileName = "currentlyList.bin";
        saveFile();
    }
    public void readCurrentlyList() throws IOException, ClassNotFoundException {
        fileName = "currentlyList.bin";
        readFile();
    }
    public void saveHistory() throws IOException {
        fileName = "history.bin";
        saveFile();
    }
    public void readHistory() throws IOException, ClassNotFoundException {
        fileName = "history.bin";
        readFile();
    }

    }
