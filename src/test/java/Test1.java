import com.rmk.config.ApplicationConfig;
import com.rmk.model.Catalog;
import com.rmk.model.Product;
import com.rmk.service.CartService;
import com.rmk.service.CatalogService;
import com.rmk.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RashMin on 29-10-2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class Test1 {

    @Autowired
    @Qualifier("cartservice")
    CartService cartService;

    @Autowired
    @Qualifier("catalogservice")
    CatalogService catalogService;

    @Autowired
    @Qualifier("productservice")
    ProductService productService;

    private final Logger logger = LoggerFactory.getLogger(Test1.class);

    @Test
    public void test1(){
        Catalog c1 = new Catalog();
        c1.setName("catalog1");

        c1=catalogService.saveCatalog(c1);

        Product p1 = new Product();
        Product p2 = new Product();

        p1.setName("p1");
        p1.setInStock(false);
        p1.setPrice(1.34d);
        p1.setRating(1);
        p1.setCatalog(c1);

        p2.setName("p2");
        p2.setInStock(true);
        p2.setPrice(1.34d);
        p2.setRating(1);
        p2.setQty(5);
        p2.setCatalog(c1);

        Set<Product> setP = new HashSet<>();
        setP.add(p1); setP.add(p2);
        c1.getProducts().add(p1);
        c1.getProducts().add(p2);



        productService.create(p1);
        productService.create(p2);

        assert ("catalog1".equals(c1.getName()));
        assert ("p1".equals(c1.getProducts().iterator().next().getName()));
        assert ("catalog1".equals(p2.getCatalog().getName()));


    }


}
