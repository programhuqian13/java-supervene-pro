package jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description java方法区溢出异常 使用CGLIB实现
 * @Version 1.0
 * @Date 2019/11/5
 * @ProjectName java-supervene-pro
 * @PackageName jvm
 * vm 参数： -XX:PermSize=10M -XX:MaxPermSize=10M
 * 在jdk 1.8 没有抛出异常
 */
public class JavaMethodAreaOOM {

    static class OOMObject{

    }

    public static void main(String... args){
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
//            enhancer.setCallback((MethodInterceptor)(Object o, Method method, Object[] objects, MethodProxy methodProxy) -> {
//                return methodProxy.invokeSuper(o,objects);
//            });
            enhancer.create();
        }
    }

}
