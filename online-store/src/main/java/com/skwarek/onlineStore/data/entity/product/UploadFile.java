package com.skwarek.onlineStore.data.entity.product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Michal on 03.10.2016.
 */
@Entity
@Table(name = "files_upload")
public class UploadFile implements Serializable {

    private static final long serialVersionUID = 4817526488251095234L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "data")
    @Lob
    private byte[] data;

    public UploadFile() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadFile)) return false;

        UploadFile that = (UploadFile) o;

        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        return Arrays.equals(data, that.data);

    }

    @Override
    public int hashCode() {
        int result = fileName != null ? fileName.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "UploadFile{" +
                "fileName=" + fileName +
                '}';
    }
}
