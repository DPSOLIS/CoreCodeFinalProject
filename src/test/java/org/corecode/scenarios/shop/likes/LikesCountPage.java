package org.corecode.scenarios.shop.likes;

import org.corecode.base.BaseTest;

public class LikesCountPage extends BaseTest {
    private static final String ROUTE_INDEX_RESOURCE = "/challenge/index.html";
    public void visitPage(){
        this.visit(ROUTE_INDEX_RESOURCE);
    }
}
