

int arr = {1,2,3,4,5,6};
Stream.of(arr).skip(1).findFirst();
Option<Integer> senValue =  Stream.of(arr).boxed().skip(1).findFirst();


SELECT count(*) as count, dept from Emp group by dept;
SELECT name from Emp where name like 's%';


AMAZON
PF UAN 101468055745



Collections.reverse(null);
stringBuffer.reverse();

sort(List<T> list): Natural ordering	
sort(List<T> list, Comparator<? super T> c)
		

Collections
------------
void sort(List<T> list)
void sort(List<T> list, Comparator<? super T> c)

void reverse(List);
void shuffle(List);		
void rotate(List<?> list, int distance)
void swap(List<?> list, int i, int j)
void fill(List<? super T> list, T obj)
void copy(destLit, scrList)
T min/max(Collection)
T min/max(Collection, Comparator)
boolean replaceAll(List<T> list, T oldVal, T newVal)

List<E> subList(int fromIndex, int toIndex)
int 	indexOfSubList(List<?> source, List<?> target)
int 	lastIndexOfSubList(List<?> source, List<?> target)
boolean addAll(Collection<? super T> c, T... elements)
boolean disjoint(Collection<?> c1, Collection<?> c2)
int 	frequency(Collection<?> c, Object o)
List<T> nCopies(int n, T o)
Collections.reverseOrder();


Split a List
------------
1. Using List's subList(from, to) method
2. Using limit and skip

Generate values
---------------
1. IntStream.range(from, to)
2. IntStream.rangeClosed(from, to)
3. Random.ints(from, to, size)
4. Collections.nCopies(size, value);


Duplicate a collection
----------------------
1. Copy Constructor
2. Collections.copy(sourcList, destinationList);
3. Stream collect
4. Add All to new List


Set fuction
--------------
1. UNION : addAll
2. INTERSECTION: retainAll
3. DISJOINT	: containsAll

