## 1.在重写equals方法时，需要遵循哪些约定，具体介绍一下？
自反 对称 传递 一致 非空

## 2.静态代理和动态代理的区别，什么场景使用
代理类生成的时间不同，程序运行前代理类是否已经存在

## Java泛型了解么？什么是类型擦除？介绍一下常用的通配符？
JDK5引入 参数化类型
Java的泛型是伪泛型，这是因为Java在编译期间，所有的泛型信息都会被擦掉，这也就是通常所说类型擦除


## ==和equals的区别
基本数据类型比较是值 引用数据类型比较是内存地址

## hashCode
获取哈希码，也称为散列码，确定该对象在哈希表中的索引位置