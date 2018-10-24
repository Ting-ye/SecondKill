package org.seckill.exception;


/*
* 秒杀关闭异常
* */

public class SeckillCloseExpection extends SeckillExpection{
    public SeckillCloseExpection(String message) {
        super(message);
    }

    public SeckillCloseExpection(String message, Throwable cause) {
        super(message, cause);
    }
}
