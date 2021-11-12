package com.urise.webapp.model;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class ResumeTest {
    private static Resume resume;
    private static final String UUID = "UUID_1";
    private static final String FULLNAME = "FULLNAME_1";

    private static final String PHONE = "4-222-8";
    private static final String EMAIL = "gizn@schastya.net";
    private static final String HOMEPAGE = "www.kakbynesdohnut.com";

    private static final Organisation PLACE_OF_STUDY = new Organisation(new Link("Sharaga", "www.sharaga.com"),
            LocalDate.of(2004, 8, 1),
            LocalDate.of(2010, 1, 1),
            null,
            "Lost time");
    private static  final Organisation PLACE_OF_WORK = new Organisation(new Link("Roga i Koputa", null),
            LocalDate.of(2011, 6, 1),
            LocalDate.of(2019, 9, 15),
            "Laborant",
            "Stupiest laborant in the world");

    private static final List<String> QUALIFICATION = new ArrayList<>();
    private static final List<String> ACHIEVE = new ArrayList<>();
    private static final String PERSONAL = "personal1, personal2";
    private static final String OBJECTIVE = "objective1, objective2";

    static {

        QUALIFICATION.add("great man");
        QUALIFICATION.add("ugly developer");

        ACHIEVE.add("something");
        ACHIEVE.add("something else");
        resume = new Resume(UUID, FULLNAME);
        resume.addContact(ContactType.PHONE, PHONE);
        resume.addContact(ContactType.EMAIL, EMAIL);
        resume.addContact(ContactType.HOMEPAGE, HOMEPAGE);

        resume.addSection(SectionType.PERSONAL, new StringSection(PERSONAL));
        resume.addSection(SectionType.OBJECTIVE, new StringSection(OBJECTIVE));

        resume.addSection(SectionType.ACHIEVE, new ListSection(ACHIEVE));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection(QUALIFICATION));

        resume.addSection(SectionType.EXPERIENCE, new OrganisationSection(List.of(PLACE_OF_WORK)));
        resume.addSection(SectionType.EDUCATION, new OrganisationSection(List.of(PLACE_OF_STUDY)));
    }


    @Test(expected = Test.None.class)
    public void TestSout() {
        System.out.println(resume.toString());
    }

}