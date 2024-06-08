package homeWork.family_tree;

import java.io.Serial;
import java.io.Serializable;

public interface Writeable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
