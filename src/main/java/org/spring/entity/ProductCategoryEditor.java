package org.spring.entity;

import org.spring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

/**
 * Created by ovoyevodin on 29.09.2016.
 */
public class ProductCategoryEditor extends PropertyEditorSupport {
    @Autowired
    private ShopService shopService;
    @Override
    public void setAsText(String text) {
        this.setValue(shopService.getCategoryById(Integer.parseInt(text)));
    }
}
