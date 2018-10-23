package org.seckill.dao;

import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

public interface SeckillDao {
    /*减库存 确认商品 确认秒杀时间在秒杀有效期内*/
    int reduceNumber(int seckillId, Date killTime);

    /*根据id查询*/
    Seckill queryById(int seckillId);
    /*根据偏移量查询商品列表*/
    List<Seckill> queryAll(int offet,int limit);

}
