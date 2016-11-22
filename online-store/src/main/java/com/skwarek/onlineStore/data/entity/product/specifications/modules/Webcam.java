package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Michal on 01.10.2016.
 */
@Embeddable
public class Webcam implements Serializable {

    private static final long serialVersionUID = -8355833593233695195L;

    @Min(value = 0, message = "{Specifications.webcam.resolutionWebcam.validation.min}")
    @Digits(integer = 3, fraction = 1, message = "{Specifications.webcam.resolutionWebcam.validation.digits}")
    @Column(name = "resolution_webcam")
    private Double resolutionWebcam;

    public Webcam() { }

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
