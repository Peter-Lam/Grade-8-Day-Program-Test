package my.contacteditor;
public class ThirdChoice
{
    String third(String choice, int b, int a, int d, int da, int m, int cs, int t, int mb, int ma, int md, int mda, int mm, int mcs, int mt, int bA, int aA, int dA, int daA, int mA, int csA, int tA)
    {
        if (choice.equals("Business Technology"))
        {
            if (bA == 0)
            {
                if (b < mb)
                {
                    return choice;
                }
                else if (b == mb)
                {
                    choice = "";
                }
            }
            else
            {
                choice = "";
            }
        }
        else if ("Visual Arts".equals(choice))
        {
            if (aA == 0)
            {
                if (a < ma)
                {
                    return choice;
                }
                else if (a == ma)
                {
                    choice = "";
                }
            }
            else
            {
                choice = "";
            }
        }
        else if ("Drama".equals(choice))
        {
            if (dA == 0)
            {
                if (d < md)
                {
                    return choice;
                }
                else if (d == md)
                {
                    choice = "";
                }
            }
            else
            {
                choice = "";
            }
        }
        else if ("Dance".equals(choice))
        {
            if (daA == 0)
            {
                if (da < mda)
                {
                    return choice;
                }
                else if (da == mda)
                {
                    choice = "";
                }
            }
            else
            {
                choice = "";
            }
        }
        else if ("Music".equals(choice))
        {
            if (mA == 0)
            {
                if (m < mm)
                {
                    return choice;
                }
                else if (m == mm)
                {
                    choice = "";
                }
            }
            else
            {
                choice = "";
            }
        }
        else if ("Computer Studies".equals(choice))
        {
            if (csA == 0)
            {
                if (cs < mcs)
                {
                    return choice;
                }
                else if (cs == mcs)
                {
                    choice = "";
                }
            }
            else
            {
                choice = "";
            }
        }
        else if ("Exploring Technologies".equals(choice))
        {
            if (tA == 0)
            {
                if (t < mt)
                {
                    return choice;
                }
                else if (t == mt)
                {
                    choice = "";
                }
            }
            else
            {
                choice = "";
            }
        }
        return choice;
    }
}