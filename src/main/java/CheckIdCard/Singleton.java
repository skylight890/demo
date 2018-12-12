package CheckIdCard;

public class Singleton{

    private static Singleton instance=null;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null) {          //修改
            instance = new Singleton();
        }
        return instance;        //修改
    }
}
