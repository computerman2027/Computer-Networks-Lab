public class CrcOptimized2 {
    static char[] subtract(char[] a, char[] b)
    {
        char[] ans = new char[a.length];
        for(int i = a.length-1; i>=0;i--)
        {
            ans[i] = (a[i] == b[i]) ? '0' : '1';
        }
        return ans;
    }

    static String divide(String data, String divisor)
    {
        int divisorLength = divisor.length();
        int dataLength = data.length();
        char[] temp = data.substring(0, divisorLength).toCharArray();
        char[] divisorArray = divisor.toCharArray();
        
        int i;
        for(i=divisorLength-1;i<dataLength;i++)
        {
            if(temp[0]=='1')
            {
                char[] ansSubtract = subtract(temp, divisorArray);

            }
        }
    }
}
