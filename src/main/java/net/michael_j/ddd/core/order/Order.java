package net.michael_j.ddd.core.order;

public class Order {
    private Status status;
    private String name;
    private String content;

    public Order(String name, String content) {
        this.status = Status.PENDING;
        this.name = name;
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    enum Status {
        PENDING, PAID, CANCELLED
    }
}
