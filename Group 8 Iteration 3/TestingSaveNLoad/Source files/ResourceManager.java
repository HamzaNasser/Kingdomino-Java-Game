import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class ResourceManager {
    public static void save(Serializable data, String filename)throws Exception{
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(Paths.get(filename))))){
            oos.writeObject(data);
            oos.flush();
            oos.close();
            //return true;
            }   
    }

    public static Object load(String filename)throws Exception{
        ArrayList<Object> list = null;
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(Paths.get(filename))))){
            list = (ArrayList<Object>) ois.readObject();
            ois.close();
            return list;
        }
    }
}
