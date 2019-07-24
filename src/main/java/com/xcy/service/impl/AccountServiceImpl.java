package com.xcy.service.impl;

import com.xcy.mapper.AccountMapper;
import com.xcy.pojo.CollectionAccount;
import com.xcy.pojo.Account;
import com.xcy.pojo.User;
import com.xcy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.Mapping;
import sun.security.krb5.internal.Ticket;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<Account> selectUserMsg(Account account) {
        List<Account> accountList = accountMapper.selectUserMsg(account);
        return accountList;
    }

  @Override
    public int saveMsg(Account account) {
        accountMapper.saveMsgById(account);
        int id = account.getId();
        return id;
    }

    @Override
    public int updateMsg(Account account) {
        accountMapper.updateMsgById(account);
        int id = account.getId();
        return id;
    }

    @Override
    public String selectUserLevel(Account account) {
        return accountMapper.selectUserLevel(account);
    }

    @Override
    public String updateAccountMoney(Account money) {
        int i = accountMapper.updateAccountMoney(money);
        if(i != 1){return "fail";}
        return "success";
    }



    @Autowired
    AccountMapper accountMapper;


    @Override
    public String updatePhoneNumById(int id, int newPhoneNum) {



        int i = accountMapper.updatePhoneNumById(new User(id,newPhoneNum));
        if (i!=1){
            return "false";
        }
        return "true";
    }

    @Override
    public String showPhoneNumById(int id) {

        String s = accountMapper.showPhoneNumById(id);


        return s;
    }

    @Override
    public Boolean updatePasswordById(int id, int password) {

        int i = accountMapper.updatePasswordById(id, password);


        if (i!=1){
            return false;
        }
        return true;
    }

    @Override
    public String showPasswordById(int phoneNum) {

        String String = accountMapper.showPasswordById(phoneNum);


        return String;
    }


    @Override
    public Boolean insertCollectionAccount(int phoneNum, CollectionAccount collectionAccount) {

        int i = accountMapper.insertCollectionAccount(phoneNum, collectionAccount);

        if (i != 1){
            return false;
        }

        return true;
    }

    @Override
    public List<CollectionAccount> showCollectionAccount(int phoneNum) {

        List<CollectionAccount> collectionAccounts = accountMapper.showCollectionAccount(phoneNum);
        return collectionAccounts;
    }

    @Override
    public List<Ticket> selectAllCouponById(int phoneNum) {

        List<Ticket> tickets = accountMapper.selectAllCouponById(phoneNum);

        return tickets;

    }


    @Override
    public Account findAll(int id) {
        return accountMapper.findAll(id);
    }
}
