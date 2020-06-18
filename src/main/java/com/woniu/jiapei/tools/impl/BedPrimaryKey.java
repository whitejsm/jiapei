package com.woniu.jiapei.tools.impl;

import com.woniu.jiapei.tools.IPrimaryKey;

import java.util.Date;
import java.util.Random;

public class BedPrimaryKey implements IPrimaryKey {
    @Override
    public String generatePrimaryKey() {
        Date date = new Date();
        return "" + (date.getYear()+1700)+(date.getMonth()+1)+date.getDate()+date.getHours()+date.getMinutes()+date.getSeconds()+"bed"+(9000+new Random().nextInt(1000));
    }
}
