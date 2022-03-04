public class DiningPhilosophers extends Thread {

    private boolean[] fork;

    private Object lock;

    private int philosopher = -1;

    public DiningPhilosophers(int philosopher, Object lock, boolean[] fork){
        this.philosopher = philosopher;
        this.lock = lock;
        this.fork = fork;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (fork[philosopher] || fork[(philosopher + 1) % 5]) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pickLeftFork(philosopher);
            pickRightFork(philosopher);
            System.out.println(philosopher + " 号哲学家开始吃饭");
            lock.notifyAll();
            putLeftFork(philosopher);
            putRightFork(philosopher);
            System.out.println(philosopher + " 号哲学家陷入沉思");
        }
    }

    public void pickLeftFork(int philosopher) {
        fork[philosopher] = true;
        System.out.println(philosopher + " 号哲学家拿起了左边的叉子");
    }

    public void pickRightFork(int philosopher) {
        fork[(philosopher + 1) % 5] = true;
        System.out.println(philosopher + " 号哲学家拿起了右边的叉子");
    }

    public void putLeftFork(int philosopher) {
        fork[philosopher] = false;
        System.out.println(philosopher + " 号哲学家放下了左边的叉子");
    }

    public void putRightFork(int philosopher) {
        fork[(philosopher + 1) % 5] = false;
        System.out.println(philosopher + " 号哲学家放下了右边的叉子");
    }
}