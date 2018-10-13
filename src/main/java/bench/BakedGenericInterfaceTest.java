package bench;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Tests against a Type which has fully baked a Generic Abstract Method
 */
public class BakedGenericInterfaceTest
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
		final AbstractInterface<BaseType> x = this.createCheckedReceiver();

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
		final AbstractInterface x = this.createUncheckedReceiver();

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
		final BakedInterface x = this.createBakedReceiver();

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

	protected AbstractInterface<BaseType> createCheckedReceiver()
	{
		return new ReceiverType();
	}

	protected AbstractInterface createUncheckedReceiver()
	{
		return new ReceiverType();
	}

	protected BakedInterface createBakedReceiver()
	{
		return new ReceiverType();
	}

	static private class ReceiverType extends BaseType implements BakedInterface
	{
		@Override
		public BaseType foo(final BaseType value)
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

	static private interface BakedInterface extends AbstractInterface<BaseType>
	{

	}

	static private interface AbstractInterface<X>
	{
		X foo(X value);
	}

	static private class BaseType
	{

	}
}