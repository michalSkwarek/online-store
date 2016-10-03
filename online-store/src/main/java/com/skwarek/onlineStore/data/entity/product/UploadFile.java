package com.skwarek.onlineStore.data.entity.product;

import javax.persistence.*;

/**
 * Created by Michal on 03.10.2016.
 */
@Entity
@Table(name = "files_upload")
public class UploadFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "data_name")
    @Lob
    private byte[] data;

	@OneToOne(mappedBy = "productImage", cascade = CascadeType.ALL)
	private Product product;
    
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
}
