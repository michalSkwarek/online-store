package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Locale;

/**
 * Created by Michal on 01.10.2016.
 */
@Embeddable
public class Webcam {

    @Column(name = "resolution_webcam")
    private Double resolutionWebcam;

    public Webcam() { }

    public Webcam(Double resolutionWebcam) {
        this.resolutionWebcam = resolutionWebcam;
    }

    public Double getResolutionWebcam() {
        return resolutionWebcam;
    }

    public void setResolutionWebcam(Double resolutionWebcam) {
        this.resolutionWebcam = resolutionWebcam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Webcam)) return false;

        Webcam webcam = (Webcam) o;

        return resolutionWebcam != null ? resolutionWebcam.equals(webcam.resolutionWebcam) : webcam.resolutionWebcam == null;

    }

    @Override
    public int hashCode() {
        return resolutionWebcam != null ? resolutionWebcam.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%.1f", resolutionWebcam) + " MP";
    }
}
