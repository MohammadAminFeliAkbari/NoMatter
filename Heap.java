public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = value;
        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        var result = items[0];
        items[0] = items[--size];

        bubbleDown();
        return result;
    }

    public void bubbleDown() {
        var index = 0;
        var largerChildIndex = largerChildIndex(index);
        while (index != largerChildIndex) {
            swap(index, largerChildIndex);
            index = largerChildIndex;
            largerChildIndex = largerChildIndex(index);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    private int largerChildIndex(int index) {
        int largest = index;
        if (hasLeftChild(index) && items[index] < leftChild(index))
            largest = leftChildIndex(index);
        if (hasRightChild(index) && items[largest] < rightChild(index))
            largest = rightChildIndex(index);
        return largest;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }


    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && items[index] > items[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

}
