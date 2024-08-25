 Marker Interface
--------------------
This is a marker interface, meaning it doesn't have any methods to implement.
It simply acts as a flag to indicate the class can be serialized.

Name some marker interfaces
------------------------------
Serializable: This interface indicates that an object's state can be serialized. In other words, it can be converted into a stream of bytes for storage or transmission.

Cloneable: This interface tells the JVM that it's legal to clone objects of the implementing class. Cloning creates a new instance with the same state as the original object.

Remote: This interface is used in remote method invocation (RMI) to mark classes that can have their methods invoked remotely on different machines.




