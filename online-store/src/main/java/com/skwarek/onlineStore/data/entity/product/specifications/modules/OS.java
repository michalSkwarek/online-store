package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "os")
public class OS extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1353287992705749589L;

    @NotEmpty(message = "{Specifications.os.name.validation.notEmpty}")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "{Specifications.os.version.validation.notEmpty}")
    @Column(name = "version")
    private String version;

    public OS() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.equals("") ? null : name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version.equals("") ? null : version;
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
