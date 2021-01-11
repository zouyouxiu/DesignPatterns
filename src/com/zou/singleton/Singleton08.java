package com.zou.singleton;

/**
 * 枚举类不给外界实例化的机会，只能它自己实例化，而一个枚举类的所有实例就只有枚举前面分号前的那几个，其他地方不允许创建
 * 不仅可以解决线程同步，还可以防止反序列化
 * 由于枚举没有构造方法，所以不能被反序列化，就算拿到他的class文件，也没有办法构造他的对象，反序列化返回的是INSTANCE值，根据INSTANCE值返回对象和单例获取的为同一个对象
 * 单元素的枚举类型已经成为实现Singleton的最佳方法
 * 如何保证线程安全：
 * 枚举类：
 * public enum t {
 * SPRING,SUMMER,AUTUMN,WINTER;
 * }
 *反编译：
 * public final class T extends Enum
 * {
 * private T(String s, int i)
 * {
 * super(s, i);
 * }
 * public static T[] values()
 * {
 * T at[];
 * int i;
 * T at1[];
 * System.arraycopy(at = ENUM$VALUES, 0, at1 = new T[i = at.length], 0, i);
 * return at1;
 * }
 * public static T valueOf(String s)
 * {
 * return (T)Enum.valueOf(demo/T, s);
 * }
 * public static final T SPRING;
 * public static final T SUMMER;
 * public static final T AUTUMN;
 * public static final T WINTER;
 * private static final T ENUM$VALUES[];
 * static
 * {
 * SPRING = new T("SPRING", 0);
 * SUMMER = new T("SUMMER", 1);
 * AUTUMN = new T("AUTUMN", 2);
 * WINTER = new T("WINTER", 3);
 * ENUM$VALUES = (new T[] {
 * SPRING, SUMMER, AUTUMN, WINTER
 * });
 * }
 * }
 * 通过反编译后代码我们可以看到，public final class T extends Enum，说明，该类是继承了Enum类的，同时final关键字告诉我们，这个类也是不能被继承的。当我们使用enmu来定义一个枚举类型的时候，
 * 编译器会自动帮我们创建一个final类型的类继承Enum类,所以枚举类型不能被继承
 * public static final T SPRING;
 * public static final T SUMMER;
 * public static final T AUTUMN;
 * public static final T WINTER;
 * private static final T ENUM$VALUES[];
 * static
 * {
 * SPRING = new T("SPRING", 0);
 * SUMMER = new T("SUMMER", 1);
 * AUTUMN = new T("AUTUMN", 2);
 * WINTER = new T("WINTER", 3);
 * ENUM$VALUES = (new T[] {
 * SPRING, SUMMER, AUTUMN, WINTER
 * });
 * 成员变量都被声明为static final，表明其为类变量，且初始化语句放在了static代码块内，表明在类加载的准备阶段这些变量就会被初始化并赋值。
 *都是static类型的，因为static类型的属性会在类被加载之后被初始化，我们在深度分析Java的ClassLoader机制（源码级别）和Java类的加载、链接和初始化两个文章中分别介绍过，
 * 当一个Java类第一次被真正使用到的时候静态资源被初始化、Java类的加载和初始化过程都是线程安全的。所以，创建一个enum类型是线程安全的。
 *  *
 * 如何防止反序列化：反射在通过newInstance创建对象时，会检查该类是否ENUM修饰，如果是则抛出异常，反射失败。
 *
 * @CallerSensitive 2     public T newInstance(Object ... initargs)
 * 3         throws InstantiationException, IllegalAccessException,
 * 4                IllegalArgumentException, InvocationTargetException
 * 5     {
 * 6         if (!override) {
 * 7             if (!Reflection.quickCheckMemberAccess(clazz, modifiers)) {
 * 8                 Class<?> caller = Reflection.getCallerClass();
 * 9                 checkAccess(caller, clazz, null, modifiers);
 * 10             }
 * 11         }
 * 12         if ((clazz.getModifiers() & Modifier.ENUM) != 0)
 * 13             throw new IllegalArgumentException("Cannot reflectively create enum objects");
 * 14         ConstructorAccessor ca = constructorAccessor;   // read volatile
 * 15         if (ca == null) {
 * 16             ca = acquireConstructorAccessor();
 * 17         }
 * 18         @SuppressWarnings("unchecked")
 * 19         T inst = (T) ca.newInstance(initargs);
 * 20         return inst;
 * 21     }
 */
public enum Singleton08 {

    INSTANCE, TEST;

    public void show() {
        System.out.println("show");
    }

    public static void main(String[] args) {
        Singleton08 instance = Singleton08.INSTANCE;
        instance.show();
        for (int i = 0; i < 100; i++) {
            //如果为多元素，那么创建的就不为同一个对象
            new Thread(() -> System.out.println(Singleton08.INSTANCE.hashCode())).start();
           // new Thread(() -> System.out.println(Singleton08.TEST.hashCode())).start();
        }
    }
}
