import javax.swing.*;

public class CounterView extends JLabel implements CounterListener {

    Counter thisCounter;

    public CounterView (Counter c) {
        this.thisCounter = c;
        this.setText(Integer.toString(thisCounter.getCounter()));
    }

    @Override
    public void incrementDetected(boolean rolledOver) {
        this.setText(Integer.toString(thisCounter.getCounter()));
    }
}
