package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
    /*插入购买明细*/
    int insertSuccessKilled(int seckillId,int userPhone);
    /*根据 id查询SuccessKilled并携带秒杀对象实体*/
    SuccessKilled queryByIdWithSeckill(int seckillId);
}
