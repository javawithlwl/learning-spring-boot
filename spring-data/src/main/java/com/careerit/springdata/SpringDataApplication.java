package com.careerit.springdata;

import com.careerit.springdata.domain.Transaction;
import com.careerit.springdata.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	@Autowired
	private TransactionRepo transactionRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Transaction transaction = new Transaction();
//		transaction.setAmount(1000);
//		transaction.setFromAccount("1111111111");
//		transaction.setToAccount("2222222222");
//		transaction.setDateTime(java.time.LocalDateTime.now());
//		transactionRepo.save(transaction);

		List<Transaction> list = transactionRepo.findAll();
		for(Transaction t:list){
			System.out.println(t);
		}
	}
}
