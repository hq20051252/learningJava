package org.apache.hadoop.learn;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class LogHandler implements InvocationHandler {  
    private Object target;
    public LogHandler(Object target) {  
        this.target = target;   
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //目标方法前的逻辑
        System.out.println("start......" );
        
        Object ret = null;
        try {
            //调用目标方法，本例中会调用move方法，这里用到反射技术
            ret = method.invoke(target, args);
            
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }//目标方法后的逻辑
                System.out.println("end.....");
        return ret;
    }
}