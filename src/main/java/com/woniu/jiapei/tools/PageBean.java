package com.woniu.jiapei.tools;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PageBean {
    private Integer pageSize = 15;
    private Integer pageNum = 1;
    private Integer pages;
    private Integer total;
}
