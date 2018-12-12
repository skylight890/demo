package demo;

public class Singleton2{
    private static Singleton2 instance = null;
    private Singleton2(){}

    public static Singleton2 getInstance() {
        if(instance == null) {
            synchronized (Singleton2.class) {   //避免高并发时多个进程调用产生多个实例
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

//原代码
//public class Singleton{
//
//    private static Singleton instance=null;
//
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        if(instance == null) {          //修改，没有实例时创建
//            instance = new Singleton();
//        }
//        return instance;        //修改位置
//    }
//}
