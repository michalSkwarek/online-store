package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Michal on 27.09.2016.
 */
@Embeddable
public class Dimensions {

    @Column(name = "thickness")
    private Double thickness;

    @Column(name = "width")
    private Double width;

    @Column(name = "height")
    private Double height;

    public Dimensions() { }

    public Dimensions(Double thickness, Double width, Double height) {
        this.thickness = thickness;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dimensions)) return false;

        Dimensions that = (Dimensions) o;

        if (thickness != null ? !thickness.equals(that.thickness) : that.thickness != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        return height != null ? height.equals(that.height) : that.height == null;

    }

    @Override
    public int hashCode() {
        int result = thickness != null ? thickness.hashCode() : 0;
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return outputFormat(thickness) + " mm \u00D7 " + outputFormat(width) + " mm \u00D7 " + outputFormat(height) + " mm";
    }

    private static String outputFormat(double d) {
        if(d == (int) d) {
            return String.format("%d", (int) d);
        } else {
            return String.format("%s", d);
        }
    }
}
