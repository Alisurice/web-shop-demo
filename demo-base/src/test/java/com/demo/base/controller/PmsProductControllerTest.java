package com.demo.base.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@RunWith(SpringRunner.class)
class PmsProductControllerTest {
    @Autowired
    PmsProductController pmsProductController;

    private MockMvc mockmvc;


    @Test
    void create() throws Exception {
        String param = "{\n" +
                "  \"albumPics\": \"string\",\n" +
                "  \"brandId\": 0,\n" +
                "  \"brandName\": \"string\",\n" +
                "  \"deleteStatus\": 0,\n" +
                "  \"description\": \"string\",\n" +
                "  \"detailDesc\": \"string\",\n" +
                "  \"detailHtml\": \"string\",\n" +
                "  \"detailMobileHtml\": \"string\",\n" +
                "  \"detailTitle\": \"string\",\n" +
                "  \"feightTemplateId\": 0,\n" +
                "  \"giftGrowth\": 0,\n" +
                "  \"giftPoint\": 0,\n" +
                "  \"id\": 0,\n" +
                "  \"keywords\": \"string\",\n" +
                "  \"lowStock\": 0,\n" +
                "  \"memberPriceList\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"memberLevelId\": 0,\n" +
                "      \"memberLevelName\": \"string\",\n" +
                "      \"memberPrice\": 0,\n" +
                "      \"productId\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": \"string\",\n" +
                "  \"newStatus\": 0,\n" +
                "  \"note\": \"string\",\n" +
                "  \"originalPrice\": 0,\n" +
                "  \"pic\": \"string\",\n" +
                "  \"prefrenceAreaProductRelationList\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"prefrenceAreaId\": 0,\n" +
                "      \"productId\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"previewStatus\": 0,\n" +
                "  \"price\": 0,\n" +
                "  \"productAttributeCategoryId\": 0,\n" +
                "  \"productAttributeValueList\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"productAttributeId\": 0,\n" +
                "      \"productId\": 0,\n" +
                "      \"value\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"productCategoryId\": 0,\n" +
                "  \"productCategoryName\": \"string\",\n" +
                "  \"productFullReductionList\": [\n" +
                "    {\n" +
                "      \"fullPrice\": 0,\n" +
                "      \"id\": 0,\n" +
                "      \"productId\": 0,\n" +
                "      \"reducePrice\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"productLadderList\": [\n" +
                "    {\n" +
                "      \"count\": 0,\n" +
                "      \"discount\": 0,\n" +
                "      \"id\": 0,\n" +
                "      \"price\": 0,\n" +
                "      \"productId\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"productSn\": \"string\",\n" +
                "  \"promotionEndTime\": \"2021-08-10T06:45:01.427Z\",\n" +
                "  \"promotionPerLimit\": 0,\n" +
                "  \"promotionPrice\": 0,\n" +
                "  \"promotionStartTime\": \"2021-08-10T06:45:01.427Z\",\n" +
                "  \"promotionType\": 0,\n" +
                "  \"publishStatus\": 0,\n" +
                "  \"recommandStatus\": 0,\n" +
                "  \"sale\": 0,\n" +
                "  \"serviceIds\": \"string\",\n" +
                "  \"skuStockList\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"lockStock\": 0,\n" +
                "      \"lowStock\": 0,\n" +
                "      \"pic\": \"string\",\n" +
                "      \"price\": 0,\n" +
                "      \"productId\": 0,\n" +
                "      \"promotionPrice\": 0,\n" +
                "      \"sale\": 0,\n" +
                "      \"skuCode\": \"string\",\n" +
                "      \"spData\": \"string\",\n" +
                "      \"stock\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"sort\": 0,\n" +
                "  \"stock\": 0,\n" +
                "  \"subTitle\": \"string\",\n" +
                "  \"subjectProductRelationList\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"productId\": 0,\n" +
                "      \"subjectId\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"unit\": \"string\",\n" +
                "  \"usePointLimit\": 0,\n" +
                "  \"verifyStatus\": 0,\n" +
                "  \"weight\": 0\n" +
                "}";
        mockmvc.perform(post("/product/create").content(param).contentType(MediaType.APPLICATION_JSON));
    }
}