package LinkedListCode;

public class Operations {
    public static LinkedList add(LinkedList num1, LinkedList num2) {

        // if we add by zero do nothing
        if (num1.toString().equals("0")) {
            return num2;
        }
        else if (num2.toString().equals("0")) {
            return num1;
        }

        LinkedList result = new LinkedList(new node(0, null));
        node current1 = num1.head;
        node current2 = num2.head;
        int carry = 0;

        while (current1 != null || current2 != null) {
            int value1 = (current1 != null) ? current1.value : 0;
            int value2 = (current2 != null) ? current2.value : 0;
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            result.add(sum % 10);

            if (current1 != null) current1 = current1.next;
            if (current2 != null) current2 = current2.next;
        }

        if (carry > 0) {
            result.add(carry);
        }

        return result;
        //
    }

    public static LinkedList multiply(LinkedList num1, LinkedList num2) {
        LinkedList result = new LinkedList(new node(0, null));

        if (num1.head == null || num2.head == null) {
            return result;
        }

        // Reverse the linked lists
        num1.reverse();
        num2.reverse();

        node current1 = num1.head;
        node current2 = num2.head;

        while (current1 != null) {
            int carry = 0;
            int digit1 = current1.value;
            node currentResult = result.head;
            node prevResult = null;

            while (current2 != null || carry > 0) {
                int digit2 = (current2 != null) ? current2.value : 0;
                int partialProduct = digit1 * digit2 + ((currentResult != null) ? currentResult.value : 0) + carry;

                carry = partialProduct / 10;

                if (currentResult == null) {
                    currentResult = new node(partialProduct % 10, null);
                    if (prevResult != null) {
                        prevResult.next = currentResult;
                    } else {
                        result.head = currentResult;
                    }
                } else {
                    currentResult.value = partialProduct % 10;
                }

                prevResult = currentResult;
                currentResult = currentResult.next;
                if (current2 != null) current2 = current2.next;
            }

            if (carry > 0) {
                prevResult.next = new node(carry, null);
            }

            current1 = current1.next;
        }

        // Reverse the result linked list to get the final answer
        result.reverse();

        return result;
    }

    public static LinkedList exponentiate(LinkedList num1, LinkedList num2) {
        if (num2.head == null) {
            // Anything raised to the power of 0 is 1
            return new LinkedList(new node(1, null));
        }

        // Convert num2 to an integer
        int exponent = num2ToInt(num2);

        // Initialize the result to 1
        LinkedList result = new LinkedList(new node(1, null));
        LinkedList base = new LinkedList(num1.head);

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                // If the exponent is odd, multiply the result by the base
                result = multiply(result, base);
            }

            // Square the base
            base = multiply(base, base);

            // Halve the exponent
            exponent /= 2;
        }

        return result;
    }

    public static int num2ToInt(LinkedList num2) {
        int result = 0;
        int powerOf10 = 1;
        node current = num2.head;

        while (current != null) {
            result = result + (current.value * powerOf10);
            powerOf10 *= 10;
            current = current.next;
        }

        return result;
    }
}
