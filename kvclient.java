package kvstore;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class kvclient {
  public static void main(String [] args) {

   try {
      TTransport transport;
     
      transport = new TSocket("localhost", 9090);
      transport.open();

      TProtocol protocol = new  TBinaryProtocol(transport);
      MultiplicationService.Client client = new MultiplicationService.Client(protocol);

      set(client);

      transport.close();
    } catch (TException x) {
      x.printStackTrace();
    } 
  }

  private static void set(KVStore.Client client) throws TException
  {
   
    System.out.println(client.kvset("mrunal", "dave"));
    //System.exit(0);
  }

  private static void get(KVStore.Client client) throws TException
  {
   
    System.out.println(client.kvget("mrunal");
    //System.exit(0);
  }

  private static void del(KVStore.Client client) throws TException
  {
   
    System.out.println(client.kvdelete("mrunal");
    //System.exit(0);
  }
}
