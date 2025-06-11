import java.util.Arrays; // only for Arrays.toString() printing

/**
 * Simple object implemention of the minimum-heap
 */
public class MinHeap {

    /** Underlying array */
    private int[] underlying;

    /**
     * Utilization counter for the array. We need this attribute because we may not
     * be using all the elements of the underlying array. For example, when we
     * create a default object, there is room for 4 nodes in the binary tree. The
     * tree, however, may have fewer nodes.
     */
    private int usage;

    /** Default array size constant */
    private static final int DEFAULT_SIZE = 4;

    /**
     * Default constructor. It calls the basic constructor passing the object's
     * default size to it.
     */
    public MinHeap() {
        this(DEFAULT_SIZE); // call basic constructor with default size
    } // default constructor

    /**
     * Basic constructor. It initializes the underlying array at the default size.
     * Then it checks the requested size to ensure it's a legit value and if so, it
     * reinitializes the underlying array at the requested size. The method also
     * sets the current usage of the underlying array to 0, indicating that nothing
     * has been added to it yet.
     * 
     * @param size int with the requested size for the underlying array.
     */
    public MinHeap(int size) {
        this.underlying = new int[DEFAULT_SIZE];
        if (size > 0) {
            this.underlying = new int[size];
        }
        this.usage = 0;
    } // basic constructor

    /** Accessor for size */
    public int getSize() {
        return this.underlying.length;
    } // method getSize

    /** Getter method ... accessor for usage */
    public int getUsage() {
        return this.usage;
    } // method getUsage

    /**
     * Determines if a given integer is a valid index for the underlying array
     * 
     * @param i int to check if valid array position
     * @return true if i within bounds, false otherwise
     */
    private boolean index_is_valid(int i) {
        return i >= 0 && i < this.underlying.length;
    } // method index_is_valid

    /**
     * Determines the underlying array position for the left child of a given
     * element. The method ensures that the index is valid. The returned value may
     * be an index out of bounds. Calling methods should always check for that.
     * 
     * @param i int with element whose left child we look for
     * @return int with index position of left child or -1 if input is invalid
     */
    private int leftChild(int parent) {
        int child = -1;
        if (index_is_valid(parent)) {
            child = 2 * parent + 1;
        }
        return child;
    } // method leftChild

    /**
     * Determines the underlying array position for the right child of a given
     * element. The method ensures that the index is valid. The returned value may
     * be an index out of bounds. Calling methods should always check for that.
     * 
     * @param i int with element whose right child we look for
     * @return int with index position of right child or -1 if input is invalid
     */
    private int rightChild(int parent) {
        int child = -1;
        if (index_is_valid(parent)) {
            child = 2 * parent + 2;
        }
        return child;
    } // method rightChild

    /**
     * Returns the parent position of a given element in the underlying array.
     * 
     * @param i int with array position whose parent we look for
     * @return int with parent position in the array or -1 if input is invalid
     */
    private int parent(int child) {
        int parent = -1;
        if (index_is_valid(child)) {
            parent = (child - 1) / 2;
        }
        return parent;
    } // method parent

    /**
     * Remove and return the smallest value from the min heap and adjust the
     * underlying array's size as needed.
     * 
     * @return int with smallest value of the underlying array.
     */
    public int getSmallest() {
        // Grab the first element of the array -- because the array represents a
        // complete binary tree in which the min-heap property is enforced, this is the
        // root of the tree and therefore the smallest element.
        int smallest_value = this.underlying[0];
        // Create a temporary array, one element smaller than the underlying array
        int[] temporary = new int[this.underlying.length - 1];
        // Copy the last actual element of the underlying array to the front of the
        // temporary array. The last actual element of the array may not be the last
        // element of the array -- there is a difference between usage of the array and
        // the size of the array.
        temporary[0] = this.underlying[this.usage - 1];
        // Copy the remaining elements of the underlying array to the temporary array.
        // Running the loop below to the length of the temporary array excludes the last
        // element of the underlying array. That's intentional: that last element is
        // already present in the temporary array, now at position 0.
        for (int i = 1; i < temporary.length; i++) {
            temporary[i] = this.underlying[i];
        }
        // Replace the underlying array with the temporary array
        this.underlying = temporary;
        // Adjust usage to indicate that one element has been removed from the
        // underlying array
        this.usage -= 1;
        // We just moved the underlying array's last element to its front. This may have
        // violated the min-heap property. Let's review the array and restore the
        // min-heap property if needed.
        this.heapifyDown();
        // Done; return the smallest value of the underlying array that we grabbed
        // before reorganizing things a bit.
        return smallest_value;
    } // method getSmallest

