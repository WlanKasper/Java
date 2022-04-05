public class Main {
    public static void main(String[] args) {

        new Test().theBestMethodUsingSynchr();


    }

}

class Test {
    MyRes res = new MyRes();
    Obj1 obj1 = new Obj1( res);
    Obj2 obj2 = new Obj2( res);
    public synchronized void theBestMethodUsingSynchr() {
            obj1.start();
            obj2.start();
    }
}

