package id.co.nds.catalogue.services;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.catalogue.entities.SaleEntity;
import id.co.nds.catalogue.exceptions.ClientException;
import id.co.nds.catalogue.models.SaleModel;
import id.co.nds.catalogue.repos.SaleRepo;
import id.co.nds.catalogue.validators.ProductValidator;

@Service
public class SaleService implements Serializable {
    @Autowired
    public SaleRepo saleRepo;

    public ProductValidator productValidator = new ProductValidator();

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { Exception.class })
    public SaleEntity doSale(SaleModel saleModel) throws Exception {
        // validation
        productValidator.nullCheckProductId(saleModel.getProductId());
        if (saleModel.getPrice() == null || saleModel.getQuantity() == null) {
            throw new ClientException("price or quantity cannot be null");
        }

        SaleEntity sale = new SaleEntity();

        sale.setProductId(saleModel.getProductId());
        sale.setPrice(saleModel.getPrice().doubleValue());
        sale.setQuantity(saleModel.getQuantity());
        sale.setTotalPrice(saleModel.getPrice().doubleValue() * saleModel.getQuantity());
        sale.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        // saleRepo.save(sale);

        // if (true) {
        // throw new Exception("Error");
        // }
        // return null;

        return saleRepo.save(sale);
    }
}
