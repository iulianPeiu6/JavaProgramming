package lab3package;

import interfaces.Visitable;

import java.time.LocalTime;

public class Church extends Location implements Visitable {

    private LocalTime openingTime;
    private LocalTime closingTime;

    public Church(String name) {
        super(name);
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }
}
