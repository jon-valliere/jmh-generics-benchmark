package bench;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Tests against a Type which has fully baked a Generic Abstract Method
 */
public class BakedGenericAbstractTest
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
		final AbstractType<BaseType> x = this.createCheckedReceiver();

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
		final AbstractType x = this.createUncheckedReceiver();

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

	protected ReceiverType createExplicitReceiver()
	{
		return new ReceiverType();
	}

	protected AbstractType<BaseType> createCheckedReceiver()
	{
		return new ReceiverType();
	}

	protected AbstractType createUncheckedReceiver()
	{
		return new ReceiverType();
	}

	static private class ReceiverType extends BakedType
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

	/**
	 * By adding a second abstract class in the inheritance, the
	 * performance drops by an order of magnitude.
	 */
	static private abstract class BakedType extends AbstractType<BaseType>
	{

	}

	static private abstract class AbstractType<X> extends BaseType
	{
		abstract public X foo(X value);
	}

	static private class BaseType
	{

	}
}