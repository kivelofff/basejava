package com.urise.webapp.model;

import java.awt.datatransfer.StringSelection;
import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private String fullName;

    public EnumMap<ContactType, String> contacts;
    public EnumMap<SectionType, Section> sections;


    public Resume(String uuid) {
        Objects.requireNonNull(uuid, "uuid must be not null");
        this.uuid = uuid;
        this.contacts = new EnumMap<>(ContactType.class);
        this.sections = new EnumMap<>(SectionType.class);
    }

    public Resume(String uuid, String fullName) {
        this(uuid);
        Objects.requireNonNull(fullName, "fullname must be not null");
        this.fullName = fullName;

    }

    public Resume() {
        this(UUID.randomUUID().toString());
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public static final Comparator<Resume> RESUME_UUID_COMPARATOR = Comparator.comparing(Resume::getUuid);


    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.getUuid());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        if (!fullName.equals(resume.fullName)) return false;
        if (!contacts.equals(resume.contacts)) return false;
        return sections.equals(resume.sections);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + contacts.hashCode();
        result = 31 * result + sections.hashCode();
        return result;
    }

    public EnumMap<ContactType, String> getContacts() {
        return contacts;
    }

    public EnumMap<SectionType, Section> getSections() {
        return sections;
    }

    public void addContact(ContactType type, String contact) {
        contacts.put(type, contact);
    }

    public boolean removeContact(ContactType type) {
        return contacts.remove(type) != null;
    }

    public void addSection(SectionType type, Section section) {
        sections.put(type, section);
    }

    public boolean removeSection(SectionType type) {
        return sections.remove(type) != null;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contacts=" + contacts +
                ", sections=" + sections +
                '}';
    }
}
