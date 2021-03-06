package bench.invoke;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Tests against a Typed Object without Generics
 */
public class StrictTypeTest
{
	@Benchmark
	public void testType()
	{
		final ReceiverType x = this.createReceiver();

		final BaseType y = this.createObject();

		BaseType z = null;

		for (int i = 0; i != 1_000_000; i++)
		{
			if (z == y)
			{
				z = x.foo(y);
			}
			else
			{
				z = x.foo(y);
			}
		}
	}

	protected BaseType createObject()
	{
		return new BaseType();
	}

	protected ReceiverType createReceiver()
	{
		return new ReceiverType();
	}

	static private class ReceiverType extends BaseType
	{
		public BaseType foo(final BaseType value)
		{
			if (value.id == this.id)
			{
				return value;
			}
			else
			{
				return value;
			}
		}
	}

	static private class BaseType
	{
		public int id = 0;
	}
}