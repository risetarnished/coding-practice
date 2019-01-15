package L.Bit.Easy.HexadecimalRepresentation;

public class HexadecimalRepresentation {
    public String hex(int number) {
        // Write your solution here
        if (number == 0) {
            return "0x0";
        }
        char[] hexBase = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        StringBuilder hexResult = new StringBuilder();
        while (number > 0) {
            hexResult.append(hexBase[number % 16]);
            number /= 16;
        }
        // The result is in reversed order now
        hexResult.append("x0");
        hexResult.reverse();
        return hexResult.toString();
    }

    public String hexBitwise(int number) {
        if (number == 0) {
            return "0x0";
        }
        char[] hexBase = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        StringBuilder hexResult = new StringBuilder("0x");
        // Set a flag to avoid leading zeros
        boolean isLeading = true;
        for (int maskEnd = 28; maskEnd >= 0; maskEnd -= 4) {
            char digit = hexBase[(number >> maskEnd) & 0xf];
            if (isLeading && digit == '0') {
                continue;
            }
            isLeading = false;
            hexResult.append(digit);
        }
        return hexResult.toString();
    }
}
