package bench.invoke;

import org.openjdk.jmh.annotations.Benchmark;

public class ExplicitGenericInterfaceTest
{
	@Benchmark
	public void testExplicit()
	{
		final ReceiverType x = this.createExplicitReceiver();

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
	public void testChecked()
	{
		final ReceiverInterface<BaseType> x = this.createCheckedReceiver();

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
		final ReceiverInterface x = this.createUncheckedReceiver();

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

	protected ReceiverInterface<BaseType> createCheckedReceiver()
	{
		return new ReceiverType();
	}

	protected ReceiverInterface createUncheckedReceiver()
	{
		return new ReceiverType();
	}

	protected ReceiverType createExplicitReceiver()
	{
		return new ReceiverType();
	}

	static private class ReceiverType extends BaseType implements ReceiverInterface<BaseType>
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

	static private interface ReceiverInterface<X>
	{
		X foo(X value);
	}

	static private class BaseType
	{
		public int id = 0;
	}
}