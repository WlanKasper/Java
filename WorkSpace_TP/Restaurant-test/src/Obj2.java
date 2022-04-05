public class Obj2 extends Thread{
    MyRes s;
    public Obj2(MyRes r) {
        s = r;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            System.out.println(s);
        }
    }
}
