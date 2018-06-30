package com.example.mybatis.mapper;


import com.example.mybatis.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {

    /**
     * 插入account
     *
     * @param account
     * @return
     */
    @Insert("insert into account(name,money) values (#{name},#{money})")
    int add(Account account);

    /**
     * 更新account
     *
     * @param name
     * @param money
     * @param id
     * @return
     */
    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int id);

    /**
     * 删除account
     * @param id
     * @return
     */
    @Delete("delete from account where id = #{id}")
    int delete(@Param("id") int id);

    /**
     * 根据id获取account
     * @param id
     * @return
     */
    @Select("select id,name,money from account where id = #{id}")
    Account findAccount(@Param("id") int id);

    @Select("select id,name,money from account")
    List<Account> listAccount();
}
