/*
 * @lc app=leetcode id=537 lang=java
 *
 * [537] Complex Number Multiplication
 */

// @lc code=start
class Solution {
    class ImaginaryNumber {
        int real = 0;
        int imaginary = 0;

        ImaginaryNumber(int real, int imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }
    }

    public String complexNumberMultiply(String num1, String num2) {
        ImaginaryNumber n1 = getImaginaryNumber(num1);
        ImaginaryNumber n2 = getImaginaryNumber(num2);
        int realPart = (n1.real*n2.real) - (n1.imaginary*n2.imaginary);
        int imaginaryPart = (n1.real*n2.imaginary)+(n1.imaginary*n2.real);
        return realPart+"+"+imaginaryPart+"i"; 
    }

    public ImaginaryNumber getImaginaryNumber(String num) {
        String real = "";
        String imaginary = "";
        String iterator = "";
        for (char ch : num.toCharArray()) {
            if (ch == '+') {
                real = new String(iterator);
                iterator = "";
                continue;
            }
            if (ch == 'i') {
                imaginary = new String(iterator);

            }
            iterator = iterator + ch;
        }
        real = real.equals("")?"0":real;
        imaginary = imaginary.equals("")?"0":imaginary;
        return new ImaginaryNumber(Integer.parseInt(real), Integer.parseInt(imaginary));

    }
}
// @lc code=end
