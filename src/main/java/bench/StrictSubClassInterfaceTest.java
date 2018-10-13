package bench;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Tests against a Typed Interface without Generics
 */
public class StrictSubClassInterfaceTest
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

	static public interface ReceiverInterface extends SuperInterface
	{

	}

	static private interface SuperInterface
	{
		BaseType foo(BaseType value);
	}

	static private class ReceiverType extends BaseType implements ReceiverInterface
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

	static private class BaseType
	{

	}
}