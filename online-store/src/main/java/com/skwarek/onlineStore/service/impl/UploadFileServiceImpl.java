package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.UploadFileDao;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.service.UploadFileService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Michal on 03.10.2016.
 */
@Service("uploadFileService")
@Transactional(propagation = Propagation.REQUIRED)
public class UploadFileServiceImpl extends GenericServiceImpl<UploadFile, Long> implements UploadFileService {

    @Autowired
    private UploadFileDao uploadFileDao;
}
