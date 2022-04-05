public class Obj1 extends Thread{
    MyRes s;
    public Obj1(MyRes r) {
        s = r;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s.num++;
        }
    }
}
