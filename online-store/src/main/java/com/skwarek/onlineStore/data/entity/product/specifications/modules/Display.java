package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.*;
import java.util.Locale;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "display")
public class Display {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "diagonal")
    private Double diagonal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "display_resolution_id")
    private DisplayResolution displayResolution;

    public Display() { }

    public Display(Double diagonal) {
        this.diagonal = diagonal;
    }

    private int calculationOfDensity() {
        Integer widthInPixels = displayResolution.getWidthInPixels();
        Integer heightInPixels = displayResolution.getHeightInPixels();
        return (int) Math.round(Math.sqrt(widthInPixels * widthInPixels + heightInPixels * heightInPixels) / diagonal);
    }

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

    public DisplayResolution getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(DisplayResolution displayResolution) {
        this.displayResolution = displayResolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Display)) return false;

        Display display = (Display) o;

        if (id != null ? !id.equals(display.id) : display.id != null) return false;
        if (diagonal != null ? !diagonal.equals(display.diagonal) : display.diagonal != null) return false;
        return displayResolution != null ? displayResolution.equals(display.displayResolution) : display.displayResolution == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (diagonal != null ? diagonal.hashCode() : 0);
        result = 31 * result + (displayResolution != null ? displayResolution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%.1f", diagonal) +
                "\", with " + displayResolution +
                " resolution at " + calculationOfDensity() + "ppi";
    }
}
