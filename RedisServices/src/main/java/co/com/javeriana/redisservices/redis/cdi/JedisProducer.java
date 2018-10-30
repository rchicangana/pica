package co.com.javeriana.redisservices.redis.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import redis.clients.jedis.Jedis;

@ApplicationScoped
public class JedisProducer {

    @Dependent
    @Produces
    public Jedis get(InjectionPoint ip) {
        System.out.println("injecting Jedis into " + ip.getMember().getDeclaringClass().getSimpleName());
        String redisHost = "35.203.20.85";
        String redisPort = "6379";

        Jedis jedis = new Jedis(redisHost, Integer.valueOf(redisPort), 10000);
        jedis.connect();
        System.out.println("Redis Connection obtained");
        return jedis;
    }

    //close the connection when the context of the 'dependent' component does not exist
    public void destroy(@Disposes Jedis jedis) {
        jedis.close();
        System.out.println("Closed Jedis connection");
    }
}
