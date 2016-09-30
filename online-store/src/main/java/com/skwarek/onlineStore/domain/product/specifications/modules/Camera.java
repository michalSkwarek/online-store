package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Locale;

/**
 * Created by Michal on 27.09.2016.
 */
@Embeddable
public class Camera {

    @Column(name = "resolution_main_camera")
    private Double resolutionMainCamera;

    @Column(name = "resolution_front_camera")
    private Double resolutionFrontCamera;

    public Camera() { }

    public Camera(Double resolutionMainCamera, Double resolutionFrontCamera) {
        this.resolutionMainCamera = resolutionMainCamera;
        this.resolutionFrontCamera = resolutionFrontCamera;
    }

    public Double getResolutionMainCamera() {
        return resolutionMainCamera;
    }

    public void setResolutionMainCamera(Double resolutionMainCamera) {
        this.resolutionMainCamera = resolutionMainCamera;
    }

    public Double getResolutionFrontCamera() {
        return resolutionFrontCamera;
    }

    public void setResolutionFrontCamera(Double resolutionFrontCamera) {
        this.resolutionFrontCamera = resolutionFrontCamera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Camera)) return false;

        Camera camera = (Camera) o;

        if (resolutionMainCamera != null ? !resolutionMainCamera.equals(camera.resolutionMainCamera) : camera.resolutionMainCamera != null)
            return false;
        return resolutionFrontCamera != null ? resolutionFrontCamera.equals(camera.resolutionFrontCamera) : camera.resolutionFrontCamera == null;

    }

    @Override
    public int hashCode() {
        int result = resolutionMainCamera != null ? resolutionMainCamera.hashCode() : 0;
        result = 31 * result + (resolutionFrontCamera != null ? resolutionFrontCamera.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%.1f", resolutionMainCamera) + " MP main camera, " +
                String.format(Locale.US, "%.1f", resolutionFrontCamera) + " MP front camera";
    }
}
