package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
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
    protected Resume getElement(File pos) {
        return null;
    }

    @Override
    protected void removeElement(File pos) {

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
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected boolean isExists(File file) {
        return file.exists();
    }
}
