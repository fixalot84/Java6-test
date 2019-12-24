package jdk.java.util.concurrent;

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
 * ThreadPool 테스트 유닛<br>
 * imall_batch에 있는 모냥과 거어어의 비슷.<br>
 * 
 * @since 2019-12-19
 * @author fixalot@lotte.net
 */
public class ThreadPoolTest {
	private static final Logger log = LoggerFactory.getLogger(ThreadPoolTest.class);

	private int instanceLength = 10;
	private int expectedSuccess = 5;
	private int expectedFails = 5;

	@Test
	public void test() {
		ExecutorService threadPool = null;
		Collection<Callable<Boolean>> threadList = null;
		int successCount = 0;
		int failCount = 0;
		int howManyThread = 10;
		try {
			List<Myclass> list = getList();
			if (list != null && list.size() > 0) {
				threadPool = Executors.newFixedThreadPool(howManyThread);
				threadList = new ArrayList<Callable<Boolean>>();
				for (int i = 0; i < list.size(); i++) {
					Mythread thread = new Mythread(list.get(i));
					threadList.add(thread);
				}
				List<Future<Boolean>> resultList = threadPool.invokeAll(threadList);
				for (Future<Boolean> future : resultList) {
					if (future.get()) {
						++successCount;
					} else {
						++failCount;
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (threadPool != null) {
				try {
					threadPool.shutdown();
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		Assert.assertTrue(expectedSuccess == successCount);
		Assert.assertTrue(expectedFails == failCount);
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

		public int getIdx() {
			return idx;
		}
	}

	private class Mythread implements Callable<Boolean> {
		private Myclass var;

		public Mythread(Myclass myclass) {
			this.var = myclass;
		}

		@Override
		public Boolean call() throws Exception {
//			return runThread();
			boolean success = true;

			// 두 썸띵
			log.debug(this.var.getIdx() + "번째 쓰레드");
			if (this.var.getIdx() % 2 == 0) { // 짝수면 true 반환
				return true;
			}
			return false;
		}
	}
}
