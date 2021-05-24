/**
 * @author Peiu Iulian-Cosmin
 */
package lab2package;

import java.util.Objects;

public abstract class AbstractSource {
    private String name;

    private int supply;

    public String getName() {
        return name;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public void setName(String name, int supply) {
        this.name = name;
        this.supply = supply;
    }

    public AbstractSource(String name, int supply) {
        this.name = name;
        this.supply = supply;
    }
}
