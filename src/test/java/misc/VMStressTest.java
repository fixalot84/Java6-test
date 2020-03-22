package misc;

import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VMStressTest {
	private static final Logger logger = LoggerFactory.getLogger(VMStressTest.class);
	public static LocalDateTime current = LocalDateTime.now();

	public static void main(String[] args) {
		LocalDateTime begin = LocalDateTime.now();
		LocalDateTime end = begin.plusMinutes(30);
//		LocalDateTime end = begin.plusSeconds(10);

		Runner runner = new Runner();
		while (current.isBefore(end)) {
			refresh();
			try {
				runner.ticktack(current.getSecondOfMinute());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
//				logger.debug("에러 났네?");
			}
		}
		logger.info("끗");
	}

	private static void refresh() {
		current = LocalDateTime.now();
	}

	private static class Runner {
		private static final Logger logger = LoggerFactory.getLogger(VMStressTest.Runner.class);
		private int prevSec;

		public void ticktack(int currentSec) {
			if (currentSec != prevSec) {
				this.prevSec = currentSec;
				logger.debug("{}", currentSec);
			} else {
				int nan = 1 / 0;
			}
		}
	}
}