Duplicate from collection
-------------------------
1. Set Copy Constructor
2. Stream's distinct() method
3. Collectors.toCollection(() -> new LinkedHashSet<>()


Concatinating 2 or more Lists/Streams
-------------------------------------
1. addAll method for Lists
2. Stream's flatMaps


Unmodifiable -> Modifiable
--------------------------
1. Copy Constructor
2. Using stream method

Modifiable -> Unmodifiable
--------------------------
1. Collections.unmodifiableList(list)
2. Using Java 10+ List.copyOf()
3. Streams collect method


Collection
----------
int 		size()
boolean 	isEmpty()
boolean 	contains(Object o);

Object[] 	toArray();
T[] 		toArray(T[] a);
T[] 		toArray(IntFunction<T[]> generator)


boolean 	add(E e);
boolean 	remove(Object o);

boolean 	containsAll(Collection<?> c);
boolean 	addAll(Collection<? extends E> c);
boolean 	removeAll(Collection<?> c);
boolean 	retainAll(Collection<?> c);

boolean 		removeIf(Predicate filter)
void 			clear();
Stream<E> 		stream()
Stream<E> 		parallelStream()
Iterator<E> 	iterator();
Spliterator<E> 	spliterator() 

List
----
UnaryOperator: e -> e;

boolean addAll(int index, Collection<? extends E> c);
void 	replaceAll(UnaryOperator<E> operator)
void 	sort(Comparator<? super E> c)

E 		get(int index);
E 		set(int index, E element);
void 	add(int index, E element);
E 		remove(int index);
int 	indexOf(Object o);
int 	lastIndexOf(Object o);
List<E> subList(int fromIndex, int toIndex);

static List<E> of(E... elements)
static List<E> copyOf(Collection<? extends E> coll)

ListIterator<E> listIterator(int index);
ListIterator<E> listIterator();


Set
----

static Set<E> copyOf(Collection<? extends E> coll)
static Set<E> of(E... elements)

Queue
-----
boolean offer(E e);
E remove(); // NoSuchElementException
E poll(); // null
E element(); // NoSuchElementException
E peek(); // null

Initial Capacity:
Load factor:

Map
---

BiFunction means (k, v) -> v;
BiConsumer means (k , v) -> {};


void	clear()
int		size()
boolean	isEmpty()

V		put(K key, V value)
// Can override existing key's value.

void	putAll(Map m)

V		putIfAbsent(K key, V value)
// If key is not existing, than adds value.


V		get(Object key)
V		getOrDefault(Object key, V defaultValue)
void	forEach(BiConsumer)

V		remove(Object key)
// Returns null if key not found.

boolean	remove(Object key, Object value)
// Return null if key and value pair not found


V		replace(K key, V value)
// Update value using key

boolean	replace(K key, V oldValue, V newValue)
// Update value using key and oldValue

void	replaceAll(BiFunction fun)
// Repeat all the values

boolean	containsKey(Object key)
boolean	containsValue(Object value)

Collection<V>	values()
Set<K>			keySet()

V	compute(K key, BiFunction fun)
V	computeIfAbsent(K key, Function fun)
V	computeIfPresent(K key, BiFunction fun)
V	merge(K key, V value, BiFunction fun)

Questions:
Diff b/w put and putIfAbsent
Diff b/w put and replace



Arrays Static Methods
---------------------
List<T>		asList(T... a)

int	binarySearch(byte[] a, byte key)

void		sort(int[] a)
void		sort(T[] a, Comparator<? super T> c)
Stream<T>	stream(T[] array)
 String		toString(Object[] a)
 
void		fill(Object[] a, Object val)
void		fill(int[] a, int val)
	
boolean		equals(Object[] a, Object[] a2)
boolean		equals(int[] a, int[] a2)
	
T[]			copyOfRange(T[] original, int from, int to)
int[]		copyOfRange(int[] original, int from, int to)
	
int[]		copyOf(int[] original, int newLength)
T[]			copyOf(T[] original, int newLength)

Objects
-------

int			compare(T a, T b, Comparator c)
boolean		equals(Object a, Object b)
boolean		isNull(Object obj)
boolean		nonNull(Object obj)

T	requireNonNull(T obj)
T	requireNonNull(T obj, String message)
T	requireNonNull(T obj, Supplier<String> sup)
int	hashCode(Object o)


String Methods
--------------
int		length()

String[]	split(String regex)
String[]	split(String regex, int limit)

String	replace(char oldChar, char newChar)
String	replace(CharSequence target, CharSequence replacement)
String	replaceAll(String regex, String replacement)
String	replaceFirst(String regex, String replacement)

boolean	matches(String regex)

char	charAt(int index)

int		compareTo(String anotherString)
int		compareToIgnoreCase(String str)
boolean	equals(Object anObject)
boolean	equalsIgnoreCase(String anotherString)

String	concat(String str)

static String	join(CharSequence delimiter, CharSequence... elements)
static String	join(CharSequence delimiter, Collection)

byte[]	getBytes(String charsetName)
char[]	toCharArray()

boolean	contains(CharSequence s)
boolean	endsWith(String suffix)
boolean	startsWith(String suffix)
boolean	startsWith(String prefix, int toffset)

String	substring(int beginIndex)
String	substring(int beginIndex, int endIndex)

int		indexOf(int ch)
int		indexOf(int ch, int fromIndex)
int		indexOf(String str)
int		indexOf(String str, int fromIndex)
int		lastIndexOf(int ch)
int		lastIndexOf(int ch, int fromIndex)
int		lastIndexOf(String str)
int		lastIndexOf(String str, int fromIndex)

String	toLowerCase()
String	toUpperCase()
String	trim()



StringJoiner
------------

StringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix)

StringJoiner	add(CharSequence newElement)
String			toString()


StringBuilder
-------------
StringBuilder	append(primitive p)
StringBuilder	append(char[] str)
StringBuilder	append(CharSequence s)
StringBuilder	append(CharSequence s, int start, int end)


StringBuilder	delete(int start, int end)
StringBuilder	deleteCharAt(int index)

StringBuilder	replace(int start, int end, String str)
StringBuilder	reverse()


----------------

