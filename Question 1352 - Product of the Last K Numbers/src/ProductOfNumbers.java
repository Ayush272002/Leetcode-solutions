import java.util.ArrayList;

class ProductOfNumbers
{
    ArrayList<Integer> stream;
    int product;

    public ProductOfNumbers() {
        stream = new ArrayList<>();
        product = 1;
    }

    public void add(int num)
    {
        if(num ==0)
        {
            stream.clear();
            product = 1;
        }
        else
        {
            product *= num;
            stream.add(product);
        }
    }

    public int getProduct(int k)
    {
        if(k==stream.size()) return product;
        if(k>stream.size()) return 0;

        return stream.get(stream.size()-1)/stream.get(stream.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */