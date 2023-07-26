package com.onpassive.odesk_admin.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.onpassive.odesk_admin.dto.MailDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MailSendingThread implements Runnable {

	private final MailUtility mailUtility;
	private final MailDto mailDto;
	private final Thread thread;

	public MailSendingThread(MailUtility mailUtility, MailDto dto) {
		this.mailUtility = mailUtility;
		this.mailDto = dto;
		thread = new Thread(this);
	}

	public void start() {
		thread.start();
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				log.error("Sleeping...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		log.info("EMAIL SEND RUN " + mailUtility);

		String toAddress = "sujith.manchala@onpassive.com";
		String subject = "Testing";
		String url = "https://obsodeskad-dev.onpassive.com/v1/features";
		String username = "sujithmanchala";
		String password = "NvrStle#22";

		MailDto dto = new MailDto();
		dto.setEmail(toAddress);
		dto.setCompanyName("Hello World");
		dto.setPassword("123456");
		dto.setAutoLoginUrl("AutoLoginURL");
		dto.setUrl("Hey please do click here");
		
		Boolean mail = mailUtility.sendMail(mailDto);
		if (mail) {
			log.info("EMAIL SEND SUCCESSFULLY!");
		} else {
			log.info("EMAIL FAILED!");
		}
	}

	public static void checkThreadPoolExecutor() {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();

		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		A a4 = new A();
		executor.submit(a1);
		executor.submit(a2);
		executor.submit(a3);
		executor.submit(a4);
		
		log.error("BEFORE SHUTDOWN");
		executor.shutdown();
		log.error("AFTER SHUTDOWN");
	}

	static class A implements Runnable {

//		public A() {
//			Thread t = new Thread(this);
//		}

		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String name = Thread.currentThread().getName();
				log.info("Running thread " + name + " : " + i);
			}
		}

	}

}