@HttpExchange
WebClient
Reactive Programming
Reactive-Web

spring-boot-starter-webflux

Default 
capacity (16)
load factor (0.75)


Example (Considering capacity 16 and load factor 0.75):

Imagine a HashMap with an initial capacity of 16 buckets.
The load factor is 0.75, which means the threshold for resizing is 16 buckets * 0.75 = 12 entries.
As long as there are less than 12 key-value pairs in the HashMap, it won't resize.
Once the 13th element is added, the average fill ratio goes above the threshold (13 > 12), triggering a resize operation. The capacity will typically double to 32 buckets to maintain efficient lookups.

------------

ConcurrentHashMap
-----------------
- Thread safe implimentation of Hashmap.
- HashMap throws ConcurrentModificationException when try to modify concurrently.
- Thread safe
- Scalability
- by using a locking mechanism  on sigment level.
- It can handle a high volume of concurrent operations efficiently.
- SEGMENT LOCKING: ConcurrentHashMap internally divides the entire map into smaller portions called segments. These segments act like buckets where key-value pairs are stored.
By default, there are 16 segments in a ConcurrentHashMap. This number can be customized during initialization if needed.
- Retrival operations are lock-free.
- Updates require acquiring the segment lock.
- doesn't allow null keys or values.
- WEAKLY CONSISTENT: This means the iteration may not reflect the latest changes made to the map by other threads during the iteration.

Segment is the specific terminology used for ConcurrentHashMap's subdivisions.
Bucket is a broader term applicable to various data structures with containers for data elements.

Hash Function: When a key-value pair is added to a hash table, the key is passed through a hash function. This function is designed to convert the key (which can be any object) into a unique integer value, the hash code.




Inter thread Communication
--------------------------
- Two threads communication with each others.
- The therea which  is expecting an updatation need to call wait on the object.
- The thread which is performaning updatation has to call notify to awake the thread which is waiting for updatation.
- After updation it has to call notify()  to wake the waiting thread.
- wait(), notify(), notify() present in Object call.

Why these methods present in Object calls but not in thread class.
- We call start method on thread object, we can call join method.
- wait, nofity and nofityAll has to call using object.
- Object will call wait, nofity and nofityAll methods but not the thread obect.

- If any thread wants to call wait on object, it should be owner of that object.
- If the thread has the lock of the object that is called owner of that object.
- Only these methods called inside synchronized area, other wise IllegalMonitorStateException.
- When object calls wait on a object, it will release the lock of that object and goes to "waiting state" immedietnly. It won't release all the locks, it will realease only one lock.
- When a object thread call notify, it may not realease the lock immedietnly. It has to perform a few things.
- Note: Except wait, notify and nofity all thread won't realease the lock.
- In case Sleep, Yield, Join won't realease the lock, but for wait, nofity and nofity all it realease the lock. Except wait, nofity, nofityAll there is no other method realease the lock.

- public final void wait() throw IE
- public final native void wait(long ms) throw IE
- public final void wait(long ms, int ns) throw IE
- public final native void nofity()
- public final native void nofityAll()

Note: Every wait method throws Intterupted Exception is checked exception. Hence whenever we are using wait method, we should handle this exception.



Thread Lifecycle Methods
------------------------
Thread t = new Thread -----> new/born state
t.start() -----------------> Ready/Runnable State
Resources allocated -------> Running State
When run method completes -> Dead State

Running thread calls wait method ----> Waiting state
Ex: obj.wait()

If waiting thread get notification ----> Another waiting state to get the lock.
If the waitng time has completes ------> 				"
If the waiting thread get interrupted ->				"

If the waiting thread get the lock ---> Ready/Runnable State

Order of methods in interthread communicaiton
---------------------------------------------
#### IF MAIN THREAD GOT THE CHANGE FIRST

MAIN  : Got the LOCK
MAIN  : Trying to call WAIT method
MAIN  : Entered into WAITING state(PAUSED)
CHILD : Got the LOCK
CHILD : STARTED calculations
CHILD : Trying to give notification
CHILD : After gaven notification
MAIN  : Got notification(RESUMED)
MAIN  : 2001000

