package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.ProductDao;
import com.skwarek.onlineStore.data.dao.ProductSpecificationsDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.data.entity.product.specifications.modules.CPU;
import com.skwarek.onlineStore.data.entity.product.specifications.modules.Display;
import com.skwarek.onlineStore.data.entity.product.specifications.modules.GPU;
import com.skwarek.onlineStore.data.entity.product.specifications.modules.OS;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 29.09.2016.
 */
@Repository("productSpecificationsDao")
public class ProductSpecificationsDaoImpl extends GenericDaoImpl<ProductSpecifications, Long> implements ProductSpecificationsDao {

    @Autowired
    private ProductDao productDao;

    @Override
    public void createSpecifications(ProductSpecifications productSpecifications, Product product) {
        setExistingData(productSpecifications);
        create(productSpecifications);
        product.setProductSpecifications(productSpecifications);
        productDao.updateProduct(product);
    }

    @Override
    public void updateSpecifications(ProductSpecifications productSpecifications) {
        setExistingData(productSpecifications);
        update(productSpecifications);
    }

    private void setExistingData(ProductSpecifications productSpecifications) {
        if (productSpecifications.getCpu() != null) {
            setCPUToSpecifications(productSpecifications);
        }
        if (productSpecifications.getGpu() != null) {
            setGPUToSpecifications(productSpecifications);
        }
        if (productSpecifications.getDisplay() != null) {
            setDisplayToSpecifications(productSpecifications);
        }
        if (productSpecifications.getOs() != null) {
            setOSToSpecifications(productSpecifications);
        }
    }

    private void setCPUToSpecifications(ProductSpecifications productSpecifications) {
        CPU cpu = getCPUFromDatabase(productSpecifications.getCpu());
        if (cpu != null) {
            productSpecifications.setCpu(cpu);
        }
    }

    private CPU getCPUFromDatabase(CPU cpu) {
        Query query = getSession().createSQLQuery("SELECT * FROM cpu AS c WHERE c.model = '" + cpu.getModel() + "'" +
                " AND c.number_of_cores = " + cpu.getNumberOfCores() +
                " AND c.low_clock_speed = " + cpu.getLowClockSpeed() +
                " AND c.high_clock_speed" + ((cpu.getHighClockSpeed() == null) ? " IS NULL" : (" = " + cpu.getHighClockSpeed())) +
                " LIMIT 1").addEntity(CPU.class);
        return (CPU) query.uniqueResult();
    }

    private void setGPUToSpecifications(ProductSpecifications productSpecifications) {
        GPU gpu = getGPUFromDatabase(productSpecifications.getGpu());
        if (gpu != null) {
            productSpecifications.setGpu(gpu);
        }
    }

    private GPU getGPUFromDatabase(GPU gpu) {
        Query query = getSession().createSQLQuery("SELECT * FROM gpu AS g WHERE g.model = '" + gpu.getModel() + "'" +
                " AND g.memory" + ((gpu.getMemory() == null) ? " IS NULL" : (" = " + gpu.getMemory())) +
                " AND g.memory_type" + ((gpu.getType() == null) ? " IS NULL" : (" = '" + gpu.getType()) + "'") +
                " LIMIT 1").addEntity(GPU.class);
        return (GPU) query.uniqueResult();
    }

    private void setDisplayToSpecifications(ProductSpecifications productSpecifications) {
        Display display = getDisplayFromDatabase(productSpecifications.getDisplay());
        if (display != null) {
            productSpecifications.setDisplay(display);
        }
    }

    private Display getDisplayFromDatabase(Display display) {
        Query query = getSession().createSQLQuery("SELECT * FROM display d where d.diagonal = " + display.getDiagonal() +
                " AND d.width_in_pixels = " + display.getWidthInPixels() +
                " AND d.height_in_pixels = " + display.getHeightInPixels() +
                " LIMIT 1").addEntity(Display.class);
        return (Display) query.uniqueResult();
    }

    private void setOSToSpecifications(ProductSpecifications productSpecifications) {
        OS os  = getOSFromDatabase(productSpecifications.getOs());
        if (os != null) {
            productSpecifications.setOs(os);
        }
    }

    private OS getOSFromDatabase(OS os) {
        Query query = getSession().createSQLQuery("SELECT * FROM os AS o WHERE o.name = '" + os.getName() + "'" +
                " AND o.version = '" + os.getVersion() + "'" +
                " LIMIT 1").addEntity(OS.class);
        return (OS) query.uniqueResult();
    }
}
