## System Design

System design is the process of designing the elements of system such as the **Architecture, Modules,** ans **Components,** the different **Interfaces** of those components and the **Data** that goes through the system. 

**Types of System Design**

* LLD (Low level design)
* HLD (High level design)

| S.N. | HLD                                                                                                                              | LLD                                                                                                     |
| ---- | -------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| 1.   | Describes the main components that would be developed for the resulting product.                                                 | Describes the design of each element mentioned in the high level design of the system.                  |
| 2.   | The system architecture details, database design, services and processes, the relationship between various modules and features. | Classes, interfaces, relationship between different classes and actual logic of the various components. |

---

## Architecture

Internal design details for building the applications.

**Types of Application Architecture**

* Monolithic
* Distributed

##### Monolithic Architecture

If all the components and functionalities of a project are entangled and combined in a single codebase, then that is a monolithic application. Means Frontend + Backend + Database, all things are writen in a single codebase. It is also known as **Centralised System.**

**Advantages**

* Less complexity.
* Easier to understand.
* Higher productivity.
* Fewer network calls as compared to other architectures.So, latency* will be low.
* Monolothic system is easier to implement security.
* Integration testing is easier.
* Less confusion

**Disadvantages**

* Single point of failure
* every module is combined in a single system, so if there is an error or bug in a single module, it can destroy the complete system.
* whenever a single module is updated, the whole system needs to be updated to reflect the changes to the users. All modules are present in a single system and are connected to one another, so the whole system needs to be updated.
* if there is any change in a single module's programming language or framework, it will affect the entire system. The entire system needs to be changed because every module is interlinked and tightly coupled.

##### Distributed System

A distributed system is a collection of multiple individual systems connected through a network that share resources, communicate and cordinate to achieve common goal.

Advantages

* Scalable
* No single point of failure
* High latency*

Disadvantages

* Complex
* Additional management reuired(like - load balencers etc.)
* Difficult to secure
* Message may be lost in b/w nodes


###### Latency

***Latency = Network delay + Computational delay**

**Way to Reduce Latency**

* **Caching :** Caching is the process of storing information for a set period of time on a computer.
* **CDN :** CDNS are geographically distributed networks of proxy servers and their objective is to serve content to users more quickly.
* Improve server configurations

---

## Throughput

The volume of work or information going through a system.

Throughput is the amount of data transmitted per unit of time. It is the process flow rate.
Throughput is measured in bits per second i.e. bps.

Monolithic < Distributed

**Causes of low throughput**

* Latency
* Protocol overhead
* Congestion

**Improving throughput**

* CDN
* Caching
* Distributed system
* Load balancer
* Improve server configurations
