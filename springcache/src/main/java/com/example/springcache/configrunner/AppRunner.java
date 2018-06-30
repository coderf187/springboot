package com.example.springcache.configrunner;

import com.example.springcache.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final AccountService accountService;

    public AppRunner(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info(".... Fetching books");
        logger.info("account1 -->" + accountService.findAccount(1));
        logger.info("account2 -->" + accountService.findAccount(2));
        logger.info("account1 -->" + accountService.findAccount(1));
        logger.info("account2 -->" + accountService.findAccount(2));
        logger.info("account1 -->" + accountService.findAccount(1));
        logger.info("account2 -->" + accountService.findAccount(2));
    }
}
