# VirtualThreads

- https://www.infoworld.com/article/3678148/intro-to-virtual-threads-a-new-approach-to-java-concurrency.html

<!---

Horizontal and vertical scaling
A scaling strategy is an approach to accommodate for varying workload and traffic requirements. Compute and storage resources can be scaled either vertically (scale up/down) or horizontally (scale out/in).

Scaling can be done manually or scheduled to be performed automatically, based on predefined metrics.

Solution
Vertical and horizontal scaling are different approaches to handling a change in workload: vertical scaling adjusts the resource capacity of the same hosting node, while horizontal scaling distributes the workload between additional nodes or decreases the number of nodes.

Vertical scaling (scaling up/down)
Vertical scaling, or scaling up, is the simplest form of scaling. It means increasing system resources on the node hosting the workload. Depending on the virtualisation technology used, we can increase CPU capacity, make more memory available to the host, add more disks, or swap components for their improved versions. In bare metal hosting or in general, scaling out is swapping overburdened resources with ones with bigger capacity.

Vertical scaling has an upper limit set by the technologies used, both hardware and software. Examples include the following:

There is a physical limit to how many banks of RAM a chipset can support.

The number of CPU sockets on a single motherboard is limited.

The number of high-speed PCI lanes that a single chipset can handle can be firmware-limited to specific components only.

Horizontal scaling (scaling out/in)
Horizontal scaling, or scaling out, distributes the workload across a number of available hosts or nodes. When capacity is exhausted or almost exhausted, a new node is added.

Horizontal scaling has its own tradeoffs. Note that when the workload processing leaves the single-host paradigm, we need to start thinking about factors like physical distance between hosts, data locality, availability, and consistency, in addition to connectivity issues.

Horizontal scaling often incurs added latency and increased synchronisation and load scheduling work. It is essential to analyse how efficient a scaling group is, or how it grows in available capacity when nodes are added, because not all systems grow linearly.

Considerations
A precondition to horizontal and vertical scaling is the possibility to update host configurations without causing downtime or introducing software defects. In the case of vertical scaling, workload processing probably needs to be interrupted during the update, which means that a highly available deployment with anti-affinity is essential.

With horizontal scaling, we need to make sure that workload processing can be redistributed, hosted, and completed independently from other nodes. This is often achieved by the use of load-balancing solutions, stateless sessions, and by designing workloads that can be abandoned and re-scheduled. <!—Consider addiing links to related articles—>

Implementation of horizontal and vertical scaling at ING
In ICHP, both horizontal and vertical scaling are possible. Horizontal scaling adds more replicas, while vertical scaling adds more resources to existing replicas. The preferred method is horizontal scaling. You can perform this manually by adjusting the number of replicas in your deployment configuration, or you can scale automatically by using the Horizontal Autoscaler. Auto-scaling is based on CPU and or memory metrics.

Kingsroad
When deploying to ICHP with Kingsroad a default horizontal and vertical scaling configuration is provided for you in the deployment pipeline. A good practice is to set the number of replicas equal or greater than 2. Be careful when you set the number of replicas to 1. It is likely that you’re setting this due to technical constraints. If your pod fails on one data centre, you are running only on the other data centre.

Service discovery
Service discovery is about finding a service at runtime, without prior need to know its IP address or hostname.

Context and problem
An instance is a running process of a service version or application, addressable on TCP/IP network via a socket identified by an IP address and a TCP port.

There may be multiple instances of a service running simultaneously, and its instances may be running at different versions. Services typically need to call one another, meanwhile some of multiple instances may be unhealthy or unavailable.

Without service discovery, the provider of service instances needs to be known by the consumer, through its configuration or in its code:

Without Service discovery

Every configuration or code needs to be occasionally updated and require operational downtime to be changed.

Solution
Introducing a service registry helps consumers discovering available instances of a service at runtime, omitting the need to hardcode provider’s properties. A service registry is a database of services, their instances and locations. Service instances can be registered and deregistered with the service registry. Service registry can also perform health checks on the registered instances to verify that they are able to handle requests.

Scenarios
There are two primary service discovery scenarios, utilizing service registry component: server-side discovery and client-side discovery.

With server-side service discovery, the consumer makes a request via a proxy or load balancer that runs at a well known location. The consumer doesn’t require prior knowledge of the provider instances. The proxy or load balancer uses service registry to identify viable and healthy instances of the provider service, and then forwards the consumer request to one of the instances. The service registry component may be built into the proxy or load balancer:

server-side service discovery

With client-side service discovery, the consumer obtains the location of viable and healthy instances of the provider service they seek by looking up service registry, and then connects directly to these instances:

client-side service discovery

Considerations
When choosing between client-side service discovery and server-side service discovery, there are notable differences and trade-offs.

Server-side
In case of server-side discovery, the consumer code is simpler since it does not have to perform discovery activities. Instead, a client makes a request to the proxy or load balancer, introducing some isolation between consumer and producer.

In case of server-side discovery, the following considerations are applicable:

Installing and configuring another component: The proxy or load balancer is another system component that must be installed and configured. And, it will also need to be designed and configured for replication, availability, and capacity.

Added latency: More network hops are required than when using client-side discovery.

Client-side
Compared to server-side discovery, client-side discovery has fewer moving parts and network hops.

Points to consider for client-side discovery:

Added dependency on the service registry.

Service discovery logic and load balancing algorithms may need to be implemented for the programming language or framework used by the consumer.

Less isolation between consumer and provider.

Implementation of service discovery at ING
At ING, a provider service is commonly referred to as an API endpoint, defined by the triplet HTTP method, host, and URL Path Template.

-->
