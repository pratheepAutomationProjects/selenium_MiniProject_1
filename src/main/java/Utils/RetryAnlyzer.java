package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnlyzer implements IRetryAnalyzer{
	int count=0;
	int retryTimes=1;
	@Override
	public boolean retry(ITestResult result) {
		
		while(count<retryTimes) {
			count++;
			return true;
			
		}
		// TODO Auto-generated method stub
		return false;
	}

}