#### IF CHILD THREAD GOT THE CHANGE FIRST

CHILD thread got the LOCK
CHILD thread STARTED calculations
CHILD thread trying to give notification
CHILD thread after gaven notification
MAIN  thread got the LOCK
MAIN  thread trying to call WAIT method
MAIN  thread entered into WAITING state(PAUSED)

- If no threads are currently waiting, the notification is effectively lost.
- Once a thread calls notify, the notified thread can wake up and resume execution, but this doesn't involve caching the notification for future use by another thread.
- The current thread which invokes these methods on any object should have the object monitor else it throws java.lang.IllegalMonitorStateException exception.


Prevent deadlock
Indefinite waiting.

Consumer Got the lock
Consumer waiting for producer to write data!
Producer got the lock
Producer Wrote the data
Producer Gave the notification
Consumer Got Notification!
Consumer Empty the value
Consumer Gave the notification
SUCCESS

Producer got the lock
Producer Wrote the data
Producer Gave the notification
Consumer Got the lock
Consumer Empty the value
Consumer Gave the notification
SUCCESS

Yield Method
--------------
- Static Method
- Defined in the Thread
- It's used to temporarily pause the execution of the current thread and allow other threads of the same priority to execute.
- When a thread calls yield(), it indicates that it's willing to yield its current use of the CPU to other threads of the same priority.
- When a thread calls yield(), it transitions to the "runnable" state, allowing other threads to run.
- The scheduler then selects the next thread to run. If there are other threads of the same priority ready to run, one of those threads will typically be selected to run next.
- The yielded thread remains in the runnable state and may be scheduled to run again in the future.



Static Methods
---------------
- Static methods won't perticipate in overriding.
- You can't place a @Override on the static overring method.
- Ex:
Animal ani = new Dog();
	- If both have their own same static method, using object will call the same class static method.
	Animal ani = new Dog();
	ani.deit(); // Animals static method will execute.

- If you try to override the static method: This instance method cannot override the static method from Animal.
- This static method cannot hide the instance method from Animal

Case study:
#1 static super method, static child method
- No error! works perfectly!
- Suggest to call using class name
- When we call with instance method, it will invoke same class static method.


Animal ani = new Dog();
ani.deit(); // Animals static method will execute

#2 non-static super method, static child method
- ERROR: This static method cannot hide the instance method from Animal.

#3 static super method, non-static child method
- ERROR: This instance method cannot override the static method from Animal.

#4 non-static super method, non-static child method
- Works FINE

Animal ani = new Dog();
ani.deit(); // Dog's method will execute




String Methods
--------------

String str0 = "Sujith";
String str1 = "Sujith";
String str2 = new String("String");
String str3 = new String("String");

str0 == str1 true
str0 == str2 false
str0 == str3 false
str1 == str2 false
str1 == str3 false
str2 == str3 false


-------------

Collecting Map
--------------

AbstractMap, Attributes, AuthProvider, ConcurrentHashMap, ConcurrentSkipListMap, EnumMap, HashMap, Hashtable, IdentityHashMap, LinkedHashMap, PrinterStateReasons, Properties, Provider, RenderingHints, SimpleBindings, TabularDataSupport, TreeMap, UIDefaults, WeakHashMap



MICRO SERVICES
---------------
https://microservices.io/patterns/microservices


Some system operations will be local (implemented by a single service), while others will be distributed across multiple services. A distributed operation is implemented using either synchronously using a protocol such as HTTP/REST or asynchronously using a message broker, such as Apache Kafka.


There are four service collaboration patterns:

- Saga, which implements a distributed command as a series of local transactions
- Command-side replica, which replicas read-only data to the service that implements a command
- API composition, which implements a distributed query as a series of local queries
- CQRS, which implements a distributed query as a series of local queries


What’s a service architecture?
https://microservices.io/post/architecture/2023/09/19/assemblage-part-3-whats-a-service-architecture.html

Assemblage?

https://microservices.io/patterns/data/saga.html