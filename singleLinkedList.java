package finalprogram;

abstract class singleLinkedList {
    private int length;

    int getLength() {
        return length;
    }

    void setLength(int length) {
        this.length = length;
    }

    boolean isEmpty() {
        return length == 0;
    }

    abstract void deleteNode();

    abstract void shownode();
}
