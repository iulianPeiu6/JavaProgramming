package com.app.lab11_v2.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "friendship", schema = "sys")
public class Friendship {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="from")
    private Long from;

    @Column(name="to")
    private Long to;

    public Friendship(Long from, Long to) {
        this.from = from;
        this.to = to;
    }

    public Friendship() {
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friendship that = (Friendship) o;
        return Objects.equals(id, that.id) && Objects.equals(from, that.from) && Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to);
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
