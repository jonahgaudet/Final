import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OdoController implements ActionListener {

    private Odometer odometer;

    public OdoController (Odometer o) {
        this.odometer = o;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Increment")) {
            odometer.increment();
        }
    }
}
