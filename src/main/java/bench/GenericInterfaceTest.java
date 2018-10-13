package bench;

import org.openjdk.jmh.annotations.Benchmark;

public class GenericInterfaceTest
{
	@Benchmark
	public void testCheckedType()
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
	public void testUncheckedType()
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

	@Benchmark
	public void testCheckedInterface()
	{
		final ReceiverInterface<BaseType> x = this.createCheckedInterface();

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
	public void testUncheckedInterface()
	{
		final ReceiverInterface x = this.createUncheckedInterface();

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

	protected ReceiverInterface<BaseType> createCheckedInterface()
	{
		return new ReceiverType<BaseType>();
	}

	protected ReceiverInterface createUncheckedInterface()
	{
		return new ReceiverType<BaseType>();
	}

	static private class ReceiverType<X> extends BaseType implements ReceiverInterface<X>
	{
		@Override
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

	static private interface ReceiverInterface<X>
	{
		X foo(X value);
	}

	static private class BaseType
	{

	}
}