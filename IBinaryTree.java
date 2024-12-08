import java.util.List;

public interface IBinaryTree<E> {
    /**
     * پیمایش میانوندی درخت را برمی‌گرداند
     */
    List<E> inOrder();

    /**
     * پیمایش پیشوندی درخت را برمی‌گرداند
     *
     * @return
     */
    List<E> preOrder();

    /**
     * پیمایش پسوندی درخت را برمی‌گرداند
     *
     * @return
     */
    List<E> postOrder();

    /**
     * پیمایش سطح به سطح درخت را برمی‌گرداند
     *
     * @return
     */
    List<E> levelOrder();

    /**
     * اندازه درخت را برمی‌گرداند
     * منظور از اندازه درخت تعداد عناصر درخت است
     *
     * @return
     */
    int size();

    /**
     * ارتفاع درخت را برمی‌گرداند
     *
     * @return
     */
    int height();

    /**
     * وزن درخت (تعداد برگ‌ها) درخت را برمی‌گرداند
     *
     * @return
     */
    int weight();

    /**
     * درخت را آینه می‌کند. منظور از آینه کردن درخت تعویض جای فرزندان چپ و راست هر گره است
     */
    void mirror();

    /**
     * returns true if the tree is perfect, otherwise returns false
     *
     * @return
     */
    boolean isPerfect();

    /**
     * if the tree contains data returns the depth of the node containing data otherwise returns -1
     *
     * @param data
     * @return
     */
    int levelOf(E data);

}
