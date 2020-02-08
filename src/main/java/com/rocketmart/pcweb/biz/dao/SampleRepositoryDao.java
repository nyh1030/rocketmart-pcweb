package com.rocketmart.pcweb.biz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleRepositoryDao {

    @Autowired
    DSLContext context;

    @Autowired
    private JDBCT

    public List<Map<String, Object>> selectSample() {

        return context.select()
                .from(SAMPLE)
                .getQuery();
    }
}
