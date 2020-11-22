package skillsoftapp4.skillsoftapp4;

import java.util.Iterator;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

public class App 
{
public static void main( String[] args )
{
    System.out.println( "Hello World!" );
DefaultDockerClientConfig config=DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost("tcp://127.0.0.1:2375").build();
DockerClient client=DockerClientBuilder.getInstance(config).build();
//client.startContainerCmd("3a6c1ea88cf3abc0113693161c2844bba4a80b9cac4697bae7fa303f599ec84c").exec();
List<Container> containers=client.listContainersCmd().withShowAll(true).exec();

Iterator<Container> it=containers.iterator();
while(it.hasNext())
{ Container container= it.next();
System.out.println(container.getId()+" "+"status="+container.getStatus());
}
  
   }
}
