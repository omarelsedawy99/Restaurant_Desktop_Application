package A;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DatabaseFile implements Serializable {

    public boolean input(String FilePath, Object data) {
        try {
            ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath));
            writter.writeObject(data);
            writter.close();
            return true;
        } catch (IOException e) {

        }
        return false;
    }

    public Object output(String FilePath) {
        Object Readed = null;

        try {
            ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(FilePath));
            Readed = Reader.readObject();
            Reader.close();

        } catch (IOException | ClassNotFoundException e) {

        }
        return Readed;
    }

}
