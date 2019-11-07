package bench.invoke;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Tests against a Typed Interface without Generics
 */
public class StrictInterfaceTest
{
	@Benchmark
	public void testInterface()
	{
		final ReceiverInterface x = this.createInterface();

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

	protected ReceiverInterface createInterface()
	{
		return new ReceiverType();
	}

	static private interface ReceiverInterface
	{
		BaseType foo(BaseType value);
	}

	static private class ReceiverType extends BaseType implements ReceiverInterface
	{
		@Override
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