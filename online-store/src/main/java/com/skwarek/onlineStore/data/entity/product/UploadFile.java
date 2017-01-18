package com.skwarek.onlineStore.data.entity.product;

import com.skwarek.onlineStore.data.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Michal on 03.10.2016.
 */
@Entity
@Table(name = "files_upload")
public class UploadFile extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1658099054017888965L;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "data")
    @Lob
    private byte[] data;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "productImage")
    private Product product;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "logo")
    private Manufacturer manufacturer;

    public UploadFile() { }

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
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
                "}";
    }
}
