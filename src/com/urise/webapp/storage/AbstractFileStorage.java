package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File>{
    protected File directory;

    public AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must be not null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not a directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        //get all files
        //delete

        File[] files = directory.listFiles();
        for (int i = 0; i < files.length; i++) {
            files[i].delete();
        }
    }

    @Override
    protected File getPosition(Resume r) {
        return new File(directory, r.getUuid());
    }

    @Override
    protected void addElement(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw  new StorageException("IO error", file.getName(), e);
        }
    }

    protected abstract void doWrite(Resume r, File file) throws IOException;

    @Override
    protected Resume getElement(File file) {
        if (!file.canRead()) {
            throw new IllegalArgumentException(file.getAbsolutePath() + " is not acessible");
        }
        //do read
        return doRead(file);
    }

    protected abstract Resume doRead(File file);

    @Override
    protected void removeElement(File file) {
        file.delete();

    }

    @Override
    protected void replaceElement(Resume r, File file) {

        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw  new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected List<Resume> getAllElements() {
        List<Resume> allResumes = new ArrayList<>();
        File[] files = directory.listFiles();
        for (int i = 0; i < files.length; i++) {
            allResumes.add(doRead(files[i]));
        }
        //do read for all
        return allResumes;
    }

    @Override
    public int size() {
        File[] files = directory.listFiles();
        //calculate number of files in folder
        return files != null ? files.length : 0;
    }

    @Override
    protected boolean isExists(File file) {
        return file.exists();
    }
}
