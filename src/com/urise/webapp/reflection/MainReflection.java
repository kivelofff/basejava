package com.urise.webapp.reflection;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    private static Resume resume = new Resume("initial_uuid");

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field field = resume.getClass().getDeclaredField("uuid");
        field.setAccessible(true);
        field.set(resume, (String)"new_uid");
        Method method = resume.getClass().getDeclaredMethod("toString");
        method.setAccessible(true);
        System.out.println(method.invoke(resume));
    }
}
