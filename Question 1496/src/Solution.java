import java.util.HashSet;

public class Solution {
    public boolean isPathCrossing(String path)
    {
        int x=0, y=0;
        HashSet<String> way = new HashSet<>();
        way.add("0,0");

        char[] charPath = path.toLowerCase().toCharArray();
        for (int i = 0; i < charPath.length; i++)
        {
            switch (charPath[i])
            {
                case 'n' :
                    y++;
                    break;
                case  's':
                    y--;
                    break;
                case 'e':
                    x++;
                    break;
                case 'w':
                    x--;
                    break;
            }
            String dir = x +","+ y;
            if(way.contains(dir))
                return true;
            else
                way.add(dir);
        }
        return false;
    }
}
