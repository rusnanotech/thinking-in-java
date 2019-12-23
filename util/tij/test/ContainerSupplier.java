package biz.markov.thinking.util.tij.test;

public abstract class ContainerSupplier<C> {
    public String name;

    public ContainerSupplier(String name) {
        this.name = name;
    }

    public abstract C get(int size);
}
