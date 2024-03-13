public class checkIfBitIsSet {
    public static void main(String[] args) {
        int num = 1;
        int targetBit = 0;
        // 13 - 1101
        // check 2nd bit...bit starts from 0
        // always to check whether the bit is set ... always left shift the target bit
        // then AND them with num, if result produces 0, then its not set, if not 0 then
        // the bit is set at that target
        if ((num & (1 << targetBit)) != 0) {
            System.out.println("The bit is set at " + targetBit);
        } else {
            System.out.println("The bit is not set at " + targetBit);
        }
    }
}
