package me.june.springbootredis.account;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-05-30
 * Time: 21:50
 **/
public interface AccountRepository extends CrudRepository<Account, String> {

}
