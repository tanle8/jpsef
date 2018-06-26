
/**
 * Write a description of Part1 here.
 * 
 * @author (Tan Le) 
 * @version (07-06-18)
 */
public class Part1 {
    public void findAbc(String input)
    {
        int index = input.indexOf("abc");
        System.out.println(index); // debug
        while (true)
        {
            if (index == -1) {
                break;
            }
            System.out.println(index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+4);
            if (index >= input.length() - 3)
            {
                break;
            }
            System.out.println("index after updating " + index);
        }
    }
    public void test()
    {
       // findAbc("abcd");
       findAbc("abcdabc");
    }
}
