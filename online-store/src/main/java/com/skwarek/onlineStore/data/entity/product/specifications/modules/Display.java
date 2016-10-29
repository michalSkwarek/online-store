package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "display")
public class Display implements Serializable {

    private static final long serialVersionUID = 574478679360415794L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "diagonal")
    private Double diagonal;

    @Column(name = "width_in_pixels")
    private Integer widthInPixels;

    @Column(name = "height_in_pixels")
    private Integer heightInPixels;

    public Display() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
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

    private int calculationOfDensity() {
        return (int) Math.round(Math.sqrt(widthInPixels * widthInPixels + heightInPixels * heightInPixels) / diagonal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Display)) return false;

        Display display = (Display) o;

        if (diagonal != null ? !diagonal.equals(display.diagonal) : display.diagonal != null) return false;
        if (widthInPixels != null ? !widthInPixels.equals(display.widthInPixels) : display.widthInPixels != null)
            return false;
        return heightInPixels != null ? heightInPixels.equals(display.heightInPixels) : display.heightInPixels == null;

    }

    @Override
    public int hashCode() {
        int result = diagonal != null ? diagonal.hashCode() : 0;
        result = 31 * result + (widthInPixels != null ? widthInPixels.hashCode() : 0);
        result = 31 * result + (heightInPixels != null ? heightInPixels.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%.1f", diagonal) +
                "\", with " + widthInPixels + " \u00D7 " + heightInPixels +
                " resolution at " + calculationOfDensity() + "ppi";
    }
}
