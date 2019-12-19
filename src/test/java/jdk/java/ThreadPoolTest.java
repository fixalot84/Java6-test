package jdk.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ThreadPool 테스트 유닛
 * 
 * @since 2019-12-19
 * @author fixalot@lotte.net
 */
public class ThreadPoolTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ThreadPoolTest.class);
	
	private int instanceLength = 10;

	@Test
	public void test() {
		ExecutorService threadPool = null;
		Collection<Callable<Integer>> threadList = null;
		int successCount = 0;
		int failCount = 0;
		int howManyThread = 10;
		try {
			List<Myclass> list = getList();
			if (list != null && list.size() > 0) {
				threadPool = Executors.newFixedThreadPool(howManyThread);
				threadList = new ArrayList<Callable<Integer>>();
				for (int i = 0; i < list.size(); i++) {
					Mythread thread = new Mythread(list.get(i));
					threadList.add(thread);
				}
				List<Future<Integer>> resultList = threadPool.invokeAll(threadList);
				for (Future<Integer> future : resultList) {
					try {
						successCount += future.get();
					} catch (Exception e) {
						failCount++;
						logger.error(e.toString());
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (threadPool != null) {
				try {
					threadPool.shutdown();
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		Assert.assertTrue(instanceLength == successCount);
		Assert.assertTrue(0 == failCount);
	}
	
	public List<Myclass> getList() {
		List<Myclass> list = new LinkedList<Myclass>();
		for (int i = 0; i < instanceLength; ++i) {
			list.add(new Myclass(i));
		}
		return list;
	}
	
	private class Myclass {
		private int idx;

		public Myclass(int idx) {
			this.idx = idx;
		}
		
		@Override
		public String toString() {
			return String.valueOf(idx) + "번 째 인스턴스";
		}
	}
	
	private class Mythread implements Callable<Integer> {
		private Myclass var;

		public Mythread(Myclass myclass) {
			this.var = myclass;
		}

		@Override
		public Integer call() throws Exception {
			return runThread();
		} 
		
		public Integer runThread() {
			boolean success = true;
			
			// 두 썸띵
			logger.debug(String.valueOf(this.var));;
			
			if (success) {
				return 1; // 성공
			} 
			throw new RuntimeException(); // 패실
		}
		
	}
}