    /**
     * Adds a new value to the Min Heap. The underlying array is resized to
     * accomodate the new element and the usage count is updated accordingly.
     * 
     * @param value int new item to be added to the Min Heap
     */
    public void add(int value) {
        // Is there room in the underlying array for a new element?
        if (this.usage == this.underlying.length) {
            // Array is maxed out, resize by 1
            int[] temporary = new int[this.underlying.length + 1];
            // copy all underlying array to temporary
            for (int i = 0; i < this.underlying.length; i++) {
                temporary[i] = this.underlying[i];
            }
            // Replace underlying array with the temporary one
            this.underlying = temporary;
        }
        // Place the new value at the first available position in the
        this.underlying[this.usage] = value;
        // Indicate that they array grew by one element
        this.usage += 1;
        // This new element may have violated the min-heap property. Ensure that the
        // property is restored.
        this.heapifyUp();
    } // method add

    /**
     * Swaps places between two elements in the underlying array
     * 
     * @param parent one of the two elements to swap place with
     * @param child  the other element to swap place with.
     */
    private void swap(int parent, int child) {
        int temp = this.underlying[parent];
        this.underlying[parent] = this.underlying[child];
        this.underlying[child] = temp;
    } // method swap

    /**
     * SOLUTION TO ASSIGNMENT FOR WEEK 02
     * 
     * This method is called after we add a new element to the min-heap. The new
     * element is placed at the first available position of the underlying array.
     * Then it is compared to its parent to determine if the min-heap property is
     * violated. If there is a violation, we swap child and parent and repeat the
     * process until the property is restored.
     */
    private void heapifyUp() {
        // Start at the last inserted element
        int index = this.usage - 1;
        /*
         * The loop successively swaps any child and parent elements that violate the
         * min-heap property. Child is at position [index] and its parent at position
         * [parent(index)]. The loop stops when it encounters a child-parent pair that
         * does not violate the min-heap property or when it reaches the front of the
         * array.
         */
        while (parent(index) >= 0 &&
                this.underlying[index] < this.underlying[parent(index)]) {
            swap(parent(index), index);
            index = parent(index);
        }
    } // method heapifyUp

    /**
     * This method is called after we remove the smallest element from the
     * underlying array. That element is always the smallest element because of the
     * min-heap property. After removal, the first element is replaced by the last
     * element of the underlying array. The replacement usually violates the
     * min-heap property. This method restores the min-heap property on the
     * underlying array, ensuring that its first element is always the smallest
     * element. The method words by checking if the root is smaller than or equal to
     * both its chidren. If not, it swaps the root with the smallest children and
     * continues to check until there is no violation of the min-heap property. The
     * method takes at most log(n) steps where n=this.usage, i.e., the number of
     * used elements in the underlying array.
     */
    private void heapifyDown() {
        // Starting point
        int parent = 0;
        // Indices for left and right child and the smallest of them.
        int left, right, smallest;
        // While loop control
        boolean minHeapViolated = true;
        // The loop below executes while the min-heap property is violated.
        while (minHeapViolated) {
            // Obtain the left and right children of the current element at [parent].
            // Remember
            // that functions left/rightChild may return a value that is out of bounds of
            // the underlying array. We need to check for that separately.
            left = leftChild(parent);
            right = rightChild(parent);
            // Assume that their parent, at [parent], is samller than them, thus observing
            // the min-heap property.
            smallest = parent;
            // Check if the left child is smaller than its parent. This will violate the
            // min-heap property so we'll have to prepare for a swap. First, however, check
            // that the left child index is within bounds of the underlying array.
            if (left < this.usage && this.underlying[left] < this.underlying[smallest]) {
                smallest = left;
            }
            // Now [smallest] points either at the parent element [parent] or at its [left]
            // child, whichever is smaller. We need to compare this element with the right
            // child of [parent]
            if (right < this.usage && this.underlying[right] < this.underlying[smallest]) {
                smallest = right;
            }
            // If [parent] is no longer the smallest element, the min-heap property has been
            // violated.
            if (smallest != parent) {
                // Restore min-heap by swapping smallest of two children with parent.
                swap(parent, smallest);
                // Move to the next level and check if the min-heap property holds there.
                parent = smallest;
            } else {
                // No violation of the min-heap property found; time to end the loop
                minHeapViolated = false;
            } // This if statement can be eliminated with
              // minHeapViolated <- smallest != parent
              // after the swap. When smallest == parent the swap is trivial.
        }
    } // method heapifyDown
} // class MinHeap