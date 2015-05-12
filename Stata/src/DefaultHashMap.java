import java.util.HashMap;

public class DefaultHashMap<K,V> extends HashMap<K,V> {
    
    protected V defaultValue;
    
    public DefaultHashMap(V defaultValue) {
        this.defaultValue = defaultValue;
    }
    
    public DefaultHashMap() {}

    @Override
    public V get(Object k) {
    	if (defaultValue == null) throw new RuntimeException("Default Value not set");
        return containsKey(k) ? super.get(k) : defaultValue;
    }

	public void setDefault(V defaultValue) {
		// TODO Auto-generated method stub
		this.defaultValue = defaultValue;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-1 => " + defaultValue + "\n");
		for (K key: super.keySet()) {
			sb.append(", " + key + " => " + super.get(key) + "\n");
		}
		return sb.toString();
	}
}