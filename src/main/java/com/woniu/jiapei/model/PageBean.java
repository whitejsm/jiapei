package com.woniu.jiapei.model;

import lombok.Data;

@Data
public class PageBean {
    private Integer currentPage;
    private Integer pages;
    private Integer pageSize = 15;
    private Integer totalCount;

}
