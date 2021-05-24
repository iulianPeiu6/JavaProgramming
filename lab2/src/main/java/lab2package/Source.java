/**
 * @author Peiu Iulian-Cosmin
 */
package lab2package;

import java.util.Objects;

public class Source {

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

    public Source(String name, int supply) {
        this.name = name;
        this.supply = supply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return supply == source.supply && Objects.equals(name, source.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, supply);
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", supply=" + supply +
                '}';
    }
}
