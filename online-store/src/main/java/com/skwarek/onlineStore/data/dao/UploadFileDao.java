package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.product.UploadFile;

/**
 * Created by Michal on 03.10.2016.
 */
public interface UploadFileDao extends GenericDao<UploadFile, Long> {

    void createFile(UploadFile file);
}
