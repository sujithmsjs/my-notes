522 RoleId
609 OrgId

OdeskUser findByReportingManagerId(int reportingManagerId);

The goal of the Spring Data repository abstraction is to significantly reduce the amount of boilerplate code required to implement data access layers for various persistence stores.

ListCrudRepository offers equivalent methods, but they return List where the CrudRepository methods return an Iterable.

Underlying persistence technology:
The typical approach:
manipulate: edit, update, work on

Derived Delete Query:
long deleteByLastname(String lastname);
List<User> removeByLastname(String lastname);

Derived Count Query:
long countByLastname(String lastname);

@RepositoryDefinition:
If you do not want to extend Spring Data interfaces, you can also annotate your repository interface with @RepositoryDefinition.


Selectively exposing CRUD methods:
```java
@NoRepositoryBean
interface MyBaseRepository<T, ID> extends Repository<T, ID> {

  Optional<T> findById(ID id);

  <S extends T> S save(S entity);
}

interface UserRepository extends MyBaseRepository<User, Long> {
  User findByEmailAddress(EmailAddress emailAddress);
}
```

In the prior example: 
prior: earlier, previous, initial
Opposite: later, subsequent

@NoRepositoryBean:
The intermediate repository interface is annotated with @NoRepositoryBean. Make sure you add that annotation to all repository interfaces for which Spring Data should not create instances at runtime.

@Nullable:








