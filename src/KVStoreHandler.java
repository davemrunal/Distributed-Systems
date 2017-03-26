package kvstore;

import org.apache.thrift.TException;
import java.util.HashMap;
import java.util.Map;


public class KVStoreHandler implements KVStore.Iface {
	
	HashMap<String, String> hmap = new HashMap<String, String>();
	@Override
	public Result kvset(String key, String value) throws org.apache.thrift.TException {
		hmap.put(key,value);
		return findByValue(0);
		
	}
	
	public Result kvget(String key) throws org.apache.thrift.TException {
		if (hmap.containsKey(key))
			return hmap.get(key);
		else
			return ErrorCode.findByValue(1);
	}

	public Result kvdelete(String key) throws org.apache.thrift.TException {
		if (hmap.containsKey(key))
			{ hmap.remove(key);
			  return ErrorCode.findByValue(0);
			}
		else 
			return ErrorCode.findByValue(1); 	
	}
}
