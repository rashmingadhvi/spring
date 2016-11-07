create table shoppingcart (cartid integer primary key, itemid integer );
create table catalog (catalogid integer primary key, name varchar);

create table product (sku varchar, name varchar ,rating integer ,price double ,instock boolean ,qty integer ,catalogid integer );
alter table product add constraint product_catalog_fk FOREIGN KEY(catalogid) REFERENCES catalog (catalogid);

create table shoppingitem (itemid integer primary key, qty integer, cartid integer, sortorder integer, sequence integer, rating integer, sku varchar);
alter table shoppingitem add constraint item_cart_fk FOREIGN KEY(cartid) REFERENCES shoppingcart (cartid);
alter table shoppingitem add constraint item_product_fk FOREIGN KEY(sku) REFERENCES product (sku);


