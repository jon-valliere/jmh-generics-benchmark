package bench.invoke;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Tests against a Type which has fully baked a Generic Abstract Method
 */
public class BakedGenericTypeTest
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
		final GenericType<BaseType> x = this.createCheckedReceiver();

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
		final GenericType x = this.createUncheckedReceiver();

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
	public void testBaked()
	{
		final BakedType x = this.createBakedReceiver();

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

	protected ReceiverType createExplicitReceiver()
	{
		return new ReceiverType();
	}

	protected GenericType<BaseType> createCheckedReceiver()
	{
		return new ReceiverType();
	}

	protected GenericType createUncheckedReceiver()
	{
		return new ReceiverType();
	}

	protected BakedType createBakedReceiver()
	{
		return new ReceiverType();
	}

	static private class ReceiverType extends BakedType
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

	/**
	 * By adding a second abstract class in the inheritance, the
	 * performance drops by an order of magnitude.
	 */
	static private class BakedType extends GenericType<BaseType>
	{

	}

	static private class GenericType<X> extends BaseType
	{
		public X foo(final X value)
		{
			return value;
		}
	}

	static private class BaseType
	{
		public int id = 0;
	}
}