package bench.invoke;

import org.openjdk.jmh.annotations.Benchmark;

public class ExtendsSubClassGenericInterfaceTest
{
	@Benchmark
	public void testExplicit()
	{
		final ReceiverType x = this.createExplicitReceiver();

		final SuperType y = this.createSuperObject();

		SuperType z = null;

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
		final ReceiverInterface<SuperType> x = this.createCheckedReceiver();

		final SuperType y = this.createSuperObject();

		SuperType z = null;

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

		final BaseType y = this.createBaseObject();

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

	protected BaseType createBaseObject()
	{
		return new SuperType();
	}

	protected SuperType createSuperObject()
	{
		return new SuperType();
	}

	protected ReceiverInterface<SuperType> createCheckedReceiver()
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

	static private class ReceiverType extends SuperType implements ReceiverInterface<SuperType>
	{
		@Override
		public SuperType foo(final SuperType value)
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

	static private interface ReceiverInterface<X extends BaseType>
	{
		X foo(X value);
	}

	static private class BaseType
	{
		public int id = 0;
	}

	static private class SuperType extends BaseType
	{

	}
}