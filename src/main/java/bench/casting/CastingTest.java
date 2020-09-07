package bench.casting;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;

/**
 * Attempts to perf test Java Casting
 *
 * Note: Pretty sure the compiler is optimizing out the casting
 */
public class CastingTest
{
	static public class ClassA
	{
		public long		var1;
		public long		var2;
		public int		var3;
		public int		var4;

		public Object	var5;
		public Object	var6;
	}

	static public class ClassB extends ClassA
	{
		public Object	var7;

		public int		var8;
		public int		var9;
	}

	public void doSomethingA4(final ClassB t)
	{
		t.var1++;

		this.doSomethingB(t);
	}

	public void doSomethingA3(final ClassA t)
	{
		t.var1++;

		if (t instanceof ClassB)
		{
			this.doSomethingB((ClassB) t);
		}
	}

	public void doSomethingA2(final ClassA t)
	{
		t.var1++;

		this.doSomethingB(ClassB.class.cast(t));
	}

	public void doSomethingA1(final ClassA t)
	{
		t.var1++;

		this.doSomethingB((ClassB) t);
	}

	public void doSomethingB(final ClassB t)
	{
		t.var9++;
	}

	static final ClassA	x	= new ClassB();
	static final ClassB	y	= new ClassB();

	@Fork(value = 2)
	@Benchmark
	public void UnsafeSubCastTest()
	{
		for (int i = 0; i < 5000; i++)
		{
			this.doSomethingA1(CastingTest.x);
		}
	}

	@Fork(value = 2)
	@Benchmark
	public void SafeSubCastTest()
	{
		for (int i = 0; i < 5000; i++)
		{
			this.doSomethingA2(CastingTest.x);
		}
	}

	@Fork(value = 2)
	@Benchmark
	public void InstanceSubCastTest()
	{
		for (int i = 0; i < 5000; i++)
		{
			this.doSomethingA3(CastingTest.x);
		}
	}

	@Fork(value = 2)
	@Benchmark
	public void BaselineTest()
	{
		for (int i = 0; i < 5000; i++)
		{
			this.doSomethingA4(CastingTest.y);
		}
	}
}
