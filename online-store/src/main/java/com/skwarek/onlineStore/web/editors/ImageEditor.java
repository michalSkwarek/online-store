package com.skwarek.onlineStore.web.editors;

import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.service.UploadFileService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Michal on 04.10.2016.
 */
public class ImageEditor extends PropertyEditorSupport {

        private UploadFileService uploadFileService;

        public ImageEditor(UploadFileService uploadFileService) {
            this.uploadFileService = uploadFileService;
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            long id = Integer.parseInt(text);
            UploadFile uploadFile = uploadFileService.read(id);
            setValue(uploadFile);
        }
    }
