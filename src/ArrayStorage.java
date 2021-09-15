import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int counter = 0;

    void clear() {
        counter = 0;
    }

    void save(Resume r) {
        storage[counter++]=r;
    }

    Resume get(String uuid) {
        int pos = getPosition(uuid);
        return (pos == -1) ? null : storage[pos];
    }

    void delete(String uuid) {
        int pos = getPosition(uuid);
        System.arraycopy(storage, pos+1, storage, pos, storage.length-pos-1);
        counter--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, counter);
    }

    int size() {
        return counter;
    }

    private int getPosition(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
