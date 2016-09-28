package com.skwarek.onlineStore.domain.product.specifications.modules;

/**
 * Created by Michal on 27.09.2016.
 */
public class Storage {

    private Integer diskMemory;

    public Storage() { }

    public Storage(Integer diskMemory) {
        this.diskMemory = diskMemory;
    }

    public Integer getDiskMemory() {
        return diskMemory;
    }

    public void setDiskMemory(Integer diskMemory) {
        this.diskMemory = diskMemory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;

        Storage storage = (Storage) o;

        return diskMemory != null ? diskMemory.equals(storage.diskMemory) : storage.diskMemory == null;

    }

    @Override
    public int hashCode() {
        return diskMemory != null ? diskMemory.hashCode() : 0;
    }

    @Override
    public String toString() {
        return diskMemory + " GB";
    }
}
