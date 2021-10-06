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
        if (!ifExists(r.uuid) && !isFull()) {
            storage[counter++]=r;
        } else {
            System.out.println("resume is not exists or storage if full!");
        }
    }

    Resume get(String uuid) {
        int pos = getPosition(uuid);
        if (pos == -1) {
            System.out.println("Resume with uuid: " + uuid + " not found!");
            return null;
        } else {
            return storage[pos];
        }
    }

    void delete(String uuid) {
        int pos = getPosition(uuid);
        if (pos == -1) {
            System.out.println("Resume with uuid: " + uuid + " not found!");
        } else {
            System.arraycopy(storage, pos + 1, storage, pos, storage.length - pos - 1);
            counter--;
        }
    }

    void update(Resume r) {
        if(ifExists(r.uuid)) {
            storage[getPosition(r.uuid)] = r;
        } else {
            System.out.println("Resume not found!");
        }

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

    private boolean ifExists(String uuid) {
        return getPosition(uuid) != -1;
    }

    private boolean isFull() {
        return counter == storage.length-1;
    }
}
