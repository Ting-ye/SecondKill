package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillExpection;
import org.seckill.exception.SeckillCloseExpection;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

public class SeckillServiceImpl implements SeckillService {

    private Logger logger =LoggerFactory.getLogger(this.getClass());

    private SeckillDao seckillDao;

    private SuccessKilledDao successKilledDao;

    //MD5盐值，用于混淆MD5
    private final String slat="dd>{P&^%$#&*(*&^^%^&*(*&^%>";
    @Override
    public List<Seckill> getSckillLidt() {
        return seckillDao.queryAll(0,10);
    }

    @Override
    public Seckill getById(int seckillId) {
        return seckillDao.queryById(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(int seckillId) {
        Seckill seckill=seckillDao.queryById(seckillId);
        if(seckill==null){
            return new Exposer(false,seckillId);
        }
        Date startTime=seckill.getStartTime();
        Date endTime=seckill.getEndTime();
        //系统当前时间
        Date nowTime=new Date();
        if (nowTime.getTime()<startTime.getTime()
                ||nowTime.getTime()>endTime.getTime()){
            return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
        }
        String md5=getMD5(seckillId);
        return new Exposer(true,md5,seckillId);
    }

    private String getMD5(int seckillId){
        String base=seckillId+"/"+slat;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    public SeckillExecution executeSeckill(int seckill, long userPhone, String md5) throws SeckillExecution, RepeatKillExpection, SeckillCloseExpection {
        return null;
    }
}
