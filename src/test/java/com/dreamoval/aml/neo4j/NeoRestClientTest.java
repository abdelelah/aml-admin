package com.dreamoval.aml.neo4j;

import com.dreamoval.aml.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class NeoRestClientTest {

    @Autowired
    NeoRestClient rest;

    @Test
    public void testAddNode() throws Exception {
//        rest.addNode("{\"name\":\"Stephen\"}");
        MultiValueMap<String,String> map = new LinkedMultiValueMap<String, String>();
        map.add("query","MATCH (n:`Account`)<-[:Owns]-(c:Customer {id:'001'}) RETURN n LIMIT 25");
        System.out.println(rest.runQuery(map, String.class));
    }
}