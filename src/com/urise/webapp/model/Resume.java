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

    public Contacts contacts;
    public HashMap<SectionType, Section> sections;


    public Resume(String uuid) {
        Objects.requireNonNull(uuid, "uuid must be not null");
        this.uuid = uuid;
        this.contacts = new Contacts();
        this.sections = new HashMap<>();
        sections.put(SectionType.EXPERIENCE, new MapSection<>(SectionType.EXPERIENCE));
        sections.put(SectionType.EDUCATION, new MapSection<>(SectionType.EDUCATION));
        sections.put(SectionType.QUALIFICATIONS, new ListSection(SectionType.QUALIFICATIONS));
        sections.put(SectionType.ACHIEVE, new ListSection(SectionType.ACHIEVE));
        sections.put(SectionType.PERSONAL, new StringSection(SectionType.PERSONAL));
        sections.put(SectionType.OBJECTIVE, new StringSection(SectionType.OBJECTIVE));
    }

    public Resume(String uuid, String fullName) {
        this(uuid);
        Objects.requireNonNull(fullName, "fullname must be not null");
        this.fullName = fullName;

    }

    public Resume(String uuid,
                  String fullName,
                  Map<Contacts.CONTACT_TYPE, String> contacts,
                  Map<String, String> experience,
                  Map<String, String> education,
                  List<String> qualifications,
                  List<String> achieve,
                  String personal,
                  String objective) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.contacts = new Contacts(contacts);
        this.sections = new HashMap<>();
        sections.put(SectionType.EXPERIENCE, new MapSection<>(experience, SectionType.EXPERIENCE));
        sections.put(SectionType.EDUCATION, new MapSection<>(education, SectionType.EDUCATION));
        sections.put(SectionType.QUALIFICATIONS, new ListSection(qualifications, SectionType.QUALIFICATIONS));
        sections.put(SectionType.ACHIEVE, new ListSection(achieve, SectionType.ACHIEVE));
        sections.put(SectionType.PERSONAL, new StringSection(personal, SectionType.PERSONAL));
        sections.put(SectionType.OBJECTIVE, new StringSection(objective, SectionType.OBJECTIVE));
    }

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(uuid)
                .append(System.lineSeparator())
                .append(fullName)
                .append(System.lineSeparator())
                .append(contacts).append(System.lineSeparator());
        for (Map.Entry<SectionType, Section> e : sections.entrySet()) {
            sb.append(e.getValue()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume o) {
        int i = fullName.compareTo(o.fullName);
        return i !=0 ? i : uuid.compareTo(o.uuid);
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
}
