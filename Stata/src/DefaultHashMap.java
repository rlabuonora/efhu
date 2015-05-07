import java.util.HashMap;

public class DefaultHashMap<K,V> extends HashMap<K,V> {
    
    protected V defaultValue;
    
    public DefaultHashMap(V defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public V get(Object k) {
        return containsKey(k) ? super.get(k) : defaultValue;
    }

	public void setDefault(V defaultValue) {
		// TODO Auto-generated method stub
		this.defaultValue = defaultValue;
	}

	public static void main(String[] args)
	{
		
	}
}