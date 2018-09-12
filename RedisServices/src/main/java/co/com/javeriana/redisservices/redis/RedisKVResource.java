package co.com.javeriana.redisservices.redis;


import co.com.javeriana.redisservices.redis.cdi.FromJedisPool;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import redis.clients.jedis.Jedis;

@Path("kv")
public class RedisKVResource {
    
      
    @Inject
    @FromJedisPool
    Jedis jedisFromPool;
    
    @GET
    @Path("{key}")
    public String get(@PathParam("key") String key){
        System.out.println("Getting value for key "+ key);
        String value = jedisFromPool.get(key);
        System.out.println("Value ---- "+ value);
        return value;
    }
    
    
    
    @POST
    @Path("{key}")
    public void put(@PathParam("key") String key, String value){
        jedisFromPool.set(key, value);
        System.out.println("Set value for key "+ key + " as "+ value);
    }
    
   
}
