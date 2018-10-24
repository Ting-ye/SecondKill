package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
    /*插入购买明细*/
    int insertSuccessKilled(@Param("seckillId")int seckillId,@Param("userPhone")int userPhone);
    /*根据 id查询SuccessKilled并携带秒杀对象实体*/
    SuccessKilled queryByIdWithSeckill(@Param("seckillId")int seckillId,@Param("userPhone")int userPhone);
}
