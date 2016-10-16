package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "os")
public class OS implements Serializable {

    private static final long serialVersionUID = 6001672831050783364L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "version")
    private String version;

    public OS() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OS)) return false;

        OS os = (OS) o;

        if (id != null ? !id.equals(os.id) : os.id != null) return false;
        if (name != null ? !name.equals(os.name) : os.name != null) return false;
        return version != null ? version.equals(os.version) : os.version == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + version;
    }
}
