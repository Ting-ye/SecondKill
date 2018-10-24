package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

public interface SeckillDao {
    /*减库存 确认商品 确认秒杀时间在秒杀有效期内*/
    int reduceNumber(@Param("seckillId") int seckillId, @Param("killTime")Date killTime);

    /*根据id查询*/
    Seckill queryById(int seckillId);

    /*根据偏移量查询商品列表*/
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
