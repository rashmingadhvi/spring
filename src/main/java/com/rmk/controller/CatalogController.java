package com.rmk.controller;

import com.rmk.model.Catalog;
import com.rmk.model.Product;
import com.rmk.model.ShoppingItem;
import com.rmk.service.CartService;
import com.rmk.service.CatalogService;
import com.rmk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by RashMin on 06-11-2016.
 */
@RestController(value="catalogcontroller")
public class CatalogController {


    @Autowired
    @Qualifier("catalogservice")
    CatalogService catalogService;


    @RequestMapping(name = "/addcatalogproduct"
            ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,method = RequestMethod.POST)
    public boolean addProductToCatalog(Integer catalogId, Product product){
        return catalogService.addProduct(catalogId,product);
    }

    @RequestMapping(name = "/removecatalogproduct"
            ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,method = RequestMethod.DELETE)
    public boolean removeProductFromCatalog(@RequestParam(name = "catalogid") Integer catalogId
            , @RequestParam(name = "productsku") String sku){
       return catalogService.removeProduct(catalogId,sku);
    }

    @RequestMapping(name = "/getcatalogproduct"
            ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE
            ,method = RequestMethod.GET)
    public Set<Product> listProducts(@RequestParam(name = "catalogid") Integer catalogId){
        return catalogService.listCatalogProducts(catalogId);
    }

    @RequestMapping(name = "/getallcatalog"
            ,produces = MediaType.APPLICATION_JSON_VALUE
            ,method = RequestMethod.GET)
    public List<Catalog> getAll(){
        return catalogService.listCatalog();
    }
}
