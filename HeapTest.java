
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// class HeapTest {
//     Heap heap;

//     @org.junit.jupiter.api.BeforeEach
//     void setUp() {
//         heap = new Heap();
//     }

//     @org.junit.jupiter.api.Test
//     void insert() {
//         heap.insert(10);
//         heap.insert(5);
//         heap.insert(17);
//         heap.insert(4);
//         heap.insert(22);
//         assertFalse(heap.isFull());
//         heap.insert(30);
//         heap.insert(40);
//         heap.insert(50);
//         heap.insert(60);
//         heap.insert(70);
//         assertTrue(heap.isFull());
//     }

//     @Test
//     void remove() {
//         assertThrows(IllegalStateException.class, () -> heap.remove());
//         heap.insert(10);
//         heap.insert(5);
//         heap.insert(17);
//         heap.insert(4);
//         heap.insert(22);
//         heap.insert(30);
//         heap.insert(40);
//         heap.insert(50);
//         heap.insert(60);
//         heap.insert(70);
//         assertEquals(heap.size(), 10);
//         assertEquals(70, heap.remove());
//         assertEquals(60, heap.remove());
//         assertEquals(heap.size(), 8);
//     }
// }
