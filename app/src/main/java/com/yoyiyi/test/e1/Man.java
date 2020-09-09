package com.yoyiyi.test.e1;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2020/9/9 23:18
 * 描述:
 */
public class Man implements Person {
    @Override
    public void sleep() {
        System.out.println("睡觉");
    }

    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public void play(String name) {
        System.out.println(name);
    }
}
