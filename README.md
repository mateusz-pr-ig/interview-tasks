# Interview tasks

## Task 0 - compilation result

```java
public class Streets {
  static String [] streets = {
            "1st Street",
            "2nd Street",
            "3rd Street",
            "4th Street"
  };
  
  public static String rideTo (int pos){
      try{
         return streets[pos] + "is";
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
        System.out.print("not");
        return "";
      }finally {
          System.out.print(" in our neighborhood.");
      }
  }

  public static void main(String[] args) {
      System.out.println(rideTo(4));
  }
}
```

## Task 1
String manipulation and stream processing

## Task 2
Palindrome checker

## Task 3 - Implement logic

Task context:
- You need to implement a user migration from a legacy system to a new system. 
- The data comes from two different sources (CSV file and database) and requires transformation and deduplication.

## Task 4 - Refactor code and implement getTotalPrice


## API Code review


```java
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        userRepository.save(user);
        return "User created";
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userRepository.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
      List<UserDto> users = userRepository.getAllUsers();
      return ResponseEntity.ok(users);
    }
}
```

## Repository layer code review


```java
@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}
```
## Entity code review

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    @ManyToMany
    private List<Role> roles = new ArrayList<>();
}
```
