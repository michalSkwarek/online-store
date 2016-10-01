package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.*;

/**
 * Created by Michal on 01.10.2016.
 */
@Entity
@Table(name = "display_resolution")
public class DisplayResolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "width_in_pixels")
    private Integer widthInPixels;

    @Column(name = "height_in_pixels")
    private Integer heightInPixels;

    public DisplayResolution() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWidthInPixels() {
        return widthInPixels;
    }

    public void setWidthInPixels(Integer widthInPixels) {
        this.widthInPixels = widthInPixels;
    }

    public Integer getHeightInPixels() {
        return heightInPixels;
    }

    public void setHeightInPixels(Integer heightInPixels) {
        this.heightInPixels = heightInPixels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisplayResolution)) return false;

        DisplayResolution that = (DisplayResolution) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (widthInPixels != null ? !widthInPixels.equals(that.widthInPixels) : that.widthInPixels != null)
            return false;
        return heightInPixels != null ? heightInPixels.equals(that.heightInPixels) : that.heightInPixels == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (widthInPixels != null ? widthInPixels.hashCode() : 0);
        result = 31 * result + (heightInPixels != null ? heightInPixels.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return widthInPixels + " \u00D7 " + heightInPixels;
    }
}
