//
//
public class ItemType {

    private int value;

    /**
     *constructor
     */

    public ItemType(int num) {
        initialize(num);
    }

    /**
     *comparison method
     *@return -1 if the value of the current object is less than the value in item
     *@return 0 if the value is equal
     *@return 1 if current object is greater than the value in item
     */
    public int compareTo(ItemType item) {
        if (this.value < item.getValue()) {
            return -1;
        }
        else if (this.value == item.getValue()) {
            return 0;
        }
        else {
            return 1;
        }
    }

    /**
     *getter method
     *@retuns the value of the data member
     */
    public int getValue() {
        return this.value;
    }

    /**
     *sets the value of the ItemType obejct
     *@param num the desired value
     */
    public void initialize(int num) {
        this.value = num;
    }

}
