package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.BedCondition;
import com.woniu.jiapei.mapper.BedMapper;
import com.woniu.jiapei.model.Bed;
import com.woniu.jiapei.model.BedExample;
import com.woniu.jiapei.service.IBedService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 床位管理的实现类
 */
@Service
public class BedServiceImpl implements IBedService {
    @Resource
    private BedMapper bedMapper;


    /**
     * 查询所有
     * @param pageBean
     * @return
     */
    public List<Bed> findAll(PageBean pageBean) {
        PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
        List<Bed> bedList = bedMapper.findAll();
        PageInfo<Bed> pageInfo = new PageInfo<Bed>(bedList);
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal((int) pageInfo.getTotal());
        return bedList;
    }

    /**
     * 根据床位id查询
     * @param bedId
     * @return
     */
    public Bed findById(String bedId) {
        return bedMapper.selectByPrimaryKey(bedId);
    }

    /**
     * 根据床位的附属信息查询
     * @param bedCondition
     * @param pageBean
     * @return
     */
    public List<Bed> findByExample(BedCondition bedCondition, PageBean pageBean) {
        BedExample example = new BedExample();
        BedExample.Criteria criteria = example.createCriteria();
        System.out.println(bedCondition);
        if(bedCondition.getBedId()!=null&&bedCondition.getBedId()!="")
            criteria.andBedIdLike("%"+bedCondition.getBedId()+"%");

        if(bedCondition.getDepartmentId()!=null&&bedCondition.getDepartmentId()!=-1)
            criteria.andDepartmentIdEqualTo(bedCondition.getDepartmentId());

        if(bedCondition.getPower()!=null&&bedCondition.getPower()!=-1)
            criteria.andPowerLessThan(bedCondition.getPower());

        if(bedCondition.getStatus()!=null&&bedCondition.getStatus()!="")
            criteria.andStatusEqualTo(bedCondition.getStatus());

        if(bedCondition.getBeginTime()!=null)
            criteria.andCreateTimeGreaterThan(bedCondition.getBeginTime());

        if(bedCondition.getEndTime()!=null)
            criteria.andCreateTimeLessThan(bedCondition.getEndTime());

        PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
        List<Bed> bedList = bedMapper.findByExample(example);
        //获取跟分页有关的信息
        PageInfo<Bed> pageInfo = new PageInfo<Bed>(bedList);
        //插入页码信息
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal((int) pageInfo.getTotal());
        return bedList;
    }

    /**
     * 更新床位信息
     * @param bed
     */
    public void update(Bed bed) {
        bedMapper.updateByPrimaryKeySelective(bed);
    }

    /**
     * 新增床位信息
     * @param bed
     */
    public void save(Bed bed) {
        bedMapper.insert(bed);
    }
}
