package com.ultrawav.helloaws.util;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = AbstractRepositoryTestApplicationContextConfig.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class AbstractRepositoryTest {

}
