package com.skwarek.onlineStore.domain.product.specifications.modules;

/**
 * Created by Michal on 27.09.2016.
 */
public class Dimensions {

    private Double height;
    private Double width;
    private Double thickness;

    public Dimensions(Double height, Double width, Double thickness) {
        this.height = height;
        this.width = width;
        this.thickness = thickness;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dimensions)) return false;

        Dimensions that = (Dimensions) o;

        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        return thickness != null ? thickness.equals(that.thickness) : that.thickness == null;

    }

    @Override
    public int hashCode() {
        int result = height != null ? height.hashCode() : 0;
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return outputFormat(height) + " mm \u00D7 " + outputFormat(width) + " mm \u00D7 " + outputFormat(thickness) + " mm";
    }

    private static String outputFormat(double d) {
        if(d == (int) d) {
            return String.format("%d", (int) d);
        } else {
            return String.format("%s", d);
        }
    }
}
