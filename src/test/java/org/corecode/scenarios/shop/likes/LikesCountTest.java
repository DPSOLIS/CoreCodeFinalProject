package org.corecode.scenarios.shop.likes;

import org.corecode.scenarios.index.IndexPage;
import org.testng.annotations.BeforeClass;

public class LikesCountTest {

    private LikesCountPage likesCountPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.likesCountPage = new LikesCountPage();
        this.likesCountPage.visitPage();
    }
}
