Bean life cycle is managed by the spring container.
When we run the program then, first of all, the spring container gets started.
After that, the container creates the instance of a bean as per the request, and then dependencies are injected. And finally, the bean is destroyed when the spring container is closed.


Using Annotation
----------------
@PostConstruct
Annotate this method to execute it automatically as the bean is instantiated.

@PreDestroy
Annotate this method to execute it when Spring container is closed.
