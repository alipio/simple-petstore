package org.testinfected.petstore.controllers;

import org.testinfected.petstore.Page;
import org.testinfected.petstore.product.Item;
import org.testinfected.petstore.product.ItemInventory;
import org.testinfected.support.Application;
import org.testinfected.support.Request;
import org.testinfected.support.Response;

import java.util.List;

import static org.testinfected.petstore.util.Context.context;

public class ListItems implements Application {

    private final ItemInventory itemInventory;
    private final Page itemsPage;

    public ListItems(ItemInventory itemInventory, Page itemsPage) {
        this.itemInventory = itemInventory;
        this.itemsPage = itemsPage;
    }

    public void handle(Request request, Response response) throws Exception {
        String productNumber = request.parameter("product");
        List<Item> items = itemInventory.findByProductNumber (productNumber);
        itemsPage.render(response, context().
                with("in-stock", !items.isEmpty()).
                and("item-count", items.size()).
                and("items", items).asMap());
    }
}
