package org.apache.hadoop.learn;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
    public static Object newProxyInstance(ClassLoader loader,Class<?> infce, InvocationHandler h) throws Exception { //JDK6 Complier API, CGLib, ASM
        String methodStr = "";
        String rt = "\r\n";
        //利用反射，获得infce接口中方法，本例中就是获得Moveable接口的方法move
        Method[] methods = infce.getMethods();
        //拼接infce中所有方法字符串，用来重写infce中的方法，本例中拼出来就是重写的move方法
        for(Method m : methods) {
            methodStr += "@Override" + rt + 
                         "public void " + m.getName() + "() {" + rt +
                         "    try {" + rt +
                         "    Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
                        /*方法最核心的代码，h是构造$Proxy1时传入的handler,本例中就是LogHandler对象,new Object[] { null}是move方法需要的参数，本例不需要,故为空。这一步将会使我们编写的处理类逻辑LogHandler的invoke方法得到调用。从而达到我们最初要在move方法前加日志逻辑的的目的,下面要做的就是把我们拼好的字符串生成类并load到内存就可以了这样就实现了动态生成代理类并加自己想加的逻辑*/
                         "    h.invoke(this, md,new Object[] { null});" + rt +
                         "    }catch(Exception e) {e.printStackTrace();}" + rt +
                        
                         "}";
        }
        
        String src = 
            "package com.bjsxt.proxy;" +  rt +
            "import java.lang.reflect.Method;" + rt +
            //这里动态实现infce接口，本例中就是Moveable,构造方法中让Proxy持有处理类Handler的引用
            "public class $Proxy1 implements " + infce.getName() + "{" + rt +
            "    public $Proxy1(InvocationHandler h) {" + rt +
            "        this.h = h;" + rt +
            "    }" + rt +
            
            
            "    com.bjsxt.proxy.InvocationHandler h;" + rt +
            //这里是需要重写Moveable中的方法，见上面该字符串的拼接过程              
            methodStr +
            "}";
        String fileName = 
            "d:/src/com/bjsxt/proxy/$Proxy1.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();
        
        //compile编译上面拼好的字符串
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();
        
        //load into memory and create an instance加载进内存并创建对象
        URL[] urls = new URL[] {new URL("file:/" + "d:/src/")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("com.bjsxt.proxy.$Proxy1");
        System.out.println(c);
        
        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object m = ctr.newInstance(h);
        
        //利用反射，这里就返回一个实现了infce接口也就是本例中Moveable接口的代理对像$Proxy1
        return m;
    }
}