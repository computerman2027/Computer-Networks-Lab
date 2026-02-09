import java.util.Scanner;

public class CRC {

    static char[] subtract(char[] a, char[] b)
    {
        char[] ans = new char[a.length];
        for(int i = a.length-1; i>=0;i--)
        {
            ans[i] = (a[i] == b[i]) ? '0' : '1';

        }
        return ans;
    }

    static void CRC_Calculate(String data, String divisor)
    {
        int divisorLength = divisor.length();
        int dlength = data.length();
        int i,j;

        for(i=0; i<divisorLength-1;i++)
        {
            data=data+'0';
        }

        char[] dataArray = data.toCharArray();
        char[] divisorArray = divisor.toCharArray();

        int dataLength= dataArray.length;

        char[] zeroArray = new char[divisorLength];
        for(i = 0;i<divisorLength;i++)
        {
            zeroArray[i]='0';
        }

        char[] tempa = new char[divisorLength];

        char[] a= new char[divisorLength];

        char[] subtract;

        for(i=0;i<dataLength-divisorLength+1;i++)
        {
            if(i==0)
            {
                for(j=0;j<divisorLength;j++)
                {
                    tempa[j] = dataArray[j+i];
                }


                subtract = subtract(tempa, divisorArray);

                tempa = new char[subtract.length];
                for(j=1;j< subtract.length;j++)
                {
                    tempa[j-1]=subtract[j];
                }

            }
            else
            {
                tempa[divisorLength-1] = dataArray[i+(divisorLength-1)];
                if(tempa[0] == '0')
                {
                    subtract = subtract(tempa, zeroArray);
                }
                else
                {
                    subtract = subtract(tempa, divisorArray);
                }

                tempa = new char[subtract.length];
                for(j=1;j< subtract.length;j++)
                {
                    tempa[j-1]=subtract[j];
                }
            }
        }

        String ans="";

        ans = data.substring(0,dlength);


        for(i=0;i<divisorLength-1;i++)
        {
            ans = ans+tempa[i];
        }

        System.out.println("data = "+ans);



    }

    static boolean CRC_Checker(String data, String divisor)
    {
        int divisorLength = divisor.length();
        int dlength = data.length();
        int i,j;

        char[] dataArray = data.toCharArray();
        char[] divisorArray = divisor.toCharArray();

        int dataLength= dataArray.length;

        char[] zeroArray = new char[divisorLength];
        for(i = 0;i<divisorLength;i++)
        {
            zeroArray[i]='0';
        }

        char[] tempa = new char[divisorLength];

        char[] a= new char[divisorLength];

        char[] subtract;

        for(i=0;i<dataLength-divisorLength+1;i++)
        {
            if(i==0)
            {
                for(j=0;j<divisorLength;j++)
                {
                    tempa[j] = dataArray[j+i];
                }


                subtract = subtract(tempa, divisorArray);

                tempa = new char[subtract.length];
                for(j=1;j< subtract.length;j++)
                {
                    tempa[j-1]=subtract[j];
                }

            }
            else
            {
                tempa[divisorLength-1] = dataArray[i+(divisorLength-1)];
                if(tempa[0] == '0')
                {
                    subtract = subtract(tempa, zeroArray);
                }
                else
                {
                    subtract = subtract(tempa, divisorArray);
                }

                tempa = new char[subtract.length];
                for(j=1;j< subtract.length;j++)
                {
                    tempa[j-1]=subtract[j];
                }
            }
        }


        for(i=0;i<divisorLength-1;i++)
        {
            if(tempa[i]=='1')
                return false;
        }


        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter data : ");
        String data = sc.next()+sc.nextLine();

        System.out.println("Enter Divisor : ");
        String divisor = sc.next();

        CRC_Calculate(data,divisor);

        System.out.println("Enter received data : ");
        String receiveddata = sc.next()+sc.nextLine();

        if(CRC_Checker(receiveddata, divisor))
        {
            System.out.println("data correct");
        }
        else
        {
            System.out.println("data incorrect");
        }
    }
}
