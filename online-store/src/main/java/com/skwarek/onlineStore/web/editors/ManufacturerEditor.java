package com.skwarek.onlineStore.web.editors;

import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.service.ManufacturerService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Michal on 28.09.2016.
 */
public class ManufacturerEditor extends PropertyEditorSupport {

    private ManufacturerService manufacturerService;

    public ManufacturerEditor(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = Integer.parseInt(text);
        Manufacturer manufacturer = manufacturerService.read(id);
        setValue(manufacturer);
    }
}
