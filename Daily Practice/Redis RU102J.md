------------
Redis RU102J
------------

Chapers / Video tutorials / Quizzes / labs & homeworks questions

Redis Solor:

api
doa
resources


Simplicity
Principle of least astonishment
	jedis.set
	jedis.get
	jedis.close -> make sure to close TCP Socket
Jedis Instances : represent a single TCP Socket and they are not thread-safe.
 
Jetty is multi-threaded.

Redis Clients:
- Manager Connection
- Impl the Redis serialization Protocol(RESP)
- Provide a usable language-specific API



Example:
- Jedis
- Lettuce
- Redisson

---------------------
Jedis
---------------------

public Jedis(String host)
public Jedis(HostAndPort hp)

JedisPool() // Thread safe

Config



JedisPoolConfig poolConfig = new JedisPoolConfig();
- Test While Idle
- Min Evictable Idle Time Millis
- Time Between Evictable Millis
- Num Tests Per Eviction Run
- Max Total
- Max Idle

JedisPool jedis = new JedisPool(poolConfig, "localhost", 6379);




Connection example:
Jedis Sentinel Pool
Jedis Cluster


DTOS:

Redis DAOs and Domain Objects


DATA ACCESS OBJECT

App
SiteDAO(Interface)
SiteDAORedisImpl(Class)
RedisServer

interface SiteDAORedisImpl{
	insertSite(Site site);
}


SiteDAORedisImpl implements SiteDAO{

}

Domain Object Summary
- Declare fields relevant to the domain
- Expose each field in a way that allows the object to be serialized.
- Setter and Getter with jackson annotations for JSON.
- Define equal(), hashCode() and toString();

The DAO Pattern(Separation of conserns)

- Domain Objects
	Pure data representations
- DAO Interface
	Data store agnostic api
- DAO Implementations
	Interact with a particular data sore.


String hashKey = RedisSchema.getSiteHashKey(site.getId());


---

Homework:

Site findById(Long id);
findByIdWithMissingSide();


Redundent: useless
Example : jedis.close() is redundant because the try-with-resources block will automatically close the Jedis instance, thereby returning it to the pool.

specifically

@return Integer reply, specifically: the cardinality (number of elements) of the set as an integer.

Cardinality :number of elements


---

WEEK 2

- Data ingestion
- Meter Reading Domain Object
- Modeling Events and metrics
- Modeling Solar Site Stats
- Lua Scriping 
- Transactions
- Coding Challenges


DATA MODEL OVERVIEW
-------------------


Data ingestion
--------------
public class MeterReading {
	//...
}

Networks aren't always reliable, and servers may not always
be online.
In these cases, we need our meters
to be able to queue their readings
and then submit them as a batch when possible.


- Meters can report queued data in a single request

Metrics Requirements
- Store multiple metrics in a single key
- Query ranges of within the key
- Store minute-level readings

SORTED SET METRIC NAMING

metrics:whg:2020-02-01:1
prefix:metric:day:siteId


ZRANGE
ZADD

Portfolio
tackle
volatile
SGB: Sovereign Gold Bonds
collateral noun(/kəˈlætərəl/)
Ex:
We had put our house up as collateral for our bank loan.
Sovereign Gold bonds can be used as coollateral for availing loans.

collate verb: to collate data/information/figures

Redemption



// Delete all keys in the currently selected database
        jedis.flushDB();

sorted set workds like HashMap

<key: <Member: Score> >

Elements will be stored according to the score which is double value.

Member is like the key in hashtable, so trying to insert member will override the previous member score.

Lua Scriping

Transactions

Long hset(Key, Field, Value)
Long hincrBy(KEY, Field, Long Value)



// Key, Field, Value(Which is going to get increased)
			jedis.hincrBy(key, "Count", 1);

RACE CONDITION
For one, we have a race condition.
This is because the compare-and- update operation isn't atomic.



LUA SCRIPTING WITH Jedis
------------------------
- STORED PROCEDURES
- EXECUTE CUSTOM LOGIC ON THE SERVER
- EXECUTE ATOMATICALLY

local key = KEYS[1]
local key = ARGV[1]
local current = redis.call('GET', key)
if(current == false) or
	()

- WHERE TO WRITE SCRIPTING
- LOAD THE SCRIPT ON INIT UING THE SCRIPT LOAD COMMAND
	- CACHE THE SHA

METHOD:
String script = "...script..."
String sha = jedis.scriptLoad(script)

List<String> keys = ...
List<String> args = ...
Object res =  jedis.evalsha(sha, keys, args);
return (Long) res = 1;



SCRIPT LOAD
EVAL SHA



---

PIPLELINING:

- Execute multiple commands in a single round trip.
- Efficient because...
	-- Reduces round-trip overhead
	-- Reduces the number of syscalls
	
- Execute more than one Redis command as a single, logical command

- Can consist of reads, writes or a combination of the two.

- Responses to all commands are teturned at once.
- Not guaranteed to execute atomically.

Pipleline p = jredis.pipelined();
p.hset(...)
p.expire(...)
p.sadd(...)
p.sync();


---

TRANSACTIONS:

- To provide automicity
- Most clients implements transactions as pipelines
- Guaranteed to be completed in single unit.

Transactions t = jedis.multi();
Response<Long> hset = t.hset(...);
Response<Long> hset = t.hset(...);
Response<Long> hset = t.hset(...);
Response<Long> hset = t.hset(...);
t.exec();

hset.get(); // To get the return value.

---

PIPELINE VS TRANSACTIONS

WHEN TO GO FOR PIPELINE?
- You have two or more commands to execute.
- Can wait for the responses of all commands at once.


WHEN TO GO FOR TRANSACTION?
- You required atomic execution of a set of commands.
- You can afford to block other clients while these commands execute.
- If you don't need automicity guaranty better go for the pipeline.
- Transactions execute atomically; pipelines don't.
- multi Redis/Jedis command marks the beginning of a transaction.
- Transactions and Lua scripting techniques can you use to atomically execute two or more Redis commands?

---

---------
Chapter-3
---------

- Site Capacity with Sorted Set
- Geo
- Geo + Criteria + Lua
- Streams


Site Capacity Leaderboards
--------------------------

- LB keep track of rankings
- A common Redis use cases
- See the solar sites with greatest and least capacity


Sorted Set
---------

Scores | Elements
-2.3

ZRANGE -> lowest to highest(log(n) + m)
ZREVRANGE -> highest to lowest

Creative Key naming:

sites:capacity:ranking:[city]

Problems:
- Low cordinality performance is not a problem, but with large sorted set, retrieving large ranges may be expensive.

- So keep your ranges small.

TRIMMING SORTED Set
- ZREM
- zREMBER
- ZREMRANGE BY RANK
	

jedis.zrevrank() or jedis.zrank(

- Z RANK
- Z REV RANK



Geospatial Data:
----------------
Redis Geospatial Features
- Store geospatial coordinates and issue queries againt them.
- Unser the hood:
	Geohash(Algorithem)
	Sorted Sets
	
- GEO ADD
- GEO REDIUS

GEOADD sites:geo -longitude -latitude sideId -> 1 Success


GEO REDIUS: sites:geo -longitute 1km
Go retrive details back

GEOADD(KEY, LONGITUDE, LATITUE, KEY)
ZRANGE(KEY, 0, -1)

NOTES ON FIND ALL
- With large sorted sets, consider ZSCAN for iterative retrieval.

- Optimize multiple H GET ALL round trips with pipelining
- H GET ALL

GET RADIUS(KEY, LONGITUDE, LATITUE, REDIUS, RADIUS_UNIT); Returns List<GeoRadiusResponse>

































































































