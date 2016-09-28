package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.*;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "os")
public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "version")
    private String version;

    public OS() { }

    public OS(String name, String version) {
        this.name = name;
        this.version = version;
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

        if (name != null ? !name.equals(os.name) : os.name != null) return false;
        return version != null ? version.equals(os.version) : os.version == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + version;
    }
}
