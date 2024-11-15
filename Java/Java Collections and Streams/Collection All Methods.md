```java
interface Iterable<T>{
	Iterator<T> iterator()
Spliterator<T> spliterator()
void forEach(Consumer<? super T>
}

interface Collection<E> extends Iterable<E>{

	boolean add(E)
	boolean addAll(Collection<? extends E>)
	void clear()
	boolean contains(Object)
	boolean containsAll(Collection<?>)
	boolean equals(Object)
	int hashCode()
	boolean isEmpty()
	Iterator<E> iterator()
	Stream<E> parallelStream()
	boolean remove(Object)
	boolean removeAll(Collection<?>)
	boolean removeIf(Predicate<? super E>)
	boolean retainAll(Collection<?>)
	int size()
	Spliterator<E> spliterator()
	Stream<E> stream()
	Object[] toArray()
	T[] toArray(T[])
	
}

public interface List<E> extends Collection<E> {
	void add(int,E)
	boolean addAll(int,Collection<? extends E>)
	E get(int)
	int indexOf(Object)
	int lastIndexOf(Object)
	ListIterator<E> listIterator()
	ListIterator<E> listIterator(int)
	E remove(int)
	void replaceAll(UnaryOperator<E>)
	E set(int,E)
	void sort(Comparator<? super E>)
	List<E> subList(int,int)
}

public interface Set<E> extends Collection<E> {}

public class ArrayList<E> implements List<E>{
	void ensureCapacity(int)
	void forEach(Consumer<? super E>)
	void trimToSize()
}


public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>{}
	
	
public interface Deque<E> extends Queue<E> {

	void addFirst(E)
	void addLast(E)
	boolean contains(Object)
	Iterator<E> descendingIterator()
	E getFirst()
	E getLast()
	Iterator<E> iterator()
	boolean offerFirst(E)
	boolean offerLast(E)
	E peekFirst()
	E peekLast()
	E pollFirst()
	E pollLast()
	E pop()
	void push(E)
	boolean remove(Object)
	E removeFirst()
	boolean removeFirstOccurrence(Object)
	E removeLast()
	boolean removeLastOccurrence(Object)
	int size()

}

public interface Queue<E> extends Collection<E> {

	E element()
	boolean offer(E)
	E peek()
	E poll()
	E remove()

}
```
