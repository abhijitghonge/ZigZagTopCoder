package interview;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ubs.convertors.CurrencyConvertor;
import com.ubs.convertors.ICurrencyConvertor;
import com.ubs.data.CompanyDataBuilder;
import com.ubs.data.GroupKey;
import com.ubs.data.IDataBuilder;
import com.ubs.loader.DelimitedFileLoader;

import junit.framework.TestCase;

public class UBSInterviewTestSuite extends TestCase {

	private File simpleFilePath = new File("SIMPLE.DAT.txt");
	private String delimiter = "\\t";

	@Test
	public void testSimplePositive() {
		DelimitedFileLoader loader = new DelimitedFileLoader(simpleFilePath, delimiter);
		ICurrencyConvertor convertor = new CurrencyConvertor();
		IDataBuilder builder = new CompanyDataBuilder(loader);
		builder.setCurrencyConvertor(convertor);
		Map<GroupKey, BigDecimal> actual = builder.build();
		GroupKey key = new GroupKey("Atlanta", "USA", "AAA+");

		Map<GroupKey, BigDecimal> expected = new HashMap<GroupKey, BigDecimal>();
		expected.put(key, new BigDecimal("65484231.44"));
		assertEquals(actual, expected);

	}
}
