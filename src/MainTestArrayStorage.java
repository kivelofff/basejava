/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.uuid = "uuid1";
        Resume r2 = new Resume();
        r2.uuid = "uuid2";
        Resume r3 = new Resume();
        r3.uuid = "uuid3";

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.uuid));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.uuid);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
        extendedTest();
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }

    static void extendedTest() {
        System.out.println("Extended test");
        System.out.println("Test 1. Delete all resumes with given uuid");
        ARRAY_STORAGE.clear();
        Resume r1 = new Resume();
        r1.uuid = "first";
        Resume r2 = new Resume();
        r2.uuid = "second";
        Resume r3 = new Resume();
        r3.uuid = "second";
        Resume r4 = new Resume();
        r4.uuid = "third";
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r4);
        printAll();
        System.out.println("Delete elements with uuid = second");
        ARRAY_STORAGE.delete("second");
        printAll();

        System.out.println("Test2. Delete non existing uuid");
        ARRAY_STORAGE.clear();
        Resume r1341314 = new Resume();
        r1341314.uuid = "i dont care";
        ARRAY_STORAGE.save(r1341314);
        ARRAY_STORAGE.delete("blabla");
        printAll();

        System.out.println("Test 2. Delete from empty storage");
        ARRAY_STORAGE.clear();
        ARRAY_STORAGE.delete("12345");
        printAll();

    }
}
