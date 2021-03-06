package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;
    @Test
    public void queryById() throws Exception{
        int id=1000;
        Seckill seckill=seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> seckillList=seckillDao.queryAll(1,20);
        for (Seckill seckill:seckillList){
            System.out.println(seckill);
        }
    }
    @Test
    public void reduceNumber() {
        Date killTime =new Date();
        int accessNum=seckillDao.reduceNumber(1000,killTime);
        System.out.println("accessNum="+accessNum);
    }


}