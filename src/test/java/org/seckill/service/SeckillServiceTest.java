package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillExpection;
import org.seckill.exception.SeckillCloseExpection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                       "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;
    @Test
    public void getSckillList() {
        List<Seckill> list=seckillService.getSckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() {
        int id=1000;
        Seckill seckill=seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() {
        int id=1001;
        Exposer exposer=seckillService.exportSeckillUrl(id);
        logger.info("Exposer={}",exposer);
//        Exposer{exposed=true, md5='4de39f35b4916acaf3a73d4ad2b7895d', seckillId=1001, now=0, start=0, end=0}
    }

    @Test
    public void executeSeckill() {
        int id=1001;
        int phone=123453786;
        String md5="4de39f35b4916acaf3a73d4ad2b7895d";
        SeckillExecution seckillExecution=seckillService.executeSeckill(id,phone,md5);
        logger.info("result={}",seckillExecution);
    }
    //集成测试代码完整逻辑，注意可重复执行
    @Test
    public void testSeckillLogic() throws Exception{
        int id=1001;
        Exposer exposer=seckillService.exportSeckillUrl(id);
        if(exposer.isExposed()){
            logger.info("exposer={}",exposer);
            int phone=123456789;
            String md5=exposer.getMd5();
            try {
                SeckillExecution seckillExecution=seckillService.executeSeckill(id,phone,md5);
                logger.info("result={}",seckillExecution);
            }catch (RepeatKillExpection e){
                logger.error(e.getMessage());
            }catch (SeckillCloseExpection e){
                logger.error(e.getMessage());
            }
        }else{
            //秒杀未开启
            logger.warn("exposer={}",exposer);
        }
    }
}