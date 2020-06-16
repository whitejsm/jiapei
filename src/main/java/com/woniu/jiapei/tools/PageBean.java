package com.woniu.jiapei.tools;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PageBean {
    private Integer pageSize = 1;
    private Integer pageNum = 1;
    private Integer pages;
    private Integer total;
}
