// Мыть посуду = 45 мин
// Стирать белье = 60 мин + 10 мин = 70 мин
// Мыть полы = 20 мин

public class MultiThread {
    public static void main(String[] args) {

        // Третий способ
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Мыть посуду выполнено: "+i+"%");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Стирать белье выполнено: "+i+"%");
                }
            }
        });
        thread1.start();
        thread2.start();

        /*
        ** Второй способ

        Thread myRunnableThread1 = new Thread(new MyRunnableThread("Мыть посуду"));
        Thread myRunnableThread2 = new Thread(new MyRunnableThread("Стирать белье"));
        Thread myRunnableThread3 = new Thread(new MyRunnableThread("Мыть полы"));
        myRunnableThread1.start();
        myRunnableThread3.start();
        myRunnableThread2.start();*/

        //** Первый способ

        MyThread myThread1 = new MyThread("Мыть посуду");
        MyThread myThread2 = new MyThread("Стирать белье");
        MyThread myThread3 = new MyThread("Мыть полы");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}

class MyRunnableThread implements Runnable{
    private String task;

    public MyRunnableThread(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.task+" выполнено: "+i+"%");
        }
    }
}



class MyThread extends Thread{
    private String task;

    public MyThread(String task) {
        super();
        this.task = task;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(this.task+" выполнено: "+i+"%");
        }
    }
}
