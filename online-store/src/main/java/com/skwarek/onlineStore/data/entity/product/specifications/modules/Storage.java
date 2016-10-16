package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Michal on 30.09.2016.
 */
@Embeddable
public class Storage implements Serializable {

    private static final long serialVersionUID = 7312755602066174729L;

    @Column(name = "disk_memory")
    private Integer diskMemory;

    public Storage() { }

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
