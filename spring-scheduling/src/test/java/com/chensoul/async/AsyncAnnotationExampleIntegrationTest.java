package com.chensoul.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {SpringAsyncConfig.class}, loader = AnnotationConfigContextLoader.class)
public class AsyncAnnotationExampleIntegrationTest {

	@Autowired
	private AsyncService asyncService;

	// tests

	@Test
	public void testAsyncAnnotationForMethodsWithVoidReturnType() {
		log.info("Start - invoking an asynchronous method. " + Thread.currentThread().getName());
		asyncService.asyncMethodWithVoidReturnType();
		log.info("End - invoking an asynchronous method. ");
	}

	@Test
	public void testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException {
		log.info("Start - invoking an asynchronous method. " + Thread.currentThread().getName());
		final Future<String> future = asyncService.asyncMethodWithReturnType();

		while (true) {
			if (future.isDone()) {
				log.info("Result from asynchronous process - " + future.get());
				break;
			}
			log.info("Continue doing something else. ");
			Thread.sleep(1000);
		}
	}

	@Test
	public void testAsyncAnnotationForMethodsWithConfiguredExecutor() {
		log.info("Start - invoking an asynchronous method. ");
		asyncService.asyncMethodWithConfiguredExecutor();
		log.info("End - invoking an asynchronous method. ");
	}

	@Test
	public void testAsyncAnnotationForMethodsWithException() throws Exception {
		log.info("Start - invoking an asynchronous method. ");
		asyncService.asyncMethodWithExceptions();
		log.info("End - invoking an asynchronous method. ");
	}

}
