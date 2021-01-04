import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Odometer {

    private ArrayList<Counter> counters;

    public Odometer (int n) {
        counters = new ArrayList<Counter>();

        for (int i = 0; i < n; i++) {
            Counter c = new Counter();
            if (i > 0) {
                counters.get(i - 1).addListener(c);
            }
            counters.add(c);
        }
    }

    public int getValue () {
        int total = 0;
        for (int i = 0; i < counters.size(); i++) {
            total += counters.get(i).getCounter() * Math.pow(10, i);
        }
        return total;
    }

    public void increment () {
        counters.get(0).increment();
    }

    public void displayGUI () {
        JFrame frame = new JFrame("Odometer");
        OdoController controller = new OdoController(this);
        frame.setLayout(new GridLayout(1, counters.size() + 1));

        for (int i = counters.size() - 1; i >= 0; i--) {
            Counter c = counters.get(i);
            CounterView v = new CounterView(c);
            c.addListener(v);
            frame.add(v);
        }

        JButton push = new JButton("Push");
        frame.add(push);
        push.addActionListener(controller);
        push.setActionCommand("Increment");

        frame.setSize(200,100);
        frame.setVisible(true);
    }

    public static void main (String[] args) {
        Odometer o = new Odometer(3);
        o.displayGUI();
    }
}
