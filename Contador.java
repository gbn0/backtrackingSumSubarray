public class Contador {
    

    private int counter;

    public Contador() {
        this.counter = 0;
    }

    public void add(int value) {
        this.counter += value;
    }

    public int getCounter() {
        return this.counter;
    }
}
