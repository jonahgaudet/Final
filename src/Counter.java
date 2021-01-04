import java.util.ArrayList;

public class Counter implements CounterListener{

    private int min;
    private int counter;
    private int max;
    private ArrayList<CounterListener> counterListeners;

    public Counter () {
        initializeCounter(0, 10);
    }

    public Counter (int min, int max) {
        initializeCounter(min, max);
    }

    public void initializeCounter (int min, int max) {
        this.min = min;
        this.counter = min;
        this.max = max;
        this.counterListeners = new ArrayList<CounterListener>();
    }

    public void increment () {
        counter += 1;
        if (counter >= max) {
            counter = min;
            valueChanged(true);
        } else {
            valueChanged(false);
        }
    }

    public int getMax () {
        return max;
    }

    public int getMin () {
        return min;
    }

    public int getCounter () {
        return counter;
    }

    public void addListener (CounterListener cl) {
        counterListeners.add(cl);
    }

    public void valueChanged(boolean rolledOver) {
        for(CounterListener cl: this.counterListeners){
            cl.incrementDetected(rolledOver);
        }
    }

    @Override
    public void incrementDetected(boolean rolledOver) {
        if (rolledOver) {
            this.increment();
        }
    }
}
