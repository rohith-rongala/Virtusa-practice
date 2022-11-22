// write program for balanced brackets using the stack
// balanced , not balanced
//[()]{}{{()()]()}
//[(])
//({()})
//[()}
using System;
class Test
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Enter the string");
        string s = Console.ReadLine();
        char[] ch = s.ToCharArray();
        
        if (IsBalanced(ch))
            Console.WriteLine("Balanced");
        else
            Console.WriteLine("Not Balanced");

    }
    static Boolean IsBalanced(char[] ch)
    {
        Stack<char> st = new Stack<char>();
        for (int i = 0; i < ch.Length; i++)
        {
            char c = ch[i];
            if (c == '{' || c == '[' || c == '(')
            {
                st.Push(c);
            }
            else
            {
                if (st.Count() == 0)
                {
                    return false;
                }
                else if (!Balanced(st.Pop(), c))
                    return false;

            }
            
        }
        if (st.Count == 0)
            return true;
        else
            return false;

    }
    public static Boolean Balanced(char c1, char c2)
    {
        if (c1 == '(' && c2 == ')')
            return true;
        else if (c1 == '{' && c2 == '}')
            return true;
        else  if (c1 == '[' && c2 == ']')
            return true;
        else
            return false;

    }
}