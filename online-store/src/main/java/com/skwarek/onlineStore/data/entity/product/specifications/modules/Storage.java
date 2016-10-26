package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Michal on 30.09.2016.
 */
@Embeddable
public class Storage implements Serializable {

    private static final long serialVersionUID = -521811971477233640L;

    @Column(name = "disk_memory")
    private Integer diskMemory;

    @Column(name = "disk_type")
    private String type;

    public Storage() { }

    public Integer getDiskMemory() {
        return diskMemory;
    }

    public void setDiskMemory(Integer diskMemory) {
        this.diskMemory = diskMemory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;

        Storage storage = (Storage) o;

        if (diskMemory != null ? !diskMemory.equals(storage.diskMemory) : storage.diskMemory != null) return false;
        return type != null ? type.equals(storage.type) : storage.type == null;

    }

    @Override
    public int hashCode() {
        int result = diskMemory != null ? diskMemory.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return diskMemory + " GB" +
                ((type == null) ? "" : " " + type);
    }
}
