package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.UploadFileDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 03.10.2016.
 */
@Repository("uploadFileDao")
public class UploadFileDaoImpl extends GenericDaoImpl<UploadFile, Long> implements UploadFileDao {

}
