package org.seckill.exception;

/*
* 重复秒杀异常（运行期异常）
* */
public class RepeatKillExpection extends SeckillExpection{
    public RepeatKillExpection (String message){
        super(message);
    }
    public RepeatKillExpection (String message,Throwable cause){
        super(message,cause);
    }
}
