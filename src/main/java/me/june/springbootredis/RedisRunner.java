package me.june.springbootredis;

import me.june.springbootredis.account.Account;
import me.june.springbootredis.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-05-30
 * Time: 21:45
 **/
@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("june","young");
        values.set("springboot","2.1.5");
        values.set("hello","world");


        Account account = new Account();
        account.setId("june");
        account.setEmail("pupupee9@gmail.com");
        account.setUsername("june0");

        Account savedAccount = accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(savedAccount.getId());
        System.out.println(byId.get().getId());
        System.out.println(byId.get().getUsername());
    }
}
