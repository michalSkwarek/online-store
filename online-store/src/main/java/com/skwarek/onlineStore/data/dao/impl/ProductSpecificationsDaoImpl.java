package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.ProductSpecificationsDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.data.entity.product.specifications.modules.*;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Michal on 29.09.2016.
 */
@Repository("productSpecificationsDao")
public class ProductSpecificationsDaoImpl extends GenericDaoImpl<ProductSpecifications, Long> implements ProductSpecificationsDao {

    @Override
    public void createSpecifications(ProductSpecifications productSpecifications) {
//        setCPUToSpecifications(productSpecifications);
        setGPUToSpecifications(productSpecifications);
//        setDisplayToSpecifications(productSpecifications);
//        setOSToSpecifications(productSpecifications);
        create(productSpecifications);
    }

    @Override
    public void updateSpecifications(ProductSpecifications productSpecifications) {
//        setCPUToSpecifications(productSpecifications);
//        setGPUToSpecifications(productSpecifications);
//        setDisplayToSpecifications(productSpecifications);
//        setOSToSpecifications(productSpecifications);
        update(productSpecifications);
    }

    private void setCPUToSpecifications(ProductSpecifications productSpecifications) {
        CPU cpu = getCPUFromDatabase(productSpecifications.getCpu());
        if (cpu != null) {
            productSpecifications.setCpu(cpu);
        }
    }

    private CPU getCPUFromDatabase(CPU cpu) {
        Query query = getSession().createQuery("from CPU c where c.model = :model and c.numberOfCores = :numberOfCores and " +
                "c.lowClockSpeed = :lowClockSpeed and c.highClockSpeed = " + cpu.getHighClockSpeed() + " and c.cache = " + cpu.getCache());

        query.setParameter("model", cpu.getModel());
        query.setParameter("numberOfCores", cpu.getNumberOfCores());
        query.setParameter("lowClockSpeed", cpu.getLowClockSpeed());
        query.setMaxResults(1);
        return (CPU) query.uniqueResult();
    }

    private void setGPUToSpecifications(ProductSpecifications productSpecifications) {
        GPU gpu = getGPUFromDatabase(productSpecifications.getGpu());
        System.out.println("dupa " + productSpecifications.getGpu());
        System.out.println("dupa " + gpu);
        if (gpu != null) {
            productSpecifications.setGpu(gpu);
        }
    }

    private GPU getGPUFromDatabase(GPU gpu) {
        Query query = getSession().createQuery("from GPU g where g.model = :model and g.memory = " + gpu.getMemory() +
                " and g.type = " + (gpu.getType().equals("") ? null : ":type)"));
        query.setParameter("type", gpu.getType());
        query.setMaxResults(1);
        return (GPU) query.uniqueResult();
    }

    private void setMemoryTypeToSpecifications(ProductSpecifications productSpecifications) {
        RAM ram = getMemoryTypeFromDatabase(productSpecifications.getRam());
        if (ram != null) {
            productSpecifications.setRam(ram);
        }
    }

    private RAM getMemoryTypeFromDatabase(RAM ram) {
        Query query = getSession().createQuery("from MemoryType m where m.type = :type");
        query.setParameter("type", ram.getType());
        query.setMaxResults(1);
        return (RAM) query.uniqueResult();
    }

    private void setDisplayToSpecifications(ProductSpecifications productSpecifications) {
        Display display = getDisplayFromDatabase(productSpecifications.getDisplay());
        if (display != null) {
            productSpecifications.setDisplay(display);
        }
    }

    private Display getDisplayFromDatabase(Display display) {
        Query query = getSession().createQuery("from Display d where g.diagonal = :diagonal " +
                "and g.displayResolution.widthInPixels = :widthInPixels and d.displayResolution.heightInPixels = :heightInPixels");
        query.setParameter("diagonal", display.getDiagonal());
        query.setParameter("widthInPixels", display.getDisplayResolution().getWidthInPixels());
        query.setParameter("heightInPixels", display.getDisplayResolution().getHeightInPixels());
        query.setMaxResults(1);
        return (Display) query.uniqueResult();
    }

    private void setOSToSpecifications(ProductSpecifications productSpecifications) {
        OS os  = getOSFromDatabase(productSpecifications.getOs());
        if (os != null) {
            productSpecifications.setOs(os);
        }
    }

    private OS getOSFromDatabase(OS os) {
        Query query = getSession().createQuery("from OS o where o.name = :name and o.version = :version");
        query.setParameter("name", os.getName());
        query.setParameter("version", os.getVersion());
        query.setMaxResults(1);
        return (OS) query.uniqueResult();
    }
}
