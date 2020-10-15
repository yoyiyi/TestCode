package com.yoyiyi.test.e1;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2020/9/9 23:20
 * 描述:
 */
public class TestInvoke {
    public static void main(String[] args) {
        /*final Man man = new Man();
        final Person person = (Person) Proxy.newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("eat".equals(method.getName())) {
                    System.out.println("吃个屁");
                }
                if ("play".equals(method.getName())) {
                    Person proxy1 = (Person) proxy;
                    proxy1.sleep();
                    method.invoke(man, "计算器");
                }
                return method.invoke(man, args);
            }
        });
        person.eat();
        person.play("篮球");*/
    }
}
