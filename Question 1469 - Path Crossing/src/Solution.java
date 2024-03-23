import java.util.HashSet;

class Solution
{
    private static class Pair
    {
        int x, y;
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }
    }
    public boolean isPathCrossing(String path)
    {
        HashSet<Pair> set = new HashSet<>();
        set.add(new Pair(0, 0)); //start

        int x = 0, y = 0;
        for(char c : path.toCharArray())
        {
            if(c == 'N') y++;
            else if(c == 'S') y--;
            else if(c == 'E') x++;
            else x--;
            if(!set.contains(new Pair(x, y))) set.add(new Pair(x, y));
            else return true;
        }

        return false;
    }
}