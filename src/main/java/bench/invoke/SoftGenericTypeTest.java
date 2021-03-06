package bench.invoke;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Tests against a standard generic class; similar to a collection
 */
public class SoftGenericTypeTest
{
	@Benchmark
	public void testChecked()
	{
		final ReceiverType<BaseType> x = this.createCheckedReceiver();

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

	@Benchmark
	public void testUnchecked()
	{
		final ReceiverType x = this.createUncheckedReceiver();

		final Object y = this.createObject();

		Object z = null;

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

	protected ReceiverType<BaseType> createCheckedReceiver()
	{
		return new ReceiverType<BaseType>();
	}

	protected ReceiverType createUncheckedReceiver()
	{
		return new ReceiverType<BaseType>();
	}

	static private class ReceiverType<X> extends BaseType
	{
		public X foo(final X value)
		{
			if (value == this)
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