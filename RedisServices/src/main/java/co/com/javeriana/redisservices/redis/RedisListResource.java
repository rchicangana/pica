/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.redisservices.redis;

import co.com.javeriana.redisservices.redis.cdi.FromJedisPool;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import redis.clients.jedis.Jedis;

/**
 *
 * @author rchicangana
 */
@Path("listas")
public class RedisListResource {
    
    @Inject
    @FromJedisPool
    Jedis jedisFromPool;
    
    private final static Logger LOG = Logger.getLogger(RedisListResource.class.getName());
    
    /**
     * obtiene informacion de una lista almacenada en redis
     * @param list
     * @param ini
     * @param fin
     * @return
     */
    @GET
    @Path("lista/{list}/{ini}/{fin}")
    public List<String> getList(@PathParam("list") String list, @PathParam("ini") Integer ini, @PathParam("fin") Integer fin){
        LOG.log(Level.INFO, "Obteniendo informacion de la lista {0} del objeto {1} al {2}", new Object[]{list, ini, fin});
        return jedisFromPool.lrange(list, ini, fin);
    }
    
    
    
}
