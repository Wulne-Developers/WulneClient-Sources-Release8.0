/*
 * Decompiled with CFR 0_132.
 */
package net.wulnemc.wulne.Module.Value;

public class Numbers<T extends Number>
        extends Value<T> {
    public T min;
    public T max;
    public T inc;
    private boolean integer;

    public Numbers(String name, T value, T min, T max, T inc) {
        super(name);
        this.setValue(value);
        this.min = min;
        this.max = max;
        this.inc = inc;
        this.integer = false;
    }

    public T getMinimum() {
        return this.min;
    }

    public T getMaximum() {
        return this.max;
    }

    public void setIncrement(T inc) {
        this.inc = inc;
    }

    public T getIncrement() {
        return this.inc;
    }

}

