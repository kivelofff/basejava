package com.urise.webapp.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ResumeTest {
    private static Resume resume;
    private static final String UUID = "UUID_1";
    private static final String FULLNAME = "FULLNAME_1";
    private static final Map<Contacts.CONTACT_TYPE, String> CONTACTS = new HashMap<>();
    private static final Map<String, String> EXPERIENCE = new HashMap<>();
    private static final Map<String, String> EDUCATION = new HashMap<>();
    private static final List<String> QUALIFICATION = new ArrayList<>();
    private static final List<String> ACHIEVE = new ArrayList<>();
    private static final String PERSONAL = "personal1, personal2";
    private static final String OBJECTIVE = "objective1, objective2";

    static {
        CONTACTS.put(Contacts.CONTACT_TYPE.PHONE, "4-222-8");
        CONTACTS.put(Contacts.CONTACT_TYPE.EMAIL, "gizn@schastya.net");
        CONTACTS.put(Contacts.CONTACT_TYPE.HOMEPAGE, "www.kakbynesdohnut.com");

        EXPERIENCE.put("Roga i Koputa", "Senior developer");
        EXPERIENCE.put("Freelance", "Top manager");

        EDUCATION.put("Led Zeppelin", "We don't need your education");

        QUALIFICATION.add("great man");
        QUALIFICATION.add("ugly developer");

        ACHIEVE.add("something");
        ACHIEVE.add("something else");
        resume = new Resume(UUID, FULLNAME, CONTACTS, EXPERIENCE, EDUCATION, QUALIFICATION, ACHIEVE, PERSONAL, OBJECTIVE);
    }


    @Test(expected = Test.None.class)
    public void TestSout() {
        System.out.println(resume.toString());
    }

}