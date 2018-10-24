package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillExpection;
import org.seckill.exception.SeckillCloseExpection;

import java.util.List;

public interface SeckillService {
    //查询所有秒杀记录
    List<Seckill> getSckillLidt();

    //查询单个秒杀记录
    Seckill getById(int seckillId);

    //秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
    Exposer exportSeckillUrl(int seckillId);

    //执行秒杀操作
    SeckillExecution executeSeckill(int seckill, long userPhone, String md5)
    throws SeckillExecution,RepeatKillExpection,SeckillCloseExpection;
}
