package co.com.javeriana.redisservices.redis;


import co.com.javeriana.redisservices.redis.cdi.FromJedisPool;
import co.com.javeriana.redisservices.redis.dto.MensajeValorDTO;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import redis.clients.jedis.Jedis;

@Path("kv")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RedisKVResource {
    
      
    @Inject
    @FromJedisPool
    Jedis jedisFromPool;
    
    @GET
    @Path("{key}")
    public MensajeValorDTO get(@PathParam("key") String key){
        System.out.println("Getting value for key "+ key);
        String value = jedisFromPool.get(key);
        System.out.println("Value ---- "+ value);
        
        return new MensajeValorDTO(value);
    }
    
    
    
    @POST
    @Path("{key}")
    public void put(@PathParam("key") String key, MensajeValorDTO value){
        jedisFromPool.set(key, value.getValor());
        System.out.println("Set value for key "+ key + " as "+ value.getValor());
    }
    
   
}
